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

import it.unifi.facpl.lib.enums.StandardDecision;

public class AuthorisationPEP {

	private String id;

	private StandardDecision decision;

	public AuthorisationPEP(String id, StandardDecision dec) {
		this.id = id;
		this.decision = dec;
	}

	public String getId() {
		return id;
	}

	public StandardDecision getDecision() {
		return decision;
	}

	@Override
	public String toString() {
		return decision.toString();
	}

}
