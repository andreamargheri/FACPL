package it.unifi.facpl.lib.algorithm.check;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.PermitOverrides;
import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

public class PermitOverridesCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(PermitOverridesCheck.class);
		l.debug("PERMIT OVERRIDES CHECK STARTED");

		Boolean atLeastOneErrorD = false;
		Boolean atLeastOneErrorP = false;
		Boolean atLeastOneErrorDP = false;
		Boolean atLeastOneDeny = false;
		Boolean atLeastOnePermit = false;

		LinkedList<AbstractFulfilledObligation> obligationDeny = new LinkedList<AbstractFulfilledObligation>();

		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));
		for (FulfilledObligationCheck obl : checkObl) {

			StandardDecision dec = obl.getObligationResult(cxtRequest);

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

}
