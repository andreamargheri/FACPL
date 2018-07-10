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
/**
 * 
 */
package it.unifi.facpl.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

/**
 * @author Andrea Margheri
 *
 */
public class PDP {

	private IEvaluableAlgorithm algCombining;
	private List<IEvaluablePolicy> policies;
	private Boolean extendedIndeterminate;

	public PDP(IEvaluableAlgorithm algCombining, List<IEvaluablePolicy> policies,
			Boolean extendedIndeterminate) {
		this.algCombining = algCombining;
		this.policies = policies;
		this.extendedIndeterminate = extendedIndeterminate;
	}

	/**
	 * PDP Evaluation
	 * 
	 * @param cxtReq
	 *            Request to Evaluate
	 */
	public AuthorisationPDP doAuthorisation(ContextRequest cxtReq) {

		Logger l = LoggerFactory.getLogger(PDP.class);

		l.debug("-------------------------------------");
		l.debug("PDP Evaluation of request: " + cxtReq.getRequest().getId() + " started...");

		try {

			// Invoking Combining Algorithm defining PDP
			AuthorisationPDP dr = new AuthorisationPDP();
			dr = algCombining.evaluate(policies, cxtReq, extendedIndeterminate);
			dr.setId(cxtReq.getRequest().getId());

			l.debug("...PDP Evaluation of request " + cxtReq.getRequest().getId() + " completed. PDP decision: "
					+ dr.toString());

			l.debug("--------------------------------");

			return dr;

		} catch (Exception e) {
			l.debug("PDP catch unexpected exception");
			l.debug(e.getMessage().toString());
			return null;
		}

	}

}
