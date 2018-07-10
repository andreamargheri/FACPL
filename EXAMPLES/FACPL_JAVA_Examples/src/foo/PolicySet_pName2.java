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
package foo;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_pName2 extends PolicySet {
	public PolicySet_pName2() {
		addId("pName2");
		// Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
		// PolElements
		addPolicyElement(new Rule_rule11());
		addPolicyElement(new Rule_rule2());
		addPolicyElement(new Rule_rule3());
		addPolicyElement(new Rule_rule4());
		// Obligation
	}

	private class Rule_rule11 extends Rule {

		Rule_rule11() {
			addId("rule11");
			// Effect
			addEffect(Effect.PERMIT);
			// Obligations
		}
	}

	private class Rule_rule2 extends Rule {

		Rule_rule2() {
			addId("rule2");
			// Effect
			addEffect(Effect.PERMIT);
			// Obligations
		}
	}

	private class Rule_rule3 extends Rule {

		Rule_rule3() {
			addId("rule3");
			// Effect
			addEffect(Effect.PERMIT);
			// Obligations
		}
	}

	private class Rule_rule4 extends Rule {

		Rule_rule4() {
			addId("rule4");
			// Effect
			addEffect(Effect.PERMIT);
			// Obligations
		}
	}
}
