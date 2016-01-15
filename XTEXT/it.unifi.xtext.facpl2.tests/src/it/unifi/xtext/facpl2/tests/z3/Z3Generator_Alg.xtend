package it.unifi.xtext.facpl2.tests.z3

import org.eclipse.xtext.junit4.AbstractXtextTests
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import com.google.inject.Inject
import it.unifi.xtext.facpl.generator.Z3Generator
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.junit4.util.ParseHelper
import it.unifi.xtext.facpl.facpl2.Facpl
import java.io.PrintWriter

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
class Z3Generator_Alg extends AbstractXtextTests {

	@Inject extension ParseHelper<Facpl>

	@Inject extension Z3Generator

	@Inject extension ValidationTestHelper

	/*
	 * PERMIT-OVERRIDES
	 */
	@Test
	def void genPolicy_PermiOver_Def() {
		var model = (
			'''
		PolicySet Name {permit-overrides
		target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
		policies: 
			Rule r1 (permit target: false && true && cat/id)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitOver_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_PermitOver_Comb() {
		var model = (
		'''
			PolicySet Name {permit-overrides
			target: equal(sub/id, "doctor")
			policies: 
			Rule r1 (permit 
			target: equal(act/id, "write")
			obl: [permit M log (addition(5,sub/profile))])
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitOver_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_PermitOver_Comb2() {
		var model = (
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
		}'''.parse
		)
		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitOver_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * DENY-OVERRIDES
	 */
	@Test
	def void genPolicy_DenyOver_Def() {
		var model = (
		'''PolicySet Name {deny-overrides
			target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
			policies: 
				Rule r1 (permit target: false && true && cat/id)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyOver_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_DenyOver_Comb() {
		var model = (
		'''PolicySet Name {deny-overrides
			target: equal(sub/id, "doctor")
			policies: 
				Rule r1 (permit 
					target: equal(act/id, "write")
					obl: [permit M log (addition(5,sub/profile))])
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyOver_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_DenyOver_Comb2() {
		var model = (
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
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyOver_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * DENY-UNLESS-PERMIT
	 */
	@Test
	def void genPolicy_DenyUnless_Def() {
		var model = (
		'''PolicySet Name {deny-unless-permit
			target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
			policies: 
				Rule r1 (permit target: false && true && cat/id)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyUnless_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_DenyUnless_Comb() {
		var model = (
		'''PolicySet Name {deny-unless-permit
			target: equal(sub/id, "doctor")
			policies: 
				Rule r1 (permit 
					target: equal(act/id, "write")
					obl: [permit M log (addition(5,sub/profile))])
				Rule r2 (deny 
					target: equal(act/type, 5))
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyUnless_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_DenyUnless_Comb2() {
		var model = (
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
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_DenyUnless_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * PERMIT-UNLESS-DENY
	 */
	@Test
	def void genPolicy_PermitUnless_Def() {
		var model = (
		'''PolicySet Name {permit-unless-deny
			target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
			policies: 
				Rule r1 (permit target: false && true && cat/id)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitUnless_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_PermitUnless_Comb() {
		var model = (
		'''PolicySet Name {permit-unless-deny
			target: equal(sub/id, "doctor")
			policies: 
				Rule r1 (permit 
					target: equal(act/id, "write")
					obl: [permit M log (addition(5,sub/profile))])
				Rule r2 (deny 
					target: equal(act/type, 5))
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitUnless_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_PermitUnless_Comb2() {
		var model = (
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
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_PermitUnless_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * FIRST-APPLICABLE
	 */
	@Test
	def void genPolicy_FirstApp_Def() {
		var model = (
		'''PolicySet Name {first-applicable
			target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
			policies: 
				Rule r1 (permit target: false && true && cat/id)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_FirstApp_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_FirstApp_Comb() {
		var model = (
		'''PolicySet Name {first-applicable
			target: equal(sub/id, "doctor")
			policies: 
				Rule r1 (permit 
					target: equal(act/id, "write")
					obl: [permit M log (addition(5,sub/profile))])
				Rule r2 (deny 
					target: equal(act/type, 5))
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_FirstApp_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_FirstApp_Comb2() {
		var model = (
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
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_FirstApp_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * ONE-APPLICABLE
	 */
	@Test
	def void genPolicy_OneApp_Def() {
		var model = (
		'''PolicySet Name {only-one-applicable
			target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
			policies: 
				Rule r1 (permit target: false && true && cat/id)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_OneApp_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_OneApp_Comb() {
		var model = (
		'''PolicySet Name {only-one-applicable
			target: equal(sub/id, "doctor")
			policies: 
				Rule r1 (permit 
					target: equal(act/id, "write")
					obl: [permit M log (addition(5,sub/profile))])
				Rule r2 (deny 
					target: equal(act/type, 5))
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_OneApp_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_OneApp_Comb2() {
		var model = (
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
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_OneApp_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * WEAK-CONSENSUS
	 */
	@Test
	def void genPolicy_WeakCon_Def() {
		var model = (
		'''PolicySet Name {weak-consensus
			target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
			policies: 
				Rule r1 (permit target: false && true && cat/id)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Weak_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_WeakCon_Comb() {
		var model = (
		'''PolicySet Name {weak-consensus
			target: equal(sub/id, "doctor")
			policies: 
				Rule r1 (permit 
					target: equal(act/id, "write")
					obl: [permit M log (addition(5,sub/profile))])
				Rule r2 (deny 
					target: equal(act/type, 5))
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Weak_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_WeakCon_Comb2() {
		var model = (
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
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Weak_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	/*
	 * STRONG-CONSENSUS
	 */
	@Test
	def void genPolicy_StrongCon_Def() {
		var model = (
		'''PolicySet Name {strong-consensus
			target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)
			policies: 
				Rule r1 (permit target: false && true && cat/id)
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Strong_Def.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_StrongCon_Comb() {
		var model = (
		'''PolicySet Name {strong-consensus
			target: equal(sub/id, "doctor")
			policies: 
				Rule r1 (permit 
					target: equal(act/id, "write")
					obl: [permit M log (addition(5,sub/profile))])
				Rule r2 (deny 
					target: equal(act/type, 5))
		}'''
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Strong_Comb.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

	@Test
	def void genPolicy_StrongCon_Comb2() {
		var model = (
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
		).parse

		assertNoErrors(model)

		var String cns = doGenerateZ3(model)

		val PrintWriter writer = new PrintWriter("z3_gen/genPolicy_Strong_Comb2.smt2", "UTF-8");
		writer.println(cns);
		writer.close();

	}

}
