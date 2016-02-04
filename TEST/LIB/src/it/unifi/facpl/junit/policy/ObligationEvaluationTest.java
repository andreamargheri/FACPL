package it.unifi.facpl.junit.policy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unifi.facpl.junit.util.request.ContextRequest_NoContext;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.policy.Obligation;
import it.unifi.facpl.lib.util.AttributeName;

public class ObligationEvaluationTest {

	private Obligation o1, o2, o3, o4;
	private ContextRequest req1;
	private AbstractFulfilledObligation value1, value2, value3;

	@Before
	public void setUp() {
		req1 = ContextRequest_NoContext.getContextReq();

		o1 = new Obligation("mailTo", Effect.PERMIT, ObligationType.M,
				new AttributeName("subject", "permission"));
		o2 = new Obligation("mailTo", Effect.DENY, ObligationType.M,
				new AttributeName("subject", "permission"), new AttributeName(
						"subject", "num"));
		o3 = new Obligation("mailTo", Effect.DENY, ObligationType.M,
				new AttributeName("subject", "permission"), new AttributeName(
						"subject", "missing"));
		o4 = new Obligation("mailTo", Effect.DENY, ObligationType.O,
				new AttributeName("subject", "missing"));

	}

	@Test
	public void testObligation() throws Throwable {
		value1 = o1.getObligationValue(req1);
		assertEquals("PR01", value1.getArguments().getFirst());
		assertEquals(value1.getEvaluatedOn(), Effect.PERMIT);
		assertEquals(value1.getType(), ObligationType.M);

		value2 = o2.getObligationValue(req1);
		assertEquals("PR01", value2.getArguments().getFirst());
		assertEquals(10, value2.getArguments().getLast());
		assertEquals(value2.getEvaluatedOn(), Effect.DENY);
		assertEquals(value2.getType(), ObligationType.M);

		try {
			value3 = o3.getObligationValue(req1);
			assertEquals("PR01", value3.getArguments().getFirst());
			assertEquals(10, value3.getArguments().getLast());
			assertEquals(value3.getEvaluatedOn(), Effect.DENY);
			assertEquals(value3.getType(), ObligationType.M);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Obligation Fulfillment Failed");
		}
	}

	@Test
	public void testAdvice() throws Throwable{
		try {
			o4.getObligationValue(req1);
//			assertEquals("PR01", value3.getArguments().getFirst());
//			assertEquals(10, value3.getArguments().getLast());
//			assertEquals(value3.getEvaluatedOn(), Effect.DENY);
//			assertEquals(value3.getType(), TypeObl.M);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Obligation Fulfillment Failed");
		}
	}
}
