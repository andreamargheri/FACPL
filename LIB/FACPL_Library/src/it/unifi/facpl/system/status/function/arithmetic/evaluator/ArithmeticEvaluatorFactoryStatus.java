package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import java.util.HashMap;

import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

public class ArithmeticEvaluatorFactoryStatus {
	private static ArithmeticEvaluatorFactoryStatus instance;

	private HashMap<Class<?>, ArithmeticEvaluatorStatus> table;

	private ArithmeticEvaluatorFactoryStatus() {
		this.table = new HashMap<Class<?>, ArithmeticEvaluatorStatus>();

		//initialisation
		this.table.put(Integer.class, NumberArithmeticEvaluatorStatus.getInstance());
		this.table.put(Double.class, NumberArithmeticEvaluatorStatus.getInstance());
		this.table.put(Boolean.class, NumberArithmeticEvaluatorStatus.getInstance());
	}

	public static synchronized ArithmeticEvaluatorFactoryStatus getInstance() {
		if (instance == null) {
			instance = new ArithmeticEvaluatorFactoryStatus(); 
		}
		return instance;
	}

	public ArithmeticEvaluatorStatus getEvaluator(Object o) throws Exception {

		try{
			ArithmeticEvaluatorStatus evaluator = table.get(o.getClass());
			if (evaluator == null) {
				// evaluator = new DefaultComparisonEvaluator();
				System.err.println("No comparison fucntion available for data type "+ o.getClass().getName());
				throw new Exception("No comparison fucntion available for data type "+ o.getClass().getName());
			}
			return evaluator; //ritorna il valutatore alla funzione
		}catch (UnsupportedTypeException e){
			System.err.println(e.getMessage());
			throw e;
		}
	}
}
