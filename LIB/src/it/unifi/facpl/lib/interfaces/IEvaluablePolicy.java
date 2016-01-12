/**
 * 
 */
package it.unifi.facpl.lib.interfaces;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.TargetDecision;

/**
 * Evaluation Methods for FACPL policies
 * @author Andrea Margheri 
 * 
 */
public interface IEvaluablePolicy{
	/**
	 * Authorisation Decision
	 * @return
	 */
	AuthorisationPDP evaluate(ContextRequest cxtRequest, Boolean extendedIndeterminate);
	
	/**
	 * Get Target Result
	 */
	TargetDecision getTargetDecision(ContextRequest cxtRequest);
	
	
	
}
