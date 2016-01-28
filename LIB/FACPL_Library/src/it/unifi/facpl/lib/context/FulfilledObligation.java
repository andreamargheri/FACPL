package it.unifi.facpl.lib.context;

import java.util.LinkedList;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;

/**
 * 
 * @author Andrea
 * Obligation gia valutata dal PDP
 */
public class FulfilledObligation {

	protected Effect evaluatedOn;
	protected ObligationType type;
	protected LinkedList<Object> arguments;
	private String pepAction;
	
	
	public FulfilledObligation(Effect effect, ObligationType typeObl, String pepAction) {
		this.type = typeObl;
		this.evaluatedOn = effect;
		this.pepAction = pepAction;
		this.arguments = new LinkedList<Object>();
	}
	
	public FulfilledObligation() {
		// TODO Auto-generated constructor stub
	}

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
	public String getPepAction() {
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
	public FulfilledObligation evaluateObl() {
		// Esegue l'azione del PEP
		return null;
	}
	
	
}
