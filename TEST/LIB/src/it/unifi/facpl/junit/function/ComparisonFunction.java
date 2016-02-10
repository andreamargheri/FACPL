package it.unifi.facpl.junit.function;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unifi.facpl.lib.function.comparison.Equal;
import it.unifi.facpl.lib.function.comparison.GreaterThan;
import it.unifi.facpl.lib.function.comparison.GreaterThanOrEqual;
import it.unifi.facpl.lib.function.comparison.LessThan;
import it.unifi.facpl.lib.function.comparison.LessThanOrEqual;
import it.unifi.facpl.lib.function.comparison.NotEqual;
import it.unifi.facpl.lib.interfaces.IExpressionFunction;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

public class ComparisonFunction {

	private IExpressionFunction function;
	private List integers_Eq, integers_Diff, integers_Times, integers_One;
	private List doubles_Eq, doubles_Diff, doubles_Times, doubles_One;
	private List boolean_Eq, boolean_Diff, boolean_Times, boolean_One, boolean_False;
	private List string_Eq, string_Diff, string_Times, string_One;
	private List date_Eq, date_Diff, date_Times, date_One;

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
		boolean_False = new LinkedList<Boolean>();
		boolean_False.add(false);
		boolean_False.add(false);

		// String
		string_Eq = new LinkedList<String>();
		string_Eq.add("time1");
		string_Eq.add("time1");
		string_Diff = new LinkedList<String>();
		string_Diff.add("time1");
		string_Diff.add("time2");
		string_Times = new LinkedList<String>();
		string_Times.add("time1");
		string_Times.add("time2");
		string_Times.add("time3");
		string_One = new LinkedList<String>();
		string_One.add("time1");

