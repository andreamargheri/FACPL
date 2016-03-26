package it.unifi.facpl.lib.context;

import java.util.Calendar;
import java.util.Date;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;

public class AbstractContextStub implements IContextStub {

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
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("calendar")) {
			return Calendar.getInstance();
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
