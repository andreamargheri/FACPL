package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import it.unifi.facpl.system.status.StatusAttribute;

public interface StringEvaluatorStatus {
	public void setValue(StatusAttribute o1, Object o2) throws Throwable;
	public void sumString(StatusAttribute o1, Object o2) throws Throwable;
}
