package it.unifi.facpl.lib.function.comparison.evaluator;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;

public class NumberComparisonEvaluator implements IComparisonEvaluator {

	private static NumberComparisonEvaluator instance; 
	
	private NumberComparisonEvaluator(){
		
	}
	
	public static NumberComparisonEvaluator getInstance(){
		if (instance == null){
			instance = new NumberComparisonEvaluator();
		}
		return instance;
	}

	@Override
	public boolean areEquals(Object o1, Object o2) throws Throwable{
		if (o1 instanceof Integer){
			return ((Integer)o1).equals(o2);
		}
		return ((Double)o1).equals(o2);
	}

	@Override
	public boolean areNotEquals(Object o1, Object o2) throws Throwable{
		if (o1 instanceof Integer){
			return !((Integer)o1).equals(o2);
		}
		return !((Double)o1).equals(o2);
	}

	@Override
	public boolean isLessThan(Object o1, Object o2) throws Throwable {
		if (o1 instanceof Integer){
			if (o2 instanceof Integer){
				return ((Integer)o1) < ((Integer) o2);
			}else {
				return ((Integer)o1) < ((Double) o2);
			}
		}
		if (o1 instanceof Double){
			if (o2 instanceof Integer){
				return ((Double)o1) < ((Integer) o2);
			}else {
				return ((Double)o1) < ((Double) o2);
			}
		}
		throw new UnsupportedTypeException(o1.getClass().getName(), "Less-Than");
	}

	@Override
	public boolean isLessThanOrEqual(Object o1, Object o2) throws Throwable {
		if (o1 instanceof Integer){
			if (o2 instanceof Integer){
				return ((Integer)o1) <= ((Integer) o2);
			}else {
				return ((Integer)o1) <= ((Double) o2);
			}
		}
		if (o1 instanceof Double){
			if (o2 instanceof Integer){
				return ((Double)o1) <= ((Integer) o2);
			}else {
				return ((Double)o1) <= ((Double) o2);
			}
		}
		throw new UnsupportedTypeException(o1.getClass().getName(), "Less-Than-Or-Equal");
	}

	@Override
	public boolean isGreaterThan(Object o1, Object o2) throws Throwable{
		if (o1 instanceof Integer){
			if (o2 instanceof Integer){
				return ((Integer)o1) > ((Integer) o2);
			}else {
				return ((Integer)o1) > ((Double) o2);
			}
		}
		if (o1 instanceof Double){
			if (o2 instanceof Integer){
				return ((Double)o1) > ((Integer) o2);
			}else {
				return ((Double)o1) > ((Double) o2);
			}
		}
		throw new UnsupportedTypeException(o1.getClass().getName(), "Greater-Than");
	}

	@Override
	public boolean isGreateThanOrEqual(Object o1, Object o2) throws Throwable{
		if (o1 instanceof Integer){
			if (o2 instanceof Integer){
				return ((Integer)o1) >= ((Integer) o2);
			}else {
				return ((Integer)o1) >= ((Double) o2);
			}
		}
		if (o1 instanceof Double){
			if (o2 instanceof Integer){
				return ((Double)o1) >= ((Integer) o2);
			}else {
				return ((Double)o1) >= ((Double) o2);
			}
		}
		throw new UnsupportedTypeException(o1.getClass().getName(), "Greater-Than-Or-Equal");
	}

	@Override
	public boolean isSubsetOf(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Numeric", "Subset-Of");
	}

	@Override
	public boolean isAtLestOneMemberOf(Object o1, Object o2) throws Throwable {
		throw new UnsupportedTypeException("Numeric", "At-Least-One-Member-Of");
	}
	

}
