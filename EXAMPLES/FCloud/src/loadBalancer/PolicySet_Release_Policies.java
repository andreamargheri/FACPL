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
package loadBalancer;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.Obligation;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;

@SuppressWarnings("all")
public class PolicySet_Release_Policies extends PolicySet {
	public PolicySet_Release_Policies() {
		addId("Release_Policies");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		// Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
				new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						"RELEASE", new AttributeName("action", "action-id"))),
				new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.OR,
						new ExpressionBooleanTree(
								new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "P_1",
										new AttributeName("subject", "profile-id"))),
						new ExpressionBooleanTree(
								new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "P_2",
										new AttributeName("subject", "profile-id")))))));
		// PolElements
		addPolicyElement(new Rule_hyper_1_release());
		addPolicyElement(new Rule_hyper_2_release());
		// Obligation
	}

	private class Rule_hyper_1_release extends Rule {

		Rule_hyper_1_release() {
			addId("hyper_1_release");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
					new AttributeName("resource", "vm-id"), new AttributeName("system", "hyper1.vm-ids")));
			// Obligations
			addObligation(new Obligation("release", Effect.PERMIT, ObligationType.M, "HYPER_1",
					new AttributeName("resource", "vm-id")));
		}
	}

	private class Rule_hyper_2_release extends Rule {

		Rule_hyper_2_release() {
			addId("hyper_2_release");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
					new AttributeName("resource", "vm-id"), new AttributeName("system", "hyper2.vm-ids")));
			// Obligations
			addObligation(new Obligation("release", Effect.PERMIT, ObligationType.M, "HYPER_2",
					new AttributeName("resource", "vm-id")));
		}
	}
}
