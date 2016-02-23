package it.unifi.facpl.lib.context;

import java.util.UUID;

import it.unifi.facpl.lib.enums.StandardDecision;

public class AuthorisationPEP {

	private String id;

	private StandardDecision decision;

	public AuthorisationPEP(String id, StandardDecision dec) {
		this.id = id;
		this.decision = dec;
	}
	public AuthorisationPEP() {
		this.id = UUID.randomUUID().toString().substring(0, 8);
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
