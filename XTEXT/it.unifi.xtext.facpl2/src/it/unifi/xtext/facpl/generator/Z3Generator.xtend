package it.unifi.xtext.facpl.generator

import org.eclipse.xtext.generator.IFileSystemAccess
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.facpl2.PolicySet
import it.unifi.xtext.facpl.facpl2.Expression
import it.unifi.xtext.facpl.facpl2.Obligation
import java.util.List
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl
import it.unifi.xtext.facpl.facpl2.Rule
import it.unifi.xtext.facpl.validation.FacplType
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference
import it.unifi.xtext.facpl.validation.inference.SubstitutionSet
import it.unifi.xtext.facpl.generator.util.PolicyConstant
import it.unifi.xtext.facpl.generator.util.ConstraintConstant
import java.util.LinkedList
import it.unifi.xtext.facpl.generator.generators.Z3Generator_Functions
import it.unifi.xtext.facpl.facpl2.AndExpression
import it.unifi.xtext.facpl.facpl2.OrExpression
import it.unifi.xtext.facpl.facpl2.NotExpression
import it.unifi.xtext.facpl.facpl2.BooleanLiteral
import java.util.HashMap
import it.unifi.xtext.facpl.facpl2.AttributeName
import it.unifi.xtext.facpl.facpl2.IntLiteral
import it.unifi.xtext.facpl.facpl2.StringLiteral
import it.unifi.xtext.facpl.facpl2.TimeLiteral
import it.unifi.xtext.facpl.facpl2.DateLiteral
import it.unifi.xtext.facpl.facpl2.Bag
import it.unifi.xtext.facpl.facpl2.Function
import it.unifi.xtext.facpl.facpl2.funID
import it.unifi.xtext.facpl.facpl2.DoubleLiteral
import it.unifi.xtext.facpl.facpl2.Effect
import it.unifi.xtext.facpl.generator.generators.z3algorithms.Z3Generator_PermitOver
import it.unifi.xtext.facpl.generator.generators.z3algorithms.Z3Generator_DenyUnless
import it.unifi.xtext.facpl.generator.generators.z3algorithms.Z3Generator_PermitUnless
import it.unifi.xtext.facpl.generator.generators.z3algorithms.Z3Generator_DenyOver
import it.unifi.xtext.facpl.generator.generators.z3algorithms.Z3Generator_FirstApp
import it.unifi.xtext.facpl.generator.generators.z3algorithms.Z3Generator_OneApp
import it.unifi.xtext.facpl.generator.generators.z3algorithms.Z3Generator_WeakCon
import it.unifi.xtext.facpl.generator.generators.z3algorithms.Z3Generator_StrongCon

class Z3Generator {

	// Typing assertions for Attributes
	private SubstitutionSet attribute_Types;

	// Declared Constants
	private HashMap<String,ConstraintConstant> constants

	// String Enumerations
	private LinkedList<String> stringEls
	
	//TypeInference
	private FacplTypeInference tInf
	
	
	def void doGenerateFileZ3(Facpl resource, IFileSystemAccess fsa) throws Exception{

		// pol can only be a PolicySet
		fsa.generateFile("_full.smt2", doGenerateZ3(resource));

	}

	def String doGenerateZ3(Facpl resource) throws Exception{

		var StringBuffer str = new StringBuffer()

		/* Compiling Policies that are declared out from the brackets of the Main */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {

				/*
				 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				 */
				// CHECK INFERENCE TYPES
				tInf = new FacplTypeInference()
				var FacplType type = tInf.doSwitch(pol)

				if (type.equals(FacplType.ERR)) {
					throw new Exception("Policy " + pol.name + " is not well-typed");
				}

				this.attribute_Types = tInf.typeAssignments;

				// CALCULATE STRING AND ATTRIBUTE constants
				val PolicyConstant tConst = new PolicyConstant()

				tConst.doSwitch(pol)

				this.constants = tConst.constants 
				
				this.stringEls = new LinkedList<String>()
				for( el : this.constants.values){
					if (el.type.equals(FacplType.STRING)){
						//add string constants
						stringEls.add(el.value.toString)
					}
				}

				/*
				 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				 */
				str.append(createMainConstraint(pol))
			}
		}

		return str.toString
	}

/* ##############################################
 * General structure of the whole constraint file
 * ##############################################
 */
