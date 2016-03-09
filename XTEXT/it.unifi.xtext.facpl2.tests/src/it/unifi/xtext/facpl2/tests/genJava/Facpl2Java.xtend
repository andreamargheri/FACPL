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
class Facpl2Java {
	
	@Inject extension CompilationTestHelper
	
	@Test
	def void testRefAlgClasses() {
     
     '''
		PolicySet pName { permit-overrides-greedy 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
    '''
		PolicySet pName { deny-overrides-greedy 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {permit-unless-deny-greedy 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {deny-unless-permit-greedy 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {first-applicable-greedy 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {only-one-applicable-greedy 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
    
     '''
		PolicySet pName {strong-consensus-greedy 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {week-consensus-greedy 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
    '''
		PolicySet pName { permit-overrides-all 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
    '''
		PolicySet pName { deny-overrides-all 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {permit-unless-deny-all 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {deny-unless-permit-all 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {first-applicable-all 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {only-one-applicable-all 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
    
     '''
		PolicySet pName {strong-consensus-all 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
     '''
		PolicySet pName {week-consensus-all 
		policies:
			Rule rule1 (deny) 
		}
     '''.compile[compiledClass]
    
	}
	
	@Test
	def checkRuleDecl (){
		 
     '''
		PolicySet pName {permit-overrides 
		policies:
			Rule rule1 (permit)
			Rule rule2 (permit)
			Rule rule3 (permit)
			Rule rule4 (permit)
		}
     '''.compile[compiledClass]
     
     
	}
	
	@Test
	def checkPDP_PEP (){
		 
     '''	
		Request:{ Name ( action / id , "READ" ) }
		
		
			PolicySet pName {permit-overrides 
				policies:
					Rule rule1 (permit)
			}
		
		PAS { 
			Extended Indeterminate : false ;
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
			Java Package : "foo" ;
			Requests To Evaluate : Name ;
			pep: deny-biased
			pdp: permit-unless-deny
		
			include pName
			Rule r1 (permit)
			
			PolicySet pName1 {permit-overrides 
				policies:
					Rule rule1 (permit)
			}
		
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
			Java Package : "foo" ;
			Requests To Evaluate : Name ;
			pep: deny-biased
			pdp: permit-unless-deny
		
			include pName
			Rule r1 (permit)
			
		}
     '''.compile[compiledClass]
	}
	
	
	
	
	
	
	
}