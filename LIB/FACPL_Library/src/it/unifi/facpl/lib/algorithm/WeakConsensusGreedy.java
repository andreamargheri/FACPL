package it.unifi.facpl.lib.algorithm;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

/**
 * 
 * @author Andrea
 *
 */
public class WeakConsensusGreedy implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(WeakConsensusGreedy.class);
		l.debug("-> WEAK CONSENSUS started");

		LinkedList<AbstractFulfilledObligation> obligationDeny = new LinkedList<AbstractFulfilledObligation>();
		LinkedList<AbstractFulfilledObligation> obligationPermit = new LinkedList<AbstractFulfilledObligation>();

		int numOfPermit = 0;
		int numOfDeny = 0;
		Boolean atLeastOneIndet = false;

		AuthorisationPDP dr = new AuthorisationPDP();
		for (IEvaluablePolicy el : elements) {
			AuthorisationPDP d = el.evaluate(cxtRequest, extendedIndeterminate);

			if (ExtendedDecision.PERMIT.equals(d.getDecision())) {
				numOfPermit++;
				obligationPermit.addAll(d.getObligation());
			} else if (ExtendedDecision.DENY.equals(d.getDecision())) {
				numOfDeny++;
				obligationDeny.addAll(d.getObligation());
			} else if (ExtendedDecision.NOT_APPLICABLE.equals(d.getDecision())) {
				continue;
			} else {
				// one of the indeterminate results
				atLeastOneIndet = true;
			}
			// greedy version
			if (numOfPermit > 0 && numOfDeny > 0) {
				dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
				l.debug("ALG.Consensus = dt: INDET");
			}
		}

		if (numOfPermit > 0 && numOfDeny > 0) {
			dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
			l.debug("ALG.Consensus = dt: INDET");
		} else if (numOfPermit == 0 && numOfDeny > 0) {
			dr.setDecision(ExtendedDecision.DENY);
			dr.setObligation(obligationDeny);
			l.debug("ALG.Consensus = dt: DENY");
		} else if (numOfDeny == 0 && numOfPermit > 0) {
			dr.setDecision(ExtendedDecision.PERMIT);
			dr.setObligation(obligationPermit);
			l.debug("ALG.Consensus = dt: PERMIT");
		} else if (atLeastOneIndet) {
			dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
			l.debug("ALG.Consensus = dt: INDET");
		} else {
			dr.setDecision(ExtendedDecision.NOT_APPLICABLE);
			l.debug("ALG.Consensus END - Result NOT_APP");
		}

		return dr;
	}
}
