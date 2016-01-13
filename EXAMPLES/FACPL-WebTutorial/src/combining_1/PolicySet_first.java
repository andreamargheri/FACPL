package combining_1;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_first extends PolicySet {
	public PolicySet_first() {
		addId("first");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyOverridesGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "4567-1",
				new AttributeName("resource", "id")));
		// PolElements
		addPolicyElement(new Rule_Rule_DenyAll());
		// Obligation
	}

	private class Rule_Rule_DenyAll extends Rule {

		Rule_Rule_DenyAll() {
			addId("Rule_DenyAll");
			// Effect
			addEffect(Effect.DENY);
			// Obligations
		}
	}
}
