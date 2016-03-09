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
package combining_2;

import java.util.HashMap;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.util.Set;

@SuppressWarnings("all")
public class ContextRequest_Request1 {

	private static ContextRequest CxtReq;

	public static ContextRequest getContextReq() {
		if (CxtReq != null) {
			return CxtReq;
		}
		// create map for each category
		HashMap<String, Object> req_action = new HashMap<String, Object>();
		HashMap<String, Object> req_subject = new HashMap<String, Object>();
		HashMap<String, Object> req_resource = new HashMap<String, Object>();
		// add attribute's values
		req_action.put("id", "read");
		req_subject.put("id", "John");
		req_subject.put("name", "Wilson");
		req_resource.put("id", "4567-1");
		// add attributes to request
		Request req = new Request("Request1");
		req.addAttribute("action", req_action);
		req.addAttribute("subject", req_subject);
		req.addAttribute("resource", req_resource);
		// context stub: default-one
		CxtReq = new ContextRequest(req, ContextStub_Default.getInstance());
		return CxtReq;
	}
}
