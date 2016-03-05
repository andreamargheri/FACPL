package it.unifi.facpl.lib.context;

import java.util.Date;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

@SuppressWarnings("all")
public class ContextStub_Status_Default extends AbstractContextStub {

	private static ContextStub_Status_Default instance;

	private static FacplStatus status;

	public static ContextStub_Status_Default getInstance() {
		if (instance == null) {
			instance = new ContextStub_Status_Default();
		}
		return instance;
	}

	private ContextStub_Status_Default() {

	}

	public static void setStatus(FacplStatus status) {
		ContextStub_Status_Default.status = status;
	}

	public StatusAttribute getStatusAttribute(StatusAttribute attribute) throws MissingAttributeException {
		return status.retrieveAttribute(attribute);
	}

	public Object getContextValues(Object attr) {
		/*
		 * return environment attribute or status attribute
		 */
		try {
			return status.getValue((StatusAttribute) attr);
		} catch (MissingAttributeException e) {
			return super.getContextValues(attr);
		}

	}

}
