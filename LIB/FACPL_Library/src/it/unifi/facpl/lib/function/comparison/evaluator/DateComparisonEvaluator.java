package it.unifi.facpl.lib.function.comparison.evaluator;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

/**
 * @author Andrea Margheri
 *
 */
public class DateComparisonEvaluator implements IComparisonEvaluator {

	private static DateComparisonEvaluator instance;

	private DateComparisonEvaluator() {

	}

	public static DateComparisonEvaluator getInstance() {
		if (instance == null) {
			instance = new DateComparisonEvaluator();
		}
		return instance;
	}

	@Override
	public boolean areEquals(Object o1, Object o2) throws Throwable {
		if (o2 instanceof FacplDate) {
			return ((FacplDate) o1).equals((FacplDate) o2);
		} else if (o2 instanceof String) {
			return ((FacplDate) o1).equals(Util.parseDate((String) o2));
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "Equal");
	}

	@Override
	public boolean areNotEquals(Object o1, Object o2) throws Throwable {
		if (o2 instanceof FacplDate) {
			return !(((FacplDate) o1).equals((FacplDate) o2));
		} else if (o2 instanceof String) {
			return !(((FacplDate) o1).equals(Util.parseDate((String) o2)));
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "Equal");
	}

	@Override
	public boolean isLessThan(Object o1, Object o2) throws Throwable {
		if (o2 instanceof FacplDate) {
			return ((FacplDate) o1).before((FacplDate) o2);
		} else if (o2 instanceof String) {
			return ((FacplDate) o1).before(Util.parseDate((String) o2));
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "Less-Than");
	}

	@Override
	public boolean isLessThanOrEqual(Object o1, Object o2) throws Throwable {
		if (o2 instanceof FacplDate) {
			return ((FacplDate) o1).before((FacplDate) o2) || ((FacplDate) o1).equals((FacplDate) o2);
		} else if (o2 instanceof String) {
			return ((FacplDate) o1).before(Util.parseDate((String) o2))
					|| ((FacplDate) o1).equals(Util.parseDate((String) o2));
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "Less-Than-Or-Equal");
	}

	@Override
	public boolean isGreaterThan(Object o1, Object o2) throws Throwable {
		if (o2 instanceof FacplDate) {
			return ((FacplDate) o1).after((FacplDate) o2);
		} else if (o2 instanceof String) {
			return ((FacplDate) o1).after(Util.parseDate((String) o2));
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "Greater-Than");
	}

	@Override
	public boolean isGreateThanOrEqual(Object o1, Object o2) throws Throwable {
		if (o2 instanceof FacplDate) {
			return ((FacplDate) o1).after((FacplDate) o2) || ((FacplDate) o1).equals((FacplDate) o2);
		} else if (o2 instanceof String) {
			return ((FacplDate) o1).after(Util.parseDate((String) o2))
					|| ((FacplDate) o1).equals(Util.parseDate((String) o2));
		}
		throw new UnsupportedTypeException(o2.getClass().getName(), "Greater-Than-Or-Equal");
	}

	@Override
	public boolean isSubsetOf(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Date", "Subset-Of");
	}

	@Override
	public boolean isAtLestOneMemberOf(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Date", "At-Least-One-Member-Of");
	}

	@Override
	public boolean isListElement(List<?> list, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Date", "Is-List-Element");

	}

}
