package it.unifi.facpl.lib.function.comparison;

import java.util.List;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.function.comparison.evaluator.ComparisonEvaluatorFactory;
import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.interfaces.IComparisonFunction;
import it.unifi.facpl.system.status.StatusAttribute;

public class GreaterThanOrEqual implements IComparisonFunction {

	public Boolean evaluateFunction(List<Object> args) throws Throwable {

		if (args.size() == 2) {
			Object o1, o2;
			/*
			 * if one of the args is a status attribute -> retrieve value
			 */
			o1 = args.get(0) instanceof StatusAttribute ? this.convertType((StatusAttribute) args.get(0)) : args.get(0);
			o2 = args.get(1) instanceof StatusAttribute ? this.convertType((StatusAttribute) args.get(1)) : args.get(1);
			IComparisonEvaluator evaluator = ComparisonEvaluatorFactory.getInstance().getEvaluator(o1);
			return evaluator.isGreateThanOrEqual(o1, o2);

		} else {
			throw new Exception("Illegal number of arguments");
		}
	}

	private Object convertType(StatusAttribute sa) {
		/*
		 * retrieve value from status attribute
		 */
		// StatusAttribute sa = FacplStatus.getInstance().getStatusAttribute(s);
		if (sa.getType() == FacplStatusType.BOOLEAN) {
			return Boolean.getBoolean(sa.getValue());
		} else if (sa.getType() == FacplStatusType.DOUBLE) {
			return Double.valueOf(sa.getValue());
		} else if (sa.getType() == FacplStatusType.INT) {
			return Integer.valueOf(sa.getValue());
		} else if (sa.getType() == FacplStatusType.STRING) {
			return sa.getValue();
		}
		return null;
	}

}
