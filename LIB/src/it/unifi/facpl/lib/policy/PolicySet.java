package it.unifi.facpl.lib.policy;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;

public abstract class PolicySet extends FacplPolicy {

	private LinkedList<FacplPolicy> polElements;

	private Class<? extends IEvaluableAlgorithm> algCombining;

	protected void addCombiningAlg(Class<? extends IEvaluableAlgorithm> alg) {
		Logger l = LoggerFactory.getLogger(PolicySet.class);
		l.debug(idElement + ": Add combining Algorithm");

		this.algCombining = alg;
	}

	protected void addPolicyElement(FacplPolicy el) {
		if (this.polElements == null) {
			this.polElements = new LinkedList<FacplPolicy>();
		}
		this.polElements.add(el);
	}

	@Override
	public AuthorisationPDP evaluate(ContextRequest cxtRequest, Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(PolicySet.class);
		l.debug(idElement + ": Start policySet eval");
	
		AuthorisationPDP auth= new AuthorisationPDP();

		TargetDecision match_target = getTargetDecision(cxtRequest);

		switch (match_target) {
		case FALSE:
			auth.setDecision(ExtendedDecision.NOT_APPLICABLE);
			l.debug(idElement + ": End policy eval - " + auth.toString());
			return auth;

		case TRUE:
			Class<?> params[] = new Class[3];
			params[0] = List.class;
			params[1] = ContextRequest.class;
			params[2] = Boolean.class;

			try {

				Method eval = algCombining.getDeclaredMethod("evaluate", params);

				l.debug("Loading combining algorithm: " + algCombining.getName());
				Object alg = algCombining.newInstance();
				l.debug("Algorithm started on eval elements");

				auth = (AuthorisationPDP) eval.invoke(alg, this.polElements, cxtRequest, extendedIndeterminate);

			} catch (Exception e) {
				// catch expression from Obligation Fulfillment
				l.debug("Catch generic exception in policy set eval. Return INDETERMINATE DP");
				return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null);
			}

			/*
			 * OBLIGATION FULFILLMENT
			 */

			try {

				LinkedList<FulfilledObligation> listObl = null;
				if (auth.getDecision().equals(ExtendedDecision.PERMIT)) {
					listObl = this.evaluateObl(Effect.PERMIT, cxtRequest);
				} else if (auth.getDecision().equals(ExtendedDecision.DENY)) {
					listObl = this.evaluateObl(Effect.DENY, cxtRequest);
				}
				// addObligation to decision result (PolicySet's obligation)
				if (listObl != null) {
					auth.addObligation(listObl);
				}

			} catch (FulfillmentFailed f) {
				// catch expression from Obligation Fulfillment
				l.debug("Catch generic exception in policy set eval. Return INDETERMINATE");
				if (extendedIndeterminate) {
					if (auth.getDecision().equals(ExtendedDecision.PERMIT)) {
						return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_P, null);
					} else {
						return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_D, null);
					}
				} else {
					return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null);
				}
			}

			l.debug(idElement + ": End policySet eval - " + auth.toString());
			return auth;

		case INDETERMINATE:

			if (extendedIndeterminate) {
				l.debug("---------------------------------------");
				l.debug("Start Extended Indeterminate Evaluation");
				Class<?> paramsE[] = new Class[3];
				paramsE[0] = List.class;
				paramsE[1] = ContextRequest.class;
				paramsE[2] = Boolean.class;

				try {
					Method evalIndeterminate = algCombining.getDeclaredMethod("evaluate", paramsE);
					Object algIndet = algCombining.newInstance();

					auth = (AuthorisationPDP) evalIndeterminate.invoke(algIndet, this.polElements, cxtRequest,
							extendedIndeterminate);

				} catch (Exception e) {
					// catch exception from Obligation Fulfillment
					l.debug("Catch generic exception in policy set eval. Return INDETERMINATE DP");
					return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null);
				}

				// clear obligations
				auth.clearObligation();
				switch (auth.getDecision()) {
				case PERMIT:
					auth.setDecision(ExtendedDecision.INDETERMINATE_P);
					break;
				case DENY:
					auth.setDecision(ExtendedDecision.INDETERMINATE_D);
					break;
				case INDETERMINATE_D:
					auth.setDecision(ExtendedDecision.INDETERMINATE_D);
					break;
				case INDETERMINATE_P:
					auth.setDecision(ExtendedDecision.INDETERMINATE_P);
					break;
				case INDETERMINATE_DP:
					auth.setDecision(ExtendedDecision.INDETERMINATE_DP);
					break;
				case NOT_APPLICABLE:
					auth.setDecision(ExtendedDecision.NOT_APPLICABLE);
					break;
				}
				l.debug("End Extended Indeterminate Evaluation");
				l.debug("---------------------------------------");
			} else {
				// no other evaluation request
				auth.setDecision(ExtendedDecision.INDETERMINATE_DP);
			}
			l.debug(idElement + ": End policy eval - " + auth.toString());
			return auth;

		default: 
			//IMPOSSIBLE (present only for Java matter)
			return new AuthorisationPDP(ExtendedDecision.INDETERMINATE_DP, null); 
			
		}

	}

}
