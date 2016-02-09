package it.unifi.facpl.lib.context;

import java.util.Date;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.StatusAttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.FacplStatus;

@SuppressWarnings("all")
public class ContextStub_Default implements IContextStub{
	
	private static ContextStub_Default instance; 

	public static ContextStub_Default getInstance(){
		if (instance == null){
			instance = new ContextStub_Default();
		}
	return instance;
	}

	private ContextStub_Default(){
	
	}

	@Override
	public Object getContextValues(AttributeName attribute) {
		//Context Time Value
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("time")){
			return new Date();
		}
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("date")){
			return new Date();
		}
		//True and False constant
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("true")){
			return true;
		}
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("false")){
			return false;
		}
		
		//TO Implement your own context here. For example
		/*
		*if (attribute.getCategory().equals("foo") && attribute.getIDAttribute().equals("id")){
		*	return "foo";
		*}else{
		*	return null;
		*}
		*/
		return null;
	}

	@Override
	public Object getContextStatusValues(FacplStatus status, StatusAttributeName attribute) throws MissingAttributeException {
		
		//TODO
		
		return null;
	}
	
}

