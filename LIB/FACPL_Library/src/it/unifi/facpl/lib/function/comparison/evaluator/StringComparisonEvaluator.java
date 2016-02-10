/**
 * Copyright (c) 2014, 2016 Concurrency and Mobility Group.
 * Universit?? di Firenze
 *	
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Michele Loreti
 */
package it.unifi.facpl.lib.function.comparison.evaluator;

import java.util.Date;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.util.Set;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

/**
 * @author Andrea Margheri
 * 
 */
public class StringComparisonEvaluator implements IComparisonEvaluator {

	private static StringComparisonEvaluator instance;

	private StringComparisonEvaluator() {

	}

	public static StringComparisonEvaluator getInstance() {
		if (instance == null) {
			instance = new StringComparisonEvaluator();
		}
		return instance;
	}

	@Override
	public boolean areEquals(Object o1, Object o2) throws Throwable {
		if (o2 instanceof String) {
			return ((String) o1).equals(o2);
		} else if (o2 instanceof Date) {
			return (Util.parseDate((String) o1)).equals((Date) o2);
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "Equal");
	}

	@Override
	public boolean areNotEquals(Object o1, Object o2) throws Throwable {
		if (o2 instanceof String) {
			return !(((String) o1).equals(o2));
		} else if (o2 instanceof Date) {
			return !((Util.parseDate((String) o1)).equals((Date) o2));
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "Not-Equal");
	}

	@Override
	public boolean isLessThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("String", "Less-Than");
	}

	@Override
	public boolean isLessThanOrEqual(Object o1, Object o2) throws UnsupportedTypeException {
		throw new UnsupportedTypeException("String", "Less-Than-Or-Equal");
	}

	@Override
	public boolean isGreaterThan(Object o1, Object o2) throws UnsupportedTypeException {
		throw new UnsupportedTypeException("String", "Greater-Than");
	}

	@Override
	public boolean isGreateThanOrEqual(Object o1, Object o2) throws UnsupportedTypeException {
		throw new UnsupportedTypeException("String", "Greater-Than-Or-Equal");
	}

	@Override
	public boolean isIn(Object o1, Object o2) throws Throwable {
		if (o2 instanceof String) {
			return ((String) o1).equals(o2);
		} else if (o2 instanceof Set) {
			return ((Set) o2).contains(o1);
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "In");
	}

}
