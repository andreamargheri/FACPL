package writeExample;

import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.ObligationStatus;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.functions.bool.FlagStatus;

public class PolicySet_ReadWrite extends PolicySet {
	
	protected ContextRequest_Status ctxReq;
	
	public PolicySet_ReadWrite(ContextRequest_Status ctxReq) throws MissingAttributeException {
		this.ctxReq = ctxReq;
		addId("ReadWrite");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Lucrezia", 
				new AttributeName("name", "id")));
		// PolElements
		addPolicyElement(new Rule_read());
		addPolicyElement(new Rule_write());
		// Obligation
		addObligation(
				new ObligationStatus(
						new FlagStatus(),
						Effect.PERMIT,
						ObligationType.M, 
						ctxReq.getStatusAttribute(new StatusAttribute("isWriting", FacplStatusType.BOOLEAN)), true) 
				); 
	}

	private class Rule_read extends Rule {

		Rule_read() throws MissingAttributeException {
			addId("read");
			// Effect
			addEffect(Effect.PERMIT);
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(new StatusAttribute("isWriting", FacplStatusType.BOOLEAN))), false)); 
		}
	}
	
	private class Rule_write extends Rule {

		Rule_write() throws MissingAttributeException {
			addId("write");
			// Effect
			addEffect(Effect.PERMIT);
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, 
					ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(new StatusAttribute("isWriting", FacplStatusType.BOOLEAN))), false)); 
		}
	}
}
