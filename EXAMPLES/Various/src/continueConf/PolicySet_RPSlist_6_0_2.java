package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_6_0_2 extends PolicySet {
	public PolicySet_RPSlist_6_0_2(){
		addId("RPSlist_6_0_2");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new Rule_RPSlist_6_0_2_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_6_0_2_r_1 extends Rule {
			
				Rule_RPSlist_6_0_2_r_1 (){
					addId("RPSlist_6_0_2_r_1");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
