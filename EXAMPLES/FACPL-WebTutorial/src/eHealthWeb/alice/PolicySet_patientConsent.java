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
package eHealthWeb.alice;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_patientConsent extends PolicySet {
	public PolicySet_patientConsent() {
		addId("patientConsent");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Alice",
				new AttributeName("resource", "patient-id")));
		// PolElements
		addPolicyElement(new PolicySet_ePre());
		addPolicyElement(new Rule_denyRule());
		// Obligation
		addObligation(new Obligation("mailTo", Effect.DENY, ObligationType.M,
				new AttributeName("resource", "patient-id.mail"), "Data requested by unauthorized subject"));
		addObligation(new Obligation("compress", Effect.PERMIT, ObligationType.O, null));
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
