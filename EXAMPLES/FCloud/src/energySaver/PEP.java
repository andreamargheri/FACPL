package energySaver;

import java.util.LinkedList;

import fcloud.requests.ContextRequest_RequestCreate;
import fcloud.requests.ContextRequest_RequestCreateP;
import fcloud.requests.ContextRequest_RequestRelease;
import fcloud.requests.ContextRequest_RequestReleaseN;
import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.system.FacplAuthorisationSystem;

@SuppressWarnings("all")
public class PEP {
	
	
		/*
		*ENTRY POINT FOR EVALUATION
		*/
		public static void main(String[] args){
			//initialize PEP
			FacplAuthorisationSystem.inizializePepActions(PEPAction.class);
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
				AuthorisationPDP resPDP = PDP.evalRequest(rcxt);
				result.append("Request: "+ resPDP.getId() + "\n\n");
				result.append("PDP Decision=\n " + resPDP.toString()+"\n\n");
				//enforce decision
				AuthorisationPEP resPEP = enforceDecision(resPDP);
				result.append("PEP Decision=\n " + resPEP.toString()+"\n");
				result.append("---------------------------------------------------\n");
			}
		}
	
	public static AuthorisationPEP enforceDecision(AuthorisationPDP pdpRes) {
		//algrothm for PEP
		String alg = "deny-biased";	
		//call enforcement 
		return FacplAuthorisationSystem.doEnforcement(alg,pdpRes);
	}
	
}
