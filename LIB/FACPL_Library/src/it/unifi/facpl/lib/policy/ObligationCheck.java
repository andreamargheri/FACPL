package it.unifi.facpl.lib.policy;

import java.util.Calendar;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.context.FulfilledObligationCheckPersistent;
import it.unifi.facpl.lib.context.FulfilledObligationTimeCheck;
import it.unifi.facpl.lib.enums.CheckObligationType;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.util.FacplDate;

public class ObligationCheck extends AbstractObligation {

	private ExpressionBooleanTree target;
	private ExpressionBooleanTree status_target;
	private int expiration; 
	private FacplDate expirationTime;
	private CheckObligationType type;
	
	/*
	 * four constructor for all combination of Expression: 
	 * 1: ExpressionFunction, ExpressionFunction
	 * 2: ExpressionBooleanTree, ExpressionBooleanTree
	 * 3: ExpressionBooleanTree, ExpressionFunction
	 * 4: ExpressionFunction, ExpresisonBooleanTree
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
	
	private void init(FacplDate expiration) {
		this.expirationTime = new FacplDate();
		System.err.println("START TIME "+this.expirationTime.toString());
		this.expirationTime.getDate().add(Calendar.SECOND, expiration.getDate().get(Calendar.SECOND));
		this.expirationTime.getDate().add(Calendar.MINUTE, expiration.getDate().get(Calendar.MINUTE));
		this.expirationTime.getDate().add(Calendar.HOUR, expiration.getDate().get(Calendar.HOUR));
		System.err.println("EXPIRATION TIME SECOND "+this.expirationTime.getDate().get(Calendar.SECOND));
		System.err.println("EXPIRATION TIME MINUTE "+this.expirationTime.getDate().get(Calendar.MINUTE));
		System.err.println("EXPIRATION TIME HOUR "+this.expirationTime.getDate().get(Calendar.HOUR));
		this.pepAction = "CHECK";
		this.type = CheckObligationType.T;
	}

	private void init() {
		this.pepAction = "CHECK";
		this.type = CheckObligationType.P;
	}

	/*
	 * CONSTRUCTOR FOR PERSISTENT TYPE
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
	
	public ObligationCheck(Effect evaluatedOn, ObligationType type) {
		super(evaluatedOn, type);
		this.init();
	}
	
	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionFunction status_target, FacplDate expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = new ExpressionBooleanTree(status_target);
		this.init(expiration);
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionBooleanTree status_target, FacplDate expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = status_target;
		this.init(expiration);
	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionFunction status_target, FacplDate expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = new ExpressionBooleanTree(status_target);
		this.init(expiration);

	}

	public ObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionBooleanTree status_target, FacplDate expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = status_target;
		this.init(expiration);

	}

	@Override
	protected AbstractFulfilledObligation createObligation() {
		/*
		 * this method create a fulfilledobligationcheck
		 */
		if (this.type == CheckObligationType.N) {
			return new FulfilledObligationCheck(this.evaluatedOn, this.typeObl, this.target, this.status_target,
					this.expiration);
		} else if (this.type == CheckObligationType.T){
			return new FulfilledObligationTimeCheck(this.evaluatedOn, this.typeObl, this.target, this.status_target,
					this.expirationTime);
		} else{
			return new FulfilledObligationCheckPersistent(this.evaluatedOn, this.typeObl, this.target,
					this.status_target);
		}
	}
	
	

}
