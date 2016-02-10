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
package it.unifi.facpl.lib.policy;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;

public abstract class Rule extends FacplPolicy {

	private Effect effect;

	protected void addEffect(Effect ef) {
		this.effect = ef;
	}

	@Override
	public AuthorisationPDP evaluate(ContextRequest cxtRequest, Boolean extendedIndeterminate) {
		Logger l = LoggerFactory.getLogger(Rule.class);
		l.debug(idElement + ": start rule eval");

		AuthorisationPDP auth = new AuthorisationPDP();

		// Evaluate Target Expression
		TargetDecision target_dec = getTargetDecision(cxtRequest);
		l.debug("Target Decision:" + target_dec.toString());

		switch (target_dec) {

		case FALSE:

			auth.setDecision(ExtendedDecision.NOT_APPLICABLE);
			return auth;

		case TRUE:

			/*
			 * OBLIGATION FULFILLMENT
			 */

			try {

				LinkedList<FulfilledObligation> listObl = null;
				if (this.effect.equals(Effect.PERMIT)) {
					auth.setDecision(ExtendedDecision.PERMIT);
					listObl = this.evaluateObl(Effect.PERMIT, cxtRequest);
				} else {
					auth.setDecision(ExtendedDecision.DENY);
					listObl = this.evaluateObl(Effect.DENY, cxtRequest);
				}
				// addObligation to decision result (PolicySet's obligation)
				if (listObl != null) {
					auth.addObligation(listObl);
				}

				return auth;

			} catch (FulfillmentFailed f) {
				// catch exception from Obligation Fulfillment
				l.debug("Catch generic exception in policy set eval. Return INDETERMINATE");
				if (extendedIndeterminate) {
					if (auth.getDecision().equals(ExtendedDecision.PERMIT)) {
						return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_P, null);
					} else {
						return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_D, null);
					}
				} else {
					return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null);
				}
			}

		case INDETERMINATE:
			if (this.effect.equals(Effect.DENY)) {
				auth.setDecision(ExtendedDecision.INDETERMINATE_D);
			} else {
				auth.setDecision(ExtendedDecision.INDETERMINATE_P);
			}
			return auth;

		default:
			// IMPOSSIBLE (present only for Java matter)
			return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null);
		}
	}
}
