package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_7_0 extends PolicySet {
	public PolicySet_RPSlist_7_0(){
		addId("RPSlist_7_0");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_7_0_0());
		addPolicyElement(new PolicySet_RPSlist_7_0_1());
		addPolicyElement(new PolicySet_RPSlist_7_0_2());
		addPolicyElement(new PolicySet_RPSlist_7_0_3());
		//Obligation
		}
		
}
