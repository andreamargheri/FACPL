package checkReadWriteExample;


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
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.functions.bool.FlagStatus;

public class PolicySet_ReadWriteCheck extends PolicySet {
	protected ContextRequest_Status ctxReq;

	public PolicySet_ReadWriteCheck(ContextRequest_Status ctxReq) throws MissingAttributeException {
		this.ctxReq = ctxReq;
		addId("ReadWrite_Policy");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Bob",
				new AttributeName("name", "id"));
		ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Alice",
				new AttributeName("name", "id"));
		ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.OR, e1, e2);
		addTarget(ebt);
		// Policy
		addPolicyElement(new PolicySet_Write(ctxReq));
		addPolicyElement(new PolicySet_Read(ctxReq));
		addPolicyElement(new PolicySet_StopWrite(ctxReq));
	}

	private class PolicySet_Write extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_Write(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("Write_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "write",
					new AttributeName("action", "id")));
			// PolElements
			addPolicyElement(new Rule_write());
			// Obligation
			addObligation(
					new ObligationStatus(
							new FlagStatus(),
							Effect.PERMIT,
							ObligationType.M,
							ctxReq.getStatusAttribute(new StatusAttribute("isWritingThesis", FacplStatusType.BOOLEAN)), true)
						);
		}

		private class Rule_write extends Rule {

			Rule_write() throws MissingAttributeException {
				addId("write");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Administrator",
						new AttributeName("group", "id"));
				ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "thesis.tex",
						new AttributeName("file", "id"));
				ExpressionFunction e3=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
										ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(
												new StatusAttribute("isWritingThesis",FacplStatusType.BOOLEAN))),false);
				ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2,e3);
				addTarget(ebt);
				
			}
		}
	}

	private class PolicySet_Read extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_Read(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("Read_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			ExpressionFunction file1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "thesis.tex",
					new AttributeName("file", "id"));
			ExpressionFunction file2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "facpl.pdf",
					new AttributeName("file", "id"));
			ExpressionFunction read = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "read",
					new AttributeName("action", "id"));
			ExpressionFunction writingCondition = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
					ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(
							new StatusAttribute("isWritingThesis", FacplStatusType.BOOLEAN))),
					false);
			ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.OR, file1, file2);
			
			addTarget(ebt);
			// PolElements
			addPolicyElement(new Rule_read());
			// Obligation

			addObligation( 
					new ObligationCheck(Effect.PERMIT, ObligationType.M,
							read,
							writingCondition
							));
		}


		private class Rule_read extends Rule {

			Rule_read() throws MissingAttributeException {
				addId("read");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e1 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "read",
						new AttributeName("action", "id"));
				ExpressionFunction e2 = new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
						ctxReq.getStatusAttribute(
								ctxReq.getStatusAttribute(new StatusAttribute("isWritingThesis", FacplStatusType.BOOLEAN))),
						false);
				ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2);
				addTarget(ebt);
			}
		}

	}
	
	private class PolicySet_StopWrite extends PolicySet {

		protected ContextRequest_Status ctxReq;

		public PolicySet_StopWrite(ContextRequest_Status ctxReq) throws MissingAttributeException {
			this.ctxReq = ctxReq;
			addId("Write_Policy");
			// Algorithm Combining
			addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
			// Target
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "stopWrite",
					new AttributeName("action", "id")));
			// PolElements
			addPolicyElement(new Rule_write());
			// Obligation
			addObligation(new ObligationStatus(new FlagStatus(), Effect.PERMIT, ObligationType.M,
					ctxReq.getStatusAttribute(new StatusAttribute("isWritingThesis", FacplStatusType.BOOLEAN)), false));
		}

		private class Rule_write extends Rule {

			Rule_write() throws MissingAttributeException {
				addId("write");
				// Effect
				addEffect(Effect.PERMIT);
				ExpressionFunction e1=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Administrator",
						new AttributeName("group", "id"));
				ExpressionFunction e2=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "thesis.tex",
						new AttributeName("file", "id"));
				ExpressionFunction e3=new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class,
										ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(
												new StatusAttribute("isWritingThesis",FacplStatusType.BOOLEAN))),true);
				ExpressionBooleanTree ebt = new ExpressionBooleanTree(ExprBooleanConnector.AND, e1, e2,e3);
				addTarget(ebt);
			}
		}
	}
}
