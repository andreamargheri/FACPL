package it.unifi.facpl.system;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.context.FulfilledObligationStatus;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IPepAction;
import it.unifi.facpl.lib.policy.FacplPolicy;

/**
 * 
 * @author Andrea Margheri Standard PDP supporting top-level combining
 *         algorithm. (Standard authorisation decision is returned) Standard PEP
 *         supporting enforcement of PDP authorisation
 * 
 */
public class FacplAuthorisationSystem {

	
	/**
	 * PDP Evaluation
	 * 
	 * @param algCombining
	 *            top-level combining algorithm
	 * @param elements
	 *            Policies defining the PDP
	 * @param cxtReq
	 *            Request to Evaluate
	 * @param extendedIndeterminate
	 *            If extendedIndeterminate has to be evaluated
	 * @return Authorisation calculated by the PDP based on the four-valued
	 *         authorisation
	 */
	public static AuthorisationPDP doAuthorisation(Class<? extends IEvaluableAlgorithm> algCombining,
			List<FacplPolicy> elements, ContextRequest cxtReq, Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(FacplAuthorisationSystem.class);

		l.debug("-------------------------------------");
		l.debug("PDP Evaluation of request: " + cxtReq.getRequest().getId() + " started...");

		try {

			// Invoking Combining Algorithm defining PDP
			Class<?> params[] = new Class[3];
			params[0] = List.class;
			params[1] = ContextRequest.class;
			params[2] = Boolean.class;

			Method eval = algCombining.getDeclaredMethod("evaluate", params);

			l.debug("Loading combining algorithm PDP: " + eval.getName());
			Object alg = algCombining.newInstance();

			AuthorisationPDP dr = new AuthorisationPDP();
			dr = (AuthorisationPDP) eval.invoke(alg, elements, cxtReq, extendedIndeterminate);
			dr.setId(cxtReq.getRequest().getId());

			l.debug("...PDP Evaluation of request " + cxtReq.getRequest().getId() + " completed. PDP decision: "
					+ dr.toString());

			l.debug("--------------------------------");

			return dr;

		} catch (Exception e) {
			l.debug("PDP catch unexpected exception");
			l.debug(e.getMessage().toString());
			return null;
		}

	}

	/**
	 * PEP Enforcement
	 * 
	 * @param alg
	 *            Enforcement Algorithm
	 * @param authPDP
	 *            Authorisation to enforce
	 * @return
	 */
	public static AuthorisationPEP doEnforcement(String alg, AuthorisationPDP authPDP) {
		
		return PEP.doEnforcement(alg, authPDP);
	
		
	}
	

	/**
	 * Initialise PEP Actions
	 * 
	 * @param classPepActions
	 */
	public static void inizializePepActions(HashMap<String, Class<? extends IPepAction>> pepActions) {
		
		PEP.addPEPActions(pepActions);
		
	}
	
}
