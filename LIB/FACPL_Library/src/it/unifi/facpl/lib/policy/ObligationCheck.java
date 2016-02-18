package it.unifi.facpl.lib.policy;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.CheckType;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;

public class ObligationCheck extends AbstractObligation {

	private ExpressionBooleanTree target;
	private ExpressionBooleanTree status_target;
	private CheckType ct;
	private int expiration; // PER ORA E' UN INT, POTRA' ESSERE ANCHE UN TEMPO
							// IN FUTURO

	/*
	 * Servono quattro costruttori poiche' bisogna considerare tutti e quattro i
	 * casi possibili di funzioni in input
	 */

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = new ExpressionBooleanTree(status_target);
		this.expiration = expiration;
		this.pepAction = "CHECK";
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = status_target;
		this.expiration = expiration;
		this.pepAction = "CHECK";
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = new ExpressionBooleanTree(status_target);
		this.expiration = expiration;
		this.pepAction = "CHECK";

	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = status_target;
		this.expiration = expiration;
		this.pepAction = "CHECK";
	}
	
	public int getExpiration() {
		return expiration;
	}

	@Override
	protected AbstractFulfilledObligation createObligation() {
		return new FulfilledObligationCheck(this.evaluatedOn,this.typeObl, this.target, this.status_target, this.expiration);
	}



}
