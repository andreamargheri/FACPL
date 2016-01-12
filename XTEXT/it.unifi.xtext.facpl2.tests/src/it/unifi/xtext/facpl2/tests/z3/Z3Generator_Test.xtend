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
import it.unifi.xtext.facpl.generator.Z3Generator
import java.io.PrintWriter

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
public class Z3Generator_Test extends AbstractXtextTests {

	@Inject
	ParseHelper<Facpl> parser

	@Inject
	Z3Generator generator

	@Test
	def void genAttribute() {
		var model = parser.parse(
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		/*
		 * Non assigned attribute considered as Bool
		 */
		if (cns.contains('''(declare-const n_cat/id (TValue Bool))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

		/*
		 * Two boolean attributes 
		 */
		model = parser.parse(
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: cat/id && cat1/id)
  	}'''
		)
		cns = generator.doGenerateZ3(model)

		if (cns.contains('''(declare-const n_cat1/id (TValue Bool))''') &&
			cns.contains('''(declare-const n_cat/id (TValue Bool))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

		/*
		 * Failed Type Inference
		 */
		model = parser.parse(
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: addition(cat/id,cat1/id))
  	}'''
		)
		assertNotNull("Policy Name is not well-typed", generator.doGenerateZ3(model))

		/*
		 * Two Bool and Int
		 */
		model = parser.parse(
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: cat/id && equal(cat1/id,5))
  	}'''
		)
		cns = generator.doGenerateZ3(model)

		if (cns.contains('''(declare-const n_cat1/id (TValue Int))''') &&
			cns.contains('''(declare-const n_cat/id (TValue Bool))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}
	}

	@Test
	def void genAttributeConstants() {
		var model = parser.parse(
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: true)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		System.out.println(cns)

		/*
		 * Non assigned attribute considered as Bool
		 */
		if (cns.contains('''(declare-const const_true (TValue Bool))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

		model = parser.parse(
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: true
  			obl: [permit M log(5,6.6,false, cat/id,"prova")]
  	}'''
		)

		cns = generator.doGenerateZ3(model)

		System.out.println(cns)

		/*
		 * Non assigned attribute considered as Bool
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
		var model = parser.parse(
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: equal("prova",cat/id) && equal("doc","pharmacist") )
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		System.out.println(cns)

		/*
		 * Non assigned attribute considered as Bool
		 */
		if (cns.contains('''(declare-datatypes () ((String s_prova s_doc s_pharmacist )))''')) {
			assertEquals(true, true)
		} else {
			assertEquals(false, true)
		}

	}

	/*
	 * PERMIT-OVERRIDES
	 */
	@Test
	def void genPolicy_PermiOver_Def() {
		var model = parser.parse(
			'''PolicySet Name {permit-overrides
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
  		policies: 
  			Rule r1 (permit target: false && true && cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitOver_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_PermitOver_Comb() {
		var model = parser.parse(
			'''PolicySet Name {permit-overrides
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitOver_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_PermitOver_Comb2() {
		var model = parser.parse(
			'''PolicySet Name {permit-overrides
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny)
  			Rule r3 (permit)
  			Rule r4 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitOver_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * DENY-OVERRIDES
	 */
	@Test
	def void genPolicy_DenyOver_Def() {
		var model = parser.parse(
			'''PolicySet Name {deny-overrides
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
  		policies: 
  			Rule r1 (permit target: false && true && cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyOver_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_DenyOver_Comb() {
		var model = parser.parse(
			'''PolicySet Name {deny-overrides
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyOver_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_DenyOver_Comb2() {
		var model = parser.parse(
			'''PolicySet Name {deny-overrides
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny)
  			Rule r3 (permit)
  			Rule r4 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyOver_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * DENY-UNLESS-PERMIT
	 */
	@Test
	def void genPolicy_DenyUnless_Def() {
		var model = parser.parse(
			'''PolicySet Name {deny-unless-permit
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
  		policies: 
  			Rule r1 (permit target: false && true && cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyUnless_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_DenyUnless_Comb() {
		var model = parser.parse(
			'''PolicySet Name {deny-unless-permit
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyUnless_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_DenyUnless_Comb2() {
		var model = parser.parse(
			'''PolicySet Name {deny-unless-permit
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  			Rule r3 (deny 
  				target: equal(act/type, 6))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyUnless_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * PERMIT-UNLESS-DENY
	 */
	@Test
	def void genPolicy_PermitUnless_Def() {
		var model = parser.parse(
			'''PolicySet Name {permit-unless-deny
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
  		policies: 
  			Rule r1 (permit target: false && true && cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitUnless_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_PermitUnless_Comb() {
		var model = parser.parse(
			'''PolicySet Name {permit-unless-deny
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitUnless_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_PermitUnless_Comb2() {
		var model = parser.parse(
			'''PolicySet Name {permit-unless-deny
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  			Rule r3 (deny 
  				target: equal(act/type, 6))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitUnless_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}
	
	
	/*
	 * FIRST-APPLICABLE
	 */
	@Test
	def void genPolicy_FirstApp_Def() {
		var model = parser.parse(
			'''PolicySet Name {first-applicable
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
  		policies: 
  			Rule r1 (permit target: false && true && cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_FirstApp_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_FirstApp_Comb() {
		var model = parser.parse(
			'''PolicySet Name {first-applicable
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_FirstApp_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_FirstApp_Comb2() {
		var model = parser.parse(
			'''PolicySet Name {first-applicable
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  			Rule r3 (deny 
  				target: equal(act/type, 6))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_FirstApp_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}
	
	
	/*
	 * ONE-APPLICABLE
	 */
	@Test
	def void genPolicy_OneApp_Def() {
		var model = parser.parse(
			'''PolicySet Name {only-one-applicable
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
  		policies: 
  			Rule r1 (permit target: false && true && cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_OneApp_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_OneApp_Comb() {
		var model = parser.parse(
			'''PolicySet Name {only-one-applicable
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_OneApp_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_OneApp_Comb2() {
		var model = parser.parse(
			'''PolicySet Name {only-one-applicable
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  			Rule r3 (deny 
  				target: equal(act/type, 6))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_OneApp_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * WEAK-CONSENSUS
	 */
	@Test
	def void genPolicy_WeakCon_Def() {
		var model = parser.parse(
			'''PolicySet Name {weak-consensus
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
  		policies: 
  			Rule r1 (permit target: false && true && cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Weak_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_WeakCon_Comb() {
		var model = parser.parse(
			'''PolicySet Name {weak-consensus
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Weak_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_WeakCon_Comb2() {
		var model = parser.parse(
			'''PolicySet Name {weak-consensus
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  			Rule r3 (deny 
  				target: equal(act/type, 6))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Weak_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * STRONG-CONSENSUS
	 */
	@Test
	def void genPolicy_StrongCon_Def() {
		var model = parser.parse(
			'''PolicySet Name {strong-consensus
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
  		policies: 
  			Rule r1 (permit target: false && true && cat/id)
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Strong_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_StrongCon_Comb() {
		var model = parser.parse(
			'''PolicySet Name {strong-consensus
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Strong_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_StrongCon_Comb2() {
		var model = parser.parse(
			'''PolicySet Name {strong-consensus
		target: equal(sub/id, "doctor")
  		policies: 
  			Rule r1 (permit 
  				target: equal(act/id, "write")
  				obl: [permit M log (addition(5,sub/profile))])
  			Rule r2 (deny 
  				target: equal(act/type, 5))
  			Rule r3 (deny 
  				target: equal(act/type, 6))
  	}'''
		)

		var String cns = generator.doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Strong_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genDeclaredFunction(){
		var model = parser.parse(
			'''
			dec-fun Bool F_Name (String, Int) 
			dec-fun Bool F_Name2 (String, Bool)
			dec-fun Bag F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
					target: F_Name(sub/id, "doctor")
			  		policies: 
			  			Rule r1 (permit )
			}'''
		)
		
		var String cns = generator.doGenerateZ3(model)
		
		val PrintWriter writer = new PrintWriter("z3_gen/decFun/file1.smt2", "UTF-8");
		writer.println(cns);
		writer.close();
		
	}
	

}
