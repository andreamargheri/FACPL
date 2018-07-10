package e_Health;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_denyAll extends PolicySet {
	public PolicySet_denyAll(){
		addId("denyAll");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.DenyOverridesGreedy());
		//PolElements
		addPolicyElement(new Rule_denyRule());
		//Obligation
		}
		
		private class Rule_denyRule extends Rule {
			
				Rule_denyRule (){
					addId("denyRule");
					//Effect
					addEffect(Effect.DENY);
					//Obligations
			}	
		}
}
