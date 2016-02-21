package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.StandardDecision;

public class AuthorisationPEP {

	private String id;

	private StandardDecision decision;

	private boolean PDPpassthrough;

	public AuthorisationPEP(String id, StandardDecision dec) {
		this.id = id;
		this.decision = dec;
		this.PDPpassthrough = false;
	}

	public AuthorisationPEP(String id, StandardDecision dec, boolean PDPpassthrough) {
		this.id = id;
		this.decision = dec;
		this.PDPpassthrough = PDPpassthrough;
	}

	public AuthorisationPEP(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public StandardDecision getDecision() {
		return decision;
	}

	@Override
	public String toString() {
		return decision.toString();
	}

	/*
	 * getter per PDPpassthrough
	 */
	public boolean PDPpassthrough() {
		return PDPpassthrough;
	}
	
	public void setDecision(StandardDecision decision) {
		this.decision = decision;
	}
	public void setPDPpassthrough(boolean pDPpassthrough) {
		PDPpassthrough = pDPpassthrough;
	}

}
