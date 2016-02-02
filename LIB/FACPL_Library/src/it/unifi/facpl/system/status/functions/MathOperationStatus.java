package it.unifi.facpl.system.status.functions;

import java.util.List;

import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorFactoryStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorStatus;
import it.unifi.facpl.system.status.functions.evalutor.IExpressionFunctionStatus;

public abstract class MathOperationStatus {

	public MathOperationStatus() {
		super();
	}
	
	

	public void evaluateFunction(List<Object> args) throws Throwable {
		
		if (args.size() == 2 && args.get(0) instanceof StatusAttribute) { //secondo controllo quasi inutile
	
			StatusAttribute s1 = (StatusAttribute)args.get(0); //attributo
			Object o2 = args.get(1); //valore
	
			ArithmeticEvaluatorStatus evaluator = ArithmeticEvaluatorFactoryStatus.getInstance().getEvaluator(o2); 
			//passo il valore per ottenere il valutatore adatto
			op(evaluator, s1, o2);
		} else {
			throw new Exception("Illegal number of arguments");
		}
	}
	
	abstract protected void op(ArithmeticEvaluatorStatus ev, StatusAttribute s1, Object o2) throws Throwable ;
	
	
}
