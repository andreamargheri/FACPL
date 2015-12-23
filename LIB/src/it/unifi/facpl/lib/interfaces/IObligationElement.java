package it.unifi.facpl.lib.interfaces;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligation;


public interface IObligationElement {

	FulfilledObligation getObligationValue(ContextRequest cxtRequest) throws Throwable;
	
}
