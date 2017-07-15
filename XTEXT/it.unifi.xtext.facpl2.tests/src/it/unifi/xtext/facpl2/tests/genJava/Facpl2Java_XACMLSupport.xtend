package it.unifi.xtext.facpl2.tests.genJava

import com.google.inject.Inject
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(Facpl2InjectorProvider))
class Facpl2Java_XACMLSupport {
	
	@Inject extension CompilationTestHelper
	
	@Test
	def check_XACMLTranslationSupport (){
		 
     '''	
		Request:{ Name ( action / id , "READ" ) }
		
		
			PolicySet pName {permit-overrides 
				policies:
					Rule rule1 (permit)
			}
		
		PAS { 
			Extended Indeterminate : false ;
			Simulate XACML Semantics: true ;
			Java Package : "foo" ;
			Requests To Evaluate : Name ;
			pep: deny-biased
			pdp: permit-unless-deny
		
			include pName
		
		}
     '''.compile[compiledClass]
     
     
     '''	
		Request:{ Name ( action / id , "READ" ) }
		
		
			PolicySet pName {permit-overrides 
				policies:
					Rule rule1 (permit)
			}
		
		PAS { 
			Extended Indeterminate : false ;
			Simulate XACML Semantics: false ;
			Java Package : "foo" ;
			Requests To Evaluate : Name ;
			pep: deny-biased
			pdp: permit-unless-deny
		
			include pName
		
		}
     '''.compile[compiledClass]
     
	}
	

	
}