package foo.funDeclaration;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_PSet extends PolicySet {
	public PolicySet_PSet() {
		addId("PSet");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
				new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						"READ", new AttributeName("action", "id"))),
				new ExpressionBooleanTree(new ExpressionFunction(Function_F_Name.class, "READ", 4))));
		// PolElements
		addPolicyElement(new Rule_rule1());
		// Obligation
	}

	private class Rule_rule1 extends Rule {

		Rule_rule1() {
			addId("rule1");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							new AttributeName("sub", "id"),
							new ExpressionFunction(Function_F_Name2.class, "foo", true))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							new AttributeName("sub", "id"), new Set(true, false)))));
			// Obligations
		}
	}
}
