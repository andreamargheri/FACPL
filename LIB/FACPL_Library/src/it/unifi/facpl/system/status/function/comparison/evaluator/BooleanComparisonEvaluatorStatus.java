package it.unifi.facpl.system.status.function.comparison.evaluator;

import java.util.List;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.function.comparison.evaluator.BooleanComparisonEvaluator;
import it.unifi.facpl.lib.interfaces.IComparisonEvaluatorStatus;
import it.unifi.facpl.lib.util.exception.UnsupportedTypeException;
import it.unifi.facpl.system.status.StatusAttribute;

public class BooleanComparisonEvaluatorStatus implements IComparisonEvaluatorStatus {

	private static BooleanComparisonEvaluatorStatus instance; 
	
	private BooleanComparisonEvaluatorStatus(){
		
	}
	
	public static BooleanComparisonEvaluatorStatus getInstance(){
		if (instance == null){
			instance = new BooleanComparisonEvaluatorStatus();
		}
		return instance;
	}

	@Override
	public boolean areEquals(StatusAttribute s1, Object o1, StatusAttribute s2, Object o2) throws Throwable {
		if (s1.getType() == FacplStatusType.BOOLEAN && s2.getType() == FacplStatusType.BOOLEAN) {
			Boolean b1 = Boolean.getBoolean(s1.getValue());
			Boolean b2 = Boolean.getBoolean(s1.getValue());
			if (b1 == b2) {
				return true;
			}
		}
		else {
			throw new UnsupportedTypeException("bool", "equals");
		}
		return false;
	}

	@Override
	public boolean areNotEquals(StatusAttribute s1, Object o1, StatusAttribute s2, Object o2) throws Throwable {
		if (s1.getType() == FacplStatusType.BOOLEAN && s2.getType() == FacplStatusType.BOOLEAN) {
			Boolean b1 = Boolean.getBoolean(s1.getValue());
			Boolean b2 = Boolean.getBoolean(s1.getValue());
			if (b1 == b2) {
				return !true;
			}
		}
		else {
			throw new UnsupportedTypeException("bool", "not-equals");
		}
		return !false;
	}

	@Override
	public boolean isLessThan(StatusAttribute s1, Object o1, StatusAttribute s2, Object o2) throws Throwable {
		throw new UnsupportedTypeException("bool", "is-less-than");
	}

	@Override
	public boolean isLessThanOrEqual(StatusAttribute s1, Object o1, StatusAttribute s2, Object o2) throws Throwable {
		throw new UnsupportedTypeException("bool", "is-less-than-equal");

	}

	@Override
	public boolean isGreaterThan(StatusAttribute s1, Object o1, StatusAttribute s2, Object o2) throws Throwable {
		throw new UnsupportedTypeException("bool", "is-greater-than");
	}

	@Override
	public boolean isGreateThanOrEqual(StatusAttribute s1, Object o1, StatusAttribute s2, Object o2) throws Throwable {
		throw new UnsupportedTypeException("bool", "is-greater-than-equal");
	}

	@Override
	public boolean isSubsetOf(StatusAttribute s1, Object o1, StatusAttribute s2, Object o2) throws Throwable {
		throw new UnsupportedTypeException("bool", "subset-of");
	}

	@Override
	public boolean isAtLestOneMemberOf(StatusAttribute s1, Object o1, StatusAttribute s2, Object o2) throws Throwable {
		throw new UnsupportedTypeException("bool", "member-of");
	}

	@Override
	public boolean isListElement(List<?> list, Object o2) throws Throwable {
		throw new UnsupportedTypeException("bool", "is-list-elements");
	}
	

}
