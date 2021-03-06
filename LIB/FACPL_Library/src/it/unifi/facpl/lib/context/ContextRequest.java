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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class ContextRequest {

	private IContextStub context;
	private Request request;

	public ContextRequest(Request req) {
		this.request = req;

		this.context = null;
	}

	public ContextRequest(Request req, IContextStub context) {
		this.request = req;

		this.context = context;
	}

	public Request getRequest() {
		return request;
	}

	public IContextStub getContext() {
		return context;
	}

	public Object getContextRequestValues(AttributeName attr_name) throws MissingAttributeException {
		Logger l = LoggerFactory.getLogger(ContextRequest.class);
		// First we check in the request
		try {
			return this.request.getRequestValues(attr_name);
		} catch (MissingAttributeException e) {
			// Request not defined on the names passed as argument
			// -> Check in the context
			if (context != null) {
				Object values = this.context.getContextValues(attr_name);
				if (values == null) {
					// throw Exception Missing Attribute if undefined again
					l.debug("Throw MissingAttributeExcepion for " + attr_name.toString());
					throw new MissingAttributeException();
				} else {
					return values;
				}
			} else {
				// throw Exception Missing Attribute due to absence of context
				l.debug("Throw MissingAttributeExcepion for " + attr_name.toString());
				throw new MissingAttributeException();
			}
		}
	}
}
