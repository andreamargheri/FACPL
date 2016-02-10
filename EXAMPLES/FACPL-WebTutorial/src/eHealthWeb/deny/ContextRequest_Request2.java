package eHealthWeb.deny;

import java.util.HashMap;

import eHealthWeb.ContextStub_eHealth;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class ContextRequest_Request2 {

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
		req_subject.put("id", "Dr.House");
		req_resource.put("patient-id", "Alice");
		req_resource.put("type", "e-Dispensation");
		req_subject.put("role", "pharmacist");
		req_subject.put("permission", "e-Dis-Read");
		req_action.put("id", "read");
		// add attributes to request
		Request req = new Request("Request2");
		req.addAttribute("subject", req_subject);
		req.addAttribute("resource", req_resource);
		req.addAttribute("action", req_action);
		// context stub: default-one
		CxtReq = new ContextRequest(req, ContextStub_eHealth.getInstance());
		return CxtReq;
	}
}
