package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;

public class FulfilledObligationCheck extends AbstractFulfilledObligation {

	private ExpressionBooleanTree target;
	private ExpressionBooleanTree status_target;
	private int expiration; // PER ORA E' UN INT, POTRA' ESSERE ANCHE UN TEMPO
							// IN FUTURO

	/*
	 * TODO: AGGIUNGERE TIPO PERSISTENTE NEL TEMPO E NEL NUMERO DI RICHIESTE
	 */
	public FulfilledObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.target = new ExpressionBooleanTree(status_target);
		this.expiration = expiration;
	}

	public FulfilledObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.status_target = status_target;
		this.expiration = expiration;
	}

	public FulfilledObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionFunction status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = target;
		this.target = new ExpressionBooleanTree(status_target);
		this.expiration = expiration;

	}

	public FulfilledObligationCheck(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionBooleanTree status_target, int expiration) {
		super(evaluatedOn, type);
		this.target = new ExpressionBooleanTree(target);
		this.status_target = status_target;
		this.expiration = expiration;
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
	public AbstractFulfilledObligation evaluateObl() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	public ExpressionValue getObligationResult(ContextRequest cxtRequest) throws Exception {
		/*
		 * SE ENTRAMBE VERE -> VERO SE UNA FALSA -> FALSO [RITORNA PDP] SE UNA
		 * BOTTOM -> BOTTOM [RITORNA PDP] SE UNA ERROR -> ERROR [RITORNA PDP]
		 */
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
	public String toString() {
		return "target: " + target.toString() + "\r\n" + "status: " + status_target.toString();
	}

}
