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
package foo;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_PSet extends PolicySet {
	public PolicySet_PSet() {
		addId("PSet");
		// Algorithm Combining
		addCombiningAlg(new it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy());
		// Target
		addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
				new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(),
						"READ", new AttributeName("action", "id"))),
				new ExpressionBooleanTree(new ExpressionFunction(new Function_F_Name(), "READ", 4))));
		// PolElements
		addPolicyElement(new Rule_rule1());
		// Obligation
	}

	private class Rule_rule1 extends Rule {

		Rule_rule1() {
			addId("rule1");
			// Effect
			addEffect(Effect.PERMIT);
			// Target
			addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
					new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(),
							new AttributeName("sub", "id"),
							new ExpressionFunction(new Function_F_Name2(), "foo", true))),
					new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(),
							new AttributeName("sub", "id"), new Set(true, false)))));
			// Obligations
		}
	}
}
