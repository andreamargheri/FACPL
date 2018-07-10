package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_17 extends PolicySet {
	public PolicySet_RPSlist_17(){
		addId("RPSlist_17");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "paper-review-info_rc",new AttributeName("resource","resource-class") 
		));
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_17_0());
		//Obligation
		}
		
}
