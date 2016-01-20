package e_Health;

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
		addPolicyElement(new PolicySet_eDis());
		addPolicyElement(new PolicySet_denyAll());
		// Obligation
		addObligation(new Obligation("mailTo", Effect.DENY, ObligationType.M,
				new AttributeName("resource", "patient-id.mail"), "Personal data requested by unauthorized subject"));
		addObligation(new Obligation("compress", Effect.PERMIT, ObligationType.O, true));
	}

}
