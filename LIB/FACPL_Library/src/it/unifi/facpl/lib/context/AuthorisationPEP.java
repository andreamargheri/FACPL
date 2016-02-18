package it.unifi.facpl.lib.context;

import it.unifi.facpl.lib.enums.StandardDecision;

public class AuthorisationPEP {

	private String id;

	private StandardDecision decision;

	private boolean check;

	public AuthorisationPEP(String id, StandardDecision dec) {
		this.id = id;
		this.decision = dec;
		this.check = false;
	}

	public AuthorisationPEP(String id, StandardDecision dec, boolean check) {
		this.id = id;
		this.decision = dec;
		this.check = check;
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
	 * getter per check
	 */
	public boolean isCheck() {
		return check;
	}

}
