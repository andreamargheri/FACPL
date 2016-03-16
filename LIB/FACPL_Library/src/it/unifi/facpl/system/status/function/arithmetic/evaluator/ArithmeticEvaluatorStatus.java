package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public interface ArithmeticEvaluatorStatus {
	/*
	 * o1: statusattribute o2: value
	 */
	public void add(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable;

	public void divide(FacplStatus status,StatusAttribute o1, Object o2) throws Throwable;

	public void multiply(FacplStatus status,StatusAttribute o1, Object o2) throws Throwable;

	public void subtract(FacplStatus status,StatusAttribute o1, Object o2) throws Throwable;

	public void flag(FacplStatus status,StatusAttribute o1, Object o2) throws Throwable; // e' per
																		// i
																		// booleani,
																		// per
																		// comodita'
																		// e'
																		// inserito
																		// nelle
																		// aritmetiche

	public void sum_date(FacplStatus status,StatusAttribute s1, Object o2) throws Throwable;
	
	public void set_date(FacplStatus status,StatusAttribute s1, Object o2) throws Throwable;

}
