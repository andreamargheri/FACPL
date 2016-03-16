package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public class StringEvaluator implements StringEvaluatorStatus {

	private static StringEvaluator instance;

	private StringEvaluator() {

	}

	public static StringEvaluator getInstance() {
		if (instance == null) {
			instance = new StringEvaluator();
		}
		return instance;
	}

	@Override
	public void setValue(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.STRING) {

			status.setAttribute(o1, o2.toString());
		}

	}

	@Override
	public void sumString(FacplStatus status, StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.STRING) {

			status.setAttribute(o1, (String)status.retrieveAttribute(o1) + o2.toString());
		}

	}

}
