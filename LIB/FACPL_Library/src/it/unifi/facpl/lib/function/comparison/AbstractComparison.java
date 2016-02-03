package it.unifi.facpl.lib.function.comparison;

import java.util.List;

import it.unifi.facpl.lib.function.comparison.evaluator.ComparisonEvaluatorFactory;
import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.interfaces.IComparisonFunction;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;
import it.unifi.facpl.system.status.StatusAttribute;

public abstract class AbstractComparison  implements IComparisonFunction {

	public AbstractComparison() {
		super();
	}

	@Override
	public Boolean evaluateFunction(List<Object> args) throws Throwable {
	
		if (args.size() == 2){
			Object o1 = args.get(0);
			Object o2 = args.get(1);
	
			IComparisonEvaluator evaluator = ComparisonEvaluatorFactory.getInstance().getEvaluator(o1);
			return op(evaluator, o1, o2);
			
		}
		/* potrebbe essere un'idea riutilizzare la struttura gia' presente
		 * estraendo dagli attributi i valori che ci servono e facendoli comparare come prima
		 * [DA CHIEDERE]
		 * args[0] = 1 SA
		 * args[1] = value del 1
		 * args[2] = 2 SA
		 * args[3] = value del 2
		 */
		if (args.size() == 4) {
			Object o1, o2;
			if (args.get(0) instanceof StatusAttribute && args.get(2) instanceof StatusAttribute) {
				o1 = ((StatusAttribute)args.get(0)).getValue();
				o2 = ((StatusAttribute)args.get(2)).getValue();
			}
			else  {
				throw new UnsupportedTypeException();
			}
	
			IComparisonEvaluator evaluator = ComparisonEvaluatorFactory.getInstance().getEvaluator(o1);
			return op(evaluator, o1, o2);
		}
		else
		{
			throw new Exception("Illegal number of arguments");
		}
	}
	protected abstract Boolean op(IComparisonEvaluator ev, Object o1, Object o2) throws Throwable ;
}