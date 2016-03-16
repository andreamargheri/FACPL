/**
 * 
 */
package it.unifi.facpl.system.status;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.util.AttributeName;

/**
 * class for status attribute
 *
 */
public class StatusAttribute extends AttributeName {

//	private String id;
	
	private FacplStatusType type;
//	private String value;

	public StatusAttribute(String id, FacplStatusType type) {
		super(id,"status");
		this.type = type;
	}

	
	/**
	 * @return the type
	 */
	public FacplStatusType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(FacplStatusType type) {
		this.type = type;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof StatusAttribute) {
//			StatusAttribute o = (StatusAttribute) obj;
//			return super.getId() == o.getId() && this.getType() == o.getType();
//		}
//		return false;
//	}

	@Override
	public String toString() {
		return this.type.toString() + "/" + super.getIDAttribute() ;
	}

}
