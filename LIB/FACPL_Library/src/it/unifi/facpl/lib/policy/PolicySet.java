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
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;

public abstract class PolicySet extends FacplPolicy {

	private LinkedList<IEvaluablePolicy> polElements;

	private IEvaluableAlgorithm algCombining;

	protected void addCombiningAlg(IEvaluableAlgorithm alg) {
		Logger l = LoggerFactory.getLogger(PolicySet.class);
		l.debug(idElement + ": Add combining Algorithm");

		this.algCombining = alg;
	}

	protected void addPolicyElement(IEvaluablePolicy el) {
		if (this.polElements == null) {
			this.polElements = new LinkedList<IEvaluablePolicy>();
		}
		this.polElements.add(el);
	}

	@Override
	public AuthorisationPDP evaluate(ContextRequest cxtRequest, Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(PolicySet.class);
		l.debug(idElement + ": Start policySet eval");

		AuthorisationPDP auth = new AuthorisationPDP();

		TargetDecision match_target = getTargetDecision(cxtRequest);

		switch (match_target) {
		case FALSE:
			auth.setDecision(ExtendedDecision.NOT_APPLICABLE);
			l.debug(idElement + ": End policy eval - " + auth.toString());
			return auth;

		case TRUE:

			try {
				l.debug("Evaluating combining algorithm: " + algCombining.getClass().getSimpleName());
				auth = algCombining.evaluate(this.polElements, cxtRequest, extendedIndeterminate);

			} catch (Exception e) {
				// catch expression from Obligation Fulfillment
				l.debug("Catch generic exception in policy set eval. Return INDETERMINATE DP");
				return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null);
			}

			/*
			 * OBLIGATION FULFILLMENT
			 */

			try {

				LinkedList<FulfilledObligation> listObl = null;
				if (auth.getDecision().equals(ExtendedDecision.PERMIT)) {
					listObl = this.evaluateObl(Effect.PERMIT, cxtRequest);
				} else if (auth.getDecision().equals(ExtendedDecision.DENY)) {
					listObl = this.evaluateObl(Effect.DENY, cxtRequest);
				}
				// addObligation to decision result (PolicySet's obligation)
				if (listObl != null) {
					auth.addObligation(listObl);
				}

			} catch (FulfillmentFailed f) {
				// catch expression from Obligation Fulfillment
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

			l.debug(idElement + ": End policySet eval - " + auth.toString());
			return auth;

		case INDETERMINATE:

			if (extendedIndeterminate) {
				l.debug("---------------------------------------");
				l.debug("Start Extended Indeterminate Evaluation");
			
				try {
					l.debug("Evaluating combining algorithm: " + algCombining.getClass().getSimpleName());
					auth = algCombining.evaluate(this.polElements, cxtRequest, extendedIndeterminate);
					
				} catch (Exception e) {
					// catch exception from Obligation Fulfillment
					l.debug("Catch generic exception in policy set eval. Return INDETERMINATE DP");
					return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null);
				}

				// clear obligations
				auth.clearObligation();
				switch (auth.getDecision()) {
				case PERMIT:
					auth.setDecision(ExtendedDecision.INDETERMINATE_P);
					break;
				case DENY:
					auth.setDecision(ExtendedDecision.INDETERMINATE_D);
					break;
				case INDETERMINATE_D:
					auth.setDecision(ExtendedDecision.INDETERMINATE_D);
					break;
				case INDETERMINATE_P:
					auth.setDecision(ExtendedDecision.INDETERMINATE_P);
					break;
				case INDETERMINATE_DP:
					auth.setDecision(ExtendedDecision.INDETERMINATE_DP);
					break;
				case NOT_APPLICABLE:
					auth.setDecision(ExtendedDecision.NOT_APPLICABLE);
					break;
				}
				l.debug("End Extended Indeterminate Evaluation");
				l.debug("---------------------------------------");
			} else {
				// no other evaluation request
				auth.setDecision(ExtendedDecision.INDETERMINATE_DP);
			}
			l.debug(idElement + ": End policy eval - " + auth.toString());
			return auth;

		default:
			// IMPOSSIBLE (present only for Java matter)
			return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null);

		}

	}

}
