package it.unifi.facpl.lib.interfaces;

import java.util.List;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;

/**
 * Combining Algorithm
 * @author Andrea Margheri
 *
 */
public interface IEvaluableAlgorithm {

	AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate);
}
