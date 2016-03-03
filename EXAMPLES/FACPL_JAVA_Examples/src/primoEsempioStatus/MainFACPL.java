package primoEsempioStatus;

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
public class MainFACPL {

	private PDP pdp;
	private PEP pep;

	public MainFACPL() throws MissingAttributeException {
		// defined list of policies included in the PDP
		LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();

		policies.add(new PolicySet_ReadWrite(ContextRequest_WriteRequestAlice.getContextReq()));

		this.pdp = new PDP(it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy.class, policies, false);

		this.pep = new PEP(EnforcementAlgorithm.DENY_BIASED);

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

		requests.add(ContextRequest_ReadRequestAlice.getContextReq()); 
		requests.add(ContextRequest_WriteRequestBob.getContextReq()); 
		requests.add(ContextRequest_ReadRequestBob.getContextReq()); 
		requests.add(ContextRequest_StopReadRequestAlice.getContextReq()); 
		requests.add(ContextRequest_StopReadRequestBob.getContextReq()); 
		
		requests.add(ContextRequest_WriteRequestAlice.getContextReq()); 
		
		
		long startR,start;
		long endR,end;
		start=System.currentTimeMillis();

		for (ContextRequest rcxt : requests) {
			result.append("---------------------------------------------------\n");
			startR=System.currentTimeMillis();
			AuthorisationPDP resPDP = system.pdp.doAuthorisation(rcxt);
			result.append("\nRequest: " + resPDP.getId() + "\n\n");
			result.append("PDP Decision=\n " + resPDP.toString() + "\n\n");
			// enforce decision
			AuthorisationPEP resPEP = system.pep.doEnforcement(resPDP);
			endR=System.currentTimeMillis();
			result.append("time per request "+(endR-startR));
			result.append("\nPEP Decision=\n " + resPEP.toString() + "\n");
			result.append("---------------------------------------------------\n");
		}
		end=System.currentTimeMillis();
		result.append("\ntime for all requests "+(end-start));
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
