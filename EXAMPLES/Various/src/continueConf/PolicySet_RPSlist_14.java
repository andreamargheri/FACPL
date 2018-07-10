package continueConf;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_RPSlist_14 extends PolicySet {
	public PolicySet_RPSlist_14(){
		addId("RPSlist_14");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicable());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "paper-conflicts_rc",new AttributeName("resource","resource-class") 
		));
		//PolElements
		addPolicyElement(new PolicySet_RPSlist_14_0());
		//Obligation
		}
		
}
