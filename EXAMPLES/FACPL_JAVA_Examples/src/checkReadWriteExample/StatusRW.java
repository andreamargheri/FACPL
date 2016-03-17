package checkReadWriteExample;

import java.util.HashMap;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public class StatusRW {
private FacplStatus status;
	
	public StatusRW() {
		HashMap<StatusAttribute, Object> attributes = new HashMap<StatusAttribute, Object>();
		attributes.put(new StatusAttribute("accessCounter", FacplStatusType.INT), 0);
		attributes.put(new StatusAttribute("isWritingThesis", FacplStatusType.BOOLEAN),Boolean.FALSE);
		status = new FacplStatus(attributes, this.getClass().getName());
	}
	public FacplStatus getStatus() {
		return status;
	}
}
