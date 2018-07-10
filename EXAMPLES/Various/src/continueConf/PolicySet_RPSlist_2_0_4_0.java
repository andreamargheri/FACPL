package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_2_0_4_0 extends PolicySet {
	public PolicySet_RPSlist_2_0_4_0(){
		addId("RPSlist_2_0_4_0");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.OR,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "read",new AttributeName("action","action-type") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "write",new AttributeName("action","action-type") 
		)))
		),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "admin",new AttributeName("subject","role") 
		)))
		);
		//PolElements
		addPolicyElement(new Rule_RPSlist_2_0_4_0_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_2_0_4_0_r_1 extends Rule {
			
				Rule_RPSlist_2_0_4_0_r_1 (){
					addId("RPSlist_2_0_4_0_r_1");
					//Effect
					addEffect(Effect.PERMIT);
					//Obligations
			}	
		}
}
