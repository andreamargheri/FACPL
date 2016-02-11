package it.unifi.facpl.lib.context;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.Set;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class Request {

	/*
	 * classe usata per la richiesta
	 */
	private String id; //id della richiesta
	private HashMap<String,HashMap<String,Object>> attributes; //attributi della richiesta

	/*
	 * costruttori
	 */
	public Request(String id){
		this.attributes = new HashMap<String, HashMap<String,Object>>();

		this.id = id;
	}
	/*
	 * -----------------------------
	 * aggiungere attributi
	 */
	public void addAttribute (String category_id, HashMap<String,Object> attr){
		this.attributes.put(category_id, attr);
	}
	/*
	 * getter per l'id
	 */
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
		Logger l = LoggerFactory.getLogger(Request.class); //log -> inutile

		l.debug("Request_attribute: Struct_Name "+ name.getCategory().toString() + " + " + name.getIDAttribute().toString());//log -> inutile

		HashMap<String,Object> values_cat = attributes.get(name.getCategory());
		/*
		 * prende il valore dalla hashmap
		 * visto che la hashmap e' definita come HashMap<String,HashMap<String,Object>>, ovvero
		 * hashmap di hashmap viene restituita un'altra hashmap
		 */
		//bag object or string, integer, ....
		//si salva direttamente un oggetto BAG in caso di multivalue
		try{
			Object values = values_cat.get(name.getIDAttribute());
			/*
			 * il valore viene preso qua', 
			 */
			if (values == null){ //se non c'è' -> eccezione
				throw new MissingAttributeException();
			}
			if (values instanceof Set){ 
				l.debug("BAG values: "+ values.toString());
			}else{
				l.debug("Attribute values: "+ values.toString());
			}
			return values;
			/*
			 * logga il valore e lo restituisce
			 */
			
		}catch(Throwable t){
			throw new MissingAttributeException();
		}
	}

}
