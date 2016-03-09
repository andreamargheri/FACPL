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
package it.unifi.facpl.lib.util.exception;

public class MissingAttributeException extends Exception {

	private static final long serialVersionUID = 1L;

	public MissingAttributeException() {
		super("Missing Attribute In Context Request");
	}

	public MissingAttributeException(String string) {
		super(string);
	}


}
