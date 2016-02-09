package it.unifi.xtext.facpl.generator

import com.google.inject.Injector
import it.unifi.xtext.facpl.Facpl2StandaloneSetup
import it.unifi.xtext.facpl.facpl2.Alg
import it.unifi.xtext.facpl.facpl2.AlgLiteral
import it.unifi.xtext.facpl.facpl2.AndExpression
import it.unifi.xtext.facpl.facpl2.AttributeName
import it.unifi.xtext.facpl.facpl2.BooleanLiteral
import it.unifi.xtext.facpl.facpl2.DateLiteral
import it.unifi.xtext.facpl.facpl2.DeclaredFunction
import it.unifi.xtext.facpl.facpl2.DoubleLiteral
import it.unifi.xtext.facpl.facpl2.Expression
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.facpl2.FulfillmentStrategy
import it.unifi.xtext.facpl.facpl2.Function
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration
import it.unifi.xtext.facpl.facpl2.Import
import it.unifi.xtext.facpl.facpl2.IntLiteral
import it.unifi.xtext.facpl.facpl2.MainFacpl
import it.unifi.xtext.facpl.facpl2.NotExpression
import it.unifi.xtext.facpl.facpl2.Obligation
import it.unifi.xtext.facpl.facpl2.OrExpression
import it.unifi.xtext.facpl.facpl2.PolicySet
import it.unifi.xtext.facpl.facpl2.Request
import it.unifi.xtext.facpl.facpl2.Rule
import it.unifi.xtext.facpl.facpl2.Set
import it.unifi.xtext.facpl.facpl2.StringLiteral
import it.unifi.xtext.facpl.facpl2.TimeLiteral
import it.unifi.xtext.facpl.generator.generators.Facpl2Generator_Name
import it.unifi.xtext.facpl.validation.FacplType
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.resource.XtextResourceSet

class Facpl2Generator implements IGenerator {
	
	protected var String packageFolder=""; 
	protected var String packageName="";
	
	static protected var URI path; 
	static protected var StringBuffer projectPath;
	static protected var String personalAlg ="CustomCombingAlg"
	  
	override void doGenerate(Resource resource, IFileSystemAccess fsa){
				
		for(e: resource.contents.filter(typeof(Facpl))) {
			//creating project path for compiling the imported files
			path = resource.URI
			projectPath = new StringBuffer()
			var count =1
			for (f : path.segmentsList){
				if (count != 1){
					if (count != path.segmentsList.size){
						projectPath.append(f+"/")
					}
				} 
				count = count+1
			}
			
			/* Generating Package */
			if (e.getMain != null){
				if (e.main.genPackage != null && e.main.genPackage != "" ){
					var name = e.getMain.genPackage
					if (name.charAt(name.length-1) == "/"){
						packageFolder = e.getMain.genPackage
					}else{
						packageFolder = e.getMain.genPackage + "/"
					}
					//name package for java class
					packageName = packageFolder.replace("/",".")
					packageName = packageName.substring(0,packageName.length-1) + ';'
				}
			}
					 
			/* Compiling Requests */
			if (e.getRequests != null){
				for (r : e.getRequests){
					//request
					fsa.generateFile(packageFolder + "ContextRequest_"+r.name+".java",r.compileRequest())
				}
				 		
			}
			
			/* Compiling Import Files */
			if (e.getImportEl != null){
				for (Import i : e.importEl){
					//call do generate on imported files
					var Injector injector = new Facpl2StandaloneSetup().createInjectorAndDoEMFRegistration();
    				var XtextResourceSet set = injector.getInstance(xtendUtil::getClassXtext);
   					var URI uri = URI::createPlatformResourceURI(projectPath+i.importURI,true);
					set.createResource(uri)
					var Resource res = set.getResource(uri,true)
						
					this.doGenerate(res,fsa)
				}
			}
			
			/* Compiling Policies that are declared out from the brackets of the Main */
			if (e.getPolicies != null){
				for(pol : e.getPolicies){
					fsa.generateFile(packageFolder + getNameFacplPolicy(pol)+".java", compilePolicy(pol,fsa))	
				}
			}
			
			/* Compiling Declared Functions */	
			if (e.declarations != null){
				for (dec : e.declarations){
					fsa.generateFile(packageFolder + getNameFunction(dec.name)+".java", compileFunction(dec))
				}
				
			}
				
			/* Compiling Main */
			if (e.getMain != null){
				
				/* Generating Main File of PDP and PEP (Policies possibly defined within the PDP are compiled as well*/
				
				fsa.generateFile(packageFolder +"MainFACPL.java",compileMain(e.getMain,fsa))
				fsa.generateFile(packageFolder +"PEPAction.java",compilePEPAction)
			}
				
		}
	}
	
