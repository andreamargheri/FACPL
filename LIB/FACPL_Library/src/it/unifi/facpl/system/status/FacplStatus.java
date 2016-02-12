package it.unifi.facpl.system.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.unifi.facpl.lib.util.StatusAttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class FacplStatus {
	
	private List<StatusAttribute> attributeList;
	private String statusID;
	private static FacplStatus instance = null;
	/**
	 * @param id
	 */
	/*
	 * metodi per singleton
	 */
//	public static FacplStatus getInstance(String statusID) {
//		if (instance == null) {
//			instance = new FacplStatus(statusID);
//		}
//		return instance;
//	}
//	public static FacplStatus getInstance(List<StatusAttribute> attributeList, String statusID) {
//		if (instance == null) {
//			instance = new FacplStatus(attributeList, statusID);
//		}
//		return instance;
//	}
//	public static FacplStatus getInstance() {
//		if (instance == null) {
//			instance = new FacplStatus("666");
//		}
//		return instance;
//	}
//	/*
//	 * costruttori privatizzati (dallo stato)
//	 */
//	private FacplStatus(String statusID) {
//		attributeList = new ArrayList<StatusAttribute>();
//		this.statusID = statusID;
//	}
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
	public Object getValue(StatusAttributeName attribute)  {
		Iterator<StatusAttribute> it = this.attributeList.iterator();
		while (it.hasNext()) {
			StatusAttribute t = it.next();
			if (attribute.getIDAttribute() == t.getId()) {
				return t.getValue();
			}
		}
		return null;
	}
	//050910828
	public StatusAttribute getStatusAttribute(StatusAttribute attribute) throws MissingAttributeException{
		int i =  this.attributeList.indexOf(attribute);
		if (i != -1) {
			return this.attributeList.get(i);
		}
		else {
			throw new MissingAttributeException("attribute doesn't exist in the current status");
		}
	}
	
	
}
