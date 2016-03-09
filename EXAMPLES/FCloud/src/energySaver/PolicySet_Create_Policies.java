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
package energySaver;

import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.util.AttributeName;

@SuppressWarnings("all")
public class PolicySet_Create_Policies extends PolicySet {
	public PolicySet_Create_Policies() {
		addId("Create_Policies");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "CREATE",
				new AttributeName("action", "action-id")));
		// PolElements
		addPolicyElement(new PolicySet_SLA_Type1());
		addPolicyElement(new PolicySet_SLA_Type2());
		// Obligation
	}

}
