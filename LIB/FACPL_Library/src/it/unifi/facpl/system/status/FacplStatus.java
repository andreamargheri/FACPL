package it.unifi.facpl.system.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.unifi.facpl.lib.util.StatusAttributeName;

public class FacplStatus {
	
	private List<StatusAttribute> attributeList;
	private String statusID;
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
	
	//eventualmente altri metodi
	//050910828
	
}
