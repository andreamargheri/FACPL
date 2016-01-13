package foo;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_NamePolicySetOne extends PolicySet {
	public PolicySet_NamePolicySetOne() {
		addId("NamePolicySetOne");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyOverridesGreedy.class);
		// PolElements
		addPolicyElement(new PolicySet_NamePolicySetTwo());
		// Obligation
	}

}
