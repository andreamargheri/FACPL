package it.unifi.facpl.lib.policy;

import java.util.ArrayList;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.enums.ExpressionValue;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.FacplLiteralTypes;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

public class ExpressionBooleanTree {

	private LinkedList<ExpressionBooleanTree> child;

	// if child is empty -> Expression Function, AttributeName, Literals
	// if there are childs -> connector
	private Object root;

	/**
	 * Create ExpressionBooleanTree having as children the trees given in input
	 * 
	 * @param conn
	 *            Connector
	 * @param nodes
	 *            ExpressionBooleanTrees to become children of Connector
	 */
	public ExpressionBooleanTree(ExprBooleanConnector conn, ExpressionBooleanTree... nodes) {
		child = new LinkedList<ExpressionBooleanTree>();
		root = conn;
		for (ExpressionBooleanTree nodeTargetTree : nodes) {
			child.add(nodeTargetTree);
		}
	}

	/**
	 * Create ExpressionBooleanTree having as children the trees formed by the
	 * functions given in input
	 * 
	 * @param conn
	 *            Connector
	 * @param functions
	 *            Functions to become children of Connector
	 */
	public ExpressionBooleanTree(ExprBooleanConnector conn, ExpressionFunction... functions) {
		child = new LinkedList<ExpressionBooleanTree>();
		root = conn;
		for (ExpressionFunction nodeFunction : functions) {
			child.add(new ExpressionBooleanTree(nodeFunction));
		}
	}

	/**
	 * Create ExpressionBooleanTree having as root the tree formed by the
	 * function given in input
	 * 
	 * @param function
	 */
	public ExpressionBooleanTree(ExpressionFunction function) {
		root = function;
		child = new LinkedList<ExpressionBooleanTree>();
	}

	/**
	 * Take as input Expression Function, or Attribute Name or Literal
	 * 
	 * @param node
	 */
	public ExpressionBooleanTree(Object node) {
		root = node;
	}

	/**
	 * @param Context
	 *            Request
	 * @return Result of Expression Evaluation. It can be ExpressionValue.BOTTOM
	 *         or ExpressionValue.ERROR
	 */
	public ExpressionValue evaluateExpressionTree(ContextRequest cxtRequest) {
		Logger l = LoggerFactory.getLogger(ExpressionBooleanTree.class);

		if (root instanceof ExprBooleanConnector) {

			// Root-> And, Or, Not
			// Child -> arguments of the function

			ArrayList<ExpressionValue> values = new ArrayList<ExpressionValue>();

			for (ExpressionBooleanTree tr : this.child) {
				values.add(toExpressionValue(tr.evaluateExpressionTree(cxtRequest)));
			}

			l.debug("Combine values " + values.toString() + " with operator " + (ExprBooleanConnector) root);

			return toExpressionValue(combineValues((ExprBooleanConnector) root, values));

		} else if (root instanceof ExpressionFunction) {
			// Root corresponds to a leaf -> return the function evaluation
			return toExpressionValue(((ExpressionFunction) root).evaluateExpression(cxtRequest));

		} else if (FacplLiteralTypes.isFacplValue(root)) {
			// literal value (argument of Expression)
			return toExpressionValue(root);

		} else if (root instanceof AttributeName) {

			// Attribute Name
			try {
				return toExpressionValue(cxtRequest.getContextRequestValues((AttributeName) root));
			} catch (MissingAttributeException e) {
				// return BOTTOM for modeling the absence of attribute
				return ExpressionValue.BOTTOM;
			}
		} else if (root instanceof ExpressionBooleanTree) {
			return ((ExpressionBooleanTree) root).evaluateExpressionTree(cxtRequest);
		}

		// Case non considered
		return ExpressionValue.ERROR;
	}

	private ExpressionValue toExpressionValue(Object value) {
		if (value.equals(true) || value.equals(ExpressionValue.TRUE)) {
			return ExpressionValue.TRUE;
		} else if (value.equals(false) || value.equals(ExpressionValue.FALSE)) {
			return ExpressionValue.FALSE;
		} else if (value.equals(ExpressionValue.BOTTOM)) {
			return ExpressionValue.BOTTOM;
		} else {
			return ExpressionValue.ERROR;
		}
	}

	public ExpressionValue combineValues(ExprBooleanConnector conn, ArrayList<ExpressionValue> args) {
		Logger l = LoggerFactory.getLogger(ExpressionBooleanTree.class);
		if (conn.equals(ExprBooleanConnector.NOT)) {
			ExpressionValue dc = args.get(0);
			switch (dc) {
			case FALSE:
				return ExpressionValue.TRUE;
			case TRUE:
				return ExpressionValue.FALSE;
			case BOTTOM:
				return ExpressionValue.BOTTOM;
			case ERROR:
				return ExpressionValue.ERROR;
			default:
				return ExpressionValue.ERROR;
			}

		} else {
			// Connector: AND or OR
			ExpressionValue dc = args.get(0);
			for (int i = 1; i < args.size(); i++) {
				ExpressionValue arg1 = dc;
				ExpressionValue arg2 = args.get(i);

				if (conn.equals(ExprBooleanConnector.AND)) {
					// Connector AND
					if (arg1.equals(ExpressionValue.FALSE) || arg2.equals(ExpressionValue.FALSE)) {
						dc = ExpressionValue.FALSE;
					} else if (arg1.equals(ExpressionValue.TRUE) && arg2.equals(ExpressionValue.TRUE)) {
						dc = ExpressionValue.TRUE;
					} else if ((arg1.equals(ExpressionValue.BOTTOM) && arg2.equals(ExpressionValue.BOTTOM))
							|| ((arg1.equals(ExpressionValue.BOTTOM) || arg2.equals(ExpressionValue.BOTTOM))
									&& (arg1.equals(ExpressionValue.TRUE) || arg2.equals(ExpressionValue.TRUE)))) {
						dc = ExpressionValue.BOTTOM;
					} else {
						dc = ExpressionValue.ERROR;
					}
				} else {
					// Connector OR
					if (arg1.equals(ExpressionValue.TRUE) || arg2.equals(ExpressionValue.TRUE)) {
						dc = ExpressionValue.TRUE;
					} else if (arg1.equals(ExpressionValue.FALSE) && arg2.equals(ExpressionValue.FALSE)) {
						dc = ExpressionValue.FALSE;
					} else if ((arg1.equals(ExpressionValue.BOTTOM) && arg2.equals(ExpressionValue.BOTTOM))
							|| ((arg1.equals(ExpressionValue.BOTTOM) || arg2.equals(ExpressionValue.BOTTOM))
									&& (arg1.equals(ExpressionValue.FALSE) || arg2.equals(ExpressionValue.FALSE)))) {
						dc = ExpressionValue.BOTTOM;
					} else {
						dc = ExpressionValue.ERROR;
					}
				}
			}
			l.debug("Combined Value: " + dc.toString());
			return dc;
		}
	}
}
