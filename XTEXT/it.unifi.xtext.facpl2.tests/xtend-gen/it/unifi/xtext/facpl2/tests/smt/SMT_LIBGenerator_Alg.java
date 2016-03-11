package it.unifi.xtext.facpl2.tests.smt;

import com.google.inject.Inject;
import it.unifi.xtext.facpl.Facpl2InjectorProvider;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator;
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
public class SMT_LIBGenerator_Alg {
  @Inject
  @Extension
  private ParseHelper<Facpl> _parseHelper;
  
  @Inject
  @Extension
  private SMT_LIBGenerator _sMT_LIBGenerator;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  /**
   * PERMIT-OVERRIDES
   */
  @Test
  public void genPolicy_PermiOver_Def() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides");
      _builder.newLine();
      _builder.append("target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule r1 (permit target: false && true && cat/id)");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_PermitOver_Def.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_PermitOver_Comb() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t");
      _builder.append("PolicySet Name {permit-overrides");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_PermitOver_Comb.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_PermitOver_Comb2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r3 (permit)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r4 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_PermitOver_Comb2.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * DENY-OVERRIDES
   */
  @Test
  public void genPolicy_DenyOver_Def() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-overrides");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit target: false && true && cat/id)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_DenyOver_Def.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_DenyOver_Comb() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-overrides");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_DenyOver_Comb.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_DenyOver_Comb2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-overrides");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r3 (permit)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r4 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_DenyOver_Comb2.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * DENY-UNLESS-PERMIT
   */
  @Test
  public void genPolicy_DenyUnless_Def() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit target: false && true && cat/id)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_DenyUnless_Def.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_DenyUnless_Comb() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_DenyUnless_Comb.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_DenyUnless_Comb2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r3 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 6))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_DenyUnless_Comb2.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * PERMIT-UNLESS-DENY
   */
  @Test
  public void genPolicy_PermitUnless_Def() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-unless-deny");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit target: false && true && cat/id)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_PermitUnless_Def.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_PermitUnless_Comb() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-unless-deny");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_PermitUnless_Comb.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_PermitUnless_Comb2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-unless-deny");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r3 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 6))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_PermitUnless_Comb2.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * FIRST-APPLICABLE
   */
  @Test
  public void genPolicy_FirstApp_Def() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {first-applicable");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit target: false && true && cat/id)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_FirstApp_Def.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_FirstApp_Comb() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {first-applicable");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_FirstApp_Comb.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_FirstApp_Comb2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {first-applicable");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r3 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 6))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_FirstApp_Comb2.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * ONE-APPLICABLE
   */
  @Test
  public void genPolicy_OneApp_Def() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {only-one-applicable");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit target: false && true && cat/id)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_OneApp_Def.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_OneApp_Comb() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {only-one-applicable");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_OneApp_Comb.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_OneApp_Comb2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {only-one-applicable");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r3 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 6))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_OneApp_Comb2.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * WEAK-CONSENSUS
   */
  @Test
  public void genPolicy_WeakCon_Def() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {weak-consensus");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit target: false && true && cat/id)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_Weak_Def.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_WeakCon_Comb() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {weak-consensus");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_Weak_Comb.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_WeakCon_Comb2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {weak-consensus");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r3 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 6))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_Weak_Comb2.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * STRONG-CONSENSUS
   */
  @Test
  public void genPolicy_StrongCon_Def() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {strong-consensus");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: false && true && cat/id && equal(cat/id1, 5.5) || greater-than(4, cat/num)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit target: false && true && cat/id)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_Strong_Def.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_StrongCon_Comb() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {strong-consensus");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_Strong_Comb.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_StrongCon_Comb2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {strong-consensus");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("target: equal(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r1 (permit ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("obl: [permit M log (addition(5,sub/profile))])");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r2 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 5))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Rule r3 (deny ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("target: equal(act/type, 6))");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/genPolicy_Strong_Comb2.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genPolicy_EHealth() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet ePre { permit-overrides-all ");
      _builder.newLine();
      _builder.append("\t\t ");
      _builder.append("target: equal(\"e-Prescription\", resource/type)");
      _builder.newLine();
      _builder.append("\t\t ");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Rule write (permit target: equal(subject/role, \"doctor\") && equal(action/id, \"write\")");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("&& in (\"e-Pre-Write\", subject/permission)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("&& in (\"e-Pre-Read\", subject/permission)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append(")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Rule read (permit target: equal(subject/role, \"doctor\") && equal(action/id, \"read\")");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("&& in (\"e-Pre-Read\", subject/permission)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append(")");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Rule pha (permit target: equal(subject/role, \"pharmacist\") && equal(action/id, \"read\")");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("&& in (\"e-Pre-Read\", subject/permission))");
      _builder.newLine();
      _builder.append("\t\t\t  ");
      _builder.append("obl: ");
      _builder.newLine();
      _builder.append("\t\t\t  ");
      _builder.append("[permit M log(system/time, resource/type,subject/id, action/id)]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/eHealth/ePre.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
