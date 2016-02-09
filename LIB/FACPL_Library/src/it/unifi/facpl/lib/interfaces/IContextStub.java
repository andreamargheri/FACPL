package it.unifi.facpl.lib.interfaces;

import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.StatusAttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

/**
 * 
 * @author Andrea Margheri
 *
 */
public interface IContextStub {
	
	Object getContextValues(AttributeName attribute) throws MissingAttributeException;
	
	Object getContextStatusValues(StatusAttributeName attribute) throws MissingAttributeException;
	
}
