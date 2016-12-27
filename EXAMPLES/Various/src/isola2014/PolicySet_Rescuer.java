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
package isola2014;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_Rescuer extends PolicySet {
	public PolicySet_Rescuer() {
		addId("Rescuer");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy.class);
		// PolElements
		addPolicyElement(new Rule_victimFound());
		// Obligation
	}

	private class Rule_victimFound extends Rule {

		Rule_victimFound() {
			addId("victimFound");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
							"qry", new AttributeName("action", "action-id"))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
							"position", new AttributeName("action", "item")))));
			// Obligations
			addObligation(new Obligation("put", Effect.PERMIT, ObligationType.M, "stop"));
		}
	}
}
