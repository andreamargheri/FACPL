package isola2014;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_Explorer extends PolicySet {
	public PolicySet_Explorer(){
		addId("Explorer");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy());
		//PolElements
		addPolicyElement(new Rule_stopExploration());
		addPolicyElement(new Rule_batteryLevel());
		//Obligation
		}
		
		private class Rule_stopExploration extends Rule {
			
				Rule_stopExploration (){
					addId("stopExploration");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "qry",new AttributeName("action","action-id") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "victimPerceived",new AttributeName("action","item") 
					)))
					);
					//Obligations
					addObligation(new Obligation("put",Effect.PERMIT,ObligationType.M,"stop"
					)
					);
					addObligation(new Obligation("put",Effect.PERMIT,ObligationType.M,"role",
					"rescuer"
					)
					);
			}	
		}
		private class Rule_batteryLevel extends Rule {
			
				Rule_batteryLevel (){
					addId("batteryLevel");
					//Effect
					addEffect(Effect.DENY);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "qry",new AttributeName("action","action-id") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "isMoving",new AttributeName("action","item") 
					)))
					),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.GreaterThan(), 20,new AttributeName("subject","batteryLevel") 
					)))
					);
					//Obligations
					addObligation(new Obligation("put",Effect.DENY,ObligationType.M,"direction"
					)
					);
			}	
		}
}
