package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_22_0_0_2_5_3_3 extends PolicySet {
	public PolicySet_RPSlist_22_0_0_2_5_3_3(){
		addId("RPSlist_22_0_0_2_5_3_3");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new Rule_RPSlist_22_0_0_2_5_3_3_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_22_0_0_2_5_3_3_r_1 extends Rule {
			
				Rule_RPSlist_22_0_0_2_5_3_3_r_1 (){
					addId("RPSlist_22_0_0_2_5_3_3_r_1");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
