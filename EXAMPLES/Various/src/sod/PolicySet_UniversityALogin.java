package sod;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_UniversityALogin extends PolicySet {
	public PolicySet_UniversityALogin(){
		addId("UniversityALogin");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "University A",new AttributeName("resource","destination") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Corporation B",new AttributeName("subject","organization") 
		)))
		),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Corporation B",new AttributeName("subject","locality") 
		)))
		),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Portable",new AttributeName("subject","originating-device") 
		)))
		);
		//PolElements
		addPolicyElement(new Rule_rule1A());
		//Obligation
		}
		
		private class Rule_rule1A extends Rule {
			
				Rule_rule1A (){
					addId("rule1A");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Login",new AttributeName("action","action-id") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(), new Set(
					"JOINT-PROJECT",
					"JRAPP-EXECUTE"
					)
					,new AttributeName("subject","permission") 
					)))
					);
					//Obligations
			}	
		}
}
