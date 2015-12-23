package it.unifi.facpl.lib.interfaces;

import java.util.List;

/**
 * Interface for match function e boolean function of condition
 * @author Andrea
 *
 */
public interface IComparisonFunction extends IExpressionFunction{
	@Override
	Boolean evaluateFunction(List<Object> args) throws Throwable;
}
