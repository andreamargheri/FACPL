package it.unifi.xtext.facpl.generator.generators.z3algorithms

import it.unifi.xtext.facpl.generator.generators.Z3Generator_Alg

class Z3Generator_FirstApp extends Z3Generator_Alg {

	override getCombinationPermit(String prev, String current, String p_name, Boolean isFirst) {
		// name of the previous combination
		// when it is the first one it is empty because it refers to a rule/policy constraint and not to an intermediate constraint previously defined
		var String n_cns = ""
		if (!isFirst) {
			n_cns = p_name + "_cmb_"
		}
		return "\t (or cns_" + n_cns + prev + "_permit (and cns_" + current + "_permit cns_" + n_cns + prev + "_notApp))\n"
	}

	override getCombinationDeny(String prev, String current, String p_name, Boolean isFirst) {
		// name of the previous combination
		// when it is the first one it is empty because it refers to a rule/policy constraint and not to an intermediate constraint previously defined
		var String n_cns = ""
		if (!isFirst) {
			n_cns = p_name + "_cmb_"
		}
		return "\t (or cns_" + n_cns + prev + "_deny (and cns_" + current + "_deny cns_" + n_cns + prev + "_notApp))\n"
	}

	override getCombinationNotApp(String prev, String current, String p_name, Boolean isFirst) {
		// name of the previous combination
		// when it is the first one it is empty because it refers to a rule/policy constraint and not to an intermediate constraint previously defined
		var String n_cns = ""
		if (!isFirst) {
			n_cns = p_name + "_cmb_"
		}
		return "\t (and cns_" + n_cns + prev + "_notApp cns_" + current + "_notApp)\n"
	}

	override getCombinationIndet(String prev, String current, String p_name, Boolean isFirst) {
		// name of the previous combination
		// when it is the first one it is empty because it refers to a rule/policy constraint and not to an intermediate constraint previously defined
		var String n_cns = ""
		if (!isFirst) {
			n_cns = p_name + "_cmb_"
		}
		return "\t (or cns_" + n_cns + prev + "_indet (and cns_" + current + "_indet cns_" + n_cns + prev + "_notApp))\n"
	}

	/*
	 * DEFAULT CASES
	 */
	override getDefaultCombinationPermit(String r_name) {
		return "cns_"+r_name+"_permit"
	}
	
	override getDefaultCombinationDeny(String r_name) {
		return "cns_"+r_name+"_deny"
	}
	
	override getDefaultCombinationNotApp(String r_name) {
		return "cns_"+r_name+"_notApp"
	}
	
	override getDefaultCombinationIndet(String r_name) {
		return "cns_"+r_name+"_indet"
	}
}