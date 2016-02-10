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
public class PolicySet_polSet extends PolicySet {
	public PolicySet_polSet() {
		addId("polSet");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		// PolElements
		addPolicyElement(new PolicySet_obligation_1());
		addPolicyElement(new PolicySet_obligation_2());
		// Obligation
		addObligation(new Obligation("log", Effect.PERMIT, ObligationType.M, "Resource accessed: ",
				new AttributeName("resource", "id")));
		addObligation(new Obligation("log", Effect.DENY, ObligationType.M, "Resource requested: ",
				new AttributeName("resource", "id")));
	}

}
