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
package it.unifi.facpl.lib.interfaces;

import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;

/**
 * Evaluation method for obligation
 * 
 * @author Andrea Margheri
 *
 */
public interface IObligationElement {

	AbstractFulfilledObligation getObligationValue(ContextRequest cxtRequest) throws Throwable;

	Effect getEvaluatedOn();

	ObligationType getTypeObl();

}
