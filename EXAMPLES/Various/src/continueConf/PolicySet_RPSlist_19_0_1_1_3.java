package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_19_0_1_1_3 extends PolicySet {
	public PolicySet_RPSlist_19_0_1_1_3(){
		addId("RPSlist_19_0_1_1_3");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "true",new AttributeName("subject","isConflicted") 
		));
		//PolElements
		addPolicyElement(new Rule_RPSlist_19_0_1_1_3_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_19_0_1_1_3_r_1 extends Rule {
			
				Rule_RPSlist_19_0_1_1_3_r_1 (){
					addId("RPSlist_19_0_1_1_3_r_1");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
