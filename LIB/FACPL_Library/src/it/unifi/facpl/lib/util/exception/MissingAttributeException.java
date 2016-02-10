package it.unifi.facpl.lib.util.exception;

public class MissingAttributeException extends Exception {

	private static final long serialVersionUID = 1L;

	public MissingAttributeException() {
		super("Missing Attribute In Context Request");
	}

}
