package it.unifi.facpl.lib.policy;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;

public class ObligationCheck extends AbstractObligation {

	private ExpressionBooleanTree target;
	private ExpressionBooleanTree status_target;
	private int expiration; //PER ORA E' UN INT, POTRA' ESSERE ANCHE UN TEMPO IN FUTURO

	/*
	 * Servono quattro costruttori poiche'
	 * bisogna considerare tutti e quattro i casi possibili di funzioni in input
	 */
	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.target = new ExpressionBooleanTree(status_target);
		this.expiration = expiration;
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = status_target;
		this.expiration = expiration;
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.target = new ExpressionBooleanTree(status_target);
		this.expiration = expiration;

	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = status_target;
		this.expiration = expiration;
	}

	@Override
	protected AbstractFulfilledObligation createObligation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public int getExpiration() {
		return expiration;
	}

}
