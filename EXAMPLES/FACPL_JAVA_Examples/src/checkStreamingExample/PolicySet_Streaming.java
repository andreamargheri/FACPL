package checkStreamingExample;


import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.ObligationCheck;
import it.unifi.facpl.lib.policy.ObligationStatus;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.functions.arithmetic.AddStatus;
import it.unifi.facpl.system.status.functions.arithmetic.SetDate;
import it.unifi.facpl.system.status.functions.arithmetic.SumDateStatus;
import it.unifi.facpl.system.status.functions.bool.FlagStatus;
import it.unifi.facpl.system.status.functions.strings.SetString;

public class PolicySet_Streaming extends PolicySet {
	protected ContextRequest_Status ctxReq;

	public PolicySet_Streaming(ContextRequest_Status ctxReq) throws Exception {
		this.ctxReq = ctxReq;
		addId("Streaming_Policy");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		
		// Policy
		addPolicyElement(new PolicySet_LoginAlice(ctxReq));
		addPolicyElement(new PolicySet_LoginBob(ctxReq));
		addPolicyElement(new PolicySet_ListenAlice(ctxReq));
		addPolicyElement(new PolicySet_ListenBob(ctxReq));
	}

	private class PolicySet_LoginAlice extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_LoginAlice(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("LoginAlice_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Alice",
					new AttributeName("name", "id"));
			ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "login",
					new AttributeName("action", "id"));
			ExpressionBooleanTree ebt= new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_Login());
			// Obligation
			addObligation(
					new ObligationStatus(
							new SetString(),
							Effect.PERMIT,
							ObligationType.M,
							ctxReq.getStatusAttribute(new StatusAttribute("loginAlice", FacplStatusType.STRING)), "PREMIUM")
						);
			addObligation(
					new ObligationStatus(
							new FlagStatus(),
							Effect.PERMIT,
							ObligationType.M,
							ctxReq.getStatusAttribute(new StatusAttribute("streamingAlice", FacplStatusType.BOOLEAN)), true)
						);
		}

		private class Rule_Login extends Rule {

			Rule_Login() throws MissingAttributeException {
				addId("LoginAlice_Rule");
				// Effect
				addEffect(Effect.PERMIT);
				addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("passwordAlice", FacplStatusType.STRING))),
						new AttributeName("password", "id")));
			}
		}
	}
	
	private class PolicySet_LoginBob extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_LoginBob(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("LoginBob_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Bob",
					new AttributeName("name", "id"));
			ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "login",
					new AttributeName("action", "id"));
			ExpressionBooleanTree ebt= new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_LoginBob());
			// Obligation
			addObligation(
					new ObligationStatus(
							new SetString(),
							Effect.PERMIT,
							ObligationType.M,
							ctxReq.getStatusAttribute(new StatusAttribute("loginBob", FacplStatusType.STRING)), "STANDARD")
						);
			addObligation(
					new ObligationStatus(
							new FlagStatus(),
							Effect.PERMIT,
							ObligationType.M,
							ctxReq.getStatusAttribute(new StatusAttribute("streamingBob", FacplStatusType.BOOLEAN)), true)
						);
		}

		private class Rule_LoginBob extends Rule {

			Rule_LoginBob() throws MissingAttributeException {
				addId("LoginBob_Rule");
				// Effect
				addEffect(Effect.PERMIT);
				addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("passwordBob", FacplStatusType.STRING))),
						new AttributeName("password", "id")));
			}
		}
	}
	
	private class PolicySet_ListenAlice extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_ListenAlice(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("ListenAlice_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "listen",
					new AttributeName("action", "id"));
			ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Alice",
					new AttributeName("name", "id"));
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_Login());
			// Obligation
			addObligation( 
					new ObligationCheck(Effect.PERMIT, ObligationType.M,
							new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Alice",
									new AttributeName("name", "id")),
							new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
									ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(
											new StatusAttribute("streamingAlice", FacplStatusType.BOOLEAN))),
									true)
							));
		}

		private class Rule_Login extends Rule {

			Rule_Login() throws MissingAttributeException {
				addId("ListenAlice_Rule");
				// Effect
				addEffect(Effect.PERMIT);
				
				addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("loginAlice", FacplStatusType.STRING))),
						"PREMIUM"));
			}
		}
	}
	
	private class PolicySet_ListenBob extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_ListenBob(ContextRequest_Status ctxReq) throws Exception {
			this.ctxReq = ctxReq;
			addId("ListenBob_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "listen",
					new AttributeName("action", "id"));
			ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Bob",
					new AttributeName("name", "id"));
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_ListenBob());
			// Obligation
			addObligation( 
					new ObligationCheck(Effect.PERMIT, ObligationType.M,
							new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Bob",
									new AttributeName("name", "id")),
							new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
									ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(
											new StatusAttribute("streamingBob", FacplStatusType.BOOLEAN))),
									true),
							new FacplDate("00:00:01")));
		}

		private class Rule_ListenBob extends Rule {

			Rule_ListenBob() throws MissingAttributeException {
				addId("ListenBob_Rule");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("loginBob", FacplStatusType.STRING))),
						"STANDARD");
				addTarget(e);
				addObligation(
						new ObligationStatus(
								new SetString(),
								Effect.PERMIT,
								ObligationType.M,
								ctxReq.getStatusAttribute(new StatusAttribute("loginBob", FacplStatusType.STRING)), "noLogin")
							);
			}
		}
	}
}
