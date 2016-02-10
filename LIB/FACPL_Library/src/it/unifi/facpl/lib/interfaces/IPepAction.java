package it.unifi.facpl.lib.interfaces;

import java.util.List;

/**
 * Evaluation method for discharging PEP actions
 * 
 * @author Andrea Margheri
 *
 */
public interface IPepAction {

	public void eval(List<Object> args) throws Throwable;

}