	//----------------------------------------------------
	//PDP
	//----------------------------------------------------
	def CharSequence compileMain(MainFacpl main, IFileSystemAccess fsa)'''
	«IF packageName != ""»package «packageName»«ENDIF»
	
	import it.unifi.facpl.lib.policy.*;
	import it.unifi.facpl.system.*;
	import it.unifi.facpl.lib.context.*;
	import it.unifi.facpl.lib.interfaces.*;
	import it.unifi.facpl.lib.enums.*;
	import it.unifi.facpl.lib.util.*;
	import java.lang.reflect.Method;
	import java.util.LinkedList;
	import java.util.List;
	
	@SuppressWarnings("all")
	public class MainFACPL{
		 	
		private PDP pdp;
		private PEP pep;
			
		public MainFACPL() {
			// defined list of policies included in the PDP
			LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();
			«FOR p : main.paf.pdp.polSet»
«««		Firt row adds the name of the policy. The next IF is needed to compile policies possibly defined in the PDP
			policies.add(new «IF p.refPol == null»«getNameFacplPolicy(p.newPolicy)»«ELSE»«getNameFacplPolicy(p.refPol)»«ENDIF»()); 
			«ENDFOR»
			this.pdp = new PDP(«getAlgName(main.paf.pdp.pdpAlg.idAlg,fsa)»«IF main.paf.pdp.pdpAlg.FStrategy!= null»«IF main.paf.pdp.pdpAlg.FStrategy.equals(FulfillmentStrategy.GREEDY)»Greedy«ENDIF»«ENDIF».class, policies, «IF main.extIndet != null»«getExpression(main.extIndet)»«ELSE»false«ENDIF»);
			
			this.pep = new PEP(EnforcementAlgorithm.«main.paf.pep.literal.replace('-','_').toUpperCase»);
				
			this.pep.addPEPActions(PEPAction.getPepActions());
		}
			
		/*
		*ENTRY POINT FOR EVALUATION
		*/
		public static void main(String[] args){
			//Initialise Authorisation System
			MainFACPL system = new MainFACPL();
			
			//log
			StringBuffer result = new StringBuffer();
			//request
			LinkedList<ContextRequest> requests = new LinkedList<ContextRequest>();
			«FOR r : main.refRequest»
			requests.add(ContextRequest_«r.name».getContextReq());
			«ENDFOR»
			for (ContextRequest rcxt : requests) {
				result.append("---------------------------------------------------\n");
				AuthorisationPDP resPDP = system.pdp.doAuthorisation(rcxt);
				result.append("Request: "+ resPDP.getId() + "\n\n");
				result.append("PDP Decision=\n " + resPDP.toString()+"\n\n");
				//enforce decision
				AuthorisationPEP resPEP = system.pep.doEnforcement(resPDP);
				result.append("PEP Decision=\n " + resPEP.toString()+"\n");
				result.append("---------------------------------------------------\n");
			}
			System.out.println(result.toString());
			ShowResult.showResult(result);
		}	
		
		«FOR p : main.paf.pdp.polSet»
			«IF p.newPolicy != null»
				«IF p.newPolicy instanceof PolicySet»
				«fsa.generateFile(packageFolder + getNameFacplPolicy(p.newPolicy)+".java",compilePolicy(p.newPolicy,fsa))»
				«ELSE»
				«compilePolicy(p.newPolicy as Rule, fsa)»			
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		public PDP getPdp() {
			return pdp;
		}
			
		public PEP getPep() {
			return pep;
		}
		
	}
	'''
	
	//----------------------------------------------------
	//PEP-ACTIONS
	//----------------------------------------------------
	def CharSequence compilePEPAction() '''
	«IF packageName != ""»package «packageName»«ENDIF»
	
	import java.util.HashMap;
	import it.unifi.facpl.lib.interfaces.IPepAction;

	@SuppressWarnings("all")
	public class PEPAction{

	    public static HashMap<String, Class<? extends IPepAction>> getPepActions() {
			/*
			 * Set your own pep action e.g. HashMap<String,Class<? extends
			 * IPepAction>> pepAction = new HashMap<String,Class<? extends
			 * IPepAction>>(); pepAction.put("action", Action.class); return
			 * pepAction;
			 */
			return null;
		}
		
	}
	'''

