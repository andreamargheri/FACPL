package it.unifi.xtext.facpl2.tests.smt

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import org.eclipse.xtext.junit4.AbstractXtextTests
import it.unifi.xtext.facpl.facpl2.Facpl
import org.eclipse.xtext.junit4.util.ParseHelper
import com.google.inject.Inject
import org.junit.Test
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import it.unifi.xtext.facpl.generator.util.SecurityProperty
import it.unifi.xtext.facpl.facpl2.Request
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference
import it.unifi.xtext.facpl.generator.util.Decision
import it.unifi.xtext.facpl.validation.FacplType
import it.unifi.xtext.facpl.generator.util.PolicyConstant
import java.io.PrintWriter
import it.unifi.xtext.facpl.generator.util.StructuralProperty

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
public class SMT_LIBGenerator_Property_Test extends AbstractXtextTests {

	@Inject extension ParseHelper<Facpl>

	@Inject extension SMT_LIBGenerator

	@Inject extension ValidationTestHelper

	/* Check well-typed request wrt considered policy */
	@Test
	def void checkTypedRequest() {

		var model = (
		'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: equal(action/id,"read") || equal(suject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		var request = (
			'''Request:{ Req_Name ( action/id , 5 ) }''').parse.requests.get(0)

		assertNoErrors(request)

		var tInf = new FacplTypeInference

		tInf.doSwitch(model)
		var type = tInf.doSwitch(request)

		assertEquals(type, FacplType.ERR)

		/* ----------------------------- */
		request = (
			'''Request:{ Req_Name ( action/id , "write" ) }''').parse.requests.get(0)

		assertNoErrors(request)

		tInf = new FacplTypeInference

		tInf.doSwitch(model)
		type = tInf.doSwitch(request)

		assertEquals(type, FacplType.TYPED)

		/* ----------------------------- */
		request = (
			'''Request:{ Req_Name ( action/id , "write", "read" ) }''').parse.requests.get(0)

		assertNoErrors(request)

		tInf = new FacplTypeInference

		tInf.doSwitch(model)
		type = tInf.doSwitch(request)

		assertEquals(type, FacplType.ERR)

		/* ----------------------------- */
		request = (
			'''Request:{ Req_Name ( action/id , "write", 5 ) }''').parse.requests.get(0)

		tInf = new FacplTypeInference

		tInf.doSwitch(model)
		type = tInf.doSwitch(request)

		assertEquals(type, FacplType.ERR)

	}

	/*Check if string constants are taken from request */
	@Test
	def void checkStringConst() {
		var model = (
		'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: in(action/id,"read") || equal(suject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		var request = (
			'''Request:{ Req_Name ( action/id ,"write" ) }''').parse.requests.get(0)

		assertNoErrors(request)

		var tConst = new PolicyConstant
		tConst.doSwitch(model)
		var b = tConst.doSwitch(request)

		assertEquals(b, true)
		assertEquals(tConst.constants.containsKey("write"), true)

		/* ------------------- */
		model = (
		'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: in("read", action/id) || equal(suject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		request = (
			'''Request:{ Req_Name ( action/id ,"write", "delete" ) }''').parse.requests.get(0)

		assertNoErrors(request)

		tConst = new PolicyConstant
		tConst.doSwitch(model)
		b = tConst.doSwitch(request)

		assertEquals(b, true)
		assertEquals(tConst.constants.containsKey("write"), true)
		assertEquals(tConst.constants.containsKey("delete"), true)

	}

