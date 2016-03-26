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
	protected String idAttribute;
	protected String category;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((idAttribute == null) ? 0 : idAttribute.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AttributeName)) {
			return false;
		}
		AttributeName other = (AttributeName) obj;
		if (category == null) {
			if (other.category != null) {
				return false;
			}
		} else if (!category.equals(other.category)) {
			return false;
		}
		if (idAttribute == null) {
			if (other.idAttribute != null) {
				return false;
			}
		} else if (!idAttribute.equals(other.idAttribute)) {
			return false;
		}
		return true;
	}

}
