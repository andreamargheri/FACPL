package it.unifi.xtext.facpl2.tests.smt;

import com.google.inject.Inject;
import it.unifi.xtext.facpl.Facpl2InjectorProvider;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator;
import it.unifi.xtext.facpl.generator.util.PolicyConstant;
import java.io.PrintWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
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
public class SMT_LIBGenerator_Constant_Test {
  @Inject
  private ParseHelper<Facpl> parser;
  
  @Inject
  private PolicyConstant constant;
  
  @Inject
  @Extension
  private ParseHelper<Facpl> _parseHelper;
  
  @Inject
  @Extension
  private SMT_LIBGenerator _sMT_LIBGenerator;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void genConstants() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("  \t\t\t");
      _builder.append("Rule r1 (permit target: 6.6 && 5 && true && false || cat/id && \"prova\")");
      _builder.newLine();
      _builder.append("  \t");
      _builder.append("}");
      Facpl model = this.parser.parse(_builder);
      final Boolean s = this.constant.doSwitch(model);
      String _string = s.toString();
      System.out.println(_string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genDateTimeLiterals() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Rule r1 (permit target: equal(cat/id, 2005/12/12))");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      final Boolean s = this.constant.doSwitch(model);
      String _string = s.toString();
      System.out.println(_string);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genDateTime1.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
