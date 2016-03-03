package it.unifi.xtext.facpl2.tests.smt

import com.google.inject.Inject
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator
import it.unifi.xtext.facpl.generator.util.PolicyConstant
import java.io.PrintWriter
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
public class SMT_LIBGenerator_Constant_Test  {
	
	@Inject
	ParseHelper<Facpl> parser

	@Inject
	PolicyConstant constant
	
	@Inject extension ParseHelper<Facpl>

	@Inject extension SMT_LIBGenerator
 
 	@Inject extension ValidationTestHelper

	@Test
	def void genConstants() {
		var model = parser.parse(
			'''PolicySet Name {permit-overrides 
  		policies: 
  			Rule r1 (permit target: 6.6 && 5 && true && false || cat/id && "prova")
  	}'''
		)

		val s = constant.doSwitch(model)

		System.out.println(s.toString)
	}


	@Test
	def void genDateTimeLiterals(){
		
		var model = ('''
		PolicySet Name {permit-overrides 
		policies: 
				Rule r1 (permit target: equal(cat/id, 2005/12/12))
		}''').parse

		model.assertNoErrors()

		val s = constant.doSwitch(model)

		System.out.println(s.toString)
	
		var String cns = doGenerateSMT_LIB_Test(model)
		
//		System.out.println(cns)
		
		val PrintWriter writer = new PrintWriter("SMT_LIB_gen/genDateTime1.smt2", "UTF-8");
		writer.println(cns);
		writer.close();
		
		
	}

}