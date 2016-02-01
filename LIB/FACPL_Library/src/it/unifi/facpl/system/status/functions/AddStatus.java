package it.unifi.facpl.system.status.functions;

import java.util.List;

import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorFactoryStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.ArithmeticEvaluatorStatus;
import it.unifi.facpl.system.status.functions.evalutor.IExpressionFunctionStatus;

public class AddStatus implements IExpressionFunctionStatus {

		public Object evaluateFunction(List<Object> args) throws Throwable {
			
			if (args.size() == 2) {

				Object o1 = args.get(0);
				Object o2 = args.get(1);

				ArithmeticEvaluatorStatus evaluator;// = ArithmeticEvaluatorFactoryStatus.getInstance().getEvaluator(o1);
				//return evaluator.add(o1, o2);
				return o1; //da cancellare dopo aver riscritto evaluator
			} else {
				throw new Exception("Illegal number of arguments");
			}
		}
}
