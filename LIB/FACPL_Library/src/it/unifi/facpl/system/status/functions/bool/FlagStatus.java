package it.unifi.facpl.system.status.functions.bool;

import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorStatus;
import it.unifi.facpl.system.status.functions.arithmetic.MathOperationStatus;

public class FlagStatus extends MathOperationStatus {

	@Override
	protected void op(ArithmeticEvaluatorStatus ev, StatusAttribute s1, Object o2) throws Throwable {
		ev.flag(s1, o2);
	}

}