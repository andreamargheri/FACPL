package it.unifi.facpl.junit.policy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unifi.facpl.junit.util.AbstractRule;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.TargetDecision;

public class Rule {

	private AbstractRule r1, r2, r5, r6, r7, r8, r11, r12, r13, r14, r17, r18;

	private AbstractRule empty1, empty2, empty3, empty4, // empty5, empty6,
			empty7, empty8, empty9, empty10, empty11, empty12, empty13, empty14;

	static private ExtendedDecision e_permit = ExtendedDecision.PERMIT;
	static private ExtendedDecision e_deny = ExtendedDecision.DENY;
	static private ExtendedDecision e_notapp = ExtendedDecision.NOT_APPLICABLE;
	static private ExtendedDecision e_indetD = ExtendedDecision.INDETERMINATE_D;
	static private ExtendedDecision e_indetP = ExtendedDecision.INDETERMINATE_P;
	@SuppressWarnings("unused")
	static private ExtendedDecision e_indetDP = ExtendedDecision.INDETERMINATE_DP;

	private static final TargetDecision match = TargetDecision.TRUE;
	private static final TargetDecision nomatch = TargetDecision.FALSE;
	private static final TargetDecision indet = TargetDecision.INDETERMINATE;

	private static final Effect permit = Effect.PERMIT;
	private static final Effect deny = Effect.DENY;

	static private Boolean err_obl_true = true;
	static private Boolean err_obl_false = false;

	@Before
	public void setUp() {
		r1 = new AbstractRule(permit, match, err_obl_false);
		r2 = new AbstractRule(deny, match, err_obl_false);
		r5 = new AbstractRule(permit, match, err_obl_true);
		r6 = new AbstractRule(deny, match, err_obl_true);

		r7 = new AbstractRule(permit, nomatch, err_obl_false);
		r8 = new AbstractRule(deny, nomatch, err_obl_false);
		r11 = new AbstractRule(permit, nomatch, err_obl_true);
		r12 = new AbstractRule(deny, nomatch, err_obl_true);

		r13 = new AbstractRule(permit, indet, err_obl_false);
		r14 = new AbstractRule(deny, indet, err_obl_false);
		r17 = new AbstractRule(permit, indet, err_obl_true);
		r18 = new AbstractRule(deny, indet, err_obl_true);

		empty1 = new AbstractRule(permit, err_obl_false);
		empty2 = new AbstractRule(deny, err_obl_false);
		empty3 = new AbstractRule(permit, err_obl_true);
		empty4 = new AbstractRule(deny, err_obl_true);

		empty7 = new AbstractRule(permit, match);
		empty8 = new AbstractRule(deny, match);
		empty9 = new AbstractRule(permit, nomatch);
		empty10 = new AbstractRule(deny, nomatch);
		empty11 = new AbstractRule(permit, indet);
		empty12 = new AbstractRule(deny, indet);

		empty13 = new AbstractRule(permit);
		empty14 = new AbstractRule(deny);
	}

	@Test
	public void testRuleEmpty() {
		AuthorisationPDP d = empty13.evaluate(null, true);
		assertEquals(e_permit, d.getDecision());
		d = empty14.evaluate(null, true);
		assertEquals(e_deny, d.getDecision());
	}

	@Test
	public void testRuleEmptyCondition() {
		AuthorisationPDP d = empty7.evaluate(null, true);
		assertEquals(e_permit, d.getDecision());
		d = empty8.evaluate(null, true);
		assertEquals(e_deny, d.getDecision());
		d = empty9.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = empty10.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = empty11.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
		d = empty12.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
	}

	@Test
	public void testRuleEmptyTarget() {
		AuthorisationPDP d = empty1.evaluate(null, true);
		assertEquals(e_permit, d.getDecision());
		d = empty2.evaluate(null, true);
		assertEquals(e_deny, d.getDecision());
		d = empty3.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
		d = empty4.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		// d = empty5.evaluate(null, true);
		// assertEquals(e_indetP, d.getDecision());
		// d = empty6.evaluate(null, true);
		// assertEquals(e_indetD, d.getDecision());
	}

	@Test
	public void testRule_IndetTarget() {
		// r13 - r18
		AuthorisationPDP d = r13.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
		d = r14.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		// d = r15.evaluate(null, true);
		// assertEquals(e_indetP, d.getDecision());
		// d = r16.evaluate(null, true);
		// assertEquals(e_indetD, d.getDecision());
		d = r17.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
		d = r18.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
	}

	@Test
	public void testRule_NoMatchTarget() {
		// r7 - r12
		AuthorisationPDP d = r7.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = r8.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		// d = r9.evaluate(null, true);
		// assertEquals(e_notapp, d.getDecision());
		// d = r10.evaluate(null, true);
		// assertEquals(e_notapp, d.getDecision());
		d = r11.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = r12.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
	}

	@Test
	public void testRule_MatchTarget() {
		// r1 - r6
		AuthorisationPDP d = r1.evaluate(null, true);
		assertEquals(e_permit, d.getDecision());
		d = r2.evaluate(null, true);
		assertEquals(e_deny, d.getDecision());
		// d = r3.evaluate(null, true);
		// assertEquals(e_, d.getDecision());
		// d = r4.evaluate(null, true);
		// assertEquals(e_notapp, d.getDecision());
		d = r5.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
		d = r6.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
	}

}
