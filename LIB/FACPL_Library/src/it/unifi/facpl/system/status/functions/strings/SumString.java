package it.unifi.facpl.system.status.functions.strings;

import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.StringEvaluator;

public class SumString extends StringOperationStatus {

	@Override
	protected void op(StatusAttribute s1, Object o2) throws Throwable {
		StringEvaluator.getInstance().sumString(s1, o2);
		
	}

}
