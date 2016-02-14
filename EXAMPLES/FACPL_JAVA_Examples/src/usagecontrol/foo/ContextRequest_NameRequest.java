package usagecontrol.foo;

import java.util.HashMap;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.context.ContextStub_Status_Default;
import it.unifi.facpl.lib.context.Request;
import it.unifi.facpl.system.status.FacplStatus;

@SuppressWarnings("all")
public class ContextRequest_NameRequest {


	private static ContextRequest_Status CxtReq;

	public static ContextRequest_Status getContextReq(FacplStatus status) {
		if (CxtReq != null) {
			return CxtReq;
		}
		//in caso contrario viene creata la richiesta
		// create map for each category
		HashMap<String, Object> req_category_attribute = new HashMap<String, Object>();
		// add attribute's values
		req_category_attribute.put("id", "3");
		// add attributes to request
		Request req = new Request("NameRequest");
		req.addAttribute("category", req_category_attribute);
		// context stub: default-one
		CxtReq = new ContextRequest_Status(req, ContextStub_Status_Default.getInstance());
		ContextStub_Status_Default.getInstance().setStatus(status);
		return CxtReq;
	}

}