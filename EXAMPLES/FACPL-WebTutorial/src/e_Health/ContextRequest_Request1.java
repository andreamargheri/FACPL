package e_Health;

import java.util.HashMap;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")		
public class ContextRequest_Request1 {

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
	req_subject.put("id","Marley");
	req_resource.put("type","ePrescription");
	req_subject.put("role","doctor");
	req_subject.put("permission",new Set(
	"e-Pre-Read",
	"e-Pre-Write"
	)
	);
	req_action.put("id","write");
	//add attributes to request
	Request req = new Request("Request1");
	req.addAttribute("subject",req_subject);
	req.addAttribute("resource",req_resource);
	req.addAttribute("action",req_action);
	//context stub: default-one
	CxtReq =  new ContextRequest(req, ContextStub_Default.getInstance());
	return CxtReq;
	}
}
