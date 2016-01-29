package Devrim;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_AccessRules extends PolicySet {
	public PolicySet_AccessRules(){
		addId("AccessRules");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		//PolElements
		addPolicyElement(new PolicySet_UniversityALogin());
		addPolicyElement(new PolicySet_CorporationBRead());
		addPolicyElement(new PolicySet_HospitalC());
		//Obligation
		}
		
}
