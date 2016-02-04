package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.interfaces.IPepActionStatus;

public class FullfilledObbligation extends AbstractFulfilledObligation {

	
	public FullfilledObbligation(Effect effect, ObligationType typeObl, String pepAction) {
		super(effect, typeObl, pepAction);
	}
	@Override
	public AbstractFulfilledObligation evaluateObl() throws Exception {
		throw new Exception("it's not a status obbligation");
	}

}
