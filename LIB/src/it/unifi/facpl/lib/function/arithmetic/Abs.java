package it.unifi.facpl.lib.function.arithmetic;

import java.util.List;

import it.unifi.facpl.lib.function.arithmetic.evaluator.ArithmeticEvaluator;
import it.unifi.facpl.lib.function.arithmetic.evaluator.ArithmeticEvaluatorFactory;
import it.unifi.facpl.lib.interfaces.IExpressionFunction;

public class Abs implements IExpressionFunction{

	@Override
	public Object evaluateFunction(List<Object> args)	throws Throwable {

		if (args.size() == 1){
			Object o1 = args.get(0);

			ArithmeticEvaluator evaluator = ArithmeticEvaluatorFactory.getInstance().getEvaluator(o1);
			return evaluator.abs(o1);

		}else{
			throw new Exception("Illegal number of arguments");
		}
	}



	
}
