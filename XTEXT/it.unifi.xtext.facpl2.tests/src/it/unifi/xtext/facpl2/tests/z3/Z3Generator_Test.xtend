package it.unifi.xtext.facpl2.tests.z3

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import org.eclipse.xtext.junit4.AbstractXtextTests
import it.unifi.xtext.facpl.facpl2.Facpl
import org.eclipse.xtext.junit4.util.ParseHelper
import com.google.inject.Inject
import org.junit.Test
import java.io.PrintWriter
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import it.unifi.xtext.facpl.generator.Z3Generator

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
public class Z3Generator_Test extends AbstractXtextTests {

	@Inject extension ParseHelper<Facpl>

	@Inject extension Z3Generator

	@Inject extension ValidationTestHelper

	@Test
	def void genAttribute() {
		var model = ('''
		PolicySet Name {permit-overrides 
		policies: 
				Rule r1 (permit target: cat/id)
		}''').parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

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

		cns = doGenerateZ3(model)

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
		assertNotNull("Policy Name is not well-typed", doGenerateZ3(model))

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

		cns = doGenerateZ3(model)

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

		var String cns = doGenerateZ3(model)

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

		cns = doGenerateZ3(model)

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

		var String cns = doGenerateZ3(model)

		System.out.println(cns)

		/*
		 * Non assigned attribute considered as boolean
		 */
		if (cns.contains('''(declare-datatypes () ((String s_prova s_pharmacist s_doc )))''')) {
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
			dec-fun Bag F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
					target: F_Name(sub/id, "doctor")
							policies: 
								Rule r1 (permit)
			}''').parse

			var flag = false
			try {
				doGenerateZ3(model)
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
			
			dec-fun Bag<Int> F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
				target: F_Name(sub/id, 5)
					policies: 
						Rule r1 (permit)
			}''').parse

			var cns = doGenerateZ3(model)

			var PrintWriter writer = new PrintWriter("z3_gen/decFun/file1.smt2", "UTF-8");
			writer.println(cns);
			writer.close();

			model = (
				'''
			dec-fun Bool F_Name (String, Int) 
			
			dec-fun Bag<Int> F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
					target: in(sub/id, F(n/id, 5))
							policies: 
								Rule r1 (permit)
			}'''
			).parse

			cns = doGenerateZ3(model)

//			System.out.println(cns)
			writer = new PrintWriter("z3_gen/decFun/file2.smt2", "UTF-8");
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

			cns = doGenerateZ3(model)

			writer = new PrintWriter("z3_gen/decFun/file3.smt2", "UTF-8");
			writer.println(cns);
			writer.close();

		} catch (Exception e) {
			System.out.println(e.message)
			assertEquals(false, true)
		}

	}

	@Test
	def void genBags() {
		
		var model = (
		'''
		PolicySet pSet {deny-unless-permit 
		policies:
			Rule name (permit target: in(5,n/id) 
		}''').parse

		var cns = doGenerateZ3(model)

		var writer = new PrintWriter("z3_gen/decBag/file1.smt2", "UTF-8");
		writer.println(cns);
		writer.close();
	}

}
