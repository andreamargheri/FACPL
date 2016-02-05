package it.unifi.facpl.lib.policy;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.FulfilledObligationStatus;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.interfaces.IObligationElement;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.FulfillmentFailed;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;

public class ObligationStatus implements IObligationElement {
	
	private Effect evaluatedOn;

	private ObligationType typeObl;
	/*
	 * aggiungere un tipo: [enum]
	 * 1: obbligation di stato
	 * 2: obbligation non di stato
	 * cambia la valutazione
	 */

	private IExpressionFunctionStatus pepAction;

	private LinkedList<Object> argsFunction; //ExpresisonBooleanTree, Expression,  Attribute Names, Literals ,Status Attribute
	private LinkedList<Object> argsStatus;
	
	public ObligationStatus(IExpressionFunctionStatus pepAction,Effect evaluatedOn, ObligationType type, Object...args){
		this.pepAction = pepAction;
		this.evaluatedOn = evaluatedOn;
		this.typeObl = type;
		this.argsFunction = new LinkedList<Object>();
		this.argsStatus = new LinkedList<Object>();
		if (args != null){
			for (Object ob : args) {
				if (ob instanceof StatusAttribute || ob instanceof Integer || ob instanceof Double || ob instanceof Boolean ){
					argsStatus.add(ob);
				}
				argsFunction.add(ob);
			}
		}
	}
	
	@Override
	public AbstractFulfilledObligation getObligationValue(ContextRequest cxtRequest) throws Throwable {
		Logger l = LoggerFactory.getLogger(Obligation.class);
		
		l.debug("Fulfilling Obligation " +this.pepAction.toString() + "...");
		//AbstractFulfilledObligation obl = new FullfilledObbligation(this.evaluatedOn,this.typeObl,this.pepAction);
		AbstractFulfilledObligation obl = new FulfilledObligationStatus(this.evaluatedOn,this.typeObl,this.pepAction); 
		if(!argsStatus.isEmpty()){
			obl.addArgStatus(argsStatus);
		}
		//da correggere dopo

		//Fulfill arguments for PEP Function
		for (Object arg : argsFunction) {
			if (arg instanceof ExpressionFunction){
				
				//Evaluation of expression
				Object res = ((ExpressionFunction)arg).evaluateExpression(cxtRequest);
				
				if (res.equals(ExpressionValue.BOTTOM) || res.equals(ExpressionValue.ERROR)){
					//Fulfillment of Obligation failed
					throw new FulfillmentFailed(); //eccezione semplice - no problem
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

	@Override
	public Effect getEvaluatedOn() {
		return evaluatedOn;
	}

	@Override
	public ObligationType getTypeObl() {
		return typeObl;
	}

}
