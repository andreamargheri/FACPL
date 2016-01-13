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
