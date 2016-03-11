package it.unifi.xtext.facpl2.tests.xacml;

import com.google.inject.Inject;
import it.unifi.jaxb.xacml.ParserXACMLEntryPoint;
import it.unifi.xtext.facpl.Facpl2InjectorProvider;
import it.unifi.xtext.facpl.facpl2.Facpl;
import java.io.File;
import java.io.PrintWriter;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(Facpl2InjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class FACPLtranslation_Test {
  @Inject
  @Extension
  private ParseHelper<Facpl> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void checkObl() {
    try {
      String file = "./xacml_src/Obl1.xml";
      File _file = new File(file);
      String code = ParserXACMLEntryPoint.genFACPL(_file);
      Facpl model = this._parseHelper.parse(code);
      this._validationTestHelper.assertNoErrors(model);
      file = "./xacml_src/Obl2.xml";
      File _file_1 = new File(file);
      String _genFACPL = ParserXACMLEntryPoint.genFACPL(_file_1);
      code = _genFACPL;
      Facpl _parse = this._parseHelper.parse(code);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      file = "./xacml_src/Obl3.xml";
      File _file_2 = new File(file);
      String _genFACPL_1 = ParserXACMLEntryPoint.genFACPL(_file_2);
      code = _genFACPL_1;
      Facpl _parse_1 = this._parseHelper.parse(code);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkTarget() {
    try {
      for (int i = 1; (i <= 6); i++) {
        {
          String file = (("./xacml_src/targets/Target" + Integer.valueOf(i)) + ".xml");
          File _file = new File(file);
          String code = ParserXACMLEntryPoint.genFACPL(_file);
          Facpl model = this._parseHelper.parse(code);
          this._validationTestHelper.assertNoErrors(model);
          final PrintWriter writer = new PrintWriter((("facpl_gen/Target" + Integer.valueOf(i)) + ".fpl"), "UTF-8");
          writer.println(code);
          writer.close();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkPSet() {
    try {
      for (int i = 1; (i <= 5); i++) {
        {
          String file = (("./xacml_src/PSet" + Integer.valueOf(i)) + ".xml");
          File _file = new File(file);
          String code = ParserXACMLEntryPoint.genFACPL(_file);
          Facpl model = this._parseHelper.parse(code);
          this._validationTestHelper.assertNoErrors(model);
          final PrintWriter writer = new PrintWriter((("facpl_gen/PSet" + Integer.valueOf(i)) + ".fpl"), "UTF-8");
          writer.println(code);
          writer.close();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkOther() {
    try {
      String n_folder = "./xacml_src/other_3";
      File folder = new File(n_folder);
      File[] listOfFiles = folder.listFiles();
      for (int i = 0; (i < listOfFiles.length); i++) {
        File _get = listOfFiles[i];
        boolean _isFile = _get.isFile();
        if (_isFile) {
          File _get_1 = listOfFiles[i];
          String code = ParserXACMLEntryPoint.genFACPL(_get_1);
          final PrintWriter writer = new PrintWriter((("facpl_gen/other/Policy" + Integer.valueOf(i)) + ".fpl"), "UTF-8");
          writer.println(code);
          writer.close();
          Facpl model = this._parseHelper.parse(code);
          this._validationTestHelper.assertNoErrors(model);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
