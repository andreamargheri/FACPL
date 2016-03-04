package it.unifi.facpl.system.status.functions.strings;

import java.util.List;

import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.StringEvaluator;

public abstract class StringOperationStatus implements IExpressionFunctionStatus {

	public StringOperationStatus() {
		super();
	}

	@Override
	public void evaluateFunction(List<Object> args) throws Throwable {
		if (args.size() == 2) { 
			StatusAttribute s1;
			if (args.get(0) instanceof StatusAttribute) {
				s1 = (StatusAttribute) args.get(0);
			} else {
				throw new Exception("First argument it's not a Status Attribute");
			}
			Object o2 = args.get(1); // value
			op(s1, o2);
									
		} else {
			throw new Exception("Illegal number of arguments");
		}
		
	}
	
	abstract protected void op(StatusAttribute s1, Object o2) throws Throwable;

	
}