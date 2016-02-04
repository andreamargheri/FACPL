package it.unifi.facpl.lib.interfaces;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.AbstractFulfilledObligation;

/**
 * Evaluation method for obligation
 * @author Andrea Margheri
 *
 */
public interface IObligationElement {

	AbstractFulfilledObligation getObligationValue(ContextRequest cxtRequest) throws Throwable;

}
