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

import java.util.LinkedList;

public class Set {

	private LinkedList<Object> values;

	public Set(Object... elements) {
		this.values = new LinkedList<Object>();
		for (Object object : elements) {
			values.add(object);
		}
	}

	public void addValue(Object value) {
		values.add(value);
	}

	public LinkedList<Object> getValues() {
		return values;
	}

	public Boolean isEmpty() {
		if (values != null & values.size() > 0)
			return false;
		else
			return true;
	}

	@Override
	public String toString() {
		return values.toString();
	}

	public boolean contains(Object object) {
		return values.contains(object);
	}

	public boolean contains(Set bag) {
		Boolean flag = true;
		for (Object el : bag.getValues()) {
			flag = flag && values.contains(el);
			if (!flag)
				return flag;
		}
		return flag;
	}

}