	//----------------------------------------------------
	//POLICIES Names
	//----------------------------------------------------
	
	def dispatch String getNameFacplPolicy(PolicySet policyS) { 
		return "PolicySet_"+ policyS.name
	}
	
	def dispatch String getNameFacplPolicy(Rule rule) { 
		return "Rule_"+ rule.name
	}
	
	//
	
	//----------------------------------------------------
	//POLICYSET
	//----------------------------------------------------
	def dispatch CharSequence compilePolicy(PolicySet pol,IFileSystemAccess fsa)'''
	«IF packageName != ""»package «packageName»«ENDIF»
	
	import it.unifi.facpl.lib.policy.*;
	import it.unifi.facpl.lib.enums.*;
	import it.unifi.facpl.lib.util.*;
	
	@SuppressWarnings("all")	
	public class «getNameFacplPolicy(pol)» extends PolicySet {
		public «getNameFacplPolicy(pol)»(){
			addId("«pol.getName()»");
			//Algorithm Combining
			«compileAlg(pol.polSetAlg,fsa)»
			«IF pol.target != null»
			//Target
			addTarget(«getExpression(pol.target)»);
			«ENDIF»
			//PolElements
			«FOR p: pol.policies»
				addPolicyElement(new «IF p.refPol == null»«getNameFacplPolicy(p.newPolicy)»«ELSE»«getNameFacplPolicy(p.refPol)»«ENDIF»());
				«IF p.refPol == null»
					«IF p.newPolicy instanceof PolicySet»
«««					COMPILE POLICYSET INTERNALLY DECLARED (it creates a new .java file)
						«fsa.generateFile(packageFolder + getNameFacplPolicy(p.newPolicy)+".java",compilePolicy(p.newPolicy,fsa))»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
			//Obligation
			«FOR o : pol.obl»
			addObligation(«o.compileObligation»);
			«ENDFOR»
			}
			
«««			//Classes Declaring Rules defined
			«FOR p: pol.policies»
				«IF p.newPolicy != null»
					«IF p.newPolicy instanceof Rule»
						«compilePolicy(p.newPolicy as Rule, fsa)»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
	}
	'''
	
	//----------------------------------------------------
	//RULE	
	//----------------------------------------------------
	def dispatch CharSequence compilePolicy(Rule rule,IFileSystemAccess fsa) '''
	private class «getNameFacplPolicy(rule)» extends Rule {
		
			«getNameFacplPolicy(rule)» (){
				addId("«rule.name»");
				//Effect
				addEffect(Effect.«rule.effect.getName»);
				«IF rule.target != null»
				//Target
				addTarget(«getExpression(rule.target)»);
				«ENDIF»
				//Obligations
				«FOR o : rule.obl»
				addObligation(«o.compileObligation»);
				«ENDFOR»
		}	
	}
	'''
	
	//----------------------------------------------------
	//OBLIGATIONS
	//----------------------------------------------------
	def compileObligation(Obligation obl) '''
		new Obligation("«obl.pepAction»",Effect.«obl.evaluetedOn.getName»,ObligationType.«obl.typeObl»,«obl.expr.getOblExpression»)
	'''
	
	def getOblExpression(EList<Expression> list) '''
	«IF list == null || list.size == 0»
		null
	«ELSE»	
		«FOR e : list SEPARATOR ','»
			«getExpression(e)»
		«ENDFOR»
	«ENDIF»
	'''

	//----------------------------------------------------
	// EXPRESSION
	//----------------------------------------------------
	def dispatch getExpression(AndExpression exp)'''
		new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(«exp.left.getExpression»),new ExpressionBooleanTree(«exp.right.getExpression»))
	'''
	 
	def dispatch getExpression(OrExpression exp)'''
		new ExpressionBooleanTree(ExprBooleanConnector.OR,new ExpressionBooleanTree(«exp.left.getExpression»),new ExpressionBooleanTree(«exp.right.getExpression»))
	'''
	
	def dispatch getExpression(NotExpression exp)'''
		new ExpressionBooleanTree(ExprBooleanConnector.NOT,new ExpressionBooleanTree(«exp.arg.getExpression»))
	'''
	
