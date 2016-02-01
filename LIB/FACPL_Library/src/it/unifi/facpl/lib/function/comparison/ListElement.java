/**
 * 
 */
package it.unifi.facpl.lib.function.comparison;

import java.util.List;

import it.unifi.facpl.lib.function.comparison.evaluator.ComparisonEvaluatorFactory;
import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.interfaces.IComparisonFunction;

/**
 * @author Andrea
 *
 */
public class ListElement implements IComparisonFunction {
	@Override
	
	public Boolean evaluateFunction(List<Object> args) throws Throwable {
		if (args.size() == 2) {
			
			Object o1 = args.get(0);
			Object o2 = args.get(1);
			
			IComparisonEvaluator evaluator = ComparisonEvaluatorFactory.getInstance().getEvaluator(o1);
			return evaluator.isListElement( (List<?>) o1 , o2 ); //perche' il cast?!?
			
		} else {
			throw new Exception("Illegal number of arguments");
		}
	}
}
