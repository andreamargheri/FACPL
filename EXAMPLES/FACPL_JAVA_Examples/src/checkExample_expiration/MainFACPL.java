package checkExample_expiration;

import java.util.LinkedList;

import it.unifi.facpl.lib.algorithm.DenyOverrides;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.lib.policy.FacplPolicy;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.PDP;
import it.unifi.facpl.system.PEP;
import it.unifi.facpl.system.PEPCheck;

@SuppressWarnings("all")
public class MainFACPL {

	private PDP pdp;
	private PEP pep;

	public MainFACPL() throws MissingAttributeException {
		// defined list of policies included in the PDP
		LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();
		// policies.add(new PolicySet_NamePolicySetTwo());
		policies.add(new PolicySet_NamePolicySetTwo(ContextRequest_NameRequest.getContextReq()));
		this.pdp = new PDP(it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy.class, policies, false);

		this.pep = new PEPCheck(EnforcementAlgorithm.DENY_BIASED, new DenyOverrides(),
				ContextRequest_NameRequest.getContextReq());

		this.pep.addPEPActions(PEPAction.getPepActions());
	}

	/*
	 * ENTRY POINT FOR EVALUATION
	 */
	public static void main(String[] args) throws MissingAttributeException {
		// Initialise Authorisation System
		MainFACPL system = new MainFACPL();
		// log
		StringBuffer result = new StringBuffer();
		// request

		LinkedList<ContextRequest_Status> requests = new LinkedList<ContextRequest_Status>();

		requests.add(ContextRequest_NameRequest.getContextReq()); // 1: PDP
																	// PERMIT -
																	// PEP
																	// PERMIT

		requests.add(ContextRequest_NameRequest.getContextReq()); // 2: PDP ->
																	// PEP
																	// PERMIT

		requests.add(ContextRequest_NameRequest.getContextReq()); // 3: PDP ->
																	// PEP
																	// PERMIT
		requests.add(ContextRequest_NameRequest.getContextReq()); // 4: PDP
																	// PERMIT ->
																	// PEP
																	// PERMIT

		requests.add(ContextRequest_NameRequest.getContextReq()); // 5: PDP ->
																	// PEP
																	// PERMIT

		requests.add(ContextRequest_NameRequest.getContextReq()); // 6: PDP ->
																	// PEP
																	// PERMIT

		AuthorisationPDP resPDP = null;
		AuthorisationPEP resPEP = null;
		Integer i = 1;
		for (ContextRequest rcxt : requests) {
			boolean PDPed = false;
			System.err.println("REQUEST N: " + i.toString());
			if (resPEP == null || resPEP.PDPpassthrough() == false) {
				resPDP = system.pdp.doAuthorisation(rcxt);
				PDPed = true;
				System.err.println("Request: " + resPDP.getId() + "\n\n");
				System.err.println("PDP Decision=\n " + resPDP.toString() + "\n\n");
			}
			// enforce decision
			if (resPEP != null && resPEP.PDPpassthrough() == false && PDPed == false) {
				System.err.println("BACK TO PDP");
				resPDP = system.pdp.doAuthorisation(rcxt);
				System.err.println("PDP Decision=\n " + resPDP.toString() + "\n\n");

				resPEP = system.pep.doEnforcement(resPDP);
				
			}
			resPEP = system.pep.doEnforcement(resPDP);
			System.err.println("PEP Decision=\n " + resPEP.toString() + "\n");
			i += 1;

		}
		// System.out.println(result.toString());
		// ShowResult.showResult(result);
	}

	public PDP getPdp() {
		return pdp;
	}

	public PEP getPep() {
		return pep;
	}

}