/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
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
public class PermitOverridesGreedy implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(PermitOverridesGreedy.class);
		l.debug("-> PERMIT OVERRIDES started");

		Boolean atLeastOneErrorD = false;
		Boolean atLeastOneErrorP = false;
		Boolean atLeastOneErrorDP = false;
		Boolean atLeastOneDeny = false;

		LinkedList<FulfilledObligation> obligationDeny = new LinkedList<FulfilledObligation>();

		AuthorisationPDP dr = new AuthorisationPDP();
		for (IEvaluablePolicy el : elements) {
			AuthorisationPDP d = el.evaluate(cxtRequest, extendedIndeterminate);

			if (ExtendedDecision.PERMIT.equals(d.getDecision())) {
				l.debug("ALG.PERMIT-GREEDY = dt: PERMIT");
				dr.setDecision(ExtendedDecision.PERMIT);
				dr.addObligation(d.getObligation());
				return dr;
			}

			if (ExtendedDecision.DENY.equals(d.getDecision())) {
				atLeastOneDeny = true;
				// add Obligation_Deny
				obligationDeny.addAll(d.getObligation());
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
			l.debug("ALG.PERMIT-GREEDY = dt: IndetDP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
			return dr;
		}
		if (atLeastOneErrorP && (atLeastOneErrorD || atLeastOneDeny)) {
			l.debug("ALG.PERMIT-GREEDY = dt: IndetDP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
			return dr;
		}
		if (atLeastOneErrorP) {
			l.debug("ALG.PERMIT-GREEDY = dt: IndetP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_P);
			return dr;
		}
		if (atLeastOneDeny) {
			l.debug("ALG.PERMIT-GREEDY = dt: Deny");
			dr.setDecision(ExtendedDecision.DENY);
			dr.addObligation(obligationDeny);
			return dr;
		}
		if (atLeastOneErrorD) {
			l.debug("ALG.PERMIT-GREEDY = dt: IndetD");
			dr.setDecision(ExtendedDecision.INDETERMINATE_D);
			return dr;
		}
		// otherwise return not app
		l.debug("ALG.PERMIT-GREEDY = dt: NotAPP");
		dr.setDecision(ExtendedDecision.NOT_APPLICABLE);
		return dr;
	}
}
