package it.unifi.facpl.system;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.algorithm.check.DenyOverridesCheck;
import it.unifi.facpl.lib.algorithm.check.IEvaluableAlgorithmCheck;
import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;

public class PEPCheck extends PEP {
	private List<FulfilledObligationCheck> checkObl;
	protected IEvaluableAlgorithmCheck checkAlg;
	private PDP pdp;
	private AuthorisationPDP authPDP;

	public PEPCheck(EnforcementAlgorithm alg, PDP pdp) {
		super(alg);
		checkObl = new LinkedList<FulfilledObligationCheck>();
		checkAlg = new DenyOverridesCheck(); // default algorithm
		this.pdp = pdp;
		authPDP = null;

	}

	public PEPCheck(EnforcementAlgorithm alg, IEvaluableAlgorithmCheck combiningAlgorithm, PDP pdp) {
		super(alg);
		checkObl = new LinkedList<FulfilledObligationCheck>();
		checkAlg = combiningAlgorithm;
		this.pdp = pdp;
		authPDP = null;

	}

	public AuthorisationPEP doAuthorisation(ContextRequest cxtReq) {
		/*
		 * authorisation: if number of check obligation == 0 -> PDP evaluation
		 * -> PEP Enforcement otherwise -> PEP Evaluation
		 */
		Logger l = LoggerFactory.getLogger(PEPCheck.class);
		AuthorisationPEP result;
		if (checkObl.size() == 0) {
			/*
			 * PDP Evaluation -> PEP ENFORCEMENT
			 */
			l.debug("NUMBER OF CHECK OBLIGATION: 0 -> AUTHORISATION BY PDP -> ENFORCEMENT BY PEP");
			authPDP = pdp.doAuthorisation(cxtReq);
			return this.doEnforcement(authPDP);
		} else {
			/*
			 * PEP EVALUATION
			 */
			l.debug("NUMBER OF CHECK OBLIGATION: " + checkObl.size() + " -> EVALUATING CHECK OBLIGATION");
			result = this.doPEPCheck(cxtReq);

			l.debug("CHECK RESULT: " + result.getDecision());
			if (result.getDecision() == StandardDecision.PERMIT || result.getDecision() == StandardDecision.DENY) {
				return result;
			} else {
				/*
				 * if check obligation returns an error -> PDP Evaluation -> PEP
				 * Enforcement
				 */
				l.debug("BACK TO PDP");
				authPDP = pdp.doAuthorisation(cxtReq);
				this.clearAllObligations();
				return this.doEnforcement(authPDP);

			}

		}

	}

	@Override
	public AuthorisationPEP doEnforcement(AuthorisationPDP authPDP) {
		/*
		 * normal PEP enforcement + addiction of CheckObligation
		 */
		AuthorisationPEP first_enforcement;
		Logger l = LoggerFactory.getLogger(PEPCheck.class);
		first_enforcement = super.doEnforcement(authPDP); // enforcement
		l.debug("FIRST ENFORCEMENT COMPLETED, DECISION: " + first_enforcement.getDecision());
		if (first_enforcement.getDecision() != StandardDecision.PERMIT) {

			return new AuthorisationPEP(first_enforcement.getId(), first_enforcement.getDecision());
		}

		l.debug("ADDING CHECK OBLIGATION TO PEP...");
		Iterator<AbstractFulfilledObligation> iterator = authPDP.getObligationIterator();
		while (iterator.hasNext()) {
			AbstractFulfilledObligation o = iterator.next();
			if (o instanceof FulfilledObligationCheck) {
				FulfilledObligationCheck temp = null;
				try {
					temp = (FulfilledObligationCheck) ((FulfilledObligationCheck) o).clone();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
				if (!checkObl.contains(temp)) {
					l.debug("ADDED: " + temp);
					checkObl.add(temp);
				}
			}
		}
		l.debug("...CHECK OBLIGATION ADDED");
		return first_enforcement;

	}

	private AuthorisationPEP doPEPCheck(ContextRequest ctxRequest) {
		/*
		 * evaluate check obligation
		 */
		Logger l = LoggerFactory.getLogger(PEPCheck.class);
		l.debug("DOING PEP CHECK:");
		AuthorisationPEP r = new AuthorisationPEP();
		if (checkObl.size() > 0) {
			LinkedList<StandardDecision> decisionList = new LinkedList<StandardDecision>();
			for (FulfilledObligationCheck obl : checkObl) {
				StandardDecision dec = obl.getObligationResult(ctxRequest);
				decisionList.add(dec);
				if (StandardDecision.NOT_APPLICABLE.equals(dec)) {
					r.setDecision(StandardDecision.NOT_APPLICABLE);
					return r;
				}
			}
			r = checkAlg.evaluate(decisionList, ctxRequest);
			checkAlg.resetAlg();
			return r;
		}
		return null;
	}

	private void clearAllObligations() {
		LoggerFactory.getLogger(PEPCheck.class).debug("RESET ALL CHECK OBLIGATION");
		this.checkObl = new LinkedList<FulfilledObligationCheck>();
	}

}
