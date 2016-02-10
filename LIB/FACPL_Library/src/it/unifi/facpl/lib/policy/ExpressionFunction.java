package it.unifi.facpl.lib.policy;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.interfaces.IExpressionFunction;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.FacplLiteralTypes;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

/**
 * 
 * @author Andrea Margheri Class representing function of Expression
 */
public class ExpressionFunction {

	private Class<? extends IExpressionFunction> functionCond;

	// AtrtibuteName, Literal, ConditionExpressionArgument, list<Object>
	// (bag),...
	private LinkedList<Object> arguments;

	public ExpressionFunction() {
	}

	public ExpressionFunction(Class<? extends IExpressionFunction> function, Object... args) {

		this.functionCond = function;

		// Arguments=AttributeName, Value o ExpressionItem
		this.arguments = new LinkedList<Object>();

		for (Object object : args) {
			this.arguments.add(object);
		}
	}

	/**
	 * Evaluation of Expression
	 * 
	 * @param ContextRequest
	 *            for retrieving attribute values
	 * @return Result of Expression Evaluation. It can be ExpressionValue.BOTTOM
	 *         or ExpressionValue.ERROR
	 */
	public Object evaluateExpression(ContextRequest cxtRequest) {

		Logger l = LoggerFactory.getLogger(ExpressionFunction.class);
		l.debug("Evaluate Expression Arguments");

		Object value = null;

		LinkedList<Object> values = new LinkedList<Object>();
		for (Object obj : this.arguments) {

			// Attribute Name
			if (obj instanceof AttributeName) {
				try {
					values.add(cxtRequest.getContextRequestValues((AttributeName) obj));
				} catch (MissingAttributeException e) {
					// Add value BOTTOM for modeling the absence of attribute
					values.add(ExpressionValue.BOTTOM);
				}
			} else if (obj instanceof ExpressionFunction) {
				// Expression
				values.add(((ExpressionFunction) obj).evaluateExpression(cxtRequest));
			} else if (FacplLiteralTypes.isFacplValue(obj)) {
				// Literals
				values.add(obj);
			} else {
				// Unexpected Type Arguments
				l.debug("Unexpected Type Argument");
				return ExpressionValue.ERROR;
			}
		}

		l.debug("Evaluated Arguments: " + values.toString());

		l.debug("Evaluate Expression: " + functionCond.getSimpleName());

		if (isBottom(values)) {
			l.debug("One of the argument is BOTTOM. Return BOTTOM");
			return ExpressionValue.BOTTOM;
		} else {
			Class<?> params[] = new Class[1];
			params[0] = List.class;

			Method function_m;
			try {
				function_m = functionCond.getDeclaredMethod("evaluateFunction", params);

				Object alg = functionCond.newInstance();
				value = function_m.invoke(alg, values);

			} catch (Exception e) {
				l.debug(e.getMessage());
				l.debug("Expression result is " + ExpressionValue.ERROR);
				return ExpressionValue.ERROR;
			}

		}

		l.debug("Expression result is " + value.toString());

		return value;
	}

	private boolean isBottom(LinkedList<Object> values) {
		for (Object s : values) {
			if (s.equals(ExpressionValue.BOTTOM))
				return true;
		}
		return false;
	}

}
