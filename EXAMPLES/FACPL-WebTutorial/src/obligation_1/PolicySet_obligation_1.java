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
package obligation_1;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_obligation_1 extends PolicySet {
	public PolicySet_obligation_1() {
		addId("obligation_1");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyOverridesGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "4567-1",
				new AttributeName("resource", "id")));
		// PolElements
		addPolicyElement(new Rule_RuleP());
		addPolicyElement(new Rule_RuleD());
		// Obligation
		addObligation(new Obligation("log", Effect.PERMIT, ObligationType.M, "Resource accessed: ",
				new AttributeName("resource", "id")));
	}

	private class Rule_RuleP extends Rule {

		Rule_RuleP() {
			addId("RuleP");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
							"John", new AttributeName("subject", "id"))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							new AttributeName("action", "id"), new Set("read", "seek")))));
			// Obligations
			addObligation(
					new Obligation("action1", Effect.PERMIT, ObligationType.M, new AttributeName("subject", "name")));
		}
	}

	private class Rule_RuleD extends Rule {

		Rule_RuleD() {
			addId("RuleD");
			// Effect
			addEffect(Effect.DENY);
			// Target
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
					new AttributeName("action", "id"), new Set("write", "checkout")));
			// Obligations
			addObligation(
					new Obligation("action2", Effect.DENY, ObligationType.M, new AttributeName("subject", "name")));
		}
	}
}
