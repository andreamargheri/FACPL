package foo;

import javax.swing.JOptionPane;

import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.system.*;
import it.unifi.facpl.lib.util.*;

import java.util.LinkedList;

@SuppressWarnings("all")
public class PEP {

	/*
	 * ENTRY POINT FOR EVALUATION
	 */
	public static void main(String[] args) {
		// initialize PEP
		FacplAuthorisationSystem.inizializePepActions(PEPAction.class);
		// log
		StringBuffer result = new StringBuffer();
		// request
		LinkedList<ContextRequest> requests = new LinkedList<ContextRequest>();
		requests.add(ContextRequest_NameRequest.getContextReq());
		for (ContextRequest rcxt : requests) {
			result.append("---------------------------------------------------\n");
			AuthorisationPDP resPDP = PDP.evalRequest(rcxt);
			result.append("Request: " + resPDP.getId() + "\n\n");
			result.append("PDP Decision=\n " + resPDP.toString() + "\n\n");
			// enforce decision
			AuthorisationPEP resPEP = enforceDecision(resPDP);
			result.append("PEP Decision=\n " + resPEP.toString() + "\n");
			result.append("---------------------------------------------------\n");
		}
	}

	public static AuthorisationPEP enforceDecision(AuthorisationPDP pdpRes) {
		// algrothm for PEP
		String alg = "deny-biased";
		// call enforcement
		return FacplAuthorisationSystem.doEnforcement(alg, pdpRes);
	}

}
