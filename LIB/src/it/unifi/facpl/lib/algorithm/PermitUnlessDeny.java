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

public class PermitUnlessDeny implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(PermitUnlessDeny.class);
		l.debug("-> PERMIT UNLESS DENY started");

		LinkedList<FulfilledObligation> obls_permit = new LinkedList<FulfilledObligation>();

		Boolean atLeastOneDeny = false;

		AuthorisationPDP dr = new AuthorisationPDP();
		for (IEvaluablePolicy el : elements) {
			AuthorisationPDP d = el.evaluate(cxtRequest, extendedIndeterminate);
			if (d.getDecision().equals(ExtendedDecision.DENY)) {
				atLeastOneDeny = true;
				dr.setDecision(ExtendedDecision.DENY);
				dr.addObligation(d.getObligation());
			} else {
				if (d.getDecision().equals(ExtendedDecision.PERMIT)) {
					obls_permit.addAll(d.getObligation());
				}
			}
		}
		if (atLeastOneDeny) {
			return dr;
		} else {
			dr.setDecision(ExtendedDecision.PERMIT);
			dr.addObligation(obls_permit);
			return dr;
		}
	}

}