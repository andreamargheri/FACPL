package foo;

import java.util.HashMap;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.util.Bag;

@SuppressWarnings("all")		
public class ContextRequest_NameRequest {

	private static ContextRequest CxtReq;


	public static ContextRequest getContextReq(){
	if (CxtReq != null){
		return CxtReq;
	}
	//create map for each category
	HashMap<String, Object> req_category = new HashMap<String, Object>();
	//add attribute's values
	req_category.put("id","value");
	//add attributes to request
	Request req = new Request("NameRequest");
	req.addAttribute("category",req_category);
	//context stub: default-one
	CxtReq =  new ContextRequest(req, ContextStub_Default.getInstance());
	return CxtReq;
	}
}
