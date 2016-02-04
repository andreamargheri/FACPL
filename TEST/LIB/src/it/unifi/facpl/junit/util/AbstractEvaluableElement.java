package it.unifi.facpl.junit.util;

import java.util.List;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

public class AbstractEvaluableElement implements IEvaluablePolicy {

	private AuthorisationPDP d;
	private TargetDecision m;

	// private LinkedList<ObligationValue> obls;

	public AbstractEvaluableElement(AuthorisationPDP d) {
		this.d = new AuthorisationPDP(d.getDecision());;
	}

	public AbstractEvaluableElement(TargetDecision m) {
		this.m = m;
	}

	public AbstractEvaluableElement(AuthorisationPDP d, TargetDecision m) {
		this.m = m;
		this.d = new AuthorisationPDP(d.getDecision());;
	}

	public AbstractEvaluableElement(AuthorisationPDP d, TargetDecision m,
			List<AbstractFulfilledObligation> obls) {
		this.m = m;
		//NB attention to the pointer for obligations
		this.d = new AuthorisationPDP(d.getDecision());
		for (AbstractFulfilledObligation o : obls) {
			if (o.getEvaluatedOn().toString().equals(d.getDecision().toString()))
				this.d.addObligation(o);
		}
	}

	@Override
	public AuthorisationPDP evaluate(ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {
		return d;
	}

	@Override
	public TargetDecision getTargetDecision(ContextRequest cxtRequest) {
		return m;
	}

}
