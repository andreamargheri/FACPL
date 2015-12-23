package it.unifi.facpl.example.epsos;

import java.util.HashMap;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.Request;
import it.unifi.facpl.lib.util.Bag;

@SuppressWarnings("all")
public class ContextRequest_Request4 {

	private static ContextRequest CxtReq;

	public static ContextRequest getContextReq() {
		if (CxtReq != null) {
			return CxtReq;
		}
		// create map for each category
		HashMap<String, Object> req_subject_access = new HashMap<String, Object>();
		HashMap<String, Object> req_subject = new HashMap<String, Object>();
		HashMap<String, Object> req_resource = new HashMap<String, Object>();
		HashMap<String, Object> req_action = new HashMap<String, Object>();
		// add attribute's values
		req_subject_access.put("purposeofuse", "TREATEMENT");
		req_subject.put("role", "medical doctor");
		req_subject.put("hl7.permission", new Bag("PRD-003", "PRD-005", "PRD-010", "PRD-016"));
		req_resource.put("resource-id", "34133-9");
		req_resource.put("resource-id.email", "mail@gmail.com");
		req_action.put("action-id", "Read");
		// add attributes to request
		Request req = new Request("Request4");
		req.addAttribute("subject.access", req_subject_access);
		req.addAttribute("subject", req_subject);
		req.addAttribute("resource", req_resource);
		req.addAttribute("action", req_action);
		// context stub: auto-generated class
		CxtReq = new ContextRequest(req, ContextStub_Default.getInstance());
		return CxtReq;
	}

}
