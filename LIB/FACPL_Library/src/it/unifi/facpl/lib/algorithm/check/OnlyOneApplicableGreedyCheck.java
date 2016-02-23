package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.OnlyOneApplicableGreedy;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;

public class OnlyOneApplicableGreedyCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {

		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> ONLY ONE APPLICABLE-Greedy started");

		Boolean atLeastOne = false;
		FulfilledObligationCheck selectedPolicy = null;
		StandardDecision appResult;

		AuthorisationPEP dr = new AuthorisationPEP();

		for (FulfilledObligationCheck el : checkObl) {
			appResult = el.getObligationResult(cxtRequest);

			if (appResult.equals(StandardDecision.INDETERMINATE)) {
				dr.setDecision(StandardDecision.INDETERMINATE);
				return dr;
			}
			if (appResult.equals(StandardDecision.PERMIT)) {
				if (atLeastOne) {
					dr.setDecision(StandardDecision.INDETERMINATE);
					return dr;
				} else {
					atLeastOne = true;
					selectedPolicy = el;
				}
			}
			if (appResult.equals(StandardDecision.PERMIT)) {
				continue;
			}
		}
		if (atLeastOne) {
			l.debug("Only one policy applied. Returned its decision result");
			dr.setDecision(selectedPolicy.getObligationResult(cxtRequest));
			return dr;
		} else {
			dr.setDecision(StandardDecision.NOT_APPLICABLE);
			l.debug("No policy applied");
			return dr;
		}
	}

}
