package fcloud.demo;

import java.util.HashMap;

import it.unifi.facpl.lib.interfaces.IPepAction;

@SuppressWarnings("all")
public class PEPAction_Cloud {
	
	 public static HashMap<String, Class<? extends IPepAction>> getPepActions() {

		HashMap<String, Class<? extends IPepAction>> pepAction = new HashMap<String, Class<? extends IPepAction>>();
		pepAction.put("create", CreateAction.class);
		pepAction.put("freeze", FreezeAction.class);
		pepAction.put("release", ReleaseAction.class);

		return pepAction;
	}

}
