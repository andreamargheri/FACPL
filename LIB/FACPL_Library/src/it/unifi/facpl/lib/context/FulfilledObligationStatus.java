/**
 * 
 */
package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;

/**
 * @author Andrea Margheri
 *
 */
public class FulfilledObligationStatus extends AbstractFulfilledObligation {

	private IExpressionFunctionStatus pepFunction;
	
	public FulfilledObligationStatus(Effect effect, ObligationType typeObl, IExpressionFunctionStatus pepFunction) {
		super(effect, typeObl);
		this.pepFunction = pepFunction;
	}
	
	public FulfilledObligationStatus(Effect effect, ObligationType typeObl, Class < ? extends IExpressionFunctionStatus > pepFunction) {
		super(effect, typeObl);
		
//		this.pepFunction = pepFunction;
		
	}

	@Override
	public AbstractFulfilledObligation evaluateObl() throws Throwable {
		this.pepFunction.evaluateFunction(this.getArgsStatus()); 
		return this;
	}
	@Override
	public String toString() {
		return evaluatedOn + " " + type.toString() + " " + pepFunction.toString() + "(" + arguments.toString() + ")";
	}


	@Override
	public Object getPepAction() {
		return this.pepFunction;
	}


}
