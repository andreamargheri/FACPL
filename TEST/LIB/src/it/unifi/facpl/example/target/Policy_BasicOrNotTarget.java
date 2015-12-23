package it.unifi.facpl.example.target;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;

@SuppressWarnings("all")
public class Policy_BasicOrNotTarget extends PolicySet{
	
	public Policy_BasicOrNotTarget(){
		addId("BasicOrNotTarget");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyOverrides.class);
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.OR,new ExpressionBooleanTree(ExprBooleanConnector.NOT,new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, false
		,new AttributeName("envirnoment","time") 
		))
		)
		,new ExpressionBooleanTree(ExprBooleanConnector.NOT,new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, false
		,new AttributeName("envirnoment","time") 
		))
		)
		)
		);
		//Rule
		addPolicyElement(new rule1());
		//Obligations
	}
	
	private class rule1 extends Rule{
		
			rule1 (){
				addId("rule1");
				//Effect
				addEffect(Effect.DENY);
				
		}	
	}
	
	
}
