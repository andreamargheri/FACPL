package it.unifi.facpl.junit.util;

import java.util.LinkedList;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;

public class AbstractPolicySet extends PolicySet {

	private TargetDecision m;
	private Class<? extends IEvaluableAlgorithm> permitOver = it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class;
	private Boolean err_obl;

	/**
	 * 
	 * @param d
	 *            Decision resulted by the internal element
	 * @param m
	 *            Target applicability
	 * @param fullfilmentObl
	 *            Fulfillment error (TRUE= Error)
	 */
	public AbstractPolicySet(AuthorisationPDP d, TargetDecision m, Boolean fullfilmentObl) {
		this.m = m;

		this.err_obl = fullfilmentObl;

		addCombiningAlg(permitOver);

		if (d.getDecision().equals(ExtendedDecision.PERMIT)) {
			addPolicyElement(new AbstractRule(Effect.PERMIT, TargetDecision.TRUE, false));
		} else if (d.getDecision().equals(ExtendedDecision.DENY)) {
			addPolicyElement(new AbstractRule(Effect.DENY, TargetDecision.TRUE, false));
		} else if (d.getDecision().equals(ExtendedDecision.NOT_APPLICABLE)) {
			addPolicyElement(new AbstractRule(Effect.DENY, TargetDecision.FALSE, false));
		} else if (d.getDecision().equals(ExtendedDecision.INDETERMINATE_D)) {
			addPolicyElement(new AbstractRule(Effect.DENY, TargetDecision.INDETERMINATE, false));
		} else if (d.getDecision().equals(ExtendedDecision.INDETERMINATE_P)) {
			addPolicyElement(new AbstractRule(Effect.PERMIT, TargetDecision.INDETERMINATE, false));
		}
	}

	@Override
	public TargetDecision getTargetDecision(ContextRequest cxtRequest) {
		if (this.m == null) {
			return super.getTargetDecision(null);
		}
		return this.m;
	}

	@Override
	protected LinkedList<FulfilledObligation> evaluateObl(Effect effect, ContextRequest cxtRequest)
			throws FulfillmentFailed {

		if (err_obl) {
			throw new FulfillmentFailed();
		} else {
			return new LinkedList<FulfilledObligation>();
		}
	}

}
