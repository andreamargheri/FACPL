package it.unifi.facpl.lib.policy;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;

public class ObligationCheck extends AbstractObligation {

	private ExpressionBooleanTree target;
	private ExpressionBooleanTree status_target;
	private int expiration; // PER ORA E' UN INT, POTRA' ESSERE ANCHE UN TEMPO
							// IN FUTURO

	/*
	 * Servono quattro costruttori poiche' bisogna considerare tutti e quattro i
	 * casi possibili di funzioni in input
	 */
	/*
	 * TODO: AGGIUNGERE TIPO PERSISTENTE NEL TEMPO E NEL NUMERO DI RICHIESTE
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

	public void subExpiration(int i) throws Exception {
		if (expiration != 0) {
			expiration -= i;
		} else if (expiration == 0) {
			throw new Exception("The obligation has expired");
			/*
			 * valutare se creare un nuovo tipo di Exception
			 */
		}
	}

	@Override
	public AbstractFulfilledObligation getObligationValue(ContextRequest cxtRequest) throws FulfillmentFailed {
		throw new FulfillmentFailed();
	}

	public ExpressionValue getObligationResult(ContextRequest cxtRequest) throws Exception {
		ExpressionValue result_target, result_target_status;
		if (this.getExpiration() > 0) {
			result_target = target.evaluateExpressionTree(cxtRequest);
			result_target_status = status_target.evaluateExpressionTree(cxtRequest);
		} else {
			result_target = ExpressionValue.ERROR;
			result_target_status = ExpressionValue.ERROR;
		}
		if (result_target == ExpressionValue.TRUE && result_target_status == ExpressionValue.TRUE) {
			this.subExpiration(1);
			return ExpressionValue.TRUE;
		} else if (result_target == ExpressionValue.BOTTOM || result_target_status == ExpressionValue.BOTTOM) {
			return ExpressionValue.BOTTOM;
		} else if (result_target == ExpressionValue.ERROR || result_target_status == ExpressionValue.ERROR) {
			return ExpressionValue.ERROR;
		} else if (result_target == ExpressionValue.FALSE || result_target == ExpressionValue.FALSE) {
			return ExpressionValue.FALSE;
		}
		return null;
	}

}
