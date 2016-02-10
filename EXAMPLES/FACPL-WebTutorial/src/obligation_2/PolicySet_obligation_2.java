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
package obligation_2;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_obligation_2 extends PolicySet {
	public PolicySet_obligation_2() {
		addId("obligation_2");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		// PolElements
		addPolicyElement(new Rule_rule1());
		// Obligation
		addObligation(new Obligation("log", Effect.DENY, ObligationType.M, "Subject: ",
				new AttributeName("subject", "id"), new AttributeName("subject", "name")));
	}

	private class Rule_rule1 extends Rule {

		Rule_rule1() {
			addId("rule1");
			// Effect
			addEffect(Effect.DENY);
			// Obligations
		}
	}
}
