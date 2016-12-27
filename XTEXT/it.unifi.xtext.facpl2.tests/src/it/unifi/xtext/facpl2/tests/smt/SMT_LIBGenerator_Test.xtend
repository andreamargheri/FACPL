package it.unifi.xtext.facpl2.tests.smt

import com.google.inject.Inject
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator
import it.unifi.xtext.facpl.generator.util.PolicyConstant
import java.io.PrintWriter
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
public class SMT_LIBGenerator_Test extends AbstractXtextTests {

	@Inject extension ParseHelper<Facpl>

	@Inject extension SMT_LIBGenerator

	@Inject extension ValidationTestHelper

	@Test
	def void genAttribute() {
		var model = ('''
		PolicySet Name {permit-overrides 
		policies: 
				Rule r1 (permit target: cat/id)
		}''').parse

		assertNoErrors(model)

		var String cns = doGenerateSMT_LIB_Test(model)

		/*
		 * Non assigned attribute considered as Boolean
		 */
		if (cns.contains('''(declare-const n_cat/id (TValue Bool))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

		/*
		 * Two boolean attributes 
		 */
		model = ('''
			PolicySet Name {permit-overrides 
				policies: Rule r1 (permit target: cat/id && cat1/id)}
		''').parse

		assertNoErrors(model)

		cns = doGenerateSMT_LIB_Test(model)

		if (cns.contains('''(declare-const n_cat1/id (TValue Bool))''') &&
			cns.contains('''(declare-const n_cat/id (TValue Bool))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

		model = ('''
		PolicySet Name {permit-overrides 
		policies: 
			Rule r1 (permit target: addition(cat/id,cat1/id))
		}'''
		).parse

		assertNoErrors(model)

		/*
		 * Target has not type boolean, the SMT-LIB cannot be generated 
		 */
		assertNotNull("Policy Name is not well-typed", doGenerateSMT_LIB_Test(model))

		/*
		 * Two Boolean and Int
		 */
		model = (
			'''
		PolicySet Name {permit-overrides 
		policies: 
			Rule r1 (permit target: cat/id && equal(cat1/id,5))
		}'''
		).parse

		assertNoErrors(model)

		cns = doGenerateSMT_LIB_Test(model)

		if (cns.contains('''(declare-const n_cat1/id (TValue Int))''') &&
			cns.contains('''(declare-const n_cat/id (TValue Bool))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}
	}

	@Test
	def void genAttributeConstants() {
		var model = ('''
		PolicySet Name {permit-overrides 
			policies: 
				Rule r1 (permit target: true)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateSMT_LIB_Test(model)

//		System.out.println(cns)
		/*
		 * Non assigned attribute considered as boolean
		 */
		if (cns.contains('''(declare-const const_true (TValue Bool))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

		model = ('''
		PolicySet Name {permit-overrides 
		policies: 
			Rule r1 (permit target: true
			obl: [permit M log(5,6.6,false, cat/id,"prova")])
		}'''
		).parse

		assertNoErrors(model)

		cns = doGenerateSMT_LIB_Test(model)

//		System.out.println(cns)
		/*
		 * Non assigned attribute are assumes of type Boolean
		 */
		if (cns.contains('''(declare-const const_true (TValue Bool))''') &&
			cns.contains('''(declare-const const_6.6 (TValue Real))''') &&
			cns.contains('''(declare-const const_false (TValue Bool))''') &&
			cns.contains('''(declare-const const_5 (TValue Int))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

	}

	@Test
	def void genString() {
		var model = (
		'''
		PolicySet Name {permit-overrides 
		policies: 
			Rule r1 (permit target: equal("prova",cat/id) && equal("doc","pharmacist") )
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateSMT_LIB_Test(model)

		System.out.println(cns)

		/*
		 * Non assigned attribute considered as boolean
		 */
		if (cns.
			contains('''(declare-datatypes () ((String s_prova s_pharmacist s_doc  s_AdditionalStringValue )))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

	}

	@Test
	def void genDeclaredFunction() {
		try {

			var model = ('''
			dec-fun Bool F_Name (String, Int) 
			dec-fun Bool F_Name2 (String, Bool)
			dec-fun Set<Int> F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
					target: F_Name(sub/id, "doctor")
							policies: 
								Rule r1 (permit)
			}''').parse

			assertNoErrors(model)

			var flag = false
			try {
				doGenerateSMT_LIB_Test(model)
			} catch (Exception e) {
				// the policy cannot be typed
				assertEquals(true, true)
				flag = true

			}
			if (!flag)
				assertEquals(false, true)

			// Second Test	
			model = (
				'''
			dec-fun Bool F_Name (String, Int) 
			
			dec-fun Set<Int> F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
				target: F_Name(sub/id, 5)
					policies: 
						Rule r1 (permit)
			}''').parse

			assertNoErrors(model)

			var cns = doGenerateSMT_LIB_Test(model)

			var PrintWriter writer = new PrintWriter("SMT_LIB_gen/decFun/file1.smt2", "UTF-8");
			writer.println(cns);
			writer.close();

			model = (
				'''
			dec-fun Bool F_Name (String, Int) 
			
			dec-fun Set<Int> F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
					target: in(sub/id, F(n/id, 5))
							policies: 
								Rule r1 (permit)
			}'''
			).parse

			assertNoErrors(model)

			cns = doGenerateSMT_LIB_Test(model)

//			System.out.println(cns)
			writer = new PrintWriter("SMT_LIB_gen/decFun/file2.smt2", "UTF-8");
			writer.println(cns);
			writer.close();

			model = (
				'''
			dec-fun Bool F_Name (String, Int)
			
			dec-fun Int F (Int, Int)
			
			PolicySet pSet {deny-unless-permit 
			policies:
			Rule name (permit target: equal(5,n/id) && F_Name(n/string,F(5, n/id)) || F_Name(n/string,F(n/id1, n/id3)))
			}'''

			).parse

			assertNoErrors(model)

			cns = doGenerateSMT_LIB_Test(model)

			writer = new PrintWriter("SMT_LIB_gen/decFun/file3.smt2", "UTF-8");
			writer.println(cns);
			writer.close();

		} catch (Exception e) {
			System.out.println(e.message)
			assertEquals(false, true)
		}

	}

	@Test
	def void attrSets() {

		var model = (
		'''
		PolicySet pSet {deny-unless-permit 
		policies:
			Rule name (permit target: in(5,n/id) 
		}''').parse

		/*
		 * BAG contains attribute, cannot be typed 
		 */
		assertNotNull("Policy Name is not well-typed", doGenerateSMT_LIB_Test(model))

	}

//@Test
//def void constantSets() {
//
//	/*
//	 * TestGeneration constants : 1 set
//	 */
//	var model = ('''
//		PolicySet pSet {deny-unless-permit 
//		policies:
//			Rule name (permit target: in(5,set(5,6))) 
//		}
//	''').parse
//
//	assertNoErrors(model)
//
//	var PolicyConstant tConst = new PolicyConstant
//
//	tConst.doSwitch(model)
//
//	assertEquals(tConst.sets.size, 1)
//
//	assertEquals(tConst.constants.containsKey("set_1"), true)
//
//	/*
//	 * TestGeneration constants - 2 sets in the policy equal -> 1 set constant
//	 */
//	model = ('''
//		PolicySet pSet {deny-unless-permit 
//		policies:
//			Rule name (permit target: in(n/id,set(true, false, false)))
//			Rule nam1 (deny target: in(true, set(true, false, false))) 
//		}
//	''').parse
//
//	assertNoErrors(model)
//
//	tConst = new PolicyConstant
//
//	tConst.doSwitch(model)
//
//	assertEquals(tConst.sets.size, 1)
//
//	assertEquals(tConst.constants.containsKey("set_1"), true)
//
//	/*
//	 * TestGeneration constants - 2 sets  -> 2 set constants
//	 */
//	model = ('''
//		PolicySet pSet {deny-unless-permit 
//		policies:
//			Rule name (permit target: in(n/id,set(true, false, false)))
//			Rule nam1 (deny target: in(true, set(false, false))) 
//		}
//	''').parse
//
//	assertNoErrors(model)
//
//	tConst = new PolicyConstant
//
//	tConst.doSwitch(model)
//
//	assertEquals(tConst.sets.size, 2)
//
//	assertEquals(tConst.constants.containsKey("set_1"), true)
//	assertEquals(tConst.constants.containsKey("set_2"), true)
//
//	/*
//	 * TestGeneration constants - 2 sets  -> 2 set constants
//	 */
//	model = ('''
//		PolicySet pSet {deny-unless-permit 
//		policies:
//			Rule name (permit target: in(n/id,set(true, false, false))) 
//		}
//		
//		PolicySet pSet1 {permit-unless-deny
//		policies: 
//			Rule nam1 (deny target: in(true, set(false, false)))
//		}
//	''').parse
//
//	assertNoErrors(model)
//
//	tConst = new PolicyConstant
//
//	tConst.doSwitch(model)
//
//	assertEquals(tConst.sets.size, 2)
//
//	assertEquals(tConst.constants.containsKey("set_1"), true)
//	assertEquals(tConst.constants.containsKey("set_2"), true)
//
//}
	@Test
	def void genSets() {

		var model = ('''
			PolicySet pSet {deny-unless-permit 
			policies:
				Rule name (permit target: in(7,set(5,6))) 
			}
		''').parse

		assertNoErrors(model)

		var String cns = doGenerateSMT_LIB_Test(model)

//		System.out.println(cns)
		/*
		 * Non assigned attribute considered as boolean
		 */
		if (cns.contains('''(declare-const const_set_1 (TValue (Set Int)))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

		val writer = new PrintWriter("SMT_LIB_gen/decSet/file1_const.smt2", "UTF-8");
		writer.println(cns);
		writer.close();
	}

	@Test
	def void genSetsStringConstants() {
		var model = '''
		PolicySet str_19{deny-overrides-all
			policies:
			Rule str_20(permit
			target: in(attr/str_5,set(false))
			)
			
			Rule str_21(deny
			target: in(attr/str_13,set(174))
			)
			
			Rule str_22(permit
			target: equal(attr/str_2,67) && in(attr/str_12,set(true)) && in(attr/str_5,set(false)) && in(attr/str_7,set("str_23","str_24")) && equal(attr/str_11,"str_25")
			)
		}'''.parse

		assertNoErrors(model)

		var String cns = doGenerateSMT_LIB_Test(model)

		val writer = new PrintWriter("SMT_LIB_gen/set/file1_set_string.smt2", "UTF-8");
		writer.println(cns);
		writer.close();
	}

	@Test
	def void genObligationContraint() {
		var model = '''
		PolicySet str_19{deny-overrides-all
			policies:
			Rule str_20(permit
			obl: [M log()]
			)
			obl-p: [M log()]
			obl-d: [M log()]
		}'''.parse

		assertNoErrors(model)

		var String cns = doGenerateSMT_LIB_Test(model)

		println(cns)

		val writer = new PrintWriter("SMT_LIB_gen/set/file1_obl.smt2", "UTF-8");
		writer.println(cns);
		writer.close();
	}

}
