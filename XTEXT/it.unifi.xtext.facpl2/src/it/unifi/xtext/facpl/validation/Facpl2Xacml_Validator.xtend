package it.unifi.xtext.facpl.validation

import it.unifi.xtext.facpl.facpl2.AndExpression
import it.unifi.xtext.facpl.facpl2.AttributeName
import it.unifi.xtext.facpl.facpl2.BooleanLiteral
import it.unifi.xtext.facpl.facpl2.DateLiteral
import it.unifi.xtext.facpl.facpl2.DeclaredFunction
import it.unifi.xtext.facpl.facpl2.DoubleLiteral
import it.unifi.xtext.facpl.facpl2.Expression
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.facpl2.Function
import it.unifi.xtext.facpl.facpl2.IntLiteral
import it.unifi.xtext.facpl.facpl2.NotExpression
import it.unifi.xtext.facpl.facpl2.OrExpression
import it.unifi.xtext.facpl.facpl2.PolicySet
import it.unifi.xtext.facpl.facpl2.Rule
import it.unifi.xtext.facpl.facpl2.StringLiteral
import it.unifi.xtext.facpl.facpl2.TimeLiteral
import it.unifi.xtext.facpl.facpl2.util.Facpl2Switch

/**
 * Check if the structural conditions on Expression (defining targets) are match
 */
class Facpl2Xacml_Validator extends Facpl2Switch<Boolean> {

	override caseAndExpression(AndExpression object) {
		return doSwitch(object.left) && doSwitch(object.right)
	}

	override caseOrExpression(OrExpression object) {
		return doSwitch(object.left) && doSwitch(object.right)
	}

	/**
	 * Not supported by XACML
	 */
	override caseNotExpression(NotExpression object) {
		
		return false
	}

	/**
	 * Check for a Policy target -> FIRST-> Attribute-Name SECOND -> Literal
	 */
	override caseFunction(Function object) {
		if (isLiteral(object.arg1) && object.arg2 instanceof AttributeName ){
			return true
		}else{
			System.out.println("Function not well-formed: " + object.arg1.toString());
			return false
		}
	}

	def Boolean isLiteral(Expression e) {
		if (e instanceof BooleanLiteral || e instanceof StringLiteral || e instanceof IntLiteral ||
			e instanceof DoubleLiteral || e instanceof DateLiteral || e instanceof TimeLiteral)
			return true
		else
			return false
	}

	/**
	 * If it is not wrapped by a function, it is an error 
	 */
	override caseAttributeName(AttributeName object) {
		return false
	}

	override caseBooleanLiteral(BooleanLiteral object) {
		return false
	}

	override caseDateLiteral(DateLiteral object) {
		return false
	}

	override caseDeclaredFunction(DeclaredFunction object) {
		false
	}

	override caseDoubleLiteral(DoubleLiteral object) {
		return false
	}

	override caseIntLiteral(IntLiteral object) {
		return false
	}

	override caseStringLiteral(StringLiteral object) {
		return false
	}

	override caseTimeLiteral(TimeLiteral object) {
		return false
	}

	/**
	 * EntryPoint for Checking if a Policy is of the expected form for translating it in XACML
	 */
	def dispatch Boolean isXACML_FormedPolicy(PolicySet p) {
		/*
		 * ALL ALGORITHMS ARE SUPPORTED -> it is returned a custom algorithm id
		 */
		if (p.target != null) {
			if (!doSwitch(p.target)) {
				return false
			}
		}
		var flag = true
		// CHECK ENCLOSED POLICIES
		for (el : p.policies) {
			if (el.newPolicy != null) {
				flag = flag && isXACML_FormedPolicy(el.newPolicy)
			} else {
				flag = flag && isXACML_FormedPolicy(el.refPol)
			}
		}

		return flag
	}

	def dispatch Boolean isXACML_FormedPolicy(Rule p) {
		/*
		 * No restriction on the expression of rule target
		 */
		return true
	}

	def Boolean isXACML_Formed(Facpl f) {
		if (f.policies != null) {
			for (p : f.policies) {
				if (!isXACML_FormedPolicy(p)){
					return false
				}
			}
		}
		return true
	}

}
