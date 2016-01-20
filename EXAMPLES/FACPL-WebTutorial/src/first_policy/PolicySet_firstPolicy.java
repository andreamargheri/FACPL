package first_policy;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_firstPolicy extends PolicySet {
	public PolicySet_firstPolicy() {
		addId("firstPolicy");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "4567-1",
				new AttributeName("resource", "id")));
		// PolElements
		addPolicyElement(new Rule_Rule1());
		addPolicyElement(new Rule_RuleDeny());
		// Obligation
	}

	private class Rule_Rule1 extends Rule {

		Rule_Rule1() {
			addId("Rule1");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
							"John", new AttributeName("subject", "id"))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
							"read", new AttributeName("action", "id")))));
			// Obligations
		}
	}

	private class Rule_RuleDeny extends Rule {

		Rule_RuleDeny() {
			addId("RuleDeny");
			// Effect
			addEffect(Effect.DENY);
			// Obligations
		}
	}
}
