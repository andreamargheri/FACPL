package it.unifi.facpl.lib.algorithm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

/**
 * 
 * @author Andrea Margheri
 *
 */
public class FirstApplicable implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(FirstApplicable.class);
		l.debug("-> FIRST APPLICABLE started");

		AuthorisationPDP dr = new AuthorisationPDP();

		for (IEvaluablePolicy el : elements) {
			dr = el.evaluate(cxtRequest, extendedIndeterminate);
			if (dr.getDecision().equals(ExtendedDecision.DENY)) {
				l.debug("First Applicable END - Result DENY");
				return dr;
			}
			if (dr.getDecision().equals(ExtendedDecision.PERMIT)) {
				l.debug("First Applicable END - Result PERMIT");
				return dr;
			}
			if (dr.getDecision().equals(ExtendedDecision.NOT_APPLICABLE)) {
				l.debug("First Applicable Continue - Element NOT APPLICABLE, continue");
				continue;
			}
			if (dr.getDecision().equals(ExtendedDecision.INDETERMINATE_D)
					|| dr.getDecision().equals(ExtendedDecision.INDETERMINATE_P)
					|| dr.getDecision().equals(ExtendedDecision.INDETERMINATE_DP)) {
				l.debug("First Applicable END - Result INDETERMINATE");
				return dr;
			}
		}
		dr.setDecision(ExtendedDecision.NOT_APPLICABLE);
		l.debug("First Applicable END - Result NOT_APP");
		return dr;
	}

}
