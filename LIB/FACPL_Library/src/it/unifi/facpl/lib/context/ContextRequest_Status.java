package it.unifi.facpl.lib.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.interfaces.IContextStub_Status;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.StatusAttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class ContextRequest_Status {

	private IContextStub_Status context;
	private Request request;

	public ContextRequest_Status(Request req) {
		this.request = req;
		this.context = null;
	}

	public ContextRequest_Status(Request req, IContextStub_Status context) {
		this.request = req;
		this.context = context;
	}

	public Request getRequest() {
		return request;
	}

	public IContextStub getContext() {
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
	
	public Object getContextRequestValues(AttributeName struct_name) throws MissingAttributeException {
		Logger l = LoggerFactory.getLogger(ContextRequest_Status.class);
		//First we check in the request
		try{
			return this.request.getRequestValues(struct_name);
		}catch(MissingAttributeException e){
			//Request not defined on the names passed as argument
			//-> Check in the context
			if (context != null){
				Object values =  this.context.getContextValues(struct_name);
				if (values == null){
					//throw Exception Missing Attribute if undefined again
					l.debug("Throw MissingAttributeExcepion for " + struct_name.toString());
					throw new MissingAttributeException();
				}else{
					return values;
				}
			}else{
				//throw Exception Missing Attribute due to absence of context
				l.debug("Throw MissingAttributeExcepion for " + struct_name.toString());
				throw new MissingAttributeException();
			}
		}
	}
}
