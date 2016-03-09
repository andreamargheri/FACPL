/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
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
