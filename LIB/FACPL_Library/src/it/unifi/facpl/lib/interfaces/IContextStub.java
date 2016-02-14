package it.unifi.facpl.lib.interfaces;

import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

/**
 * 
 * @author Andrea Margheri
 *
 */
public interface IContextStub {
	
	Object getContextValues(Object attribute) throws MissingAttributeException;
	
}
