package it.unifi.xtext.facpl2.tests.type

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
class TypeCheck_Test {

	@Inject extension ParseHelper<Facpl>
	@Inject extension ValidationTestHelper

	@Test
	def void testFunctionEqual() {
		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			equal(5, true)
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			not-equal(5, true)
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			equal(cat/id, true)
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			not-equal(cat/id, true && false)
		)
		}'''.parse

		model.assertNoErrors

	}

	@Test
	def void testFunctionComparison() {
		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			greater-than(5, true)
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			less-than(5, true)
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			less-than(cat/id, true)
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			less-than-or-equal(cat/id, cat/id)
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			less-than-or-equal(5, cat/id)
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			less-than-or-equal(5, 2015/12/10)
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			greater-than-or-equal(2000/12/12, 2015/12/10)
		)
		}'''.parse

		model.assertNoErrors
	}

	@Test
	def void testFunctionArith() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			addition(5, true)
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			addition(5, cat/id)
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			addition(5, subtract(10, cat/id))
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			divide(5, true && subtract(10, cat/id))
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			multiply(5, cat/id && subtract(10, cat/id))
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

	}

	@Test
	def void testFunctionIn() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(5, set(5,5))	)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(true, set(5,5))	)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(n/id, set(5,5))	)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(n/id, set(5,5)) && equal(n/id, 5)	)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(n/id, set(5,5)) && equal(n/id, true)	)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

	}

	@Test
	def void testFunctionset() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			in(5, set(5,5))
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			in(5, set(5,true))
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.set,
			null,
			"set elements have to be of the same type"
		)

