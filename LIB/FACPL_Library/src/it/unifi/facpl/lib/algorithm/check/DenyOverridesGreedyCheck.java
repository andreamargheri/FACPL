package it.unifi.facpl.lib.algorithm.check;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.StandardDecision;

public class DenyOverridesGreedyCheck implements IEvaluableAlgorithmCheck {

	private Boolean atLeastOneErrorD = false;
	private Boolean atLeastOneErrorP = false;
	private Boolean atLeastOneErrorDP = false;
	private Boolean atLeastOnePermit = false;

	@Override
	public AuthorisationPEP evaluate(List<StandardDecision> decList, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());

		l.debug("-> DENY OVERRIDES (GREEDY) CHECK STARTED");

		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));

		for (StandardDecision dec : decList) {

			if (ExtendedDecision.DENY.equals(dec)) {
				// only last obligations evaluated are returned
				l.debug("ALG.DENY-Greedy = dt: Deny");
				dr.setDecision(StandardDecision.DENY);
				return dr;
			}
			if (StandardDecision.PERMIT.equals(dec)) {
				atLeastOnePermit = true;

				continue;
			}
			if (StandardDecision.NOT_APPLICABLE.equals(dec)) {
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(dec)) {
				atLeastOneErrorD = true;
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(dec)) {
				atLeastOneErrorP = true;
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(dec)) {
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

		l.debug("ALG.DENY-Greedy = dt: NotAPP");
		dr.setDecision(StandardDecision.NOT_APPLICABLE);
		return dr;
	}

	@Override
	public void resetAlg() {
		this.atLeastOneErrorD = false;
		this.atLeastOneErrorDP = false;
		this.atLeastOneErrorP = false;
		this.atLeastOnePermit = false;

	}

}
