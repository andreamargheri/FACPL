package usagecontrol.foo;

import java.util.ArrayList;
import java.util.LinkedList;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.lib.enums.EnforcementAlgorithm;
import it.unifi.facpl.lib.enums.FacplStatusType;
import it.unifi.facpl.lib.policy.FacplPolicy;
import it.unifi.facpl.lib.util.ShowResult;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;
import it.unifi.facpl.system.PDP;
import it.unifi.facpl.system.PEP;
import it.unifi.facpl.system.status.FacplStatus;
import it.unifi.facpl.system.status.StatusAttribute;

@SuppressWarnings("all")
public class MainFACPL{
	 	
	private PDP pdp;
	private PEP pep;
		
	public MainFACPL() throws MissingAttributeException {
		// defined list of policies included in the PDP
		LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();
		FacplStatus status = createStatus();
		policies.add(new PolicySet_NamePolicySetTwo(status)); 
		//policies.add(new PolicySet_NamePolicySetTwo());
		this.pdp = new PDP(it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy.class, policies, false);
		
		this.pep = new PEP(EnforcementAlgorithm.DENY_BIASED);
			
		this.pep.addPEPActions(PEPAction.getPepActions());
	}
	
	public FacplStatus createStatus() {
		ArrayList<StatusAttribute> attributeList = new ArrayList<StatusAttribute>();
		attributeList.add(new StatusAttribute("accessNumber", FacplStatusType.INT, "60"));
		FacplStatus status = new FacplStatus(attributeList, "stato");
		return status;
	}
		
	/*
	*ENTRY POINT FOR EVALUATION
	*/
	public static void main(String[] args) throws MissingAttributeException{
		//Initialise Authorisation System
		MainFACPL system = new MainFACPL();
		
		//log
		StringBuffer result = new StringBuffer();
		//request
		LinkedList<ContextRequest> requests = new LinkedList<ContextRequest>();
		requests.add(ContextRequest_NameRequest.getContextReq());
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
