package it.unifi.facpl.lib.function.comparison;


import java.util.List;

import it.unifi.facpl.lib.function.comparison.evaluator.ComparisonEvaluatorFactory;
import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.interfaces.IComparisonFunction;

public class LessThanOrEqual extends AbstractComparison{


	@Override
	protected Boolean op(IComparisonEvaluator ev, Object o1, Object o2) throws Throwable {
		return ev.isLessThanOrEqual( o1 , o2 );
	}

}
