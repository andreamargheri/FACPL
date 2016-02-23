package it.unifi.facpl.lib.interfaces;

import java.util.List;

/**
 * Comparison to implement by the supported datatypes
 * 
 * @author Andrea Margheri
 *
 */
public interface IComparisonEvaluator {

	/*
	 * Boolean Comparison
	 */

	public boolean areEquals(Object o1, Object o2) throws Throwable;

	public boolean areNotEquals(Object o1, Object o2) throws Throwable;

	public boolean isLessThan(Object o1, Object o2) throws Throwable;

	public boolean isLessThanOrEqual(Object o1, Object o2) throws Throwable;

	public boolean isGreaterThan(Object o1, Object o2) throws Throwable;

	public boolean isGreateThanOrEqual(Object o1, Object o2) throws Throwable;

	// NOT DEFINED BY EVALUATOR -> TO USE Class ExpressionBooleanTree

	// /*
	// *Logic operators
	// */
	//
	// public boolean and(List<Object> objs) throws Throwable;
	//
	// public boolean or(List<Object> objs) throws Throwable;
	//
	// public boolean not(Object o1) throws Throwable;

	/*
	 * Set operators
	 */

	public boolean isSubsetOf(Object o1, Object o2) throws Throwable;

	public boolean isAtLestOneMemberOf(Object o1, Object o2) throws Throwable;

	/*
	 * List operators
	 */

	public boolean isListElement(List<?> list, Object o2) throws Throwable;
}
