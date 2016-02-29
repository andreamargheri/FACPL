package checkReadWriteExample;


import java.util.LinkedList;

import it.unifi.facpl.lib.algorithm.check.DenyOverridesCheck;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.policy.FacplPolicy;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.PDP;
import it.unifi.facpl.system.PEP;
import it.unifi.facpl.system.PEPCheck;

@SuppressWarnings("all")
public class MainFACPL {

	private PDP pdp;
	private PEPCheck pep;

	public MainFACPL() throws MissingAttributeException {
		// defined list of policies included in the PDP
		LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();
		// policies.add(new PolicySet_NamePolicySetTwo());
		policies.add(new PolicySet_ReadWrite(ContextRequest_ReadRequest.getContextReq()));
		this.pdp = new PDP(it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy.class, policies, false);

		this.pep = new PEPCheck(EnforcementAlgorithm.DENY_BIASED, new DenyOverridesCheck(), this.pdp);

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

		requests.add(ContextRequest_ReadRequest.getContextReq()); 
		requests.add(ContextRequest_ReadRequest.getContextReq()); 
		requests.add(ContextRequest_ReadRequest.getContextReq()); 
		requests.add(ContextRequest_ReadRequest.getContextReq()); 
		requests.add(ContextRequest_ReadRequest.getContextReq()); 

		requests.add(ContextRequest_WriteRequest.getContextReq()); 
		requests.add(ContextRequest_ReadRequest.getContextReq()); 
		requests.add(ContextRequest_StopWriteRequest.getContextReq());
		requests.add(ContextRequest_ReadRequest.getContextReq());
		requests.add(ContextRequest_ReadRequest.getContextReq());
		requests.add(ContextRequest_ReadRequest.getContextReq());
		requests.add(ContextRequest_ReadRequest.getContextReq());

		AuthorisationPDP resPDP = null;
		AuthorisationPEP resPEP = null;
		Integer i = 1;
		for (ContextRequest rcxt : requests) {
			System.err.println("REQUEST N: " + i.toString()+"\n");
			System.err.println(system.pep.doAuthorisation(rcxt));
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