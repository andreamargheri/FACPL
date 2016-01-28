package foo;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.system.*;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.interfaces.*;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Main {
	
	private PDP pdp;
	private PEP pep;
	
	private Main() {
		// add policies
		LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();
		policies.add(new PolicySet_PolName());
		
		this.pdp = new PDP(it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy.class, policies, false);
		
		this.pep = new PEP(EnforcementAlgorithm.BASE);
		
		this.pep.addPEPActions(PEPAction.getPepActions());
	}

	
	public static void main(String[] args) {
		//Initialise Authorisation System
		Main system = new Main();

		// Log
		StringBuffer result = new StringBuffer();
		// Request
		LinkedList<ContextRequest> requests = new LinkedList<ContextRequest>();
		requests.add(ContextRequest_NameRequest.getContextReq());
		for (ContextRequest rcxt : requests) {
			result.append("---------------------------------------------------\n");
			AuthorisationPDP resPDP = system.pdp.doAuthorisation(rcxt);
			
			result.append("Request: " + resPDP.getId() + "\n\n");
			result.append("PDP Decision=\n " + resPDP.toString() + "\n\n");
			
			// Enforce decision
			AuthorisationPEP resPEP = system.pep.doEnforcement(resPDP);
							
			result.append("PEP Decision=\n " + resPEP.toString() + "\n");
			result.append("---------------------------------------------------\n");
		}
		
		
	}
	
	
}
