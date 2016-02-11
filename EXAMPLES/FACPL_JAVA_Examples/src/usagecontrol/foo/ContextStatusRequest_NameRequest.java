package usagecontrol.foo;

import java.util.HashMap;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class ContextStatusRequest_NameRequest {
	/*
	 * DA MODIFICARE
	 */

	private static ContextRequest CxtReq;

	public static ContextRequest getContextReq() {
		if (CxtReq != null) {
			return CxtReq;
		}
		//in caso contrario viene creata la richiesta
		// create map for each category
		HashMap<String, Object> req_category_attribute = new HashMap<String, Object>();
		// add attribute's values
		req_category_attribute.put("id_attribute", "");
		// add attributes to request
		Request req = new Request("NameRequest");
		req.addAttribute("category_attribute", req_category_attribute);
		// context stub: default-one
		CxtReq = new ContextRequest(req, ContextStub_Default.getInstance());
		return CxtReq;
	}
}
