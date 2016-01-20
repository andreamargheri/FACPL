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

	// Reference to Classes modeling Obligation Actions
	private static HashMap<String, Class<? extends IPepAction>> pepAction;

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
		Logger l = LoggerFactory.getLogger(PEP.class);
		l.debug("Start PEP enforcement for request: " + authPDP.getId());
		l.debug("Authorisation to enforce: " + authPDP.toString());
		if (pepAction == null) {
			l.debug("Pep actions not inizialized");
			// inizializePepAction();
		}
		try {
			AuthorisationPEP decPEP;
			if (alg.equals("base")) {
				l.debug("Chosen Enforcement Algorithm " + alg.toString());
				StandardDecision dec = authPDP.getStandardDecision();
				if (dec.equals(StandardDecision.DENY) || dec.equals(StandardDecision.PERMIT)) {
					for (FulfilledObligation obl : authPDP.getObligation()) {
						// if any error throw exception
						try {
							dischargeObligations(obl);
						} catch (Throwable t) {
							// t.printStackTrace();
							l.debug("Obligation Evaluation Failed");
							// return indeterminate when for permit or deny
							// decision obligations discharging is not
							// successful
							l.debug("Enforced Decision:" + StandardDecision.INDETERMINATE);
							return new AuthorisationPEP(authPDP.getId(), StandardDecision.INDETERMINATE);
						}
					}
					// all obligation ok. stay the same deny or permit decision
					decPEP = new AuthorisationPEP(authPDP.getId(), dec);
				} else {
					// indet or notapp decision
					l.debug("No Obligations to discharge. Enforcement completed");
					decPEP = new AuthorisationPEP(authPDP.getId(), dec);
				}
			} else if (alg.equals("deny-biased")) {
				l.debug("Chosen Enforcement Algorithm " + alg.toString());
				StandardDecision dec = authPDP.getStandardDecision();
				// permit -> eval obligations
				// otherwise or error -> return deny
				if (dec.equals(StandardDecision.PERMIT)) {
					for (FulfilledObligation obl : authPDP.getObligation()) {
						try {
							// if any error throw exception
							dischargeObligations(obl);
						} catch (Throwable t) {
							// t.printStackTrace();
							l.debug("Obligation Evaluation Failed");
							// return deny in all cases of error
							l.debug("Enforced Decision:" + StandardDecision.DENY);
							return new AuthorisationPEP(authPDP.getId(), StandardDecision.DENY);
						}
					}
					// all obligation ok. return permit
					decPEP = new AuthorisationPEP(authPDP.getId(), dec);
				} else {
					// deny or indet or notapp decision -> return deny
					l.debug("No Obligations to discharge. Enforcement completed");
					decPEP = new AuthorisationPEP(authPDP.getId(), StandardDecision.DENY);
				}
			} else if (alg.equals("permit-biased")) {
				l.debug("Chosen Enforcement Algorithm " + alg.toString());
				StandardDecision dec = authPDP.getStandardDecision();
				// deny -> eval obligations
				// otherwise or error -> return permit
				if (dec.equals(StandardDecision.DENY)) {
					for (FulfilledObligation obl : authPDP.getObligation()) {
						try {
							// if any error throw exception
							dischargeObligations(obl);
						} catch (Throwable t) {
							// t.printStackTrace();
							l.debug("Obligations Evaluation Failed");
							// return deny in all cases of error
							l.debug("Enforced Decision:" + StandardDecision.PERMIT);
							return new AuthorisationPEP(authPDP.getId(), StandardDecision.PERMIT);
						}
					}
					// all obligation ok. return deny
					decPEP = new AuthorisationPEP(authPDP.getId(), dec);
				} else {
					// permit or indet or notapp decision -> return permit
					l.debug("No Obligations to discharge. Enforcement completed");
					decPEP = new AuthorisationPEP(authPDP.getId(), StandardDecision.PERMIT);
				}
			} else {
				throw new Exception("Undefined PEP Algorithm");
			}

			l.debug("Enforced Decision:" + decPEP.toString());
			return decPEP;
		} catch (Throwable t) {
			// return indeterminate for undefined algorithm or others
			l.debug("Unhandled Exception. Enforced Decision: INDETERMINATE");
			return new AuthorisationPEP(authPDP.getId(), StandardDecision.INDETERMINATE);
		}
	}

	/**
	 * Discharge Single FulfilledObligation
	 * 
	 * @param obl
	 * @throws Throwable
	 */
	private static void dischargeObligations(FulfilledObligation obl) throws Throwable {
		Logger l = LoggerFactory.getLogger(PEP.class);
		try {
			// discharge obligation
			// retrieve pepActionClass
			Class<? extends IPepAction> classAction = pepAction.get(obl.getPepAction());

			if (classAction == null) {
				l.debug("Undefined PEP action \"" + obl.getPepAction() + "\"");

				throw new Exception("Undefined " + obl.getPepAction() + " PEP Action");
			}

			Class<?> params[] = new Class[1];
			params[0] = List.class;

			Method eval = classAction.getDeclaredMethod("eval", params);

			Object pepAction = classAction.newInstance();

			eval.invoke(pepAction, obl.getArguments());

		} catch (Throwable t) {
			// check type of obligation for enforcement error
			// t.printStackTrace();
			if (obl.getType().equals(ObligationType.M)) {
				// if mandatory re-throw exception
				throw t;
			}
			l.debug("Exception ignored. Obligation is optional");
		}
	}

	/**
	 * Initialise PEP Actions
	 * 
	 * @param classPepActions
	 */
	public static void inizializePepActions(Class<?> classPepActions) {
		Logger l = LoggerFactory.getLogger(PEP.class);
		l.debug("Add standard actions");
		pepAction = new HashMap<String, Class<? extends IPepAction>>();
		pepAction.put("mail", it.unifi.facpl.lib.pepFunction.MailTo.class);
		pepAction.put("log", it.unifi.facpl.lib.pepFunction.Log.class);
		pepAction.put("compress", it.unifi.facpl.lib.pepFunction.Compress.class);

		// load from custom file PepAction
		try {

			Class<?> params[] = new Class[0];

			Method eval = classPepActions.getDeclaredMethod("addPepActions", params);

			Object pepAction = classPepActions.newInstance();

			@SuppressWarnings("all")
			HashMap<String, Class<? extends IPepAction>> hash = (HashMap<String, Class<? extends IPepAction>>) eval
					.invoke(pepAction, null);
			if (hash != null) {
				FacplAuthorisationSystem.pepAction.putAll(hash);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
