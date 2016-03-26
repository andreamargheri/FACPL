/**
 * 
 */
package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;

/**
 * @author Andrea Margheri
 *
 */
public class FulfilledObligationStatus extends AbstractFulfilledObligation {
	/*
	 * this obligation contains an IExpressionFunctionStatus-type object that
	 * will modify the status attribute
	 */
	private IExpressionFunctionStatus pepFunction;

	public FulfilledObligationStatus(Effect effect, ObligationType typeObl, IExpressionFunctionStatus pepFunction) {
		super(effect, typeObl);
		this.pepFunction = pepFunction;
	}

	public FulfilledObligationStatus(Effect effect, ObligationType typeObl,
			Class<? extends IExpressionFunctionStatus> pepFunction) {
		super(effect, typeObl);

		// this.pepFunction = pepFunction;

	}

	@Override
	public AbstractFulfilledObligation evaluateObl(FacplStatus status) throws Throwable {
		// invoke the action in the object for status attribute modification
		this.pepFunction.evaluateFunction(status, this.getArgsStatus());
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
