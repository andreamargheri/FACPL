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

import java.util.Date;

import it.unifi.facpl.lib.function.comparison.evaluator.Util;

public class FacplDate {

	private Date date;

	public FacplDate(String dateS) {
		try {
			date = Util.parseDate(dateS);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.append("The input date and/or time value cannot be parsed");
		}
	}

	public Date getDate() {
		return date;
	}

	public boolean equals(FacplDate obj) {
		return date.equals(obj.getDate());
	}

	public boolean equals(Date obj) {
		return date.equals(obj);
	}

	public boolean before(Date obj) {
		return date.before(obj);
	}

	public boolean before(FacplDate obj) {
		return date.before(obj.getDate());
	}

	public boolean after(Date obj) {
		return date.after(obj);
	}

	public boolean after(FacplDate obj) {
		return date.after(obj.getDate());
	}

	@Override
	public String toString() {
		return this.date.toString();
	}
}
