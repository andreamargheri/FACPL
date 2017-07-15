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

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.util.Set;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

/**
 * @author Andrea Margheri
 * 
 */
public class SetComparisonEvaluator implements IComparisonEvaluator {

	private static SetComparisonEvaluator instance;

	private SetComparisonEvaluator() {

	}

	public static SetComparisonEvaluator getInstance() {
		if (instance == null) {
			instance = new SetComparisonEvaluator();
		}
		return instance;
	}

	@Override
	public boolean areEquals(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Equal");
	}

	@Override
	public boolean areNotEquals(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Not-Equal");
	}

	@Override
	public boolean isLessThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Less-Than");
	}

	@Override
	public boolean isLessThanOrEqual(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Less-Than-Or-Equal");
	}

	@Override
	public boolean isGreaterThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Greater-Than");
	}

	@Override
	public boolean isGreateThanOrEqual(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Greater-Than-Or-Equal");
	}

	@Override
	public boolean isIn(Object o1, Object o2) throws Throwable {
		if (o2 instanceof Set) {
			return ((Set) o2).contains((Set) o1);
		} else if (((Set) o1).getValues().size() == 1) {
			// o2 of a different type, e.g. a literal, thus if the bag is formed
			// by only one value they are compared each other
			return ((Set) o1).contains(o2);
		} else {
			throw new UnsupportedTypeException("Set vs" + o2.getClass().getName(), "Subset");
		}
	}
}
