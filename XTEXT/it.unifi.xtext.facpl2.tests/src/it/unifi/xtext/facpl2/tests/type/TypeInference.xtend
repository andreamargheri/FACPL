package it.unifi.xtext.facpl2.tests.type

import com.google.inject.Inject
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import it.unifi.xtext.facpl.facpl2.Facpl
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import it.unifi.xtext.facpl.validation.FacplType
import it.unifi.xtext.facpl.facpl2.Facpl2Package

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Facpl2InjectorProvider))
/**
 * Test draft used during development - NOT RUNNING
 */
class TypeInference {

	@Inject extension ParseHelper<Facpl>
	@Inject extension ValidationTestHelper

	@Test
	def void testPolicy() {
		var model = '''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: equal("prova",cat/id) && equal("doc","pharmacist") )
  	}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.andExpression,
			null,
			FacplType.BOOLEAN.toString
		)

	}

	@Test
	def void testFunctionINT() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			addition(5, cat/id)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.INT.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"SUB:cat/id -> INT"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			addition(cat/id1, cat/id2)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.INT.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"SUB:cat/id2 -> null cat/id1 -> INT"
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"EQ:cat/id1 = cat/id2"
		)

	}

	@Test
	def void testFunctionBOOL() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			equal(5, cat/id)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"cat/id -> INT"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			equal(cat/id1, cat/id2)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"EQ:cat/id1 = cat/id2"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			equal(cat/id1, addition(5,cat/id2))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"SUB:cat/id2 -> INT cat/id1 -> INT"
		)
	}

	@Test
	def void testFunctionLESSGRE() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			less-than(5, cat/id)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"cat/id -> INT"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			less-than(cat/id1, cat/id2)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"SUB:cat/id2 -> null cat/id1 -> INT"
		)
		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"EQ:cat/id1 = cat/id2"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			less-than(cat/id1, addition(5,cat/id2))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"SUB:cat/id2 -> INT cat/id1 -> INT"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			less-than(cat/id1, equal(5,cat/id2))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.ERR.toString
		)

	}

	@Test
	def void checkUnAssigned() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			equal(cat/id1, less-than(5,cat/id1))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.ERR.toString
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			equal(cat/id1, equal(true,cat/id1))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"SUB:cat/id1 -> BOOLEAN"
		)

	}

//	@Test
//	def void checkAttribute() {
//
//		var model = '''
//		PolicySet pSet {deny-unless-permit 
//		policies: 
//		Rule name (permit 
//		target: 
//			cat/id1 
//		)
//		}'''.parse
//
//		model.assertWarning(
//			Facpl2Package::eINSTANCE.attributeName,
//			null,
//			FacplType.NAME.toString
//		)
//
//		model.assertWarning(
//			Facpl2Package::eINSTANCE.attributeName,
//			null,
//			"SUB:cat/id1 -> null"
//		)
//	}
	@Test
	def void checkAnd() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			cat/id1 && cat/id2
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.andExpression,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.andExpression,
			null,
			"SUB:cat/id2 -> null cat/id1 -> BOOLEAN"
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.andExpression,
			null,
			"EQ:cat/id1 = cat/id2"
		)
	}

	@Test
	def void checkOr() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			 cat/id2 || true
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.orExpression,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.orExpression,
			null,
			"SUB:cat/id2 -> BOOLEAN"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			cat/id1 || (cat/id2 && equal(5,cat/id3))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.orExpression,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.orExpression,
			null,
			"SUB:cat/id3 -> INT cat/id2 -> BOOLEAN cat/id1 -> BOOLEAN"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			cat/id1 || (cat/id2 && equal(5,cat/id1))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.orExpression,
			null,
			FacplType.ERR.toString
		)

	}

	@Test
	def void checkNot() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			 !cat/id2
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.notExpression,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.notExpression,
			null,
			"SUB:cat/id2 -> BOOLEAN"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			 !true
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.notExpression,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.notExpression,
			null,
			"SUB:"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			 ! cat/id || equal(5, cat/id)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.notExpression,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.orExpression,
			null,
			FacplType.ERR.toString
		)

	}

	@Test
	def void checkSet() {
		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			set(cat/id1, cat/id2)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			FacplType.SET_NAME.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			"SUB:"
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			"EQ:cat/id1 = cat/id2"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			set(cat/id1, cat/id2, cat/id3)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			FacplType.SET_NAME.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			"SUB:"
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			"EQ:cat/id2 = cat/id3 cat/id1 = cat/id2"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			set(cat/id1, cat/id2, 5.5)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			FacplType.SET_DOUBLE.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			"SUB:cat/id2 -> DOUBLE cat/id1 -> DOUBLE"
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			"EQ:"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			set(cat/id1, cat/id2, 5.5, true)
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			FacplType.ERR.toString
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			set(cat/id1, cat/id2, 5.5) || cat/id1 
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			FacplType.SET_DOUBLE.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.orExpression,
			null,
			FacplType.ERR.toString
		)
	}

	@Test
	def void checkInFunction() {

		var model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			in(cat/id3, set(cat/id1, cat/id2))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			FacplType.SET_NAME.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"SUB:cat/id3 -> null cat/id2 -> null cat/id1 -> null"
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"EQ:cat/id3 = cat/id1 cat/id1 = cat/id2"
		)

		model = '''
		PolicySet pSet {deny-unless-permit 
		policies: 
		Rule name (permit 
		target: 
			in(5.5, set(cat/id1, cat/id2))
		)
		}'''.parse

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			FacplType.BOOLEAN.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.set,
			null,
			FacplType.SET_NAME.toString
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"SUB:cat/id2 -> null cat/id1 -> DOUBLE"
		)

		model.assertWarning(
			Facpl2Package::eINSTANCE.function,
			null,
			"EQ:cat/id1 = cat/id2"
		)

	}

}
