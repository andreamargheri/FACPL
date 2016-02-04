package it.unifi.facpl.lib.context;

import java.util.LinkedList;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.interfaces.IExpressionFunction;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;

/**
 * 
 * @author Andrea
 * Obligation gia valutata dal PDP
 */
public abstract class AbstractFulfilledObligation {

	protected Effect evaluatedOn;
	protected ObligationType type;
	protected LinkedList<Object> arguments;
	protected IExpressionFunctionStatus pepAction; //dare un tipo a questo
	protected StatusAttribute s;
	/*
	 * questa e' l'obbligation valutata astratta
	 * bisogna differenziare tra obbligation fullfilled di stato e obbligation fullfilled NON di stato
	 * implementare il metodo evaluateObl()
	 */
	
	public AbstractFulfilledObligation(Effect effect, ObligationType typeObl, IExpressionFunctionStatus pepAction) {
		this.type = typeObl;
		this.evaluatedOn = effect;
		this.pepAction = pepAction;
		this.arguments = new LinkedList<Object>();
	}
	
	public AbstractFulfilledObligation() {
		
	}
	
	public abstract void setStatusAttribute(StatusAttribute s) throws Exception;

	public void addArg(Object object){
		if (this.arguments == null){
			this.arguments = new LinkedList<Object>();
		}
		this.arguments.add(object);
	}
	
	public Effect getEvaluatedOn() {
		return evaluatedOn;
	}
	public ObligationType getType() {
		return type;
	}
	public IExpressionFunctionStatus getPepAction() {
		return pepAction;
	}
	public LinkedList<Object> getArguments() {
		return arguments;
	}
	
	@Override
	public String toString() {
		return evaluatedOn + " " + type.toString() + " " + pepAction.toString() + "(" + arguments.toString() + ")";
	}
	
	/**
	 * Eval by PEP
	 * @return
	 */
	public abstract AbstractFulfilledObligation evaluateObl() throws Throwable;
	
	
}
