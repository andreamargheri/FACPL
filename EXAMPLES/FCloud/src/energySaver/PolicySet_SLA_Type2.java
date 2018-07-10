package energySaver;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_SLA_Type2 extends PolicySet {
	public PolicySet_SLA_Type2(){
		addId("SLA_Type2");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy());
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "P_2",new AttributeName("subject","profile-id") 
		)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "TYPE_2",new AttributeName("resource","vm-type") 
		)))
		);
		//PolElements
		addPolicyElement(new Rule_hyper_1_create());
		addPolicyElement(new Rule_hyper_2_create());
		addPolicyElement(new Rule_hyper_1_freeze());
		addPolicyElement(new Rule_hyper_2_freeze());
		//Obligation
		addObligation(new Obligation("log",Effect.DENY,ObligationType.O,"Not enough available resources for TYPE_2 VMs"
		)
		);
		}
		
		private class Rule_hyper_1_create extends Rule {
			
				Rule_hyper_1_create (){
					addId("hyper_1_create");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.LessThanOrEqual(), 2,new AttributeName("system","hyper1.availableResources") 
					));
					//Obligations
					addObligation(new Obligation("create",Effect.PERMIT,ObligationType.M,"HYPER_1",
					new AttributeName("system","vm-id") ,
					"TYPE_2"
					)
					);
			}	
		}
		private class Rule_hyper_2_create extends Rule {
			
				Rule_hyper_2_create (){
					addId("hyper_2_create");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.LessThanOrEqual(), 2,new AttributeName("system","hyper2.availableResources") 
					));
					//Obligations
					addObligation(new Obligation("create",Effect.PERMIT,ObligationType.M,"HYPER_2",
					new AttributeName("system","vm-id") ,
					"TYPE_2"
					)
					);
			}	
		}
		private class Rule_hyper_1_freeze extends Rule {
			
				Rule_hyper_1_freeze (){
					addId("hyper_1_freeze");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.OR,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), 0,new AttributeName("system","hyper1.availableResources") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.LessThanOrEqual(), 2,new AttributeName("system","hyper1.vm1-counter") 
					)))
					),new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), 1,new AttributeName("system","hyper1.availableResources") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.LessThanOrEqual(), 1,new AttributeName("system","hyper1.vm1-counter") 
					)))
					))
					);
					//Obligations
					addObligation(new Obligation("freeze",Effect.PERMIT,ObligationType.M,"HYPER_1",
					new ExpressionFunction(new it.unifi.facpl.lib.function.arithmetic.Subtract(), 2,new AttributeName("system","hyper1.availableResources") 
					),
					"TYPE_1"
					)
					);
					addObligation(new Obligation("create",Effect.PERMIT,ObligationType.M,"HYPER_1",
					new AttributeName("system","vm-id") ,
					"TYPE_2"
					)
					);
			}	
		}
		private class Rule_hyper_2_freeze extends Rule {
			
				Rule_hyper_2_freeze (){
					addId("hyper_2_freeze");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.OR,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), 0,new AttributeName("system","hyper2.availableResources") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.LessThanOrEqual(), 2,new AttributeName("system","hyper2.vm1-counter") 
					)))
					),new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), 1,new AttributeName("system","hyper2.availableResources") 
					)),new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.LessThanOrEqual(), 1,new AttributeName("system","hyper2.vm1-counter") 
					)))
					))
					);
					//Obligations
					addObligation(new Obligation("freeze",Effect.PERMIT,ObligationType.M,"HYPER_2",
					new ExpressionFunction(new it.unifi.facpl.lib.function.arithmetic.Subtract(), 2,new AttributeName("system","hyper2.availableResources") 
					),
					"TYPE_1"
					)
					);
					addObligation(new Obligation("create",Effect.PERMIT,ObligationType.M,"HYPER_2",
					new AttributeName("system","vm-id") ,
					"TYPE_2"
					)
					);
			}	
		}
}
