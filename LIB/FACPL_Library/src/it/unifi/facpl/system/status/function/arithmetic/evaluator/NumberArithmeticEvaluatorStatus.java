package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import it.unifi.facpl.lib.function.arithmetic.evaluator.NumberArithmeticEvaluator;

public class NumberArithmeticEvaluatorStatus  implements ArithmeticEvaluatorStatus{

	private static NumberArithmeticEvaluatorStatus instance; 
	
	private NumberArithmeticEvaluatorStatus(){
		
	}
	
	public static NumberArithmeticEvaluatorStatus getInstance(){
		if (instance == null){
			instance = new NumberArithmeticEvaluatorStatus();
		}
		return instance;
	}
	
	@Override
	public Number add(Object o1, Object o2) throws Throwable {
	
		return null;
	}

	@Override
	public Number divide(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number multiply(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number subtract(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number mod(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number abs(Object o1) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
