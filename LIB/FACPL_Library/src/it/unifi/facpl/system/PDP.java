/**
 * 
 */
package it.unifi.facpl.system;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.policy.FacplPolicy;

/**
 * @author Andrea Margheri
 *
 */
public class PDP {

	private Class<? extends IEvaluableAlgorithm> algCombining;
	private List<FacplPolicy> policies;
	private Boolean extendedIndeterminate;

	public PDP(Class<? extends IEvaluableAlgorithm> algCombining, List<FacplPolicy> policies,
			Boolean extendedIndeterminate) {
		this.algCombining = algCombining;
		this.policies = policies;
		this.extendedIndeterminate = extendedIndeterminate;
	}

	/**
	 * PDP Evaluation
	 * 
	 * @param cxtReq
	 *            Request to Evaluate
	 */
	public AuthorisationPDP doAuthorisation(ContextRequest cxtReq) {

		Logger l = LoggerFactory.getLogger(PDP.class);

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
			
			/*
			 * DEBUG
			 */
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX DIOCANE XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println("alg "+alg);
			System.out.println("policies "+policies);
			System.out.println("cxtReq " +cxtReq);
			System.out.println("extendedIndeterminated "+extendedIndeterminate);
			//System.out.println("dr" + dr); -> NULL POINTER EXCEPTION
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX DIOCANE XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			
			/*
			 * DEBUG
			 */
			
			dr = (AuthorisationPDP) eval.invoke(alg, policies, cxtReq, extendedIndeterminate); 
			dr.setId(cxtReq.getRequest().getId());

			l.debug("...PDP Evaluation of request " + cxtReq.getRequest().getId() + " completed. PDP decision: "
					+ dr.toString());

			l.debug("--------------------------------");

			return dr;

		} catch (Exception e) {
			printStackTrace(e);
			l.debug("PDP catch unexpected exception");
			l.debug(e.getMessage().toString());
			return null;
		}

	}
	/*
	 * TODO: da cancellare -> per debug
	 */
	public static void printStackTrace(Throwable t) {
		System.out.println(t);
		for (StackTraceElement ste : t.getStackTrace()) {

			System.err.println("\tat " + ste);
		}
		Throwable cause = t.getCause();
		if (cause != null) {
			System.err.print("Caused by \r\n");
			printStackTrace(cause);
		}
	}

}
