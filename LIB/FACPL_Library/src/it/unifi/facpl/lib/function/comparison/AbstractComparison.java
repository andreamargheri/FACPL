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
		/* potrebbe essere un'idea riutilizzare la struttura gia' presente
		 * estraendo dagli attributi i valori che ci servono e facendoli comparare come prima
		 * [DA CHIEDERE]
		 */
		if (args.size() == 2){
			Object o1, o2;
			o1 = args.get(0) instanceof StatusAttribute? ((StatusAttribute)args.get(0)).getValue() : args.get(0);
			o2 = args.get(1) instanceof StatusAttribute? ((StatusAttribute)args.get(1)).getValue() : args.get(1);
			if (!(o1 instanceof StatusAttribute) ^ !(o2 instanceof StatusAttribute) ) {
				throw new Exception("One is attribute and other no");
				/*
				 * magari fare mix dei due casi ovvero:
				 * args[0]: StatusAttribute
				 * args[1]: valore
				 * si estrae il valore da args[0] e si confronta con args[1] o viceversa
				 */
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