package it.unifi.xtext.facpl2.tests.validator

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import com.google.inject.Inject
import it.unifi.xtext.facpl.facpl2.Facpl
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import it.unifi.xtext.facpl.facpl2.Facpl2Package

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Facpl2InjectorProvider))
class ValidatorChecks {

	@Inject extension ParseHelper<Facpl>
	@Inject extension ValidationTestHelper

	@Test
	def void testPolicyNames() {
		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
			Rule name (permit )
			Rule name (deny)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.rule,
			null,
			"Duplicate policy name 'name'"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
			Rule pSet (permit )
			Rule name (deny)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.rule,
			null,
			"Duplicate policy name 'pSet'"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
			Rule r1 (permit )
			Rule r2 (deny)
		}'''.parse

		model.assertNoErrors

		model = '''
			PolicySet pSet {deny-unless-permit 
			policies: 
				Rule r1 (permit )
				Rule r2 (deny)
			}
			
			PolicySet r1 {deny-unless-permit 
			policies: 
				Rule r2 (permit)
			}
		'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.rule,
			null,
			"Duplicate policy name 'r2'"
		)

		model.assertError(
			Facpl2Package::eINSTANCE.policySet,
			null,
			"Duplicate policy name 'r1'"
		)

		model.assertError(
			Facpl2Package::eINSTANCE.rule,
			null,
			"Duplicate policy name 'r1'"
		)

	}

	@Test
	def void testRequests() {
		var model = '''
			Request:{ Name
				(subject/profile-id , "S")
			}
		'''.parse

		model.assertNoErrors

		model = '''
			Request:{ Name
				(subject/profile-id , "S")
			}
			
			Request:{ Name
						(subject/profile-id , "S")
					}
		'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.request,
			null,
			"Duplicate request name 'Name'"
		)

		model = '''
			Request:{ Name
						(subject/profile-id , "S", 5)
					}
		'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.attributeReq,
			null,
			"Type mismatch: all set elements must be of the same type"
		)

		model = '''
			Request:{ Name
						(subject/profile-id , n/id)
					}
		'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.attributeReq,
			null,
			"Type mismatch: request attribute cannot be names"
		)

		model = '''
			Request:{ Name
						(subject/profile-id , "S",n/id)
					}
		'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.attributeReq,
			null,
			"Type mismatch: request attribute cannot be names"
		)

	}

	@Test
	def void testDate() {
		var model = '''
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: greater-than(20/12/2015, 09:00:00))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.dateLiteral,
			null,
			"Error date value. Must be yyyy/MM/dd"
		)

		model = '''
		PolicySet Name {deny-unless-permit
		 			policies: 
		 				Rule r1 (permit target: greater-than(2015/12/12, 27:00:00))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.timeLiteral,
			null,
			"Error time value. Must be HH:mm:ss"
		)

		model = '''
		PolicySet Name {deny-unless-permit
		 			policies: 
		 				Rule r1 (permit target: greater-than(2015/14/12, 23:60:00))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.timeLiteral,
			null,
			"Error time value. Must be HH:mm:ss"
		)

		model.assertError(
			Facpl2Package::eINSTANCE.dateLiteral,
			null,
			"Error date value. Must be yyyy/MM/dd"
		)

	}

	@Test
	def void testSet() {
		var model = '''
			PolicySet pSet {deny-unless-permit 
			policies:
				Rule name (permit target: in(5,set(5,6))) 
			}
		'''.parse

		assertNoErrors(model)

		model = '''
			PolicySet pSet {deny-unless-permit 
			policies:
				Rule name (permit target: in(5,set(5,true))) 
			}
		'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.set,
			null,
			"Set elements have to be of the same type"
		)
		
		model = '''
			PolicySet pSet {deny-unless-permit 
			policies:
				Rule name (permit target: in(5,set(5,n/id))) 
			}
		'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.set,
			null,
			"Sets cannot contain attribute name"
		)
		
		model = '''
			PolicySet pSet {deny-unless-permit 
			policies:
				Rule name (permit target: in(5,set(5,set(true)))) 
			}
		'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.set,
			null,
			"Sets cannot contain other sets"
		)


	}

}
