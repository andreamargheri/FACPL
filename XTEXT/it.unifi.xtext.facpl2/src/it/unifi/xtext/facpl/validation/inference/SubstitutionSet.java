/**
 * 
 */
package it.unifi.xtext.facpl.validation.inference;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.validation.FacplType;

/**
 * @author Andrea Margheri
 *
 */
public class SubstitutionSet {

	private HashMap<String, FacplType> substitution;
	private HashMap<String, String> equalities;
	private LinkedList<String> set_Attributes;

	public SubstitutionSet() {
		this.substitution = new HashMap<String, FacplType>();
		this.equalities = new HashMap<String, String>();
		this.set_Attributes = new LinkedList<String>();
	}

	public HashMap<String, FacplType> getSubstitutions() {
		return substitution;
	}

	public void add(AttributeName var, FacplType type) throws Exception {
		if (isBounded(var)) {
			if ((getBound(var).equals(FacplType.INT) && type.equals(FacplType.DOUBLE))
					|| (getBound(var).equals(FacplType.DOUBLE) && type.equals(FacplType.INT))) {
				this.substitution.put(_nameToString(var), FacplType.DOUBLE);
			} else if (!getBound(var).equals(type)) {
				// Type cannot be unified
				// Put the inferred type of the variable as error
				this.substitution.put(_nameToString(var), FacplType.ERR);
				throw new Exception("Attribute Name Types cannot be unified");
			}
		} else {
			this.substitution.put(_nameToString(var), type);
		}
	}

	public void addEquality(AttributeName n1, AttributeName n2) {
		this.equalities.put(_nameToString(n1), _nameToString(n2));
		// this.equalities.put(_nameToString(n2), _nameToString(n1));
	}

	public boolean isBounded(AttributeName n) {
		return this.substitution.get(_nameToString(n)) != null;
	}

	/**
	 * Return the inferred type for the attribute name in input
	 * 
	 * @param n
	 * @return
	 */
	public FacplType getBound(AttributeName n) {
		return this.substitution.get(_nameToString(n));
	}

	public void addSetName(AttributeName a) {
		this.set_Attributes.add(_nameToString(a));
	}

	public LinkedList<String> getSet_Attributes() {
		return set_Attributes;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (Entry<String, FacplType> s : substitution.entrySet()) {
			if (s.getValue() != null)
				str.append(s.getKey() + " -> " + s.getValue().toString() + " ");
			else
				str.append(s.getKey() + " -> null ");
		}
		return str.toString();
	}

	public String toEq() {
		StringBuffer str = new StringBuffer();
		for (Entry<String, String> s : equalities.entrySet()) {
			if (s.getValue() != null)
				str.append(s.getKey() + " = " + s.getValue() + " ");
			else
				str.append(s.getKey() + " = null ");
		}
		return str.toString();
	}

	public static String _nameToString(AttributeName n) {
		return n.getCategory() + "/" + n.getId();
	}
}
