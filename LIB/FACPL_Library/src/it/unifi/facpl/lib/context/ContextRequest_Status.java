package it.unifi.facpl.lib.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.StatusAttribute;

public class ContextRequest_Status extends ContextRequest {

	
	public ContextRequest_Status(Request req) {
		super(req);
	}

	public ContextRequest_Status(Request req, IContextStub context) {
		super(req, context);
	}

	public IContextStub getContext() {
		return context;
	}
	
	public StatusAttribute getStatusAttribute(StatusAttribute attribute) throws MissingAttributeException {
		return ((ContextStub_Status_Default)context).getStatusAttribute(attribute);
	}
 
	public Object getContextRequestValues (StatusAttribute name) throws MissingAttributeException {
		Logger l = LoggerFactory.getLogger(ContextRequest_Status.class);
		if (context != null){
			
			/*
			 * SI PASSA LO STATO COME RIFERIMENTO -> CAMBIARE ?
			 */
			Object values =  this.context.getContextValues(name);
			
			
			if (values == null){
				l.debug("Throw MissingAttributeExcepion for " + name.toString());
				throw new MissingAttributeException();
			}else{
				return values;
			}
		}else{
			l.debug("Throw MissingAttributeExcepion for " + name.toString());
			throw new MissingAttributeException();
		}
	}
}