	/* Generation of SMT-LIB code for Properties */
	@Test
	def void genSecProperty_SECURITY() {
		var model = (
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: equal(action/id,"read") || equal(subject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		var Request request = (
			'''
			Request:{ Req_Name ( action/id , "read" ) } 
		'''
		).parse.requests.get(0)

		assertNoErrors(request)

		var str = doGenerateSecurity_Property_Code(model, "Name", request, Decision.PERMIT, SecurityProperty.EVAL)

		/* Test if subject/id assert to bottom */
		assertEquals(str.contains("(assert (miss n_subject/id))"), true)

		/* Test Final assertion */
		assertEquals(str.contains("(assert cns_Name_permit)"), true)

		/*Copy the generated code to file */
		var PrintWriter writer = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_Eval.smt2", "UTF-8");
		writer.println(str);
		writer.close();

		/* ------------------------------------- */
		model = (
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: equal(action/id,"read") && equal(subject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		request = (
			'''
			Request:{ Req_Name ( action/id , "read" ) } 
		'''
		).parse.requests.get(0)

		assertNoErrors(request)

		/* -> NOT-APP */
		str = doGenerateSecurity_Property_Code(model, "Name", request, Decision.NOT_APPLICABLE, SecurityProperty.MAY)

		/* Test if subject/id assert to bottom */
		assertEquals(str.contains("(assert (miss n_subject/id))"), false)

		/* Test Final assertion */
		assertEquals(str.contains("(assert cns_Name_notApp)"), true)

		/*Copy the generated code to file */
		writer = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_May_NotApp.smt2", "UTF-8");
		writer.println(str);
		writer.close();

		/* -> INDET */
		str = doGenerateSecurity_Property_Code(model, "Name", request, Decision.INDETERMINATE, SecurityProperty.MAY)

		/* Test if subject/id assert to bottom */
		assertEquals(str.contains("(assert (miss n_subject/id))"), false)

		/* Test Final assertion */
		assertEquals(str.contains("(assert cns_Name_indet)"), true)

		/*Copy the generated code to file */
		writer = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_May_Indet.smt2", "UTF-8");
		writer.println(str);
		writer.close();

		/* ------------------------------------- */
		model = (
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: equal(action/id,"read") || equal(subject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		request = (
			'''
			Request:{ Req_Name ( action/id , "read" ) } 
		'''
		).parse.requests.get(0)

		assertNoErrors(request)

		str = doGenerateSecurity_Property_Code(model, "Name", request, Decision.NOT_APPLICABLE, SecurityProperty.MUST)

		/* Test if subject/id assert to bottom */
		assertEquals(str.contains("(assert (miss n_subject/id))"), false)

		/* Test Final assertion */
		assertEquals(str.contains("(assert (not cns_Name_notApp))"), true)

		/*Copy the generated code to file */
		writer = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_Must1.smt2", "UTF-8");
		writer.println(str);
		writer.close();

		/* ------------------------------------- */
		model = (
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: equal(action/id,"read") || equal(subject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		request = (
			'''
			Request:{ Req_Name ( action/id , "read" ) (subject/id, "Franco") } 
		'''
		).parse.requests.get(0)

		assertNoErrors(request)

		str = doGenerateSecurity_Property_Code(model, "Name", request, Decision.PERMIT, SecurityProperty.MUST)

		/* Test if subject/id assert to bottom */
		assertEquals(str.contains("(assert (miss n_subject/id))"), false)

		/* Test Final assertion */
		assertEquals(str.contains("(assert (not cns_Name_permit))"), true)

		/*Copy the generated code to file */
		writer = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_Must2.smt2", "UTF-8");
		writer.println(str);
		writer.close();

	}

	/* Generation of SMT-LIB code for Properties with Set declared in the request*/
	@Test
	def void genSecProperty_SECURITY_Set() {
		var model = (
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: in("read", action/id) || equal(subject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		var Request request = (
			'''
			Request:{ Req_Name ( action/id , "read", "write" ) } 
		'''
		).parse.requests.get(0)

		assertNoErrors(request)

		var str = doGenerateSecurity_Property_Code(model, "Name", request, Decision.PERMIT, SecurityProperty.EVAL)

		/* Test if subject/id assert to bottom */
		assertEquals(str.contains("(assert (miss n_subject/id))"), true)

		/* Test Final assertion */
		assertEquals(str.contains("(assert cns_Name_permit)"), true)

		/*Test Assertion on set declared in the Request */
		
		assertEquals(str.contains("(assert (= (select (val n_action/id) 0) s_read))"), true)
		assertEquals(str.contains("(assert (= (select (val n_action/id) 1) s_write))"), true)

		/*Copy the generated code to file */
		var PrintWriter writer = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_Eval_Set.smt2", "UTF-8");
		writer.println(str);
		writer.close();
		
	}

	@Test
	def void checkAddAttribute() {

		var model = (
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: equal(action/id,"read") || equal(subject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		var Request request = (
			'''
			Request:{ Req_Name ( action/purpose , "CLEAN" ) } 
		'''
		).parse.requests.get(0)

		assertNoErrors(request)

		var str = doGenerateSecurity_Property_Code(model, "Name", request, Decision.PERMIT, SecurityProperty.EVAL)

		/* Test if the attribute declared in the request but not in the policy is correctly added in the code */
		assertEquals(str.contains("(declare-const n_action/purpose (TValue String))"), true)

	}


	/* Generation of SMT-LIB code for Complete Structural Property*/
	@Test
	def void genStructProperty_Complete() {
		var model = (
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: in("read", action/id) || equal(subject/id,"Andrea"))
  		}''').parse

		assertNoErrors(model)

		var str = doGenerateComplete_Property_Code(model, "Name")

		/* Test Final assertion */
		assertEquals(str.contains("(assert cns_Name_notApp)"), true)

		/*Copy the generated code to file */
		var PrintWriter writer = new PrintWriter("SMT_LIB_gen/StructuralProperty/genStruct_Complete1.smt2", "UTF-8");
		writer.println(str);
		writer.close();
		
		/* ------------------ */
		
		model = (
		'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: in("read", action/id) || equal(subject/id,"Andrea"))
  		}
  		PolicySet Name1 {permit-overrides 
  		  	policies: 
  		  		Rule r12 (permit target: in("read", action/id) || equal(subject/id,"Andrea"))
  		 }
  		''').parse

		assertNoErrors(model)

		str = doGenerateComplete_Property_Code(model, "Name1")

		/* Test Final assertion */
		assertEquals(str.contains("(assert cns_Name1_notApp)"), true)

		/*Copy the generated code to file */
		writer = new PrintWriter("SMT_LIB_gen/StructuralProperty/genStruct_Complete2.smt2", "UTF-8");
		writer.println(str);
		writer.close();	
	}
	
	/* Generation of SMT-LIB code for Structural Properties (but Complete)*/
	@Test
	def void genStructProperties() {
		var model = (
		'''
		PolicySet Name {permit-overrides 
		policies: 
			Rule r1 (permit target: equal("read", action/type))
		}
		
		PolicySet Name1 {permit-overrides 
		policies: 
			Rule r12 (permit target: equal("read", action/id) || equal(subject/id,"Andrea"))
		}
  		''').parse

		assertNoErrors(model)

		var str = doGenerateStructural_Property_Code(model, "Name", "Name1", StructuralProperty.COVERAGE);

		/* Test Final assertion */
		assertEquals(str.contains("(=> cns_Name_permit cns_Name1_permit)"), true)

		/*Copy the generated code to file */
		var PrintWriter writer = new PrintWriter("SMT_LIB_gen/StructuralProperty/genStruct_Coverage1.smt2", "UTF-8");
		writer.println(str);
		writer.close();
		
		
		/* ---------------------------- */
		
		
		model = (
		'''
		PolicySet Name {permit-overrides 
		policies: 
			Rule r1 (permit target: equal("read", action/type))
		}
		
		PolicySet Name1 {permit-overrides 
		policies: 
			Rule r12 (permit target: equal("read", action/id) || equal(subject/id,"Andrea"))
		}
  		''').parse

		assertNoErrors(model)

		str = doGenerateStructural_Property_Code(model, "Name", "Name1", StructuralProperty.DISJOINT);

		/* Test Final assertion */
		assertEquals(str.contains("(and cns_Name_permit cns_Name1_permit)"), true)

		/*Copy the generated code to file */
		writer = new PrintWriter("SMT_LIB_gen/StructuralProperty/genStruct_Disjoint1.smt2", "UTF-8");
		writer.println(str);
		writer.close();

	}
	
}
