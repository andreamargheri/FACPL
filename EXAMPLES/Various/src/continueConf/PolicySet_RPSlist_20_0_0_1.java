package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_20_0_0_1 extends PolicySet {
	public PolicySet_RPSlist_20_0_0_1(){
		addId("RPSlist_20_0_0_1");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "create",new AttributeName("action","action-type") 
		)),new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "subreviewer",new AttributeName("subject","role") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "true",new AttributeName("subject","isEq-subjUserId-resUserId") 
		)))
		))
		);
		//PolElements
		addPolicyElement(new Rule_RPSlist_20_0_0_1_r_1());
		//Obligation
		}
		
		private class Rule_RPSlist_20_0_0_1_r_1 extends Rule {
			
				Rule_RPSlist_20_0_0_1_r_1 (){
					addId("RPSlist_20_0_0_1_r_1");
					//Effect
					addEffect(Effect.PERMIT);
					//Obligations
			}	
		}
}
