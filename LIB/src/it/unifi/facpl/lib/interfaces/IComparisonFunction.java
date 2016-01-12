package it.unifi.facpl.lib.interfaces;

import java.util.List;

/**
 * Comparison Functions
 * @author Andrea Margheri
 *
 */
public interface IComparisonFunction extends IExpressionFunction{
	@Override
	Boolean evaluateFunction(List<Object> args) throws Throwable;
}
