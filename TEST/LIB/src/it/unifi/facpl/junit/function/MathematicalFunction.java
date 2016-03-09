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
package it.unifi.facpl.junit.function;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unifi.facpl.lib.function.arithmetic.Abs;
import it.unifi.facpl.lib.function.arithmetic.Add;
import it.unifi.facpl.lib.function.arithmetic.Divide;
import it.unifi.facpl.lib.function.arithmetic.Mod;
import it.unifi.facpl.lib.function.arithmetic.Multiply;
import it.unifi.facpl.lib.function.arithmetic.Subtract;
import it.unifi.facpl.lib.interfaces.IExpressionFunction;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

public class MathematicalFunction {

	private IExpressionFunction function;
	private List integers_Eq, integers_Diff, integers_Times, integers_One;
	private List doubles_Eq, doubles_Diff, doubles_Times, doubles_One;
	private List boolean_Eq, boolean_Diff, boolean_Times, boolean_One;

	// doubles, booleans;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		// Integer
		integers_Eq = new LinkedList<Integer>();
		integers_Eq.add(4);
		integers_Eq.add(4);
		integers_Diff = new LinkedList<Integer>();
		integers_Diff.add(4);
		integers_Diff.add(5);
		integers_Times = new LinkedList<Integer>();
		integers_Times.add(4);
		integers_Times.add(3);
		integers_Times.add(6);
		integers_One = new LinkedList<Integer>();
		integers_One.add(1);

		// Double
		doubles_Eq = new LinkedList<Double>();
		doubles_Eq.add(4.4);
		doubles_Eq.add(4.4);
		doubles_Diff = new LinkedList<Double>();
		doubles_Diff.add(4.2);
		doubles_Diff.add(5.5);
		doubles_Times = new LinkedList<Double>();
		doubles_Times.add(4.6);
		doubles_Times.add(3.2);
		doubles_Times.add(6.1);
		doubles_One = new LinkedList<Double>();
		doubles_One.add(1.4);

