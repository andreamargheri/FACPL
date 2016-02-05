package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;

public class FullfilledObbligation extends AbstractFulfilledObligation {

	
	public FullfilledObbligation(Effect effect, ObligationType typeObl, IExpressionFunctionStatus pepAction) {
		super(effect, typeObl, pepAction);
	}
	@Override
	public AbstractFulfilledObligation evaluateObl() throws Exception {
		throw new Exception("it's not a status obbligation"); 
	}
//	@Override
//	public void setStatusAttribute(StatusAttribute s) throws Exception {
//		throw new Exception("it's not a status obbligation"); 
//		
//	}

}
