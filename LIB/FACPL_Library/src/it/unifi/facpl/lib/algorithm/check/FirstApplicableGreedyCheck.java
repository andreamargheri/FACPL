package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.StandardDecision;

public class FirstApplicableGreedyCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<StandardDecision> decList, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> FIRST APPLICABLE-Greedy started");

		AuthorisationPEP dr = new AuthorisationPEP();

		for (StandardDecision d : decList) {
			
			if (d.equals(StandardDecision.DENY)) {
				l.debug("First Applicable END - Result DENY");
				dr.setDecision(StandardDecision.DENY);
				return dr;
			}
			if (d.equals(StandardDecision.PERMIT)) {
				l.debug("First Applicable END - Result PERMIT");
				dr.setDecision(StandardDecision.PERMIT);
				return dr;
			}
			if (d.equals(StandardDecision.NOT_APPLICABLE)) {
				l.debug("First Applicable Continue - Element NOT APPLICABLE, continue");
				continue;
			}
			if (d.equals(StandardDecision.INDETERMINATE)){
				l.debug("First Applicable END - Result INDETERMINATE");
				dr.setDecision(StandardDecision.INDETERMINATE);
				return dr;
			}
		}
		dr.setDecision(StandardDecision.NOT_APPLICABLE);
		l.debug("First Applicable END - Result NOT_APP");
		return dr;
	}

	@Override
	public void resetAlg() {
		// TODO Auto-generated method stub
		
	}

}
