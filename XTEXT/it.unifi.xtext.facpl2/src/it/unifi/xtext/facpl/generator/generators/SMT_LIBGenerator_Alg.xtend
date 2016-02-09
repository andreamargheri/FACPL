package it.unifi.xtext.facpl.generator.generators

import it.unifi.xtext.facpl.facpl2.PolicySet

/**
 * Abstract Methods for the Combination of constraints
 */
abstract class SMT_LIBGenerator_Alg {
	private int n_step;

	def CharSequence combine(PolicySet p) {
		// Define number of step modeling the combination
		n_step = p.policies.size - 1
		if (n_step == 0) {
			// only one rule/policy forming the policy set in input -> go to the default case
			var String r_name
			r_name = getPolName(0, p)
			return getDefaultCase(p.name, r_name)
		} else {
			// multiple steps
			// final constraints the one named _cmb_final_
			var StringBuffer s = new StringBuffer()
			var String previousCmb = getPolName(0,p)
			//we set the flag isFlag to sign the first combination
			var Boolean isFirst = true
			for (var i=1; i <= n_step; i ++){
				//at the current step the second combination argument is the current policy in the list
				var String currentCmb = getPolName(i, p)
				var Boolean isFinal
				if (i == n_step){
					isFinal = true
				}else{
					isFinal = false
				}
				
				s.append(getCombination(previousCmb, currentCmb, p.name, isFirst, isFinal)+ " \n")
				//after the first combination we set the flag to be false
				isFirst = false
				if (!isFinal){
					//at the current step the first combination argument is the one combined before 
					previousCmb = previousCmb + currentCmb  
				}
			}
			return s	
		}
	}

	/**
	 * Prev = name of first policy to consider (i.e. relevant part of the name of the corresponding constraint)
	 * current = name of second policy to consider (i.e. relevant part of the name of the corresponding constraint)
	 * P_name = name of the represented policy (i.e. part of the name of the generated constraint)
	 * IsFirst = signal the first combination (i.e. it needed to initialize the constraint name)
	 * IsFinal = true== the last step of the combination -> the constraint name contains _final_
	 */
	def String getCombination(String prev, String current, String p_name, Boolean isFirst, Boolean isFinal){
		var StringBuffer str = new StringBuffer()
		var String cns_name
		if (isFinal){
			cns_name = "final"
		}else{
			cns_name = prev+current
		}
		//Permit Case
		str.append("(define-fun cns_"+p_name+"_cmb_"+cns_name+"_permit () Bool\n")	
		str.append(getCombinationPermit(prev,current,p_name,isFirst))
		str.append(")\n\n")	
		//Deny Case
		str.append("(define-fun cns_"+p_name+"_cmb_"+cns_name+"_deny () Bool\n")
		str.append(getCombinationDeny(prev,current,p_name,isFirst))	
		str.append(")\n\n")
		//NotApp Case
		str.append("(define-fun cns_"+p_name+"_cmb_"+cns_name+"_notApp () Bool\n")
		str.append(getCombinationNotApp(prev,current,p_name,isFirst))
		str.append(")\n\n")
		//Indet Case
		str.append("(define-fun cns_"+p_name+"_cmb_"+cns_name+"_indet () Bool\n")
		str.append(getCombinationIndet(prev,current,p_name,isFirst))
		str.append(")\n\n")		
		return str.toString		
	}
	
	/**
	 * Return the name of the referred or defined policy 
	 */
	def getPolName(int index, PolicySet p) {
		if (p.policies.get(index).refPol != null) {
			return p.policies.get(index).refPol.name
		} else {
			return p.policies.get(index).newPolicy.name
		}
	}

	/*
	 * Abstract Methods modeling the different combinations due to each combining algorithm
	 */
	abstract def String getCombinationPermit(String prev, String current, String p_name, Boolean isFirst)
	abstract def String getCombinationDeny(String prev, String current, String p_name, Boolean isFirst)
	abstract def String getCombinationNotApp(String prev, String current, String p_name, Boolean isFirst)
	abstract def String getCombinationIndet(String prev, String current, String p_name, Boolean isFirst)
	
	/*
	 * ################
	 * DEFAULT CASE: only one policy to combine
	 * ################
	 */

	def getDefaultCase(String pSet_name, String r_name) '''
		(define-fun cns_«pSet_name»_cmb_final_permit () Bool
			«getDefaultCombinationPermit(r_name)»
		)
		
		(define-fun cns_«pSet_name»_cmb_final_deny () Bool
			«getDefaultCombinationDeny(r_name)»
		)
		
		(define-fun cns_«pSet_name»_cmb_final_notApp () Bool
			«getDefaultCombinationNotApp(r_name)»
		)
		
		(define-fun cns_«pSet_name»_cmb_final_indet () Bool
			«getDefaultCombinationIndet(r_name)»
		)
	'''
	
	/*
	 * Abstract Methods modeling the different combinations due to each combining algorithm
	 */
	abstract def String getDefaultCombinationPermit(String r_name)
	abstract def String getDefaultCombinationDeny(String r_name)
	abstract def String getDefaultCombinationNotApp(String r_name)
	abstract def String getDefaultCombinationIndet(String r_name)
}