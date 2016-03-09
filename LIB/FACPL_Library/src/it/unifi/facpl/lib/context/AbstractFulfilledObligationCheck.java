package it.unifi.facpl.lib.context;

import java.util.LinkedList;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;

public class AbstractFulfilledObligationCheck extends AbstractFulfilledObligation {

	public AbstractFulfilledObligationCheck(Effect effect, ObligationType typeObl) {
		this.type = typeObl;
		this.evaluatedOn = effect;
		this.arguments = new LinkedList<Object>();
	}
	@Override
	public Object getPepAction() {
		
		return null;
	}

	@Override
	public AbstractFulfilledObligation evaluateObl() throws Throwable {
		
		return null;
	}

}
