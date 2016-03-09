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

import it.unifi.facpl.lib.function.comparison.In;
import it.unifi.facpl.lib.interfaces.IExpressionFunction;
import it.unifi.facpl.lib.util.Set;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

public class ListFunction {

	private static IExpressionFunction function;

	private final String s1 = "type1";
	private final String s2 = "type2";
	private final String s3 = "type3";
	private final String s4 = "type4";

	private List<Object> list;
	private Set b_ok, b_equals, b_one, b_two, b_noString;

	@Before
	public void setUp() {
		// create bag examples
		b_ok = new Set();
		b_ok.addValue(s1);
		b_ok.addValue(s2);
		b_ok.addValue(s3);
		b_ok.addValue(s4);

		b_equals = new Set();
		b_equals.addValue(s1);
		b_equals.addValue(s1);

		b_one = new Set();
		b_one.addValue(s1);

		b_two = new Set();
		b_two.addValue(s1);
		b_two.addValue(s2);

		b_noString = new Set();
		b_noString.addValue(5);

		list = new LinkedList<Object>();
	}

	// StringSubset.java
	@Test
	public void testSubSet_Function_String() throws Throwable {
		function = new In();

		list.clear();
		list.add(b_equals);
		list.add(b_ok);
		Boolean b = (Boolean) function.evaluateFunction(list);
		assertEquals(true, b);

		list.clear();
		list.add(s1);
		list.add(b_ok);
		b = (Boolean) function.evaluateFunction(list);
		assertEquals(true, b);
		try {
			list.clear();
			list.add(b_two);
			list.add(s1);
			b = (Boolean) function.evaluateFunction(list);
		} catch (Exception e) {
			assertEquals(e.getClass(), UnsupportedTypeException.class);
		}

		list.clear();
		list.add(b_one);
		list.add(s1);
		b = (Boolean) function.evaluateFunction(list);
		assertEquals(true, b);

		list.clear();
		list.add(b_ok);
		list.add(b_equals);
		b = (Boolean) function.evaluateFunction(list);
		assertEquals(false, b);

		list.clear();
		list.add(b_one);
		list.add(b_two);
		b = (Boolean) function.evaluateFunction(list);
		assertEquals(true, b);

		list.clear();
		list.add(b_two);
		list.add(b_one);
		b = (Boolean) function.evaluateFunction(list);
		assertEquals(false, b);
		try {
			list.clear();
			list.add(s1);
			list.add(s1);
			list.add(b_ok);
			function.evaluateFunction(list);
			list.add(b_ok);
			list.add(s1);
			b = (Boolean) function.evaluateFunction(list);
			assertEquals(true, b);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			list.clear();
			list.add(5);
			list.add(b_ok);
			function.evaluateFunction(list);
		} catch (Exception e) {
			assertEquals("Illegal Type of arguments", e.getMessage());
		}

	}

}
