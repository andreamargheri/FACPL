package it.unifi.facpl.system;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.context.FulfilledObligationCheck;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;

public class PEPCheck extends PEP {
	private ContextRequest_Status ctxRequest;
	private List<FulfilledObligationCheck> checkObl;

	public PEPCheck(EnforcementAlgorithm alg, IEvaluableAlgorithm combiningAlgorithm,
			ContextRequest_Status ctxRequest) {
		super(alg);
		this.ctxRequest = ctxRequest;
		checkObl = new LinkedList<FulfilledObligationCheck>();
	}

	/*
	 * TODO: CHIEDERE COME COMPORTARSI IN BASE A DENY BIASED, PERMIT BIASED E
	 * BASE
	 * 
	 */
	@Override
	public AuthorisationPEP doEnforcement(AuthorisationPDP authPDP) {
		AuthorisationPEP first_enforcement;
		first_enforcement = super.doEnforcement(authPDP); // enforcement
		if (first_enforcement.getDecision() != StandardDecision.PERMIT) {
			return first_enforcement;
		}
		if (checkObl.size() == 0) {
			Iterator<AbstractFulfilledObligation> iterator = authPDP.getObligationIterator();
			while (iterator.hasNext()) {
				AbstractFulfilledObligation o = iterator.next();
				if (o instanceof FulfilledObligationCheck) {
					checkObl.add((FulfilledObligationCheck) o);
				}
			}
		}
		/*
		 * soluzione temporanea prima del combining algorithm TODO: TROVARE UN
		 * MODO DI USARE IL COMBINING ALGORITHM GIA' ESISTENTE PER COMBINARE LE
		 * DECISIONI
		 * 
		 */
		boolean tempDecision = true;
		for (FulfilledObligationCheck o : checkObl) {
			try {
				ExpressionValue value = o.getObligationResult(ctxRequest);
				if (value != ExpressionValue.TRUE) {
					tempDecision = false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!tempDecision) {
			return first_enforcement;
		} else {
			return new AuthorisationPEP(first_enforcement.getId(), StandardDecision.PERMIT, true);
		}

		/*
		 * fine soluzione temporanea
		 */

	}

}
