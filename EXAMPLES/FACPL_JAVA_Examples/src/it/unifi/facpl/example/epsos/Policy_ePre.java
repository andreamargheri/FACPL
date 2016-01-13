package it.unifi.facpl.example.epsos;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.Obligation;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.Bag;

public class Policy_ePre extends PolicySet {

	public Policy_ePre() {
		addId("ePresctiprion");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		// Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
				new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						"TREATEMENT", new AttributeName("subject.access", "purposeofuse"))),
				new ExpressionBooleanTree(ExprBooleanConnector.OR,
						new ExpressionBooleanTree(
								new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
										"medical doctor", new AttributeName("subject", "role"))),
						new ExpressionBooleanTree(
								new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
										"pharmachist", new AttributeName("subject", "role")))),
				new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						"57829-4", new AttributeName("resource", "resource-id")))));
		// Rule
		addPolicyElement(new rule1());
		addPolicyElement(new ruledeny());
		// Obligations
		addObligation(new Obligation("log", Effect.PERMIT, ObligationType.M, new AttributeName("subject", "doctor-id"),
				new AttributeName("resource", "resource-id")));
		addObligation(new Obligation("mail", Effect.DENY, ObligationType.M,
				new AttributeName("resource", "resource-id.email"),
				"Your medical record has been requested by EpSOS subject"));
	}

	private class rule1 extends Rule {

		rule1() {
			addId("rule1");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
					new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Read",
							new AttributeName("action", "action-id")),
					new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							new Bag("PRD-004", "PRD-010"), new AttributeName("subject", "hl7.permission"))));

			// Obligations
		}
	}

	private class ruledeny extends Rule {

		ruledeny() {
			addId("ruledeny");
			// Effect
			addEffect(Effect.DENY);
		}
	}

}
