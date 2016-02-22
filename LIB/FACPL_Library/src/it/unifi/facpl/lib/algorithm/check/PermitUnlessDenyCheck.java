package it.unifi.facpl.lib.algorithm.check;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;

public class PermitUnlessDenyCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(PermitUnlessDenyCheck.class);
		l.debug("PERMIT UNLESS DENY CHECK STARTED");

		Boolean atLeastOneDeny = false;

		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));
		for (FulfilledObligationCheck obl : checkObl) {
			StandardDecision d = obl.getObligationResult(cxtRequest);
			if (d.equals(StandardDecision.DENY)) {
				atLeastOneDeny = true;
				dr.setDecision(StandardDecision.DENY);
			} else {
				if (d.equals(StandardDecision.PERMIT)) {
				}
			}
		}
		if (atLeastOneDeny) {
			return dr;
		} else {
			dr.setDecision(StandardDecision.PERMIT);
			return dr;
		}

	}
}
