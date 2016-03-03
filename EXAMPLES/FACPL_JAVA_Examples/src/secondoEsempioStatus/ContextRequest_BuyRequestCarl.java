package secondoEsempioStatus;


import java.util.ArrayList;
import java.util.HashMap;

import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.context.ContextStub_Status_Default;
import it.unifi.facpl.lib.context.Request;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

@SuppressWarnings("all")
public class ContextRequest_BuyRequestCarl {
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
		req_category_attribute_name.put("id", "Carl");
		req_category_attribute_action.put("id", "buy");
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
		ArrayList<StatusAttribute> attributeList = new ArrayList<StatusAttribute>();
		attributeList.add(new StatusAttribute("compratoFile1", FacplStatusType.BOOLEAN, "false"));
		attributeList.add(new StatusAttribute("noleggiatoFile1Tempo", FacplStatusType.BOOLEAN, "false"));
		attributeList.add(new StatusAttribute("noleggiatoFile1Counter", FacplStatusType.BOOLEAN, "false"));
		attributeList.add(new StatusAttribute("counterViewFile1", FacplStatusType.INT, "0"));
		attributeList.add(new StatusAttribute("File1", FacplStatusType.STRING, "null"));
		attributeList.add(new StatusAttribute("buyType", FacplStatusType.INT, "0"));// 0 per comprare 1 per noleggiare a tempo 2 per noleggiare le views
		FacplStatus status = new FacplStatus(attributeList, "stato");
		return status;
	}
}
