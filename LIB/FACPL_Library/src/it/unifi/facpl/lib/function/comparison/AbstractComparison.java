package it.unifi.facpl.lib.function.comparison;

import java.util.List;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.function.comparison.evaluator.ComparisonEvaluatorFactory;
import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.interfaces.IComparisonFunction;
import it.unifi.facpl.system.status.StatusAttribute;

public abstract class AbstractComparison  implements IComparisonFunction {

	public AbstractComparison() {
		super();
	}

	@Override
	public Boolean evaluateFunction(List<Object> args) throws Throwable {

		if (args.size() == 2){
			Object o1, o2;
			o1 = args.get(0) instanceof StatusAttribute? 
					this.convertType((StatusAttribute)args.get(0)): args.get(0);
			o2 = args.get(1) instanceof StatusAttribute? 
					this.convertType((StatusAttribute)args.get(1)): args.get(1);
			IComparisonEvaluator evaluator = ComparisonEvaluatorFactory.getInstance().getEvaluator(o1);
			return op(evaluator, o1, o2);

		}
		else
		{
			throw new Exception("Illegal number of arguments");
		}
	}
	/*
	 * effettua il controllo sul tipo dell'attributo dello status attribute
	 * e fa il cast al tipo corretto
	 */
	private Object convertType(StatusAttribute s) {
		if (s.getType() == FacplStatusType.BOOLEAN) {
			return Boolean.getBoolean(s.getValue());
		}
		else if (s.getType() == FacplStatusType.DOUBLE) {
			return Double.valueOf(s.getValue());
		}
		else if (s.getType() == FacplStatusType.INT) {
			return Integer.valueOf(s.getValue());
		}
		else if (s.getType() == FacplStatusType.STRING) {
			return s.getValue();
		}
		return null;
	}

	protected abstract Boolean op(IComparisonEvaluator ev, Object o1, Object o2) throws Throwable ;
}