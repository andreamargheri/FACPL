/**
 * Copyright (c) 2014 Concurrency and Mobility Group.
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

import java.util.List;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;



/**
 * @author Andrea Margheri
 *
 */
public class BooleanComparisonEvaluator implements IComparisonEvaluator{

	private static BooleanComparisonEvaluator instance; 
	
	private BooleanComparisonEvaluator(){
		
	}
	
	public static BooleanComparisonEvaluator getInstance(){
		if (instance == null){
			instance = new BooleanComparisonEvaluator();
		}
		return instance;
	}

	
	
	@Override
	public boolean areEquals(Object o1, Object o2) throws Throwable {
		if (o2 instanceof Boolean)
			return ((Boolean)o1).equals(o2);
		else
			throw new UnsupportedTypeException(o2.getClass().getName(), "Equal");
	}

	@Override
	public boolean areNotEquals(Object o1, Object o2) throws Throwable {
		if (o2 instanceof Boolean)
			return !(((Boolean)o1).equals(o2));
		else
			throw new UnsupportedTypeException(o2.getClass().getName(), "Equal");
	}

	@Override
	public boolean isLessThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Boolean", "Less-Than");
	}

	@Override
	public boolean isLessThanOrEqual(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Boolean", "Less-Than-Or-Equal");
	}

	@Override
	public boolean isGreaterThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Boolean", "Greater-Than");
	}

	@Override
	public boolean isGreateThanOrEqual(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Boolean", "Greater-Than-Or-Equal");
	}

	@Override
	public boolean isSubsetOf(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Boolean", "Subset-Of");
	}

	@Override
	public boolean isAtLestOneMemberOf(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Boolean", "At-Least-One-Member-Of");
	}
	@Override
	public boolean isListElement(List<?> list, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Boolean", "Is-List-Element");

	}


}