def createMainConstraint(PolicySet pol) '''
«getDatatypeDec(pol)»
«IF this.stringEls.size > 0»
;################### STRING DECLARATIONs #######################
«getStringDec()»
«ENDIF»
;################## BAG s

;?????????????????????????

;################### FUNCTION DECLARATIONs #######################
«getFunctionDec()»
;################################ END DATATYPEs AND FUNCTIONs DECLARATION #############################

;################### ATTRIBUTE DECLARATIONs #######################
«getAttributeDec()»
;################### CONSTANTs DECLARATIONs #######################
«getConstantDec()»
«««		Building constraint of internal element of the policy
«FOR el : pol.policies»
	«getPolicyConstr(el)»
«ENDFOR»
;################################ TOP-LEVEL POLICY «pol.name» CONSTRAINTs ###########################
«««	Creating the constraint of the policy set
;##### Policy Target
««« STEP 1 -> get constraint of the target
«IF pol.target != null»
	«getTargetConstr(pol.target,pol.name)»
«ELSE»
	«getTargetConstr_default(pol.name)»
«ENDIF»
«««	STEP 2 -> get constraint of Obligations
;##### Policy Obligations
«IF pol.obl != null»
	«getObligationConstr(pol.obl,pol.name)»
«ENDIF»
«««	STEP 3 -> get constraint of Combining Algorithm
;##### Policy Combining Algorithm
«getCombiningAlgorithmConstr(pol)»
«««	STEP 4 -> building up the four constraints modelling the policy
;##### Policy Final Constraints
«getFinalConstrPSet(pol.name)»
;################### END TOP-LEVEL POLICY «pol.name» CONSTRAINTs #########################
'''


/* ##############################################
 * Internal Rule/PolicySet 
 * ##############################################
 */
def getPolicyConstr(AbstractPolicyIncl pol) throws Exception {
	if (pol.refPol != null) {
		getInternalPolicyConstr(pol.refPol)
	} else if (pol.newPolicy != null) {
	//	Generate the constraint of the internal policy (rule or policy set)
		if (pol.newPolicy instanceof Rule) {
			getInternalPolicyConstr(pol.newPolicy as Rule)
		} else if (pol.newPolicy instanceof PolicySet) {
			getInternalPolicyConstr(pol.newPolicy as PolicySet)
		}
	}
}

/*
 *	POLICY SET AND RULE CONSTRAINTs 
 */
 
/**
 * RULE
 */ 
def dispatch getInternalPolicyConstr(Rule r) 
'''
;################### START CONSTRAINT RULE «r.name» #######################
«««	Creating the constraint of the rule
««« STEP 1 -> get constraint of the target
;##### Rule Target
	«IF r.target != null»
«getTargetConstr(r.target,r.name)»
	«ELSE»
«getTargetConstr_default(r.name)»
	«ENDIF»
«««	STEP 2 -> get constraint of Obligations
;##### Rule Obligations
«IF r.obl != null»
«getObligationConstr(r.obl,r.name)»
«ELSE»
«getObligationsConstr_Default(r.name)»
«ENDIF»
«««	STEP 3 -> building up the four constraints modelling the policy
;##### Rule Constraints
;PERMIT
(define-fun cns_«r.name»_permit () Bool
«IF r.effect.equals(Effect.DENY)» false 
«ELSE»
(and (isTrue cns_target_«r.name») cns_obl_permit_«r.name»)
«ENDIF»
)
;DENY
(define-fun cns_«r.name»_deny () Bool
«IF r.effect.equals(Effect.PERMIT)» false 
«ELSE»
(and (isTrue cns_target_«r.name») cns_obl_deny_«r.name»)
«ENDIF»
)
;NOT APP
(define-fun cns_«r.name»_notApp () Bool
	(or (isFalse cns_target_«r.name») (bot cns_target_«r.name»))
)
;INDET
(define-fun cns_«r.name»_indet () Bool
	(or 
		(err cns_target_«r.name»)
		(and 
			(isTrue cns_target_«r.name»)
			«IF r.effect.equals(Effect.PERMIT)»
			(not cns_obl_permit_«r.name»)
			«ELSE»
			(not cns_obl_deny_«r.name»)
			«ENDIF»
		)
	)
)
;################### END CONSTRAINT RULE «r.name» #########################
'''

