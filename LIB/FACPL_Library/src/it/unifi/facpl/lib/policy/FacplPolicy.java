package it.unifi.facpl.lib.policy;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;

public abstract class FacplPolicy implements IEvaluablePolicy {

	protected ExpressionBooleanTree targetExpression;
	protected LinkedList<Obligation> obligations;
	protected String idElement;

	protected void addId(String id) {
		this.idElement = id;
	}

	protected void addTarget(ExpressionBooleanTree target) {
		if (target != null) {
			this.targetExpression = target;
		}
	}

	protected void addTarget(ExpressionFunction target) {
		if (target != null) {
			this.targetExpression = new ExpressionBooleanTree(target);
		}
	}

	protected void addObligation(Obligation obl) {
		Logger l = LoggerFactory.getLogger(FacplPolicy.class);
		l.debug(idElement + ": addObligation");
		if (obl != null) {
			if (this.obligations == null) {
				this.obligations = new LinkedList<Obligation>();
			}
			this.obligations.add(obl);
		}
	}

	/**
	 * Target evaluation
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public TargetDecision getTargetDecision(ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(FacplPolicy.class);
		l.debug(idElement + "- Target Evaluation: ");

		if (this.targetExpression == null) {
			// empty target
			l.debug("Empty target. Target: TRUE");
			return TargetDecision.TRUE;
		}
		// Get Evaluation of Expression(s) defining the target (Call
		// ExpressionTree modeling Expressions)
		ExpressionValue result = this.targetExpression.evaluateExpressionTree(cxtRequest);

		// Convert the obtained result to the correct "matching" value
		TargetDecision dec;
		if (result.equals(ExpressionValue.BOTTOM) || result.equals(ExpressionValue.FALSE)) {
			dec = TargetDecision.FALSE;
		} else if (result.equals(ExpressionValue.TRUE)) {
			dec = TargetDecision.TRUE;
		} else {
			dec = TargetDecision.INDETERMINATE;
		}

		l.debug("End Target Decision: " + dec.toString());

		return dec;
	}

	protected LinkedList<FulfilledObligation> evaluateObl(Effect effect, ContextRequest cxtRequest)
			throws FulfillmentFailed {
		LinkedList<FulfilledObligation> fuliflledObls = new LinkedList<FulfilledObligation>();
		Logger l = LoggerFactory.getLogger(FacplPolicy.class);
		l.debug(idElement + "- Start obligation eval");

		if (this.obligations != null) {
			for (Obligation oblExpr : this.obligations) {
				// Check Applicability of the Obligations to evaluate
				if (oblExpr.getEvaluatedOn().name().equals(effect.name())) {
					fuliflledObls.add(oblExpr.getObligationValue(cxtRequest));
				}
			}
		}

		l.debug(idElement + "- End obligation eval");

		return fuliflledObls;
	}

}
