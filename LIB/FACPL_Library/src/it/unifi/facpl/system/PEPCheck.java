package it.unifi.facpl.system;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		Logger l = LoggerFactory.getLogger(PEPCheck.class);
		first_enforcement = super.doEnforcement(authPDP); // enforcement
		l.debug("FIRST ENFORCEMENT COMPLETED, DECISION: " + first_enforcement.getDecision());
		if (first_enforcement.getDecision() != StandardDecision.PERMIT) {

			return new AuthorisationPEP(first_enforcement.getId(), first_enforcement.getDecision(), false);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// checkObl.add((FulfilledObligationCheck) o);
				if (!checkObl.contains(temp)) {
					l.debug("ADDED: " + temp);
					checkObl.add(temp);
					// } else if (checkObl.contains(temp) &&
					// checkObl.get(checkObl.indexOf(temp)).hasExpired()) {
					// l.debug("ADDED: "+temp);
					// checkObl.add(temp);
					// }
				}
			}
		}
		l.debug("...CHECK OBLIGATION ADDED");
		/*
		 * soluzione temporanea prima del combining algorithm TODO: TROVARE UN
		 * MODO DI USARE IL COMBINING ALGORITHM GIA' ESISTENTE PER COMBINARE LE
		 * DECISIONI
		 * 
		 */
		boolean pass = true;
		List<Integer> reAdd = new LinkedList<Integer>();
		for (FulfilledObligationCheck o1 : checkObl) {
			try {
				if (!o1.hasExpired()) {
					ExpressionValue value = o1.getObligationResult(ctxRequest);
					if (value != ExpressionValue.TRUE) {
						pass = false;
					} else {
						o1.subExpiration(1);
						if (o1.hasExpired()) {
							reAdd.add(checkObl.indexOf(o1));
							pass = false;
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i : reAdd) {
			try {
				checkObl.add((FulfilledObligationCheck) checkObl.get(i).clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!pass) {
			return new AuthorisationPEP(first_enforcement.getId(), first_enforcement.getDecision(), pass);
		} else {
			return new AuthorisationPEP(first_enforcement.getId(), StandardDecision.PERMIT, pass);
		}

		/*
		 * fine soluzione temporanea
		 */

	}

}
