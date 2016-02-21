package checkExample.three;

import it.unifi.facpl.lib.context.ContextRequest_Status;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.ObligationCheck;
import it.unifi.facpl.lib.policy.ObligationStatus;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.functions.arithmetic.AddStatus;

@SuppressWarnings("all")
public class PolicySet_NamePolicySetTwo extends PolicySet {
	protected ContextRequest_Status ctxReq;

	public PolicySet_NamePolicySetTwo(ContextRequest_Status ctxReq) throws MissingAttributeException {
		this.ctxReq = ctxReq;
		addId("NamePolicySetTwo");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "3", 
				new AttributeName("category", "id")));
		// PolElements
		addPolicyElement(new Rule_ruleName());
		
		// Obligation
		addObligation(
				new ObligationStatus(
						new AddStatus(),
						Effect.PERMIT,
						ObligationType.M, 
						ctxReq.getStatusAttribute(new StatusAttribute("accessNumber", FacplStatusType.INT)), 1) 
				);
		addObligation( //PERSISTENTE
				new ObligationCheck(Effect.PERMIT, 
						ObligationType.M,
						new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "3", 
								new AttributeName("category", "id")), 
						new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThan.class, 
								ctxReq.getStatusAttribute(ctxReq.getStatusAttribute(new StatusAttribute("accessNumber", FacplStatusType.INT))), 3)));
 
	}

	private class Rule_ruleName extends Rule {

		Rule_ruleName() throws MissingAttributeException {
			addId("ruleName");
			// Effect
			addEffect(Effect.PERMIT);
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThan.class,
					ctxReq.getStatusAttribute(
							ctxReq.getStatusAttribute(new StatusAttribute("accessNumber", FacplStatusType.INT))),
					88));
		}
	}
}
