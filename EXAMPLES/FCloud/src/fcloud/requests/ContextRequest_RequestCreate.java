package fcloud.requests;


import java.util.HashMap;

import fcloud.demo.ContextStub_FCloud;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.Request;

@SuppressWarnings("all")		
public class ContextRequest_RequestCreate {

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
	req_subject.put("profile-id","P_2");
	req_resource.put("vm-type","TYPE_2");
	req_action.put("action-id","CREATE");
	//add attributes to request
	Request req = new Request("RequestCreate");
	req.addAttribute("subject",req_subject);
	req.addAttribute("resource",req_resource);
	req.addAttribute("action",req_action);
	//context stub: default-one
	CxtReq =  new ContextRequest(req, ContextStub_FCloud.getInstance());
	return CxtReq;
	}
}
