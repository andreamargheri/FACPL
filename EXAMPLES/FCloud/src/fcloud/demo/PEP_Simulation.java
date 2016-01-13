package fcloud.demo;

import java.util.LinkedList;

import fcloud.requests.ContextRequest_RequestCreate;
import fcloud.requests.ContextRequest_RequestCreateP;
import fcloud.requests.ContextRequest_RequestRelease;
import fcloud.requests.ContextRequest_RequestReleaseN;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.system.FacplAuthorisationSystem;

public class PEP_Simulation {

	public static void main(String[] args) throws Exception {
		// initilize environment and PEP actions
		PEP_Simulation.initialize();

		// log
		StringBuffer result = new StringBuffer();

		// request
		LinkedList<ContextRequest> requestes = new LinkedList<ContextRequest>();

		requestes.add(ContextRequest_RequestCreate.getContextReq());
		requestes.add(ContextRequest_RequestCreate.getContextReq());
		requestes.add(ContextRequest_RequestCreateP.getContextReq());
		requestes.add(ContextRequest_RequestReleaseN.getContextReq());
		requestes.add(ContextRequest_RequestRelease.getContextReq());

		for (ContextRequest rcxt : requestes) {
			result.append("---------------------------------------------------\n");
			/*
			 * TO CHANGE WITH THE CORRECT PDP REFERENCE
			 */

			AuthorisationPDP resPDP = loadBalancer.PDP.evalRequest(rcxt);

			/* ---------------------------------- */

			result.append("Request: " + resPDP.getId() + "\n\n");
			result.append("PDP Decision=\n " + resPDP.toString() + "\n\n");
			// enforce decision
			AuthorisationPEP resPEP = PEP_Simulation.enforceDecision(resPDP);
			result.append("PEP Decision=\n " + resPEP.toString() + "\n");
			result.append("---------------------------------------------------\n");
		}
		System.out.println(result);
	}

	public static AuthorisationPEP enforceDecision(AuthorisationPDP pdpRes) {
		// algorithm for PEP
		String alg = "base";
		// call enforcement
		return FacplAuthorisationSystem.doEnforcement(alg, pdpRes);
	}

	private static void initialize() {
		// initialize Cloud Simulation Environment
		FCloud.getInstance().initializeSimulation("./system");
		// initialize PEP
		FacplAuthorisationSystem.inizializePepActions(PEPAction.class);
	}

}
