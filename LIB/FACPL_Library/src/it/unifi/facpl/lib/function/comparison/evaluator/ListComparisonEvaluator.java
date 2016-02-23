package it.unifi.facpl.lib.function.comparison.evaluator;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

public class ListComparisonEvaluator implements IComparisonEvaluator {

	private static ListComparisonEvaluator instance;

	private ListComparisonEvaluator() {

	}

	public static ListComparisonEvaluator getInstance() {
		if (instance == null) {
			instance = new ListComparisonEvaluator();
		}
		return instance;
	}

	@Override
	public boolean areEquals(Object o1, Object o2) throws Throwable {
		if (o1 instanceof List<?>) {
			return o1.equals(o2);
		}
		return false;
	}

	@Override
	public boolean areNotEquals(Object o1, Object o2) throws Throwable {
		if (o1 instanceof List<?>) {
			return !(o1.equals(o2));
		}
		return !false;
	}

	@Override
	public boolean isLessThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("List", "Is-Less-Than");

	}

	@Override
	public boolean isLessThanOrEqual(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("list", "Is-Less-Than-Or-Equal");

	}

	@Override
	public boolean isGreaterThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("list", "Is-greater-than");

	}

	@Override
	public boolean isGreateThanOrEqual(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("list", "Is-greater-than-or-equal");

	}

	@Override
	public boolean isSubsetOf(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("list", "Is-subset-of");
	}

	@Override
	public boolean isAtLestOneMemberOf(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("list", "Is-at-least-one-member-of");
	}

	@Override
	public boolean isListElement(List<?> list, Object o2) throws Throwable {
		boolean dummy = false;
		for (Object o : list) {
			dummy = o.equals(o2);
			if (dummy) {
				return dummy;
			}
		}
		return false;

	}

}
