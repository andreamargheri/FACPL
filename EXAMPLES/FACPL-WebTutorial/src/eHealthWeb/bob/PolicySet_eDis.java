/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
package eHealthWeb.bob;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_eDis extends PolicySet {
	public PolicySet_eDis() {
		addId("eDis");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverrides.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "e-Dispensation",
				new AttributeName("resource", "type")));
		// PolElements
		addPolicyElement(new Rule_readPhaDis());
		addPolicyElement(new Rule_writePhaDis());
		// Obligation
		addObligation(new Obligation("log", Effect.PERMIT, ObligationType.M, new AttributeName("system", "time"),
				new AttributeName("resource", "type"), new AttributeName("subject", "id"),
				new AttributeName("action", "id")));
	}

	private class Rule_readPhaDis extends Rule {

		Rule_readPhaDis() {
			addId("readPhaDis");
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
							"e-Dis-Read", new AttributeName("subject", "permission")))));
			// Obligations
		}
	}

	private class Rule_writePhaDis extends Rule {

		Rule_writePhaDis() {
			addId("writePhaDis");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(
					new ExpressionBooleanTree(ExprBooleanConnector.AND,
							new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,
									new ExpressionBooleanTree(new ExpressionBooleanTree(ExprBooleanConnector.AND,
											new ExpressionBooleanTree(new ExpressionFunction(
													it.unifi.facpl.lib.function.comparison.Equal.class,
													new AttributeName("subject", "role"), "pharmacist")),
									new ExpressionBooleanTree(
											new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
													new AttributeName("action", "id"), "write")))),
							new ExpressionBooleanTree(
									new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
											"e-Dis-Read", new AttributeName("subject", "permission"))))),
					new ExpressionBooleanTree(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.In.class,
							"e-Dis-Write", new AttributeName("subject", "permission")))));
			// Obligations
		}
	}
}
