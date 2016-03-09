/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
package it.unifi.facpl.lib.function.arithmetic;

import java.util.List;

import it.unifi.facpl.lib.function.arithmetic.evaluator.ArithmeticEvaluator;
import it.unifi.facpl.lib.function.arithmetic.evaluator.ArithmeticEvaluatorFactory;
import it.unifi.facpl.lib.interfaces.IExpressionFunction;

public class Multiply implements IExpressionFunction {

	@Override
	public Object evaluateFunction(List<Object> args) throws Throwable {

		if (args.size() == 2) {
			Object o1 = args.get(0);
			Object o2 = args.get(1);

			ArithmeticEvaluator evaluator = ArithmeticEvaluatorFactory.getInstance().getEvaluator(o1);
			return evaluator.multiply(o1, o2);

		} else {
			throw new Exception("Illegal number of arguments");
		}

	}

}
