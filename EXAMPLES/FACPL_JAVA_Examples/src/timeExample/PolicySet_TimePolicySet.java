package timeExample;

import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.ObligationStatus;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.FacplDate;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.functions.arithmetic.AddStatus;
import it.unifi.facpl.system.status.functions.arithmetic.SumDateStatus;

@SuppressWarnings("all")
public class PolicySet_TimePolicySet extends PolicySet {
	protected ContextRequest_Status ctxReq;
	public PolicySet_TimePolicySet(ContextRequest_Status ctxReq) throws MissingAttributeException {
		this.ctxReq = ctxReq;
		addId("AccessPolicySet");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "Lucrezia", 
				new AttributeName("name", "id")));
		// PolElements
		addPolicyElement(new Rule_Access());
		// Obligation
		addObligation(
				new ObligationStatus(
						new SumDateStatus(),
						Effect.PERMIT,
						ObligationType.M, 
						ctxReq.getStatusAttribute(new StatusAttribute("lastAccess", FacplStatusType.DATE)), new FacplDate("03:11:2")) 
				); 
	}

	private class Rule_Access extends Rule {

		Rule_Access() throws MissingAttributeException {
			addId("time");
			// Effect
			addEffect(Effect.PERMIT);
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThan.class, 
					ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(new StatusAttribute("lastAccess", FacplStatusType.DATE))), new FacplDate("16:35:27"))); 
		}
	}
}
