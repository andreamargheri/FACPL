package it.unifi.xtext.facpl.generator.generators.z3algorithms

import it.unifi.xtext.facpl.generator.generators.Z3Generator_Alg

class Z3Generator_OneApp extends Z3Generator_Alg {

	override getCombinationPermit(String prev, String current, String p_name, Boolean isFirst) {
		// name of the previous combination
		// when it is the first one it is empty because it refers to a rule/policy constraint and not to an intermediate constraint previously defined
		var String n_cns = ""
		if (!isFirst) {
			n_cns = p_name + "_cmb_"
		}
		return "\t (or (and cns_" + n_cns + prev + "_permit cns_" + current + "_notApp) (and cns_" + n_cns + prev + "_notApp cns_" + current + "_permit))\n"
	}

	override getCombinationDeny(String prev, String current, String p_name, Boolean isFirst) {
		// name of the previous combination
		// when it is the first one it is empty because it refers to a rule/policy constraint and not to an intermediate constraint previously defined
		var String n_cns = ""
		if (!isFirst) {
			n_cns = p_name + "_cmb_"
		}
		return "\t (or (and cns_" + n_cns + prev + "_deny cns_" + current + "_notApp) (and cns_" + n_cns + prev + "_notApp cns_" + current + "_deny))\n"
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
		val StringBuffer str = new StringBuffer()
		str.append("\t (or \n ")
		str.append("\t\t cns_" + n_cns + prev + "_indet \n\t\t cns_" + current + "_indet \n")
		str.append("\t\t (and \n")
		str.append("\t\t\t (or cns_" + n_cns + prev + "_permit cns_" + n_cns + prev + "_deny)\n")
		str.append("\t\t\t (or cns_" + current + "_permit cns_" + current + "_deny)")
		str.append("\t\t )")
		str.append(")")		
		return str.toString
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