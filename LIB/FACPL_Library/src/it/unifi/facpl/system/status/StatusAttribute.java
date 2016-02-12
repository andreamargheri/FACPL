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
	private String value;

	public StatusAttribute(String id, FacplStatusType type) {
		this.id = id;
		this.type = type;
		/*
		 * default values
		 */
		if (type == (FacplStatusType.INT) || type == (FacplStatusType.DOUBLE)) {
			value = "0";
		}
		else if (type == FacplStatusType.BOOLEAN) {
			value = "false";
		}
		else {
			value = "";
		}
	}
	
	public StatusAttribute(String id, FacplStatusType type, String value) {
		this.id = id;
		this.type = type;
		this.value = value;
	}
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StatusAttribute) {
			StatusAttribute o = (StatusAttribute)obj;
			return this.getId()==o.getId() && this.getType() == o.getType();
		}
		return false;
	}
	
	
	
}
