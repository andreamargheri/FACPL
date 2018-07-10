package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist extends PolicySet {
	public PolicySet_RPSlist(){
		addId("RPSlist");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_0());
		addPolicyElement(new PolicySet_RPSlist_1());
		addPolicyElement(new PolicySet_RPSlist_2());
		addPolicyElement(new PolicySet_RPSlist_3());
		addPolicyElement(new PolicySet_RPSlist_4());
		addPolicyElement(new PolicySet_RPSlist_5());
		addPolicyElement(new PolicySet_RPSlist_6());
		addPolicyElement(new PolicySet_RPSlist_7());
		addPolicyElement(new PolicySet_RPSlist_8());
		addPolicyElement(new PolicySet_RPSlist_9());
		addPolicyElement(new PolicySet_RPSlist_10());
		addPolicyElement(new PolicySet_RPSlist_11());
		addPolicyElement(new PolicySet_RPSlist_12());
		addPolicyElement(new PolicySet_RPSlist_13());
		addPolicyElement(new PolicySet_RPSlist_14());
		addPolicyElement(new PolicySet_RPSlist_15());
		addPolicyElement(new PolicySet_RPSlist_16());
		addPolicyElement(new PolicySet_RPSlist_17());
		addPolicyElement(new PolicySet_RPSlist_18());
		addPolicyElement(new PolicySet_RPSlist_19());
		addPolicyElement(new PolicySet_RPSlist_20());
		addPolicyElement(new PolicySet_RPSlist_21());
		addPolicyElement(new PolicySet_RPSlist_22());
		addPolicyElement(new PolicySet_RPSlist_23());
		addPolicyElement(new PolicySet_RPSlist_24());
		//Obligation
		}
		
}
