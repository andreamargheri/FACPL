package it.unifi.facpl.junit.policy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unifi.facpl.junit.util.AbstractPolicySet;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.TargetDecision;

public class PolicySet {

	private static final TargetDecision match = TargetDecision.TRUE;
	private static final TargetDecision nomatch = TargetDecision.FALSE;
	private static final TargetDecision indet = TargetDecision.INDETERMINATE;

	static private ExtendedDecision e_permit = ExtendedDecision.PERMIT;
	static private ExtendedDecision e_deny = ExtendedDecision.DENY;
	static private ExtendedDecision e_notapp = ExtendedDecision.NOT_APPLICABLE;
	static private ExtendedDecision e_indetD = ExtendedDecision.INDETERMINATE_D;
	static private ExtendedDecision e_indetP = ExtendedDecision.INDETERMINATE_P;
	@SuppressWarnings("unused")
	static private ExtendedDecision e_indetDP = ExtendedDecision.INDETERMINATE_DP;

	static private Boolean err_obl_yes = true;
	static private Boolean err_obl_no = false;

	private AbstractPolicySet p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;

	private AbstractPolicySet p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30;

	@Before
	public void setUp() {
		p1 = new AbstractPolicySet(new AuthorisationPDP(e_permit), match, err_obl_no);
		p2 = new AbstractPolicySet(new AuthorisationPDP(e_deny), match, err_obl_no);
		p3 = new AbstractPolicySet(new AuthorisationPDP(e_notapp), match, err_obl_no);
		p4 = new AbstractPolicySet(new AuthorisationPDP(e_indetD), match, err_obl_no);
		p5 = new AbstractPolicySet(new AuthorisationPDP(e_indetP), match, err_obl_no);

		p6 = new AbstractPolicySet(new AuthorisationPDP(e_permit), nomatch, err_obl_no);
		p7 = new AbstractPolicySet(new AuthorisationPDP(e_deny), nomatch, err_obl_no);
		p8 = new AbstractPolicySet(new AuthorisationPDP(e_notapp), nomatch, err_obl_no);
		p9 = new AbstractPolicySet(new AuthorisationPDP(e_indetD), nomatch, err_obl_no);
		p10 = new AbstractPolicySet(new AuthorisationPDP(e_indetP), nomatch, err_obl_no);

		p11 = new AbstractPolicySet(new AuthorisationPDP(e_permit), indet, err_obl_no);
		p12 = new AbstractPolicySet(new AuthorisationPDP(e_deny), indet, err_obl_no);
		p13 = new AbstractPolicySet(new AuthorisationPDP(e_notapp), indet, err_obl_no);
		p14 = new AbstractPolicySet(new AuthorisationPDP(e_indetD), indet, err_obl_no);
		p15 = new AbstractPolicySet(new AuthorisationPDP(e_indetP), indet, err_obl_no);

		// Obligation Failure
		p16 = new AbstractPolicySet(new AuthorisationPDP(e_permit), match, err_obl_yes);
		p17 = new AbstractPolicySet(new AuthorisationPDP(e_deny), match, err_obl_yes);
		p18 = new AbstractPolicySet(new AuthorisationPDP(e_notapp), match, err_obl_yes);
		p19 = new AbstractPolicySet(new AuthorisationPDP(e_indetD), match, err_obl_yes);
		p20 = new AbstractPolicySet(new AuthorisationPDP(e_indetP), match, err_obl_yes);

		p21 = new AbstractPolicySet(new AuthorisationPDP(e_permit), nomatch, err_obl_yes);
		p22 = new AbstractPolicySet(new AuthorisationPDP(e_deny), nomatch, err_obl_yes);
		p23 = new AbstractPolicySet(new AuthorisationPDP(e_notapp), nomatch, err_obl_yes);
		p24 = new AbstractPolicySet(new AuthorisationPDP(e_indetD), nomatch, err_obl_yes);
		p25 = new AbstractPolicySet(new AuthorisationPDP(e_indetP), nomatch, err_obl_yes);

		p26 = new AbstractPolicySet(new AuthorisationPDP(e_permit), indet, err_obl_yes);
		p27 = new AbstractPolicySet(new AuthorisationPDP(e_deny), indet, err_obl_yes);
		p28 = new AbstractPolicySet(new AuthorisationPDP(e_notapp), indet, err_obl_yes);
		p29 = new AbstractPolicySet(new AuthorisationPDP(e_indetD), indet, err_obl_yes);
		p30 = new AbstractPolicySet(new AuthorisationPDP(e_indetP), indet, err_obl_yes);

	}

	@Test
	public void testMatchTargetOblOK() {
		AuthorisationPDP d = p1.evaluate(null, true);
		assertEquals(e_permit, d.getDecision());
		d = p2.evaluate(null, true);
		assertEquals(e_deny, d.getDecision());
		d = p3.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p4.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		d = p5.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
	}

	@Test
	public void testNoMatchTargetOblOK() {
		AuthorisationPDP d = p6.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p7.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p8.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p9.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p10.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
	}

	@Test
	public void testIndetTargetOblOK() {
		AuthorisationPDP d = p11.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
		d = p12.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		d = p13.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p14.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		d = p15.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
	}

	@Test
	public void testMatchTargetOblFAILED() {
		AuthorisationPDP d = p16.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
		d = p17.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		d = p18.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p19.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		d = p20.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
	}

	@Test
	public void testNoMatchTargetOblFAILED() {
		AuthorisationPDP d = p21.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p22.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p23.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p24.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p25.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
	}

	@Test
	public void testIndetTargetOblFAILED() {
		AuthorisationPDP d = p26.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
		d = p27.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		d = p28.evaluate(null, true);
		assertEquals(e_notapp, d.getDecision());
		d = p29.evaluate(null, true);
		assertEquals(e_indetD, d.getDecision());
		d = p30.evaluate(null, true);
		assertEquals(e_indetP, d.getDecision());
	}

}
