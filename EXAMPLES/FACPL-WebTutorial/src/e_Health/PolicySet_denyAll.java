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
package e_Health;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_denyAll extends PolicySet {
	public PolicySet_denyAll() {
		addId("denyAll");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyOverridesGreedy.class);
		// PolElements
		addPolicyElement(new Rule_denyRule());
		// Obligation
	}

	private class Rule_denyRule extends Rule {

		Rule_denyRule() {
			addId("denyRule");
			// Effect
			addEffect(Effect.DENY);
			// Obligations
		}
	}
}
