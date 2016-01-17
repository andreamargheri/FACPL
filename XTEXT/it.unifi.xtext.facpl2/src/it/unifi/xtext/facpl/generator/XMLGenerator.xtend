package it.unifi.xtext.facpl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.common.util.URI
import it.unifi.xtext.facpl.generator.util.TargetTree
import it.unifi.xtext.facpl.generator.util.Connector
import it.unifi.xtext.facpl.validation.FacplType
import java.util.UUID
import java.util.Calendar
import java.text.SimpleDateFormat

import org.eclipse.emf.common.util.EList
import java.util.HashMap
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.facpl2.FacplPolicy
import it.unifi.xtext.facpl.facpl2.PolicySet
import it.unifi.xtext.facpl.facpl2.Expression
import it.unifi.xtext.facpl.facpl2.AndExpression
import it.unifi.xtext.facpl.facpl2.OrExpression
import it.unifi.xtext.facpl.facpl2.NotExpression
import it.unifi.xtext.facpl.facpl2.Obligation
import it.unifi.xtext.facpl.facpl2.Alg
import it.unifi.xtext.facpl.facpl2.Rule
import it.unifi.xtext.facpl.facpl2.BooleanLiteral
import it.unifi.xtext.facpl.facpl2.StringLiteral
import it.unifi.xtext.facpl.facpl2.DoubleLiteral
import it.unifi.xtext.facpl.facpl2.IntLiteral
import it.unifi.xtext.facpl.facpl2.Function
import it.unifi.xtext.facpl.facpl2.Set
import it.unifi.xtext.facpl.facpl2.AttributeName
import it.unifi.xtext.facpl.facpl2.DateLiteral
import it.unifi.xtext.facpl.facpl2.TimeLiteral
import it.unifi.xtext.facpl.facpl2.Request

/**
 * Xtend Generator for creating the XACML policies and/or requests corresponding to the FACPL code given as input
 */
class XMLGenerator {

	static var URI path;
	static var StringBuffer projectPath;
	static var HashMap<String, Function> targetExp = new HashMap<String, Function>();

	static var FacplTypeInference tInf;

	private static var String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

	new() {
		it.unifi.xtext.facpl.generator.XMLGenerator.tInf = new FacplTypeInference
	}

	def private static String now() {
		var Calendar cal = Calendar::getInstance();
		var SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}

	/**
	 * XACML Code generation
	 */
	def void doGenerateFileXACML(Resource resource, IFileSystemAccess fsa) throws Exception{

		for (e : resource.contents.filter(typeof(Facpl))) {
			path = resource.URI
			projectPath = new StringBuffer()
			var count = 1
			for (f : path.segmentsList) {
				if (count != 1) {
					if (count != path.segmentsList.size) {
						projectPath.append(f + "/")
					}
				}
				count = count + 1
			}
			if (e.requests != null) {
				for (r : e.requests) {

					// request
					fsa.generateFile("ContextRequest_" + r.name + ".xml", doGenerateXACML(r))
				}
			}

			// Compiling Policy and PolicySet within the Main
			if (e.main != null) {
				if (e.main.paf != null) {
					for (pol : e.main.paf.pdp.polSet) {
						if (pol.newPolicy != null) {
							fsa.generateFile((pol.newPolicy as FacplPolicy).name + ".xml",
								doGenerateXACML(pol.newPolicy))
						} else if (pol.refPol != null) {
							fsa.generateFile(pol.refPol.name + ".xml", doGenerateXACML(pol.refPol))
						}
					}
				}
			}
			// Compiling the Policies Outside the main
			if (e.policies != null) {
				for (pol : e.policies) {
					fsa.generateFile(pol.name + ".xml", doGenerateXACML(pol))
				}
			}
		}
	}

	/**
	 * COMMANDS for interaction with ECLIPSE MENU -> Policies
	 */
	 def void doGenerateFileXACML_Pol (PolicySet p,IFileSystemAccess fsa){
	 	fsa.generateFile(p.name + ".xml", doGenerateXACML(p))
	 }
	 
	 /**
	 * COMMANDS for interaction with ECLIPSE MENU -> Requests
	 */

