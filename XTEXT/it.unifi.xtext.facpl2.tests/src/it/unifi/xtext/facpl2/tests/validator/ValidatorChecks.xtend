package it.unifi.xtext.facpl2.tests.validator

import com.google.inject.Inject
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.facpl2.Facpl2Package
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

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
		
		assertNoErrors(model)

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


		model = ('''
		PolicySet Name {permit-overrides 
		policies: 
				Rule r1 (permit target: equal(cat/id, 2005/43/43))
		}''').parse

		model.assertError(Facpl2Package::eINSTANCE.dateLiteral,
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

	@Test
	def void testWebExamples(){
		
		var model = '''
		PolicySet firstPolicy { permit-overrides
			target: equal ( "4567-1" , resource / id ) policies:
			Rule Rule1 ( permit target: equal ( "John" , subject / id ) && equal ( "read" , action / id ) )
			Rule RuleDeny ( deny )
		}'''.parse
		
		model.assertNoErrors()
		
		model ='''
		PolicySet permitAll { deny-overrides
			policies:
			Rule Rule1 ( permit )
		}'''.parse
		
		model.assertNoErrors()
		
		
		model ='''
		PolicySet firstPolicy_denyOverrides {deny-overrides
			 target: equal("4567-1",resource/id)
			 policies: 
				Rule RuleCondition_P (permit target: equal("John",subject/id)
					&&  in(action/id, set("read","seek")) 
				)
				Rule RuleCondition_D ( deny
					target: in(action/id, set("write","checkout"))
				)  
		}
		'''.parse
		
		model.assertNoErrors()
		
		model = '''
		PolicySet polSet { first-applicable
			policies:
			PolicySet first { deny-overrides
				target: equal ( "4567-1" , resource / id ) policies:
				Rule Rule_DenyAll ( deny )
			}
			PolicySet second { permit-overrides
				policies:
				Rule rule1 ( permit )
			}
		}'''.parse
		
		
		model.assertNoErrors()
		
		model = '''
		PolicySet polSet { only-one-applicable
			policies: 
			 PolicySet first {deny-overrides
				 target: equal("4567-1",resource/id)
				 policies:  
					Rule Rule_DenyAll (deny)  
			  }
			  PolicySet second {permit-overrides 
			  	policies: Rule rule1 (permit)
			  }
		}'''.parse
		
		
		model.assertNoErrors()
		
		model = '''
		PolicySet obligation_1 { deny-overrides
			target: equal ( "4567-1" , resource / id ) policies:
			Rule RuleP ( permit target: equal ( "John" , subject / id ) && in ( action / id , set( "read" , "seek" ) ) 
				
				obl:
				[  M action1 ( subject / name ) ]
			)
			Rule RuleD ( deny target: in ( action / id , set( "write" , "checkout" ) ) 
				obl:
				[  M action2 ( subject / name ) ]
			)
			obl-p:
			[ M log ( "Resource accessed: " , resource / id ) ]
		}'''.parse
		
		model.assertNoErrors()
		
		model = '''
		PolicySet polSet { permit-overrides
			policies:
			PolicySet obligation_1 { deny-overrides
				target: equal ( "4567-1" , resource / id ) policies:
				Rule RuleP ( permit target: equal ( "John" , subject / id ) && in ( action / id , set( "read" , "seek" ) ) 
					obl:
					[ M action1 ( subject / name ) ]
				)
				Rule RuleD ( deny target: equal ( "Mark" , subject / id ) && in ( action / id , set( "write" , "checkout" ) ) 
					obl:
					[ M action2 ( subject / name ) ]
				)
			}
			PolicySet obligation_2 { permit-overrides
				policies:
				Rule rule1 ( deny )
				obl-d:
				[ M log ( "Subject: " , subject / id , subject / name ) ]
			}
			obl-p:
			[ M log ( "Resource accessed: " , resource / id ) ]
			obl-d:
			[ M log ( "Resource requested: " , resource / id ) ]
		}'''.parse
		
		model.assertNoErrors()
		
	}

}
