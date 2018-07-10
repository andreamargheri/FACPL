package first_policy;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_firstPolicy extends PolicySet {
	public PolicySet_firstPolicy(){
		addId("firstPolicy");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "4567-1",new AttributeName("resource","id") 
		));
		//PolElements
		addPolicyElement(new Rule_Rule1());
		addPolicyElement(new Rule_RuleDeny());
		//Obligation
		}
		
		private class Rule_Rule1 extends Rule {
			
				Rule_Rule1 (){
					addId("Rule1");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "John",new AttributeName("subject","id") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "read",new AttributeName("action","id") 
					)))
					);
					//Obligations
			}	
		}
		private class Rule_RuleDeny extends Rule {
			
				Rule_RuleDeny (){
					addId("RuleDeny");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
