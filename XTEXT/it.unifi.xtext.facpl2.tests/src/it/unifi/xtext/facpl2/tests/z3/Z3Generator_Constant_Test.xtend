package it.unifi.xtext.facpl2.tests.z3

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import org.eclipse.xtext.junit4.AbstractXtextTests
import it.unifi.xtext.facpl.facpl2.Facpl
import org.eclipse.xtext.junit4.util.ParseHelper
import com.google.inject.Inject
import org.junit.Test
import it.unifi.xtext.facpl.generator.util.PolicyConstant

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
public class Z3Generator_Constant_Test extends AbstractXtextTests {

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