package loadBalancer;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.Obligation;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;

@SuppressWarnings("all")	
public class PolicySet_SLA_Type1 extends PolicySet {
	public PolicySet_SLA_Type1(){
		addId("SLA_Type1");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		//Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.OR,new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "P_1",new AttributeName("subject","profile-id") 
		)
		),new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "P_2",new AttributeName("subject","profile-id") 
		)
		))
		),new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "TYPE_1",new AttributeName("resource","vm-type") 
		)
		))
		);
		//PolElements
		addPolicyElement(new Rule_hyper_1());
		addPolicyElement(new Rule_hyper_2());
		//Obligation
		addObligation(new Obligation("log",Effect.DENY,ObligationType.O,"Not enough available resources for TYPE_1 VMs"
		)
		);
		}
		
		private class Rule_hyper_1 extends Rule {
			
				Rule_hyper_1 (){
					addId("hyper_1");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThanOrEqual.class, 1,new AttributeName("system","hyper1.availableResources") 
					)
					),new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThanOrEqual.class, new AttributeName("system","hyper2.availableResources") 
					,new AttributeName("system","hyper1.availableResources") 
					)
					))
					);
					//Obligations
					addObligation(new Obligation("create",Effect.PERMIT,ObligationType.M,"HYPER_1",
					new AttributeName("system","vm-id") ,
					"TYPE_1"
					)
					);
			}	
		}
		private class Rule_hyper_2 extends Rule {
			
				Rule_hyper_2 (){
					addId("hyper_2");
					//Effect
					addEffect(Effect.PERMIT);
					//Target
					addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThanOrEqual.class, 1,new AttributeName("system","hyper2.availableResources") 
					)
					),new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThanOrEqual.class, new AttributeName("system","hyper1.availableResources") 
					,new AttributeName("system","hyper2.availableResources") 
					)
					))
					);
					//Obligations
					addObligation(new Obligation("create",Effect.PERMIT,ObligationType.M,"HYPER_2",
					new AttributeName("system","vm-id") ,
					"TYPE_1"
					)
					);
			}	
		}
}
