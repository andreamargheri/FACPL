package foo;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_NamePolicySetTwo extends PolicySet {
	public PolicySet_NamePolicySetTwo() {
		addId("NamePolicySetTwo");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyOverrides.class);
		// Target
		addTarget(
				new ExpressionBooleanTree(ExprBooleanConnector.NOT,
						new ExpressionBooleanTree(
								new ExpressionBooleanTree(ExprBooleanConnector.AND,
										new ExpressionBooleanTree(new ExpressionFunction(
												it.unifi.facpl.lib.function.comparison.Equal.class,
												new AttributeName("category", "id"), 5)),
								new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.NOT,
										new ExpressionBooleanTree(new ExpressionFunction(
												it.unifi.facpl.lib.function.comparison.Equal.class,
												new AttributeName("category", "id"),
												new AttributeName("category", "id")))))))));
		// PolElements
		addPolicyElement(new Rule_ruleName());
		// Obligation
	}

	private class Rule_ruleName extends Rule {

		Rule_ruleName() {
			addId("ruleName");
			// Effect
			addEffect(Effect.DENY);
			// Obligations
		}
	}
}
