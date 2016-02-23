package it.unifi.facpl.lib.context;

import java.util.Date;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;

@SuppressWarnings("all")
public class ContextStub_Default implements IContextStub {

	private static ContextStub_Default instance;

	public static ContextStub_Default getInstance() {
		if (instance == null) {
			instance = new ContextStub_Default();
		}
		return instance;
	}

	private ContextStub_Default() {

	}

	@Override
	public Object getContextValues(Object attr) {
		AttributeName attribute = null;
		if (attr instanceof AttributeName) {
			attribute = (AttributeName) attr;
		}
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
		return null;
	}

}
