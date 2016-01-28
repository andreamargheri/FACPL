/**
 * 
 */
package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.interfaces.IPepActionStatus;

/**
 * @author Andrea Margheri
 *
 */
public class FulfilledObligationStatus extends FulfilledObligation {

	private Class < ? extends IPepActionStatus> pepAction; 
	
	
	public FulfilledObligationStatus(Effect effect, ObligationType typeObl, Class < ? extends IPepActionStatus> pepAction) {
		super();
		super.type = typeObl;
		super.evaluatedOn = effect;
		this.pepAction = pepAction;
	}
	
	
	
	

}
