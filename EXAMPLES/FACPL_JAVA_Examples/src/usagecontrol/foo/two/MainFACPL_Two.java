package usagecontrol.foo.two;

import java.util.ArrayList;
import java.util.LinkedList;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.policy.FacplPolicy;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.PDP;
import it.unifi.facpl.system.PEP;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

@SuppressWarnings("all")
public class MainFACPL_Two {

	private PDP pdp;
	private PEP pep;
	private static FacplStatus status;
	
	public MainFACPL_Two() throws MissingAttributeException {
		// defined list of policies included in the PDP
		LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();
		// policies.add(new PolicySet_NamePolicySetTwo());
		policies.add(new PolicySet_NamePolicySetTwo(ContextRequest_NameRequest.getContextReq()));
		this.pdp = new PDP(it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy.class, policies, false);

		this.pep = new PEP(EnforcementAlgorithm.DENY_BIASED);

		this.pep.addPEPActions(PEPAction.getPepActions());
	}



	/*
	 * ENTRY POINT FOR EVALUATION
	 */
	public static void main(String[] args) throws MissingAttributeException {
		// Initialise Authorisation System
		MainFACPL_Two system = new MainFACPL_Two();
		// log
		StringBuffer result = new StringBuffer();
		// request
		LinkedList<ContextRequest_Status> requests = new LinkedList<ContextRequest_Status>();
		requests.add(ContextRequest_NameRequest.getContextReq());
		for (ContextRequest rcxt : requests) {
			result.append("---------------------------------------------------\n");
			AuthorisationPDP resPDP = system.pdp.doAuthorisation(rcxt);
			result.append("Request: " + resPDP.getId() + "\n\n");
			result.append("PDP Decision=\n " + resPDP.toString() + "\n\n");
			// enforce decision
			AuthorisationPEP resPEP = system.pep.doEnforcement(resPDP);
			result.append("PEP Decision=\n " + resPEP.toString() + "\n");
			result.append("---------------------------------------------------\n");
		}
		System.out.println(result.toString());
		// ShowResult.showResult(result);
	}

	public PDP getPdp() {
		return pdp;
	}

	public PEP getPep() {
		return pep;
	}

}