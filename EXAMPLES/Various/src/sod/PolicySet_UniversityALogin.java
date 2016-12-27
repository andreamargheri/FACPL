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
package sod;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_UniversityALogin extends PolicySet {
	public PolicySet_UniversityALogin() {
		addId("UniversityALogin");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		// Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
				new ExpressionBooleanTree(
						new ExpressionBooleanTree(ExprBooleanConnector.AND,
								new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,
										new ExpressionBooleanTree(new ExpressionFunction(
												it.unifi.facpl.lib.function.comparison.Equal.class, "University A",
												new AttributeName("resource", "destination"))),
										new ExpressionBooleanTree(new ExpressionFunction(
												it.unifi.facpl.lib.function.comparison.Equal.class, "Corporation B",
												new AttributeName("subject", "organization"))))),
								new ExpressionBooleanTree(
										new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
												"Corporation B", new AttributeName("subject", "locality"))))),
				new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						"Portable", new AttributeName("subject", "originating-device")))));
		// PolElements
		addPolicyElement(new Rule_rule1A());
		// Obligation
	}

	private class Rule_rule1A extends Rule {

		Rule_rule1A() {
			addId("rule1A");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
							"Login", new AttributeName("action", "action-id"))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							new Set("JOINT-PROJECT", "JRAPP-EXECUTE"), new AttributeName("subject", "permission")))));
			// Obligations
		}
	}
}
