package it.unifi.facpl.lib.interfaces;

import java.util.List;

import it.unifi.facpl.system.status.StatusAttribute;

public interface IPepActionStatus extends IPepAction {
	
	public void eval(StatusAttribute attrStatus, List<Object> args) throws Throwable;
	
}
