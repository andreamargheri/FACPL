package it.unifi.facpl.lib.function.comparison;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;

public class NotEqual extends AbstractComparison {

	@Override
	protected Boolean op(IComparisonEvaluator ev, Object o1, Object o2) throws Throwable {
		return ev.areNotEquals(o1, o2);
	}


}
