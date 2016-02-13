package it.unifi.facpl.lib.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.interfaces.IContextStub_Status;
import it.unifi.facpl.lib.util.StatusAttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class ContextRequest_Status extends ContextRequest {

	private IContextStub_Status context;
	
	public ContextRequest_Status(Request req) {
		super(req);
		this.context = null;
	}

	public ContextRequest_Status(Request req, IContextStub_Status context) {
		super(req);
		this.context = context;
	}

	public IContextStub_Status getContext() {
		return context;
	}

	public Object getContextRequestValues (StatusAttributeName name) throws MissingAttributeException {
		Logger l = LoggerFactory.getLogger(ContextRequest_Status.class);
		if (context != null){
			
			/*
			 * SI PASSA LO STATO COME RIFERIMENTO -> CAMBIARE ?
			 */
			Object values =  this.context.getContextStatusValues(name);
			
			
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
