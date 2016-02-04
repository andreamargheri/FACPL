package it.unifi.facpl.system;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.lib.interfaces.IPepAction;
import it.unifi.facpl.system.status.FacplStatus;

/**
 * 
 * @author Andrea Margheri Discharging of Fulfilled Obligation and
 *         Implementation of Enforcement Algorithms
 */
public class PEP {

	// Reference to Classes modeling Obligation Actions
	private static HashMap<String, Class<? extends IPepAction>> pepAction;

	private EnforcementAlgorithm alg;
	private FacplStatus status;
	public PEP(EnforcementAlgorithm alg) {
		this.alg = alg;
		this.status = new FacplStatus("status");
	}
	public PEP(EnforcementAlgorithm alg, FacplStatus status) {
		this.alg = alg;
		this.status = status;
		
	}


	public AuthorisationPEP doEnforcement(AuthorisationPDP authPDP) {

		Logger l = LoggerFactory.getLogger(PEP.class);
		l.debug("Start PEP enforcement for request: " + authPDP.getId());
		l.debug("Authorisation to enforce: " + authPDP.toString());

		if (pepAction == null) {
			l.debug("Pep actions not inizialized");
			// inizializePepAction();
		}
		try {
			AuthorisationPEP decPEP = null;
			StandardDecision dec = authPDP.getStandardDecision();
			switch (this.alg) {
			case BASE:
				l.debug("Chosen Enforcement Algorithm " + alg.toString());

				if (dec.equals(StandardDecision.DENY) || dec.equals(StandardDecision.PERMIT)) {
					for (AbstractFulfilledObligation obl : authPDP.getObligation()) {
						// if any error throw exception
						try {
							this.dischargeObligation(obl);
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
				break;

			case DENY_BIASED:
				l.debug("Chosen Enforcement Algorithm " + alg.toString());
				// permit -> evaluate obligations
				// otherwise or error -> return deny

				if (dec.equals(StandardDecision.PERMIT)) {
					for (AbstractFulfilledObligation obl : authPDP.getObligation()) {
						try {
							// if any error throw exception
							this.dischargeObligation(obl);
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
				break;

			case PERMIT_BIASED:
				if (dec.equals(StandardDecision.DENY)) {
					for (AbstractFulfilledObligation obl : authPDP.getObligation()) {
						try {
							// if any error throw exception
							this.dischargeObligation(obl);
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
				break;
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
	private void dischargeObligation(AbstractFulfilledObligation obl) throws Throwable {
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

	public void addPEPActions(HashMap<String, Class<? extends IPepAction>> classPepActions) {
		Logger l = LoggerFactory.getLogger(PEP.class);
		l.debug("Add standard actions");

		pepAction = new HashMap<String, Class<? extends IPepAction>>();
		pepAction.put("mail", it.unifi.facpl.lib.pepFunction.MailTo.class);
		pepAction.put("log", it.unifi.facpl.lib.pepFunction.Log.class);
		pepAction.put("compress", it.unifi.facpl.lib.pepFunction.Compress.class);

		if (classPepActions != null) {
			for (String key : classPepActions.keySet()) {
				l.debug("Add action " + key);
			}
			pepAction.putAll(classPepActions);
		}

	}

}
