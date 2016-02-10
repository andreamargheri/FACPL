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
package permit_all;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_permitAll extends PolicySet {
	public PolicySet_permitAll() {
		addId("permitAll");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyOverridesGreedy.class);
		// PolElements
		addPolicyElement(new Rule_Rule1());
		// Obligation
	}

	private class Rule_Rule1 extends Rule {

		Rule_Rule1() {
			addId("Rule1");
			// Effect
			addEffect(Effect.PERMIT);
			// Obligations
		}
	}
}
