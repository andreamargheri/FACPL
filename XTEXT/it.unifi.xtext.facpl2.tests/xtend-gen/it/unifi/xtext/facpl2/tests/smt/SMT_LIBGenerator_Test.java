package it.unifi.xtext.facpl2.tests.smt;

import com.google.inject.Inject;
import it.unifi.xtext.facpl.Facpl2InjectorProvider;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator;
import it.unifi.xtext.facpl.generator.util.ConstraintConstant;
import it.unifi.xtext.facpl.generator.util.PolicyConstant;
import java.io.PrintWriter;
import java.util.HashMap;
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
public class SMT_LIBGenerator_Test extends AbstractXtextTests {
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
  public void genAttribute() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Rule r1 (permit target: cat/id)");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(declare-const n_cat/id (TValue Bool))");
      boolean _contains = cns.contains(_builder_1);
      if (_contains) {
        Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(true));
      } else {
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet Name {permit-overrides ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("policies: Rule r1 (permit target: cat/id && cat1/id)}");
      _builder_2.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_2);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      String _doGenerateSMT_LIB_Test = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      cns = _doGenerateSMT_LIB_Test;
      boolean _and = false;
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("(declare-const n_cat1/id (TValue Bool))");
      boolean _contains_1 = cns.contains(_builder_3);
      if (!_contains_1) {
        _and = false;
      } else {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("(declare-const n_cat/id (TValue Bool))");
        boolean _contains_2 = cns.contains(_builder_4);
        _and = _contains_2;
      }
      if (_and) {
        Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(true));
      } else {
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      }
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("PolicySet Name {permit-overrides ");
      _builder_5.newLine();
      _builder_5.append("policies: ");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("Rule r1 (permit target: addition(cat/id,cat1/id))");
      _builder_5.newLine();
      _builder_5.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_5);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      String _doGenerateSMT_LIB_Test_1 = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      Assert.assertNotNull("Policy Name is not well-typed", _doGenerateSMT_LIB_Test_1);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("PolicySet Name {permit-overrides ");
      _builder_6.newLine();
      _builder_6.append("policies: ");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("Rule r1 (permit target: cat/id && equal(cat1/id,5))");
      _builder_6.newLine();
      _builder_6.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_6);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
      String _doGenerateSMT_LIB_Test_2 = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      cns = _doGenerateSMT_LIB_Test_2;
      boolean _and_1 = false;
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("(declare-const n_cat1/id (TValue Int))");
      boolean _contains_3 = cns.contains(_builder_7);
      if (!_contains_3) {
        _and_1 = false;
      } else {
        StringConcatenation _builder_8 = new StringConcatenation();
        _builder_8.append("(declare-const n_cat/id (TValue Bool))");
        boolean _contains_4 = cns.contains(_builder_8);
        _and_1 = _contains_4;
      }
      if (_and_1) {
        Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(true));
      } else {
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genAttributeConstants() {
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
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(declare-const const_true (TValue Bool))");
      boolean _contains = cns.contains(_builder_1);
      if (_contains) {
        Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(true));
      } else {
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet Name {permit-overrides ");
      _builder_2.newLine();
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Rule r1 (permit target: true");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("obl: [permit M log(5,6.6,false, cat/id,\"prova\")])");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_2);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      String _doGenerateSMT_LIB_Test = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      cns = _doGenerateSMT_LIB_Test;
      boolean _and = false;
      boolean _and_1 = false;
      boolean _and_2 = false;
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("(declare-const const_true (TValue Bool))");
      boolean _contains_1 = cns.contains(_builder_3);
      if (!_contains_1) {
        _and_2 = false;
      } else {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("(declare-const const_6.6 (TValue Real))");
        boolean _contains_2 = cns.contains(_builder_4);
        _and_2 = _contains_2;
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("(declare-const const_false (TValue Bool))");
        boolean _contains_3 = cns.contains(_builder_5);
        _and_1 = _contains_3;
      }
      if (!_and_1) {
        _and = false;
      } else {
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("(declare-const const_5 (TValue Int))");
        boolean _contains_4 = cns.contains(_builder_6);
        _and = _contains_4;
      }
      if (_and) {
        Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(true));
      } else {
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genString() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule r1 (permit target: equal(\"prova\",cat/id) && equal(\"doc\",\"pharmacist\") )");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      System.out.println(cns);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(declare-datatypes () ((String s_prova s_pharmacist s_doc )))");
      boolean _contains = cns.contains(_builder_1);
      if (_contains) {
        Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(true));
      } else {
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genDeclaredFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("dec-fun Bool F_Name (String, Int) ");
      _builder.newLine();
      _builder.append("dec-fun Bool F_Name2 (String, Bool)");
      _builder.newLine();
      _builder.append("dec-fun Set<Int> F (Int, Int) ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("target: F_Name(sub/id, \"doctor\")");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Rule r1 (permit)");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      boolean flag = false;
      try {
        this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(true));
          flag = true;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      if ((!flag)) {
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("dec-fun Bool F_Name (String, Int) ");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("dec-fun Set<Int> F (Int, Int) ");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("PolicySet Name {deny-unless-permit");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("target: F_Name(sub/id, 5)");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("Rule r1 (permit)");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      PrintWriter writer = new PrintWriter("SMT_LIB_gen/decFun/file1.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("dec-fun Bool F_Name (String, Int) ");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("dec-fun Set<Int> F (Int, Int) ");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("PolicySet Name {deny-unless-permit");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("target: in(sub/id, F(n/id, 5))");
      _builder_2.newLine();
      _builder_2.append("\t\t\t\t");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("\t\t\t\t\t");
      _builder_2.append("Rule r1 (permit)");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      String _doGenerateSMT_LIB_Test = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      cns = _doGenerateSMT_LIB_Test;
      PrintWriter _printWriter = new PrintWriter("SMT_LIB_gen/decFun/file2.smt2", "UTF-8");
      writer = _printWriter;
      writer.println(cns);
      writer.close();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("dec-fun Bool F_Name (String, Int)");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("dec-fun Int F (Int, Int)");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("Rule name (permit target: equal(5,n/id) && F_Name(n/string,F(5, n/id)) || F_Name(n/string,F(n/id1, n/id3)))");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
      String _doGenerateSMT_LIB_Test_1 = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      cns = _doGenerateSMT_LIB_Test_1;
      PrintWriter _printWriter_1 = new PrintWriter("SMT_LIB_gen/decFun/file3.smt2", "UTF-8");
      writer = _printWriter_1;
      writer.println(cns);
      writer.close();
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof Exception) {
        final Exception e_1 = (Exception)_t_1;
        String _message = e_1.getMessage();
        System.out.println(_message);
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
  }
  
  @Test
  public void attrSets() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule name (permit target: in(5,n/id) ");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      String _doGenerateSMT_LIB_Test = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      Assert.assertNotNull("Policy Name is not well-typed", _doGenerateSMT_LIB_Test);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void constantSets() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule name (permit target: in(5,set(5,6))) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      PolicyConstant tConst = new PolicyConstant();
      tConst.doSwitch(model);
      HashMap<String, String> _sets = tConst.getSets();
      int _size = _sets.size();
      Assert.assertEquals(_size, 1);
      HashMap<String, ConstraintConstant> _constants = tConst.getConstants();
      boolean _containsKey = _constants.containsKey("set_1");
      Assert.assertEquals(Boolean.valueOf(_containsKey), Boolean.valueOf(true));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule name (permit target: in(n/id,set(true, false, false)))");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule nam1 (deny target: in(true, set(true, false, false))) ");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      PolicyConstant _policyConstant = new PolicyConstant();
      tConst = _policyConstant;
      tConst.doSwitch(model);
      HashMap<String, String> _sets_1 = tConst.getSets();
      int _size_1 = _sets_1.size();
      Assert.assertEquals(_size_1, 1);
      HashMap<String, ConstraintConstant> _constants_1 = tConst.getConstants();
      boolean _containsKey_1 = _constants_1.containsKey("set_1");
      Assert.assertEquals(Boolean.valueOf(_containsKey_1), Boolean.valueOf(true));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Rule name (permit target: in(n/id,set(true, false, false)))");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Rule nam1 (deny target: in(true, set(false, false))) ");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      PolicyConstant _policyConstant_1 = new PolicyConstant();
      tConst = _policyConstant_1;
      tConst.doSwitch(model);
      HashMap<String, String> _sets_2 = tConst.getSets();
      int _size_2 = _sets_2.size();
      Assert.assertEquals(_size_2, 2);
      HashMap<String, ConstraintConstant> _constants_2 = tConst.getConstants();
      boolean _containsKey_2 = _constants_2.containsKey("set_1");
      Assert.assertEquals(Boolean.valueOf(_containsKey_2), Boolean.valueOf(true));
      HashMap<String, ConstraintConstant> _constants_3 = tConst.getConstants();
      boolean _containsKey_3 = _constants_3.containsKey("set_2");
      Assert.assertEquals(Boolean.valueOf(_containsKey_3), Boolean.valueOf(true));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("Rule name (permit target: in(n/id,set(true, false, false))) ");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("PolicySet pSet1 {permit-unless-deny");
      _builder_3.newLine();
      _builder_3.append("policies: ");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("Rule nam1 (deny target: in(true, set(false, false)))");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
      PolicyConstant _policyConstant_2 = new PolicyConstant();
      tConst = _policyConstant_2;
      tConst.doSwitch(model);
      HashMap<String, String> _sets_3 = tConst.getSets();
      int _size_3 = _sets_3.size();
      Assert.assertEquals(_size_3, 2);
      HashMap<String, ConstraintConstant> _constants_4 = tConst.getConstants();
      boolean _containsKey_4 = _constants_4.containsKey("set_1");
      Assert.assertEquals(Boolean.valueOf(_containsKey_4), Boolean.valueOf(true));
      HashMap<String, ConstraintConstant> _constants_5 = tConst.getConstants();
      boolean _containsKey_5 = _constants_5.containsKey("set_2");
      Assert.assertEquals(Boolean.valueOf(_containsKey_5), Boolean.valueOf(true));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genSets() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule name (permit target: in(7,set(5,6))) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String cns = this._sMT_LIBGenerator.doGenerateSMT_LIB_Test(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(declare-const const_set_1 (TValue (Set Int)))");
      boolean _contains = cns.contains(_builder_1);
      if (_contains) {
        Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(true));
      } else {
        Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(true));
      }
      final PrintWriter writer = new PrintWriter("SMT_LIB_gen/decSet/file1_const.smt2", "UTF-8");
      writer.println(cns);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
