package sod;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_HospitalC extends PolicySet {
	public PolicySet_HospitalC(){
		addId("HospitalC");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Hospital C",new AttributeName("resource","destination") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Hospital C",new AttributeName("subject","locality") 
		)))
		),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "University A",new AttributeName("subject","organization") 
		)))
		),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Portable",new AttributeName("subject","originating-device") 
		)))
		);
		//PolElements
		addPolicyElement(new Rule_ruleCa());
		//Obligation
		}
		
		private class Rule_ruleCa extends Rule {
			
				Rule_ruleCa (){
					addId("ruleCa");
					//Effect
					addEffect(Effect.DENY);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "Write",new AttributeName("action","action-id") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(), new Set(
					"JOINT-PROJECT",
					"HEALTH-RECORDS",
					"JRAPP-EXECUTE"
					)
					,new AttributeName("subject","permission") 
					)))
					);
					//Obligations
			}	
		}
}
