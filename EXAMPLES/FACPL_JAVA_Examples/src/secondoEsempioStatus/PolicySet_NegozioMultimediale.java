package secondoEsempioStatus;

import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExprBooleanConnector;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionBooleanTree;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.ObligationStatus;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.functions.arithmetic.AddStatus;
import it.unifi.facpl.system.status.functions.arithmetic.SubStatus;
import it.unifi.facpl.system.status.functions.bool.FlagStatus;

public class PolicySet_NegozioMultimediale extends PolicySet {
	protected ContextRequest_Status ctxReq;

	public PolicySet_NegozioMultimediale(ContextRequest_Status ctxReq) throws MissingAttributeException {
		this.ctxReq = ctxReq;
		addId("ReadWrite_Policy");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Bob",
				new AttributeName("name", "id"));
		ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Alice",
				new AttributeName("name", "id"));
		ExpressionFunction e3 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Carl",
				new AttributeName("name", "id"));
		
		ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.OR, e1, e2,e3);
		
		addTarget(ebt);
		// Policy
		addPolicyElement(new PolicySet_BuyType0(ctxReq));
		addPolicyElement(new PolicySet_BuyType1(ctxReq));
		addPolicyElement(new PolicySet_BuyType2(ctxReq));
		addPolicyElement(new PolicySet_View0(ctxReq));
		addPolicyElement(new PolicySet_View1(ctxReq));
		addPolicyElement(new PolicySet_View2(ctxReq));
	}

	private class PolicySet_BuyType0 extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_BuyType0(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("Buy_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.FirstApplicable.class);
			// Target
			ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"file1",
					new AttributeName("file", "id")
					);
			ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"buy",
					new AttributeName("action", "id")
					);
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_buy());
			// Obligation
			addObligation(new ObligationStatus(new FlagStatus(), Effect.PERMIT, ObligationType.M,
					ctxReq.getStatusAttribute(new StatusAttribute("accessTypeAlice", FacplStatusType.INT)), 0));
		}

		private class Rule_buy extends Rule {

			Rule_buy() throws MissingAttributeException {
				addId("buy");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("buyType", FacplStatusType.INT))),
						0);
				ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("name", FacplStatusType.STRING))),
						"Alice");
				ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
				addTarget(ebt);
			}
		}
	}
	
	private class PolicySet_BuyType1 extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_BuyType1(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("Buy_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.FirstApplicable.class);
			// Target
			ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"file1",
					new AttributeName("file", "id")
					);
			ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"buy",
					new AttributeName("action", "id")
					);
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_buy());
			// Obligation
			addObligation(new ObligationStatus(new FlagStatus(), Effect.PERMIT, ObligationType.M,
					ctxReq.getStatusAttribute(new StatusAttribute("accessTypeBob", FacplStatusType.INT)), 1));
		}

		private class Rule_buy extends Rule {

			Rule_buy() throws MissingAttributeException {
				addId("buy");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("buyType", FacplStatusType.INT))),
						1);
				ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("name", FacplStatusType.STRING))),
						"Bob");
				ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
				addTarget(ebt);
			}
		}
	}

	private class PolicySet_BuyType2 extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_BuyType2(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("Buy_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.FirstApplicable.class);
			// Target
			ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"file1",
					new AttributeName("file", "id")
					);
			ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"buy",
					new AttributeName("action", "id")
					);
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_buy());
			// Obligation
			addObligation(new ObligationStatus(new FlagStatus(), Effect.PERMIT, ObligationType.M,
					ctxReq.getStatusAttribute(new StatusAttribute("accessTypeCarl", FacplStatusType.INT)), 2));
		}

		private class Rule_buy extends Rule {

			Rule_buy() throws MissingAttributeException {
				addId("buy");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("buyType", FacplStatusType.INT))),
						1);
				ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("name", FacplStatusType.STRING))),
						"Carl");
				ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
				addTarget(ebt);
			}
		}
	}
	
	private class PolicySet_View0 extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_View0(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("View_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"file1",
					new AttributeName("file", "id")
					);
			ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"View",
					new AttributeName("action", "id")
					);
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_view());
			// Obligation
			
		}

		private class Rule_view extends Rule {

			Rule_view() throws MissingAttributeException {
				addId("view");
				// Effect
				addEffect(Effect.PERMIT);
				addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("accessTypeAlice", FacplStatusType.INT))),
						0));
			}
		}

	}
	
	private class PolicySet_View1 extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_View1(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("View_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"file1",
					new AttributeName("file", "id")
					);
			ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"View",
					new AttributeName("action", "id")
					);
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_view());
			// Obligation
			
		}

		private class Rule_view extends Rule {

			Rule_view() throws MissingAttributeException {
				addId("view");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("accessTypeBob", FacplStatusType.INT))),
						1);
				ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThan.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("tempoViewFile1", FacplStatusType.DATE))),
						"INSERIRE DATA");
				ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
				addTarget(ebt);
			}
		}

	}
	
	private class PolicySet_View2 extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_View2(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("View_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"file1",
					new AttributeName("file", "id")
					);
			ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					"View",
					new AttributeName("action", "id")
					);
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_view());
			// Obligation
			//FARE OBLIGATION SUB PER IL COUNTER DELLE VIEW
		}

		private class Rule_view extends Rule {

			Rule_view() throws MissingAttributeException {
				addId("view");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("accessTypeBob", FacplStatusType.INT))),
						1);
				ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThan.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("counterViewFile1", FacplStatusType.INT))),
						12384032);//METTERE NUMERO MASSIMO
				ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
				addTarget(ebt);
			}
		}

	}
}
