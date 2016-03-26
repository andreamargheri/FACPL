package it.unifi.facpl.lib.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public class ContextRequest_Status extends ContextRequest {

	private FacplStatus status;

	public ContextRequest_Status(Request req) {
		super(req);
	}

	public ContextRequest_Status(Request req, IContextStub context) {
		super(req, context);
	}

	public ContextRequest_Status(Request req, IContextStub context, FacplStatus status) {
		super(req, context);
		this.status = status;
	}

	public FacplStatus getStatus() {
		return status;
	}

	public void setStatus(FacplStatus status) {
		this.status = status;
	}

	@Override
	public Object getContextRequestValues(AttributeName name) throws MissingAttributeException {
		Logger l = LoggerFactory.getLogger(ContextRequest_Status.class);

		if (name instanceof StatusAttribute) {
			if (status != null) {
				try {
					return this.status.retrieveAttribute((StatusAttribute) name);
				} catch (MissingAttributeException e) {
					l.debug("Throw MissingAttributeExcepion for " + name.toString() + "Status is missing");
					throw new MissingAttributeException();
				}
			} else {
				l.debug("Throw MissingAttributeExcepion for " + name.toString() + "Status is missing");
				throw new MissingAttributeException();
			}
		} else {
			return super.getContextRequestValues(name);
		}
	}
}
