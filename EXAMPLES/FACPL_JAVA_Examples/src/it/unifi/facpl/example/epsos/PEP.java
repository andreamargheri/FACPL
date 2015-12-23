package it.unifi.facpl.example.epsos;

import it.unifi.facpl.lib.context.AuthorisationPDP;
import it.unifi.facpl.lib.context.AuthorisationPEP;
import it.unifi.facpl.lib.context.ContextRequest;
import it.unifi.facpl.system.FacplAuthorisationSystem;

@SuppressWarnings("all")
public class PEP {
	
	public static void main(String[] args){
		FacplAuthorisationSystem.inizializePepActions(PEPAction.class);
		
		//log
		StringBuffer result = new StringBuffer();
	
			result.append("---------------------------------------------------\n");
//			ContextRequest request1 = ContextRequest_Request1.getContextReq();
			ContextRequest req2 = ContextRequest_Request2_bot.getContextReq();
//			AuthorisationPDP resPDP = PDP.evalRequest(request1);
			AuthorisationPDP resPDP = PDP.evalRequest(req2);
			result.append("Request: "+ resPDP.getId() + "\n\n");
			result.append("PDP Decision=\n " + resPDP.toString()+"\n\n");
			//enforce decision
			AuthorisationPEP resPEP = enforceDecision(resPDP);
			result.append("PEP Decision=\n " + resPEP.toString()+"\n");
			result.append("---------------------------------------------------\n");
		
	}

	public static AuthorisationPEP enforceDecision(AuthorisationPDP pdpRes) {
		//algrothm for PEP
		String alg = "base";	
		//call enforcement 
		return FacplAuthorisationSystem.doEnforcement(alg,pdpRes);
	}
	
}
