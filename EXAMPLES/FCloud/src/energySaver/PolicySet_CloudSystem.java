package energySaver;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_CloudSystem extends PolicySet {
	public PolicySet_CloudSystem(){
		addId("CloudSystem");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy());
		//PolElements
		addPolicyElement(new PolicySet_Create_Policies());
		addPolicyElement(new PolicySet_Release_Policies());
		//Obligation
		}
		
}
