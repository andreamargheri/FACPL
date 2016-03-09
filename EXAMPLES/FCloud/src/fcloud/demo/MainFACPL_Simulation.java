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
package fcloud.demo;


import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.system.*;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.interfaces.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import fcloud.requests.ContextRequest_RequestCreate;
import fcloud.requests.ContextRequest_RequestCreateP;
import fcloud.requests.ContextRequest_RequestRelease;
import fcloud.requests.ContextRequest_RequestReleaseN;

@SuppressWarnings("all")
public class MainFACPL_Simulation{
	 	
	private PDP pdp;
	private PEP pep;
		
	public MainFACPL_Simulation() {
		
		// initialize Cloud Simulation Environment
		FCloud.getInstance().initializeSimulation("./system");
	
		
		// defined list of policies included in the PDP
		LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();
		
		/*
		 * LOAD-BALANCER
		 */
//		policies.add(new loadBalancer.PolicySet_CloudSystem()); 

		
		/*
		 * ENERGY-SAVER
		 */
		policies.add(new energySaver.PolicySet_CloudSystem()); 
		
		
		this.pdp = new PDP(it.unifi.facpl.lib.algorithm.PermitOverridesGreedy.class, policies, false);
		
		this.pep = new PEP(EnforcementAlgorithm.DENY_BIASED);
			
		this.pep.addPEPActions(PEPAction_Cloud.getPepActions());
	}
		
	/*
	*ENTRY POINT FOR EVALUATION
	*/
	public static void main(String[] args){
		//Initialise Authorisation System
		MainFACPL_Simulation system = new MainFACPL_Simulation();
		
		//log
		StringBuffer result = new StringBuffer();
		//request
		LinkedList<ContextRequest> requests = new LinkedList<ContextRequest>();
		requests.add(ContextRequest_RequestCreate.getContextReq());
		requests.add(ContextRequest_RequestCreate.getContextReq());
		requests.add(ContextRequest_RequestCreate.getContextReq());
		requests.add(ContextRequest_RequestCreateP.getContextReq());
		requests.add(ContextRequest_RequestRelease.getContextReq());
		requests.add(ContextRequest_RequestReleaseN.getContextReq());
		for (ContextRequest rcxt : requests) {
			result.append("---------------------------------------------------\n");
			AuthorisationPDP resPDP = system.pdp.doAuthorisation(rcxt);
			result.append("Request: "+ resPDP.getId() + "\n\n");
			result.append("PDP Decision=\n " + resPDP.toString()+"\n\n");
			//enforce decision
			AuthorisationPEP resPEP = system.pep.doEnforcement(resPDP);
			result.append("PEP Decision=\n " + resPEP.toString()+"\n");
			result.append("---------------------------------------------------\n");
		}
		System.out.println(result.toString());
		ShowResult.showResult(result);
	}	
	
	
	public PDP getPdp() {
		return pdp;
	}
		
	public PEP getPep() {
		return pep;
	}
	
}
