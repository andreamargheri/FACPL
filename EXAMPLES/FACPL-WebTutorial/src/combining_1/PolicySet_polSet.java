package combining_1;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_polSet extends PolicySet {
	public PolicySet_polSet(){
		addId("polSet");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.FirstApplicableGreedy());
		//PolElements
		addPolicyElement(new PolicySet_first());
		addPolicyElement(new PolicySet_second());
		//Obligation
		}
		
}
