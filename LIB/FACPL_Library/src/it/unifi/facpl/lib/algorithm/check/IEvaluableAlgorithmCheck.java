package it.unifi.facpl.lib.algorithm.check;

import java.util.List;

import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.StandardDecision;

public interface IEvaluableAlgorithmCheck {

	AuthorisationPEP evaluate(List<StandardDecision> checkObl, ContextRequest cxtRequest);
	public void resetAlg();
}
