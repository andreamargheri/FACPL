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
package it.unifi.facpl.lib.function.comparison.evaluator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Date parseDate(String s) throws Exception {
		DateFormat dateLong = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
		DateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat dateTime = new SimpleDateFormat("HH:mm:ss");
		try {
			return dateLong.parse(s);
		} catch (Exception e) {
			try {
				return dateOnly.parse(s);
			} catch (Exception t) {
				return dateTime.parse(s);
			}
		}
	}

}