		// Boolean
		boolean_Eq = new LinkedList<Boolean>();
		boolean_Eq.add(true);
		boolean_Eq.add(true);
		boolean_Diff = new LinkedList<Boolean>();
		boolean_Diff.add(true);
		boolean_Diff.add(false);
		boolean_Times = new LinkedList<Boolean>();
		boolean_Times.add(true);
		boolean_Times.add(true);
		boolean_Times.add(false);
		boolean_One = new LinkedList<Boolean>();
		boolean_One.add(true);

	}

	// Add.java
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd_Function_Double() throws Throwable {
		function = new Add();
		Double b = (Double) function.evaluateFunction(doubles_Eq);
		assertEquals(new Double(8.8), b);
		b = (Double) function.evaluateFunction(doubles_Diff);
		assertEquals(new Double(9.7), b);
		try {
			function.evaluateFunction(doubles_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(doubles_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAdd_Function_Int() throws Throwable {
		function = new Add();
		Integer b = (Integer) function.evaluateFunction(integers_Eq);
		assertEquals(new Integer(8), b);
		b = (Integer) function.evaluateFunction(integers_Diff);
		assertEquals(new Integer(9), b);
		try {
			function.evaluateFunction(integers_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(integers_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAdd_Function_Boolean() throws Throwable {
		function = new Add();
		Integer b;
		try {
			b = (Integer) function.evaluateFunction(boolean_Eq);
			assertEquals(new Integer(8), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			b = (Integer) function.evaluateFunction(boolean_Diff);
			assertEquals(new Integer(9), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			function.evaluateFunction(boolean_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(boolean_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// Subtract
	@SuppressWarnings("unchecked")
	@Test
	public void testSubtract_Function_Double() throws Throwable {
		function = new Subtract();
		Double b = (Double) function.evaluateFunction(doubles_Eq);
		assertEquals(new Double(0.0), b);
		b = (Double) function.evaluateFunction(doubles_Diff);
		// [4.2,5.5]
		assertEquals(new Double((Double) doubles_Diff.get(0) - (Double) doubles_Diff.get(1)), b);
		try {
			function.evaluateFunction(doubles_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(doubles_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSubtract_Function_Int() throws Throwable {
		function = new Subtract();
		Integer b = (Integer) function.evaluateFunction(integers_Eq);
		assertEquals(new Integer(0), b);
		b = (Integer) function.evaluateFunction(integers_Diff);
		assertEquals(new Integer(-1), b);
		try {
			function.evaluateFunction(integers_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(integers_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSubtract_Function_Boolean() throws Throwable {
		function = new Subtract();
		Integer b;
		try {
			b = (Integer) function.evaluateFunction(boolean_Eq);
			assertEquals(new Integer(8), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			b = (Integer) function.evaluateFunction(boolean_Diff);
			assertEquals(new Integer(9), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			function.evaluateFunction(boolean_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(boolean_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// Multiply
	@SuppressWarnings("unchecked")
	@Test
	public void testMultiply_Function_Double() throws Throwable {
		function = new Multiply();
		Double b = (Double) function.evaluateFunction(doubles_Eq);
		assertEquals(new Double((Double) doubles_Eq.get(0) * (Double) doubles_Eq.get(1)), b);
		b = (Double) function.evaluateFunction(doubles_Diff);
		// [4.2,5.5]
		assertEquals(new Double((Double) doubles_Diff.get(0) * (Double) doubles_Diff.get(1)), b);
		try {
			function.evaluateFunction(doubles_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(doubles_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMultiply_Function_Int() throws Throwable {
		function = new Multiply();
		Integer b = (Integer) function.evaluateFunction(integers_Eq);
		assertEquals(new Integer(16), b);
		b = (Integer) function.evaluateFunction(integers_Diff);
		assertEquals(new Integer(20), b);
		try {
			function.evaluateFunction(integers_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(integers_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMultiply_Function_Boolean() throws Throwable {
		function = new Multiply();
		Integer b;
		try {
			b = (Integer) function.evaluateFunction(boolean_Eq);
			assertEquals(new Integer(16), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			b = (Integer) function.evaluateFunction(boolean_Diff);
			assertEquals(new Integer(20), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			function.evaluateFunction(boolean_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(boolean_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// Divide
	@SuppressWarnings("unchecked")
	@Test
	public void testDivide_Function_Double() throws Throwable {
		function = new Divide();
		Double b = (Double) function.evaluateFunction(doubles_Eq);
		assertEquals(new Double((Double) doubles_Eq.get(0) / (Double) doubles_Eq.get(1)), b);
		b = (Double) function.evaluateFunction(doubles_Diff);
		// [4.2,5.5]
		assertEquals(new Double((Double) doubles_Diff.get(0) / (Double) doubles_Diff.get(1)), b);
		try {
			function.evaluateFunction(doubles_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(doubles_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDivide_Function_Int() throws Throwable {
		function = new Divide();
		Integer b = (Integer) function.evaluateFunction(integers_Eq);
		assertEquals(new Integer(1), b);
		b = (Integer) function.evaluateFunction(integers_Diff);
		assertEquals(new Integer(0), b);
		try {
			function.evaluateFunction(integers_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(integers_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDivide_Function_Boolean() throws Throwable {
		function = new Divide();
		Integer b;
		try {
			b = (Integer) function.evaluateFunction(boolean_Eq);
			assertEquals(new Integer(16), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			b = (Integer) function.evaluateFunction(boolean_Diff);
			assertEquals(new Integer(20), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			function.evaluateFunction(boolean_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(boolean_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// Abs.java
	@SuppressWarnings("unchecked")
	@Test
	public void testAbs_Function_Double() throws Throwable {
		function = new Abs();
		Double b;
		try {
			b = (Double) function.evaluateFunction(doubles_Eq);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			b = (Double) function.evaluateFunction(doubles_Diff);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}

		try {
			function.evaluateFunction(doubles_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		System.out.println(Math.abs(1.4));
		b = (Double) function.evaluateFunction(doubles_One);
		assertEquals(new Double(1.4), b);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAbs_Function_Int() throws Throwable {
		function = new Abs();
		Integer b;
		try {
			b = (Integer) function.evaluateFunction(integers_Eq);
			assertEquals(new Integer(1), b);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			b = (Integer) function.evaluateFunction(integers_Diff);
			assertEquals(new Integer(0), b);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(integers_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		b = (Integer) function.evaluateFunction(integers_One);
		assertEquals(new Integer(1), b);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAbs_Function_Boolean() throws Throwable {
		function = new Abs();
		Integer b;
		try {
			b = (Integer) function.evaluateFunction(boolean_Eq);
			assertEquals(new Integer(16), b);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			b = (Integer) function.evaluateFunction(boolean_Diff);
			assertEquals(new Integer(20), b);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(boolean_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(boolean_One);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
	}

	// Mod.java
	@SuppressWarnings("unchecked")
	@Test
	public void testMod_Function_Double() throws Throwable {
		function = new Mod();
		Double b;
		try {
			b = (Double) function.evaluateFunction(doubles_Eq);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
		}
		try {
			b = (Double) function.evaluateFunction(doubles_Diff);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
		}

		try {
			function.evaluateFunction(doubles_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			b = (Double) function.evaluateFunction(doubles_One);
			assertEquals(new Double(1.4), b);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMod_Function_Int() throws Throwable {
		function = new Mod();
		Integer b;

		b = (Integer) function.evaluateFunction(integers_Eq);
		assertEquals(new Integer(0), b);

		// [4,5] -> 4%5
		b = (Integer) function.evaluateFunction(integers_Diff);
		assertEquals(new Integer(4), b);

		try {
			function.evaluateFunction(integers_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			b = (Integer) function.evaluateFunction(integers_One);
			assertEquals(new Integer(1), b);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMod_Function_Boolean() throws Throwable {
		function = new Mod();
		Integer b;
		try {
			b = (Integer) function.evaluateFunction(boolean_Eq);
			assertEquals(new Integer(16), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			b = (Integer) function.evaluateFunction(boolean_Diff);
			assertEquals(new Integer(20), b);
		} catch (Exception e) {
			assertEquals(Exception.class, e.getClass());
		}
		try {
			function.evaluateFunction(boolean_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(boolean_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

}
