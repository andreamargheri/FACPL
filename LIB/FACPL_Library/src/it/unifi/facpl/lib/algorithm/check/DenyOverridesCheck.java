package it.unifi.facpl.lib.algorithm.check;

import java.util.List;
import java.util.UUID;

import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.StandardDecision;

public class DenyOverridesCheck implements IEvaluableAlgorithmCheck {

	private Boolean atLeastOneErrorD = false;
	private Boolean atLeastOneErrorP = false;
	private Boolean atLeastOneErrorDP = false;
	private Boolean atLeastOnePermit = false;
	private Boolean atLeastOneDeny = false;

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {
		AuthorisationPEP dr = new AuthorisationPEP(UUID.randomUUID().toString().substring(0, 8));
		dr.setPDPpassthrough(true);
		for (FulfilledObligationCheck obl : checkObl) {
			if (!obl.hasExpired()) {

				StandardDecision dec;
				try {
					dec = obl.getObligationResult(cxtRequest);
					if (obl.hasExpired()) {
						dr.setPDPpassthrough(false);
					}
					if (ExpressionValue.FALSE == dec) {
						atLeastOneDeny = true;
						dr.setDecision(StandardDecision.DENY);
					}
					if (ExpressionValue.TRUE == dec) {
						atLeastOnePermit = true;
						continue;
					}
					if (ExpressionValue.ERROR == dec) {
						continue;
					}
					if (ExpressionValue.BOTTOM == dec) {
						this.atLeastOneErrorD = true;
						this.atLeastOneErrorDP = true;
						this.atLeastOneErrorP = true;
						continue;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				dr.setPDPpassthrough(false);
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
