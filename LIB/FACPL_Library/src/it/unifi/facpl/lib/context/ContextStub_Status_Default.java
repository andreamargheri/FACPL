package it.unifi.facpl.lib.context;

import java.util.Date;

import it.unifi.facpl.lib.interfaces.IContextStub_Status;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.StatusAttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.FacplStatus;

@SuppressWarnings("all")
public class ContextStub_Status_Default implements IContextStub_Status{
	
	private static ContextStub_Status_Default instance; 

	private static FacplStatus status; 
	
	public static ContextStub_Status_Default getInstance(){
		if (instance == null){
			instance = new ContextStub_Status_Default();
		}
	return instance;
	}

	private ContextStub_Status_Default(){
	
	}

	
	public static void setStatus(FacplStatus status) {
		ContextStub_Status_Default.status = status;
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
	public Object getContextStatusValues(StatusAttributeName attribute) throws MissingAttributeException {
		
		/*
		 *  TODO Auto-generated method stub
		 */
		
		return status.getValue(attribute);
	}
	
}

