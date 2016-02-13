package usagecontrol.foo;

import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.ExpressionFunction;
import it.unifi.facpl.lib.policy.Obligation;
import it.unifi.facpl.lib.policy.ObligationStatus;
import it.unifi.facpl.lib.policy.PolicySet;
import it.unifi.facpl.lib.policy.Rule;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;
import it.unifi.facpl.system.status.functions.arithmetic.AddStatus;

@SuppressWarnings("all")
public class PolicySet_NamePolicySetTwo extends PolicySet {
	protected FacplStatus status;

	public PolicySet_NamePolicySetTwo() throws MissingAttributeException {
		addId("NamePolicySetTwo");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "2",
				new AttributeName("category", "id")));
		// PolElements
		addPolicyElement(new Rule_ruleName());
		// Obligation
	}
	
	
	public PolicySet_NamePolicySetTwo(FacplStatus status) throws MissingAttributeException {
		this.status = status;
		addId("NamePolicySetTwo");
		// Algorithm Combining
		addCombiningAlg(it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy.class);
		// Target
		addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.Equal.class, "9", 
				new AttributeName("category", "id")));
		// PolElements
		addPolicyElement(new Rule_ruleName());
		// Obligation
		addObligation(
				new ObligationStatus(
						new AddStatus(),
						Effect.PERMIT,
						ObligationType.M, 
						status.getStatusAttribute(new StatusAttribute("accessNumber", FacplStatusType.INT)), 1) 
				); 
	}

	private class Rule_ruleName extends Rule {

		Rule_ruleName() throws MissingAttributeException {
			addId("ruleName");
			// Effect
			addEffect(Effect.PERMIT);
			// Obligations
			//addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThan.class, 
				//	status.getStatusAttribute(new StatusAttribute("accessNumber", FacplStatusType.INT)), 3)); 
		}
	}
}
