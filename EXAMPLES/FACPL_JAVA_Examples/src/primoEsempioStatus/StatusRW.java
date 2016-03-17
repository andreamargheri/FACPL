package primoEsempioStatus;

import java.util.HashMap;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

public class StatusRW {

private FacplStatus status;
	
	public StatusRW() {
		HashMap<StatusAttribute, Object> attributes = new HashMap<StatusAttribute, Object>();
		attributes.put(new StatusAttribute("isWriting", FacplStatusType.BOOLEAN), false);
		attributes.put(new StatusAttribute("counterReadFile1", FacplStatusType.INT), 0);
		attributes.put(new StatusAttribute("counterReadFile2", FacplStatusType.INT), 0);
		status = new FacplStatus(attributes, this.getClass().getName());
	}
	public FacplStatus getStatus() {
		return status;
	}
}
