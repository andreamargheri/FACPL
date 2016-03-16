package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public interface StringEvaluatorStatus {
	public void setValue(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable;
	public void sumString(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable;
}
