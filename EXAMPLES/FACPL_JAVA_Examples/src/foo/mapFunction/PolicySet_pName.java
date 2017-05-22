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
package foo.mapFunction;

import it.unifi.facpl.lib.policy.*;
import foo.declaredFunctions.Function_F_Name;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")
public class PolicySet_pName extends PolicySet {
	public PolicySet_pName() {
		addId("pName");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
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
			addTarget(new ExpressionBooleanTree(
					new ExpressionFunction(true, it.unifi.facpl.lib.function.comparison.Equal.class,
							new AttributeName("action", "id"), new Set("READ", "WRITE"))));

		}
	}
}
