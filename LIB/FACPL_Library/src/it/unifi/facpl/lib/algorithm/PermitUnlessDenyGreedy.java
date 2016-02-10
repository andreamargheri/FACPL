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
public class PermitUnlessDenyGreedy implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(PermitUnlessDenyGreedy.class);
		l.debug("-> PERMIT UNLESS DENY-GREEDY started");

		LinkedList<FulfilledObligation> obls_permit = new LinkedList<FulfilledObligation>();

		AuthorisationPDP dr = new AuthorisationPDP();
		for (IEvaluablePolicy el : elements) {
			AuthorisationPDP d = el.evaluate(cxtRequest, extendedIndeterminate);
			if (d.getDecision().equals(ExtendedDecision.DENY)) {
				dr.setDecision(ExtendedDecision.DENY);
				dr.addObligation(d.getObligation());
				l.debug("ALG.PERMIT-un-DENY = dt: DENY");
				return dr;
			} else {

				if (d.getDecision().equals(ExtendedDecision.PERMIT)) {
					obls_permit.addAll(d.getObligation());
				}
			}
		}
		l.debug("ALG.PERMIT-un-DENY = dt: PERMIT");
		dr.setDecision(ExtendedDecision.PERMIT);
		dr.addObligation(obls_permit);
		return dr;
	}

}