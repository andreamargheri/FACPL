package usagecontrol.foo;

import it.unifi.facpl.lib.policy.*;

import java.util.List;

import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;
import it.unifi.facpl.system.status.functions.arithmetic.AddStatus;

@SuppressWarnings("all")
public class PolicySet_NamePolicySetTwo extends PolicySet {
	
	public PolicySet_NamePolicySetTwo() {
		addId("NamePolicySetTwo");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "value",
				new AttributeName("category", "id")));
		// PolElements
		addPolicyElement(new Rule_ruleName());
		// Obligation
		addObligation(
				new Obligation(
						"log", 
						Effect.PERMIT, 
						ObligationType.M, 
						new AttributeName("category", "id"),"Obligation")
				);

		addObligation(
				new ObligationStatus(
						new AddStatus(),
						Effect.PERMIT,
						ObligationType.M, 
						new StatusAttribute("accessNumber", FacplStatusType.INT), 1) 
				); 
	}
/*
 * RICORDA: IL NEW NON VA BENE LA SOPRA, BISOGNA PRENDERE L'ATTRIBUTO DALLO STATO E PASSARLO
 */
	private class Rule_ruleName extends Rule {

		Rule_ruleName() {
			addId("ruleName");
			// Effect
			addEffect(Effect.PERMIT);
			// Obligations
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThan.class, "STATUSDIPRIMA", 3)); 
		}
	}
}
