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

package it.unifi.facpl.lib.function.arithmetic.evaluator;

import java.util.HashMap;

import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

/**
 * @author Andrea Margheri
 * 
 */
public class ArithmeticEvaluatorFactory {

	private static ArithmeticEvaluatorFactory instance;

	private HashMap<Class<?>, ArithmeticEvaluator> table;

	private ArithmeticEvaluatorFactory() {
		this.table = new HashMap<Class<?>, ArithmeticEvaluator>();

		// initialisation
		this.table.put(Integer.class, NumberArithmeticEvaluator.getInstance());
		this.table.put(Double.class, NumberArithmeticEvaluator.getInstance());
	}

	public static synchronized ArithmeticEvaluatorFactory getInstance() {
		if (instance == null) {
			instance = new ArithmeticEvaluatorFactory();
		}
		return instance;
	}

	public ArithmeticEvaluator getEvaluator(Object o) throws Exception {

		try {
			ArithmeticEvaluator evaluator = table.get(o.getClass());
			if (evaluator == null) {
				// evaluator = new DefaultComparisonEvaluator();
				System.err.println("No comparison fucntion available for data type " + o.getClass().getName());
				throw new Exception("No comparison fucntion available for data type " + o.getClass().getName());
			}
			return evaluator;
		} catch (UnsupportedTypeException e) {
			System.err.println(e.getMessage());
			throw e;
		}
	}

}
