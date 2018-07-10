package energySaver;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_Create_Policies extends PolicySet {
	public PolicySet_Create_Policies(){
		addId("Create_Policies");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy());
		//Target
		addTarget(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(), "CREATE",new AttributeName("action","action-id") 
		));
		//PolElements
		addPolicyElement(new PolicySet_SLA_Type1());
		addPolicyElement(new PolicySet_SLA_Type2());
		//Obligation
		}
		
}
