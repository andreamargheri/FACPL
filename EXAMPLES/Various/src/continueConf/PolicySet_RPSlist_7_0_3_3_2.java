package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_7_0_3_3_2 extends PolicySet {
	public PolicySet_RPSlist_7_0_3_3_2(){
		addId("RPSlist_7_0_3_3_2");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "pc-member",new AttributeName("subject","role") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "true",new AttributeName("subject","isEq-subjUserId-resUserId") 
		)))
		);
		//PolElements
		addPolicyElement(new Rule_RPSlist_7_0_3_3_2_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_7_0_3_3_2_r_1 extends Rule {
			
				Rule_RPSlist_7_0_3_3_2_r_1 (){
					addId("RPSlist_7_0_3_3_2_r_1");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