		try {
			// Date
			date_Eq = new LinkedList<FacplDate>();
			date_Eq.add(new FacplDate("2014/12/13"));
			date_Eq.add(new FacplDate("2014/12/13"));
			date_Diff = new LinkedList<Date>();
			date_Diff.add(new FacplDate("2014/12/13"));
			date_Diff.add(new FacplDate("2013/01/10"));
			date_Times = new LinkedList<Date>();
			date_Times.add(new FacplDate("2014/12/13"));
			date_Times.add(new FacplDate("2013/01/10"));
			date_Times.add(new FacplDate("2013/01/10"));
			date_One = new LinkedList<Date>();
			date_One.add(new FacplDate("02:00:00"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testEqual_Function_Int() throws Throwable {
		function = new Equal();
		Boolean b = (Boolean) function.evaluateFunction(integers_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(integers_Diff);
		assertEquals(false, b);
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
	public void testEqual_Function_Double() throws Throwable {
		function = new Equal();
		Boolean b = (Boolean) function.evaluateFunction(doubles_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(doubles_Diff);
		assertEquals(false, b);
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
	public void testEqual_Function_Bool() throws Throwable {
		function = new Equal();
		Boolean b = (Boolean) function.evaluateFunction(boolean_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(boolean_Diff);
		assertEquals(false, b);
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

	@SuppressWarnings("unchecked")
	@Test
	public void testEqual_Function_String() throws Throwable {
		function = new Equal();
		Boolean b = (Boolean) function.evaluateFunction(string_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(string_Diff);
		assertEquals(false, b);
		try {
			function.evaluateFunction(string_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(string_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testEqual_Function_Date() throws Throwable {
		function = new Equal();
		Boolean b = (Boolean) function.evaluateFunction(date_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(date_Diff);
		assertEquals(false, b);
		try {
			function.evaluateFunction(date_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(date_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// Not-Equal

	@SuppressWarnings("unchecked")
	@Test
	public void testNot_Equal_Function_Double() throws Throwable {
		function = new NotEqual();
		Boolean b = (Boolean) function.evaluateFunction(doubles_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(doubles_Diff);
		assertEquals(true, b);
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
	public void testNot_Equal_Function_Int() throws Throwable {
		function = new NotEqual();
		Boolean b = (Boolean) function.evaluateFunction(integers_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(integers_Diff);
		assertEquals(true, b);
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
	public void testNot_Equal_Function_Bool() throws Throwable {
		function = new NotEqual();
		Boolean b = (Boolean) function.evaluateFunction(boolean_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(boolean_Diff);
		assertEquals(true, b);
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

	@SuppressWarnings("unchecked")
	@Test
	public void testNot_Equal_Function_String() throws Throwable {
		function = new NotEqual();
		Boolean b = (Boolean) function.evaluateFunction(string_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(string_Diff);
		assertEquals(true, b);
		try {
			function.evaluateFunction(string_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(string_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testNot_Equal_Function_Date() throws Throwable {
		function = new NotEqual();
		Boolean b = (Boolean) function.evaluateFunction(date_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(date_Diff);
		assertEquals(true, b);
		try {
			function.evaluateFunction(date_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(date_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// GreaterThan.java

	@SuppressWarnings("unchecked")
	@Test
	public void testGreater_Function_Bool() throws Throwable {
		function = new GreaterThan();
		Boolean b;
		try {
			b = (Boolean) function.evaluateFunction(boolean_Eq);
			assertEquals(false, b);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
		}
		try {
			b = (Boolean) function.evaluateFunction(boolean_Diff);
			assertEquals(true, b);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
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

	@SuppressWarnings("unchecked")
	@Test
	public void testGreater_Function_Double() throws Throwable {
		function = new GreaterThan();
		Boolean b = (Boolean) function.evaluateFunction(doubles_Eq);
		// [4.4,4.4]
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(doubles_Diff);
		// [4.2,5.2]
		assertEquals(false, b);
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
	public void testGreater_Function_Int() throws Throwable {
		function = new GreaterThan();
		Boolean b = (Boolean) function.evaluateFunction(integers_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(integers_Diff);
		// [4,5]
		assertEquals(false, b);
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
	public void testGreater_Function_Date() throws Throwable {
		function = new GreaterThan();
		Boolean b = (Boolean) function.evaluateFunction(date_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(date_Diff);
		// [2014/12/13,2013/01/10]
		assertEquals(true, b);
		try {
			function.evaluateFunction(date_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(date_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// GreaterThanOrEqual.java

	@SuppressWarnings("unchecked")
	@Test
	public void testGreaterEqual_Function_Bool() throws Throwable {
		function = new GreaterThanOrEqual();
		Boolean b;
		try {
			b = (Boolean) function.evaluateFunction(boolean_Eq);
			assertEquals(false, b);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
		}
		try {
			b = (Boolean) function.evaluateFunction(boolean_Diff);
			assertEquals(true, b);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
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

	@SuppressWarnings("unchecked")
	@Test
	public void testGreaterEqual_Function_Double() throws Throwable {
		function = new GreaterThanOrEqual();
		Boolean b = (Boolean) function.evaluateFunction(doubles_Eq);
		// [4.4,4.4]
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(doubles_Diff);
		// [4.2,5.2]
		assertEquals(false, b);
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
	public void testGreaterEqual_Function_Int() throws Throwable {
		function = new GreaterThanOrEqual();
		Boolean b = (Boolean) function.evaluateFunction(integers_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(integers_Diff);
		// [4,5]
		assertEquals(false, b);
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
	public void testGreaterEqual_Function_Date() throws Throwable {
		function = new GreaterThanOrEqual();
		Boolean b = (Boolean) function.evaluateFunction(date_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(date_Diff);
		assertEquals(true, b);
		try {
			function.evaluateFunction(date_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(date_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// LessThan.java

	@SuppressWarnings("unchecked")
	@Test
	public void testLess_Function_Bool() throws Throwable {
		function = new LessThan();
		Boolean b;
		try {
			b = (Boolean) function.evaluateFunction(boolean_Eq);
			assertEquals(false, b);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
		}
		try {
			b = (Boolean) function.evaluateFunction(boolean_Diff);
			assertEquals(true, b);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
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

	@SuppressWarnings("unchecked")
	@Test
	public void testLess_Function_Double() throws Throwable {
		function = new LessThan();
		Boolean b = (Boolean) function.evaluateFunction(doubles_Eq);
		// [4.4,4.4]
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(doubles_Diff);
		// [4.2,5.2]
		assertEquals(true, b);
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
	public void testLess_Function_Int() throws Throwable {
		function = new LessThan();
		Boolean b = (Boolean) function.evaluateFunction(integers_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(integers_Diff);
		// [4,5]
		assertEquals(true, b);
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
	public void testLess_Function_Date() throws Throwable {
		function = new LessThan();
		Boolean b = (Boolean) function.evaluateFunction(date_Eq);
		assertEquals(false, b);
		b = (Boolean) function.evaluateFunction(date_Diff);
		assertEquals(false, b);
		try {
			function.evaluateFunction(date_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(date_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

	// LessThanOrEqual.java

	@SuppressWarnings("unchecked")
	@Test
	public void testLessEqual_Function_Bool() throws Throwable {
		function = new LessThanOrEqual();
		Boolean b;
		try {
			b = (Boolean) function.evaluateFunction(boolean_Eq);
			assertEquals(false, b);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
		}
		try {
			b = (Boolean) function.evaluateFunction(boolean_Diff);
			assertEquals(true, b);
		} catch (Exception e) {
			assertEquals(UnsupportedTypeException.class, e.getClass());
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

	@SuppressWarnings("unchecked")
	@Test
	public void testLessEqual_Function_Double() throws Throwable {
		function = new LessThanOrEqual();
		Boolean b = (Boolean) function.evaluateFunction(doubles_Eq);
		// [4.4,4.4]
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(doubles_Diff);
		// [4.2,5.2]
		assertEquals(true, b);
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
	public void testLessEqual_Function_Int() throws Throwable {
		function = new LessThanOrEqual();
		Boolean b = (Boolean) function.evaluateFunction(integers_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(integers_Diff);
		// [4,5]
		assertEquals(true, b);
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
	public void testLessEqual_Function_Date() throws Throwable {
		function = new LessThanOrEqual();
		Boolean b = (Boolean) function.evaluateFunction(date_Eq);
		assertEquals(true, b);
		b = (Boolean) function.evaluateFunction(date_Diff);
		assertEquals(false, b);
		try {
			function.evaluateFunction(date_Times);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
		try {
			function.evaluateFunction(date_One);
		} catch (Exception e) {
			assertEquals("Illegal number of arguments", e.getMessage());
		}
	}

}
