package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;

public class DenyUnlessPermitGreedyCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> DENY UNLESS PERMIT - Greedy started");

		

		AuthorisationPEP dr = new AuthorisationPEP();
		for (FulfilledObligationCheck el : checkObl) {
			StandardDecision d = el.getObligationResult(cxtRequest);
			if (d.equals(StandardDecision.PERMIT)) {
				dr.setDecision(StandardDecision.PERMIT);

				return dr;
			} else {
				if (d.equals(StandardDecision.DENY)) {

				}
			}
		}
		dr.setDecision(StandardDecision.DENY);

		return dr;
	}

}
