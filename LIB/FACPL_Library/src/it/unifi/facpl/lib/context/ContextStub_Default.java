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

@SuppressWarnings("all")
public class ContextStub_Default extends AbstractContextStub {

	private static ContextStub_Default instance;

	public static ContextStub_Default getInstance() {
		if (instance == null) {
			instance = new ContextStub_Default();
		}
		return instance;
	}

	private ContextStub_Default() {

	}

}
