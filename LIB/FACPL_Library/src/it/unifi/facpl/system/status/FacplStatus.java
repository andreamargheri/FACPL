package it.unifi.facpl.system.status;

import java.util.HashMap;
import java.util.UUID;

import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class FacplStatus {

	
	private String statusID;
	
	private HashMap<StatusAttribute,Object> status;

	/**
	 * @param id
	 */

	public FacplStatus(String statusID) {
		this.status = new HashMap<StatusAttribute,Object>();
		this.statusID = statusID;
	}

	/**
	 * @param attributeList
	 * @param id
	 */
	public FacplStatus(HashMap<StatusAttribute,Object> attributeList, String statusID) {
		this.status = attributeList;
		this.statusID = statusID;
	}

	public FacplStatus() {
		this.status = new HashMap<StatusAttribute,Object>();
		this.statusID = UUID.randomUUID().toString().substring(0, 8);
	}

	public String getStatusID() {
		return this.statusID;
	}

	public void add(StatusAttribute a,String v) {
		this.status.put(a,v);
	}

	/**
	 * To use to retrieve the value of a Status Attribute
	 * 
	 * @param attribute
	 */
	public Object retrieveAttribute(StatusAttribute attribute) throws MissingAttributeException {
		Object v = this.status.get(attribute);	
		if (v == null){
			throw new MissingAttributeException("attribute doesn't exist in the current status");
		}else{
			return v;
		}
	}
	public void setAttribute(StatusAttribute attribute, Object o) throws MissingAttributeException {
		Object v = this.status.get(attribute);	
		if (v == null){
			throw new MissingAttributeException("attribute doesn't exist in the current status");
		}else{
			this.status.put(attribute, o);
		}
	}

}
