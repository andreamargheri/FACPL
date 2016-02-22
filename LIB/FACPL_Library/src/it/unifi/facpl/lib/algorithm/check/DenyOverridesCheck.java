package it.unifi.facpl.lib.algorithm.check;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.system.PEPCheck;

public class DenyOverridesCheck implements IEvaluableAlgorithmCheck {

	private Boolean atLeastOneErrorD = false;
	private Boolean atLeastOneErrorP = false;
	private Boolean atLeastOneErrorDP = false;
	private Boolean atLeastOnePermit = false;
	private Boolean atLeastOneDeny = false;

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(DenyOverridesCheck.class);
		l.debug("DENY OVERRIDE FOR CHECK STARTED");
		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));
		for (FulfilledObligationCheck obl : checkObl) {
			StandardDecision dec = obl.getObligationResult(cxtRequest);
			if (StandardDecision.DENY.equals(dec)) {
				atLeastOneDeny = true;
				dr.setDecision(StandardDecision.DENY);
			}
			if (StandardDecision.PERMIT.equals(dec)) {
				atLeastOnePermit = true;
				continue;
			}
			if (StandardDecision.NOT_APPLICABLE.equals(dec)) {
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(dec)) {
				atLeastOneErrorP = true;
				atLeastOneErrorDP = true;
				atLeastOneErrorD = true;
				continue;
			}

		}

		
		if (atLeastOneDeny) {
			return dr;
		}
		if (atLeastOneErrorDP) {
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		if (atLeastOneErrorD && (atLeastOneErrorP || atLeastOnePermit)) {
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		if (atLeastOneErrorD) {
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		if (atLeastOnePermit) {
			dr.setDecision(StandardDecision.PERMIT);
			return dr;
		}
		if (atLeastOneErrorP) {
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		// otherwise return not app
		dr.setDecision(StandardDecision.NOT_APPLICABLE);
		return dr;
	}

}
