package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import it.unifi.facpl.system.status.StatusAttribute;

public interface ArithmeticEvaluatorStatus {
	/*
	 * o1: statusattribute o2: value
	 */
	public void add(StatusAttribute o1, Object o2) throws Throwable;

	public void divide(StatusAttribute o1, Object o2) throws Throwable;

	public void multiply(StatusAttribute o1, Object o2) throws Throwable;

	public void subtract(StatusAttribute o1, Object o2) throws Throwable;

	public void flag(StatusAttribute o1, Object o2) throws Throwable; // e' per
																		// i
																		// booleani,
																		// per
																		// comodita'
																		// e'
																		// inserito
																		// nelle
																		// aritmetiche

	public void sum_date(StatusAttribute s1, Object o2) throws Throwable;
	
	public void set_date(StatusAttribute s1, Object o2) throws Throwable;

}
