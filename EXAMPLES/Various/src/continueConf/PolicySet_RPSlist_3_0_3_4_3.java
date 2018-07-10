package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_3_0_3_4_3 extends PolicySet {
	public PolicySet_RPSlist_3_0_3_4_3(){
		addId("RPSlist_3_0_3_4_3");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//PolElements
		addPolicyElement(new Rule_RPSlist_3_0_3_4_3_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_3_0_3_4_3_r_1 extends Rule {
			
				Rule_RPSlist_3_0_3_4_3_r_1 (){
					addId("RPSlist_3_0_3_4_3_r_1");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
