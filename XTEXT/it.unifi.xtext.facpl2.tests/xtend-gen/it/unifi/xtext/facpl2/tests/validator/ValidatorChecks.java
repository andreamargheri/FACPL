package it.unifi.xtext.facpl2.tests.validator;

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
public class ValidatorChecks {
  @Inject
  @Extension
  private ParseHelper<Facpl> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testPolicyNames() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pSet {deny-unless-permit ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule name (permit )");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule name (deny)");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      EClass _rule = Facpl2Package.eINSTANCE.getRule();
      this._validationTestHelper.assertError(model, _rule, 
        null, 
        "Duplicate policy name \'name\'");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule pSet (permit )");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule name (deny)");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _rule_1 = Facpl2Package.eINSTANCE.getRule();
      this._validationTestHelper.assertError(model, _rule_1, 
        null, 
        "Duplicate policy name \'pSet\'");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Rule r1 (permit )");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Rule r2 (deny)");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies: ");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("Rule r1 (permit )");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("Rule r2 (deny)");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("PolicySet r1 {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies: ");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("Rule r2 (permit)");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      EClass _rule_2 = Facpl2Package.eINSTANCE.getRule();
      this._validationTestHelper.assertError(model, _rule_2, 
        null, 
        "Duplicate policy name \'r2\'");
      EClass _policySet = Facpl2Package.eINSTANCE.getPolicySet();
      this._validationTestHelper.assertError(model, _policySet, 
        null, 
        "Duplicate policy name \'r1\'");
      EClass _rule_3 = Facpl2Package.eINSTANCE.getRule();
      this._validationTestHelper.assertError(model, _rule_3, 
        null, 
        "Duplicate policy name \'r1\'");
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
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRequests() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Request:{ Name");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("(subject/profile-id , \"S\")");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Request:{ Name");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("(subject/profile-id , \"S\")");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("Request:{ Name");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("(subject/profile-id , \"S\")");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _request = Facpl2Package.eINSTANCE.getRequest();
      this._validationTestHelper.assertError(model, _request, 
        null, 
        "Duplicate request name \'Name\'");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Request:{ Name");
      _builder_2.newLine();
      _builder_2.append("\t\t\t");
      _builder_2.append("(subject/profile-id , \"S\", 5)");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("}");
      _builder_2.newLine();
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      EClass _attributeReq = Facpl2Package.eINSTANCE.getAttributeReq();
      this._validationTestHelper.assertError(model, _attributeReq, 
        null, 
        "Type mismatch: all set elements must be of the same type");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Request:{ Name");
      _builder_3.newLine();
      _builder_3.append("\t\t\t");
      _builder_3.append("(subject/profile-id , n/id)");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("}");
      _builder_3.newLine();
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      EClass _attributeReq_1 = Facpl2Package.eINSTANCE.getAttributeReq();
      this._validationTestHelper.assertError(model, _attributeReq_1, 
        null, 
        "Type mismatch: request attribute cannot be names");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Request:{ Name");
      _builder_4.newLine();
      _builder_4.append("\t\t\t");
      _builder_4.append("(subject/profile-id , \"S\",n/id)");
      _builder_4.newLine();
      _builder_4.append("\t\t");
      _builder_4.append("}");
      _builder_4.newLine();
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      EClass _attributeReq_2 = Facpl2Package.eINSTANCE.getAttributeReq();
      this._validationTestHelper.assertError(model, _attributeReq_2, 
        null, 
        "Type mismatch: request attribute cannot be names");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDate() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {deny-unless-permit");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Rule r1 (permit target: greater-than(20/12/2015, 09:00:00))");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      EClass _dateLiteral = Facpl2Package.eINSTANCE.getDateLiteral();
      this._validationTestHelper.assertError(model, _dateLiteral, 
        null, 
        "Error date value. Must be yyyy/MM/dd");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet Name {deny-unless-permit");
      _builder_1.newLine();
      _builder_1.append(" \t\t\t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append(" \t\t\t\t");
      _builder_1.append("Rule r1 (permit target: greater-than(2015/12/12, 27:00:00))");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _timeLiteral = Facpl2Package.eINSTANCE.getTimeLiteral();
      this._validationTestHelper.assertError(model, _timeLiteral, 
        null, 
        "Error time value. Must be HH:mm:ss");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet Name {deny-unless-permit");
      _builder_2.newLine();
      _builder_2.append(" \t\t\t");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append(" \t\t\t\t");
      _builder_2.append("Rule r1 (permit target: greater-than(2015/14/12, 23:60:00))");
      _builder_2.newLine();
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      EClass _timeLiteral_1 = Facpl2Package.eINSTANCE.getTimeLiteral();
      this._validationTestHelper.assertError(model, _timeLiteral_1, 
        null, 
        "Error time value. Must be HH:mm:ss");
      EClass _dateLiteral_1 = Facpl2Package.eINSTANCE.getDateLiteral();
      this._validationTestHelper.assertError(model, _dateLiteral_1, 
        null, 
        "Error date value. Must be yyyy/MM/dd");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet Name {permit-overrides ");
      _builder_3.newLine();
      _builder_3.append("policies: ");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("Rule r1 (permit target: equal(cat/id, 2005/43/43))");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      EClass _dateLiteral_2 = Facpl2Package.eINSTANCE.getDateLiteral();
      this._validationTestHelper.assertError(model, _dateLiteral_2, 
        null, 
        "Error date value. Must be yyyy/MM/dd");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSet() {
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
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pSet {deny-unless-permit ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule name (permit target: in(5,set(5,true))) ");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      EClass _set = Facpl2Package.eINSTANCE.getSet();
      this._validationTestHelper.assertError(model, _set, 
        null, 
        "Set elements have to be of the same type");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pSet {deny-unless-permit ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Rule name (permit target: in(5,set(5,n/id))) ");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      EClass _set_1 = Facpl2Package.eINSTANCE.getSet();
      this._validationTestHelper.assertError(model, _set_1, 
        null, 
        "Sets cannot contain attribute name");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pSet {deny-unless-permit ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("Rule name (permit target: in(5,set(5,set(true)))) ");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      EClass _set_2 = Facpl2Package.eINSTANCE.getSet();
      this._validationTestHelper.assertError(model, _set_2, 
        null, 
        "Sets cannot contain other sets");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWebExamples() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet firstPolicy { permit-overrides");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("target: equal ( \"4567-1\" , resource / id ) policies:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule Rule1 ( permit target: equal ( \"John\" , subject / id ) && equal ( \"read\" , action / id ) )");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule RuleDeny ( deny )");
      _builder.newLine();
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet permitAll { deny-overrides");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule Rule1 ( permit )");
      _builder_1.newLine();
      _builder_1.append("}");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet firstPolicy_denyOverrides {deny-overrides");
      _builder_2.newLine();
      _builder_2.append("\t ");
      _builder_2.append("target: equal(\"4567-1\",resource/id)");
      _builder_2.newLine();
      _builder_2.append("\t ");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("Rule RuleCondition_P (permit target: equal(\"John\",subject/id)");
      _builder_2.newLine();
      _builder_2.append("\t\t\t");
      _builder_2.append("&&  in(action/id, set(\"read\",\"seek\")) ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append(")");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("Rule RuleCondition_D ( deny");
      _builder_2.newLine();
      _builder_2.append("\t\t\t");
      _builder_2.append("target: in(action/id, set(\"write\",\"checkout\"))");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append(")  ");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet polSet { first-applicable");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("PolicySet first { deny-overrides");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("target: equal ( \"4567-1\" , resource / id ) policies:");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("Rule Rule_DenyAll ( deny )");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("PolicySet second { permit-overrides");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("Rule rule1 ( permit )");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.append("}");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      model = _parse_2;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("PolicySet polSet { only-one-applicable");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("policies: ");
      _builder_4.newLine();
      _builder_4.append("\t ");
      _builder_4.append("PolicySet first {deny-overrides");
      _builder_4.newLine();
      _builder_4.append("\t\t ");
      _builder_4.append("target: equal(\"4567-1\",resource/id)");
      _builder_4.newLine();
      _builder_4.append("\t\t ");
      _builder_4.append("policies:  ");
      _builder_4.newLine();
      _builder_4.append("\t\t\t");
      _builder_4.append("Rule Rule_DenyAll (deny)  ");
      _builder_4.newLine();
      _builder_4.append("\t  ");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.append("\t  ");
      _builder_4.append("PolicySet second {permit-overrides ");
      _builder_4.newLine();
      _builder_4.append("\t  \t");
      _builder_4.append("policies: Rule rule1 (permit)");
      _builder_4.newLine();
      _builder_4.append("\t  ");
      _builder_4.append("}");
      _builder_4.newLine();
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("PolicySet obligation_1 { deny-overrides");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("target: equal ( \"4567-1\" , resource / id ) policies:");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("Rule RuleP ( permit target: equal ( \"John\" , subject / id ) && in ( action / id , set( \"read\" , \"seek\" ) ) ");
      _builder_5.newLine();
      _builder_5.append("\t\t");
      _builder_5.newLine();
      _builder_5.append("\t\t");
      _builder_5.append("obl:");
      _builder_5.newLine();
      _builder_5.append("\t\t");
      _builder_5.append("[  M action1 ( subject / name ) ]");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append(")");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("Rule RuleD ( deny target: in ( action / id , set( \"write\" , \"checkout\" ) ) ");
      _builder_5.newLine();
      _builder_5.append("\t\t");
      _builder_5.append("obl:");
      _builder_5.newLine();
      _builder_5.append("\t\t");
      _builder_5.append("[  M action2 ( subject / name ) ]");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append(")");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("obl-p:");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("[ M log ( \"Resource accessed: \" , resource / id ) ]");
      _builder_5.newLine();
      _builder_5.append("}");
      Facpl _parse_4 = this._parseHelper.parse(_builder_5);
      model = _parse_4;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("PolicySet polSet { permit-overrides");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("policies:");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("PolicySet obligation_1 { deny-overrides");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("target: equal ( \"4567-1\" , resource / id ) policies:");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("Rule RuleP ( permit target: equal ( \"John\" , subject / id ) && in ( action / id , set( \"read\" , \"seek\" ) ) ");
      _builder_6.newLine();
      _builder_6.append("\t\t\t");
      _builder_6.append("obl:");
      _builder_6.newLine();
      _builder_6.append("\t\t\t");
      _builder_6.append("[ M action1 ( subject / name ) ]");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append(")");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("Rule RuleD ( deny target: equal ( \"Mark\" , subject / id ) && in ( action / id , set( \"write\" , \"checkout\" ) ) ");
      _builder_6.newLine();
      _builder_6.append("\t\t\t");
      _builder_6.append("obl:");
      _builder_6.newLine();
      _builder_6.append("\t\t\t");
      _builder_6.append("[ M action2 ( subject / name ) ]");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append(")");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("}");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("PolicySet obligation_2 { permit-overrides");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("policies:");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("Rule rule1 ( deny )");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("obl-d:");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("[ M log ( \"Subject: \" , subject / id , subject / name ) ]");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("}");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("obl-p:");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("[ M log ( \"Resource accessed: \" , resource / id ) ]");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("obl-d:");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("[ M log ( \"Resource requested: \" , resource / id ) ]");
      _builder_6.newLine();
      _builder_6.append("}");
      Facpl _parse_5 = this._parseHelper.parse(_builder_6);
      model = _parse_5;
      this._validationTestHelper.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
