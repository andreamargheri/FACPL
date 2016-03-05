package it.unifi.facpl.lib.context;

import java.util.Date;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;

@SuppressWarnings("all")
public class ContextStub_Default extends AbstractContextStub {

	private static ContextStub_Default instance;

	public static ContextStub_Default getInstance() {
		if (instance == null) {
			instance = new ContextStub_Default();
		}
		return instance;
	}

	private ContextStub_Default() {

	}

}
