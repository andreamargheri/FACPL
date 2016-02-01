package it.unifi.facpl.system.status.function.comparison.evaluator;

import java.util.HashMap;
import java.util.List;

import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;
import it.unifi.facpl.lib.interfaces.IComparisonEvaluatorStatus;

public class ComparisonEvaluatorFactoryStatus {
	private static ComparisonEvaluatorFactoryStatus instance;

	private HashMap<Class<?>, IComparisonEvaluatorStatus> table;

	/**
	 * Initialization of the evaluators -> NB to add reference otherwise exception
	 */
	private ComparisonEvaluatorFactoryStatus() {
		this.table = new HashMap<Class<?>, IComparisonEvaluatorStatus>();
		
		//initialisation
		this.table.put(Integer.class, NumberComparisonEvaluatorStatus.getInstance());
		this.table.put(Double.class, NumberComparisonEvaluatorStatus.getInstance());
		this.table.put(String.class, StringComparisonEvaluatorStatus.getInstance());
		this.table.put(Boolean.class, BooleanComparisonEvaluatorStatus.getInstance());
		this.table.put(FacplDate.class, DateComparisonEvaluatorStatus.getInstance());
		this.table.put(List.class, ListComparisonEvaluatorStatus.getInstance()); 
		
	}

	public static synchronized ComparisonEvaluatorFactoryStatus getInstance() {
		if (instance == null) {
			instance = new ComparisonEvaluatorFactoryStatus();
		}
		return instance;
	}

	public IComparisonEvaluatorStatus getEvaluator(Object o) throws Exception {

		try{
			IComparisonEvaluatorStatus evaluator = table.get(o.getClass());
			if (evaluator == null) {
				// evaluator = new DefaultComparisonEvaluator();
				System.err.println("No comparison fucntion available for data type "+ o.getClass().getName());
				throw new Exception("No comparison fucntion available for data type "+ o.getClass().getName());
			}		
			return evaluator;
		}catch (UnsupportedTypeException e){
			System.err.println(e.getMessage());
			throw e;
		}
	}
}
