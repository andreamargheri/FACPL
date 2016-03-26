package it.unifi.facpl.lib.algorithm.check;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.StandardDecision;

public class DenyUnlessPermitCheck implements IEvaluableAlgorithmCheck {
	private Boolean atLeastOnePermit = false;

	@Override
	public AuthorisationPEP evaluate(List<StandardDecision> decList, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> DENY UNLESS PERMIT CHECK STARTED");

		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));
		for (StandardDecision d : decList) {
			if (d.equals(StandardDecision.PERMIT)) {
				atLeastOnePermit = true;
				dr.setDecision(StandardDecision.PERMIT);

			} else {
				if (d.equals(StandardDecision.DENY)) {
				}
			}
		}
		if (atLeastOnePermit) {
			return dr;
		} else {
			dr.setDecision(StandardDecision.DENY);
			return dr;
		}
	}

	@Override
	public void resetAlg() {
		this.atLeastOnePermit = false;
	}

}
