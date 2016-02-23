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

	public PEPCheck(EnforcementAlgorithm alg, IEvaluableAlgorithm combiningAlgorithm, PDP pdp) {
		super(alg);
		checkObl = new LinkedList<FulfilledObligationCheck>();
		checkAlg = new DenyOverridesCheck(); // per ora si usa uno fissato
		this.pdp = pdp;
		authPDP = null;

	}

	public AuthorisationPEP doAuthorisation(ContextRequest cxtReq) {
		Logger l = LoggerFactory.getLogger(PEPCheck.class);
		AuthorisationPEP result;
		if (checkObl.size() == 0) {
			l.debug("NUMBER OF CHECK OBLIGATION: 0 -> AUTHORISATION BY PDP -> ENFORCEMENT BY PEP");
			authPDP = pdp.doAuthorisation(cxtReq);
			return this.doEnforcement(authPDP);
		} else {
			l.debug("NUMBER OF CHECK OBLIGATION: " + checkObl.size() + " -> EVALUATING CHECK OBLIGATION");
			result = this.doPEPCheck(cxtReq);

			l.debug("CHECK RESULT: " + result.getDecision());
			if (result.getDecision() == StandardDecision.PERMIT || result.getDecision() == StandardDecision.DENY) {
				return result;
			} else {
				l.debug("BACK TO PDP");
				authPDP = pdp.doAuthorisation(cxtReq);
				this.clearAllObligations();
				return this.doEnforcement(authPDP);

			}

		}

	}

	@Override
	public AuthorisationPEP doEnforcement(AuthorisationPDP authPDP) {
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
		Logger l = LoggerFactory.getLogger(PEPCheck.class);
		l.debug("DOING PEP CHECK:");
		if (checkObl.size() > 0) {
			return checkAlg.evaluate(checkObl, ctxRequest);
		}
		return null;
	}

	private void clearAllObligations() {
		LoggerFactory.getLogger(PEPCheck.class).debug("RESET ALL CHECK OBLIGATION");
		;
		this.checkObl = new LinkedList<FulfilledObligationCheck>();
	}

}
