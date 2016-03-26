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

	private FacplStatusType type;

	public StatusAttribute(String id, FacplStatusType type) {
		super(id, "status");
		this.type = type;
	}

	public FacplStatusType getType() {
		return type;
	}

	public void setType(FacplStatusType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type.toString() + "/" + super.getIDAttribute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StatusAttribute) {
			StatusAttribute o = (StatusAttribute) obj;
			return super.getIDAttribute() == o.getIDAttribute() && this.getType() == o.getType();
		}
		return false;
	}

}
