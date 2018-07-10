package sod;

import it.unifi.facpl.lib.policy.*;
import it.unifi.facpl.system.*;
import it.unifi.facpl.lib.context.*;
import it.unifi.facpl.lib.interfaces.*;
import it.unifi.facpl.lib.enums.*;
import it.unifi.facpl.lib.util.*;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class MainFACPL{
	 	
	private PDP pdp;
	private PEP pep;
		
	public MainFACPL() {
		// defined list of policies included in the PDP
		LinkedList<IEvaluablePolicy> policies = new LinkedList<IEvaluablePolicy>();
		policies.add(new PolicySet_AccessRules()); 
		policies.add(new PolicySet_SoDRules()); 
		this.pdp = new PDP(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy(), policies, false);
		
		this.pep = new PEP(EnforcementAlgorithm.BASE);
			
		this.pep.addPEPActions(PEPAction.getPepActions());
	}
		
	/*
	*ENTRY POINT FOR EVALUATION
	*/
	public static void main(String[] args){
		//Initialise Authorisation System
		MainFACPL system = new MainFACPL();
		
		//log
		StringBuffer result = new StringBuffer();
		//request
		LinkedList<ContextRequest> requests = new LinkedList<ContextRequest>();
		requests.add(ContextRequest_Request1.getContextReq());
		requests.add(ContextRequest_Request2.getContextReq());
		requests.add(ContextRequest_Request3.getContextReq());
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
		//ShowResult.showResult(result);
	}	
	
	
	public PDP getPdp() {
		return pdp;
	}
		
	public PEP getPep() {
		return pep;
	}
	
}
