package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;

public class FullfilledObbligation extends AbstractFulfilledObligation {

	private String pepAction;
	
	public FullfilledObbligation(Effect effect, ObligationType typeObl, String pepAction) {
		super(effect, typeObl);
		this.pepAction = pepAction;
	}
	
	@Override
	public AbstractFulfilledObligation evaluateObl() throws Exception {
		throw new Exception("it's not a status obbligation"); 
	}
	@Override
	public String toString() {
		return evaluatedOn + " " + type.toString() + " " + pepAction.toString() + "(" + arguments.toString() + ")";
	}

	@Override
	public Object getPepAction() {
		return this.pepAction;
	}
}
