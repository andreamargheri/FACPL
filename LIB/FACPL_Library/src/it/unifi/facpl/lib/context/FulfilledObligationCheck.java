package it.unifi.facpl.lib.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.check.IEvaluableAlgorithmCheck;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.system.PEP;

public class FulfilledObligationCheck extends AbstractFulfilledObligation implements Cloneable {

	protected ExpressionBooleanTree target;
	protected ExpressionBooleanTree status_target;
	protected int expiration; 
	protected boolean hasExpired;
	protected int originalExpiration;

	
	public FulfilledObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.target = new ExpressionBooleanTree(status_target);
		this.expiration = expiration;
		this.originalExpiration = expiration;
		this.hasExpired = false;
	}

	public FulfilledObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = status_target;
		this.expiration = expiration;
		this.hasExpired = false;
		this.originalExpiration = expiration;
	}

	public FulfilledObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.target = new ExpressionBooleanTree(status_target);
		this.expiration = expiration;
		this.hasExpired = false;
		this.originalExpiration = expiration;
	}

	public FulfilledObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = status_target;
		this.expiration = expiration;
		this.hasExpired = false;
		this.originalExpiration = expiration;
	}

	@Override
	public Object getPepAction() {
		// TODO Auto-generated method stub
		/*
		 * TODO: NON CI SONO PEPACTION, GESTIRE QUESTO ASPETTO
		 */
		return null;
	}

	@Override
	public AbstractFulfilledObligation evaluateObl() throws Throwable  {
		// TODO Auto-generated method stub
		return null;
	}

	public ExpressionValue getObligationResult(ContextRequest cxtRequest) throws Exception {
		/*
		 * SE ENTRAMBE VERE -> VERO SE UNA FALSA -> FALSO [RITORNA PDP] SE UNA
		 * BOTTOM -> BOTTOM [RITORNA PDP] SE UNA ERROR -> ERROR [RITORNA PDP]
		 */
		Logger l = LoggerFactory.getLogger(FulfilledObligationCheck.class);
		l.debug("EVALUATING FULFILLEDOBLIGATIONCHECK: "+"\r\n");
		
		ExpressionValue result_target, result_target_status;
		result_target = null;
		result_target_status = null;
		if (this.getExpiration() > 0) {
			l.debug("EVALUATING EXPRESSION OF OBLIGATION: "+"\r\n");
			result_target = target.evaluateExpressionTree(cxtRequest);
			result_target_status = status_target.evaluateExpressionTree(cxtRequest);
			this.subExpiration(1);
			l.debug("RESULT_TARGET: " + result_target + " || RESULT_TARGET_STATUS: " + result_target_status);
		} else if (this.getExpiration() == 0) {
			l.debug("OBLIGATION CHECK HAS EXPIRED");
			result_target = ExpressionValue.ERROR;
			result_target_status = ExpressionValue.ERROR;
		}

		/*
		 * TODO: GESTIRE NULL POINTER EXCEPTION
		 */
		if (result_target == ExpressionValue.TRUE && result_target_status == ExpressionValue.TRUE) {
			l.debug("DECISION CHECK: TRUE");
			return ExpressionValue.TRUE;
		} else if (result_target == ExpressionValue.BOTTOM || result_target_status == ExpressionValue.BOTTOM) {
			l.debug("DECISION CHECK: BOTTOM");
			return ExpressionValue.BOTTOM;
		} else if (result_target == ExpressionValue.ERROR || result_target_status == ExpressionValue.ERROR) {
			l.debug("DECISION CHECK: ERROR");
			return ExpressionValue.ERROR;
		} else if (result_target == ExpressionValue.FALSE || result_target_status == ExpressionValue.FALSE) {
			l.debug("DECISION CHECK: FALSE");
			return ExpressionValue.FALSE;
		}
		return null;
	}

	public int getExpiration() {
		return expiration;
	}
	public void setExpired() {
		this.hasExpired = true;
	}
	public boolean hasExpired() {
		return this.hasExpired;
	}
	public void subExpiration(int i) throws Exception {
		Logger l = LoggerFactory.getLogger(FulfilledObligationCheck.class);
		if (expiration != 0) {
			expiration -= i;
			l.debug("NEW EXPIRATION: "+this.toString());
			if (expiration == 0) {
				this.setExpired();
			}
		} else if (expiration == 0) {
			throw new Exception("The obligation has expired");
			/*
			 * valutare se creare un nuovo tipo di Exception
			 */
		}
	}

	@Override
	public String toString() {
		return "target: " + target.toString() + "\r\n" + "status: " + status_target.toString() +"\r\n EXPIRATION IN: "+expiration;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new FulfilledObligationCheck(this.evaluatedOn, this.type, this.target,this.status_target, this.originalExpiration);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FulfilledObligationCheck) {
			FulfilledObligationCheck temp = (FulfilledObligationCheck) obj;
			return temp.target == this.target && temp.status_target == this.status_target;
		}
		return false;
	}

}
