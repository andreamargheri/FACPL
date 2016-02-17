package it.unifi.facpl.system;

import java.util.Iterator;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.policy.ObligationCheck;

public class PEPCheck extends PEP {
	private ContextRequest_Status ctxRequest;

	public PEPCheck(EnforcementAlgorithm alg, IEvaluableAlgorithm combiningAlgorithm,
			ContextRequest_Status ctxRequest) {
		super(alg);
		this.ctxRequest = ctxRequest;
	}

	@Override
	public AuthorisationPEP doEnforcement(AuthorisationPDP authPDP) {
		AuthorisationPEP result, first_enforcement;
		first_enforcement = super.doEnforcement(authPDP); //enforcement classico 
		Iterator<ObligationCheck> iteratorCheck = authPDP.getIteratorCheck();
		/*
		 * soluzione temporanea prima del combining algorithm TODO: TROVARE UN
		 * MODO DI USARE IL COMBINING ALGORITHM GIA' ESISTENTE PER COMBINARE LE
		 * DECISIONI
		 * 
		 */
		boolean tempDecision = true;
		while (iteratorCheck.hasNext()) {
			ObligationCheck obl = iteratorCheck.next();
			try {
				if (obl.getObligationResult(ctxRequest) != ExpressionValue.TRUE) {
					tempDecision = false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (tempDecision == true && first_enforcement.getDecision() == StandardDecision.PERMIT) {
			result = new AuthorisationPEP(authPDP.getId(), StandardDecision.PERMIT);
		} else {
			result = new AuthorisationPEP(authPDP.getId(), StandardDecision.DENY);
		}

		/*
		 * fine soluzione temporanea
		 */

		return result;

	}

}
