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
import it.unifi.facpl.lib.algorithm.DenyUnlessPermit;
import it.unifi.facpl.lib.algorithm.FirstApplicable;
import it.unifi.facpl.lib.algorithm.OnlyOneApplicable;
import it.unifi.facpl.lib.algorithm.PermitOverridesGreedy;
import it.unifi.facpl.lib.algorithm.PermitUnlessDeny;
import it.unifi.facpl.lib.context.AbstractFulfilledObligation;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.FullfilledObbligation;
import it.unifi.facpl.lib.enums.Effect;
import it.unifi.facpl.lib.enums.ExtendedDecision;
import it.unifi.facpl.lib.enums.ObligationType;
import it.unifi.facpl.lib.enums.TargetDecision;
import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;

public class CombiningAlgObligation {

	static private ExtendedDecision permit = ExtendedDecision.PERMIT;
	static private ExtendedDecision deny = ExtendedDecision.DENY;
	static private ExtendedDecision notapp = ExtendedDecision.NOT_APPLICABLE;
	static private ExtendedDecision indetD = ExtendedDecision.INDETERMINATE_D;
	static private ExtendedDecision indetP = ExtendedDecision.INDETERMINATE_P;
	static private ExtendedDecision indetDP = ExtendedDecision.INDETERMINATE_DP;

	static private Integer nList = 10;

	private AbstractFulfilledObligation o1, o2, o3, o4;
	private LinkedList<AbstractFulfilledObligation> obl_allPermit, obl_allDeny,
			obl_various, obl_allAdvice;

	private IEvaluableAlgorithm alg;
	private List<AuthorisationPDP> listAllPermit, listAllDeny, listAllNotApp,
			listAllIndetP, listAllIndetD, listAllIndetDP, listFirstPermit,
			listFirstDeny;
	private List<TargetDecision> listAllApp, listOneApp, listNoApp,
			listAllIndetMatch, listMixMatch;

	@Before
	public void setUp() {
		// obligation
		o1 = new FullfilledObbligation(Effect.PERMIT, ObligationType.M, "mailTo");

		o2 = new FullfilledObbligation(Effect.DENY, ObligationType.M, "mailTo");

		o3 = new FullfilledObbligation(Effect.PERMIT, ObligationType.O, "mailTo");

		o4 = new FullfilledObbligation(Effect.DENY, ObligationType.O, "mailTo");

		// create obligation lists
		obl_allPermit = new LinkedList<AbstractFulfilledObligation>();
		obl_allPermit.add(o1);
		obl_allPermit.add(o1);
		obl_allPermit.add(o1);

		obl_allDeny = new LinkedList<AbstractFulfilledObligation>();
		obl_allDeny.add(o2);
		obl_allDeny.add(o2);
		obl_allDeny.add(o2);

		obl_various = new LinkedList<AbstractFulfilledObligation>();
		obl_various.add(o1);
		obl_various.add(o2);

		obl_allAdvice = new LinkedList<AbstractFulfilledObligation>();
		obl_allAdvice.add(o3);
		obl_allAdvice.add(o4);

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
		// orderedList: permit and deny precedence
		listFirstPermit = new LinkedList<AuthorisationPDP>();
		listFirstPermit.add(new AuthorisationPDP(permit));
		for (int i = 1; i <= nList /4; i++) {
			listFirstPermit.add(new AuthorisationPDP(deny));
			listFirstPermit.add(new AuthorisationPDP(notapp));
			listFirstPermit.add(new AuthorisationPDP(indetP));
			listFirstPermit.add(new AuthorisationPDP(indetD));
		}
		listFirstDeny = new LinkedList<AuthorisationPDP>();
		listFirstDeny.add(new AuthorisationPDP(deny));
		for (int i = 1; i <= nList /4; i++) {
			listFirstDeny.add(new AuthorisationPDP(permit));
			listFirstDeny.add(new AuthorisationPDP(notapp));
			listFirstDeny.add(new AuthorisationPDP(indetP));
			listFirstDeny.add(new AuthorisationPDP(indetD));
		}
		// matching tuples for the onlyOneapplicable
		listAllApp = new LinkedList<TargetDecision>();
		for (int i = 1; i <= nList*2; i++) {
			listAllApp.add(TargetDecision.TRUE);
		}
		listNoApp = new LinkedList<TargetDecision>();
		for (int i = 1; i <= nList*2; i++) {
			listNoApp.add(TargetDecision.FALSE);
		}
		listAllIndetMatch = new LinkedList<TargetDecision>();
		for (int i = 1; i <= nList*2; i++) {
			listAllIndetMatch.add(TargetDecision.INDETERMINATE);
		}
		listOneApp = new LinkedList<TargetDecision>();
		listOneApp.add(0, TargetDecision.TRUE);
		for (int i = 1; i <= nList*2; i++) {
			listOneApp.add(TargetDecision.FALSE);
		}
		listMixMatch = new LinkedList<TargetDecision>();
		for (int i = 1; i <= nList*2; i++) {
			listMixMatch.add(TargetDecision.INDETERMINATE);
		}
		listMixMatch.add(TargetDecision.FALSE);
		listMixMatch.add(TargetDecision.TRUE);
	}

