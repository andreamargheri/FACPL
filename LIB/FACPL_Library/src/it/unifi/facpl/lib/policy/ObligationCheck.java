package it.unifi.facpl.lib.policy;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.context.FulfilledObligationCheckPersistent;
import it.unifi.facpl.lib.enums.CheckObligationType;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;

public class ObligationCheck extends AbstractObligation {

	private ExpressionBooleanTree target;
	private ExpressionBooleanTree status_target;
	private int expiration; // PER ORA E' UN INT, POTRA' ESSERE ANCHE UN TEMPO
							// IN FUTURO
	private CheckObligationType type;
	/*
	 * Servono quattro costruttori poiche' bisogna considerare tutti e quattro i
	 * casi possibili di funzioni in input
	 */

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = new ExpressionBooleanTree(status_target);
		this.init(expiration);
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = status_target;
		this.init(expiration);
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = new ExpressionBooleanTree(status_target);
		this.init(expiration);

	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = status_target;
		this.init(expiration);

	}

	private void init(int expiration) {
		this.expiration = expiration;
		this.pepAction = "CHECK";
		this.type = CheckObligationType.N;
	}

	private void init() {
		this.pepAction = "CHECK";
		this.type = CheckObligationType.P;
	}

	/*
	 * COSTRUTTORI PER IL PERSISTENTE
	 */

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionFunction status_target) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = new ExpressionBooleanTree(status_target);
		this.init();
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionBooleanTree status_target) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = status_target;
		this.init();

	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionFunction status_target) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = new ExpressionBooleanTree(status_target);
		this.init();

	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionBooleanTree status_target) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = status_target;
		this.init();
	}

	@Override
	protected AbstractFulfilledObligation createObligation() {
		if (this.type == CheckObligationType.N) {
			return new FulfilledObligationCheck(this.evaluatedOn, this.typeObl, this.target, this.status_target,
					this.expiration);
		} else {
			return new FulfilledObligationCheckPersistent(this.evaluatedOn, this.typeObl, this.target,
					this.status_target);
		}
	}

}
