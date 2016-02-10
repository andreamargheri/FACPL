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
package it.unifi.facpl.junit.util;

import java.util.LinkedList;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;

public class AbstractRule extends Rule {

	private TargetDecision m;
	private Boolean err_obl;

	public AbstractRule(Effect effect, TargetDecision m, Boolean fullfilmentObl) {
		addEffect(effect);
		this.m = m;
		this.err_obl = fullfilmentObl;

	}

	public AbstractRule(Effect effect, Boolean fullfilmentObl) {
		addEffect(effect);
		this.err_obl = fullfilmentObl;

	}

	public AbstractRule(Effect effect, TargetDecision m) {
		addEffect(effect);
		this.m = m;
		this.err_obl = false; // no error in the fullfillment

	}

	public AbstractRule(Effect effect) {
		addEffect(effect);
		this.err_obl = false; // no error in the fullfillment
	}

	@Override
	public TargetDecision getTargetDecision(ContextRequest cxtRequest) {
		if (this.m == null) {
			return super.getTargetDecision(null);
		}
		return this.m;
	}

	@Override
	protected LinkedList<FulfilledObligation> evaluateObl(Effect effect, ContextRequest cxtRequest)
			throws FulfillmentFailed {

		if (err_obl) {
			throw new FulfillmentFailed();
		} else {
			return new LinkedList<FulfilledObligation>();
		}
	}

}
