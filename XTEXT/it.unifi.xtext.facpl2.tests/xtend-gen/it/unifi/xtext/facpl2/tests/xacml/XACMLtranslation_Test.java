package it.unifi.xtext.facpl2.tests.xacml;

import com.google.inject.Inject;
import it.unifi.jaxb.xacml.ParserXACMLEntryPoint;
import it.unifi.xtext.facpl.Facpl2InjectorProvider;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.generator.XMLGenerator;
import it.unifi.xtext.facpl.validation.Facpl2Xacml_Validator;
import java.io.PrintWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(Facpl2InjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XACMLtranslation_Test extends AbstractXtextTests {
  @Inject
  @Extension
  private ParseHelper<Facpl> _parseHelper;
  
  @Inject
  @Extension
  private XMLGenerator _xMLGenerator;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  private int counter = 0;
  
  public int getId() {
    this.counter++;
    return this.counter;
  }
  
  private Facpl2Xacml_Validator xacml_val = new Facpl2Xacml_Validator();
  
  @Test
  public void checkPolicySet() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Rule r1 (permit target: cat/id)");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      boolean _stubCheckXACML = this.stubCheckXACML(model, "PSet");
      Assert.assertEquals(Boolean.valueOf(_stubCheckXACML), Boolean.valueOf(true));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet Name {permit-overrides ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("target: equal(true,cat/id)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("Rule r1 (permit target: cat/id)");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      boolean _stubCheckXACML_1 = this.stubCheckXACML(model, "PSet");
      Assert.assertEquals(Boolean.valueOf(_stubCheckXACML_1), Boolean.valueOf(true));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet Name {permit-overrides ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("target: equal(true,cat/id) && less-than(4,n/id)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("Rule r1 (permit target: cat/id)");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      boolean _stubCheckXACML_2 = this.stubCheckXACML(model, "PSet");
      Assert.assertEquals(Boolean.valueOf(_stubCheckXACML_2), Boolean.valueOf(true));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet Name {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("policies: ");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("Rule r1 (permit target: less-than(4,addition(4,5)))");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("Rule r2 (permit target: cat/id)");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      boolean _stubCheckXACML_3 = this.stubCheckXACML(model, "PSet");
      Assert.assertEquals(Boolean.valueOf(_stubCheckXACML_3), Boolean.valueOf(true));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("PolicySet Name {deny-unless-permit ");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("target: equal(true,cat/id) && less-than(4,n/id)");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("policies: ");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("Rule r1 (permit target: cat/id)");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("Rule r2 (permit target: cat/id)");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("PolicySet Name2 {deny-unless-permit ");
      _builder_4.newLine();
      _builder_4.append("\t\t\t\t\t");
      _builder_4.append("target: equal(false,cat/id) ");
      _builder_4.newLine();
      _builder_4.append("\t\t\t\t\t");
      _builder_4.append("policies:");
      _builder_4.newLine();
      _builder_4.append("\t\t\t\t\t");
      _builder_4.append("Rule r4 (permit target: equal(addition(5,5),n/num))");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      boolean _stubCheckXACML_4 = this.stubCheckXACML(model, "PSet");
      Assert.assertEquals(Boolean.valueOf(_stubCheckXACML_4), Boolean.valueOf(true));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkObl() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Rule r1 (permit target: true)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("obl-p: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("[M mail(cat/id)]");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      boolean _stubCheckXACML = this.stubCheckXACML(model, "Obl");
      Assert.assertEquals(Boolean.valueOf(_stubCheckXACML), Boolean.valueOf(true));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet Name {permit-overrides ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("Rule r1 (permit target: true)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("obl-p: ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("[ M mail(cat/id, true, 5, addition(4,5))]");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      boolean _stubCheckXACML_1 = this.stubCheckXACML(model, "Obl");
      Assert.assertEquals(Boolean.valueOf(_stubCheckXACML_1), Boolean.valueOf(true));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet Name {permit-overrides ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("Rule r1 (permit target: true)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("obl-p: ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("[ M mail(cat/id, true, 5, addition(4,5))]");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("obl-d:");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("[O mail(cat/id, true, 5, addition(4,5))]");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      boolean _stubCheckXACML_2 = this.stubCheckXACML(model, "Obl");
      Assert.assertEquals(Boolean.valueOf(_stubCheckXACML_2), Boolean.valueOf(true));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Aux methods for checking XACML policies
   */
  public boolean stubCheckXACML(final Facpl model, final String str) {
    try {
      int _id = this.getId();
      String id = (str + Integer.valueOf(_id));
      System.out.println((("Validating Policy of case " + id) + " ...."));
      this._validationTestHelper.assertNoErrors(model);
      Boolean test = this.xacml_val.isXACML_Formed(model);
      System.out.println(("-> Well-Formed for XACML " + test));
      Assert.assertEquals(test, Boolean.valueOf(true));
      final String xacml = this._xMLGenerator.doGenerateXACML_StubTest(model);
      String file_id = (("xacml_gen/" + id) + ".xml");
      final PrintWriter writer = new PrintWriter(file_id, "UTF-8");
      writer.println(xacml);
      writer.close();
      try {
        ParserXACMLEntryPoint.parseXACML(file_id);
        System.out.println("->Parsing OK");
        System.out.println(("...end Validating Policy of case " + id));
        return true;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          System.out.println("->Parsing Error");
          System.out.println(("...end Validating Policy of case " + id));
          return false;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
