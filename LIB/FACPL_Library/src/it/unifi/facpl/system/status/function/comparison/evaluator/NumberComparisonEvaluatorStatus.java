package it.unifi.facpl.system.status.function.comparison.evaluator;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluatorStatus;

public class NumberComparisonEvaluatorStatus implements IComparisonEvaluatorStatus {

	private static NumberComparisonEvaluatorStatus instance; 
	
	private NumberComparisonEvaluatorStatus(){
		
	}
	
	public static NumberComparisonEvaluatorStatus getInstance(){
		if (instance == null){
			instance = new NumberComparisonEvaluatorStatus();
		}
		return instance;
	}
	@Override
	public boolean areEquals(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean areNotEquals(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLessThan(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLessThanOrEqual(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreaterThan(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGreateThanOrEqual(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSubsetOf(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAtLestOneMemberOf(Object o1, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isListElement(List<?> list, Object o2) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}


}
