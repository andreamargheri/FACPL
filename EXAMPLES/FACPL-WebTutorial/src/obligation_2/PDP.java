package obligation_2;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.system.*;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.interfaces.*;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class PDP {
	private static List<FacplPolicy> policies;

	private static void inizialize() {
		// add policies
		policies = new LinkedList<FacplPolicy>();
		policies.add(new PolicySet_polSet());
	}

	public static AuthorisationPDP evalRequest(ContextRequest request) {
		if (policies == null)
			inizialize();
		Class<? extends IEvaluableAlgorithm> pdpAlg = it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class;
		// flag for choosing how manage indeterminate extended values
		// True = when target INDETERMINATE combining algorithm run
		// False = when target INDETERMINATE evaluation return INDETERMINATE
		// without running combining algorithm
		Boolean extendedIndeterminate = true;
		// main
		return FacplAuthorisationSystem.doAuthorisation(pdpAlg, policies, request, extendedIndeterminate);
	}
}
