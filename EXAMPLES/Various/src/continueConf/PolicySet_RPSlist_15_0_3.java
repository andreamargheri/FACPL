package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_15_0_3 extends PolicySet {
	public PolicySet_RPSlist_15_0_3(){
		addId("RPSlist_15_0_3");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "read",new AttributeName("action","action-type") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "true",new AttributeName("subject","isSubjectsMeeting") 
		)))
		);
		//PolElements
		addPolicyElement(new Rule_RPSlist_15_0_3_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_15_0_3_r_1 extends Rule {
			
				Rule_RPSlist_15_0_3_r_1 (){
					addId("RPSlist_15_0_3_r_1");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
