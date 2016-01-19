package it.unifi.facpl.lib.context;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.Set;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class Request {

	private String id;
	private HashMap<String,HashMap<String,Object>> attributes;

	public Request(String id){
		this.attributes = new HashMap<String, HashMap<String,Object>>();

		this.id = id;
	}

	public void addAttribute (String category_id, HashMap<String,Object> attr){
		this.attributes.put(category_id, attr);
	}

	public String getId() {
		return id;
	}

//	public void setId(String id) {
//		this.id = id;
//	}

	/**
	 * 
	 * @param category Category_Id of the attribute in the request context
	 * @param name Name of the attribute in the request context
	 * @return Type of values or Bag object of attribute values that matches the parameters
	 * @throws MissingAttributeException 
	 */
	public Object getRequestValues(AttributeName name) throws MissingAttributeException{
		Logger l = LoggerFactory.getLogger(Request.class);

		l.debug("Request_attribute: Struct_Name "+ name.getCategory().toString() + " + " + name.getIDAttribute().toString());

		HashMap<String,Object> values_cat = attributes.get(name.getCategory());

		//bag object or string, integer, ....
		//si salva direttamente un oggetto BAG in caso di multivalue
		try{
			Object values = values_cat.get(name.getIDAttribute());
			if (values == null){
				throw new MissingAttributeException();
			}
			if (values instanceof Set){
				l.debug("BAG values: "+ values.toString());
			}else{
				l.debug("Attribute values: "+ values.toString());
			}
			return values;
		}catch(Throwable t){
			throw new MissingAttributeException();
		}
	}

}
