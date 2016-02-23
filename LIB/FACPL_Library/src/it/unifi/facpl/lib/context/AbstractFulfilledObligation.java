package it.unifi.facpl.lib.context;

import java.util.LinkedList;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;

/**
 * 
 * @author Andrea Obligation gia valutata dal PDP
 */
public abstract class AbstractFulfilledObligation {

	protected Effect evaluatedOn;
	protected ObligationType type;
	protected LinkedList<Object> arguments;
	protected LinkedList<Object> argsStatus;
	/*
	 * questa e' l'obbligation valutata astratta bisogna differenziare tra
	 * obbligation fullfilled di stato e obbligation fullfilled NON di stato
	 * implementare il metodo evaluateObl()
	 */

	public AbstractFulfilledObligation(Effect effect, ObligationType typeObl) {
		this.type = typeObl;
		this.evaluatedOn = effect;
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

	public abstract Object getPepAction();

	public LinkedList<Object> getArguments() {
		return arguments;
	}

	public LinkedList<Object> getArgsStatus() {
		return argsStatus;
	}

	/**
	 * Eval by PEP
	 * 
	 * @return
	 */
	public abstract AbstractFulfilledObligation evaluateObl() throws Throwable;

}
