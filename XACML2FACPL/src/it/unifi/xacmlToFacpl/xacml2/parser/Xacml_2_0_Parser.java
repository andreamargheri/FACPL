package it.unifi.xacmlToFacpl.xacml2.parser;

import it.unifi.xacmlToFacpl.xacml2.context.jaxb.AttributeType;
import it.unifi.xacmlToFacpl.xacml2.context.jaxb.AttributeValueType;
import it.unifi.xacmlToFacpl.xacml2.context.jaxb.RequestType;
import it.unifi.xacmlToFacpl.xacml2.context.jaxb.SubjectType;
import it.unifi.xacmlToFacpl.xacml2.context.jaxb.ResourceType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.ActionMatchType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.ActionType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.ApplyType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.AttributeDesignatorType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.ConditionType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.EnvironmentMatchType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.IdReferenceType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.PolicySetType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.PolicyType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.ResourceMatchType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.RuleType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.SubjectAttributeDesignatorType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.SubjectMatchType;
import it.unifi.xacmlToFacpl.xacml2.policy.jaxb.TargetType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class Xacml_2_0_Parser {

	private JAXBContext jc_req;
	private JAXBContext jc_pol;
	private Unmarshaller u_req;
	private Unmarshaller u_pol;
	private static int id;
	private static int idReq;
	protected Logger l;

	private static Xacml_2_0_Parser parser;

	private static final String ACTION_ID = "action";
	private static final String SUBJECT_ID = "subject";
	private static final String ENV_ID = "environment";
	private static final String RESOURCE_ID = "resource";

	public static Xacml_2_0_Parser getInstance() {
		if (parser == null) {
			parser = new Xacml_2_0_Parser();
		}
		return parser;
	}

	private Xacml_2_0_Parser() {
		l = Logger.getLogger(Xacml_2_0_Parser.class);
		id = 0;
		idReq = 1;
		try {
			l.trace("Instaced JAXBContext");
			jc_req = JAXBContext
					.newInstance("it.unifi.xacmlToFacpl.xacml2.context.jaxb");
			jc_pol = JAXBContext
					.newInstance("it.unifi.xacmlToFacpl.xacml2.policy.jaxb");
			u_req = jc_req.createUnmarshaller();
			u_pol = jc_pol.createUnmarshaller();

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

		Object obj;
		try {
			obj = u_pol.unmarshal(d);
		} catch (Throwable e) {
			obj = u_req.unmarshal(d);
		}

		if (obj instanceof JAXBElement) {
			el = (JAXBElement<?>) obj;
			// call policy parser or request parser
			if (el.getValue() instanceof PolicySetType) {
//				st.append("{ \n pep: base \n pdp: permit-overrides \n");
				l.trace("PolicySet Item");
				this.parsePolicy((PolicySetType) el.getValue(), st);
//				st.append("\n }");
			} else if (el.getValue() instanceof PolicyType) {
//				st.append("{ \n pep: base \n pdp: permit-overrides \n");
				l.trace("Policy Item");
				this.parsePolicy((PolicyType) el.getValue(), st);
//				st.append("\n }");
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

		// Marshaller m = jc.createMarshaller();
		// m.marshal(obj, System.out);
		//
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
			st.append("PolicySet " + parseID_Name(polSet.getPolicySetId()) + " { ");
		} else {
			// add unique name to polSet
			l.debug("No policySet identifier. Chosen a default one");
			st.append("PolicySet polSet_" + id + "{ ");
			id++;
		}
		st.append(getCombingAlgName(polSet.getPolicyCombiningAlgId()) + "\n");
		l.trace("Added Combing Alg: "
				+ getCombingAlgName(polSet.getPolicyCombiningAlgId()));
		l.trace("Parsing target..");
		if (polSet.getTarget() != null) {

			/*
			 * << PARSE POLICY SET TARGET >>>
			 */
			String s = parseTarget(polSet.getTarget());
			if (!s.trim().isEmpty())
				st.append("target: " + s.trim() + "\n");

		}
		st.append("policies: \n");
		// policy or policy set or reference
		for (JAXBElement<?> p : polSet
				.getPolicySetOrPolicyOrPolicySetIdReference()) {
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
				st.append(parseID_Name(((IdReferenceType) p.getValue()).getValue())
						+ "\n");
			}
		}

		/*
		 * <<< OBLIGATIONS >>>
		 */

		// if (polSet.getObligationExpressions() != null ||
		// polSet.getAdviceExpressions() != null){
		// st.append("\n");
		// //oblgiations and advices
		// st.append("obl: " +
		// parseObls(polSet.getObligationExpressions(),polSet.getAdviceExpressions())+"\n");
		// }
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
			st.append("Policy " + parseID_Name(policy.getPolicyId()) + " < ");
		} else {
			// add unique name to polSet
			l.debug("No policy identifier. Chosen a default one");
			st.append("Policy policy_" + id + " < ");
			id++;
		}
		st.append(getCombingAlgName(policy.getRuleCombiningAlgId()) + "\n");
		l.trace("Added Combing Alg: "
				+ getCombingAlgName(policy.getRuleCombiningAlgId()));
		l.trace("Parsing target..");
		if (policy.getTarget() != null) {

			/*
			 * <<<< PARSE TARGET POLICY >>>>>
			 */
			String s = parseTarget(policy.getTarget());
			if (!s.trim().isEmpty())
				st.append("target: " + s.trim() + "\n");

		}
		st.append("rules: \n");
		// rules
		for (Object r : policy
				.getCombinerParametersOrRuleCombinerParametersOrVariableDefinition()) {
			if (r instanceof RuleType) {
				l.trace("Found a rule");
				st.append(parseRule((RuleType) r) + "\n");
			}
		}

		/*
		 * <<< OBLIGATIONS >>>
		 */

		// //oblgiations and advices
		// if (policy.getObligationExpressions() != null ||
		// policy.getAdviceExpressions() != null){
		// st.append("\n");
		// st.append("obl: " +
		// parseObls(policy.getObligationExpressions(),policy.getAdviceExpressions())+"\n");
		// }
		st.append(">");
		l.trace("End Policy Parsing");
		return st;
	}

	private String parseRule(RuleType r) {
		StringBuffer s = new StringBuffer();
		if (r.getRuleId() != "") {
			s.append("Rule " + parseID_Name(r.getRuleId()));
		} else {
			// add unique name to polSet
			l.debug("No rule identifier. Chosen a default one");
			s.append("Rule rule_" + id);
			id++;
		}
		s.append(" (" + r.getEffect().name().toLowerCase() + " ");
		if (r.getTarget() != null) {
			/*
			 * <<< PARSE RULE TARGET >>>>
			 */
			String st = parseTarget(r.getTarget());
			if (!st.trim().isEmpty())
				s.append("target: " + st.trim() + "\n");

		}
		if (r.getCondition() != null) {
			s.append("condition: " + parseCondition(r.getCondition()) + "\n");
		}

		/*
		 * <<< OBLGIATION >>>
		 */

		// if (r.getObligationExpressions() != null || r.getAdviceExpressions()
		// != null){
		// s.append("obl: " +
		// parseObls(r.getObligationExpressions(),r.getAdviceExpressions()));
		// }

		// closing brackets
		s.append(")");
		return s.toString();
	}

	private String getCombingAlgName(String algId) {
		if (algId.contains("ordered-permit")) {
			return "ordered-permit-overrides";
		} else if (algId.contains("ordered-deny")) {
			return "ordered-deny-overrides";
		} else if (algId.contains("permit-overrides")) {
			return "permit-overrides";
		} else if (algId.contains("deny-overrides")) {
			return "deny-overrides";
		} else if (algId.contains("first")) {
			return "first-applicable";
		} else if (algId.contains("only-one")) {
			return "only-one-applicable";
		} else if (algId.contains("permit-unless")) {
			return "permit-unless-deny";
		} else if (algId.contains("deny-unless")) {
			return "deny-unless-permit";
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
			StringBuffer[] s = new StringBuffer[4];

			// ACTIONs

			if (t.getActions() != null) {
				if (t.getActions().getAction().size() > 0) {
					s[0] = new StringBuffer();
					int j = 1;
					s[0].append("(");
					for (ActionType a : t.getActions().getAction()) {
						if (a.getActionMatch().size() > 0) {
							s[0].append("(");
							int i = 1;
							for (ActionMatchType match : a.getActionMatch()) {
								s[0].append(parseMatch(match));
								if (i < a.getActionMatch().size())
									s[0].append(" && ");
								i++;
							}
							s[0].append(")");
						}
						if (j < t.getActions().getAction().size())
							s[0].append(" || ");
						j++;
					}
					s[0].append(")");
				}
			}

			// SUBJECTs

			if (t.getSubjects() != null) {
				if (t.getSubjects().getSubject().size() > 0) {
					s[1] = new StringBuffer();
					int j = 1;
					s[1].append("(");
					for (it.unifi.xacmlToFacpl.xacml2.policy.jaxb.SubjectType a : t
							.getSubjects().getSubject()) {

						if (a.getSubjectMatch().size() > 0) {
							s[1].append("(");
							int i = 1;
							for (SubjectMatchType match : a.getSubjectMatch()) {
								s[1].append(parseMatch(match));
								if (i < a.getSubjectMatch().size())
									s[1].append(" && ");
								i++;
							}
							s[1].append(")");
						}
						if (j < t.getSubjects().getSubject().size())
							s[1].append(" || ");
						j++;
					}
					s[1].append(")");
				}
			}

			// RESOURCEs

			if (t.getResources() != null) {
				if (t.getResources().getResource().size() > 0) {
					s[2] = new StringBuffer();
					int j = 1;
					s[2].append("(");
					for (it.unifi.xacmlToFacpl.xacml2.policy.jaxb.ResourceType a : t
							.getResources().getResource()) {
						if (a.getResourceMatch().size() > 0) {
							s[2].append("(");
							int i = 1;
							for (ResourceMatchType match : a.getResourceMatch()) {
								s[2].append(parseMatch(match));
								if (i < a.getResourceMatch().size())
									s[2].append(" && ");
								i++;
							}
							s[2].append(")");
						}
						if (j < t.getResources().getResource().size())
							s[2].append(" || ");
						j++;
					}
					s[2].append(")");
				}
			}

			// ENVIRONMENTs

			if (t.getEnvironments() != null) {
				if (t.getEnvironments().getEnvironment().size() > 0) {
					s[3] = new StringBuffer();
					int j = 1;
					s[3].append("(");
					for (it.unifi.xacmlToFacpl.xacml2.policy.jaxb.EnvironmentType a : t
							.getEnvironments().getEnvironment()) {
						if (a.getEnvironmentMatch().size() > 0) {
							s[3].append("(");
							int i = 1;
							for (EnvironmentMatchType match : a
									.getEnvironmentMatch()) {
								s[3].append(parseMatch(match));
								if (i < a.getEnvironmentMatch().size())
									s[3].append(" && ");
								i++;
							}
							s[3].append(")");
						}
						if (j < t.getEnvironments().getEnvironment().size())
							s[3].append(" || ");
						j++;
					}
					s[3].append(")");
				}
			}

			StringBuffer res = new StringBuffer();

			for (int i = 0; i < 4; i++) {
				if (s[i] != null) {
					if (s[i].length() > 0) {
						res.append(s[i]);

						// Decide if add &&
						if (i <= 2) {
							Boolean flag = false;
							for (int j = i + 1; j < 4; j++) {
								if (s[j] != null)
									flag = true;
							}
							if (flag)
								res.append(" && ");

						}
					}
				}
			}

			return res.toString();

		} else {
			l.debug("...target empty");
			return "";
		}
	}

	/**
	 * Match functions Only designator is supported
	 * 
	 * @param c
	 * @return
	 */
	private String parseMatch(Object match) {

		l.trace("Match parsing");
		StringBuffer s = new StringBuffer();
		if (match instanceof ActionMatchType) {

			ActionMatchType c = (ActionMatchType) match;

			s.append(getIDFunction(parseID(c.getMatchId()))); // function match
			s.append("(");
			// Cannot be a sequence of value in target
			s.append(parseValueP(c.getAttributeValue()) + ", "); // funticon
																	// matching
																	// value
			if (c.getAttributeSelector() != null) {
				s.append("---Selector Not Supported---");
				l.debug("Selector Not Supported");
			} else {
				// designator
				s.append(parseDesignator(c.getActionAttributeDesignator(),
						ACTION_ID));
			}
			s.append(")");

		}

		if (match instanceof SubjectMatchType) {
			SubjectMatchType c = (SubjectMatchType) match;

			s.append(getIDFunction(parseID(c.getMatchId()))); // function match
			s.append("(");

			s.append(parseValueP(c.getAttributeValue()) + ", "); // funticon
																	// matching
																	// value
			if (c.getAttributeSelector() != null) {
				s.append("---Selector Not Supported---");
				l.debug("Selector Not Supported");
			} else {
				// designator
				s.append(parseDesignator(c.getSubjectAttributeDesignator(),
						SUBJECT_ID));
			}
			s.append(")");
		}

		if (match instanceof ResourceMatchType) {
			ResourceMatchType c = (ResourceMatchType) match;

			s.append(getIDFunction(parseID(c.getMatchId()))); // function match
			s.append("(");

			s.append(parseValueP(c.getAttributeValue()) + ", "); // funticon
																	// matching
																	// value
			if (c.getAttributeSelector() != null) {
				s.append("---Selector Not Supported---");
				l.debug("Selector Not Supported");
			} else {
				// designator
				s.append(parseDesignator(c.getResourceAttributeDesignator(),
						RESOURCE_ID));
			}
			s.append(")");
		}

		if (match instanceof EnvironmentMatchType) {
			EnvironmentMatchType c = (EnvironmentMatchType) match;

			s.append(getIDFunction(parseID(c.getMatchId()))); // function match
			s.append("(");

			s.append(parseValueP(c.getAttributeValue()) + ", "); // funticon
																	// matching
																	// value
			if (c.getAttributeSelector() != null) {
				s.append("---Selector Not Supported---");
				l.debug("Selector Not Supported");
			} else {
				// designator
				s.append(parseDesignator(c.getEnvironmentAttributeDesignator(),
						ENV_ID));
			}
			s.append(")");
		}

		return s.toString();

	}

	// /**
	// * Set of obligations and advice of rule, policy and policy set items
	// * @param obls
	// * @param advs
	// * @return
	// */
	// private String parseObls(ObligationExpressionsType obls,
	// AdviceExpressionsType advs) {
	// StringBuffer s = new StringBuffer();
	// //obls
	// if (obls != null){
	// for (ObligationExpressionType o : obls.getObligationExpression()){
	// s.append("[ " + o.getFulfillOn().name().toLowerCase() + " M  ");
	// s.append(parseID(o.getObligationId()) + " ( ");
	// //arguments
	// int i =0;
	// for (AttributeAssignmentExpressionType arg :
	// o.getAttributeAssignmentExpression()){
	// if (i>0)
	// s.append(",");
	// s.append(parseArgumentObls(arg));
	// i++;
	// }
	// s.append(")]\n");
	// }
	// }
	// //adv
	// if(advs != null){
	// for (AdviceExpressionType a : advs.getAdviceExpression()){
	// s.append("[ " + a.getAppliesTo().name().toLowerCase() + " O ");
	// s.append(parseID(a.getAdviceId()) + " ( ");
	// //arguments
	// int i =0;
	// for (AttributeAssignmentExpressionType arg :
	// a.getAttributeAssignmentExpression()){
	// if (i>0)
	// s.append(", ");
	// s.append(parseArgumentObls(arg));
	// i++;
	// }
	// s.append(")]\n");
	// }
	// }
	// return s.toString();
	// }
	//
	// /**
	// * Not requested categoryId of the AttributeAssignementExpression (in
	// XACML is Optionally)
	// * Parsing only attributeId and expression
	// * @param argumentAssignementExpression of AdviceExpression and
	// ObligationExpression
	// * @return parsed string in FACPL-like syntax
	// */
	// private String parseArgumentObls(AttributeAssignmentExpressionType arg) {
	// StringBuffer s = new StringBuffer();
	// //structured name
	// //no attribute id for arguments, it is decided by an agreement with
	// policy writer
	// //s.append(parseID(arg.getAttributeId()) + ", ");
	// s.append(parseExpr(arg.getExpression()));
	// return s.toString();
	// }

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
		// onlt ApplyType, Designator and Value
		Object ob = exp.getValue();
		/*
		 * Attribute values (double type: one request, one policy)
		 */
		if (ob instanceof it.unifi.xacmlToFacpl.xacml2.context.jaxb.AttributeValueType) {

			// s.append(parseValueR((it.unifi.xacmlToFacpl.xacml2.context.jaxb.AttributeValueType)ob));

		} else if (ob instanceof it.unifi.xacmlToFacpl.xacml2.policy.jaxb.AttributeValueType) {
			s.append(parseValueP((it.unifi.xacmlToFacpl.xacml2.policy.jaxb.AttributeValueType) ob));
		}
		/*
		 * END Attribute values (double type: one request, one policy)
		 */
		else if (ob instanceof ApplyType) {
			s.append(parseApply((ApplyType) ob));

		} else if (ob instanceof SubjectAttributeDesignatorType) {
			s.append(parseDesignator((AttributeDesignatorType) ob, SUBJECT_ID));
		} 
//		else if (ob instanceof ResourceAttributeDesignatorType) {
//			s.append(parseDesignator((AttributeDesignatorType) ob, RESOURCE_ID));
//		} else if (ob instanceof EnvironmentAttributeDesignatorType) {
//			s.append(parseDesignator((AttributeDesignatorType) ob, ENV_ID));
//		} else if (ob instanceof ActionAttributeDesignatorType) {
//			s.append(parseDesignator((AttributeDesignatorType) ob, ACTION_ID));
//		}
		else {

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
	private String parseDesignator(AttributeDesignatorType des, String category) {

		l.trace(category);
		l.trace(des.getAttributeId());
		return category + "/" + parseID_Name(des.getAttributeId());
	}

	/**
	 * Processing the AttributeValue element. <b>Notably, an AttributeValue can
	 * contain only one value, sequence of AttributeValue nested within other
	 * AttributeValue must be avoided </b>
	 * 
	 * @param AttributeValueType
	 *            (request type)
	 * 
	 * @return String parserValue corresponding to the literal expressed in the
	 *         XACML element
	 */
	private String parseValueR(
			it.unifi.xacmlToFacpl.xacml2.context.jaxb.AttributeValueType ob,
			String type) {
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

		// String type = parseID(ob.getDataType());
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

		// return el.toString().trim();

	}

	/**
	 * Processing the AttributeValue element. <b>Notably, an AttributeValue can
	 * contain only one value, sequence of AttributeValue nested within other
	 * AttributeValue must be avoided </b>
	 * 
	 * @param AttributeValueType
	 *            (request type)
	 * 
	 * @return String parserValue corresponding to the literal expressed in the
	 *         XACML element
	 */
	private String parseValueP(
			it.unifi.xacmlToFacpl.xacml2.policy.jaxb.AttributeValueType ob) {
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
		s.append(getIDFunction(parseID(ob.getFunctionId())));
		s.append("(");
		int i = 0;
		for (JAXBElement<?> ex : ob.getExpression()) {
			if (i > 0)
				s.append(", ");
			s.append(parseExpr(ex));
			i++;
		}
		s.append(")");
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
		if (Character.isDigit(id.charAt(0))){
			id = "id_" + id;
		}
		id = id.substring(id.lastIndexOf(":") + 1);
		return id.replace(':', '_').replace(' ', '_').replace('.', '_');

	}
	
	/**
	 * Remove xacml namespace and return the identifier Available for Element Name
	 * 
	 * @param id
	 * @return
	 */
	private String parseID_Name(String id) {
		// replace all ":" in string
		if (Character.isDigit(id.charAt(0))){
			id = "id_" + id;
		}
		id = id.substring(id.lastIndexOf(":") + 1);
		return id.replace(':', '_').replace(' ', '_').replace('.', '_').replace("-", "_");

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
			return "add";
		}
		if (replace.contains("abs")) {
			return "abs";
		}
		if (replace.contains("mod")) {
			return "mod";
		}
		if (replace.contains("multiply")) {
			return "multiply";
		}
		if (replace.contains("divide")) {
			return "divide";
		}
		// bag
		if (replace.contains("one")) {
			return "at-least-one-member-of";
		}
		if (replace.contains("subset")) {
			return "subset";
		}
		if (replace.contains("bag")) {
			return "bag";
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
			return "and";
		}
		if (replace.contains("or")) {
			return "or";
		}
		if (replace.contains("not")) {
			return "not";
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
		st.append("Request_" + String.format("%08d", idReq) + "\n");
		idReq++;

		/*
		 * For each on attribute values that are defined within the four
		 * categories inside a request
		 */
		// Action
		for (AttributeType a : request.getAction().getAttribute()) {
			st.append("(" + ACTION_ID + "/" + parseID_Name(a.getAttributeId())
					+ ", ");
			String datatype = a.getDataType();
			for (AttributeValueType val : a.getAttributeValue()) {
				st.append(parseValueR(val, datatype));
			}
			st.append(")\n");
		}
		// Subject
		for (SubjectType s : request.getSubject()) {
			for (AttributeType a : s.getAttribute()) {
				String datatype = a.getDataType();
				st.append("(" + SUBJECT_ID + "/" + parseID_Name(a.getAttributeId())
						+ ", ");
				for (AttributeValueType val : a.getAttributeValue()) {
					st.append(parseValueR(val, datatype));
				}
				st.append(")\n");
			}
		}
		// Resource
		for (ResourceType s : request.getResource()) {
			for (AttributeType a : s.getAttribute()) {
				String datatype = a.getDataType();
				st.append("(" + RESOURCE_ID + "/" + parseID_Name(a.getAttributeId())
						+ ", ");
				for (AttributeValueType val : a.getAttributeValue()) {
					st.append(parseValueR(val, datatype));
				}
				st.append(")\n");
			}
		}
		// Environment
		for (AttributeType a : request.getEnvironment().getAttribute()) {
			st.append("(" + ENV_ID + "/" + parseID_Name(a.getAttributeId()) + ", ");
			String datatype = a.getDataType();
			for (AttributeValueType val : a.getAttributeValue()) {
				st.append(parseValueR(val, datatype));
			}
			st.append(")\n");
		}

		st.append("}");
		return st;
	}
}
