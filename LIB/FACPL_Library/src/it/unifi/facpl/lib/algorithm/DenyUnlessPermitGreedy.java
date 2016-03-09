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

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

/**
 * 
 * @author Andrea Margheri
 *
 */
public class DenyUnlessPermitGreedy implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(DenyUnlessPermitGreedy.class);
		l.debug("-> DENY UNLESS PERMIT - Greedy started");

		LinkedList<AbstractFulfilledObligation> obls_deny = new LinkedList<AbstractFulfilledObligation>();

		AuthorisationPDP dr = new AuthorisationPDP();
		for (IEvaluablePolicy el : elements) {
			AuthorisationPDP d = el.evaluate(cxtRequest, extendedIndeterminate);
			if (d.getDecision().equals(ExtendedDecision.PERMIT)) {
				dr.setDecision(ExtendedDecision.PERMIT);
				dr.addObligation(d.getObligation());
				l.debug("ALG.DENY-un-PERMIT = dt: PERMIT");
				return dr;
			} else {
				if (d.getDecision().equals(ExtendedDecision.DENY)) {
					obls_deny.addAll(d.getObligation());
				}
			}
		}
		l.debug("ALG.DENY-un-PERMIT = dt: DENY");
		dr.setDecision(ExtendedDecision.DENY);
		dr.addObligation(obls_deny);
		return dr;
	}

}
