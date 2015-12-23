package it.unifi.facpl.junit.util;

import java.util.LinkedList;
import java.util.List;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.FulfilledObligation;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.interfaces.IEvaluablePolicy;

public class EvaluableElementStub {

	private LinkedList<IEvaluablePolicy> elements;	

	public EvaluableElementStub() {
		this.elements = new LinkedList<IEvaluablePolicy>();
	}

	/**
	 * Create a set of AbstractEvaluableElements starting from a set of Decision. 
	 * @param dt
	 */
	public void setElements(List<AuthorisationPDP> dt) {
		for (AuthorisationPDP d : dt) {
			elements.add(new AbstractEvaluableElement(d));
		}
	}
	
	
	/**
	 * Create a set of AbstractEvaluableElements starting from a set of Decision. 
	 * @param dt decision result
	 * @param obls list of obligations for each AbstractEvaluableElement
	 */
	public void setElements(List<AuthorisationPDP> dt,List<TargetDecision> mt,  List<FulfilledObligation> obls) {
		for (int i = 0; i < dt.size(); i++){
				elements.add(new AbstractEvaluableElement(dt.get(i),mt.get(i), obls));
			}
	}
	
	public void setElements(List<AuthorisationPDP> dt, List<TargetDecision> mt) {
		for (int i = 0; i < dt.size(); i++){
//		for (DecisionResult d : dt) {
			elements.add(new AbstractEvaluableElement(dt.get(i),mt.get(i)));
		}
	}

	
	public void clearElements(){
		elements.clear();
	}

	public LinkedList<IEvaluablePolicy> getElements() {
		return elements;
	}

	
}
