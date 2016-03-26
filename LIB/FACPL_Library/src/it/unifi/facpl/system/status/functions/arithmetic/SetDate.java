package it.unifi.facpl.system.status.functions.arithmetic;

import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorStatus;

public class SetDate extends MathOperationStatus {

	@Override
	protected void op(ArithmeticEvaluatorStatus ev, StatusAttribute s1, Object o2, FacplStatus status)
			throws Throwable {
		ev.set_date(status, s1, o2);

	}

}
