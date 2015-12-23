package it.unifi.facpl.example.epsos;

import java.util.LinkedList;
import java.util.List;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.policy.FacplPolicy;
import it.unifi.facpl.system.FacplAuthorisationSystem;

@SuppressWarnings("all")
public class PDP {
	private static List<FacplPolicy> policies;

	private static void inizialize() {
		// add policies
		policies = new LinkedList<FacplPolicy>();
		policies.add(new Policy_ePre());
		policies.add(new Policy_summary());
	}

	public static AuthorisationPDP evalRequest(ContextRequest request) {
		if (policies == null)
			inizialize();
		Class<? extends IEvaluableAlgorithm> pdpAlg = it.unifi.facpl.lib.algorithm.DenyOverrides.class;
		// flag for choosing how manage indeterminate extended values
		// True = when target INDETERMINATE combining algorithm run
		// False = when target INDETERMINATE evaluation return INDETERMINATE
		// without run combining algorithm
		Boolean extendedIndeterminate = false;
		// main
		return FacplAuthorisationSystem.doAuthorisation(pdpAlg, policies, request, extendedIndeterminate);
	}
}
