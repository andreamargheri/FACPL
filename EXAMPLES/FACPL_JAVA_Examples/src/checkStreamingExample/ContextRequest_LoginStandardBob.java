package checkStreamingExample;

import java.util.ArrayList;
import java.util.HashMap;

import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.context.ContextStub_Status_Default;
import it.unifi.facpl.lib.context.Request;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public class ContextRequest_LoginStandardBob {

	private static ContextRequest_Status CxtReq;

	public static ContextRequest_Status getContextReq() {
		if (CxtReq != null) {
			return CxtReq;
		}
		// create map for each category
		HashMap<String, Object> req_category_attribute_name = new HashMap<String, Object>();
		HashMap<String, Object> req_category_attribute_action = new HashMap<String, Object>();
		HashMap<String, Object> req_category_attribute_password = new HashMap<String, Object>();
		// add attribute's values
		req_category_attribute_name.put("id", "Bob");
		req_category_attribute_action.put("id", "login");
		req_category_attribute_password.put("id", "abcdef");
		// add attributes to request
		Request req = new Request("login bob");
		req.addAttribute("name", req_category_attribute_name);
		req.addAttribute("action", req_category_attribute_action);
		req.addAttribute("password", req_category_attribute_password);
		// context stub: default-one
		CxtReq = new ContextRequest_Status(req, ContextStub_Status_Default.getInstance());
		/*
		 * set dello stato
		 */
		ContextStub_Status_Default.getInstance().setStatus(createStatus());
		return CxtReq;
	}
	
	private static FacplStatus createStatus() {
		ArrayList<StatusAttribute> attributeList = new ArrayList<StatusAttribute>();
		attributeList.add(new StatusAttribute("loginBob", FacplStatusType.STRING, "noLogin"));
		attributeList.add(new StatusAttribute("loginAlice", FacplStatusType.STRING, "noLogin"));
		attributeList.add(new StatusAttribute("passwordAlice", FacplStatusType.STRING, "123456"));
		attributeList.add(new StatusAttribute("passwordBob", FacplStatusType.STRING, "abcdef"));
		attributeList.add(new StatusAttribute("streamingTimeBob", FacplStatusType.DATE, new FacplDate().toString()));
		attributeList.add(new StatusAttribute("streamingAlice", FacplStatusType.BOOLEAN, "false"));
		attributeList.add(new StatusAttribute("streamingBob", FacplStatusType.BOOLEAN, "false"));
		attributeList.add(new StatusAttribute("TIME", FacplStatusType.DATE, new FacplDate().toString()));
		FacplStatus status = new FacplStatus(attributeList, "stato");
		return status;
	}
}
