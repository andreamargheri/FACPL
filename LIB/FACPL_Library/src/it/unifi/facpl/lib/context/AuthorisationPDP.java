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
package it.unifi.facpl.lib.context;

import java.util.LinkedList;
import java.util.List;

import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.StandardDecision;

/**
 * 
 * @author Andrea Decision Tuple. Eval result of an evaluable element.
 *         Parametric over request id
 */
public class AuthorisationPDP {

	private String id;

	private ExtendedDecision decision;
	private LinkedList<FulfilledObligation> obligation;

	public AuthorisationPDP() {
		this.obligation = new LinkedList<FulfilledObligation>();
	}

	public AuthorisationPDP(ExtendedDecision decision, LinkedList<FulfilledObligation> obligations) {
		this.decision = decision;
		this.obligation = obligations;
	}

	public AuthorisationPDP(ExtendedDecision decision) {
		this.decision = decision;
		this.obligation = new LinkedList<FulfilledObligation>();
	}

	// DECISION

	public void setDecision(ExtendedDecision decision) {
		this.decision = decision;
	}

	public ExtendedDecision getDecision() {
		return decision;
	}

	public StandardDecision getStandardDecision() {

		switch (this.decision) {
		case PERMIT:
			return StandardDecision.PERMIT;
		case DENY:
			return StandardDecision.DENY;
		case NOT_APPLICABLE:
			return StandardDecision.NOT_APPLICABLE;
		case INDETERMINATE_D:
			return StandardDecision.INDETERMINATE;
		case INDETERMINATE_P:
			return StandardDecision.INDETERMINATE;
		case INDETERMINATE_DP:
			return StandardDecision.INDETERMINATE;
		}

		return null;

	}

	// OBLIGATION

	public void addObligation(FulfilledObligation obligation) {
		if (this.obligation == null) {
			this.obligation = new LinkedList<FulfilledObligation>();
		}
		this.obligation.add(obligation);
	}

	public void addObligation(List<FulfilledObligation> obligation) {
		if (this.obligation == null) {
			this.obligation = new LinkedList<FulfilledObligation>();
		}
		this.obligation.addAll(obligation);
	}

	public void setObligation(LinkedList<FulfilledObligation> obligations) {
		this.obligation = obligations;
	}

	public void clearObligation() {
		this.obligation.clear();
	}

	public LinkedList<FulfilledObligation> getObligation() {
		return obligation;
	}

	// ID

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuffer text = new StringBuffer();
		text.append("Decision: " + decision.toString() + " ");
		text.append("Obligations: ");
		if (obligation != null) {
			for (FulfilledObligation obl : obligation) {
				text.append(obl.toString());
			}
		} else {
			text.append("[]");
		}
		return text.toString();
	}

}
