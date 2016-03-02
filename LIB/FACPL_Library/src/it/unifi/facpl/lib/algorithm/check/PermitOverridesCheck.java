package it.unifi.facpl.lib.algorithm.check;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.StandardDecision;

public class PermitOverridesCheck implements IEvaluableAlgorithmCheck {

	private Boolean atLeastOneErrorD = false;
	private Boolean atLeastOneErrorP = false;
	private Boolean atLeastOneErrorDP = false;
	private Boolean atLeastOneDeny = false;
	private Boolean atLeastOnePermit = false;
	
	@Override
	public AuthorisationPEP evaluate(List<StandardDecision> decList, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("PERMIT OVERRIDES CHECK STARTED");



		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));
		for (StandardDecision dec : decList) {


			if (ExtendedDecision.PERMIT.equals(dec)) {
				l.debug("ALG.PERMIT = dt: PERMIT");
				atLeastOnePermit = true;
				dr.setDecision(StandardDecision.PERMIT);
			}

			if (StandardDecision.DENY.equals(dec)) {
				atLeastOneDeny = true;
				continue;
			}

			if (StandardDecision.NOT_APPLICABLE.equals(dec)) {
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(dec)) {
				atLeastOneErrorDP = true;
				atLeastOneErrorP = true;
				atLeastOneErrorD = true;
				continue;
			}
		}
		if (atLeastOnePermit) {
			l.debug("ALG. PERMIT = dt: PERMIT");
			return dr;
		}
		if (atLeastOneErrorDP) {
			l.debug("ALG.PERMIT = dt: IndetDP");
			dr.setDecision(StandardDecision.INDETERMINATE);

			return dr;
		}
		if (atLeastOneErrorP && (atLeastOneErrorD || atLeastOneDeny)) {
			l.debug("ALG.PERMIT = dt: IndetDP");
			dr.setDecision(StandardDecision.INDETERMINATE);

			return dr;
		}
		if (atLeastOneErrorP) {
			l.debug("ALG.PERMIT = dt: IndetP");
			dr.setDecision(StandardDecision.INDETERMINATE);

			return dr;
		}
		if (atLeastOneDeny) {
			l.debug("ALG.PERMIT = dt: Deny");
			dr.setDecision(StandardDecision.DENY);

			return dr;
		}
		if (atLeastOneErrorD) {
			l.debug("ALG.PERMIT = dt: IndetD");
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		// otherwise return not app
		l.debug("ALG.PERMIT = dt: NotAPP");
		dr.setDecision(StandardDecision.NOT_APPLICABLE);
		return dr;
	}

	@Override
	public void resetAlg() {
		this.atLeastOneErrorD = false;
		this.atLeastOneErrorP = false;
		this.atLeastOneErrorDP = false;
		this.atLeastOneDeny = false;
		this.atLeastOnePermit = false;
	}

}
