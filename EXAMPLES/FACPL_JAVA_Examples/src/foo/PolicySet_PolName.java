package foo;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_PolName extends PolicySet {
	public PolicySet_PolName(){
		addId("PolName");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermit.class);
		//Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "value",new AttributeName("category","id") 
		)
		);
		//PolElements
		addPolicyElement(new Rule_rule1());
		//Obligation
		}
		
		private class Rule_rule1 extends Rule {
			
				Rule_rule1 (){
					addId("rule1");
					//Effect
					addEffect(Effect.PERMIT);
					//Obligations
			}	
		}
}
