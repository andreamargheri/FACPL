/**
 * 
 */
package it.unifi.facpl.lib.util;

import it.unifi.facpl.lib.enums.FacplStatusType;

/**
 * @author mameli
 *
 */
public class StatusAttributeName extends AttributeName {

	private FacplStatusType type;
	
	public StatusAttributeName(String category, String id) {
		super(category, id);
	}
	
	public FacplStatusType getType() {
		return type;
	}
}
