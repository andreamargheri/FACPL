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

	private Boolean atLeastOneDeny = false;
	
	@Override
	public AuthorisationPEP evaluate(List<StandardDecision> decList, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("PERMIT UNLESS DENY CHECK STARTED");

		Boolean atLeastOneDeny = false;

		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));
		for (StandardDecision dec : decList) {
			StandardDecision d = dec;
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

	@Override
	public void resetAlg() {
		this.atLeastOneDeny = false;
		
	}
}