//		model.assertError(
//			Facpl2Package::eINSTANCE.function,
//			null,
//			"Expression cannot be typed"
//		)
		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			in(set(5), set(5,10))
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			in(cat/id, set(5,10))
		)
		}'''.parse

		model.assertNoErrors

	}

	@Test
	def void testFunctionEqual_Ext() {
		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			equal(5, n/id)
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit target: equal(5, n/id))
		Rule name1 (permit target: equal(true, n/id))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)
	}

	@Test
	def void testDeclaredFunction() {

		var model = '''
		dec-fun Bool F_Name (String)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: F_Name(5))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.declaredFunction,
			null,
			"Type mismatch: expected (String) but was (Int)"
		)

		model = '''
		dec-fun Bool F_Name (String, Bool)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: F_Name("5"))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.declaredFunction,
			null,
			"Invalid number of arguments"
		)

		model = '''
		dec-fun Bool F_Name (String, Bool)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: F_Name("foo",n/id))
		}'''.parse

		model.assertNoErrors

		model = '''
		dec-fun Bool F_Name (String, Bool)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: F_Name(n/id1,n/id))
		}'''.parse

		model.assertNoErrors
		model = '''
		dec-fun Bool F_Name (String, Bool)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: F_Name(n/id,n/id))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.declaredFunction,
			null,
			"Type mismatch: type for argument 'n/id' cannot be inferred"
		)

		model = '''
		dec-fun Bool F_Name (String, Bool)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: equal(5,n/id) && F_Name(n/string,n/id))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.declaredFunction,
			null,
			"Type mismatch: type for argument 'n/id' cannot be inferred"
		)

		model = '''
		dec-fun Bool F_Name (String, Int)
		
		dec-fun Int F (Int, Int)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: equal(5,n/id) && F_Name(n/string,F(5, n/id)))
		}'''.parse

		model.assertNoErrors()

		model = '''
		dec-fun Bool F_Name (String, Double)
		
		dec-fun Int F (Int, Int)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: equal(5,n/id) && F_Name(n/string,F(5, n/id)))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.declaredFunction,
			null,
			"Type mismatch: expected (String,Double) but was (String,Int)"
		)

	}

	@Test
	def void testsetFunDecl() {

		var model = '''
		dec-fun Bool F_Name (String, Int) 
		
		dec-fun Set<Int> F (Int, Int) 
		
		PolicySet Name {deny-unless-permit
				target: F_Name(sub/id, F(n/id, 5))
						policies: 
							Rule r1 (permit)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.declaredFunction,
			null,
			"Type mismatch: expected (String,Int) but was (String,set_int)"
		)

		model = '''
		dec-fun Bool F_Name (String, Int) 
		
		dec-fun Set<Int> F (Int, Int) 
		
		PolicySet Name {deny-unless-permit
				target: in(sub/id, F(n/id, 5))
						policies: 
							Rule r1 (permit)
		}'''.parse

		model.assertNoErrors

		model = '''
		dec-fun Bool F_Name (String, Int) 
		
		dec-fun Set<Bool> F (Int, Int) 
		
		PolicySet Name {deny-unless-permit
				target: in(sub/id, F(n/id, 5)) && equal(sub/id, 5)
						policies: 
							Rule r1 (permit)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		dec-fun Bool F_Name (String, Int)
		
		dec-fun Int F (Int, Int)
		
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: equal(5,n/id) && F_Name(n/string,F(5, n/id)) || F_Name(n/string,F(n/id1, n/id3)))
		}'''.parse

		model.assertNoErrors

		model = '''
			dec-fun Bool F_Name (String, Int) 
			
			dec-fun Set<Int> F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
					target: in(sub/id, F(n/id, 5))
							policies: 
								Rule r1 (permit)
			}
		'''.parse

		model.assertNoErrors

	}

	@Test
	def void checkDateTime() {

		var model = '''
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: equal(08:00:00, 09:00:00))
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: greater-than(08:00:00, 09:00:00))
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: greater-than(sys/date, 09:00:00))
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: greater-than(2015/10/12, 09:00:00))
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: greater-than(2015/10/12, n/id))
				Rule r2 (deny target: equal(true, n/id)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

	}

	@Test
	def checkDateTime2() {

		var model = '''
		PolicySet Name {deny-unless-permit
		policies:
		Rule time ( permit 
			target: greater-than-or-equal ( 01:00:00 , environment / time ) || less-than ( 06:00:00 , environment / time )			
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet Name {deny-unless-permit
		policies:
		Rule time ( permit 
			target: greater-than-or-equal ( 01:00:00 , n/id ) || less-than ( 06:00:00 , environment / time )			
		)
		Rule time2 (permit target: equal(n/id, 2015/12/12))
		}'''.parse

		model.assertNoErrors

	}

	@Test
	def declaredFunctionDate() {

		var model = '''
		dec-fun Bool F (DateTime, DateTime)
		
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: F(08:00:00, 09:00:00))
		}'''.parse

		model.assertNoErrors

		model = '''
		dec-fun Bool F (DateTime, DateTime)
		
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: F(sys/env, 09:00:00))
		}'''.parse

		model.assertNoErrors

		model = '''
		dec-fun Int F (DateTime, DateTime)
		
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: F(sys/env, 09:00:00))
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.rule,
			null,
			"Target Expression evaluates to a not-boolean value. This element evaluates to indeterminate"
		)

		model = '''
		dec-fun Bool F (DateTime, DateTime)
		
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: F(sys/env, 09:00:00) && equal(sys/env, true))
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.declaredFunction,
			null,
			"Type mismatch: type for argument 'sys/env' cannot be inferred"
		)

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		dec-fun Bool F (DateTime, DateTime)
		dec-fun DateTime F2 (Int, Int)
		
		PolicySet Name {deny-unless-permit
			policies: 
				Rule r1 (permit target: F(F2(5,sys/time), 09:00:00) && equal(sys/env, true))
		}'''.parse

		model.assertNoErrors

	}

	@Test
	def intFun() {

		var model = '''
			PolicySet Name {permit-overrides 
				policies: 
				Rule r1 (permit target: addition(cat/id,cat1/id))
			}
		'''.parse

		model.assertNoErrors
		
		model.assertWarning(
			Facpl2Package::eINSTANCE.rule,
			null,
			"Target Expression evaluates to a not-boolean value. This element evaluates to indeterminate"
		)

	}
	
	@Test
	def oblFun(){
		
		var model = ('''
		PolicySet Name {permit-overrides 
		policies: 
			Rule r1 (permit target: true
			
			obl: [permit M log(5,6.6,false, cat/id,"prova")])
		}'''
		).parse

		assertNoErrors(model)
	}
	
	@Test
	def setString(){
		var model ='''
		PolicySet Name {permit-overrides
		target: in ( subject / fedoraRole ,	set( "researcher" , "professor" , "administrator" )) 
				policies: 
				Rule id_1 ( deny target: ( ( equal ( "urn:fedora:names:fedora:2.1:action:id-getDatastreamDissemination" , action / id
								) ) ) && ( ( equal ( "demo:11" , resource / resource_id ) && equal ( "DS1" , resource / id ) ) || ( equal (
									"demo:11" , resource / resource_id ) && equal ( "RIGHTS1" , resource / id ) ) ) &&
									 ! ( in ( subject / fedoraRole ,
								set( "researcher" , "professor" , "administrator" ) ) ) 
							)
		}'''.parse
		
		assertNoErrors(model)
	}
}
