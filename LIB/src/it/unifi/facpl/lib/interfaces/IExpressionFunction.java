package it.unifi.facpl.lib.interfaces;

import java.util.List;

/**
 * Function types for target and obligation expressions
 * @author Andrea Margheri
 *
 */
public interface IExpressionFunction {
	
	Object evaluateFunction(List<Object> args) throws Throwable;

}
