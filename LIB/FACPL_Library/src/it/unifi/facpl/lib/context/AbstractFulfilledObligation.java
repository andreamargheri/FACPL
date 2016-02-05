package it.unifi.facpl.lib.context;

import java.util.LinkedList;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.system.status.function.arithmetic.evaluator.IExpressionFunctionStatus;

/**
 * 
 * @author Andrea Obligation gia valutata dal PDP
 */
public abstract class AbstractFulfilledObligation {

	protected Effect evaluatedOn;
	protected ObligationType type;
	protected LinkedList<Object> arguments;
	protected IExpressionFunctionStatus pepFunction;
	protected String pepAction;
	protected LinkedList<Object> argsStatus;
	/*
	 * questa e' l'obbligation valutata astratta bisogna differenziare tra
	 * obbligation fullfilled di stato e obbligation fullfilled NON di stato
	 * implementare il metodo evaluateObl()
	 */

	public AbstractFulfilledObligation(Effect effect, ObligationType typeObl, IExpressionFunctionStatus pepAction) {
		this.type = typeObl;
		this.evaluatedOn = effect;
		this.pepFunction = pepAction;
		this.arguments = new LinkedList<Object>();
	}

	public AbstractFulfilledObligation(Effect effect, ObligationType typeObl, String pepAction) {
		this.type = typeObl;
		this.evaluatedOn = effect;
		this.pepAction = pepAction;
		this.arguments = new LinkedList<Object>();
	}

	public AbstractFulfilledObligation() {

	}

	public void addArg(Object object) {
		if (this.arguments == null) {
			this.arguments = new LinkedList<Object>();
		}
		this.arguments.add(object);
	}

	public void addArgStatus(LinkedList<Object> ob) {
		if (this.argsStatus == null) {
			this.argsStatus = new LinkedList<Object>();
		}
		this.argsStatus = ob;
	}

	public Effect getEvaluatedOn() {
		return evaluatedOn;
	}

	public ObligationType getType() {
		return type;
	}

	public IExpressionFunctionStatus getPepAction() {
		return pepFunction;
	}

	public LinkedList<Object> getArguments() {
		return arguments;
	}

	public LinkedList<Object> getArgsStatus() {
		return argsStatus;
	}

	@Override
	public String toString() {
		return evaluatedOn + " " + type.toString() + " " + pepFunction.toString() + "(" + arguments.toString() + ")";
	}

	/**
	 * Eval by PEP
	 * 
	 * @return
	 */
	public abstract AbstractFulfilledObligation evaluateObl() throws Throwable;

}
