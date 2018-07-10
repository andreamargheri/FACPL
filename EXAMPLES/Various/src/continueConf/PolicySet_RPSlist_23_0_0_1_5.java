package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_23_0_0_1_5 extends PolicySet {
	public PolicySet_RPSlist_23_0_0_1_5(){
		addId("RPSlist_23_0_0_1_5");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_23_0_0_1_5_0());
		addPolicyElement(new PolicySet_RPSlist_23_0_0_1_5_1());
		addPolicyElement(new PolicySet_RPSlist_23_0_0_1_5_2());
		addPolicyElement(new PolicySet_RPSlist_23_0_0_1_5_3());
		//Obligation
		}
		
}
