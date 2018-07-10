package e_Health;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_eDis extends PolicySet {
	public PolicySet_eDis(){
		addId("eDis");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "eDispensation",new AttributeName("resource","type") 
		));
		//PolElements
		addPolicyElement(new Rule_readPha2());
		//Obligation
		addObligation(new Obligation("log",Effect.PERMIT,ObligationType.M,new AttributeName("system","time") ,
		new AttributeName("resource","type") ,
		new AttributeName("subject","id") ,
		new AttributeName("action","id") 
		)
		);
		}
		
		private class Rule_readPha2 extends Rule {
			
				Rule_readPha2 (){
					addId("readPha2");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "pharmacist",new AttributeName("subject","role") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "read",new AttributeName("action","id") 
					)))
					),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(), new AttributeName("subject","permission") 
					,new Set(
					"e-Dis-Read"
					)
					)))
					);
					//Obligations
			}	
		}
}
