package eHealthWeb.deny;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_patientConsent extends PolicySet {
	public PolicySet_patientConsent() {
		addId("patientConsent");
		// Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
		// Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Alice",
				new AttributeName("resource", "patient-id")));
		// PolElements
		addPolicyElement(new Rule_denyRule());
		// Obligation
		addObligation(new Obligation("compress", Effect.PERMIT, ObligationType.O, null));
		addObligation(new Obligation("mailTo", Effect.DENY, ObligationType.M,
				new AttributeName("resource", "patient-id.mail"), "Data requested by unauthorized subject"));
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
