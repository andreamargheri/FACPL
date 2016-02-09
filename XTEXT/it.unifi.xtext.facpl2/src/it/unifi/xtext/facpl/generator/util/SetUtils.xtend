package it.unifi.xtext.facpl.generator.util

import it.unifi.xtext.facpl.facpl2.AttributeName
import it.unifi.xtext.facpl.facpl2.BooleanLiteral
import it.unifi.xtext.facpl.facpl2.DateLiteral
import it.unifi.xtext.facpl.facpl2.DoubleLiteral
import it.unifi.xtext.facpl.facpl2.IntLiteral
import it.unifi.xtext.facpl.facpl2.Set
import it.unifi.xtext.facpl.facpl2.StringLiteral
import it.unifi.xtext.facpl.facpl2.TimeLiteral
import it.unifi.xtext.facpl.facpl2.util.Facpl2Switch

/**
 * Pretty printing of Sets (it reports only the Literals forming a Set)
 */
class SetUtils extends Facpl2Switch<String> {

//Set
	override caseSet(Set Set) '''Set(«FOR arg : Set.args SEPARATOR ","»«doSwitch(arg)»«ENDFOR»)'''

//Attribute name -> empty list of constants
	override caseAttributeName(AttributeName object) {
		return object.category + "/" + object.id
	}

//Creating constants
	override caseBooleanLiteral(BooleanLiteral object) {
		return object.value.toString
	}

	override caseDoubleLiteral(DoubleLiteral object) {
		return object.value.toString
	}

	override caseIntLiteral(IntLiteral object) {
		return object.value.toString
	}

	override caseStringLiteral(StringLiteral object) {
		return object.value.toString
	}

	override caseDateLiteral(DateLiteral object) {
		return object.value.toString
	}

	override caseTimeLiteral(TimeLiteral object) {
		return object.value.toString
	}

}
