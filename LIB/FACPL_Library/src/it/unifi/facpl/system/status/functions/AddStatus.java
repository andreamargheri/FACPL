package it.unifi.facpl.system.status.functions;

import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorStatus;
import it.unifi.facpl.system.status.functions.evalutor.IExpressionFunctionStatus;

public class AddStatus extends MathOperationStatus {

	@Override
	protected void op(ArithmeticEvaluatorStatus ev,StatusAttribute s1, Object o2) throws Throwable {
		ev.add(s1, o2);
	}
}
