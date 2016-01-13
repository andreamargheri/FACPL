package it.unifi.xtext.facpl2.tests.type

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
		Rule name (permit target: in(5, bag(5,5))	)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(true, bag(5,5))	)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(n/id, bag(5,5))	)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(n/id, bag(5,5)) && equal(n/id, 5)	)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit target: in(n/id, bag(5,5)) && equal(n/id, true)	)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.function,
			null,
			"Expression cannot be typed"
		)

	}

	@Test
	def void testFunctionBag() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			in(5, bag(5,5))
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			in(5, bag(5,true))
		)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.bag,
			null,
			"Bag elements have to be of the same type"
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
			in(bag(5), bag(5,10))
		)
		}'''.parse

		model.assertNoErrors

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies:
		Rule name (permit 
		target: 
			in(cat/id, bag(5,10))
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
	def void testBagFunDecl() {

		var model = '''
		dec-fun Bool F_Name (String, Int) 
		
		dec-fun Bag<Int> F (Int, Int) 
		
		PolicySet Name {deny-unless-permit
				target: F_Name(sub/id, F(n/id, 5))
						policies: 
							Rule r1 (permit)
		}'''.parse

		model.assertError(
			Facpl2Package::eINSTANCE.declaredFunction,
			null,
			"Type mismatch: expected (String,Int) but was (String,Bag_int)"
		)

		model = '''
		dec-fun Bool F_Name (String, Int) 
		
		dec-fun Bag<Int> F (Int, Int) 
		
		PolicySet Name {deny-unless-permit
				target: in(sub/id, F(n/id, 5))
						policies: 
							Rule r1 (permit)
		}'''.parse

		model.assertNoErrors

		model = '''
		dec-fun Bool F_Name (String, Int) 
		
		dec-fun Bag<Bool> F (Int, Int) 
		
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
			
			dec-fun Bag<Int> F (Int, Int) 
			
			PolicySet Name {deny-unless-permit
					target: in(sub/id, F(n/id, 5))
							policies: 
								Rule r1 (permit)
			}
		'''.parse
		
		model.assertNoErrors
		
	}
}
