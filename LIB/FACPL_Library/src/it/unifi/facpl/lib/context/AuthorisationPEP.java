package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.StandardDecision;

public class AuthorisationPEP {

	private String id;

	private StandardDecision decision;


	public AuthorisationPEP(String id, StandardDecision dec) {
		this.id = id;
		this.decision = dec;
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

	public void setDecision(StandardDecision decision) {
		this.decision = decision;
	}


}
