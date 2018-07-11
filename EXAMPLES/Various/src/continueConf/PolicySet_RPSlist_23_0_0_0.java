package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_23_0_0_0 extends PolicySet {
	public PolicySet_RPSlist_23_0_0_0(){
		addId("RPSlist_23_0_0_0");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "pc-chair",new AttributeName("subject","role") 
		));
		//PolElements
		addPolicyElement(new Rule_RPSlist_23_0_0_0_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_23_0_0_0_r_1 extends Rule {
			
				Rule_RPSlist_23_0_0_0_r_1 (){
					addId("RPSlist_23_0_0_0_r_1");
					//Effect
					addEffect(Effect.PERMIT);
					//Obligations
			}	
		}
}