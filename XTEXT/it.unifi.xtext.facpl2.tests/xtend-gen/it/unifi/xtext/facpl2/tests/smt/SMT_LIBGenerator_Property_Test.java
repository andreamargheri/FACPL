package it.unifi.xtext.facpl2.tests.smt;

import com.google.inject.Inject;
import it.unifi.xtext.facpl.Facpl2InjectorProvider;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator;
import it.unifi.xtext.facpl.generator.util.AuthorisationProperty;
import it.unifi.xtext.facpl.generator.util.ConstraintConstant;
import it.unifi.xtext.facpl.generator.util.Decision;
import it.unifi.xtext.facpl.generator.util.PolicyConstant;
import it.unifi.xtext.facpl.generator.util.StructuralProperty;
import it.unifi.xtext.facpl.validation.FacplType;
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference;
import java.io.PrintWriter;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
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
public class SMT_LIBGenerator_Property_Test extends AbstractXtextTests {
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
   * Check well-typed request wrt considered policy
   */
  @Test
  public void checkTypedRequest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("  \t\t\t");
      _builder.append("Rule r1 (permit target: equal(action/id,\"read\") || equal(suject/id,\"Andrea\"))");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Request:{ Req_Name ( action/id , 5 ) }");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      EList<Request> _requests = _parse.getRequests();
      Request request = _requests.get(0);
      this._validationTestHelper.assertNoErrors(request);
      FacplTypeInference tInf = new FacplTypeInference();
      tInf.doSwitch(model);
      FacplType type = tInf.doSwitch(request);
      Assert.assertEquals(type, FacplType.ERR);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Request:{ Req_Name ( action/id , \"write\" ) }");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      EList<Request> _requests_1 = _parse_1.getRequests();
      Request _get = _requests_1.get(0);
      request = _get;
      this._validationTestHelper.assertNoErrors(request);
      FacplTypeInference _facplTypeInference = new FacplTypeInference();
      tInf = _facplTypeInference;
      tInf.doSwitch(model);
      FacplType _doSwitch = tInf.doSwitch(request);
      type = _doSwitch;
      Assert.assertEquals(type, FacplType.TYPED);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Request:{ Req_Name ( action/id , \"write\", \"read\" ) }");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      EList<Request> _requests_2 = _parse_2.getRequests();
      Request _get_1 = _requests_2.get(0);
      request = _get_1;
      this._validationTestHelper.assertNoErrors(request);
      FacplTypeInference _facplTypeInference_1 = new FacplTypeInference();
      tInf = _facplTypeInference_1;
      tInf.doSwitch(model);
      FacplType _doSwitch_1 = tInf.doSwitch(request);
      type = _doSwitch_1;
      Assert.assertEquals(type, FacplType.ERR);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Request:{ Req_Name ( action/id , \"write\", 5 ) }");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      EList<Request> _requests_3 = _parse_3.getRequests();
      Request _get_2 = _requests_3.get(0);
      request = _get_2;
      FacplTypeInference _facplTypeInference_2 = new FacplTypeInference();
      tInf = _facplTypeInference_2;
      tInf.doSwitch(model);
      FacplType _doSwitch_2 = tInf.doSwitch(request);
      type = _doSwitch_2;
      Assert.assertEquals(type, FacplType.ERR);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Check if string constants are taken from request
   */
  @Test
  public void checkStringConst() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("  \t\t\t");
      _builder.append("Rule r1 (permit target: in(action/id,\"read\") || equal(suject/id,\"Andrea\"))");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Request:{ Req_Name ( action/id ,\"write\" ) }");
      Facpl _parse = this._parseHelper.parse(_builder_1);
      EList<Request> _requests = _parse.getRequests();
      Request request = _requests.get(0);
      this._validationTestHelper.assertNoErrors(request);
      PolicyConstant tConst = new PolicyConstant();
      tConst.doSwitch(model);
      Boolean b = tConst.doSwitch(request);
      Assert.assertEquals(b, Boolean.valueOf(true));
      HashMap<String, ConstraintConstant> _constants = tConst.getConstants();
      boolean _containsKey = _constants.containsKey("write");
      Assert.assertEquals(Boolean.valueOf(_containsKey), Boolean.valueOf(true));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet Name {permit-overrides ");
      _builder_2.newLine();
      _builder_2.append("  \t\t");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("  \t\t\t");
      _builder_2.append("Rule r1 (permit target: in(\"read\", action/id) || equal(suject/id,\"Andrea\"))");
      _builder_2.newLine();
      _builder_2.append("  \t\t");
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Request:{ Req_Name ( action/id ,\"write\", \"delete\" ) }");
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      EList<Request> _requests_1 = _parse_2.getRequests();
      Request _get = _requests_1.get(0);
      request = _get;
      this._validationTestHelper.assertNoErrors(request);
      PolicyConstant _policyConstant = new PolicyConstant();
      tConst = _policyConstant;
      tConst.doSwitch(model);
      Boolean _doSwitch = tConst.doSwitch(request);
      b = _doSwitch;
      Assert.assertEquals(b, Boolean.valueOf(true));
      HashMap<String, ConstraintConstant> _constants_1 = tConst.getConstants();
      boolean _containsKey_1 = _constants_1.containsKey("write");
      Assert.assertEquals(Boolean.valueOf(_containsKey_1), Boolean.valueOf(true));
      HashMap<String, ConstraintConstant> _constants_2 = tConst.getConstants();
      boolean _containsKey_2 = _constants_2.containsKey("delete");
      Assert.assertEquals(Boolean.valueOf(_containsKey_2), Boolean.valueOf(true));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Generation of SMT-LIB code for Properties
   */
  @Test
  public void genSecProperty_SECURITY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("  \t\t\t");
      _builder.append("Rule r1 (permit target: equal(action/id,\"read\") || equal(subject/id,\"Andrea\"))");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Request:{ Req_Name ( action/id , \"read\" ) } ");
      _builder_1.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_1);
      EList<Request> _requests = _parse.getRequests();
      Request request = _requests.get(0);
      this._validationTestHelper.assertNoErrors(request);
      String str = this._sMT_LIBGenerator.doGenerateAuthorisation_Property_Code(model, "Name", request, Decision.PERMIT, AuthorisationProperty.EVAL);
      boolean _contains = str.contains("(assert (miss n_subject/id))");
      Assert.assertEquals(Boolean.valueOf(_contains), Boolean.valueOf(true));
      boolean _contains_1 = str.contains("(assert cns_Name_permit)");
      Assert.assertEquals(Boolean.valueOf(_contains_1), Boolean.valueOf(true));
      PrintWriter writer = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_Eval.smt2", "UTF-8");
      writer.println(str);
      writer.close();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet Name {permit-overrides ");
      _builder_2.newLine();
      _builder_2.append("  \t\t");
      _builder_2.append("policies: ");
      _builder_2.newLine();
      _builder_2.append("  \t\t\t");
      _builder_2.append("Rule r1 (permit target: equal(action/id,\"read\") && equal(subject/id,\"Andrea\"))");
      _builder_2.newLine();
      _builder_2.append("  \t\t");
      _builder_2.append("}");
      Facpl _parse_1 = this._parseHelper.parse(_builder_2);
      model = _parse_1;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Request:{ Req_Name ( action/id , \"read\" ) } ");
      _builder_3.newLine();
      Facpl _parse_2 = this._parseHelper.parse(_builder_3);
      EList<Request> _requests_1 = _parse_2.getRequests();
      Request _get = _requests_1.get(0);
      request = _get;
      this._validationTestHelper.assertNoErrors(request);
      String _doGenerateAuthorisation_Property_Code = this._sMT_LIBGenerator.doGenerateAuthorisation_Property_Code(model, "Name", request, Decision.NOT_APPLICABLE, AuthorisationProperty.MAY);
      str = _doGenerateAuthorisation_Property_Code;
      boolean _contains_2 = str.contains("(assert (miss n_subject/id))");
      Assert.assertEquals(Boolean.valueOf(_contains_2), Boolean.valueOf(false));
      boolean _contains_3 = str.contains("(assert cns_Name_notApp)");
      Assert.assertEquals(Boolean.valueOf(_contains_3), Boolean.valueOf(true));
      PrintWriter _printWriter = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_May_NotApp.smt2", "UTF-8");
      writer = _printWriter;
      writer.println(str);
      writer.close();
      String _doGenerateAuthorisation_Property_Code_1 = this._sMT_LIBGenerator.doGenerateAuthorisation_Property_Code(model, "Name", request, Decision.INDETERMINATE, AuthorisationProperty.MAY);
      str = _doGenerateAuthorisation_Property_Code_1;
      boolean _contains_4 = str.contains("(assert (miss n_subject/id))");
      Assert.assertEquals(Boolean.valueOf(_contains_4), Boolean.valueOf(false));
      boolean _contains_5 = str.contains("(assert cns_Name_indet)");
      Assert.assertEquals(Boolean.valueOf(_contains_5), Boolean.valueOf(true));
      PrintWriter _printWriter_1 = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_May_Indet.smt2", "UTF-8");
      writer = _printWriter_1;
      writer.println(str);
      writer.close();
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("PolicySet Name {permit-overrides ");
      _builder_4.newLine();
      _builder_4.append("  \t\t");
      _builder_4.append("policies: ");
      _builder_4.newLine();
      _builder_4.append("  \t\t\t");
      _builder_4.append("Rule r1 (permit target: equal(action/id,\"read\") || equal(subject/id,\"Andrea\"))");
      _builder_4.newLine();
      _builder_4.append("  \t\t");
      _builder_4.append("}");
      Facpl _parse_3 = this._parseHelper.parse(_builder_4);
      model = _parse_3;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("Request:{ Req_Name ( action/id , \"read\" ) } ");
      _builder_5.newLine();
      Facpl _parse_4 = this._parseHelper.parse(_builder_5);
      EList<Request> _requests_2 = _parse_4.getRequests();
      Request _get_1 = _requests_2.get(0);
      request = _get_1;
      this._validationTestHelper.assertNoErrors(request);
      String _doGenerateAuthorisation_Property_Code_2 = this._sMT_LIBGenerator.doGenerateAuthorisation_Property_Code(model, "Name", request, Decision.NOT_APPLICABLE, AuthorisationProperty.MUST);
      str = _doGenerateAuthorisation_Property_Code_2;
      boolean _contains_6 = str.contains("(assert (miss n_subject/id))");
      Assert.assertEquals(Boolean.valueOf(_contains_6), Boolean.valueOf(false));
      boolean _contains_7 = str.contains("(assert (not cns_Name_notApp))");
      Assert.assertEquals(Boolean.valueOf(_contains_7), Boolean.valueOf(true));
      PrintWriter _printWriter_2 = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_Must1.smt2", "UTF-8");
      writer = _printWriter_2;
      writer.println(str);
      writer.close();
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("PolicySet Name {permit-overrides ");
      _builder_6.newLine();
      _builder_6.append("  \t\t");
      _builder_6.append("policies: ");
      _builder_6.newLine();
      _builder_6.append("  \t\t\t");
      _builder_6.append("Rule r1 (permit target: equal(action/id,\"read\") || equal(subject/id,\"Andrea\"))");
      _builder_6.newLine();
      _builder_6.append("  \t\t");
      _builder_6.append("}");
      Facpl _parse_5 = this._parseHelper.parse(_builder_6);
      model = _parse_5;
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("Request:{ Req_Name ( action/id , \"read\" ) (subject/id, \"Franco\") } ");
      _builder_7.newLine();
      Facpl _parse_6 = this._parseHelper.parse(_builder_7);
      EList<Request> _requests_3 = _parse_6.getRequests();
      Request _get_2 = _requests_3.get(0);
      request = _get_2;
      this._validationTestHelper.assertNoErrors(request);
      String _doGenerateAuthorisation_Property_Code_3 = this._sMT_LIBGenerator.doGenerateAuthorisation_Property_Code(model, "Name", request, Decision.PERMIT, AuthorisationProperty.MUST);
      str = _doGenerateAuthorisation_Property_Code_3;
      boolean _contains_8 = str.contains("(assert (miss n_subject/id))");
      Assert.assertEquals(Boolean.valueOf(_contains_8), Boolean.valueOf(false));
      boolean _contains_9 = str.contains("(assert (not cns_Name_permit))");
      Assert.assertEquals(Boolean.valueOf(_contains_9), Boolean.valueOf(true));
      PrintWriter _printWriter_3 = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_Must2.smt2", "UTF-8");
      writer = _printWriter_3;
      writer.println(str);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Generation of SMT-LIB code for Properties with Set declared in the request
   */
  @Test
  public void genSecProperty_SECURITY_Set() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("  \t\t\t");
      _builder.append("Rule r1 (permit target: in(\"read\", action/id) || equal(subject/id,\"Andrea\"))");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Request:{ Req_Name ( action/id , \"read\", \"write\" ) } ");
      _builder_1.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_1);
      EList<Request> _requests = _parse.getRequests();
      Request request = _requests.get(0);
      this._validationTestHelper.assertNoErrors(request);
      String str = this._sMT_LIBGenerator.doGenerateAuthorisation_Property_Code(model, "Name", request, Decision.PERMIT, AuthorisationProperty.EVAL);
      boolean _contains = str.contains("(assert (miss n_subject/id))");
      Assert.assertEquals(Boolean.valueOf(_contains), Boolean.valueOf(true));
      boolean _contains_1 = str.contains("(assert cns_Name_permit)");
      Assert.assertEquals(Boolean.valueOf(_contains_1), Boolean.valueOf(true));
      boolean _contains_2 = str.contains("(assert (= (select (val n_action/id) 0) s_read))");
      Assert.assertEquals(Boolean.valueOf(_contains_2), Boolean.valueOf(true));
      boolean _contains_3 = str.contains("(assert (= (select (val n_action/id) 1) s_write))");
      Assert.assertEquals(Boolean.valueOf(_contains_3), Boolean.valueOf(true));
      PrintWriter writer = new PrintWriter("SMT_LIB_gen/SecurityProperty/genSec_Prop_Eval_Set.smt2", "UTF-8");
      writer.println(str);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkAddAttribute() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("  \t\t\t");
      _builder.append("Rule r1 (permit target: equal(action/id,\"read\") || equal(subject/id,\"Andrea\"))");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Request:{ Req_Name ( action/purpose , \"CLEAN\" ) } ");
      _builder_1.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_1);
      EList<Request> _requests = _parse.getRequests();
      Request request = _requests.get(0);
      this._validationTestHelper.assertNoErrors(request);
      String str = this._sMT_LIBGenerator.doGenerateAuthorisation_Property_Code(model, "Name", request, Decision.PERMIT, AuthorisationProperty.EVAL);
      boolean _contains = str.contains("(declare-const n_action/purpose (TValue String))");
      Assert.assertEquals(Boolean.valueOf(_contains), Boolean.valueOf(true));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Generation of SMT-LIB code for Complete Structural Property
   */
  @Test
  public void genStructProperty_Complete() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("  \t\t\t");
      _builder.append("Rule r1 (permit target: in(\"read\", action/id) || equal(subject/id,\"Andrea\"))");
      _builder.newLine();
      _builder.append("  \t\t");
      _builder.append("}");
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String str = this._sMT_LIBGenerator.doGenerateComplete_Property_Code(model, "Name");
      boolean _contains = str.contains("(assert cns_Name_notApp)");
      Assert.assertEquals(Boolean.valueOf(_contains), Boolean.valueOf(true));
      PrintWriter writer = new PrintWriter("SMT_LIB_gen/StructuralProperty/genStruct_Complete1.smt2", "UTF-8");
      writer.println(str);
      writer.close();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet Name {permit-overrides ");
      _builder_1.newLine();
      _builder_1.append("  \t\t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("  \t\t\t");
      _builder_1.append("Rule r1 (permit target: in(\"read\", action/id) || equal(subject/id,\"Andrea\"))");
      _builder_1.newLine();
      _builder_1.append("  \t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  \t\t");
      _builder_1.append("PolicySet Name1 {permit-overrides ");
      _builder_1.newLine();
      _builder_1.append("  \t\t  \t");
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("  \t\t  \t\t");
      _builder_1.append("Rule r12 (permit target: in(\"read\", action/id) || equal(subject/id,\"Andrea\"))");
      _builder_1.newLine();
      _builder_1.append("  \t\t ");
      _builder_1.append("}");
      _builder_1.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      String _doGenerateComplete_Property_Code = this._sMT_LIBGenerator.doGenerateComplete_Property_Code(model, "Name1");
      str = _doGenerateComplete_Property_Code;
      boolean _contains_1 = str.contains("(assert cns_Name1_notApp)");
      Assert.assertEquals(Boolean.valueOf(_contains_1), Boolean.valueOf(true));
      PrintWriter _printWriter = new PrintWriter("SMT_LIB_gen/StructuralProperty/genStruct_Complete2.smt2", "UTF-8");
      writer = _printWriter;
      writer.println(str);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Generation of SMT-LIB code for Structural Properties (but Complete)
   */
  @Test
  public void genStructProperties() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet Name {permit-overrides ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule r1 (permit target: equal(\"read\", action/type))");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("PolicySet Name1 {permit-overrides ");
      _builder.newLine();
      _builder.append("policies: ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule r12 (permit target: equal(\"read\", action/id) || equal(subject/id,\"Andrea\"))");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Facpl model = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(model);
      String str = this._sMT_LIBGenerator.doGenerateStructural_Property_Code(model, "Name", "Name1", StructuralProperty.COVER);
      boolean _contains = str.contains("(=> cns_Name_permit cns_Name1_permit)");
      Assert.assertEquals(Boolean.valueOf(_contains), Boolean.valueOf(true));
      PrintWriter writer = new PrintWriter("SMT_LIB_gen/StructuralProperty/genStruct_Coverage1.smt2", "UTF-8");
      writer.println(str);
      writer.close();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet Name {permit-overrides ");
      _builder_1.newLine();
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule r1 (permit target: equal(\"read\", action/type))");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("PolicySet Name1 {permit-overrides ");
      _builder_1.newLine();
      _builder_1.append("policies: ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule r12 (permit target: equal(\"read\", action/id) || equal(subject/id,\"Andrea\"))");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Facpl _parse = this._parseHelper.parse(_builder_1);
      model = _parse;
      this._validationTestHelper.assertNoErrors(model);
      String _doGenerateStructural_Property_Code = this._sMT_LIBGenerator.doGenerateStructural_Property_Code(model, "Name", "Name1", StructuralProperty.DISJOINT);
      str = _doGenerateStructural_Property_Code;
      boolean _contains_1 = str.contains("(and cns_Name_permit cns_Name1_permit)");
      Assert.assertEquals(Boolean.valueOf(_contains_1), Boolean.valueOf(true));
      PrintWriter _printWriter = new PrintWriter("SMT_LIB_gen/StructuralProperty/genStruct_Disjoint1.smt2", "UTF-8");
      writer = _printWriter;
      writer.println(str);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
