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
package it.unifi.facpl.lib.util;

public class AttributeName {
	private String idAttribute;
	private String category;

	public AttributeName(String category, String id) {
		this.category = category;
		this.idAttribute = id;
	}

	public String getIDAttribute() {
		return idAttribute;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return category.toString() + "/" + idAttribute.toString();
	}

}
