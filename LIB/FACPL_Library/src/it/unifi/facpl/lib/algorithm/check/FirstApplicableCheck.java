package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.FirstApplicable;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;

public class FirstApplicableCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<FulfilledObligationCheck> checkObl, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> FIRST APPLICABLE started");

		AuthorisationPEP dr = new AuthorisationPEP();

		for (FulfilledObligationCheck el : checkObl) {
			dr.setDecision(el.getObligationResult(cxtRequest));
			if (dr.getDecision().equals(StandardDecision.DENY)) {
				l.debug("First Applicable END - Result DENY");
				return dr;
			}
			if (dr.getDecision().equals(StandardDecision.PERMIT)) {
				l.debug("First Applicable END - Result PERMIT");
				return dr;
			}
			if (dr.getDecision().equals(StandardDecision.NOT_APPLICABLE)) {
				l.debug("First Applicable Continue - Element NOT APPLICABLE, continue");
				continue;
			}
			if (dr.getDecision().equals(StandardDecision.INDETERMINATE)){
				l.debug("First Applicable END - Result INDETERMINATE");
				return dr;
			}
		}
		dr.setDecision(StandardDecision.NOT_APPLICABLE);
		l.debug("First Applicable END - Result NOT_APP");
		return dr;
	}

}
