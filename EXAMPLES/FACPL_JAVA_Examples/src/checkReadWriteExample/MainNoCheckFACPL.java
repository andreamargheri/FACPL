package checkReadWriteExample;


import java.util.LinkedList;

import it.unifi.facpl.lib.algorithm.check.DenyOverridesCheck;
import it.unifi.facpl.lib.algorithm.check.DenyOverridesGreedyCheck;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.policy.FacplPolicy;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.PDP;
import it.unifi.facpl.system.PEP;

@SuppressWarnings("all")
public class MainNoCheckFACPL {

	private PDP pdp;
	private PEP pep;

	public MainNoCheckFACPL() throws MissingAttributeException {
		// defined list of policies included in the PDP
		LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();

		policies.add(new PolicySet_ReadWrite());
		this.pdp = new PDP(it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy.class, policies, false);

		this.pep = new PEP(EnforcementAlgorithm.DENY_BIASED);

		this.pep.addPEPActions(PEPAction.getPepActions());
	}

	/*
	 * ENTRY POINT FOR EVALUATION
	 */
	public static void main(String[] args) throws MissingAttributeException {
		// Initialise Authorisation System
		MainNoCheckFACPL system = new MainNoCheckFACPL();
		// log
		StringBuffer result = new StringBuffer();
		// request

		LinkedList<ContextRequest_Status> requests = new LinkedList<ContextRequest_Status>();

//		requests.add(ContextRequest_ReadRequestBob.getContextReq());//permit pdp
//		requests.add(ContextRequest_ReadRequestBob.getContextReq());//permit pep only
//		requests.add(ContextRequest_ReadRequestAlice.getContextReq());
//		requests.add(ContextRequest_ReadRequestBob.getContextReq());//permit pep only
//		requests.add(ContextRequest_ReadRequestBob.getContextReq());//permit pep only

		requests.add(ContextRequest_WriteRequestAlice.getContextReq());//permit 		#

		requests.add(ContextRequest_ReadRequestBob.getContextReq()); //read while 		#
																  															//write deny
//		requests.add(ContextRequest_WriteRequestAlice.getContextReq());//write while
//																  																//write deny
//
//		requests.add(ContextRequest_StopWriteRequestAlice.getContextReq());//permit 	#
//
//		requests.add(ContextRequest_ReadRequestBob.getContextReq());//permit			#


		AuthorisationPDP resPDP = null;
		AuthorisationPEP resPEP = null;
		int i = 1;
		long startR,start;
		long endR,end;
		start=System.currentTimeMillis();
		for (ContextRequest_Status rcxt : requests) {

			result.append("---------------------------------------------------\n");
			result.append("REQUEST N: "+(i)+"\n");
			result.append("REQUEST: "+rcxt.getRequest().getId());
			result.append("\nPEP Decision=\n ");
			startR=System.currentTimeMillis();
			System.err.println("REQUEST N: " + i);
			resPDP = system.pdp.doAuthorisation(rcxt);
			resPEP = system.pep.doEnforcement(resPDP,rcxt);
			result.append(resPEP);
			endR=System.currentTimeMillis();
			result.append("\ntime per request "+(endR-startR));
			result.append("\n---------------------------------------------------\n");
			i += 1;
		}
		end=System.currentTimeMillis();
		result.append("\ntime for all requests "+(end-start));
		System.out.println(result.toString());
	}

	public PDP getPdp() {
		return pdp;
	}

	public PEP getPep() {
		return pep;
	}

}
