/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
package it.unifi.facpl.system;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.enums.StandardDecision;
import it.unifi.facpl.lib.interfaces.IPepAction;

/**
 * 
 * @author Andrea Margheri Discharging of Fulfilled Obligation and
 *         Implementation of Enforcement Algorithms
 */
public class PEP {

	// Reference to Classes modeling Obligation Actions
	private static HashMap<String, IPepAction> pepAction;

	private EnforcementAlgorithm alg;

	public PEP(EnforcementAlgorithm alg) {
		this.alg = alg;
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
					for (FulfilledObligation obl : authPDP.getObligation()) {
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
					for (FulfilledObligation obl : authPDP.getObligation()) {
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
					for (FulfilledObligation obl : authPDP.getObligation()) {
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
	private void dischargeObligation(FulfilledObligation obl) throws Throwable {
		Logger l = LoggerFactory.getLogger(PEP.class);
		try {
			// discharge obligation
			// retrieve pepActionClass
			IPepAction classAction = pepAction.get(obl.getPepAction());

			if (classAction == null) {
				l.debug("Undefined PEP action \"" + obl.getPepAction() + "\"");
				throw new Exception("Undefined " + obl.getPepAction() + " PEP Action");
			}

			classAction.eval(obl.getArguments());

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

	public void addPEPActions(HashMap<String, IPepAction> classPepActions) {
		Logger l = LoggerFactory.getLogger(PEP.class);
		l.debug("Add standard actions");

		pepAction = new HashMap<String, IPepAction>();
		pepAction.put("mail", new it.unifi.facpl.lib.pepFunction.MailTo());
		pepAction.put("log", new it.unifi.facpl.lib.pepFunction.Log());
		pepAction.put("compress", new it.unifi.facpl.lib.pepFunction.Compress());

		if (classPepActions != null) {
			for (String key : classPepActions.keySet()) {
				l.debug("Add action " + key);
			}
			pepAction.putAll(classPepActions);
		}

	}

}
