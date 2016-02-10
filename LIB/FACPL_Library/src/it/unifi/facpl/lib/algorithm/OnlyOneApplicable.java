package it.unifi.facpl.lib.algorithm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

/**
 * 
 * @author Andrea Marheri
 *
 */
public class OnlyOneApplicable implements IEvaluableAlgorithm {

	@Override
	public AuthorisationPDP evaluate(List<IEvaluablePolicy> elements, ContextRequest cxtRequest,
			Boolean extendedIndeterminate) {

		Logger l = LoggerFactory.getLogger(OnlyOneApplicable.class);
		l.debug("-> ONLY ONE APPLICABLE started");

		Boolean atLeastOne = false;
		IEvaluablePolicy selectedPolicy = null;
		TargetDecision appResult;

		AuthorisationPDP dr = new AuthorisationPDP();

		for (IEvaluablePolicy el : elements) {
			appResult = el.getTargetDecision(cxtRequest);

			if (appResult.equals(TargetDecision.INDETERMINATE)) {
				dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
				return dr;
			}
			if (appResult.equals(TargetDecision.TRUE)) {
				if (atLeastOne) {
					dr.setDecision(ExtendedDecision.INDETERMINATE_DP);
					return dr;
				} else {
					atLeastOne = true;
					selectedPolicy = el;
				}
			}
			if (appResult.equals(TargetDecision.FALSE)) {
				continue;
			}
		}
		if (atLeastOne) {
			l.debug("Only one policy applied. Returned its decision result");
			return selectedPolicy.evaluate(cxtRequest, extendedIndeterminate);
		} else {
			dr.setDecision(ExtendedDecision.NOT_APPLICABLE);
			l.debug("No policy applied");
			return dr;
		}

	}

}
