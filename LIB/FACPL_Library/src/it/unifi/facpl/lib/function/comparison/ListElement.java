/**
 * 
 */
package it.unifi.facpl.lib.function.comparison;

import java.util.List;

import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;

/**
 * @author Andrea
 *
 */
public class ListElement extends AbstractComparison {

	@Override
	protected Boolean op(IComparisonEvaluator ev, Object o1, Object o2) throws Throwable {
		return ev.isListElement( (List<?>) o1 , o2 );
	}
}
