package it.unifi.xtext.facpl.generator.util

import it.unifi.xtext.facpl.facpl2.util.Facpl2Switch
import it.unifi.xtext.facpl.validation.FacplType
import it.unifi.xtext.facpl.facpl2.BooleanLiteral
import it.unifi.xtext.facpl.facpl2.DoubleLiteral
import it.unifi.xtext.facpl.facpl2.IntLiteral
import it.unifi.xtext.facpl.facpl2.StringLiteral
import it.unifi.xtext.facpl.facpl2.DateLiteral
import it.unifi.xtext.facpl.facpl2.TimeLiteral
import it.unifi.xtext.facpl.facpl2.AttributeName
import it.unifi.xtext.facpl.facpl2.AndExpression
import it.unifi.xtext.facpl.facpl2.Expression
import it.unifi.xtext.facpl.facpl2.NotExpression
import it.unifi.xtext.facpl.facpl2.OrExpression
import it.unifi.xtext.facpl.facpl2.Function
import it.unifi.xtext.facpl.facpl2.Rule

import it.unifi.xtext.facpl.facpl2.PolicySet
import it.unifi.xtext.facpl.facpl2.Bag
import it.unifi.xtext.facpl.facpl2.FacplPolicy
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference
import java.util.HashMap
import it.unifi.xtext.facpl.facpl2.DeclaredFunction

/**
 * Collect constants used in a policy
 */
class PolicyConstant extends Facpl2Switch<Boolean> {

	private HashMap<String, ConstraintConstant> constants;

	new() {
		this.constants = new HashMap<String, ConstraintConstant>()
	}

	def getConstants() {
		return this.constants
	}

	// FACPL CASEs
	override caseFacpl(Facpl object) {
		var s = true
		if (object.policies != null) {
			for (pol : object.policies) {
				s = s && doSwitch(pol)
			}
		}
		return s
	}

	override caseFacplPolicy(FacplPolicy object) {
		if (object instanceof PolicySet) {
			return doSwitch(object as PolicySet)
		} else if (object instanceof Rule) {
			return doSwitch(object as Rule)
		}
	}

	override caseAbstractPolicyIncl(AbstractPolicyIncl object) {
		if (object.refPol != null) {
			return doSwitch(object.refPol)
		} else if (object.newPolicy != null) {
			return doSwitch(object.newPolicy)
		}
	}

	override casePolicySet(PolicySet object) {
		var s = true
		if (object.target != null) {
			s = s && doSwitch(object.target)
		}
		for (pol : object.policies) {
			s = s && doSwitch(pol)
		}
		for (ob : object.obl) {
			for (expr : ob.expr) {
				s = s && doSwitch(expr)
			}
		}
		return s
	}

	override caseRule(Rule object) {
		var s = true
		if (object.target != null) {
			s = s && doSwitch(object.target)
		}
		for (ob : object.obl) {
			for (expr : ob.expr) {
				s = s && doSwitch(expr)
			}
		}
		return s
	}

	override caseExpression(Expression object) {
		return doSwitch(object)
	}

//merging list
	override caseAndExpression(AndExpression object) {
		doSwitch(object.left)
		doSwitch(object.right)
		return true
	}

	override caseOrExpression(OrExpression object) {
		doSwitch(object.left)
		doSwitch(object.right)
		return true
	}

	override caseNotExpression(NotExpression object) {
		return doSwitch(object.arg)
	}

//Function
	override caseFunction(Function object) {
		doSwitch(object.arg1)
		doSwitch(object.arg2)
		return true
	}

//BAG
	override caseBag(Bag bag) {
		val tCheck = new FacplTypeInference()

		val FacplType t = tCheck.doSwitch(bag)

		if (t.equals(FacplType.NAME)) {
		}

		throw new Exception()
	}

//Declared function invocation
	override caseDeclaredFunction(DeclaredFunction f) {
		for (arg : f.args) {
			doSwitch(arg)
		}
		return true
	}

//Attribute name -> empty list of constants
	override caseAttributeName(AttributeName object) {
		return true
	}

//Creating constants
	override caseBooleanLiteral(BooleanLiteral object) {
		val c = new ConstraintConstant(FacplType.BOOLEAN, object.value.toString, object.value.toString)
		this.constants.put(c.att_name, c)
		return true
	}

	override caseDoubleLiteral(DoubleLiteral object) {
		val c = new ConstraintConstant(FacplType.DOUBLE, object.value.toString, object.value.toString)
		this.constants.put(c.att_name, c)
		return true
	}

	override caseIntLiteral(IntLiteral object) {
		val c = new ConstraintConstant(FacplType.INT, object.value.toString, object.value.toString)
		this.constants.put(c.att_name, c)
		return true
	}

	override caseStringLiteral(StringLiteral object) {
		val c = new ConstraintConstant(FacplType.STRING, object.value.toString, object.value.toString)
		this.constants.put(c.att_name, c)
		return true
	}

	override caseDateLiteral(DateLiteral object) {
		throw new Exception("NOT SUPPORTED")
	}

	override caseTimeLiteral(TimeLiteral object) {
		throw new Exception("NOT SUPPORTED")
	}

}
