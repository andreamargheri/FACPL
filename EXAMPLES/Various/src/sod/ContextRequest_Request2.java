package sod;

import java.util.HashMap;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")		
public class ContextRequest_Request2 {

	private static ContextRequest CxtReq;


	public static ContextRequest getContextReq(){
	if (CxtReq != null){
		return CxtReq;
	}
	//create map for each category
	HashMap<String, Object> req_subject = new HashMap<String, Object>();
	HashMap<String, Object> req_resource = new HashMap<String, Object>();
	HashMap<String, Object> req_action = new HashMap<String, Object>();
	//add attribute's values
	req_subject.put("user","dmendiola");
	req_subject.put("role","SwEng");
	req_subject.put("organization","Corporation B");
	req_subject.put("locality","University A");
	req_subject.put("originating-device","Portable");
	req_resource.put("destination","University A");
	req_action.put("action-id","Read");
	req_subject.put("permission",new Set(
	"JOINT-PROJECT",
	"HEALTH-RECORDS",
	"JRAPP-EXECUTE"
	)
	);
	//add attributes to request
	Request req = new Request("Request2");
	req.addAttribute("subject",req_subject);
	req.addAttribute("resource",req_resource);
	req.addAttribute("action",req_action);
	//context stub: default-one
	CxtReq =  new ContextRequest(req, ContextStub_Default.getInstance());
	return CxtReq;
	}
}