	def void doGenerateFileXACML_Req(Request r,IFileSystemAccess fsa) {
		fsa.generateFile("ContextRequest_" + r.name + ".xml", doGenerateXACML(r))
	}

	/**
	 * XACML Code generation -> STUB FOR TESTs
	 */
	def String doGenerateXACML_StubTest(Facpl res) throws Exception{

		// Requests
		if (res.requests != null) {
			for (r : res.requests) {
				return doGenerateXACML(r).toString
			}
		}

		// Compiling Policy and PolicySet within the Main
		if (res.main != null) {
			if (res.main.paf != null) {
				for (pol : res.main.paf.pdp.polSet) {
					if (pol.newPolicy != null) {
						return doGenerateXACML(pol.newPolicy).toString
					} else if (pol.refPol != null) {
						return doGenerateXACML(pol.refPol).toString
					}
				}
			}
		}
		// Compiling the Policies Outside the main
		if (res.policies != null) {
			for (pol : res.policies) {
				return doGenerateXACML(pol).toString
			}
		}
	}

	/**
	 * Call Translation
	 */
	def doGenerateXACML(Object res) {
		if (res instanceof Request) {
			return compileReq(res)
		} else if (res instanceof FacplPolicy) {
			return compilePol(res)
		}
	}

	/**
	 * External PolicySet (prologue needed)
	 */
	def dispatch CharSequence compilePol(PolicySet policy) '''
		<!-- New document created with Xtend2 by Eclipse Plugin at «now» -->
		<PolicySet xmlns="urn:oasis:names:tc:xacml:3.0:core:schema:wd-17"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="urn:oasis:names:tc:xacml:3.0:core:schema:wd-17
			http://docs.oasis-open.org/xacml/3.0/xacml-core-v3-schema-wd-17.xsd"
		PolicySetId="«policy.name»"
		Version="1.0"
		PolicyCombiningAlgId="«getAlg(policy.polSetAlg, policy)»"
		MaxDelegationDepth="1">
		«IF policy.target != null»
			«policy.target.compileExpressionTarget»
		«ELSE»
			<Target/>
		«ENDIF»
		«FOR pol : policy.policies»
			«IF pol.refPol != null»
				<PolicySetIdReference>
					«pol.refPol.name»
				</PolicySetIdReference>
			«ELSE»
				«pol.newPolicy.compileIntPol»
			«ENDIF» 
		«ENDFOR»
		«IF policy.obl.size() != 0»
			«compileAdvObl(policy.obl)»
		«ENDIF»
		</PolicySet>
	'''

	def dispatch compilePol(Rule rule) '''
	<!-- New document created with Xtend2 by Eclipse Plugin at «now» -->
	<Policy xmlns="urn:oasis:names:tc:xacml:3.0:core:schema:wd-17"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="urn:oasis:names:tc:xacml:3.0:core:schema:wd-17
		http://docs.oasis-open.org/xacml/3.0/xacml-core-v3-schema-wd-17.xsd"
	PolicyId="PolicyEnclosingRule«rule.name»"
	Version="1.0"
	RuleCombiningAlgId="urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-overrides"
	MaxDelegationDepth="1">
		<Target/>
		«compileIntPol(rule)»
	</Policy>
	'''
	
	// ------------------------------------------------
	// OBLIGATION / ADVICE -> ENTRY POINT
	// ------------------------------------------------
	def compileAdvObl(EList<Obligation> list) {
		var Boolean flag = false
		var StringBuffer s = new StringBuffer()
		for (obl : list) {
			if (obl.typeObl.equals("M")) {
				if (!flag) {
					s.append("<ObligationExpressions>\n")
					flag = true
				}
				s.append(obl.compileObl)
			}
		}
		if (flag) {
			s.append("</ObligationExpressions>\n")
		}
		flag = false
		for (obl : list) {
			if (obl.typeObl.equals("O")) {
				if (!flag) {
					s.append("<AdviceExpressions>\n")
					flag = true
				}
				s.append(obl.compileAdv)
			}
		}
		if (flag) {
			s.append("</AdviceExpressions>\n")
		}
		return s.toString
	}

