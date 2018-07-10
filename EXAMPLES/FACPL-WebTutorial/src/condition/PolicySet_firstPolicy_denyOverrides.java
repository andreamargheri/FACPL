package condition;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_firstPolicy_denyOverrides extends PolicySet {
	public PolicySet_firstPolicy_denyOverrides(){
		addId("firstPolicy_denyOverrides");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.DenyOverridesGreedy());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "4567-1",new AttributeName("resource","id") 
		));
		//PolElements
		addPolicyElement(new Rule_RuleCondition_P());
		addPolicyElement(new Rule_RuleCondition_D());
		//Obligation
		}
		
		private class Rule_RuleCondition_P extends Rule {
			
				Rule_RuleCondition_P (){
					addId("RuleCondition_P");
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
			}	
		}
		private class Rule_RuleCondition_D extends Rule {
			
				Rule_RuleCondition_D (){
					addId("RuleCondition_D");
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
			}	
		}
}
