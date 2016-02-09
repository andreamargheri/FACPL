package it.unifi.facpl.system.status;

import java.util.ArrayList;
import java.util.List;

import it.unifi.facpl.lib.util.StatusAttributeName;

public class FacplStatus {
	
	private List<StatusAttribute> attributeList;
	private String id;
	/**
	 * @param id
	 */
	public FacplStatus(String id) {
		attributeList = new ArrayList<StatusAttribute>();
		this.id = id;
	}
	
	/**
	 * @param attributeList
	 * @param id
	 */
	public FacplStatus(List<StatusAttribute> attributeList, String id) {
		this.attributeList = attributeList;
		this.id = id;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void add(StatusAttribute a) {
		this.attributeList.add(a);
	}

	
	/**
	 * To use to retrieve the value of a Status Attribute
	 * @param attribute
	 */
	public Object getValue(StatusAttributeName attribute) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//eventualmente altri metodi
	//050910828
	
}
