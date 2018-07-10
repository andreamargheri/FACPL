package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_19 extends PolicySet {
	public PolicySet_RPSlist_19(){
		addId("RPSlist_19");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "paper-review-info-submissionStatus_rc",new AttributeName("resource","resource-class") 
		));
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_19_0());
		//Obligation
		}
		
}
