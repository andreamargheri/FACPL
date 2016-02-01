/**
 * 
 */
package it.unifi.facpl.system.status;

import it.unifi.facpl.lib.enums.FacplStatusType;

/**
 * class for status attribute	
 *
 */
public class StatusAttribute {

	private String id;
	private FacplStatusType type;
	/**
	 * @param id
	 * @param type
	 */
	public StatusAttribute(String id, FacplStatusType type) {
		this.id = id;
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public FacplStatusType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(FacplStatusType type) {
		this.type = type;
	}
	
	
	
}
