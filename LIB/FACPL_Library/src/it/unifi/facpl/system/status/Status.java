package it.unifi.facpl.system.status;

import java.util.ArrayList;
import java.util.List;

public class Status {
	
	private List<StatusAttribute> attributeList;
	private String id;
	/**
	 * @param id
	 */
	public Status(String id) {
		attributeList = new ArrayList<StatusAttribute>();
		this.id = id;
	}
	
	/**
	 * @param attributeList
	 * @param id
	 */
	public Status(List<StatusAttribute> attributeList, String id) {
		this.attributeList = attributeList;
		this.id = id;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void add(StatusAttribute a) {
		this.attributeList.add(a);
	}
	
	//eventualmente altri metodi
	//050910828
	
	

}
