package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_6_0_3_4 extends PolicySet {
	public PolicySet_RPSlist_6_0_3_4(){
		addId("RPSlist_6_0_3_4");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_6_0_3_4_0());
		addPolicyElement(new PolicySet_RPSlist_6_0_3_4_1());
		addPolicyElement(new PolicySet_RPSlist_6_0_3_4_2());
		addPolicyElement(new PolicySet_RPSlist_6_0_3_4_3());
		//Obligation
		}
		
}
