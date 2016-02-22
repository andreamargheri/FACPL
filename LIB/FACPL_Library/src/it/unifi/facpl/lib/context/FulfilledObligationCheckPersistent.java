package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;

public class FulfilledObligationCheckPersistent extends FulfilledObligationCheck {

	public FulfilledObligationCheckPersistent(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionBooleanTree status_target) {
		super(evaluatedOn, type, target, status_target, Integer.MAX_VALUE);
	}

	public FulfilledObligationCheckPersistent(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionBooleanTree status_target) {
		super(evaluatedOn, type, target, status_target, Integer.MAX_VALUE);
	}

	public FulfilledObligationCheckPersistent(Effect evaluatedOn, ObligationType type, ExpressionBooleanTree target,
			ExpressionFunction status_target) {
		super(evaluatedOn, type, target, status_target, Integer.MAX_VALUE);
	}

	public FulfilledObligationCheckPersistent(Effect evaluatedOn, ObligationType type, ExpressionFunction target,
			ExpressionFunction status_target) {
		super(evaluatedOn, type, target, status_target, Integer.MAX_VALUE);
	}

	public void setExpired() {
		this.hasExpired = false;
	}

	public boolean hasExpired() {
		return false;
	}

	public void subExpiration(int i) {
		// do nothing
	}

	@Override
	public String toString() {
		return "target: " + target.toString() + "\r\n" + "status: " + status_target.toString() + "\r\n PERSISTENT";
	}

}
