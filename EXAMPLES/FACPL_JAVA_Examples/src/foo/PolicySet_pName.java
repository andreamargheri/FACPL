package foo;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_pName extends PolicySet {
	
	public PolicySet_pName(){
		addId("pName");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
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
