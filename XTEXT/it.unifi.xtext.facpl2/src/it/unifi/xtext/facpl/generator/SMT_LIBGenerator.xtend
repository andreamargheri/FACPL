package it.unifi.xtext.facpl.generator

import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.generator.generators.SMT_LIBGenerator_Code
import org.eclipse.xtext.generator.IFileSystemAccess
import it.unifi.xtext.facpl.facpl2.Request
import it.unifi.xtext.facpl.generator.util.Decision
import it.unifi.xtext.facpl.generator.util.SecurityProperty
import it.unifi.xtext.facpl.validation.inference.SubstitutionSet

class SMT_LIBGenerator extends SMT_LIBGenerator_Code {

	/**
	 * EntryPoint for menu command Generate SMT-LIB code
	 */
	def void doGenerateFileSMT_LIB(Facpl resource, IFileSystemAccess fsa) throws Exception{

		/* Type checks + Initialization of constants and various */
		initialiseFacplResource(resource)

		/* Compiling policies */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				fsa.generateFile(pol.getName + ".smt2", createMainConstraint(pol));
			}
		}
		if (resource.main != null) {
			if (resource.main.paf.pdp != null) {
				for (pol : resource.main.paf.pdp.polSet) {
					if (pol.newPolicy != null) {
						fsa.generateFile(pol.newPolicy.getName + ".smt2", createMainConstraint(pol.newPolicy));
					}
				// Referred policies are not combined
				}
			}
		}

	}

	/**
	 * EntryPoint for Security Property
	 */
	def void doGenerateSecurity_Property(Facpl resource, String policy_name, String name_property, Request req,
		Decision dec, SecurityProperty prop, IFileSystemAccess fsa) {

		var str = doGenerateSecurity_Property_Code(resource, policy_name, req, dec, prop);

		/* Copy the generated SMT-LIB in a FILE  */
		fsa.generateFile(policy_name + "_property_" + name_property + ".smt2", str);

	}

	/**
	 * Generation of SMT-LIB code for Security Property 
	 */
	def String doGenerateSecurity_Property_Code(Facpl resource, String policy_name, Request req, Decision dec,
		SecurityProperty prop) {

		/* Generate the SMT_LIB code of the FacplPolicy in input*/
		/* -> Type checks + Initialization of constants and various */
		initialiseFacplResource_Request(resource, req)

		var str = new StringBuffer

		/* -> Compile to SMT-LIB the chosen policy */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				if (pol.name.equals(policy_name)) {
					str.append(createMainConstraint(pol))
				}
			}
		}

		str.append(";###################### SECURITY PROPERTY MODELLING #####################\n")

		/* Add the definition of the property */
		/* -> 1.  Insert Assertion modeling Request */
		for (attr : req.attributes) {
			if (this.attributes.getBound(attr.name) != null) {

				if (attr.value.size == 1) {
					//singled-valued attribute
					str.append(
						"(assert (= (val " + getNameAttr(SubstitutionSet._nameToString(attr.name)) + ") " +
							getExpressionValue(attr.value.get(0)) + "))\n")
				} else {
					//Multi-valued attribute 
					/* 1 -> Force the value of the set a specified value */
					for (var i = 0; i < attr.value.size ; i ++){
						str.append(
						"(assert (= (select (val " + 
							getNameAttr(SubstitutionSet._nameToString(attr.name)) + ") " + i + ") " +
							getExpressionValue(attr.value.get(i)) + "))\n")
					}
					/* 2 -> Force any other possible value to be equal to the declared ones */
					str.append("\n(assert (forall ((i Int	))\n")
					str.append("\t (or\n")
					for (var i = 0; i < attr.value.size ; i ++){
						str.append(
						"\t \t (= (select (val " + 
							getNameAttr(SubstitutionSet._nameToString(attr.name)) + ") " + i + ")" +
							getExpressionValue(attr.value.get(i)) + ")\n")
					}
					str.append(")))\n\n")
				}

				/* Force the attribute to not be BOTTOM neither ERROR */
				str.append("(assert (not (miss " + getNameAttr(SubstitutionSet._nameToString(attr.name)) + ")))\n")
				str.append("(assert (not (err " + getNameAttr(SubstitutionSet._nameToString(attr.name)) + ")))\n")
			}
		}

		/* ONLY FOR EVAL PROPERTY */
		if (prop.equals(SecurityProperty.EVAL)) {
			/* Force to bottom the attributes not assigned in the request */
			for (attr_policy : this.attributes.substitutions.keySet) {
				if (!isDefinedInReq(attr_policy, req)) {
					/* Used in the Policy but not assigned in the Request */
					str.append("(assert (miss " + getNameAttr(attr_policy) + "))\n")
				}
			}
		}

		str.append("\n")
		
		/* -> 2. Add final assertion modeling the satisfiability of the Property  */
		switch (prop) {
			case EVAL: {
				str.append("(assert cns_" + policy_name + "_" + _toDecision(dec) + ")")
			}
			case MAY: {
				str.append("(assert cns_" + policy_name + "_" + _toDecision(dec) + ")")
			}
			case MUST: {
				str.append("(assert (not cns_" + policy_name + "_" + _toDecision(dec) + "))")
			}
		}

		/* Evaluation commands for Z3 */
		str.append("\n\n(check-sat)\n")
		str.append("(get-model)\n")

		return str.toString();
	}

	def String _toDecision(Decision dec) {
		switch (dec) {
			case DENY: {
				return "deny"
			}
			case PERMIT: {
				return "permit"
			}
			case INDETERMINATE: {
				return "indet"
			}
			case NOT_APPLICABLE: {
				return "notApp"
			}
		}
	}

	def boolean isDefinedInReq(String attr_p, Request req) {
		for (attr : req.attributes) {
			if (SubstitutionSet._nameToString(attr.name).equals(attr_p))
				return true
		}
		return false
	}

	/**
	 * Stub for testing SMT-LIB code
	 */
	def String doGenerateSMT_LIB_Test(Facpl resource) throws Exception{

		var StringBuffer str = new StringBuffer()

		/* Type checks + Initialization of constants and various */
		initialiseFacplResource(resource)

		/* Compiling Policies that are declared out from the brackets of the Main */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				str.append(createMainConstraint(pol))
			}
		}

		return str.toString
	}

}