	@Test
	public void testPermitOver() {
		alg = new PermitOverridesGreedy();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		//halts at the first permit, only the three obligations defined in the first element are returned
		assertEquals(obl_allPermit.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllPermit,listAllApp, obl_allDeny); 
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		//deny obligations -> any obligation returned
		assertEquals(0, d.getObligation().size());
	
		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		//all permit obligation, whereas all elements are evaluated as deny
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		//all obligation of all elements are returned
		assertEquals(listAllDeny.size()*obl_allDeny.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllNotApp, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetD, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_D, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetDP, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetP,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_P, d.getDecision());
		assertEquals(0, d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(obl_allPermit.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstDeny,listAllApp, obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		//at least one PERMIT decision, hence, PERMIT result but no obligation with PERMIT effect
		assertEquals(0, d.getObligation().size());

	}

	@Test
	public void testDenytOver() {
		alg = new DenyOverrides();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;
		
		el.setElements(listAllPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(obl_allPermit.size()*listAllPermit.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllPermit,listAllApp, obl_allDeny); 
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(0, d.getObligation().size());
	
		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(obl_allDeny.size()*listAllDeny.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllNotApp, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetD, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_D, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetDP, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetP,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_P, d.getDecision());
		assertEquals(0, d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(0, d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstDeny,listAllApp, obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(obl_allDeny.size(), d.getObligation().size());
		
	}


	@Test
	public void testFirstApp() {
		alg = new FirstApplicable();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(obl_allPermit.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllPermit,listAllApp, obl_allDeny); 
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		//deny obligations -> any obligation returned
		assertEquals(0, d.getObligation().size());
	
		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(obl_allDeny.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllNotApp, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetD, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_D, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetDP, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetP,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_P, d.getDecision());
		assertEquals(0, d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(obl_allPermit.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstDeny,listAllApp, obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(obl_allDeny.size(), d.getObligation().size());
		
	}

	@Test
	public void testDenyUnlessPermit() {
		alg = new DenyUnlessPermit();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		//halts at the first permit, only the three obligations defined in the first element are returned
		assertEquals(obl_allPermit.size()*listAllPermit.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllPermit,listAllApp, obl_allDeny); 
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		//deny obligations -> any obligation returned
		assertEquals(0, d.getObligation().size());
	
		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		//all permit obligation, whereas all elements are evaluated as deny
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		//all obligation of all elements are returned
		assertEquals(listAllDeny.size()*obl_allDeny.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllNotApp, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetD, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetDP, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetP,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(0, d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(obl_allPermit.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstDeny,listAllApp, obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(0, d.getObligation().size());

	}

	@Test
	public void testPermitUnlessDeny() {
		alg = new PermitUnlessDeny();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		//halts at the first permit, only the three obligations defined in the first element are returned
		assertEquals(listAllPermit.size()*obl_allPermit.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllPermit,listAllApp, obl_allDeny); 
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		//deny obligations -> any obligation returned
		assertEquals(0, d.getObligation().size());
	
		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		//all permit obligation, whereas all elements are evaluated as deny
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllDeny, listAllApp,obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		//all obligation of all elements are returned
		assertEquals(obl_allDeny.size()*listAllDeny.size(), d.getObligation().size());
		
		el.clearElements();
		el.setElements(listAllNotApp, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetD, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetDP, listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllIndetP,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(0, d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstPermit,listAllApp, obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(0, d.getObligation().size());
		
		el.clearElements();
		el.setElements(listFirstDeny,listAllApp, obl_allDeny);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.DENY, d.getDecision());
		assertEquals(obl_allDeny.size(), d.getObligation().size());
		
	}

	@Test
	public void testOnlyOneApp() {

		// listAllApp, listOneApp, listNoApp, listAllIndetMatch, listMixMatch;
		alg = new OnlyOneApplicable();
		EvaluableElementStub el = new EvaluableElementStub();
		AuthorisationPDP d;

		el.setElements(listAllPermit, listAllApp,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllPermit, listNoApp,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.NOT_APPLICABLE, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllPermit, listOneApp,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.PERMIT, d.getDecision());
		assertEquals(obl_allPermit.size(), d.getObligation().size());

		el.clearElements();
		el.setElements(listAllPermit, listAllIndetMatch,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());
		assertEquals(0, d.getObligation().size());

		el.clearElements();
		el.setElements(listAllPermit, listMixMatch,obl_allPermit);
		d = alg.evaluate(el.getElements(), null, true);
		assertEquals(ExtendedDecision.INDETERMINATE_DP, d.getDecision());
		assertEquals(0, d.getObligation().size());
		
	}

}
