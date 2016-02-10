package eHealthWeb.alice;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_ePre extends PolicySet {
	public PolicySet_ePre() {
		addId("ePre");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverrides.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "e-Prescription",
				new AttributeName("resource", "type")));
		// PolElements
		addPolicyElement(new Rule_writeDoc());
		addPolicyElement(new Rule_readDoc());
		addPolicyElement(new Rule_readPha());
		// Obligation
		addObligation(new Obligation("log", Effect.PERMIT, ObligationType.M, new AttributeName("system", "time"),
				new AttributeName("resource", "type"), new AttributeName("subject", "id"),
				new AttributeName("action", "id")));
	}

	private class Rule_writeDoc extends Rule {

		Rule_writeDoc() {
			addId("writeDoc");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(
					new ExpressionBooleanTree(ExprBooleanConnector.AND,
							new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,
									new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,
											new ExpressionBooleanTree(new ExpressionFunction(
													it.unifi.facpl.lib.function.comparison.Equal.class,
													new AttributeName("subject", "role"), "doctor")),
									new ExpressionBooleanTree(
											new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
													new AttributeName("action", "id"), "write")))),
							new ExpressionBooleanTree(
									new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
											"e-Pre-Write", new AttributeName("subject", "permission"))))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							"e-Pre-Read", new AttributeName("subject", "permission")))));
			// Obligations
		}
	}

	private class Rule_readDoc extends Rule {

		Rule_readDoc() {
			addId("readDoc");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(
					new ExpressionBooleanTree(ExprBooleanConnector.AND,
							new ExpressionBooleanTree(
									new ExpressionBooleanTree(ExprBooleanConnector.AND,
											new ExpressionBooleanTree(new ExpressionFunction(
													it.unifi.facpl.lib.function.comparison.Equal.class,
													new AttributeName("subject", "role"), "doctor")),
									new ExpressionBooleanTree(
											new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
													new AttributeName("action", "id"), "read")))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							"e-Pre-Read", new AttributeName("subject", "permission")))));
			// Obligations
		}
	}

	private class Rule_readPha extends Rule {

		Rule_readPha() {
			addId("readPha");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(
					new ExpressionBooleanTree(ExprBooleanConnector.AND,
							new ExpressionBooleanTree(
									new ExpressionBooleanTree(ExprBooleanConnector.AND,
											new ExpressionBooleanTree(new ExpressionFunction(
													it.unifi.facpl.lib.function.comparison.Equal.class,
													new AttributeName("subject", "role"), "pharmacist")),
									new ExpressionBooleanTree(
											new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
													new AttributeName("action", "id"), "read")))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							"e-Pre-Read", new AttributeName("subject", "permission")))));
			// Obligations
		}
	}
}
