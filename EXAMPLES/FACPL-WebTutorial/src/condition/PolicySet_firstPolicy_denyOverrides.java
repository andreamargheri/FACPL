/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
package condition;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_firstPolicy_denyOverrides extends PolicySet {
	public PolicySet_firstPolicy_denyOverrides() {
		addId("firstPolicy_denyOverrides");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyOverridesGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "4567-1",
				new AttributeName("resource", "id")));
		// PolElements
		addPolicyElement(new Rule_RuleCondition_P());
		addPolicyElement(new Rule_RuleCondition_D());
		// Obligation
	}

	private class Rule_RuleCondition_P extends Rule {

		Rule_RuleCondition_P() {
			addId("RuleCondition_P");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
							"John", new AttributeName("subject", "id"))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							new AttributeName("action", "id"), new Set("read", "seek")))));
			// Obligations
		}
	}

	private class Rule_RuleCondition_D extends Rule {

		Rule_RuleCondition_D() {
			addId("RuleCondition_D");
			// Effect
			addEffect(Effect.DENY);
			// Target
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
					new AttributeName("action", "id"), new Set("write", "checkout")));
			// Obligations
		}
	}
}
