/**
 * 
 */
package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;

/**
 * @author Andrea Margheri
 *
 */
public class FulfilledObligationStatus extends AbstractFulfilledObligation {

	
	
	
	public FulfilledObligationStatus(Effect effect, ObligationType typeObl, IExpressionFunctionStatus pepAction) {
		super(effect, typeObl, pepAction);
	}


	@Override
	public AbstractFulfilledObligation evaluateObl() throws Throwable {
		this.pepAction.evaluateFunction(this.getArgsStatus()); 
		return this;
	}


}
