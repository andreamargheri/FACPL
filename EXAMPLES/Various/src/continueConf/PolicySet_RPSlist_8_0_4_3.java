package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_8_0_4_3 extends PolicySet {
	public PolicySet_RPSlist_8_0_4_3(){
		addId("RPSlist_8_0_4_3");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_8_0_4_3_0());
		addPolicyElement(new PolicySet_RPSlist_8_0_4_3_1());
		addPolicyElement(new PolicySet_RPSlist_8_0_4_3_2());
		addPolicyElement(new PolicySet_RPSlist_8_0_4_3_3());
		addPolicyElement(new PolicySet_RPSlist_8_0_4_3_4());
		//Obligation
		}
		
}
