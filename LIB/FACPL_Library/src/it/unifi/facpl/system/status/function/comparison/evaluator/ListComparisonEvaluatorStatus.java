package it.unifi.facpl.system.status.function.comparison.evaluator;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluatorStatus;

public class ListComparisonEvaluatorStatus implements IComparisonEvaluatorStatus {
	
	private static ListComparisonEvaluatorStatus instance; 
	
	private ListComparisonEvaluatorStatus(){
		
	}
	
	public static ListComparisonEvaluatorStatus getInstance(){
		if (instance == null){
			instance = new ListComparisonEvaluatorStatus();
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