	// ----------------------------------------------------------------------
	// OBGALITION - basic element
	// ----------------------------------------------------------------------
	def compileObl(Obligation obl) '''
		<ObligationExpression ObligationId="«obl.pepAction»" FulfillOn="«obl.evaluetedOn.toString.toFirstUpper»">
			«FOR o : obl.expr»
				<AttributeAssignmentExpression AttributeId="urn:oasis:names:tc:xaml:3.0:argument">
				«o.getExpression»
				</AttributeAssignmentExpression>
			«ENDFOR»
		</ObligationExpression>
	'''

	// ----------------------------------------------------------------------
	// ADVICE - basic element
	// ----------------------------------------------------------------------
	def compileAdv(Obligation obl) '''
		<AdviceExpression AdviceId="«obl.pepAction»" AppliesTo="«obl.evaluetedOn.toString.toFirstUpper»">
			«FOR o : obl.expr»
				<AttributeAssignmentExpression AttributeId="urn:oasis:names:tc:xaml:3.0:argument">
				«o.getExpression»
				</AttributeAssignmentExpression>
			«ENDFOR»
		</AdviceExpression>
	'''

	// ----------------------------------------------------------------------
	// POLICY and POLICY SET - enclosed in other element (not to generate file's header)
	// ----------------------------------------------------------------------
	def dispatch CharSequence compileIntPol(PolicySet policy) '''
		<PolicySet PolicySetId="«policy.name»" Version="1.0"
		PolicyCombiningAlgId="«getAlg(policy.polSetAlg, policy)»" >
		«IF policy.target != null»
			«policy.target.compileExpressionTarget»
		«ELSE»
			<Target/>
		«ENDIF»
		«FOR p : policy.policies»
			«IF p.refPol != null»
				<PolicySetIdReference>
				«p.refPol.name»
				</PolicySetIdReference>
			«ELSE»
				«p.newPolicy.compileIntPol»
			«ENDIF» 
		«ENDFOR»
		«IF policy.obl.size() != 0»
			«compileAdvObl(policy.obl)»
		«ENDIF»
		</PolicySet>
	'''

	// ----------------------------------------------------------------------
	// RULE
	// ----------------------------------------------------------------------
	def dispatch compileIntPol(Rule rule) '''
	<Policy 
		PolicyId="PolicyEnclosingRule«rule.name»"
		Version="1.0"
		RuleCombiningAlgId="urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-overrides"
		MaxDelegationDepth="1">
		<Target/>
		<Rule RuleId="«rule.name»" Effect="«rule.effect.toString.toFirstUpper»">
			<Target/>
			«IF rule.target != null»
				<Condition>«getExpression(rule.target)»</Condition>
			«ELSE»
			«ENDIF»
			«IF rule.obl.size() != 0»
			«compileAdvObl(rule.obl)»
			«ENDIF»
		</Rule>
	</Policy>
	'''

// -----------------------------------------------
	// TARGET
	// ------------------------------------------------
	// re-organization of target expressions
	def compileExpressionTarget(Expression expression) {
		if (expression == null) {
			return "<Target/>"
		}
		var exp = expression.createTargetTree

		// validate targetTree
		exp = xtendUtil::refactorTargetTree(exp)
		return "<Target>\n" + createTargetXML(exp, null, false) + "</Target>"
	}

	// translate to XML
	def CharSequence createTargetXML(TargetTree tree, Connector dad, Boolean isMatchSequence) '''
		«IF tree.root != null»
			«IF tree.root instanceof Connector»
				«FOR el : tree.child»
					«getXMLElementS(tree.root as Connector, dad)»
					«IF dad != null && dad.equals(Connector::OR)»
						«createTargetXML(el, tree.root as Connector, true)»
					«ELSE»
						«createTargetXML(el, tree.root as Connector, false)»
					«ENDIF»
					«getXMLElementE(tree.root as Connector, dad)»
				«ENDFOR»
			«ELSE»
				«getOpenSequenceElements(dad, isMatchSequence)»
				«getTargetFunction(tree.root as String)»
				«getCloseSequenceElements(dad, isMatchSequence)»
			«ENDIF»
		«ENDIF»
	'''

	def getXMLElementS(Connector connector, Connector dad) {
		switch connector {
			case Connector::AND:
				if (dad == null) {
					return "<AnyOf>"
				} else {
					return ""
				}
			case Connector::OR:
				return "<AllOf>"
		}
	}

