package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.StrongConsensusGreedy;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;

public class StrongConsensusGreedyCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {

		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> STRONG CONSENSUS started");

		int numOfPermit = 0;
		int numOfDeny = 0;

		Boolean atLeastOneNotApp = false;

		Boolean noConsensus = false;

		AuthorisationPEP dr = new AuthorisationPEP();
		for (FulfilledObligationCheck el : checkObl) {
			StandardDecision d = el.getObligationResult(cxtRequest);

			if (StandardDecision.PERMIT.equals(d)) {
				numOfPermit++;

				if (numOfDeny > 0 || atLeastOneNotApp) {
					noConsensus = true;
					break;
				}
			} else if (StandardDecision.DENY.equals(d)) {
				numOfDeny++;

				if (numOfPermit > 0 || atLeastOneNotApp) {
					noConsensus = true;
					break;
				}
			} else if (StandardDecision.NOT_APPLICABLE.equals(d)) {
				if (numOfDeny > 0 || numOfPermit > 0) {
					noConsensus = true;
					break;
				}
			} else {
				// no consensus when decision is indeterminate
				dr.setDecision(StandardDecision.INDETERMINATE);
				l.debug("ALG.Consensus = dt: INDET");
				return dr;
			}

		}

		if (noConsensus) {
			dr.setDecision(StandardDecision.INDETERMINATE);
			l.debug("ALG.Consensus = dt: INDET");
		} else if (numOfPermit > 0) {
			dr.setDecision(StandardDecision.PERMIT);
			l.debug("ALG.Consensus = dt: PERMIT");
		} else if (numOfDeny > 0) {
			dr.setDecision(StandardDecision.DENY);
			l.debug("ALG.Consensus = dt: DENY");
		} else {
			dr.setDecision(StandardDecision.NOT_APPLICABLE);
			l.debug("ALG.Consensus END - Result NOT_APP");
		}

		return dr;
	}

}