	def dispatch getExpression(Function exp)'''
		new ExpressionFunction(it.unifi.facpl.lib.function.«Facpl2Generator_Name::getFunName(exp.functionId)».class, «getExpression(exp.arg1)»,«getExpression(exp.arg2)»)
	'''
	
	def dispatch getExpression(DeclaredFunction exp)'''
		new ExpressionFunction(«getNameFunction(exp.functionId.name)».class,
		«IF exp.args.size > 0»
			«FOR arg : exp.args SEPARATOR ','» 
				«getExpression(arg)»
			«ENDFOR»
		«ELSE»
			null
		«ENDIF»
		)
	''' 
			
	// Basic EXPRESSION: int, double, boolean, string, date, attribute name, Set
	def dispatch getExpression(IntLiteral e) {
		e.value
	}

	def dispatch getExpression(DoubleLiteral e) {
		e.value
	}

	def dispatch getExpression(BooleanLiteral e) {
		e.value
	}

	def dispatch getExpression(StringLiteral e) {
		'"' + e.value + '"'
	}

	def dispatch getExpression(TimeLiteral e) {
		'new FacplDate("' + e.value + '")'
	}

	def dispatch getExpression(DateLiteral e) {
		'new FacplDate("' + e.value + '")'
	}

	def dispatch getExpression(AttributeName attributeName) '''
		new AttributeName("«attributeName.category.toString»","«attributeName.id.toString»") 
	'''

	def dispatch getExpression(Set Set) '''
		new Set(
		«FOR b : Set.args SEPARATOR ','»
			«getExpression(b)»
		«ENDFOR»
		)
	'''	
		
	//----------------------------------------------------
	// COMBINING ALGORITHM : custom + standard
	//----------------------------------------------------
	
	def compileAlg(Alg alg,IFileSystemAccess fsa) '''
		«IF (!alg.idAlg.getName.toString.equals("CUSTOM_ALG"))»
		addCombiningAlg(«getAlgName(alg.idAlg,fsa)»«IF alg.FStrategy!= null»«IF alg.FStrategy.equals(FulfillmentStrategy.GREEDY)»Greedy«ENDIF»«ENDIF».class);
		«ELSE»
		addCombiningAlg(«getAlgName(alg.idAlg,fsa)».class);
		«ENDIF»
	'''
	
	
	def getAlgName(AlgLiteral alg,IFileSystemAccess fsa) { 
		if (alg.getName.toString.equals("DENY_OVER")){
			return "it.unifi.facpl.lib.algorithm.DenyOverrides"
		}
		if (alg.getName.toString.equals("PERMIT_OVER")){
			return "it.unifi.facpl.lib.algorithm.PermitOverrides"
		}
		if (alg.getName.toString.equals("FIRST")){
			return "it.unifi.facpl.lib.algorithm.FirstApplicable"
		}
		if (alg.getName.toString.equals("DENY_UNLESS")){
			return "it.unifi.facpl.lib.algorithm.DenyUnlessPermit"
		}
		if (alg.getName.toString.equals("PERMIT_UNLESS")){
			return "it.unifi.facpl.lib.algorithm.PermitUnlessDeny"
		}
		if (alg.getName.toString.equals("ONLY_ONE")){
			return "it.unifi.facpl.lib.algorithm.OnlyOneApplicable"
		}	
		if (alg.getName.toString.equals("WEAK_CONS")){
			return "it.unifi.facpl.lib.algorithm.WeakConsensus"
		}
		if (alg.getName.toString.equals("STRONG_CONS")){
			return "it.unifi.facpl.lib.algorithm.StrongConsensus"
		}
		//user algorithm
		if (alg.getName.toString.equals("CUSTOM_ALG")){
			//generate class for user algorithm
			fsa.generateFile(packageFolder + personalAlg +".java",compilePersonalAlg())
			return personalAlg
		}
	}
	
