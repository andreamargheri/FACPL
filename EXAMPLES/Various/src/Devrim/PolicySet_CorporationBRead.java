package Devrim;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_CorporationBRead extends PolicySet {
	public PolicySet_CorporationBRead(){
		addId("CorporationBRead");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "University A",new AttributeName("resource","destination") 
		)
		),new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Corporation B",new AttributeName("subject","organization") 
		)
		))
		),new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "University A",new AttributeName("subject","locality") 
		)
		))
		);
		//PolElements
		addPolicyElement(new Rule_rule1B());
		//Obligation
		}
		
		private class Rule_rule1B extends Rule {
			
				Rule_rule1B (){
					addId("rule1B");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Read",new AttributeName("action","action-id") 
					)
					),new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class, new Set(
					"JOINT-PROJECT",
					"HEALTH-RECORDS",
					"JRAPP-EXECUTE"
					)
					,new AttributeName("subject","permission") 
					)
					))
					);
					//Obligations
			}	
		}
}
