package it.unifi.facpl.system.status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class FacplStatus {
	
	private List<StatusAttribute> attributeList;
	private String statusID;
	private static FacplStatus instance = null;
	/**
	 * @param id
	 */

	public FacplStatus(String statusID) {
		attributeList = new ArrayList<StatusAttribute>();
		this.statusID = statusID;
	}
	/**
	 * @param attributeList
	 * @param id
	 */
	public FacplStatus(List<StatusAttribute> attributeList, String statusID) {
		this.attributeList = attributeList;
		this.statusID = statusID;
	}
	
	public FacplStatus() {
		attributeList = new ArrayList<StatusAttribute>();
		this.statusID = UUID.randomUUID().toString().substring(0, 8);
	}
	
	public String getStatusID() {
		return this.statusID;
	}
	
	public void add(StatusAttribute a) {
		this.attributeList.add(a);
	}

	
	/**
	 * To use to retrieve the value of a Status Attribute
	 * @param attribute
	 */
	public StatusAttribute retrieveAttribute(StatusAttribute attribute) throws MissingAttributeException {
		int i =  this.attributeList.indexOf(attribute);
		if (i != -1) {
			return this.attributeList.get(i);
		}
		else {
			throw new MissingAttributeException("attribute doesn't exist in the current status");
		}
	}

	//050910828

	
	public Object getValue(StatusAttribute attribute) throws MissingAttributeException {
		return (Object)(this.retrieveAttribute(attribute).getValue());
	}
	
	
}
