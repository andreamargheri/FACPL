package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.StandardDecision;

public class PermitUnlessDenyGreedyCheck implements IEvaluableAlgorithmCheck {

	@Override
	public AuthorisationPEP evaluate(List<StandardDecision> decList, ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(getClass());
		l.debug("-> PERMIT UNLESS DENY-GREEDY started");

		AuthorisationPEP dr = new AuthorisationPEP();
		for (StandardDecision dec : decList) {
			try {
				StandardDecision d = dec;
				if (d.equals(StandardDecision.DENY)) {
					dr.setDecision(StandardDecision.DENY);
					return dr;
				} else {
					if (d.equals(StandardDecision.PERMIT)) {

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		dr.setDecision(StandardDecision.PERMIT);

		return dr;
	}

	@Override
	public void resetAlg() {

	}
}
