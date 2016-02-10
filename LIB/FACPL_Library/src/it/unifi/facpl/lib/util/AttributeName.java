package it.unifi.facpl.lib.util;

public class AttributeName {
	private String idAttribute;
	private String category;

	public AttributeName(String category, String id) {
		this.category = category;
		this.idAttribute = id;
	}

	public String getIDAttribute() {
		return idAttribute;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return category.toString() + "/" + idAttribute.toString();
	}

}
