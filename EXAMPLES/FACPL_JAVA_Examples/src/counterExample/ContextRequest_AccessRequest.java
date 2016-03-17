package counterExample;

import java.util.ArrayList;
import java.util.HashMap;

import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.context.ContextStub_Default;
import it.unifi.facpl.lib.context.Request;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

@SuppressWarnings("all")
public class ContextRequest_AccessRequest {

	private static ContextRequest_Status CxtReq;

	public static ContextRequest_Status getContextReq() {
		if (CxtReq != null) {
			return CxtReq;
		}
		// create map for each category
		HashMap<String, Object> req_category_attribute = new HashMap<String, Object>();
		// add attribute's values
		req_category_attribute.put("id", "Lucrezia");
		// add attributes to request
		Request req = new Request("request1");
		req.addAttribute("name", req_category_attribute);
		// context stub: default-one
		CxtReq = new ContextRequest_Status(req, ContextStub_Default.getInstance());
		Status_1 st = new Status_1();
		CxtReq.setStatus(st.getStatus());
		return CxtReq;
	}


}