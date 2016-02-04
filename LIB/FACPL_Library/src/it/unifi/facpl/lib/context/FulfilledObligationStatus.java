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

	
	
	
	public FulfilledObligationStatus(Effect effect, ObligationType typeObl, IExpressionFunctionStatus pepAction, StatusAttribute s) {
		super(effect, typeObl, pepAction);
		this.s=s;
	}


	@Override
	public AbstractFulfilledObligation evaluateObl() throws Throwable {
		/*
		 * -vedere quali sono gli argomenti
		 * -gestire eccezione con try-catch nel caso di fallimento dell'operazione 
		 * (per ora viene spedita su)
		 */
		this.pepAction.evaluateFunction(this.getArguments()); //quali sono gli argomenti? ponzi ponzi popopo
		return this;
	}


	@Override
	public void setStatusAttribute(StatusAttribute s) throws Exception {
		this.s = s;
		
	}

}
