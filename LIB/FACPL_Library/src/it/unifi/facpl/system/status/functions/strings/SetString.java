package it.unifi.facpl.system.status.functions.strings;

import java.util.List;

import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.StringEvaluator;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.StringEvaluatorStatus;

public class SetString extends StringOperationStatus {

	@Override
	protected void op(StringEvaluatorStatus ev, StatusAttribute s1, Object o2) throws Throwable {
		ev.setValue(s1, o2);
		
	}



}
