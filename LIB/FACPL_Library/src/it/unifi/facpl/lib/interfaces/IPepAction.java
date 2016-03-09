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
 * Evaluation method for discharging PEP actions
 * 
 * @author Andrea Margheri
 *
 */
public interface IPepAction {

	public void eval(List<Object> args) throws Throwable;

}
