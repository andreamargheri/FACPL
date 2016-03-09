/**
 * 
 */
package it.unifi.xtext.facpl.generator.util;

import it.unifi.xtext.facpl.validation.FacplType;

/**
 * @author Andrea Margheri
 *
 */
public class ConstraintConstant {

	private FacplType type;
	private String att_name;
	private Object value;

	public ConstraintConstant(FacplType t, String n, Object v) {
		this.type = t;
		this.att_name = n.replaceAll(" ", "_");
		if (v instanceof String) {
			v = ((String) v).replaceAll(" ", "_");
		}
		this.value = v;
	}

	public Object getValue() {
		return value;
	}

	public String getAtt_name() {
		return att_name;
	}

	public FacplType getType() {
		return type;
	}

	@Override
	public String toString() {
		return this.att_name + " : " + this.type.toString() + " = " + this.value.toString();
	}

}