	def getXMLElementE(Connector connector, Connector dad) {
		switch connector {
			case Connector::AND:
				if (dad == null) {
					return "</AnyOf>"
				} else {
					return ""
				}
			case Connector::OR:
				return "</AllOf>"
		}
	}

	def getOpenSequenceElements(Connector connector, Boolean isMatchSequence) {
		if (connector == null) {
			return "<AnyOf> \n \t <AllOf> \n \t\t "
		}
		if (connector == Connector::AND && !isMatchSequence) {
			return "<AllOf> \n \t\t "
		}
	}

	def getCloseSequenceElements(Connector connector, Boolean isMatchSequence) {
		if (connector == null) {
			return "</AllOf> \n \t </AnyOf> \n \t\t "
		}
		if (connector == Connector::AND && !isMatchSequence) {
			return "</AllOf> \n \t\t "
		}
	}

	// translate function
	def getTargetFunction(String string) {

		// get targetBase from hashMap targetExpr
		var Function exp = targetExp.remove(string)
		var StringBuffer target = new StringBuffer();

		target.append('<Match MatchId="' + getFunctionId(exp.functionId.toString, FacplType.combine(tInf.doSwitch(exp.arg1),tInf.doSwitch(exp.arg2))) + '">\n')
		target.append(getExpression(exp.arg1))
		target.append(getExpression(exp.arg2))
//		target.append(
//			'<AttributeDesignator DataType="http://www.w3.org/2001/XMLSchema#anyURI" MustBePresent="false"\n' +
//				'Category="' + getCategoryId(exp.structName.category) + '" AttributeId="' +
//				getAttributeId(exp.structName) + '" />')
		target.append("</Match>")
		return target.toString
	}

	// --------------------------------------------------------------------
	// TARGET: create target tree
	// --------------------------------------------------------------------
	def dispatch TargetTree createTargetTree(AndExpression exp) {
		return new TargetTree(Connector.AND, exp.left.createTargetTree, exp.right.createTargetTree)
	}

	def dispatch TargetTree createTargetTree(OrExpression exp) {
		return new TargetTree(Connector.OR, exp.left.createTargetTree, exp.right.createTargetTree)
	}

	// TODO -> Supported by XACML policies? 
	def dispatch TargetTree createTargetTree(NotExpression exp) {
		return new TargetTree(Connector.NOT, exp.arg.createTargetTree)
	}

	def dispatch TargetTree createTargetTree(Function target) {
		var r = new TargetTree(target.createAtomTarget)
		return r
	}

	//Internal method for numbering atom 
	def createAtomTarget(Function target) {
		var String id = UUID::randomUUID().toString
		targetExp.put(id, target)
		return id
	}
	
	

	def Connector compileOP(String string) {
		switch string {
			case "&&":
				return Connector::AND
			case "||":
				return Connector::OR
			case "!":
				return Connector::NOT
		}
	}

	// -----------------------------------------------------------------	
	// EXPRESSIONs
	// -----------------------------------------------------------------
	def dispatch getExpression (AndExpression e)'''
		<Apply FunctionId="urn:oasis:names:tc:xacml:1.0:function:and">
				«getExpression(e.left)»
				«getExpression(e.right)»
		</Apply>
	'''	
		
	def dispatch getExpression (OrExpression e)'''
		<Apply FunctionId="urn:oasis:names:tc:xacml:1.0:function:or">
				«getExpression(e.left)»
				«getExpression(e.right)»
		</Apply>
	'''		
	
	def dispatch getExpression (NotExpression e)'''
		<Apply FunctionId="urn:oasis:names:tc:xacml:1.0:function:not">
				«getExpression(e.arg)»
		</Apply>
	'''	
		
	def dispatch getExpression(Function f) '''
		<Apply FunctionId="«getFunctionId(f.functionId.toString, FacplType.combine(tInf.doSwitch(f.arg1),tInf.doSwitch(f.arg2)))»">
			«getExpression(f.arg1)»
			«getExpression(f.arg2)»
		</Apply>
	'''
	// literal value
	def dispatch getExpression(IntLiteral e) '''
		<AttributeValue DataType="«getDataType(e)»">
		«e.value»
		</AttributeValue>
	'''

