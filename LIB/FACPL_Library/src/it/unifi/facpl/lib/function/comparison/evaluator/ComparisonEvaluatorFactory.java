package it.unifi.facpl.lib.function.comparison.evaluator;

import java.util.HashMap;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

/**
 * @author Andrea Margheri
 * 
 */
public class ComparisonEvaluatorFactory {

	private static ComparisonEvaluatorFactory instance;

	private HashMap<Class<?>, IComparisonEvaluator> table;

	/**
	 * Initialization of the evaluators -> NB to add reference otherwise exception
	 */
	private ComparisonEvaluatorFactory() {
		this.table = new HashMap<Class<?>, IComparisonEvaluator>();
		
		//initialisation
		this.table.put(Integer.class, NumberComparisonEvaluator.getInstance());
		this.table.put(Double.class, NumberComparisonEvaluator.getInstance());
		this.table.put(String.class, StringComparisonEvaluator.getInstance());
		this.table.put(Boolean.class, BooleanComparisonEvaluator.getInstance());
		this.table.put(FacplDate.class, DateComparisonEvaluator.getInstance());
		
		this.table.put(List.class, ListComparisonEvalutor.getInstace());
		
	}

	public static synchronized ComparisonEvaluatorFactory getInstance() {
		if (instance == null) {
			instance = new ComparisonEvaluatorFactory();
		}
		return instance;
	}

	public IComparisonEvaluator getEvaluator(Object o) throws Exception {

		try{
			IComparisonEvaluator evaluator = table.get(o.getClass());
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
