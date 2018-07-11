package obligation_2;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_polSet extends PolicySet {
	public PolicySet_polSet(){
		addId("polSet");
		//Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
		//PolElements
		addPolicyElement(new PolicySet_obligation_1());
		addPolicyElement(new PolicySet_obligation_2());
		//Obligation
		addObligation(new Obligation("compress", Effect.PERMIT, ObligationType.O, null));
		addObligation(new Obligation("mailTo",Effect.DENY,ObligationType.M,new AttributeName("resource","patient-id.mail") ,
		"Data requested by unauthorized subject"
		)
		);
		}
		
}
