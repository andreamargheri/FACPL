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
import it.unifi.facpl.lib.util.Set;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

/**
 * 
 * @author Andrea Margheri Class representing function of Expression
 */
public class ExpressionFunction {

	private Class<? extends IExpressionFunction> functionCond;

	/**
	 * 0 = AttributeName 1, ...= Literals or ExpressionItems
	 */
	private LinkedList<Object> arguments;

	/**
	 * Flag for map function (aka high-order function applying iteratively a
	 * function on arguments)
	 */
	private final boolean isMap;
	
	/**
	 * When set to true, during expression evaluation bottom is converted to false 
	 */
	private final boolean isXACMLTranslation;

	/**
	 * FACPL-oriented expression function. No support for XACML semantics correspondence
	 * @param function
	 * @param args
	 */
	public ExpressionFunction(Class<? extends IExpressionFunction> function, Object... args) {
		this.functionCond = function;

		this.arguments = new LinkedList<Object>();

		for (Object object : args) {
			this.arguments.add(object);
		}
		
		/* XACML semantics correspondence */
		this.isMap = false;
		this.isXACMLTranslation = false;
	}
	
	
	/**
	 * With explicit support for XACML semantics correspondence
	 * @param function
	 * @param isXACMLTranslation
	 * @param args
	 */
	public ExpressionFunction(boolean isXACMLTranslation, Class<? extends IExpressionFunction> function, Object... args) {
		this.functionCond = function;

		this.arguments = new LinkedList<Object>();

		for (Object object : args) {
			this.arguments.add(object);
		}
		
		/* XACML semantics correspondence */
		this.isMap = false;
		this.isXACMLTranslation = isXACMLTranslation;
	}

	/**
	 * 
	 * @param function
	 * @param arg1
	 * @param arg2
	 * @param mapFunction
	 *            Setting a map function
	 * @param isXACMLTranslation
	 */
	public ExpressionFunction(Class<? extends IExpressionFunction> function, boolean isXACMLTranslation, AttributeName arg1, Object arg2,
			boolean mapFunction) {
		
		/* XACML Translation */
		this.isMap = mapFunction;
		this.isXACMLTranslation = isXACMLTranslation;
		
		this.functionCond = function;

		// Arguments=AttributeName and Literal
		this.arguments = new LinkedList<Object>();
		this.arguments.add(arg1);
		this.arguments.add(arg2);

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

		if (isMap) {
			try {
				// it is a high-order map function that iterate the application
				// of the function on each element of the set taken as argument
				l.debug("Map function");

				// Get the set of values to iterate from the request
				Object valuesToIterate = null;
				try{
					valuesToIterate = cxtRequest.getContextRequestValues(((AttributeName) this.arguments.get(0)));
				}catch (MissingAttributeException e){
					l.debug("Attribute in map function is bottom. Return bottom");
					return ExpressionValue.BOTTOM;
				}
				
				// Collect value on which iterate the function application
				LinkedList<Object> lst = new LinkedList<Object>();
				if (valuesToIterate instanceof Set) {
					lst = ((Set) valuesToIterate).getValues();
				} else if (FacplLiteralTypes.isFacplValue(valuesToIterate)) {
					// Literals
					lst.add(valuesToIterate);
				} else {
					throw new Exception("Unexpected Definition of Map function");
				}

				l.debug("Arguments on which iterating: " + lst.toString());

				// Iterate function application
				Class<?> params[] = new Class[1];
				params[0] = List.class;

				Method function_m;
				LinkedList<ExpressionValue> function_results = new LinkedList<ExpressionValue>();

				for (Object v : lst) {
					try {
						l.debug("Current literal is " + v.toString());

						// set up list to pass as argument to the function
						LinkedList<Object> function_arg = new LinkedList<Object>();
						function_arg.add(v);
						if (FacplLiteralTypes.isFacplValue(this.arguments.get(1))){
							function_arg.add(this.arguments.get(1));
						}else{
							throw new Exception("Unexpected map definition");
						}
						
						// load the function
						Object intermediate_value = null;
						function_m = functionCond.getDeclaredMethod("evaluateFunction", params);
						Object a = functionCond.newInstance();

						// add intermediate values to the list
						intermediate_value = function_m.invoke(a, function_arg);
						l.debug("Intermediate value is " + intermediate_value);

						if (intermediate_value.equals(true)) {
							function_results.add(ExpressionValue.TRUE);
						} else if (intermediate_value.equals(false)) {
							function_results.add(ExpressionValue.FALSE);
						} else if (intermediate_value.equals(ExpressionValue.BOTTOM)) {
							function_results.add(ExpressionValue.BOTTOM);
						} else {
							function_results.add(ExpressionValue.ERROR);
						}

					} catch (Exception e) {
						l.debug(e.getMessage());
						e.printStackTrace();
						l.debug("Intermediate value is error " + ExpressionValue.ERROR);
						function_results.add(ExpressionValue.ERROR);
					}

					l.debug("Intermediate values so far " + function_results.toString());
				}

				// Calculate final decision
				/*
				 * 1. if at least a TRUE -> return TRUE 2. if there is no true
				 * and there is at least an ERROR -> return ERR 3. if all FALSE
				 * or BOTTOM -> return FALSE
				 */
				boolean isThereERR = false;
				for (ExpressionValue v : function_results) {
					if (v.equals(ExpressionValue.TRUE)) {
						return ExpressionValue.TRUE;
					} else if (v.equals(ExpressionValue.ERROR)) {
						isThereERR = true;
					}
				}

				if (isThereERR) {
					return ExpressionValue.ERROR;
				} else {
					return ExpressionValue.FALSE;
				}
			} catch (Exception e) {
				l.debug(e.getMessage());
				e.printStackTrace();
				l.debug("Unexpected structure of map");
				return ExpressionValue.ERROR;
			}
		} else {
			// it is a single function
			LinkedList<Object> values = new LinkedList<Object>();
			for (Object obj : this.arguments) {

				// Attribute Name
				if (obj instanceof AttributeName) {
					try {
						values.add(cxtRequest.getContextRequestValues((AttributeName) obj));
					} catch (MissingAttributeException e) {
						// Add value BOTTOM for modelling the absence of
						// attribute
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
				/* Support for XACML semantic correspondence */
				if (isXACMLTranslation){
					l.debug("Flag on XACML Target simulation set to true -> convert BOTTOM to FALSE");
					return ExpressionValue.FALSE;
				} else {
					return ExpressionValue.BOTTOM;
				}
			} else {
				Class<?> params[] = new Class[1];
				params[0] = List.class;

				Method function_m;
				try {
					function_m = functionCond.getDeclaredMethod("evaluateFunction", params);
					Object a = functionCond.newInstance();
					value = function_m.invoke(a, values);

				} catch (Exception e) {
					l.debug(e.getMessage());
					l.debug("Expression result is " + ExpressionValue.ERROR);
					return ExpressionValue.ERROR;
				}

			}
			l.debug("Expression result is " + value.toString());
			
			/* Support for XACML semantic correspondence */
			if (isXACMLTranslation && value.equals(ExpressionValue.BOTTOM)){
				l.debug("Flag on XACML Target simulation set to true -> convert BOTTOM to FALSE");
				return ExpressionValue.FALSE;
			}
		
			return value;
		}
	}

	private boolean isBottom(LinkedList<Object> values) {
		for (Object s : values) {
			if (s.equals(ExpressionValue.BOTTOM))
				return true;
		}
		return false;
	}

}
