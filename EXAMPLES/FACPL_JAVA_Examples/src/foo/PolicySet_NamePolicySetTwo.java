package foo;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

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
		addObligation(new Obligation("log", Effect.PERMIT, ObligationType.M, new AttributeName("category", "id"),
				"Obligation"));
	}

	private class Rule_ruleName extends Rule {

		Rule_ruleName() {
			addId("ruleName");
			// Effect
			addEffect(Effect.PERMIT);
			// Obligations
		}
	}
}
