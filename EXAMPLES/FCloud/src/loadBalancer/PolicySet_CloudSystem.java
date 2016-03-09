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

import it.unifi.facpl.lib.policy.PolicySet;

@SuppressWarnings("all")
public class PolicySet_CloudSystem extends PolicySet {
	public PolicySet_CloudSystem() {
		addId("CloudSystem");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// PolElements
		addPolicyElement(new PolicySet_Create_Policies());
		addPolicyElement(new PolicySet_Release_Policies());
		// Obligation
	}

}
