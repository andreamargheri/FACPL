package it.unifi.facpl.example.epsos;

import java.util.HashMap;

import it.unifi.facpl.lib.interfaces.IPepAction;
import it.unifi.facpl.lib.pepFunction.Compress;

@SuppressWarnings("all")
public class PEPAction{

	public HashMap<String,Class<? extends IPepAction>> addPepActions(){
		
		HashMap<String,Class<? extends IPepAction>> pepAction = new HashMap<String,Class<? extends IPepAction>>();
		pepAction.put("compress", Compress.class);
		return pepAction;
		
	}
	
}
