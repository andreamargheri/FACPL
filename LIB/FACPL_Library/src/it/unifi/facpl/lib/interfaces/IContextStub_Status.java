package it.unifi.facpl.lib.interfaces;

import it.unifi.facpl.lib.util.StatusAttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

/**
 * 
 * @author Andrea Margheri
 *
 */
public interface IContextStub_Status extends IContextStub{
	
	Object getContextStatusValues(StatusAttributeName attribute) throws MissingAttributeException;
	
}
