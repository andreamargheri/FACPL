package it.unifi.xtext.facpl2.tests.xacml

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import org.eclipse.xtext.junit4.XtextRunner
import com.google.inject.Inject
import it.unifi.xtext.facpl.facpl2.Facpl
import org.eclipse.xtext.junit4.util.ParseHelper
import it.unifi.xtext.facpl.generator.XMLGenerator
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import it.unifi.jaxb.xacml.ParserXACMLEntryPoint
import java.io.PrintWriter
import it.unifi.xtext.facpl.validation.Facpl2Xacml_Validator
import org.eclipse.xtext.junit4.AbstractXtextTests

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
	
	
	@Test
	def checkEHealth(){
		var model = '''
		PolicySet patientConsent { permit-overrides
			target: equal ( "Alice" , resource / patient-id ) 
			policies:
			PolicySet ePre { permit-overrides - all
				target:equal("e-Prescription",resource/type)
				policies:
				Rule writeDoc ( permit target: equal ( subject / role , "doctor" ) 
					&& equal ( action / id , "write" ) 
					&& in ("e-Pre-Write" , subject / permission ) 
					&& in ( "e-Pre-Read" , subject / permission ) )
				Rule readDoc ( permit target: equal ( subject / role , "doctor" )
					&& equal ( action / id , "read" ) 
					&& in ( "e-Pre-Read", subject / permission ) )
				Rule readPha ( permit target: equal ( subject / role , "pharmacist" ) 
					&& equal ( action / id , "read" ) 
					&& in ("e-Pre-Read" , subject / permission ) )
				obl:
				[ permit M log ( system / time , resource / type , subject / id , action / id ) ]
			}
			Rule denyRule ( deny )
			obl:
			[ deny M mailTo ( resource / patient-id.mail , "Data requested by unauthorized subject" ) ]
			[ permit O compress ( ) ]
		}
		'''.parse
		
		assertEquals(stubCheckXACML(model, "eHealth"), true)
		
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
