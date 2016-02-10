package it.unifi.xacmlToFacpl.parser;

import it.unifi.xacmlToFacpl.jaxb.AdviceExpressionType;
import it.unifi.xacmlToFacpl.jaxb.AdviceExpressionsType;
import it.unifi.xacmlToFacpl.jaxb.AllOfType;
import it.unifi.xacmlToFacpl.jaxb.AnyOfType;
import it.unifi.xacmlToFacpl.jaxb.ApplyType;
import it.unifi.xacmlToFacpl.jaxb.AttributeAssignmentExpressionType;
import it.unifi.xacmlToFacpl.jaxb.AttributeDesignatorType;
import it.unifi.xacmlToFacpl.jaxb.AttributeType;
import it.unifi.xacmlToFacpl.jaxb.AttributeValueType;
import it.unifi.xacmlToFacpl.jaxb.AttributesType;
import it.unifi.xacmlToFacpl.jaxb.ConditionType;
import it.unifi.xacmlToFacpl.jaxb.IdReferenceType;
import it.unifi.xacmlToFacpl.jaxb.MatchType;
import it.unifi.xacmlToFacpl.jaxb.ObligationExpressionType;
import it.unifi.xacmlToFacpl.jaxb.ObligationExpressionsType;
import it.unifi.xacmlToFacpl.jaxb.PolicySetType;
import it.unifi.xacmlToFacpl.jaxb.PolicyType;
import it.unifi.xacmlToFacpl.jaxb.RequestType;
import it.unifi.xacmlToFacpl.jaxb.RuleType;
import it.unifi.xacmlToFacpl.jaxb.TargetType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class XacmlParser {
	private JAXBContext jc;
	private Unmarshaller u;
	private static int id;
	private static int idReq;
	protected Logger l;

	public XacmlParser() {
		l = Logger.getLogger(XacmlParser.class);
		id = 0;
		idReq = 1;
		try {
			l.trace("Instaced JAXBContext");
			jc = JAXBContext.newInstance("it.unifi.xacmlToFacpl.jaxb");
			u = jc.createUnmarshaller();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Root of JAXB document. Choosing the type of the root element, i.e.
	 * request, policy, policy set
	 * 
	 * @param d
	 *            JAXB document
	 * @return parsed string in FACPL-like syntax
	 * @throws JAXBException
	 */
	public StringBuffer parse(Document d) throws JAXBException {
		StringBuffer st = new StringBuffer();
		JAXBElement<?> el;
		Object obj = u.unmarshal(d);

		if (obj instanceof JAXBElement) {
			el = (JAXBElement<?>) obj;
			// call policy parser or request parser
			if (el.getValue() instanceof PolicySetType) {
				l.trace("PolicySet Item");
				this.parsePolicy((PolicySetType) el.getValue(), st);
			} else if (el.getValue() instanceof PolicyType) {
				l.trace("Policy Item");
				this.parsePolicy((PolicyType) el.getValue(), st);
			} else if (el.getValue() instanceof RequestType) {
				l.trace("Request Item");
				this.parseRequest((RequestType) el.getValue(), st);
			} else {
				throw new JAXBException("No XACML Policy or Request to parse");
			}
		} else {
			// exception not a XACML Policy or request
			throw new JAXBException("No XACML Policy or Request to parse");
		}
		return st;
	}

	/**
	 * Parsing of XACML PolicySet element A PolicySet can contain a policy, a
	 * policy set or a referenceID
	 * 
	 * @param polSet
	 *            as JAXB element
	 * @param st
	 * @return
	 */
	private StringBuffer parsePolicy(PolicySetType polSet, StringBuffer st) {
		// PolicySet
		if (polSet.getPolicySetId() != "") {
			st.append("PolicySet " + parseID(polSet.getPolicySetId()) + " { ");
		} else {
			// add unique name to polSet
			l.debug("No policySet identifier. Chosen a default one");
			st.append("PolicySet polSet_" + id + "{ ");
			id++;
		}
		st.append(getCombingAlgName(polSet.getPolicyCombiningAlgId()) + "\n");
		l.trace("Added Combing Alg: " + getCombingAlgName(polSet.getPolicyCombiningAlgId()));
		l.trace("Parsing target..");
		if (polSet.getTarget() != null) {
			if (polSet.getTarget().getAnyOf() != null) {
				if (polSet.getTarget().getAnyOf().size() != 0) {
					st.append("target: " + parseTarget(polSet.getTarget()) + "\n");
				}
			}
		}
		st.append("policies: \n");
		// policy or policy set or reference
		for (JAXBElement<?> p : polSet.getPolicySetOrPolicyOrPolicySetIdReference()) {
			if (p.getValue() instanceof PolicyType) {
				l.trace("Found a Policy");
				parsePolicy((PolicyType) p.getValue(), st);
				st.append("\n");
			}
			if (p.getValue() instanceof PolicySetType) {
				l.trace("Found a Policy Set");
				parsePolicy((PolicySetType) p.getValue(), st);
				st.append("\n");
			}
			if (p.getValue() instanceof IdReferenceType) {
				l.trace("Found a Reference");
				st.append("include ");
				st.append(parseID(((IdReferenceType) p.getValue()).getValue()) + "\n");
			}
		}
		if (polSet.getObligationExpressions() != null || polSet.getAdviceExpressions() != null) {
			st.append("\n");
			// oblgiations and advices
			st.append("obl: " + parseObls(polSet.getObligationExpressions(), polSet.getAdviceExpressions()) + "\n");
		}
		st.append("}");
		l.trace("End PolicySet Parsing");
		return st;
	}

	/**
	 * Parsing of XACML Policy element
	 * 
	 * @param policy
	 *            as JAXB element
	 * @param st
	 * @return
	 */
	protected StringBuffer parsePolicy(PolicyType policy, StringBuffer st) {
		// Policy
		if (policy.getPolicyId() != "") {
			st.append("PolicySet " + parseID(policy.getPolicyId()) + " { ");
		} else {
			// add unique name to polSet
			l.debug("No policy identifier. Chosen a default one");
			st.append("Policy policy_" + id + " { ");
			id++;
		}
		st.append(getCombingAlgName(policy.getRuleCombiningAlgId()) + "\n");
		l.trace("Added Combing Alg: " + getCombingAlgName(policy.getRuleCombiningAlgId()));
		l.trace("Parsing target..");
		if (policy.getTarget() != null) {
			if (policy.getTarget().getAnyOf() != null) {
				if (policy.getTarget().getAnyOf().size() != 0) {
					st.append("target: " + parseTarget(policy.getTarget()) + "\n");
				}
			}
		}
		st.append("policies: \n");
		// rules
		for (Object r : policy.getCombinerParametersOrRuleCombinerParametersOrVariableDefinition()) {
			if (r instanceof RuleType) {
				l.trace("Found a rule");
				st.append(parseRule((RuleType) r) + "\n");
			}
		}
		// oblgiations and advices
		if (policy.getObligationExpressions() != null || policy.getAdviceExpressions() != null) {
			st.append("\n");
			st.append("obl: " + parseObls(policy.getObligationExpressions(), policy.getAdviceExpressions()) + "\n");
		}
		st.append("}");
		l.trace("End Policy Parsing");
		return st;
	}

	private String parseRule(RuleType r) {
		StringBuffer s = new StringBuffer();
		if (r.getRuleId() != "") {
			s.append("Rule " + parseID(r.getRuleId()));
		} else {
			// add unique name to polSet
			l.debug("No rule identifier. Chosen a default one");
			s.append("Rule rule_" + id);
			id++;
		}
		s.append(" (" + r.getEffect().name().toLowerCase() + " ");
		if (r.getTarget() != null) {
			if (r.getTarget().getAnyOf() != null) {
				if (r.getTarget().getAnyOf().size() != 0) {
					s.append("target: " + parseTarget(r.getTarget()) + "\n");
				}
			}
		}
		/* Condition is attached to the target */
		if (r.getCondition() != null) {
			if (r.getTarget() != null) {
				if (r.getTarget().getAnyOf().size() != 0) {
					s.append(" && ");
				} else {
					s.append(" target: ");
				}
			} else {
				s.append(" target: ");
			}
			s.append(parseCondition(r.getCondition()) + "\n");
		}

		if (r.getObligationExpressions() != null || r.getAdviceExpressions() != null) {
			s.append("obl: " + parseObls(r.getObligationExpressions(), r.getAdviceExpressions()));
		}
		// closing brackets
		s.append(")");
		return s.toString();
	}

	private String getCombingAlgName(String algId) {
		if (algId.contains("ordered-permit")) {
			return "permit-overrides-greedy";
		} else if (algId.contains("ordered-deny")) {
			return "deny-overrides-greedy";
		} else if (algId.contains("permit-overrides")) {
			return "permit-overrides-greedy";
		} else if (algId.contains("deny-overrides")) {
			return "deny-overrides-greedy";
		} else if (algId.contains("first")) {
			return "first-applicable-greedy";
		} else if (algId.contains("only-one")) {
			return "only-one-applicable-greedy";
		} else if (algId.contains("permit-unless")) {
			return "permit-unless-deny-greedy";
		} else if (algId.contains("deny-unless")) {
			return "deny-unless-permit-greedy";
		}
		return "custom-algorithm";
	}

	/**
	 * Target parsing for rule, policy and policy set
	 * 
	 * @param t
	 * @return
	 */
	private String parseTarget(TargetType t) {
		if (t != null) {
			StringBuffer s = new StringBuffer();
			l.trace("list of AnyOf");
			for (int j = 0; j < t.getAnyOf().size(); j++) {
				AnyOfType a = t.getAnyOf().get(j);
				if (t.getAnyOf().size() > 1) {
					s.append("(");
				}
				// Sequence of AllOf to put between ||
				for (int k = 0; k < a.getAllOf().size(); k++) {
					AllOfType b = a.getAllOf().get(k);
					if (a.getAllOf().size() > 1) {
						s.append("(");
					}
					// Sequence of Match to put between &&
					for (int i = 0; i < b.getMatch().size(); i++) {
						l.trace("parsing Match");
						s.append(parseMatch(b.getMatch().get(i)));
						if (i < b.getMatch().size() - 1) {
							s.append("&&");
						}
					}
					if (a.getAllOf().size() > 1) {
						s.append(")");
					}
					if (k < a.getAllOf().size() - 1)
						s.append("||");
				}
				// End sequence of AllOF
				if (t.getAnyOf().size() > 1) {
					s.append(")");
				}
				if (j < t.getAnyOf().size() - 1)
					s.append("&&");
			}
			l.debug("...target parsed");
			return s.toString();
		} else {
			l.debug("...target empty");
			return "";
		}
	}

	/**
	 * Match functions of AllOf items inside AnyOf items recursively inside a
	 * Target element Only designator is supported
	 * 
	 * @param c
	 * @return
	 */
	private String parseMatch(MatchType c) {
		l.trace("Match parsing");
		StringBuffer s = new StringBuffer();
		String id = getIDFunction(parseID(c.getMatchId()));
		String value = parseValue(c.getAttributeValue());
		String attr = "";
		if (c.getAttributeSelector() != null) {
			attr = "---Selector Not Supported---";
			l.debug("Selector Not Supported");
		} else {
			// designator
			attr = parseDesignator(c.getAttributeDesignator());
		}
		// Compile the function
		if (id.equals("&&") || id.equals("||")) {
			s.append("(" + value + " " + id + " " + attr + ")");
		} else if (id.equals("!")) {
			s.append(id + "(" + value + ")");
		} else {
			s.append(id + "(" + value + " , " + attr + ")");
		}
		return s.toString();
	}

	/**
	 * Set of obligations and advice of rule, policy and policy set items
	 * 
	 * @param obls
	 * @param advs
	 * @return
	 */
	private String parseObls(ObligationExpressionsType obls, AdviceExpressionsType advs) {
		StringBuffer s = new StringBuffer();
		// obls
		if (obls != null) {
			for (ObligationExpressionType o : obls.getObligationExpression()) {
				s.append("[ " + o.getFulfillOn().name().toLowerCase() + " M  ");
				s.append(parseID(o.getObligationId()) + " ( ");
				// arguments
				int i = 0;
				for (AttributeAssignmentExpressionType arg : o.getAttributeAssignmentExpression()) {
					if (i > 0)
						s.append(",");
					s.append(parseArgumentObls(arg));
					i++;
				}
				s.append(")]\n");
			}
		}
		// adv
		if (advs != null) {
			for (AdviceExpressionType a : advs.getAdviceExpression()) {
				s.append("[ " + a.getAppliesTo().name().toLowerCase() + " O ");
				s.append(parseID(a.getAdviceId()) + " ( ");
				// arguments
				int i = 0;
				for (AttributeAssignmentExpressionType arg : a.getAttributeAssignmentExpression()) {
					if (i > 0)
						s.append(", ");
					s.append(parseArgumentObls(arg));
					i++;
				}
				s.append(")]\n");
			}
		}
		return s.toString();
	}

	/**
	 * Not requested categoryId of the AttributeAssignementExpression (in XACML
	 * is Optionally) Parsing only attributeId and expression
	 * 
	 * @param argumentAssignementExpression
	 *            of AdviceExpression and ObligationExpression
	 * @return parsed string in FACPL-like syntax
	 */
	private String parseArgumentObls(AttributeAssignmentExpressionType arg) {
		StringBuffer s = new StringBuffer();
		// structured name
		// no attribute id for arguments, it is decided by an agreement with
		// policy writer
		// s.append(parseID(arg.getAttributeId()) + ", ");
		s.append(parseExpr(arg.getExpression()));
		return s.toString();
	}

	/**
	 * Condition: unique expression that is parsed according to the
	 * ExpressionType rule
	 * 
	 * @param con
	 * @return
	 */
	private String parseCondition(ConditionType con) {
		if (con != null) {
			return parseExpr(con.getExpression());
		} else {
			l.trace("empty condition");
			return "";
		}
	}

	/**
	 * PARSING OF EXPRESSION: -> VariableReference - Not Supported ->
	 * FunctionType - Not Supported -> ApplyType - Supported ->
	 * AttributeSelector (use Xpath)-> Not Supported -> AttributeDesignator -
	 * Supported -> AttributeValue - Supported
	 * 
	 * @param expression
	 * @return
	 */
	private String parseExpr(JAXBElement<?> exp) {
		StringBuffer s = new StringBuffer();
		// only ApplyType, Designator and Value
		Object ob = exp.getValue();
		if (ob instanceof AttributeValueType) {
			s.append(parseValue((AttributeValueType) ob));
		} else if (ob instanceof ApplyType) {
			s.append(parseApply((ApplyType) ob));
		} else if (ob instanceof AttributeDesignatorType) {
			s.append(parseDesignator((AttributeDesignatorType) ob));
		} else {
			l.debug("Type of expression not supported"
					+ "Only expression supported are ApplyType, AttributeDesignator and AttributeValue");
			s.append("---Expression type not supported---");
		}
		return s.toString();
	}

	/**
	 * AttributeDesignator
	 * 
	 * @param AttributeDesignator
	 *            des
	 * @return String corresponding to the structured-name of the attribute
	 */
	private String parseDesignator(AttributeDesignatorType des) {
		l.trace(des.getCategory());
		l.trace(des.getAttributeId());
		return parseID(des.getCategory()) + "/" + parseID(des.getAttributeId());
	}

	/**
	 * Processing the AttributeValue element. <b>Notably, an AttributeValue can
	 * contain only one value, sequence of AttributeValue nested within other
	 * AttributeValue must be avoided </b>
	 * 
	 * @param AttributeValueType
	 * 
	 * @return String parserValue corresponding to the literal expressed in the
	 *         XACML element
	 */
	private String parseValue(AttributeValueType ob) {
		// Multiple values are permitted only as sequence of AttributeValue not
		// inside an AttributeValue, i.e
		/*
		 * <AttributeValue DataType="http://www.w3.org/2001/XMLSchema#string">
		 * <AttributeValue DataType="http://www.w3.org/2001/XMLSchema#string">
		 * value </AttributeValue> <AttributeValue
		 * DataType="http://www.w3.org/2001/XMLSchema#string"> value
		 * </AttributeValue> </AttributeValue>
		 */
		// generate a wrong result.

		if (ob.getContent().size() > 1) {
			l.debug("---AttributeValue with mutiples contents are not supported. It is parsed only the first.");
			l.info("---Multivalued Attribute are rendered as sequence of atribute with same type---");
		}
		Object el = ob.getContent().get(0);
		String type = parseID(ob.getDataType());
		if (type.contains("string")) {
			return "\"" + el.toString().trim() + "\"";
			// }
			// else if(type.contains("date")){
			// return "DATE";
		} else if (type.contains("anyURI")) {
			return "\"" + el.toString().trim() + "\"";
		} else if (type.contains("integer")) {
			try {
				Integer.parseInt(el.toString());
				return el.toString().trim();
			} catch (Exception e) {
				// returned Double type
				return el.toString().trim() + ".0";
			}
		} else {
			return el.toString().trim();
		}

	}

	/**
	 * Parse <Apply> function. We admit nested function, that are recursively
	 * parsed
	 * 
	 * @param ob
	 * @return
	 */
	private Object parseApply(ApplyType ob) {
		// NB -> nested functions
		StringBuffer s = new StringBuffer();
		String op = getIDFunction(parseID(ob.getFunctionId()));
		if (op.equals("&&") || op.equals("||")) {
			s.append("(");
			int i = 0;
			for (JAXBElement<?> ex : ob.getExpression()) {
				if (i > 0)
					s.append(" "+ op + " ");
				s.append(parseExpr(ex));
				i++;
			}
			s.append(")");
		} else {
			s.append(op);
			s.append("(");
			int i = 0;
			for (JAXBElement<?> ex : ob.getExpression()) {
				if (i > 0)
					s.append(", ");
				s.append(parseExpr(ex));
				i++;
			}
			s.append(")");
		}
		return s.toString();
	}

	/**
	 * Remove xacml namespace and return the identifier Available for
	 * AttributeID, Category, Type and Function
	 * 
	 * @param id
	 * @return
	 */
	private String parseID(String id) {
		// replace all ":" in string
		id = id.substring(id.lastIndexOf(":") + 1);
		return id.replace(':', '_');

	}

	/**
	 * Get the right name of the comparison function
	 * 
	 * @param replace
	 * @return
	 */
	private String getIDFunction(String replace) {
		replace = replace.toLowerCase();
		if (replace.contains("equal")) {
			return "equal";
		}
		if (replace.contains("not-equal")) {
			return "not-equal";
		}
		// arithmetic
		if (replace.contains("add")) {
			return "addition";
		}
		if (replace.contains("multiply")) {
			return "multiply";
		}
		if (replace.contains("divide")) {
			return "divide";
		}
		// bag
		if (replace.contains("one")) {
			return "in";
		}
		if (replace.contains("subset")) {
			return "in";
		}
		if (replace.contains("bag")) {
			return "set";
		}
		// comparison
		if (replace.contains("greater-than-or-equal")) {
			return "greater-than-or-equal";
		}
		if (replace.contains("greater-than")) {
			return "greater-than";
		}
		if (replace.contains("less-than-or-equal")) {
			return "less-than-or-equal";
		}
		if (replace.contains("less-than")) {
			return "less-than";
		}
		// logic
		if (replace.contains("and")) {
			return "&&";
		}
		if (replace.contains("or")) {
			return "||";
		}
		if (replace.contains("not")) {
			return "!";
		}
		return replace;
	}

	/**
	 * Parsing Request. <b> Notably multiple-values attributes MUST be expressed
	 * as a sequence of AttributeValue within the same <Attribute> element.
	 * 
	 * @param RequestType
	 * @param StringBuffer
	 *            st
	 * @return StringBuffer st update
	 */
	protected StringBuffer parseRequest(RequestType request, StringBuffer st) {
		st.append("Request:{ ");
		st.append("Request_" + idReq + "\n");
		idReq++;
		for (AttributesType at : request.getAttributes()) {
			String category = parseID(at.getCategory());
			for (AttributeType el : at.getAttribute()) {
				st.append("( " + category + "/" + parseID(el.getAttributeId()) + ", ");
				int i = 0;
				for (AttributeValueType val : el.getAttributeValue()) {
					if (i > 0)
						st.append(", ");
					st.append(parseValue(val));
					i++;
				}
				st.append(")\n");
			}
		}
		st.append("}");
		return st;
	}
}
