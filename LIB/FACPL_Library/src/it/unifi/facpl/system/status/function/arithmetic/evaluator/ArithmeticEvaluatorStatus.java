package it.unifi.facpl.system.status.function.arithmetic.evaluator;

public interface ArithmeticEvaluatorStatus {
	
	public Number add (Object o1, Object o2) throws Throwable;
	
	public Number divide (Object o1, Object o2) throws Throwable;
	
	public Number multiply (Object o1, Object o2) throws Throwable;
	
	public Number subtract (Object o1, Object o2) throws Throwable;
	
	public Number mod (Object o1, Object o2) throws Throwable;
	
	/*
	 * Unary Operators
	 */
	
	public Number abs (Object o1) throws Throwable;
	
	
}
