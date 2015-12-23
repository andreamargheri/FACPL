package it.unifi.facpl.lib.algorithm;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

/**
 * 
 * @author Andrea Margheri
 *
 */
public class DenyUnlessPermit implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(DenyUnlessPermit.class);
		l.debug("-> DENY UNLESS PERMIT started");

		LinkedList<FulfilledObligation> obls_deny = new LinkedList<FulfilledObligation>();

		Boolean atLeastOnePermit = false;

		AuthorisationPDP dr = new AuthorisationPDP();
		for (IEvaluablePolicy el : elements) {
			AuthorisationPDP d = el.evaluate(cxtRequest, extendedIndeterminate);
			if (d.getDecision().equals(ExtendedDecision.PERMIT)) {
				atLeastOnePermit = true;
				dr.setDecision(ExtendedDecision.PERMIT);
				dr.addObligation(d.getObligation());
			} else {
				if (d.getDecision().equals(ExtendedDecision.DENY)) {
					obls_deny.addAll(d.getObligation());
				}
			}
		}
		if (atLeastOnePermit) {
			return dr;
		} else {
			dr.setDecision(ExtendedDecision.DENY);
			dr.addObligation(obls_deny);
			return dr;
		}
	}

}
