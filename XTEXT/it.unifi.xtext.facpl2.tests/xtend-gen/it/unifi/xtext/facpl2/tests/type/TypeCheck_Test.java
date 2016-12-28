package it.unifi.xtext.facpl2.tests.type;

import com.google.inject.Inject;
import it.unifi.xtext.facpl.Facpl2InjectorProvider;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(Facpl2InjectorProvider.class)
@SuppressWarnings("all")
public class TypeCheck_Test {
  @Inject
  @Extension
  private ParseHelper<Facpl> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testFunctionEqual() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("Rule name (permit ");
      _builder.newLine();
      _builder.append("target: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("equal(5, true)");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      EClass _function = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("Rule name (permit ");
      _builder_1.newLine();
      _builder_1.append("target: ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("not-equal(5, true)");
      _builder_1.newLine();
      _builder_1.append(")");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _function_1 = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function_1, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("Rule name (permit ");
      _builder_2.newLine();
      _builder_2.append("target: ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("equal(cat/id, true)");
      _builder_2.newLine();
      _builder_2.append(")");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("Rule name (permit ");
      _builder_3.newLine();
      _builder_3.append("target: ");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("not-equal(cat/id, true && false)");
      _builder_3.newLine();
      _builder_3.append(")");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunctionComparison() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("Rule name (permit ");
      _builder.newLine();
      _builder.append("target: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("greater-than(5, true)");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      EClass _function = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("Rule name (permit ");
      _builder_1.newLine();
      _builder_1.append("target: ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("less-than(5, true)");
      _builder_1.newLine();
      _builder_1.append(")");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _function_1 = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function_1, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("Rule name (permit ");
      _builder_2.newLine();
      _builder_2.append("target: ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("less-than(cat/id, true)");
      _builder_2.newLine();
      _builder_2.append(")");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      EClass _function_2 = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function_2, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("Rule name (permit ");
      _builder_3.newLine();
      _builder_3.append("target: ");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("less-than-or-equal(cat/id, cat/id)");
      _builder_3.newLine();
      _builder_3.append(")");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("PolicySet pSet {deny-unless-permit ");
      _builder_4.newLine();
      _builder_4.append("policies:");
      _builder_4.newLine();
      _builder_4.append("Rule name (permit ");
      _builder_4.newLine();
      _builder_4.append("target: ");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("less-than-or-equal(5, cat/id)");
      _builder_4.newLine();
      _builder_4.append(")");
      _builder_4.newLine();
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("PolicySet pSet {deny-unless-permit ");
      _builder_5.newLine();
      _builder_5.append("policies:");
      _builder_5.newLine();
      _builder_5.append("Rule name (permit ");
      _builder_5.newLine();
      _builder_5.append("target: ");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("less-than-or-equal(5, 2015/12/10)");
      _builder_5.newLine();
      _builder_5.append(")");
      _builder_5.newLine();
      _builder_5.append("}");
      Facpl _parse_4 = this._parseHelper.parse(_builder_5);
      model = _parse_4;
      EClass _function_3 = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function_3, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("PolicySet pSet {deny-unless-permit ");
      _builder_6.newLine();
      _builder_6.append("policies:");
      _builder_6.newLine();
      _builder_6.append("Rule name (permit ");
      _builder_6.newLine();
      _builder_6.append("target: ");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("greater-than-or-equal(2000/12/12, 2015/12/10)");
      _builder_6.newLine();
      _builder_6.append(")");
      _builder_6.newLine();
      _builder_6.append("}");
      Facpl _parse_5 = this._parseHelper.parse(_builder_6);
      model = _parse_5;
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunctionArith() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("Rule name (permit ");
      _builder.newLine();
      _builder.append("target: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("addition(5, true)");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      EClass _function = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("Rule name (permit ");
      _builder_1.newLine();
      _builder_1.append("target: ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("addition(5, cat/id)");
      _builder_1.newLine();
      _builder_1.append(")");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("Rule name (permit ");
      _builder_2.newLine();
      _builder_2.append("target: ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("addition(5, subtract(10, cat/id))");
      _builder_2.newLine();
      _builder_2.append(")");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("Rule name (permit ");
      _builder_3.newLine();
      _builder_3.append("target: ");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("divide(5, true && subtract(10, cat/id))");
      _builder_3.newLine();
      _builder_3.append(")");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      EClass _function_1 = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function_1, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("PolicySet pSet {deny-unless-permit ");
      _builder_4.newLine();
      _builder_4.append("policies:");
      _builder_4.newLine();
      _builder_4.append("Rule name (permit ");
      _builder_4.newLine();
      _builder_4.append("target: ");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("multiply(5, cat/id && subtract(10, cat/id))");
      _builder_4.newLine();
      _builder_4.append(")");
      _builder_4.newLine();
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      EClass _function_2 = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function_2, 
        null, 
        "Expression cannot be typed");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunctionIn() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("Rule name (permit target: in(5, set(5,5))\t)");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("Rule name (permit target: in(true, set(5,5))\t)");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _function = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("Rule name (permit target: in(n/id, set(5,5))\t)");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("Rule name (permit target: in(n/id, set(5,5)) && equal(n/id, 5)\t)");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("PolicySet pSet {deny-unless-permit ");
      _builder_4.newLine();
      _builder_4.append("policies:");
      _builder_4.newLine();
      _builder_4.append("Rule name (permit target: in(n/id, set(5,5)) && equal(n/id, true)\t)");
      _builder_4.newLine();
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      EClass _function_1 = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function_1, 
        null, 
        "Expression cannot be typed");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunctionset() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("Rule name (permit ");
      _builder.newLine();
      _builder.append("target: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("in(5, set(5,5))");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("Rule name (permit ");
      _builder_1.newLine();
      _builder_1.append("target: ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("in(5, set(5,true))");
      _builder_1.newLine();
      _builder_1.append(")");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _set = Facpl2Package.eINSTANCE.getSet();
      this._validationTestHelper.assertError(model, _set, 
        null, 
        "set elements have to be of the same type");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("Rule name (permit ");
      _builder_2.newLine();
      _builder_2.append("target: ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("in(set(5), set(5,10))");
      _builder_2.newLine();
      _builder_2.append(")");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("Rule name (permit ");
      _builder_3.newLine();
      _builder_3.append("target: ");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("in(cat/id, set(5,10))");
      _builder_3.newLine();
      _builder_3.append(")");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFunctionEqual_Ext() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("Rule name (permit ");
      _builder.newLine();
      _builder.append("target: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("equal(5, n/id)");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("Rule name (permit target: equal(5, n/id))");
      _builder_1.newLine();
      _builder_1.append("Rule name1 (permit target: equal(true, n/id))");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _function = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function, 
        null, 
        "Expression cannot be typed");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDeclaredFunction() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("dec-fun Bool F_Name (String)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("Rule name (permit target: F_Name(5))");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      EClass _declaredFunction = Facpl2Package.eINSTANCE.getDeclaredFunction();
      this._validationTestHelper.assertError(model, _declaredFunction, 
        null, 
        "Type mismatch: expected (String) but was (Int)");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("dec-fun Bool F_Name (String, Bool)");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("Rule name (permit target: F_Name(\"5\"))");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _declaredFunction_1 = Facpl2Package.eINSTANCE.getDeclaredFunction();
      this._validationTestHelper.assertError(model, _declaredFunction_1, 
        null, 
        "Invalid number of arguments");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("dec-fun Bool F_Name (String, Bool)");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("Rule name (permit target: F_Name(\"foo\",n/id))");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("dec-fun Bool F_Name (String, Bool)");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("Rule name (permit target: F_Name(n/id1,n/id))");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("dec-fun Bool F_Name (String, Bool)");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("PolicySet pSet {deny-unless-permit ");
      _builder_4.newLine();
      _builder_4.append("policies:");
      _builder_4.newLine();
      _builder_4.append("Rule name (permit target: F_Name(n/id,n/id))");
      _builder_4.newLine();
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      EClass _declaredFunction_2 = Facpl2Package.eINSTANCE.getDeclaredFunction();
      this._validationTestHelper.assertError(model, _declaredFunction_2, 
        null, 
        "Type mismatch: type for argument \'n/id\' cannot be inferred");
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("dec-fun Bool F_Name (String, Bool)");
      _builder_5.newLine();
      _builder_5.newLine();
      _builder_5.append("PolicySet pSet {deny-unless-permit ");
      _builder_5.newLine();
      _builder_5.append("policies:");
      _builder_5.newLine();
      _builder_5.append("Rule name (permit target: equal(5,n/id) && F_Name(n/string,n/id))");
      _builder_5.newLine();
      _builder_5.append("}");
      Facpl _parse_4 = this._parseHelper.parse(_builder_5);
      model = _parse_4;
      EClass _declaredFunction_3 = Facpl2Package.eINSTANCE.getDeclaredFunction();
      this._validationTestHelper.assertError(model, _declaredFunction_3, 
        null, 
        "Type mismatch: type for argument \'n/id\' cannot be inferred");
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dec-fun Bool F_Name (String, Int)");
      _builder_6.newLine();
      _builder_6.newLine();
      _builder_6.append("dec-fun Int F (Int, Int)");
      _builder_6.newLine();
      _builder_6.newLine();
      _builder_6.append("PolicySet pSet {deny-unless-permit ");
      _builder_6.newLine();
      _builder_6.append("policies:");
      _builder_6.newLine();
      _builder_6.append("Rule name (permit target: equal(5,n/id) && F_Name(n/string,F(5, n/id)))");
      _builder_6.newLine();
      _builder_6.append("}");
      Facpl _parse_5 = this._parseHelper.parse(_builder_6);
      model = _parse_5;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("dec-fun Bool F_Name (String, Double)");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append("dec-fun Int F (Int, Int)");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append("PolicySet pSet {deny-unless-permit ");
      _builder_7.newLine();
      _builder_7.append("policies:");
      _builder_7.newLine();
      _builder_7.append("Rule name (permit target: equal(5,n/id) && F_Name(n/string,F(5, n/id)))");
      _builder_7.newLine();
      _builder_7.append("}");
      Facpl _parse_6 = this._parseHelper.parse(_builder_7);
      model = _parse_6;
      EClass _declaredFunction_4 = Facpl2Package.eINSTANCE.getDeclaredFunction();
      this._validationTestHelper.assertError(model, _declaredFunction_4, 
        null, 
        "Type mismatch: expected (String,Double) but was (String,Int)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testsetFunDecl() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("dec-fun Bool F_Name (String, Int) ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("dec-fun Set<Int> F (Int, Int) ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("target: F_Name(sub/id, F(n/id, 5))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Rule r1 (permit)");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      EClass _declaredFunction = Facpl2Package.eINSTANCE.getDeclaredFunction();
      this._validationTestHelper.assertError(model, _declaredFunction, 
        null, 
        "Type mismatch: expected (String,Int) but was (String,set_int)");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("dec-fun Bool F_Name (String, Int) ");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("dec-fun Set<Int> F (Int, Int) ");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("PolicySet Name {deny-unless-permit");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("target: in(sub/id, F(n/id, 5))");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t\t");
      _builder_1.append("Rule r1 (permit)");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("dec-fun Bool F_Name (String, Int) ");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("dec-fun Set<Bool> F (Int, Int) ");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("PolicySet Name {deny-unless-permit");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("target: in(sub/id, F(n/id, 5)) && equal(sub/id, 5)");
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
      EClass _function = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function, 
        null, 
        "Expression cannot be typed");
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
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("dec-fun Bool F_Name (String, Int) ");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("dec-fun Set<Int> F (Int, Int) ");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("PolicySet Name {deny-unless-permit");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("target: in(sub/id, F(n/id, 5))");
      _builder_4.newLine();
      _builder_4.append("\t\t\t\t");
      _builder_4.append("policies: ");
      _builder_4.newLine();
      _builder_4.append("\t\t\t\t\t");
      _builder_4.append("Rule r1 (permit)");
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDateTime() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Rule r1 (permit target: equal(08:00:00, 09:00:00))");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet Name {deny-unless-permit");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("Rule r1 (permit target: greater-than(08:00:00, 09:00:00))");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet Name {deny-unless-permit");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("Rule r1 (permit target: greater-than(sys/date, 09:00:00))");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet Name {deny-unless-permit");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("policies: ");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("Rule r1 (permit target: greater-than(2015/10/12, 09:00:00))");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("PolicySet Name {deny-unless-permit");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("policies: ");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("Rule r1 (permit target: greater-than(2015/10/12, n/id))");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("Rule r2 (deny target: equal(true, n/id)");
      _builder_4.newLine();
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      EClass _function = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function, 
        null, 
        "Expression cannot be typed");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkDateTime2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("Rule time ( permit ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("target: greater-than-or-equal ( 01:00:00 , environment / time ) || less-than ( 06:00:00 , environment / time )\t\t\t");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet Name {deny-unless-permit");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("Rule time ( permit ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("target: greater-than-or-equal ( 01:00:00 , n/id ) || less-than ( 06:00:00 , environment / time )\t\t\t");
      _builder_1.newLine();
      _builder_1.append(")");
      _builder_1.newLine();
      _builder_1.append("Rule time2 (permit target: equal(n/id, 2015/12/12))");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void declaredFunctionDate() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("dec-fun Bool F (DateTime, DateTime)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Rule r1 (permit target: F(08:00:00, 09:00:00))");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("dec-fun Bool F (DateTime, DateTime)");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("PolicySet Name {deny-unless-permit");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("Rule r1 (permit target: F(sys/env, 09:00:00))");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("dec-fun Int F (DateTime, DateTime)");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("PolicySet Name {deny-unless-permit");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("Rule r1 (permit target: F(sys/env, 09:00:00))");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      EClass _rule = Facpl2Package.eINSTANCE.getRule();
      this._validationTestHelper.assertWarning(model, _rule, 
        null, 
        "Target Expression evaluates to a not-boolean value. This element evaluates to indeterminate");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("dec-fun Bool F (DateTime, DateTime)");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("PolicySet Name {deny-unless-permit");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("policies: ");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("Rule r1 (permit target: F(sys/env, 09:00:00) && equal(sys/env, true))");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      EClass _declaredFunction = Facpl2Package.eINSTANCE.getDeclaredFunction();
      this._validationTestHelper.assertError(model, _declaredFunction, 
        null, 
        "Type mismatch: type for argument \'sys/env\' cannot be inferred");
      EClass _function = Facpl2Package.eINSTANCE.getFunction();
      this._validationTestHelper.assertError(model, _function, 
        null, 
        "Expression cannot be typed");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("dec-fun Bool F (DateTime, DateTime)");
      _builder_4.newLine();
      _builder_4.append("dec-fun DateTime F2 (Int, Int)");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("PolicySet Name {deny-unless-permit");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("policies: ");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("Rule r1 (permit target: F(F2(5,sys/time), 09:00:00) && equal(sys/env, true))");
      _builder_4.newLine();
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void intFun() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule r1 (permit target: addition(cat/id,cat1/id))");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      EClass _rule = Facpl2Package.eINSTANCE.getRule();
      this._validationTestHelper.assertWarning(model, _rule, 
        null, 
        "Target Expression evaluates to a not-boolean value. This element evaluates to indeterminate");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void oblFun() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule r1 (permit target: true");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("obl: [M log(5,6.6,false, cat/id,\"prova\")])");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
