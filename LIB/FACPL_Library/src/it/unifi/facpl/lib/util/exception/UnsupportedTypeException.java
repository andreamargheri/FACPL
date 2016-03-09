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

/**
 * @author Andrea Margheri
 *
 */
public class UnsupportedTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsupportedTypeException() {
		super("Unsupported Argument Type for the function");
	}

	public UnsupportedTypeException(String type, String fun) {
		super("Unsupported Argument Type " + type + " for the comparison function " + fun);
	}

}
