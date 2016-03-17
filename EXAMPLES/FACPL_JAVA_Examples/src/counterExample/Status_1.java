package counterExample;

import java.util.HashMap;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public class Status_1 {
	
	private FacplStatus status;
	
	public Status_1() {
		HashMap<StatusAttribute, Object> attributes = new HashMap<StatusAttribute, Object>();
		attributes.put(new StatusAttribute("accessCounter", FacplStatusType.INT), 0);
		status = new FacplStatus(attributes, this.getClass().getName());
	}
	public FacplStatus getStatus() {
		return status;
	}
}
