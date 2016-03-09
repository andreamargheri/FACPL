package it.unifi.facpl.system.status.function.arithmetic.evaluator;

import it.unifi.facpl.lib.enums.FacplStatusType;
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
	public void setValue(StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.STRING) {
			o1.setValue(o2.toString());
		}

	}

	@Override
	public void sumString(StatusAttribute o1, Object o2) throws Throwable {
		if (o1.getType() == FacplStatusType.STRING) {
			o1.setValue(o1.getValue().toString()+o2.toString());
		}
		
	}

}
