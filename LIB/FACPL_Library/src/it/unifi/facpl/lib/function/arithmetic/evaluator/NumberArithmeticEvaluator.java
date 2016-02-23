package it.unifi.facpl.lib.function.arithmetic.evaluator;

import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

/**
 * @author Andrea Margheri
 *
 */
public class NumberArithmeticEvaluator implements ArithmeticEvaluator {

	private static NumberArithmeticEvaluator instance;

	private NumberArithmeticEvaluator() {

	}

	public static NumberArithmeticEvaluator getInstance() {
		if (instance == null) {
			instance = new NumberArithmeticEvaluator();
		}
		return instance;
	}

	@Override
	public Number add(Object o1, Object o2) throws Throwable {
		if (o1 instanceof Integer) {
			if (o2 instanceof Integer)
				return (Integer) o1 + (Integer) o2;
			else
				return (Integer) o1 + (Double) o2;
		} else if (o1 instanceof Double) {
			if (o2 instanceof Integer)
				return (Double) o1 + (Integer) o2;
			else
				return (Double) o1 + (Double) o2;
		}
		throw new UnsupportedTypeException("Number", "Add");
	}

	@Override
	public Number divide(Object o1, Object o2) throws Throwable {
		if (o1 instanceof Integer) {
			if (o2 instanceof Integer)
				return (Integer) o1 / (Integer) o2;
			else
				return (Integer) o1 / (Double) o2;
		} else if (o1 instanceof Double) {
			if (o2 instanceof Integer)
				return (Double) o1 / (Integer) o2;
			else
				return (Double) o1 / (Double) o2;
		}
		throw new UnsupportedTypeException("Number", "Divide");
	}

	@Override
	public Number multiply(Object o1, Object o2) throws Throwable {
		if (o1 instanceof Integer) {
			if (o2 instanceof Integer)
				return (Integer) o1 * (Integer) o2;
			else
				return (Integer) o1 * (Double) o2;
		} else if (o1 instanceof Double) {
			if (o2 instanceof Integer)
				return (Double) o1 * (Integer) o2;
			else
				return (Double) o1 * (Double) o2;
		}
		throw new UnsupportedTypeException("Number", "Multiply");
	}

	@Override
	public Number subtract(Object o1, Object o2) throws Throwable {
		if (o1 instanceof Integer) {
			if (o2 instanceof Integer)
				return (Integer) o1 - (Integer) o2;
			else
				return (Integer) o1 - (Double) o2;
		} else if (o1 instanceof Double) {
			if (o2 instanceof Integer)
				return (Double) o1 - (Integer) o2;
			else
				return (Double) o1 - (Double) o2;
		}
		throw new UnsupportedTypeException("Number", "Subtract");
	}

	@Override
	public Number abs(Object o1) throws Throwable {
		if (o1 instanceof Integer)
			return Math.abs((Integer) o1);
		if (o1 instanceof Double)
			return Math.abs((Double) o1);
		throw new UnsupportedTypeException("Number", "Mod");
	}

	/**
	 * Defined only for Integer values
	 */

	@Override
	public Number mod(Object o1, Object o2) throws Throwable {
		if (o1 instanceof Integer && o2 instanceof Integer)
			return (Integer) o1 % (Integer) o2;
		throw new UnsupportedTypeException("Number", "Mod");
	}

}
