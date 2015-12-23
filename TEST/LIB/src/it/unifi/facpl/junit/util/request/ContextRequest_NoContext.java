package it.unifi.facpl.junit.util.request;

import java.util.HashMap;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.Request;

public class ContextRequest_NoContext {

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
		req_subject.put("id", "andrea");
		req_subject.put("role", "doctor");
		req_subject.put("permission", "PR01");
		req_subject.put("num", 10);
		req_resource.put("patient.category", "CAT01");
		req_resource.put("patient.treatement", "TR05");
		req_action.put("id", "write");
		req_resource.put("id", 10);
		req_resource.put("num", 5);
		req_resource.put("patient.mail", "mail@mail.com");
		// add attributes to request
		Request req = new Request("Name");
		req.addAttribute("subject", req_subject);
		req.addAttribute("resource", req_resource);
		req.addAttribute("action", req_action);

		CxtReq = new ContextRequest(req, null);
		return CxtReq;
	}

}
