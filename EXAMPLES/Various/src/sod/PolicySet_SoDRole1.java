package sod;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_SoDRole1 extends PolicySet {
	public PolicySet_SoDRole1(){
		addId("SoDRole1");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		//PolElements
		addPolicyElement(new Rule_ruleName());
		//Obligation
		}
		
		private class Rule_ruleName extends Rule {
			
				Rule_ruleName (){
					addId("ruleName");
					//Effect
					addEffect(Effect.PERMIT);
					//Obligations
			}	
		}
}
