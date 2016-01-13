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
