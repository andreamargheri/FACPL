package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_9_0 extends PolicySet {
	public PolicySet_RPSlist_9_0(){
		addId("RPSlist_9_0");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_9_0_0());
		addPolicyElement(new PolicySet_RPSlist_9_0_1());
		addPolicyElement(new PolicySet_RPSlist_9_0_2());
		addPolicyElement(new PolicySet_RPSlist_9_0_3());
		//Obligation
		}
		
}
