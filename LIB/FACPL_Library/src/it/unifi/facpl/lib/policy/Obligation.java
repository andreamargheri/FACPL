package it.unifi.facpl.lib.policy;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FullfilledObbligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.interfaces.IObligationElement;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

/**
 *
 * @author Andrea Margheri
 * Obligation of Policies (to be fulfilled)
 */
public class Obligation implements IObligationElement{

	private Effect evaluatedOn;

	private ObligationType typeObl;

	private String pepFunction;

	private LinkedList<Object> argsFunction; //ExpresisonBooleanTree, Expression,  Attribute Names, Literals

	public Obligation(String pepFunction,Effect evaluatedOn, ObligationType type, Object...args){
		this.pepFunction = pepFunction;
		this.evaluatedOn = evaluatedOn;
		this.typeObl = type;
		this.argsFunction = new LinkedList<Object>();
		if (args != null){
			for (Object ob : args) {
				argsFunction.add(ob);
			}
		}
	}

	@Override
	public AbstractFulfilledObligation getObligationValue(ContextRequest cxtRequest) throws FulfillmentFailed { 
		Logger l = LoggerFactory.getLogger(Obligation.class);
	
		l.debug("Fulfilling Obligation " +this.pepFunction.toString() + "...");
		//AbstractFulfilledObligation obl = new FullfilledObbligation(this.evaluatedOn,this.typeObl,this.pepFunction);
		AbstractFulfilledObligation obl = new FullfilledObbligation(this.evaluatedOn,this.typeObl,this.pepFunction);

		//Fulfill arguments for PEP Function
		for (Object arg : argsFunction) {
			if (arg instanceof ExpressionFunction){
				
				//Evaluation of expression
				Object res = ((ExpressionFunction)arg).evaluateExpression(cxtRequest);
				
				if (res.equals(ExpressionValue.BOTTOM) || res.equals(ExpressionValue.ERROR)){
					//Fulfillment of Obligation failed
					throw new FulfillmentFailed();
				}
				//Evaluation ok -> add value in the arguments
				obl.addArg(res);
				
			}else if (arg instanceof ExpressionBooleanTree){	
				
				//Evaluation of boolean expression
				ExpressionValue res = ((ExpressionBooleanTree)arg).evaluateExpressionTree(cxtRequest);
				
				if (res.equals(ExpressionValue.BOTTOM) || res.equals(ExpressionValue.ERROR)){
					//Fulfillment of Obligation failed
					throw new FulfillmentFailed();
				}
				//Evaluation ok -> add value in the arguments
				obl.addArg(res);
						
			}else if (arg instanceof AttributeName){
				try {
					//attribute to be retrieved
					obl.addArg(cxtRequest.getContextRequestValues((AttributeName) arg));
				} catch (MissingAttributeException e) {
					//Fulfillment of Obligation failed
					throw new FulfillmentFailed();
				}
				
			}else{
				//literal to be directly added as argument
				obl.addArg(arg);
			}
		}
		
		l.debug("...fulfillment completed. Arguments: " + obl.getArguments().toString());
		
		return obl;
	}

	public Effect getEvaluatedOn() {
		return evaluatedOn;
	}

	public ObligationType getTypeObl() {
		return typeObl;
	}

}
