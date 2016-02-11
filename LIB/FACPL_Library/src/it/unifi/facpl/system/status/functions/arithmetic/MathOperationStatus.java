package it.unifi.facpl.system.status.functions.arithmetic;

import java.util.List;

import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorFactoryStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;

public abstract class MathOperationStatus  implements IExpressionFunctionStatus {

	public MathOperationStatus() {
		super();
	}


	public void evaluateFunction(List<Object> args) throws Throwable {

		if (args.size() == 2) { //secondo controllo quasi inutile
			StatusAttribute s1;
			if (args.get(0) instanceof StatusAttribute) {
				s1 = (StatusAttribute)args.get(0);
			} 
			else { 
				throw new Exception("First argument it's not a Status Attribute");
			}
			Object o2 = args.get(1); //valore

			ArithmeticEvaluatorStatus evaluator = ArithmeticEvaluatorFactoryStatus.getInstance().getEvaluator(o2); 
			//passo il valore per ottenere il valutatore adatto
			op(evaluator, s1, o2); //chiamo il metodo per fare le varie operazioni [elimino ridondanza di codice]
		} else {
			throw new Exception("Illegal number of arguments");
		}
	}
	/*
	 * metodo astratto implementato nelle sottoclassi per le oprazioni
	 */
	abstract protected void op(ArithmeticEvaluatorStatus ev, StatusAttribute s1, Object o2) throws Throwable ;


}