	def CharSequence compilePersonalAlg() '''
	«IF packageName != ""»package «packageName»«ENDIF»
	
	import java.util.LinkedList;
	import java.util.List;
	import org.apache.log4j.Logger;

	import it.unifi.facpl.lib.context.*;
	import it.unifi.facpl.lib.enums.ExtendedDecision;
	import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
	import it.unifi.facpl.lib.interfaces.IEvaluableElement;
	import it.unifi.facpl.lib.policy.PAFElement;
	import it.unifi.facpl.lib.util.DecisionResult;
	
	@SuppressWarnings("all")
	public class «personalAlg» implements IEvaluableAlgorithm{

		@Override
		public DecisionResult evaluate(List<EvaluableElement> elements, 
			ContextRequest cxtRequest, Boolean arg2) {
		
		Logger l = Logger.getLogger(PAFElement.class);
		l.debug("-> personal combining algorithm started");
	
		/* TODO Auto-generated evaluate method
		* Create personal combing strategy for EvaluableElement
		* For Example
		*
		*for (EvaluableElement el : elements) {
		*	DecisionResult d = el.evaluate(cxtRequest);
		*	if (d.getDecision().equals(ExtendedDecision.PERMIT)){
		*		obls_permit.addAll(d.getObligation());
		*	}else 
		*	
		*	ecisions.add(d);
		*}
		*
		*DecisionResult dr = new DecisionResult();
		*for (DecisionResult decision : decisions) {
		*	if (decision.getDecision().equals(ExtendedDecision.PERMIT)){
		*		dr.setDecision(ExtendedDecision.PERMIT);
		*		dr.addObligation(obls_permit);
		*		return dr;
		*	}
		*}
		*
		*dr.setDecision(ExtendedDecision.INDETERMINATE);
		*return dr;
		*
		*/
		return null;
		}
	}
	'''

	//----------------------------------------------------
	//REQUEST 
	//----------------------------------------------------
	def CharSequence compileRequest(Request request) '''
		«IF packageName != ""»package «packageName»«ENDIF»
		
		import java.util.HashMap;
		import it.unifi.facpl.lib.context.*;
		import it.unifi.facpl.lib.util.*;
		
		@SuppressWarnings("all")		
		public class ContextRequest_«request.name» {

			private static ContextRequest CxtReq;
		

			public static ContextRequest getContextReq(){
			if (CxtReq != null){
				return CxtReq;
			}
			//create map for each category
			«FOR category : xtendUtil::getCategories(request)»
				HashMap<String, Object> req_«xtendUtil::parseNameCat(category)» = new HashMap<String, Object>();
			«ENDFOR»
			//add attribute's values
			«FOR a : request.attributes»
				req_«xtendUtil::parseNameCat(a.name.category)».put("«a.name.id»",«a.value.compileRequestValue»);
			«ENDFOR»
			//add attributes to request
			Request req = new Request("«request.name»");
			«FOR category : xtendUtil::getCategories(request)»
				req.addAttribute("«category»",req_«xtendUtil::parseNameCat(category)»);
			«ENDFOR»
			«IF request.stub!=null»
			//context stub: 
			CxtReq =  new ContextRequest(req, «request.stub.trim».getInstance());
			«ELSE»
			//context stub: default-one
			CxtReq =  new ContextRequest(req, ContextStub_Default.getInstance());
			«ENDIF»
			return CxtReq;
			}
		}
		'''
		
	def compileRequestValue(EList<Expression> list) { 
		if (list.size == 1){
			return getExpression(list.get(0))
		}else{
			list.getSetDeclaration
		}
	}
	
	def CharSequence getSetDeclaration(EList<Expression> list) '''
		new Set(
		«FOR l: list SEPARATOR ','»
		«getExpression(l)»
		«ENDFOR»
		)
	'''
	//----------------------------------------------------
	//DECLARED FUNCTIONs 
	//----------------------------------------------------
	def String getNameFunction (String f_name)'''Function_«f_name»'''
	
	def compileFunction(FunctionDeclaration f)'''
		«IF packageName != ""»package «packageName»«ENDIF»
		
		import java.util.List;
		
		import it.unifi.facpl.lib.interfaces.IExpressionFunction;
		import it.unifi.facpl.lib.util.*;
		
		@SuppressWarnings("all")
		public class «getNameFunction(f.name)» implements IExpressionFunction{
		
			@Override
			public Object evaluateFunction(List<Object> args) throws Throwable {
				
				if (args.size() == «f.args.size») {
					«IF f.args.size > 0»		
					if( 
					«var i = -1»
					«FOR arg:  f.args SEPARATOR ' && '»
					args.get(«i = i +1») instanceof «Facpl2Generator_Name::getJavaType(FacplType::getFacplType(arg))»
					«ENDFOR»
					){
							throw new Exception("TODO: auto-generated method stub");
					}else{
							throw new Exception("Illegal types of arguments");
					}
					«ELSE»
					throw new Exception("TODO: auto-generated method stub");
					«ENDIF»
				} else {
					throw new Exception("Illegal number of arguments");
				}
				
			}
		
		}
	'''
	
}