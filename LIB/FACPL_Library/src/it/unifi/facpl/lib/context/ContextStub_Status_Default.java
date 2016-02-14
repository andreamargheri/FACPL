package it.unifi.facpl.lib.context;

import java.util.Date;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

@SuppressWarnings("all")
public class ContextStub_Status_Default implements IContextStub {
	/*
	 * TODO: rendere lo stato unico ed non modificabile
	 */
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

	public Object getContextValues(Object attr) throws MissingAttributeException {
		if (attr instanceof AttributeName) {
			AttributeName attribute = (AttributeName) attr;
			// Context Time Value
			if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("time")) {
				return new Date();
			}
			if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("date")) {
				return new Date();
			}
			// True and False constant
			if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("true")) {
				return true;
			}
			if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("false")) {
				return false;
			}
		} else if (attr instanceof StatusAttribute) {
			return status.getValue((StatusAttribute) attr);
		}
		return null;

	}

}
