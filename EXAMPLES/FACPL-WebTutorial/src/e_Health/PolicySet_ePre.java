package e_Health;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_ePre extends PolicySet {
	public PolicySet_ePre(){
		addId("ePre");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "ePrescription",new AttributeName("resource","type") 
		));
		//PolElements
		addPolicyElement(new Rule_readDoc());
		addPolicyElement(new Rule_readPha1());
		//Obligation
		addObligation(new Obligation("log",Effect.PERMIT,ObligationType.M,new AttributeName("system","time") ,
		new AttributeName("resource","type") ,
		new AttributeName("subject","id") ,
		new AttributeName("action","id") 
		)
		);
		}
		
		private class Rule_readDoc extends Rule {
			
				Rule_readDoc (){
					addId("readDoc");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "doctor",new AttributeName("subject","role") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "read",new AttributeName("action","id") 
					)))
					),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(), new AttributeName("subject","permission") 
					,new Set(
					"e-Pre-Read"
					)
					)))
					);
					//Obligations
			}	
		}
		private class Rule_readPha1 extends Rule {
			
				Rule_readPha1 (){
					addId("readPha1");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "pharmacist",new AttributeName("subject","role") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "read",new AttributeName("action","id") 
					)))
					),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(), new AttributeName("subject","permission") 
					,new Set(
					"e-Pre-Read"
					)
					)))
					);
					//Obligations
			}	
		}
}