/**
 * POLICY SET (internal)
 */
def dispatch getInternalPolicyConstr(PolicySet pol) 
'''
;################### START CONSTRAINT POLICY SET «pol.name» #######################
«««	Creating the constraint of the policy set
««« STEP 1 -> get constraint of the target
;##### Policy Target
	«IF pol.target != null»
«getTargetConstr(pol.target,pol.name)»
	«ELSE»
«getTargetConstr_default(pol.name)»
	«ENDIF»
«««	STEP 2 -> get constraint of Obligations
;##### Policy Obligations
	«IF pol.obl != null»
«getObligationConstr(pol.obl,pol.name)»
	«ELSE»
«getObligationsConstr_Default(pol.name)»
	«ENDIF»
«««	STEP 3 -> get constraint of Combining Algorithm
;##### Policy Combining Algorithm
«getCombiningAlgorithmConstr(pol)»
«««	STEP 4 -> building up the four constraints modelling the policy
;##### Policy Constraints
«getFinalConstrPSet(pol.name)»

;################### END CONSTRAINT POLICY SET «pol.name» #########################
'''
	/* ##############################################
	 * Combining Algorithm Constraint 
	 * ##############################################
	 */	
	def getCombiningAlgorithmConstr(PolicySet p) {
		switch p.polSetAlg.idAlg{
			case PERMIT_OVER : new Z3Generator_PermitOver().combine(p)
			case DENY_OVER : new Z3Generator_DenyOver().combine(p)
			case DENY_UNLESS : new Z3Generator_DenyUnless().combine(p)
			case PERMIT_UNLESS : new Z3Generator_PermitUnless().combine(p)
			case FIRST : new Z3Generator_FirstApp().combine(p) 
			case ONLY_ONE : new Z3Generator_OneApp().combine(p)
			case WEAK_CONS : new Z3Generator_WeakCon().combine(p)
			case STRONG_CONS : new Z3Generator_StrongCon().combine(p)
			 
			default: {
				
			}
		}
	}

def getFinalConstrPSet(String p_name)'''
;PERMIT
(define-fun cns_«p_name»_permit () Bool
	(and 
		(isTrue cns_target_«p_name»)
		cns_«p_name»_cmb_final_permit
		cns_obl_permit_«p_name»
	)
)
;DENY
(define-fun cns_«p_name»_deny () Bool
	(and 
		(isTrue cns_target_«p_name»)
		cns_«p_name»_cmb_final_deny
		cns_obl_deny_«p_name»
	)
)
;NOT APP
(define-fun cns_«p_name»_notApp () Bool
	(or
		(or (isFalse cns_target_«p_name») (bot cns_target_«p_name»))
		(and (isTrue cns_target_«p_name») cns_«p_name»_cmb_final_notApp)
	)
)
;INDET
(define-fun cns_«p_name»_indet () Bool
	(or 
		(err cns_target_«p_name»)
		(and (isTrue cns_target_«p_name») cns_«p_name»_cmb_final_indet)
		(and 
			(isTrue cns_target_«p_name»)
			cns_«p_name»_cmb_final_permit
			(not cns_obl_permit_«p_name»)
		)
		(and 
			(isTrue cns_target_«p_name»)
			cns_«p_name»_cmb_final_deny
			(not cns_obl_deny_«p_name»)
		)
	)
)
'''


	/* ##############################################
	 * Target Constraint 
	 * ##############################################
	 */
	def getTargetConstr(Expression e, String name) '''
		(define-fun cns_target_«name» () (TValue Bool)
			«getExpressionConst(e)»
		)
	'''
	def getTargetConstr_default(String name)'''
		(define-fun cns_target_«name» () (TValue Bool)	
			(mk-val true false false) 
		)
	'''

	/* ##############################################
	 * Obligation Constraint
	 * ##############################################
	 */
	def getObligationConstr(List<Obligation> obls, String name) '''
	«getObligationConstr_Eff(obls,name, Effect.PERMIT)»
	 
	«getObligationConstr_Eff(obls,name, Effect.DENY)»
	 
	'''
	
