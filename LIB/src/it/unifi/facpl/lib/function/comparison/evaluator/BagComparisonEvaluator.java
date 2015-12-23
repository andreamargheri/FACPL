package it.unifi.facpl.lib.function.comparison.evaluator;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.util.Bag;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

/**
 * @author Andrea Margheri
 * 
 */
public class BagComparisonEvaluator implements IComparisonEvaluator {

	private static BagComparisonEvaluator instance;

	private BagComparisonEvaluator() {

	}

	public static BagComparisonEvaluator getInstance() {
		if (instance == null) {
			instance = new BagComparisonEvaluator();
		}
		return instance;
	}

	@Override
	public boolean areEquals(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Equal");
	}

	@Override
	public boolean areNotEquals(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Not-Equal");
	}

	@Override
	public boolean isLessThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Less-Than");
	}

	@Override
	public boolean isLessThanOrEqual(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Less-Than-Or-Equal");
	}

	@Override
	public boolean isGreaterThan(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Greater-Than");
	}

	@Override
	public boolean isGreateThanOrEqual(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Bag", "Greater-Than-Or-Equal");
	}

	@Override
	public boolean isSubsetOf(Object o1, Object o2) throws Throwable {
		if (o2 instanceof Bag) {
			return ((Bag) o2).contains((Bag) o1);
		} else if (((Bag) o1).getBag_values().size() == 1) {
			// o2 of a different type, e.g. a literal, thus if the bag is formed
			// by only one value they are compared each other
			return ((Bag) o1).contains(o2);
		} else {
			throw new UnsupportedTypeException("Bag (with multiple items) vs"
					+ o2.getClass().getName(), "Subset");
		}
	}

	@Override
	public boolean isAtLestOneMemberOf(Object o1, Object o2) throws Throwable {
		if (((Bag)o1).isEmpty()){
			return false;
		}
		if (o2 instanceof Bag) {
			Boolean flag = false;
			for (Object obj : ((Bag) o1).getBag_values()) {
				if (((Bag) o2).contains(obj)) {
					flag = true;
					break;
				}
			}
			return flag;
		} else {
			// o2 of a different type, e.g. a literal, thus if the bag is formed
			// by only one value they are compared each other
			Boolean flag = false;
			for (Object obj : ((Bag) o1).getBag_values()) {
				if (o2.equals(obj)) {
					flag = true;
					break;
				}
			}
			return flag;
		}
	}

}
