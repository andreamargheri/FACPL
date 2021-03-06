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
package fcloud.requests;

import java.util.HashMap;

import fcloud.demo.ContextStub_FCloud;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.Request;

@SuppressWarnings("all")
public class ContextRequest_RequestReleaseN {

	private static ContextRequest CxtReq;

	public static ContextRequest getContextReq() {
		if (CxtReq != null) {
			return CxtReq;
		}
		// create map for each category
		HashMap<String, Object> req_subject = new HashMap<String, Object>();
		HashMap<String, Object> req_resource = new HashMap<String, Object>();
		HashMap<String, Object> req_action = new HashMap<String, Object>();
		// add attribute's values
		req_subject.put("profile-id", "P_1");
		req_resource.put("vm-type", "TYPE_1");
		req_resource.put("vm-id", "vm_id3");
		req_action.put("action-id", "RELEASE");
		// add attributes to request
		Request req = new Request("RequestReleaseN");
		req.addAttribute("subject", req_subject);
		req.addAttribute("resource", req_resource);
		req.addAttribute("action", req_action);
		// context stub: default-one
		CxtReq = new ContextRequest(req, ContextStub_FCloud.getInstance());
		return CxtReq;
	}
}
