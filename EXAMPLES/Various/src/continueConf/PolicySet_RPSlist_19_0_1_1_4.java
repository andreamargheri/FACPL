package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_19_0_1_1_4 extends PolicySet {
	public PolicySet_RPSlist_19_0_1_1_4(){
		addId("RPSlist_19_0_1_1_4");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "read",new AttributeName("action","action-type") 
		)),new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "pc-member",new AttributeName("subject","role") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "false",new AttributeName("subject","isConflicted") 
		)))
		))
		);
		//PolElements
		addPolicyElement(new Rule_RPSlist_19_0_1_1_4_r_1());
		addPolicyElement(new Rule_RPSlist_19_0_1_1_4_r_2());
		addPolicyElement(new Rule_RPSlist_19_0_1_1_4_r_3());
		addPolicyElement(new Rule_RPSlist_19_0_1_1_4_r_4());
		addPolicyElement(new Rule_RPSlist_19_0_1_1_4_r_5());
		//Obligation
		}
		
		private class Rule_RPSlist_19_0_1_1_4_r_1 extends Rule {
			
				Rule_RPSlist_19_0_1_1_4_r_1 (){
					addId("RPSlist_19_0_1_1_4_r_1");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "true",new AttributeName("subject","isEq-subjUserId-resUserId") 
					));
					//Obligations
			}	
		}
		private class Rule_RPSlist_19_0_1_1_4_r_2 extends Rule {
			
				Rule_RPSlist_19_0_1_1_4_r_2 (){
					addId("RPSlist_19_0_1_1_4_r_2");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "discussion",new AttributeName("resource","phase") 
					));
					//Obligations
			}	
		}
		private class Rule_RPSlist_19_0_1_1_4_r_3 extends Rule {
			
				Rule_RPSlist_19_0_1_1_4_r_3 (){
					addId("RPSlist_19_0_1_1_4_r_3");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "true",new AttributeName("subject","subjReviewsThisResPaper") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "true",new AttributeName("subject","hasSubmittedReviewForResPaper") 
					)))
					);
					//Obligations
			}	
		}
		private class Rule_RPSlist_19_0_1_1_4_r_4 extends Rule {
			
				Rule_RPSlist_19_0_1_1_4_r_4 (){
					addId("RPSlist_19_0_1_1_4_r_4");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "true",new AttributeName("resource","isSeeUnassignedAllowed") 
					));
					//Obligations
			}	
		}
		private class Rule_RPSlist_19_0_1_1_4_r_5 extends Rule {
			
				Rule_RPSlist_19_0_1_1_4_r_5 (){
					addId("RPSlist_19_0_1_1_4_r_5");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
