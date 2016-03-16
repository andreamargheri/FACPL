package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import java.util.List;

import it.unifi.facpl.system.status.FacplStatus;

public interface IExpressionFunctionStatus {

	public void evaluateFunction(FacplStatus status, List<Object> args) throws Throwable;

}
