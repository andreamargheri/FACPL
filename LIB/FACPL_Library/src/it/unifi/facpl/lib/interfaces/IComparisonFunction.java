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

import java.util.List;

/**
 * Comparison Functions
 * 
 * @author Andrea Margheri
 *
 */
public interface IComparisonFunction extends IExpressionFunction {
	@Override
	Boolean evaluateFunction(List<Object> args) throws Throwable;
}
