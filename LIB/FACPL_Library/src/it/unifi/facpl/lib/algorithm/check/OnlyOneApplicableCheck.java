package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.OnlyOneApplicable;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;

public class OnlyOneApplicableCheck implements IEvaluableAlgorithmCheck {

	private Boolean atLeastOne = false;
	//FulfilledObligationCheck selectedPolicy = null;
	private StandardDecision selectedDecision=StandardDecision.INDETERMINATE;
	private StandardDecision appResult;
	
	@Override
	public AuthorisationPEP evaluate(List<StandardDecision> decList, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> ONLY ONE APPLICABLE started");



		AuthorisationPEP dr = new AuthorisationPEP();

		for (StandardDecision dec : decList) {
			appResult = dec;

			if (appResult.equals(StandardDecision.INDETERMINATE)) {
				dr.setDecision(StandardDecision.INDETERMINATE);
				return dr;
			}
			if (appResult.equals(StandardDecision.PERMIT)) {
				if (atLeastOne) {
					dr.setDecision(StandardDecision.INDETERMINATE);
					return dr;
				} else {
					atLeastOne = true;
					//selectedPolicy = el;
					selectedDecision= dec;

				}
			}
			if (appResult.equals(StandardDecision.DENY)) {
				continue;
			}
		}
		if (atLeastOne) {
			l.debug("Only one policy applied. Returned its decision result");
			dr.setDecision(selectedDecision);
			return dr;
		} else {
			dr.setDecision(StandardDecision.NOT_APPLICABLE);
			l.debug("No policy applied");
			return dr;
		}
	}

	@Override
	public void resetAlg() {
		this.atLeastOne = false;
		this.selectedDecision=StandardDecision.INDETERMINATE;
		
	}

}
