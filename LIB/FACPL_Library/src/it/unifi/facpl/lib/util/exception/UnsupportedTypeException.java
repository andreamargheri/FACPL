package it.unifi.facpl.lib.util.exception;

/**
 * @author Andrea Margheri
 *
 */
public class UnsupportedTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnsupportedTypeException(){
		super("Unsupported Argument Type for the function");
	}
	
	public UnsupportedTypeException(String type, String fun) {
		super("Unsupported Argument Type "+ type +" for the comparison function "+ fun);
	}
	

}