	def dispatch getExpression(DoubleLiteral e) '''
		<AttributeValue DataType="«getDataType(e)»">
		«e.value»
		</AttributeValue>
	'''

	def dispatch getExpression(StringLiteral e) '''
		<AttributeValue DataType="«getDataType(e)»">
		«e.value»
		</AttributeValue>
	'''

	def dispatch getExpression(BooleanLiteral e) '''
		<AttributeValue DataType="«getDataType(e)»">
		«e.value»
		</AttributeValue>
	'''

	def dispatch getExpression(DateLiteral e) '''
		<AttributeValue DataType="«getDataType(e)»">
		«e.value»
		</AttributeValue>
	'''

	def dispatch getExpression(AttributeName name) '''
		<AttributeDesignator 
		DataType="http://www.w3.org/2001/XMLSchema#anyURI" MustBePresent="false" 
		Category="«getCategoryId(name.category)»" 
		AttributeId="«getAttributeId(name)»"/>
	'''

	def dispatch getExpression(Set item) '''
		<Apply FunctionId="urn:oasis:names:tc:xacml:1.0:function:anyuri-bag">
			«FOR i : item.args»
				«getExpression(i)»
			«ENDFOR»
		</Apply>
	'''

	// dataType Id
	def dispatch getDataType(IntLiteral exp) {
		return "http://www.w3.org/2001/XMLSchema#integer"
	}

	def dispatch getDataType(DoubleLiteral exp) {
		return "http://www.w3.org/2001/XMLSchema#double"
	}

	def dispatch getDataType(BooleanLiteral exp) {
		return "http://www.w3.org/2001/XMLSchema#boolean"
	}

	def dispatch getDataType(StringLiteral exp) {
		return "http://www.w3.org/2001/XMLSchema#string"
	}

	def dispatch getDataType(DateLiteral exp) {
		return "http://www.w3.org/2001/XMLSchema#date"
	}

	def dispatch getDataType(TimeLiteral exp) {
		return "http://www.w3.org/2001/XMLSchema#date"
	}

	// -----------------------------------------------------------------	
	// FUNCTION ID
	// -----------------------------------------------------------------	
	def getFunctionId(String id, FacplType type) {

		// equal-function
		if (id.equals("equal")) {
			if (type.equals(FacplType::BOOLEAN)) {
				return "urn:oasis:names:tc:xacml:1.0:function:boolean-equal"
			}
			if (type.equals(FacplType::STRING)) {
				return "urn:oasis:names:tc:xacml:1.0:function:string-equal"
			}
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-equal"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-equal"
			}
			if (type.equals(FacplType::DATETIME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:dateTime-equal"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:anyURI-equal"
			}
		} else 	if (id.equals("not-equal")) {
			if (type.equals(FacplType::BOOLEAN)) {
				return "urn:oasis:names:tc:xacml:1.0:function:boolean-not-equal"
			}
			if (type.equals(FacplType::STRING)) {
				return "urn:oasis:names:tc:xacml:1.0:function:string-not-equal"
			}
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-not-equal"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-not-equal"
			}
			if (type.equals(FacplType::DATETIME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:dateTime-not-equal"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:anyURI-not-equal"
			}
		} else	if (id.equals("less-than")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-less-than"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-less-than"
			}
			if (type.equals(FacplType::DATETIME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:dateTime-less-than"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-less-than"
			}
		}else if (id.equals("less-than-or-equal")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-less-than-or-equal"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-less-than-or-equal"
			}
			if (type.equals(FacplType::DATETIME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:dateTime-less-than-or-equal"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-less-than-or-equal"
			}
		} else if (id.equals("greater-than")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-greater-than"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-greater-than"
			}
			if (type.equals(FacplType::DATETIME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:dateTime-greater-than"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-greater-than"
			}
		} else 	if (id.equals("greater-than-or-equal")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-greater-than-or-equal"
			}
			if (type.equals(FacplType::DATETIME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:dateTime-greater-than-or-equal"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal"
			}
		}else if (id.equals("in")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:int-subset"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-subset"
			}
			if (type.equals(FacplType::STRING)) {
				return "urn:oasis:names:tc:xacml:1.0:function:string-subset"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:anyURI-subset"
			}
		}

