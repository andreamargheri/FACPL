package it.unifi.xtext.facpl.generator

import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.facpl2.Request
import it.unifi.xtext.facpl.generator.generators.SMT_LIBGenerator_Code
import it.unifi.xtext.facpl.generator.util.Decision
import it.unifi.xtext.facpl.generator.util.StructuralProperty
import it.unifi.xtext.facpl.validation.inference.SubstitutionSet
import org.eclipse.xtext.generator.IFileSystemAccess
import it.unifi.xtext.facpl.generator.util.AuthorisationProperty

class SMT_LIBGenerator extends SMT_LIBGenerator_Code {

	/**
	 * EntryPoint for menu command Generate SMT-LIB code
	 */
	def void doGenerateFileSMT_LIB(Facpl resource, IFileSystemAccess fsa) throws Exception{
		
	
		/* Type checks + Initialization of constants and various */
		var header = initialiseFacplResource(resource)

		/* Compiling policies */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				fsa.generateFile(pol.getName + ".smt2", header +" \n" + createMainConstraint(pol));
			}
		}
		if (resource.main != null) {
			if (resource.main.paf.pdp != null) {
				for (pol : resource.main.paf.pdp.polSet) {
					if (pol.newPolicy != null) {
						fsa.generateFile(pol.newPolicy.getName + ".smt2", header +" \n" + createMainConstraint(pol.newPolicy));
					}
				// Referred policies are not compiled
				}
			}
		}

	}

	/**
	 * EntryPoint for Authorisation Property
	 */
	def void doGenerateAuthorisation_Property(Facpl resource, String policy_name, String name_property, Request req,
		Decision dec, AuthorisationProperty prop, IFileSystemAccess fsa) {

		var str = doGenerateAuthorisation_Property_Code(resource, policy_name, req, dec, prop);

		var fileName =  "Property_" + name_property + "_" + policy_name ;
		/* Copy the generated SMT-LIB in a FILE  */
		fsa.generateFile(fileName + ".smt2", str);
		
		/* Generate Z3 bash commands for executing file */
		fsa.generateFile(fileName + "_z3.sh", getBashCommand(fileName, name_property, policy_name))

	}
	
	
	/**
	 * EntryPoint for Structural Property
	 */
	def void doGenerateStructural_Property(Facpl resource, String policy_name1, String policy_name2, 
		String name_property, StructuralProperty prop, IFileSystemAccess fsa) {
		
		var str = ""
		var fileName = ""
		if (prop.equals(StructuralProperty.COMPLETE)){
			/* Only one policy is involved */
			str = doGenerateComplete_Property_Code(resource, policy_name1);
			fileName = "Property_" + name_property + "_" + policy_name1;
		}else {
			str = doGenerateStructural_Property_Code(resource, policy_name1, policy_name2, prop);
			fileName = "Property_" + name_property + "_" + policy_name1 + "_" + policy_name2;
		}
		/* Copy the generated SMT-LIB in a FILE  */
		fsa.generateFile(fileName + ".smt2", str);
		
		/* Generate Z3 bash commands for executing file */
		fsa.generateFile(fileName + "_z3.sh", getBashCommand(fileName, name_property, policy_name1))

	}
		
	/**
	 * Main bash file for Z3 launch
	 */
	def getBashCommand(String fileName, String prop_name, String policy_name) '''
	#! /bin/bash
	
	clear
	
	echo "Starting Verification of Property «prop_name» on FACPL Policy «policy_name»"
	
	#Alias z3 is assumed defined in the environment
	
	z3 -st -smt2 «fileName».smt2
	'''

	/**
	 * Generation of SMT-LIB code for the Complete Structural Property
	 */
	def doGenerateComplete_Property_Code(Facpl resource, String policy_name) {
		var str = new StringBuffer
		
		/* Generate the SMT_LIB code of the FacplPolicy in input*/
		/* -> Type checks + Initialization of constants and various */
		str.append(initialiseFacplResource(resource))

		/* -> Compile to SMT-LIB the chosen policy */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				if (pol.name.equals(policy_name)) {
					str.append(createMainConstraint(pol))
				}
			}
		}

		str.append(";###################### STRUCTURAL PROPERTY #####################\n")
		
		str.append("(echo \"--> Check COMPLETE of " + policy_name + "... (holds if the following check is unsat)\")\n")
		
		str.append("(assert cns_" + policy_name + "_notApp)")
		
		/* Evaluation commands for Z3 */
		str.append("\n\n(check-sat)\n")
		str.append("(get-model)\n")

		return str.toString();
	}

	/**
	 * Generation of the SMT-LIB for the structural properties
	 */
	def doGenerateStructural_Property_Code(Facpl resource, String policy_name1, String policy_name2, StructuralProperty property) {
		var str = new StringBuffer
		
		/* Generate the SMT_LIB code of the FacplPolicy in input*/
		/* -> Type checks + Initialization of constants and various */
		str.append(initialiseFacplResource(resource))

	
		/* -> Compile to SMT-LIB the chosen policy */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				if (pol.name.equals(policy_name1) || pol.name.equals(policy_name2)) {
					str.append(createMainConstraint(pol))
				}
			}
		}

		str.append(";###################### STRUCTURAL PROPERTY #####################\n")
		
		if (property.equals(StructuralProperty.COVER)){
		
			/* Policy1 cover Policy2 */
		
			str.append("(echo \"--> Check " + policy_name1 + "COVER" + policy_name2 +"... (holds if the following two checks are unsat)\")\n")
			
			/* Check 1 of 2 */

			str.append("(echo \"...(1/2) " + policy_name1 + "_PERMIT  COVER " + policy_name2 + "_PERMIT...(holds if it is unsat)\")\n ")
			
			str.append("(push)\n")
			str.append("(assert \n")
			str.append("\t (and (not cns_"+ policy_name1 + "_permit) cns_"+ policy_name2 + "_permit)\n")
			str.append(")\n")
			
			/* Evaluation commands for Z3 */
			str.append("\n(check-sat)\n")
			str.append(";(get-model)\n\n")
			
			/* Check 2 of 2 */
			
			str.append("(pop)\n")
			str.append("(push)\n")
			
			str.append("(echo \"...(2/2) " + policy_name1 + "_DENY  COVER " + policy_name2 + "_DENY...(holds if it is unsat)\")\n ")
			
			str.append("(assert \n")
			str.append("\t (and (not cns_"+ policy_name1 + "_deny) cns_"+ policy_name2 + "_deny)\n")
			str.append(")\n")
			
			/* Evaluation commands for Z3 */
			str.append("\n(check-sat)\n")
			str.append(";(get-model)\n\n")

			
		}else if (property.equals(StructuralProperty.DISJOINT)){

			/* Policy1 DISJOINT Policy2 */
		
			str.append("(echo \"--> Check " + policy_name1 + "DIJOINT" + policy_name2 +"... (holds if the following four checks are unsat)\")\n")
			
			/* Check 1 of 4 */

			str.append("(echo \"...(1/4) " + policy_name1 + "_PERMIT  DIJOINT " + policy_name2 + "_PERMIT...(holds if it is unsat)\")\n ")
			
			str.append("(push)\n")
			str.append("(assert \n")
			str.append("\t (and cns_"+ policy_name1 + "_permit cns_"+ policy_name2 + "_permit)\n")
			str.append(")\n")
			
			/* Evaluation commands for Z3 */
			str.append("\n(check-sat)\n")
			str.append(";(get-model)\n\n")
	
			/* Check 2 of 4 */

			str.append("(echo \"...(2/4) " + policy_name1 + "_PERMIT  DIJOINT " + policy_name2 + "_DENY...(holds if it is unsat)\")\n ")
			
			str.append("(push)\n")
			str.append("(assert \n")
			str.append("\t (and cns_"+ policy_name1 + "_permit cns_"+ policy_name2 + "_deny)\n")
			str.append(")\n")
			
			/* Evaluation commands for Z3 */
			str.append("\n(check-sat)\n")
			str.append(";(get-model)\n\n")
			
			/* Check 3 of 4 */

			str.append("(echo \"...(3/4) " + policy_name1 + "_DENY  DIJOINT " + policy_name2 + "_PERMIT...(holds if it is unsat)\")\n ")
			
			str.append("(push)\n")
			str.append("(assert \n")
			str.append("\t (and cns_"+ policy_name1 + "_deny cns_"+ policy_name2 + "_permit)\n")
			str.append(")\n")
			
			/* Evaluation commands for Z3 */
			str.append("\n(check-sat)\n")
			str.append(";(get-model)\n\n")
			
			
			/* Check 4 of 4 */

			str.append("(echo \"...(4/4) " + policy_name1 + "_DENY  DIJOINT " + policy_name2 + "_DENY...(holds if it is unsat)\")\n ")
			
			str.append("(push)\n")
			str.append("(assert \n")
			str.append("\t (and cns_"+ policy_name1 + "_deny cns_"+ policy_name2 + "_deny)\n")
			str.append(")\n")
			
			/* Evaluation commands for Z3 */
			str.append("\n(check-sat)\n")
			str.append(";(get-model)\n\n")
			
		}else {
			throw new Exception("Wrong invocation of the generation method for the case of structural properties")
		}
		
		return str.toString();	
	}
	

	/**
	 * Generation of SMT-LIB code for Authorisation Property 
	 */
	def String doGenerateAuthorisation_Property_Code(Facpl resource, String policy_name, Request req, Decision dec,
		AuthorisationProperty prop) {
		
		var str = new StringBuffer
		
		/* Generate the SMT_LIB code of the FacplPolicy in input*/
		/* -> Type checks + Initialization of constants and various */
		str.append(initialiseFacplResource_Request(resource, req))

		/* -> Compile to SMT-LIB the chosen policy */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				if (pol.name.equals(policy_name)) {
					str.append(createMainConstraint(pol))
				}
			}
		}

		str.append(";###################### AUTHORISATION PROPERTY #####################\n")

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
					//Multivalued attribute 
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
		if (prop.equals(AuthorisationProperty.EVAL)) {
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
				str.append("(echo \" --> Check EVAL property... (holds if the following check is sat)\")\n")
			}
			case MAY: {
				str.append("(assert cns_" + policy_name + "_" + _toDecision(dec) + ")")
				str.append("(echo \" --> Check MAY property... (holds if the following check is sat)\")\n")
			}
			case MUST: {
				str.append("(assert (not cns_" + policy_name + "_" + _toDecision(dec) + "))")
				str.append("(echo \" --> Check MUST property... (holds if the following check is unsat)\")\n")
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
		var init = initialiseFacplResource(resource)

		println("Generating policy code...")

		/* Compiling Policies that are declared out from the brackets of the Main */
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				str.append(createMainConstraint(pol))
			}
		}

		return init + "\n" + str.toString
	}

}
