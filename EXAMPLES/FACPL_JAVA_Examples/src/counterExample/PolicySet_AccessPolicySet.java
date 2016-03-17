package counterExample;

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
import it.unifi.facpl.system.status.functions.arithmetic.AddStatus;

@SuppressWarnings("all")
public class PolicySet_AccessPolicySet extends PolicySet {
	public PolicySet_AccessPolicySet() throws MissingAttributeException {
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
						new AddStatus(),
						Effect.PERMIT,
						ObligationType.M, 
						new StatusAttribute("accessCounter", FacplStatusType.INT), 1) 
				); 
	}

	private class Rule_Access extends Rule {

		Rule_Access() throws MissingAttributeException {
			addId("access");
			// Effect
			addEffect(Effect.PERMIT);
			addTarget(new ExpressionFunction(it.unifi.facpl.lib.function.comparison.LessThan.class, 
					new StatusAttribute("accessCounter", FacplStatusType.INT), 5)); 
		}
	}
}
