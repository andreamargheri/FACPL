package it.unifi.facpl.lib.algorithm.check;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.DenyOverridesGreedy;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.StandardDecision;

public class DenyOverridesGreedyCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());

		l.debug("-> DENY OVERRIDES (GREEDY) CHECK STARTED");

		Boolean atLeastOneErrorD = false;
		Boolean atLeastOneErrorP = false;
		Boolean atLeastOneErrorDP = false;
		Boolean atLeastOnePermit = false;


		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));

		for (FulfilledObligationCheck el : checkObl) {

			StandardDecision d = el.getObligationResult(cxtRequest);

			if (ExtendedDecision.DENY.equals(d)) {
				// only last obligations evaluated are returned
				l.debug("ALG.DENY-Greedy = dt: Deny");
				dr.setDecision(StandardDecision.DENY);
				return dr;
			}
			if (StandardDecision.PERMIT.equals(d)) {
				atLeastOnePermit = true;

				continue;
			}
			if (StandardDecision.NOT_APPLICABLE.equals(d)) {
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(d)) {
				atLeastOneErrorD = true;
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(d)) {
				atLeastOneErrorP = true;
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(d)) {
				atLeastOneErrorDP = true;
				continue;
			}
		}
		if (atLeastOneErrorDP) {
			l.debug("ALG.DENY-Greedy= dt: IndetDP");
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		if (atLeastOneErrorD && (atLeastOneErrorP || atLeastOnePermit)) {
			l.debug("ALG.DENY-Greedy = dt: IndetDP");
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		if (atLeastOneErrorD) {
			l.debug("ALG.DENY-Greedy = dt: IndetD");
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		if (atLeastOnePermit) {
			l.debug("ALG.DENY-Greedy = dt: Permit");
			dr.setDecision(StandardDecision.PERMIT);
			return dr;
		}
		if (atLeastOneErrorP) {
			l.debug("ALG.DENY-Greedy = dt: IndetP");
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		// otherwise return not app
		l.debug("ALG.DENY-Greedy = dt: NotAPP");
		dr.setDecision(StandardDecision.NOT_APPLICABLE);
		return dr;
	}

}
