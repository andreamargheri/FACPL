package Devrim;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_SoDRules extends PolicySet {
	public PolicySet_SoDRules(){
		addId("SoDRules");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		//PolElements
		addPolicyElement(new PolicySet_SoDRole1());
		//Obligation
		}
		
}
