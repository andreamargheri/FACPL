package isola2014;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_Rescuer extends PolicySet {
	public PolicySet_Rescuer(){
		addId("Rescuer");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy());
		//PolElements
		addPolicyElement(new Rule_victimFound());
		//Obligation
		}
		
		private class Rule_victimFound extends Rule {
			
				Rule_victimFound (){
					addId("victimFound");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "qry",new AttributeName("action","action-id") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "position",new AttributeName("action","item") 
					)))
					);
					//Obligations
					addObligation(new Obligation("put",Effect.PERMIT,ObligationType.M,"stop"
					)
					);
			}	
		}
}
