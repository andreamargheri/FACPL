package it.unifi.facpl.lib.algorithm;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

/**
 * 
 * @author Andrea Margheri
 *
 */
public class DenyOverridesGreedy implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(DenyOverridesGreedy.class);

		l.debug("-> DENY OVERRIDES started");

		Boolean atLeastOneErrorD = false;
		Boolean atLeastOneErrorP = false;
		Boolean atLeastOneErrorDP = false;
		Boolean atLeastOnePermit = false;

		LinkedList<AbstractFulfilledObligation> obligationPermit = new LinkedList<AbstractFulfilledObligation>();

		AuthorisationPDP dr = new AuthorisationPDP();

		for (IEvaluablePolicy el : elements) {

			AuthorisationPDP d = el.evaluate(cxtRequest, extendedIndeterminate);

			if (ExtendedDecision.DENY.equals(d.getDecision())) {
				// only last obligations evaluated are returned
				l.debug("ALG.DENY-Greedy = dt: Deny");
				dr.setDecision(ExtendedDecision.DENY);
				dr.addObligation(d.getObligation());
				return dr;
			}
			if (ExtendedDecision.PERMIT.equals(d.getDecision())) {
				atLeastOnePermit = true;
				// manage obligation
				obligationPermit.addAll(d.getObligation());

				continue;
			}
			if (ExtendedDecision.NOT_APPLICABLE.equals(d.getDecision())) {
				continue;
			}
			if (ExtendedDecision.INDETERMINATE_D.equals(d.getDecision())) {
				atLeastOneErrorD = true;
				continue;
			}
			if (ExtendedDecision.INDETERMINATE_P.equals(d.getDecision())) {
				atLeastOneErrorP = true;
				continue;
			}
			if (ExtendedDecision.INDETERMINATE_DP.equals(d.getDecision())) {
				atLeastOneErrorDP = true;
				continue;
			}
		}
		if (atLeastOneErrorDP) {
			l.debug("ALG.DENY-Greedy= dt: IndetDP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
			return dr;
		}
		if (atLeastOneErrorD && (atLeastOneErrorP || atLeastOnePermit)) {
			l.debug("ALG.DENY-Greedy = dt: IndetDP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
			return dr;
		}
		if (atLeastOneErrorD) {
			l.debug("ALG.DENY-Greedy = dt: IndetD");
			dr.setDecision(ExtendedDecision.INDETERMINATE_D);
			return dr;
		}
		if (atLeastOnePermit) {
			l.debug("ALG.DENY-Greedy = dt: Permit");
			dr.setDecision(ExtendedDecision.PERMIT);
			dr.addObligation(obligationPermit);
			return dr;
		}
		if (atLeastOneErrorP) {
			l.debug("ALG.DENY-Greedy = dt: IndetP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_P);
			return dr;
		}
		// otherwise return not app
		l.debug("ALG.DENY-Greedy = dt: NotAPP");
		dr.setDecision(ExtendedDecision.NOT_APPLICABLE);
		return dr;
	}

}
