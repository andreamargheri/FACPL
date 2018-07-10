package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_19_0_1_1_2 extends PolicySet {
	public PolicySet_RPSlist_19_0_1_1_2(){
		addId("RPSlist_19_0_1_1_2");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.OR,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "create",new AttributeName("action","action-type") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "delete",new AttributeName("action","action-type") 
		)))
		),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "pc-chair",new AttributeName("subject","role") 
		)))
		);
		//PolElements
		addPolicyElement(new Rule_RPSlist_19_0_1_1_2_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_19_0_1_1_2_r_1 extends Rule {
			
				Rule_RPSlist_19_0_1_1_2_r_1 (){
					addId("RPSlist_19_0_1_1_2_r_1");
					//Effect
					addEffect(Effect.PERMIT);
					//Obligations
			}	
		}
}