//	def getObligationConstr_Eff (List<Obligation> obls, String name, Effect ef)
//'''(define-fun cns_obl_«ef.toString»_«name» ()  Bool
//	«IF obls.size > 0»
//	(and 
//		«var i = 0»
//		«FOR o : obls»
//			«IF o.evaluetedOn.equals(ef)»
//				«i = i +1»
//				«IF o.expr.size > 0»
//				(and 
//				«FOR e : o.expr»
//						(not (bot «getExpressionConst(e)»))
//						(not (err «getExpressionConst(e)»))
//				«ENDFOR»
//				)
//				«ELSE»true«ENDIF»
//			«ENDIF»
//		«ENDFOR»
//		«IF i == 0»
//			true true
//		«ENDIF»
//	)«ELSE»true«ENDIF»)'''
		
	def getObligationConstr_Eff (List<Obligation> obls, String name, Effect ef){
		val StringBuffer str = new StringBuffer()
		str.append("(define-fun cns_obl_"+ef.toString +"_"+ name +" ()  Bool\n")
		if (obls.size > 0){
			str.append("\t (and ") 
			var i = 0
			for( o : obls){
			 	if (o.evaluetedOn.equals(ef)){
					i = i +1
					if (o.expr.size > 0){
						str.append("(and\n ") 
						for (e : o.expr){
								str.append("\t\t (not (bot"+ getExpressionConst(e)+"))")
								str.append("\t\t (not (err"+ getExpressionConst(e)+ "))")
						}
						str.append(")\n")
					}else{
						str.append("true")
					}
				}
			}
			if (i == 0){
				str.append("\t true true")
			}
		str.append(")")	
		}else {
			str.append("true\n")
		}
		str.append(")")
		return str.toString
	}
		
	def getObligationsConstr_Default(String name)'''
	(define-fun cns_obl_permit_«name» ()  Bool true )
	(define-fun cns_obl_deny_«name» ()  Bool true )
	'''


	/* ########################################################################
	 * Auxiliary Functions for Datatype, functions and attributes declarations 
	 * ########################################################################
	 */
	// TODO NB !!!!!!!!!! -> isValueBag da parametrizzare rispetto al tipo della funzione
	// Returning the record datatype, the bag and the auxiliary functions
	def getDatatypeDec(PolicySet pol) '''
	;#######################
	;RECORD DATATYPE with BOTTOM and ERROR
	;#######################
	(declare-datatypes (U) ((TValue (mk-val (val U)(bot Bool)(err Bool)))))
	
	;#######################
	;BAG of elements of type T with attached an integer index
	;#######################
	(define-sort Bag (T) (Array Int T)) '''

	// Defining the enumeration type modeling string -> definition of equality and/or function in  
	def getStringDec() 
	''' (declare-datatypes () ((String «FOR el: this.stringEls»s_«el» «ENDFOR»)))'''

	// Declaring Attributes used in the policy
	def getAttributeDec() '''«FOR att_name : this.attribute_Types.substitutions.keySet»
			(declare-const «getNameAttr(att_name)» (TValue «getType(this.attribute_Types.substitutions.get(att_name))»))
			(assert (not (and (bot «getNameAttr(att_name)») (err «getNameAttr(att_name)»))))
			 
		«ENDFOR»
	'''

	// Convention for attribute names
	def getNameAttr(String string) '''n_«string»'''

	def getConstAttr(String string) '''const_«string»'''

	// Types Name to be used in SMT constraint
	def getType(FacplType type) {
		if (type == null) {
			return "Bool"
		}
		switch type {
			case BOOLEAN: return "Bool"
			case DOUBLE: return "Real"
			case INT: return "Int"
			case STRING: return "String" // NB this type has to be declared!!!
			case NAME: return "Bool" // TO BE USED EVERYWHERE WHERE NOT DECLARED!!!!
			// Bag cases
			case BAG_BOOLEAN: return "(Bag Bool)"
			case BAG_INT: return "(Bag Int)"
			case BAG_DOUBLE: return "(Bag Real)"
			case BAG_NAME: return "(Bag Bool)" // TO BE USED EVERYWHERE WHERE NOT DECLARED!!!!
			case BAG_STRING: return "(Bag String)"
			// Not-Supported (?)
			case BAG_DATE: throw new Exception("DATE NOT SUPPORTED ????")
			case DATE: throw new Exception("DATE NOT SUPPORTED ????")
			case ERR: throw new Exception("Policy not well-typed")
		}
	}

	// Constants used in Expressions + Obligations
	def getConstantDec() '''«FOR cst : this.constants.values»
			(declare-const «getConstAttr(cst.att_name)» (TValue «getType(cst.type)»))
			«IF cst.type.equals(FacplType.STRING)»
			(assert (= (val «getConstAttr(cst.att_name)») s_«cst.value»))
			«ELSE»
			(assert (= (val «getConstAttr(cst.att_name)») «cst.value»))
			«ENDIF»
			(assert (not (bot «getConstAttr(cst.att_name)»))) 
			(assert (not (err «getConstAttr(cst.att_name)»))) 
			 
		«ENDFOR»
	'''

	// Constraint Function modeling FACPL
	def getFunctionDec() '''
	«Z3Generator_Functions::getBoolFunctions()»
	«Z3Generator_Functions::getEqualityFunctions()»
	«IF this.stringEls.size > 0»
	
	(define-fun isValString ((x (TValue String))) Bool
		(ite (and (not (bot x)) (not (err x))) true false)
	)

	(define-fun «funID.EQUAL.toString»String ((x (TValue String)) (y (TValue String))) (TValue Bool)
		(ite (and (isValString x) (isValString y))
			(ite (= (val x) (val y))
				(mk-val true false false)
				(mk-val false false false)
			)
			(ite (or (err x) (err y))
				(mk-val false false true)
				(mk-val false true false)
			)
		)
	)
	
	«ENDIF»	
	«Z3Generator_Functions::getIntFunctions()»
	«Z3Generator_Functions::getRealFunctions()»
	'''
	
	//EXPRESSION 
	
	def dispatch String getExpressionConst(AndExpression e)
	'''(FAnd «getExpressionConst(e.left)» «getExpressionConst(e.right)»)'''
	
	def dispatch String getExpressionConst(OrExpression e)
	'''(FOr «getExpressionConst(e.left)» «getExpressionConst(e.right)»)'''
	
	def dispatch String getExpressionConst(NotExpression e)
	'''(FNot «getExpressionConst(e.arg)»)'''
	
	//Attribute_Name
	def dispatch String getExpressionConst (AttributeName e)
	'''«getNameAttr(SubstitutionSet::_nameToString(e))»'''
	
	//Function
	def dispatch String getExpressionConst (Function f)
	'''(«getFunctionName(f)» «getExpressionConst(f.arg1)» «getExpressionConst(f.arg2)»)'''
	
	
	def getFunctionName(Function function) {
		var type1 = tInf.doSwitch(function.arg1)
		var type2 = tInf.doSwitch(function.arg2)
		//If any of the type is NAME look for type inference constraint
		if (type1.equals(FacplType.NAME)){
			//i.e. arg1 is an attribute name
			type1 = this.attribute_Types.getBound(function.arg1 as AttributeName)
		}
		if (type2.equals(FacplType.NAME)){
			//i.e. arg1 is an attribute name
			type2 = this.attribute_Types.getBound(function.arg2 as AttributeName)
		}
		//combine the types and if there is no constraints on the NAME type assign it to BOOLEAN
		var typeF = FacplType.combine(type1,type2)
		if (typeF == null){
			typeF = FacplType.BOOLEAN
		}
		
		if (function.functionId.equals(funID.IN)){
			throw new Exception("BAG TODO")
		}else{
			return getId(function.functionId.toString)+getType(typeF)
		}
	}
	
	def getId(String s){
		return s.replace('-','')
	}
	
	//Literal 
	def dispatch String getExpressionConst (BooleanLiteral e)
	'''«getConstAttr(e.value.toString)»''' 
	
	def dispatch String getExpressionConst (IntLiteral e)
	'''«getConstAttr(e.value.toString)»''' 
	
	def dispatch String getExpressionConst (DoubleLiteral e)
	'''«getConstAttr(e.value.toString)»''' 
	
	def dispatch String getExpressionConst (StringLiteral e)
	'''«getConstAttr(e.value.toString)»''' 
	
	//TODO
	
	def dispatch String getExpressionConst (Bag e){
			throw new Exception ("NOT SUPPORTED")
	}
	
	def dispatch String getExpressionConst (DateLiteral e){
		throw new Exception ("NOT SUPPORTED")
	}
	
	def dispatch String getExpressionConst (TimeLiteral e){
		throw new Exception ("NOT SUPPORTED")
	}
}