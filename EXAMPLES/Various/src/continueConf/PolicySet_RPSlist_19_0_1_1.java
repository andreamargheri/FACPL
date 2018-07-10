package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_19_0_1_1 extends PolicySet {
	public PolicySet_RPSlist_19_0_1_1(){
		addId("RPSlist_19_0_1_1");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_19_0_1_1_0());
		addPolicyElement(new PolicySet_RPSlist_19_0_1_1_1());
		addPolicyElement(new PolicySet_RPSlist_19_0_1_1_2());
		addPolicyElement(new PolicySet_RPSlist_19_0_1_1_3());
		addPolicyElement(new PolicySet_RPSlist_19_0_1_1_4());
		addPolicyElement(new PolicySet_RPSlist_19_0_1_1_5());
		//Obligation
		}
		
}
