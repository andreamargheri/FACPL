package it.unifi.xtext.facpl2.tests.smt

import com.google.inject.Inject
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.generator.util.PolicyConstant
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
public class SMT_LIBGenerator_Constant_Test extends AbstractXtextTests {

	@Inject
	ParseHelper<Facpl> parser

	@Inject
	PolicyConstant constant

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

}