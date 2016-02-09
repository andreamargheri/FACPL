package it.unifi.xtext.facpl2.tests.xacml

import com.google.inject.Inject
import it.unifi.jaxb.xacml.ParserXACMLEntryPoint
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.generator.XMLGenerator
import it.unifi.xtext.facpl.validation.Facpl2Xacml_Validator
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
class XACMLtranslation_Test extends AbstractXtextTests {

	@Inject extension ParseHelper<Facpl>
	
	@Inject extension XMLGenerator

	@Inject extension ValidationTestHelper

	private int counter = 0;

	def int getId() {
		this.counter++
		return this.counter
	}

	private Facpl2Xacml_Validator xacml_val = new Facpl2Xacml_Validator()

	@Test
	def void checkPolicySet() {
		var model = '''
		PolicySet Name {permit-overrides 
			policies: 
				Rule r1 (permit target: cat/id)
		}'''.parse

		assertEquals(stubCheckXACML(model, "PSet"), true)

		model = '''
		PolicySet Name {permit-overrides 
			target: equal(true,cat/id)
			policies: 
				Rule r1 (permit target: cat/id)
		}'''.parse

		assertEquals(stubCheckXACML(model, "PSet"), true)

		model = '''
		PolicySet Name {permit-overrides 
			target: equal(true,cat/id) && less-than(4,n/id)
			policies: 
				Rule r1 (permit target: cat/id)
		}'''.parse

		assertEquals(stubCheckXACML(model, "PSet"), true)

		model = '''
		PolicySet Name {deny-unless-permit 
			policies: 
				Rule r1 (permit target: less-than(4,addition(4,5)))
				Rule r2 (permit target: cat/id)
		}'''.parse

		assertEquals(stubCheckXACML(model, "PSet"), true)

		model = '''
		PolicySet Name {deny-unless-permit 
			target: equal(true,cat/id) && less-than(4,n/id)
			policies: 
				Rule r1 (permit target: cat/id)
				Rule r2 (permit target: cat/id)
				PolicySet Name2 {deny-unless-permit 
							target: equal(false,cat/id) 
							policies:
							Rule r4 (permit target: equal(addition(5,5),n/num))
				}
		}'''.parse

		assertEquals(stubCheckXACML(model, "PSet"), true)

	}

	@Test
	def void checkObl() {
		var model = '''
		PolicySet Name {permit-overrides 
			policies: 
				Rule r1 (permit target: true)
			obl: 
			[permit M mail(cat/id)]
		}'''.parse

		assertEquals(stubCheckXACML(model, "Obl"), true)

		model = '''
		PolicySet Name {permit-overrides 
			policies: 
				Rule r1 (permit target: true)
			obl: 
			[permit M mail(cat/id, true, 5, addition(4,5))]
		}'''.parse

		assertEquals(stubCheckXACML(model, "Obl"), true)

		model = '''
		PolicySet Name {permit-overrides 
			policies: 
				Rule r1 (permit target: true)
			obl: 
			[permit M mail(cat/id, true, 5, addition(4,5))]
			[deny O mail(cat/id, true, 5, addition(4,5))]
		}'''.parse

		assertEquals(stubCheckXACML(model, "Obl"), true)

	}

	/**
	 * Aux methods for checking XACML policies
	 */
	def stubCheckXACML(Facpl model, String str) {
		var id = str + getId()
		System.out.println("Validating Policy of case " + id + " ....")

		assertNoErrors(model)

		/*
		 * Check if the policy can be translated into a XACML one
		 */
		var test = xacml_val.isXACML_Formed(model)

		System.out.println("-> Well-Formed for XACML " + test)

		assertEquals(test, true)

		val xacml = doGenerateXACML_StubTest(model)

		var file_id = "xacml_gen/" + id + ".xml"

		val writer = new PrintWriter(file_id, "UTF-8");
		writer.println(xacml);
		writer.close();
  
		/*
		 * Test if the XACML policy is well-formed
		 */
		try {
			ParserXACMLEntryPoint.parseXACML(file_id)
			System.out.println("->Parsing OK")
			System.out.println("...end Validating Policy of case " + id)
			return true
		} catch (Exception e) {
			System.out.println("->Parsing Error")
			System.out.println("...end Validating Policy of case " + id)
			return false
		}
	}

}
