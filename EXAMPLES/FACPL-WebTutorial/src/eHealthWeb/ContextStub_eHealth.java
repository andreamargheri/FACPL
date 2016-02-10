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
package eHealthWeb;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.*;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

import java.util.Date;

public class ContextStub_eHealth implements IContextStub {

	private static ContextStub_eHealth instance;

	public static ContextStub_eHealth getInstance() {
		if (instance == null) {
			instance = new ContextStub_eHealth();
		}
		return instance;
	}

	private ContextStub_eHealth() {
	}

	@Override
	public Object getContextValues(AttributeName attribute) throws MissingAttributeException {
		// Context Time Value
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("time")) {
			return new Date();
		}
		if (attribute.getCategory().equals("system")) {
			String id = attribute.getIDAttribute();
			if (id.equals("time")) {
				return new Date();
			}
		}
		if (attribute.getCategory().equals("resource")) {
			String id = attribute.getIDAttribute();
			if (id.equals("patient-id.mail")) {
				return "mail@mail.com";
			}
		}
		throw new MissingAttributeException();
	}

}