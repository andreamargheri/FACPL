package loadBalancer;

import it.unifi.facpl.lib.policy.PolicySet;

@SuppressWarnings("all")	
public class PolicySet_CloudSystem extends PolicySet {
	public PolicySet_CloudSystem(){
		addId("CloudSystem");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		//PolElements
		addPolicyElement(new PolicySet_Create_Policies());
		addPolicyElement(new PolicySet_Release_Policies());
		//Obligation
		}
		
}
