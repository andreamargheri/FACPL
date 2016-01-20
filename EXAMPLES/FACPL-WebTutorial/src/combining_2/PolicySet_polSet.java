package combining_2;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_polSet extends PolicySet {
	public PolicySet_polSet() {
		addId("polSet");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.OnlyOneApplicableGreedy.class);
		// PolElements
		addPolicyElement(new PolicySet_first());
		addPolicyElement(new PolicySet_second());
		// Obligation
	}

}
