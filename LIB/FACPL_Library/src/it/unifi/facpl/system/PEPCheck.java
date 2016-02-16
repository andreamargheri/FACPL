package it.unifi.facpl.system;

import java.util.LinkedList;

import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;
import it.unifi.facpl.lib.policy.ObligationCheck;

public class PEPCheck extends PEP {

	private LinkedList<ObligationCheck> checkObligationList;
	private IEvaluableAlgorithm combiningAlgorithm;
	public PEPCheck(EnforcementAlgorithm alg, IEvaluableAlgorithm combiningAlgorithm) {
		super(alg);
		this.checkObligationList = new LinkedList<ObligationCheck>();
		this.combiningAlgorithm = combiningAlgorithm;
	}

}
