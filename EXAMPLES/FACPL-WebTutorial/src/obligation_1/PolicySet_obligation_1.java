package obligation_1;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_obligation_1 extends PolicySet {
	public PolicySet_obligation_1(){
		addId("obligation_1");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.DenyOverridesGreedy());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "4567-1",new AttributeName("resource","id") 
		));
		//PolElements
		addPolicyElement(new Rule_RuleP());
		addPolicyElement(new Rule_RuleD());
		//Obligation
		addObligation(new Obligation("log",Effect.PERMIT,ObligationType.M,"Resource accessed: ",
		new AttributeName("resource","id") 
		)
		);
		}
		
		private class Rule_RuleP extends Rule {
			
				Rule_RuleP (){
					addId("RuleP");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "John",new AttributeName("subject","id") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(), new AttributeName("action","id") 
					,new Set(
					"read",
					"seek"
					)
					)))
					);
					//Obligations
					addObligation(new Obligation("action1",Effect.PERMIT,ObligationType.M,new AttributeName("subject","name") 
					)
					);
			}	
		}
		private class Rule_RuleD extends Rule {
			
				Rule_RuleD (){
					addId("RuleD");
					//Effect
					addEffect(Effect.DENY);
					//Target
					addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(), new AttributeName("action","id") 
					,new Set(
					"write",
					"checkout"
					)
					));
					//Obligations
					addObligation(new Obligation("action2",Effect.DENY,ObligationType.M,new AttributeName("subject","name") 
					)
					);
			}	
		}
}
