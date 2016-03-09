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
package it.unifi.facpl.lib.function.comparison;

import java.util.List;

import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.function.comparison.evaluator.ComparisonEvaluatorFactory;
import it.unifi.facpl.lib.interfaces.IComparisonEvaluator;
import it.unifi.facpl.lib.interfaces.IComparisonFunction;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.system.status.StatusAttribute;

public class LessThan implements IComparisonFunction {

	public Boolean evaluateFunction(List<Object> args) throws Throwable {

		if (args.size() == 2) {
			Object o1, o2;
			o1 = args.get(0) instanceof StatusAttribute ? this.convertType((StatusAttribute) args.get(0)) : args.get(0);
			o2 = args.get(1) instanceof StatusAttribute ? this.convertType((StatusAttribute) args.get(1)) : args.get(1);

			IComparisonEvaluator evaluator = ComparisonEvaluatorFactory.getInstance().getEvaluator(o1);
			return evaluator.isLessThan(o1, o2);

		} else {
			throw new Exception("Illegal number of arguments");
		}
	}

	/*
	 * effettua per prima cosa il retrieve dallo status dell'attributo corretto
	 * poi fa il controllo sul tipo dell'attributo dello status attribute e fa
	 * il cast al tipo corretto
	 */
	private Object convertType(StatusAttribute sa) {
		// StatusAttribute sa = FacplStatus.getInstance().getStatusAttribute(s);
		if (sa.getType() == FacplStatusType.BOOLEAN) {
			return Boolean.getBoolean(sa.getValue());
		} else if (sa.getType() == FacplStatusType.DOUBLE) {
			return Double.valueOf(sa.getValue());
		} else if (sa.getType() == FacplStatusType.INT) {
			return Integer.valueOf(sa.getValue());
		} else if (sa.getType() == FacplStatusType.STRING) {
			return sa.getValue();
		} else if (sa.getType() == FacplStatusType.DATE) {
			return new FacplDate(sa.getValue());
		}
		return null;
	}
}
