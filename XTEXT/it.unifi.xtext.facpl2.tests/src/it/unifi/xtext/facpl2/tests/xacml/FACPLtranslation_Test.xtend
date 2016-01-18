package it.unifi.xtext.facpl2.tests.xacml

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import it.unifi.xtext.facpl.Facpl2InjectorProvider
import org.eclipse.xtext.junit4.XtextRunner
import com.google.inject.Inject
import it.unifi.xtext.facpl.facpl2.Facpl
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import it.unifi.jaxb.xacml.ParserXACMLEntryPoint
import org.eclipse.xtext.junit4.AbstractXtextTests
import java.io.File
import java.io.PrintWriter

@InjectWith(typeof(Facpl2InjectorProvider))
@RunWith(typeof(XtextRunner))
class FACPLtranslation_Test extends AbstractXtextTests {

	@Inject extension ParseHelper<Facpl>

	@Inject extension ValidationTestHelper

	@Test
	def void checkObl() {

		var file = "./xacml_src/Obl1.xml"
		var code = ParserXACMLEntryPoint.genFACPL(new File(file))
		var model = code.parse

		assertNoErrors(model)

		file = "./xacml_src/Obl2.xml"

		code = ParserXACMLEntryPoint.genFACPL(new File(file))

		model = code.parse

		assertNoErrors(model)

		file = "./xacml_src/Obl3.xml"

		code = ParserXACMLEntryPoint.genFACPL(new File(file))

		model = code.parse

		assertNoErrors(model)

	}

	@Test
	def void checkPSet() {

		for (var i = 1; i <= 5; i ++) {
			var file = "./xacml_src/PSet" + i + ".xml"
			var code = ParserXACMLEntryPoint.genFACPL(new File(file))
			var model = code.parse

			assertNoErrors(model)

			val PrintWriter writer = new PrintWriter("facpl_gen/PSet"+i+".fpl", "UTF-8");
			writer.println(code);
			writer.close();

		}

	}

	@Test
	def void checkOther() {

		var n_folder = "./xacml_src/other_3";
		var folder = new File(n_folder);
		var File[] listOfFiles = folder.listFiles();

		for (var i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles.get(i).isFile()) {

				var code = ParserXACMLEntryPoint.genFACPL(listOfFiles.get(i))
				
				val PrintWriter writer = new PrintWriter("facpl_gen/other/Policy"+i+".fpl", "UTF-8");
				writer.println(code);
				writer.close();
				
				var model = code.parse
				
				assertNoErrors(model)
			}
		}
	}
}