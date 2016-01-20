package fcloud.demo;

import java.util.HashMap;

import it.unifi.facpl.lib.interfaces.IPepAction;

@SuppressWarnings("all")
public class PEPAction {

	public PEPAction() {
	}

	public HashMap<String, Class<? extends IPepAction>> addPepActions() {
		// Set your own pep action e.g.

		HashMap<String, Class<? extends IPepAction>> pepAction = new HashMap<String, Class<? extends IPepAction>>();
		pepAction.put("create", CreateAction.class);
		pepAction.put("freeze", FreezeAction.class);
		pepAction.put("release", ReleaseAction.class);

		return pepAction;
	}

}
