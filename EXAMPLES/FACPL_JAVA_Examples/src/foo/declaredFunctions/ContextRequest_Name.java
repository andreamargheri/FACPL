package foo.declaredFunctions;

import java.util.HashMap;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.util.Bag;

@SuppressWarnings("all")
public class ContextRequest_Name {

	private static ContextRequest CxtReq;

	public static ContextRequest getContextReq() {
		if (CxtReq != null) {
			return CxtReq;
		}
		// create map for each category
		HashMap<String, Object> req_action = new HashMap<String, Object>();
		// add attribute's values
		req_action.put("id", "READ");
		// add attributes to request
		Request req = new Request("Name");
		req.addAttribute("action", req_action);
		// context stub: default-one
		CxtReq = new ContextRequest(req, ContextStub_Default.getInstance());
		return CxtReq;
	}
}
