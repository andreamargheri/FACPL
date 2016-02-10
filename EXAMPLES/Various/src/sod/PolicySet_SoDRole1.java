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
package sod;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;

@SuppressWarnings("all")	
public class PolicySet_SoDRole1 extends PolicySet {
	public PolicySet_SoDRole1(){
		addId("SoDRole1");
		//Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class);
		//PolElements
		addPolicyElement(new Rule_ruleName());
		//Obligation
		}
		
		private class Rule_ruleName extends Rule {
			
				Rule_ruleName (){
					addId("ruleName");
					//Effect
					addEffect(Effect.PERMIT);
					//Obligations
			}	
		}
}
