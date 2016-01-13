package obligation_2;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_obligation_2 extends PolicySet {
	public PolicySet_obligation_2() {
		addId("obligation_2");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		// PolElements
		addPolicyElement(new Rule_rule1());
		// Obligation
		addObligation(new Obligation("log", Effect.DENY, ObligationType.M, "Subject: ",
				new AttributeName("subject", "id"), new AttributeName("subject", "name")));
	}

	private class Rule_rule1 extends Rule {

		Rule_rule1() {
			addId("rule1");
			// Effect
			addEffect(Effect.DENY);
			// Obligations
		}
	}
}
