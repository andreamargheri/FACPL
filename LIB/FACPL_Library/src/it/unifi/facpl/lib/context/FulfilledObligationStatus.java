/**
 * 
 */
package it.unifi.facpl.lib.context;

import java.awt.List;
import java.util.LinkedList;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;
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
//		StatusAttribute s = FacplStatus.getInstance().
//				getStatusAttribute((StatusAttribute)this.getArgsStatus().get(0));
//		LinkedList<Object> args = this.getArgsStatus();
//		args.set(0, s);
//		this.pepFunction.evaluateFunction(args);
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
