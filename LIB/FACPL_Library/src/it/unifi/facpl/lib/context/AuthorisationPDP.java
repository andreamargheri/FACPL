package it.unifi.facpl.lib.context;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.StandardDecision;

/**
 * 
 * @author Andrea Decision Tuple. Eval result of an evaluable element.
 *         Parametric over request id
 */
public class AuthorisationPDP {

	private String id;

	private ExtendedDecision decision;
	private LinkedList<AbstractFulfilledObligation> obligation;

	// Constructors

	public AuthorisationPDP() {
		this.obligation = new LinkedList<AbstractFulfilledObligation>();
	}

	public AuthorisationPDP(ExtendedDecision decision, LinkedList<AbstractFulfilledObligation> obligations) {
		this.decision = decision;
		this.obligation = obligations;
	}

	public AuthorisationPDP(ExtendedDecision decision) {
		this.decision = decision;
		this.obligation = new LinkedList<AbstractFulfilledObligation>();
	}

	// DECISION

	public void setDecision(ExtendedDecision decision) {
		this.decision = decision;
	}

	public ExtendedDecision getDecision() {
		return decision;
	}

	public StandardDecision getStandardDecision() {

		switch (this.decision) {
		case PERMIT:
			return StandardDecision.PERMIT;
		case DENY:
			return StandardDecision.DENY;
		case NOT_APPLICABLE:
			return StandardDecision.NOT_APPLICABLE;
		case INDETERMINATE_D:
			return StandardDecision.INDETERMINATE;
		case INDETERMINATE_P:
			return StandardDecision.INDETERMINATE;
		case INDETERMINATE_DP:
			return StandardDecision.INDETERMINATE;
		}

		return null;

	}

	// OBLIGATION

	public void addObligation(AbstractFulfilledObligation obligation) {
		if (this.obligation == null) {
			this.obligation = new LinkedList<AbstractFulfilledObligation>();
		}
		this.obligation.add(obligation);
	}

	public void addObligation(List<AbstractFulfilledObligation> obligation) {
		if (this.obligation == null) {
			this.obligation = new LinkedList<AbstractFulfilledObligation>();
		}
		this.obligation.addAll(obligation);
	}

	public void setObligation(LinkedList<AbstractFulfilledObligation> obligations) {
		this.obligation = obligations;
	}

	public void clearObligation() {
		this.obligation.clear();
	}

	public LinkedList<AbstractFulfilledObligation> getObligation() {
		return obligation;
	}

	public Iterator<AbstractFulfilledObligation> getObligationIterator() {
		return obligation.iterator();
	}

	// ID

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuffer text = new StringBuffer();
		text.append("Decision: " + decision.toString() + " ");
		text.append("Obligations: ");
		if (obligation != null) {
			for (AbstractFulfilledObligation obl : obligation) {
				text.append(obl.toString());
			}
		} else {
			text.append("[]");
		}
		return text.toString();
	}

}
