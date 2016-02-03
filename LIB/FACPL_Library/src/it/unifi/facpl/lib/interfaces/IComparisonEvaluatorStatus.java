package it.unifi.facpl.lib.interfaces;

import java.util.List;

import it.unifi.facpl.system.status.StatusAttribute;

public interface IComparisonEvaluatorStatus {
	/*
	 * Boolean Comparison
	 */

	public boolean areEquals( StatusAttribute s1, Object o1 , StatusAttribute s2, Object o2 ) throws Throwable;
	
	public boolean areNotEquals( StatusAttribute s1, Object o1 , StatusAttribute s2, Object o2 ) throws Throwable;
	
	public boolean isLessThan( StatusAttribute s1, Object o1 , StatusAttribute s2, Object o2 ) throws Throwable;
	
	public boolean isLessThanOrEqual( StatusAttribute s1, Object o1 , StatusAttribute s2, Object o2 ) throws Throwable;
	
	public boolean isGreaterThan( StatusAttribute s1, Object o1 , StatusAttribute s2, Object o2 ) throws Throwable;
	
	public boolean isGreateThanOrEqual( StatusAttribute s1, Object o1 , StatusAttribute s2, Object o2) throws Throwable;
	
	//NOT DEFINED BY EVALUATOR -> TO USE Class ExpressionBooleanTree
	
//	/* 
//	 *Logic operators 
//	 */
//	
//	public boolean and(List<Object> objs) throws Throwable;
//	
//	public boolean or(List<Object> objs) throws Throwable;
//	
//	public boolean not(Object o1) throws Throwable;
	
	/*
	 * Set operators
	 */
	
	public boolean isSubsetOf(StatusAttribute s1, Object o1 , StatusAttribute s2, Object o2) throws Throwable;
	
	public boolean isAtLestOneMemberOf (StatusAttribute s1, Object o1 , StatusAttribute s2, Object o2) throws Throwable;
	
	/*
	 * List operators
	 */
	
	public boolean isListElement(List<?> list, Object o2) throws Throwable; //si fara' in seguito
}
