package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.PermitOverridesGreedy;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;

public class PermitOverridesGreedyCheck implements IEvaluableAlgorithmCheck {
	private Boolean atLeastOneErrorD = false;
	private Boolean atLeastOneErrorP = false;
	private Boolean atLeastOneErrorDP = false;
	private Boolean atLeastOneDeny = false;
	
	@Override
	public AuthorisationPEP evaluate(List<StandardDecision> decList, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> PERMIT OVERRIDES started");


		AuthorisationPEP dr = new AuthorisationPEP();
		
		for (StandardDecision dec : decList) {
			StandardDecision d = dec;

			if (StandardDecision.PERMIT.equals(d)) {
				l.debug("ALG.PERMIT-GREEDY = dt: PERMIT");
				dr.setDecision(StandardDecision.PERMIT);

				return dr;
			}

			if (StandardDecision.DENY.equals(d)) {
				atLeastOneDeny = true;
				// add Obligation_Deny

				continue;
			}

			if (StandardDecision.NOT_APPLICABLE.equals(d)) {
				continue;
			}
			if (StandardDecision.INDETERMINATE.equals(d)) {
				atLeastOneErrorD = true;
				atLeastOneErrorDP = true;
				atLeastOneErrorP = true;
				continue;
			}

		}
		if (atLeastOneErrorDP) {
			l.debug("ALG.PERMIT-GREEDY = dt: IndetDP");
			dr.setDecision(StandardDecision.INDETERMINATE);
			return dr;
		}
		if (atLeastOneDeny) {
			l.debug("ALG.PERMIT-GREEDY = dt: Deny");
			dr.setDecision(StandardDecision.DENY);

			return dr;
		}
		// otherwise return not app
		l.debug("ALG.PERMIT-GREEDY = dt: NotAPP");
		dr.setDecision(StandardDecision.NOT_APPLICABLE);
		return dr;
	}

	@Override
	public void resetAlg() {
		this.atLeastOneErrorD = false;
		this.atLeastOneErrorP = false;
		this.atLeastOneErrorDP = false;
		this.atLeastOneDeny = false;
		
	}

}
