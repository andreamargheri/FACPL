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
package it.unifi.facpl.example.target;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;

@SuppressWarnings("all")
public class Policy_BasicOrAndTarget extends PolicySet {

	public Policy_BasicOrAndTarget() {
		addId("BasicOrAndTarget");
		// Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.DenyOverrides());
		// Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
				new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(),
						false, new AttributeName("envirnoment", "time"))),
				new ExpressionBooleanTree(ExprBooleanConnector.OR,
						new ExpressionBooleanTree(
								new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), false,
										new AttributeName("envirnoment", "time"))),
						new ExpressionBooleanTree(
								new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), false,
										new AttributeName("envirnoment", "time"))))));
		// Rule
		addPolicyElement(new rule1());
		// Obligations
	}

	private class rule1 extends Rule {

		rule1() {
			addId("rule1");
			// Effect
			addEffect(Effect.DENY);

		}
	}

}
