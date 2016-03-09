/*******************************************************************************
 * Copyright (c) 2016 Andrea Margheri
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andrea Margheri
 *******************************************************************************/
package it.unifi.facpl.junit.policy;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.unifi.facpl.junit.util.EvaluableElementStub;
import it.unifi.facpl.lib.algorithm.DenyOverrides;
import it.unifi.facpl.lib.algorithm.DenyOverridesGreedy;
import it.unifi.facpl.lib.algorithm.DenyUnlessPermit;
import it.unifi.facpl.lib.algorithm.DenyUnlessPermitGreedy;
import it.unifi.facpl.lib.algorithm.FirstApplicable;
import it.unifi.facpl.lib.algorithm.OnlyOneApplicable;
import it.unifi.facpl.lib.algorithm.PermitOverridesGreedy;
import it.unifi.facpl.lib.algorithm.PermitUnlessDeny;
import it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy;
import it.unifi.facpl.lib.algorithm.StrongConsensus;
import it.unifi.facpl.lib.algorithm.WeakConsensus;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;

public class CombiningAlg {

	static private ExtendedDecision permit = ExtendedDecision.PERMIT;
	static private ExtendedDecision deny = ExtendedDecision.DENY;
	static private ExtendedDecision notapp = ExtendedDecision.NOT_APPLICABLE;
	static private ExtendedDecision indetD = ExtendedDecision.INDETERMINATE_D;
	static private ExtendedDecision indetP = ExtendedDecision.INDETERMINATE_P;
	static private ExtendedDecision indetDP = ExtendedDecision.INDETERMINATE_DP;

	static private Integer nList = 10;

	private IEvaluableAlgorithm alg;
	private List<AuthorisationPDP> listAllPermit, listAllDeny, listAllNotApp, listAllIndetP, listAllIndetD,
			listAllIndetDP, listFirstPermit, listFirstDeny;
	private List<TargetDecision> listAllApp, listOneApp, listNoApp, listAllIndetMatch, listMixMatch;

	@Before
	public void setUp() {
		// basic decision tuple: all decision are the same
		listAllPermit = new LinkedList<AuthorisationPDP>();
		for (int i = 1; i <= nList; i++) {
			listAllPermit.add(new AuthorisationPDP(permit));
		}
		listAllDeny = new LinkedList<AuthorisationPDP>();
		for (int i = 1; i <= nList; i++) {
			listAllDeny.add(new AuthorisationPDP(deny));
		}
		listAllNotApp = new LinkedList<AuthorisationPDP>();
		for (int i = 1; i <= nList; i++) {
			listAllNotApp.add(new AuthorisationPDP(notapp));
		}
		listAllIndetD = new LinkedList<AuthorisationPDP>();
		for (int i = 1; i <= nList; i++) {
			listAllIndetD.add(new AuthorisationPDP(indetD));
		}
		listAllIndetDP = new LinkedList<AuthorisationPDP>();
		for (int i = 1; i <= nList; i++) {
			listAllIndetDP.add(new AuthorisationPDP(indetDP));
		}
		listAllIndetP = new LinkedList<AuthorisationPDP>();
		for (int i = 1; i <= nList; i++) {
			listAllIndetP.add(new AuthorisationPDP(indetP));
		}
		// orderedList: permit and deny precedendce
		listFirstPermit = new LinkedList<AuthorisationPDP>();
		listFirstPermit.add(new AuthorisationPDP(permit));
		for (int i = 1; i <= nList / 2; i++) {
			listFirstPermit.add(new AuthorisationPDP(deny));
			listFirstPermit.add(new AuthorisationPDP(notapp));
			listFirstPermit.add(new AuthorisationPDP(indetP));
			listFirstPermit.add(new AuthorisationPDP(indetD));
		}
		listFirstDeny = new LinkedList<AuthorisationPDP>();
		listFirstDeny.add(new AuthorisationPDP(deny));
		for (int i = 1; i <= nList / 2; i++) {
			listFirstDeny.add(new AuthorisationPDP(permit));
			listFirstDeny.add(new AuthorisationPDP(notapp));
			listFirstDeny.add(new AuthorisationPDP(indetP));
			listFirstDeny.add(new AuthorisationPDP(indetD));
		}
		// matching tuples for the onlyOneapplicable
		listAllApp = new LinkedList<TargetDecision>();
		for (int i = 1; i <= nList; i++) {
			listAllApp.add(TargetDecision.TRUE);
		}
		listNoApp = new LinkedList<TargetDecision>();
		for (int i = 1; i <= nList; i++) {
			listNoApp.add(TargetDecision.FALSE);
		}
		listAllIndetMatch = new LinkedList<TargetDecision>();
		for (int i = 1; i <= nList; i++) {
			listAllIndetMatch.add(TargetDecision.INDETERMINATE);
		}
		listOneApp = new LinkedList<TargetDecision>();
		listOneApp.add(0, TargetDecision.TRUE);
		for (int i = 2; i <= nList; i++) {
			listOneApp.add(TargetDecision.FALSE);
		}
		listMixMatch = new LinkedList<TargetDecision>();
		for (int i = 1; i <= nList - 2; i++) {
			listMixMatch.add(TargetDecision.INDETERMINATE);
		}
		listMixMatch.add(nList - 2, TargetDecision.FALSE);
		listMixMatch.add(nList - 1, TargetDecision.TRUE);
	}

	@Test
	public void testPermitOver() {
		alg = new PermitOverridesGreedy();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_D, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_P, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
	}

	@Test
	public void testDenytOver() {
		alg = new DenyOverrides();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_D, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_P, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
	}

	@Test
	public void testDenytOverGreedy() {
		alg = new DenyOverridesGreedy();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_D, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_P, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
	}

	@Test
	public void testFirstApp() {
		alg = new FirstApplicable();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_D, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_P, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
	}

	@Test
	public void testDenyUnlessPermit() {
		alg = new DenyUnlessPermit();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

	}

	@Test
	public void testDenyUnlessPermitGreedy() {
		alg = new DenyUnlessPermitGreedy();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

	}

	@Test
	public void testPermitUnlessDeny() {
		alg = new PermitUnlessDeny();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

	}

	@Test
	public void testPermitUnlessDenyGreedy() {
		alg = new PermitUnlessDenyGreedy();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

	}

	@Test
	public void testOnlyOneApp() {

		// listAllApp, listOneApp, listNoApp, listAllIndetMatch, listMixMatch;
		alg = new OnlyOneApplicable();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit, listAllApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllPermit, listNoApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());

		el.clearElements();
		el.setElements(listAllPermit, listOneApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllPermit, listAllIndetMatch);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllPermit, listMixMatch);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

	}

	@Test
	public void testWeakConsensus() {

		alg = new WeakConsensus();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());
	}

	@Test
	public void testStrongConsensus() {

		alg = new StrongConsensus();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());

		el.clearElements();
		el.setElements(listAllDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());

		el.clearElements();
		el.setElements(listAllNotApp);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetD);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetDP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listAllIndetP);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listFirstPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());

		el.clearElements();
		el.setElements(listFirstDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());
	}

}