		// arithmetic function
		if (id.equals("add")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-add"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-add"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-add"
			}
		}
		if (id.equals("subtract")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-subtract"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-subtract"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-subtract"
			}
		}
		if (id.equals("multiply")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-multiply"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-multiply"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-multiply"
			}
		}
		if (id.equals("divide")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-divide"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-divide"
			}
			if (type.equals(FacplType::NAME)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-divide"
			}
		}
		if (id.equals("abs")) {
			if (type.equals(FacplType::INT)) {
				return "urn:oasis:names:tc:xacml:1.0:function:integer-abs"
			}
			if (type.equals(FacplType::DOUBLE)) {
				return "urn:oasis:names:tc:xacml:1.0:function:double-abs"
			}
		}
		if (id.equals("mod")) {
			return "urn:oasis:names:tc:xacml:1.0:function:integer-mod"
		}
	}

	// -----------------------------------------------------------------	
	// REQUEST
	// -----------------------------------------------------------------
	def CharSequence compileReq(Request request) '''
		<!-- New document created with Xtend2 by Eclipse Plugin at «now» -->
		<Request xmlns="urn:oasis:names:tc:xacml:3.0:core:schema:wd-17"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="urn:oasis:names:tc:xacml:3.0:core:schema:wd-17
				http://docs.oasis-open.org/xacml/3.0/xacml-core-v3-schema-wd-17.xsd"
			ReturnPolicyIdList="false" CombinedDecision="false">
		«FOR category : xtendUtil::getCategories(request)»
			<Attributes
				Category="«getCategoryId(category)»">
				«FOR at : request.attributes»
					«IF at.name.category.equals(category)»
						<Attribute IncludeInResult="false"
						AttributeId="«getAttributeId(at.name)»">
						«FOR e : at.value»
							«e.getExpression»
						«ENDFOR»
						</Attribute>
					«ENDIF»
			«ENDFOR»
			</Attributes>
		«ENDFOR»
		</Request>
	'''

	// category Attributes ID
	def getCategoryId(String string) {
		var String id
		switch string {
			case 'subject': id = "urn:oasis:names:tc:xacml:3.0:attribute-category:subject"
			case 'action': id = "urn:oasis:names:tc:xacml:3.0:attribute-category:action"
			case 'environment': id = "urn:oasis:names:tc:xacml:3.0:attribute-category:environment"
			case 'resource': id = "urn:oasis:names:tc:xacml:3.0:attribute-category:resource"
			default: id = "urn:oasis:names:tc:xacml:3.0:attribute-category:" + string
		}
		return id
	}

	// Attribute Id for <Attribute>	
	def getAttributeId(AttributeName literal) {
		var StringBuffer id = new StringBuffer()
		switch literal.category {
			case 'subject': id.append("urn:oasis:names:tc:xacml:1.0:subject:")
			case 'resource': id.append("urn:oasis:names:tc:xacml:1.0:resource:")
			case 'action': id.append("urn:oasis:names:tc:xacml:1.0:action:")
			case 'environment': id.append("urn:oasis:names:tc:xacml:1.0:environment:")
			default: id.append("urn:oasis:names:tc:xacml:3.0:" + literal.category + ":")
		}
		id.append(literal.id)
		return id.toString
	}

	// ----------------------------------------------------------------------
	// COMBINING ALGORITHM
	// ----------------------------------------------------------------------
	def getAlg(Alg alg, FacplPolicy pol) {
		if (alg.idAlg.getName.toString.equals("DENY_OVER")) {
			return "urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:deny-overrides"
		}
		if (alg.idAlg.getName.toString.equals("PERMIT_OVER")) {
			return "urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-overrides"
		}
		if (alg.idAlg.getName.toString.equals("FIRST")) {
			return "urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:first-applicable"
		}
		if (alg.idAlg.getName.toString.equals("DENY_UNLESS")) {
			return "urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:deny-unless-permit"
		}
		if (alg.idAlg.getName.toString.equals("PERMIT_UNLESS")) {
			return "urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-unless-deny"
		}
		if (alg.idAlg.getName.toString.equals("ONLY_ONE")) {
			return "urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:only-one-applicable"
		}

		// user algorithm or consensus
		return "urn:names:policy-combining-algorithm:personal-algorithm"
//		}
	}

}
