package secondoEsempioStatus;


import java.util.ArrayList;
import java.util.HashMap;

import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.context.ContextStub_Status_Default;
import it.unifi.facpl.lib.context.Request;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

@SuppressWarnings("all")
public class ContextRequest_ViewRequestAlice {
	private static ContextRequest_Status CxtReq;

	public static ContextRequest_Status getContextReq() {
		if (CxtReq != null) {
			return CxtReq;
		}
		// create map for each category
		HashMap<String, Object> req_category_attribute_name = new HashMap<String, Object>();
		HashMap<String, Object> req_category_attribute_action = new HashMap<String, Object>();
		HashMap<String, Object> req_category_attribute_file = new HashMap<String, Object>();
		// add attribute's values
		req_category_attribute_name.put("id", "Alice");
		req_category_attribute_action.put("id", "view");
		req_category_attribute_file.put("id", "file1");
		// add attributes to request
		Request req = new Request("view");
		req.addAttribute("name", req_category_attribute_name);
		req.addAttribute("action", req_category_attribute_action);
		req.addAttribute("file", req_category_attribute_file);
		// context stub: default-one
		CxtReq = new ContextRequest_Status(req, ContextStub_Status_Default.getInstance());
		/*
		 * set dello stato
		 */
		ContextStub_Status_Default.getInstance().setStatus(createStatus());
		return CxtReq;
	}

	private static FacplStatus createStatus() {
		FacplDate date = new FacplDate();
		ArrayList<StatusAttribute> attributeList = new ArrayList<StatusAttribute>();
		attributeList.add(new StatusAttribute("accessTypeAlice", FacplStatusType.STRING, "no"));
		attributeList.add(new StatusAttribute("accessTypeBob", FacplStatusType.STRING, "no"));
		attributeList.add(new StatusAttribute("aliceFile1viewNumber", FacplStatusType.INT, "0"));
		attributeList.add(new StatusAttribute("bobFile1viewNumber", FacplStatusType.INT, "0"));
		attributeList.add(new StatusAttribute("aliceFile1expiration", FacplStatusType.DATE, date.toString()));
		attributeList.add(new StatusAttribute("bobFile1expiration", FacplStatusType.DATE, date.toString()));
		FacplStatus status = new FacplStatus(attributeList, "stato");
		return status;
	}
}
