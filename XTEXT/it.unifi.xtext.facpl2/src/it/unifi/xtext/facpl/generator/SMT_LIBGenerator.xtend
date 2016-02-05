package it.unifi.xtext.facpl.generator

import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.generator.generators.SMT_LIBGenerator_Code
import org.eclipse.xtext.generator.IFileSystemAccess
import it.unifi.xtext.facpl.facpl2.Request
import it.unifi.xtext.facpl.generator.util.Decision
import it.unifi.xtext.facpl.generator.util.SecurityProperty


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
	def void doGenerateSecurity_Property(Facpl resource, String policy_name, String name_property, 
		Request req, Decision dec,	SecurityProperty prop, IFileSystemAccess fsa) {

		/* Generate the SMT_LIB code of the FacplPolicy in input*/

		/* -> Type checks + Initialization of constants and various */
		initialiseFacplResource(resource)

		/* -> Compile the chosen policy */
		var str = new StringBuffer
		if (resource.getPolicies != null) {
			for (pol : resource.getPolicies) {
				if (pol.name.equals(policy_name)){
					str.append(createMainConstraint(pol))
				}			
			}
		}
	
	
		/* Add the definition of the property */
	
		/* ->1.  Insert Assertion modeling Request */
		
		/* ->2. Add final assertion modeling the satisfiability of the Property  */
		
		switch (prop) {
			case EVAL: {
				
			}
			case MAY: {
				
			}
			case MUST: {
				
			}
		}
	
		
		/* Copy the generated SMT-LIB in a FILE  */
		
		fsa.generateFile(policy_name + "_property_"+ name_property +".smt2", str.toString);

		
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
