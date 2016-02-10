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
public class DenyOverrides implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(DenyOverrides.class);

		l.debug("-> DENY OVERRIDES started");

		Boolean atLeastOneErrorD = false;
		Boolean atLeastOneErrorP = false;
		Boolean atLeastOneErrorDP = false;
		Boolean atLeastOnePermit = false;
		Boolean atLeastOneDeny = false;

		LinkedList<FulfilledObligation> obligationPermit = new LinkedList<FulfilledObligation>();

		AuthorisationPDP dr = new AuthorisationPDP();

		for (IEvaluablePolicy el : elements) {

			AuthorisationPDP d = el.evaluate(cxtRequest, extendedIndeterminate);

			if (ExtendedDecision.DENY.equals(d.getDecision())) {
				atLeastOneDeny = true;
				dr.setDecision(ExtendedDecision.DENY);
				dr.addObligation(d.getObligation());
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
		if (atLeastOneDeny) {
			l.debug("ALG.DENY = dt: DENY");
			return dr;
		}
		if (atLeastOneErrorDP) {
			l.debug("ALG.DENY = dt: IndetDP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
			dr.clearObligation();
			return dr;
		}
		if (atLeastOneErrorD && (atLeastOneErrorP || atLeastOnePermit)) {
			l.debug("ALG.DENY = dt: IndetDP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
			dr.clearObligation();
			return dr;
		}
		if (atLeastOneErrorD) {
			l.debug("ALG.DENY = dt: IndetD");
			dr.setDecision(ExtendedDecision.INDETERMINATE_D);
			dr.clearObligation();
			return dr;
		}
		if (atLeastOnePermit) {
			l.debug("ALG.DENY = dt: Permit");
			dr.setDecision(ExtendedDecision.PERMIT);
			dr.clearObligation();
			dr.addObligation(obligationPermit);
			return dr;
		}
		if (atLeastOneErrorP) {
			l.debug("ALG.DENY = dt: IndetP");
			dr.setDecision(ExtendedDecision.INDETERMINATE_P);
			dr.clearObligation();
			return dr;
		}
		// otherwise return not app
		l.debug("ALG.DENY = dt: NotAPP");
		dr.setDecision(ExtendedDecision.NOT_APPLICABLE);
		dr.clearObligation();
		return dr;
	}

}
