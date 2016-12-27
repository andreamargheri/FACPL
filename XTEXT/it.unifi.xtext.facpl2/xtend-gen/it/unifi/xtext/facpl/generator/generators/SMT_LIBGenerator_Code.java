package it.unifi.xtext.facpl.generator.generators;

import com.google.common.base.Objects;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Alg;
import it.unifi.xtext.facpl.facpl2.AlgLiteral;
import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DeclaredFunction;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Effect;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration;
import it.unifi.xtext.facpl.facpl2.IntLiteral;
import it.unifi.xtext.facpl.facpl2.NotExpression;
import it.unifi.xtext.facpl.facpl2.Obligation;
import it.unifi.xtext.facpl.facpl2.OrExpression;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.facpl2.Rule;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TimeLiteral;
import it.unifi.xtext.facpl.facpl2.TypeLiteral;
import it.unifi.xtext.facpl.facpl2.funID;
import it.unifi.xtext.facpl.generator.generators.SMT_LIBGenerator_Functions;
import it.unifi.xtext.facpl.generator.generators.smt.algorithms.SMT_LIBGenerator_DenyOver;
import it.unifi.xtext.facpl.generator.generators.smt.algorithms.SMT_LIBGenerator_DenyUnless;
import it.unifi.xtext.facpl.generator.generators.smt.algorithms.SMT_LIBGenerator_FirstApp;
import it.unifi.xtext.facpl.generator.generators.smt.algorithms.SMT_LIBGenerator_OneApp;
import it.unifi.xtext.facpl.generator.generators.smt.algorithms.SMT_LIBGenerator_PermitOver;
import it.unifi.xtext.facpl.generator.generators.smt.algorithms.SMT_LIBGenerator_PermitUnless;
import it.unifi.xtext.facpl.generator.generators.smt.algorithms.SMT_LIBGenerator_StrongCon;
import it.unifi.xtext.facpl.generator.generators.smt.algorithms.SMT_LIBGenerator_WeakCon;
import it.unifi.xtext.facpl.generator.util.ConstraintConstant;
import it.unifi.xtext.facpl.generator.util.DateUtil;
import it.unifi.xtext.facpl.generator.util.PolicyConstant;
import it.unifi.xtext.facpl.generator.util.SetUtils;
import it.unifi.xtext.facpl.validation.FacplType;
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference;
import it.unifi.xtext.facpl.validation.inference.SubstitutionSet;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class SMT_LIBGenerator_Code {
  protected SubstitutionSet attributes;
  
  protected HashMap<String, ConstraintConstant> constants;
  
  protected HashMap<String, String> sets;
  
  protected LinkedList<String> stringEls;
  
  protected FacplTypeInference tInf;
  
  protected StringBuffer dec_functions;
  
  protected Boolean flagDeclaredFunctions = Boolean.valueOf(false);
  
  /**
   * Initialization method for the SMT-LIB code generation
   * -> Used for structural properties but not for security ones
   */
  public CharSequence initialiseFacplResource(final Facpl resource) throws Exception {
    FacplTypeInference _facplTypeInference = new FacplTypeInference();
    this.tInf = _facplTypeInference;
    EList<FunctionDeclaration> _declarations = resource.getDeclarations();
    boolean _notEquals = (!Objects.equal(_declarations, null));
    if (_notEquals) {
      StringBuffer _stringBuffer = new StringBuffer();
      this.dec_functions = _stringBuffer;
      EList<FunctionDeclaration> _declarations_1 = resource.getDeclarations();
      for (final FunctionDeclaration dec : _declarations_1) {
        {
          String _createDeclFunctionConstr = this.createDeclFunctionConstr(dec);
          String _plus = (_createDeclFunctionConstr + "\n");
          this.dec_functions.append(_plus);
          this.flagDeclaredFunctions = Boolean.valueOf(true);
        }
      }
    }
    FacplType type = this.tInf.doSwitch(resource);
    boolean _equals = type.equals(FacplType.ERR);
    if (_equals) {
      throw new Exception("FACPL code is not well-typed");
    }
    SubstitutionSet _typeAssignments = this.tInf.getTypeAssignments();
    this.attributes = _typeAssignments;
    final PolicyConstant tConst = new PolicyConstant();
    tConst.doSwitch(resource);
    HashMap<String, ConstraintConstant> _constants = tConst.getConstants();
    this.constants = _constants;
    HashMap<String, String> _sets = tConst.getSets();
    this.sets = _sets;
    LinkedList<String> _linkedList = new LinkedList<String>();
    this.stringEls = _linkedList;
    Collection<ConstraintConstant> _values = this.constants.values();
    for (final ConstraintConstant el : _values) {
      FacplType _type = el.getType();
      boolean _equals_1 = _type.equals(FacplType.STRING);
      if (_equals_1) {
        Object _value = el.getValue();
        String _string = _value.toString();
        this.stringEls.add(_string);
      }
    }
    return this.getGeneralDeclarations();
  }
  
  /**
   * Initialization method for the Property evaluation ( it take into account a request)
   */
  public CharSequence initialiseFacplResource_Request(final Facpl resource, final Request request) throws Exception {
    FacplTypeInference _facplTypeInference = new FacplTypeInference();
    this.tInf = _facplTypeInference;
    EList<FunctionDeclaration> _declarations = resource.getDeclarations();
    boolean _notEquals = (!Objects.equal(_declarations, null));
    if (_notEquals) {
      StringBuffer _stringBuffer = new StringBuffer();
      this.dec_functions = _stringBuffer;
      EList<FunctionDeclaration> _declarations_1 = resource.getDeclarations();
      for (final FunctionDeclaration dec : _declarations_1) {
        {
          String _createDeclFunctionConstr = this.createDeclFunctionConstr(dec);
          String _plus = (_createDeclFunctionConstr + "\n");
          this.dec_functions.append(_plus);
          this.flagDeclaredFunctions = Boolean.valueOf(true);
        }
      }
    }
    FacplType type = this.tInf.doSwitch(resource);
    FacplType type1 = this.tInf.doSwitch(request);
    boolean _equals = type.equals(FacplType.ERR);
    if (_equals) {
      throw new Exception("FACPL policy is not well-typed");
    }
    boolean _equals_1 = type1.equals(FacplType.ERR);
    if (_equals_1) {
      throw new Exception("FACPL request is not well-typed with respect to the given Policy");
    }
    SubstitutionSet _typeAssignments = this.tInf.getTypeAssignments();
    this.attributes = _typeAssignments;
    final PolicyConstant tConst = new PolicyConstant();
    tConst.doSwitch(resource);
    tConst.doSwitch(request);
    HashMap<String, ConstraintConstant> _constants = tConst.getConstants();
    this.constants = _constants;
    HashMap<String, String> _sets = tConst.getSets();
    this.sets = _sets;
    LinkedList<String> _linkedList = new LinkedList<String>();
    this.stringEls = _linkedList;
    Collection<ConstraintConstant> _values = this.constants.values();
    for (final ConstraintConstant el : _values) {
      FacplType _type = el.getType();
      boolean _equals_2 = _type.equals(FacplType.STRING);
      if (_equals_2) {
        Object _value = el.getValue();
        String _string = _value.toString();
        this.stringEls.add(_string);
      }
    }
    return this.getGeneralDeclarations();
  }
  
  public CharSequence getGeneralDeclarations() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _datatypeDec = this.getDatatypeDec();
    _builder.append(_datatypeDec, "");
    _builder.newLineIfNotEmpty();
    {
      int _size = this.stringEls.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append(";################### STRING DECLARATIONs #######################");
        _builder.newLine();
        CharSequence _stringDec = this.getStringDec();
        _builder.append(_stringDec, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((this.flagDeclaredFunctions).booleanValue()) {
        _builder.append(";################### FUNCTIONS DECLARED BY POLICY (TO BE IMPLEMENTED) ##################");
        _builder.newLine();
        _builder.append(";#TODO: stub definitions for declared functions");
        _builder.newLine();
        String _string = this.dec_functions.toString();
        _builder.append(_string, "");
        _builder.newLineIfNotEmpty();
        _builder.append(";################### END FUNCTIONS DECLARED BY POLICY ##################");
        _builder.newLine();
      }
    }
    _builder.append(";################### FACPL FUNCTION DECLARATIONs #######################");
    _builder.newLine();
    CharSequence _functionDec = this.getFunctionDec();
    _builder.append(_functionDec, "");
    _builder.newLineIfNotEmpty();
    _builder.append(";################################ END DATATYPEs AND FUNCTIONs DECLARATION #############################");
    _builder.newLine();
    _builder.newLine();
    _builder.append(";################### ATTRIBUTE DECLARATIONs #######################");
    _builder.newLine();
    CharSequence _attributeDec = this.getAttributeDec();
    _builder.append(_attributeDec, "");
    _builder.newLineIfNotEmpty();
    _builder.append(";################### CONSTANTs DECLARATIONs #######################");
    _builder.newLine();
    CharSequence _constantDec = this.getConstantDec();
    _builder.append(_constantDec, "");
    _builder.newLineIfNotEmpty();
    _builder.append(";################################ END ATTRIBUTEs AND CONSTANTs DECLARATION #############################");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * ##############################################
   * General structure of the whole constraint file
   * ##############################################
   */
  public CharSequence createMainConstraint(final FacplPolicy pol) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      {
        if ((pol instanceof PolicySet)) {
          {
            EList<AbstractPolicyIncl> _policies = ((PolicySet)pol).getPolicies();
            for(final AbstractPolicyIncl el : _policies) {
              CharSequence _policyConstr = this.getPolicyConstr(el);
              _builder.append(_policyConstr, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append(";################################ TOP-LEVEL POLICY ");
      String _name = pol.getName();
      _builder.append(_name, "");
      _builder.append(" CONSTRAINTs ###########################");
      _builder.newLineIfNotEmpty();
      _builder.append(";##### Policy Target");
      _builder.newLine();
      {
        Expression _target = pol.getTarget();
        boolean _notEquals = (!Objects.equal(_target, null));
        if (_notEquals) {
          Expression _target_1 = pol.getTarget();
          String _name_1 = pol.getName();
          CharSequence _targetConstr = this.getTargetConstr(_target_1, _name_1);
          _builder.append(_targetConstr, "");
          _builder.newLineIfNotEmpty();
        } else {
          String _name_2 = pol.getName();
          CharSequence _targetConstr_default = this.getTargetConstr_default(_name_2);
          _builder.append(_targetConstr_default, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append(";##### Policy Obligations");
      _builder.newLine();
      {
        if ((pol instanceof PolicySet)) {
          {
            EList<Obligation> _oblp = ((PolicySet)pol).getOblp();
            boolean _notEquals_1 = (!Objects.equal(_oblp, null));
            if (_notEquals_1) {
              EList<Obligation> _oblp_1 = ((PolicySet)pol).getOblp();
              String _name_3 = ((PolicySet)pol).getName();
              String _obligationConstr_Eff = this.getObligationConstr_Eff(_oblp_1, _name_3, Effect.PERMIT);
              _builder.append(_obligationConstr_Eff, "");
              _builder.newLineIfNotEmpty();
            } else {
              String _name_4 = ((PolicySet)pol).getName();
              CharSequence _obligationsConstr_Default = this.getObligationsConstr_Default(_name_4, Effect.PERMIT);
              _builder.append(_obligationsConstr_Default, "");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            EList<Obligation> _obld = ((PolicySet)pol).getObld();
            boolean _notEquals_2 = (!Objects.equal(_obld, null));
            if (_notEquals_2) {
              EList<Obligation> _obld_1 = ((PolicySet)pol).getObld();
              String _name_5 = ((PolicySet)pol).getName();
              String _obligationConstr_Eff_1 = this.getObligationConstr_Eff(_obld_1, _name_5, Effect.DENY);
              _builder.append(_obligationConstr_Eff_1, "");
              _builder.newLineIfNotEmpty();
            } else {
              String _name_6 = ((PolicySet)pol).getName();
              CharSequence _obligationsConstr_Default_1 = this.getObligationsConstr_Default(_name_6, Effect.DENY);
              _builder.append(_obligationsConstr_Default_1, "");
              _builder.newLineIfNotEmpty();
            }
          }
        } else {
          EList<Obligation> _obl = ((Rule) pol).getObl();
          String _name_7 = pol.getName();
          Effect _effect = ((Rule) pol).getEffect();
          String _obligationConstr_Eff_2 = this.getObligationConstr_Eff(_obl, _name_7, _effect);
          _builder.append(_obligationConstr_Eff_2, "");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        if ((pol instanceof PolicySet)) {
          _builder.append(";##### Policy Combining Algorithm");
          _builder.newLine();
          CharSequence _combiningAlgorithmConstr = this.getCombiningAlgorithmConstr(((PolicySet)pol));
          _builder.append(_combiningAlgorithmConstr, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append(";##### Policy Final Constraints");
      _builder.newLine();
      String _name_8 = pol.getName();
      CharSequence _finalConstrPSet = this.getFinalConstrPSet(_name_8, pol);
      _builder.append(_finalConstrPSet, "");
      _builder.newLineIfNotEmpty();
      _builder.append(";################### END TOP-LEVEL POLICY ");
      String _name_9 = pol.getName();
      _builder.append(_name_9, "");
      _builder.append(" CONSTRAINTs #########################");
      _builder.newLineIfNotEmpty();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * ##############################################
   * Internal Rule/PolicySet
   * ##############################################
   */
  public CharSequence getPolicyConstr(final AbstractPolicyIncl pol) throws Exception {
    PolicySet _refPol = pol.getRefPol();
    boolean _notEquals = (!Objects.equal(_refPol, null));
    if (_notEquals) {
      PolicySet _refPol_1 = pol.getRefPol();
      return this.getInternalPolicyConstr(_refPol_1);
    } else {
      FacplPolicy _newPolicy = pol.getNewPolicy();
      boolean _notEquals_1 = (!Objects.equal(_newPolicy, null));
      if (_notEquals_1) {
        FacplPolicy _newPolicy_1 = pol.getNewPolicy();
        if ((_newPolicy_1 instanceof Rule)) {
          FacplPolicy _newPolicy_2 = pol.getNewPolicy();
          return this.getInternalPolicyConstr(((Rule) _newPolicy_2));
        } else {
          FacplPolicy _newPolicy_3 = pol.getNewPolicy();
          if ((_newPolicy_3 instanceof PolicySet)) {
            FacplPolicy _newPolicy_4 = pol.getNewPolicy();
            return this.getInternalPolicyConstr(((PolicySet) _newPolicy_4));
          }
        }
      }
    }
    return null;
  }
  
  /**
   * RULE
   */
  protected CharSequence _getInternalPolicyConstr(final Rule r) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(";################### START CONSTRAINT RULE ");
    String _name = r.getName();
    _builder.append(_name, "");
    _builder.append(" #######################");
    _builder.newLineIfNotEmpty();
    _builder.append(";##### Rule Target");
    _builder.newLine();
    {
      Expression _target = r.getTarget();
      boolean _notEquals = (!Objects.equal(_target, null));
      if (_notEquals) {
        Expression _target_1 = r.getTarget();
        String _name_1 = r.getName();
        CharSequence _targetConstr = this.getTargetConstr(_target_1, _name_1);
        _builder.append(_targetConstr, "");
        _builder.newLineIfNotEmpty();
      } else {
        String _name_2 = r.getName();
        CharSequence _targetConstr_default = this.getTargetConstr_default(_name_2);
        _builder.append(_targetConstr_default, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(";##### Rule Obligations");
    _builder.newLine();
    {
      EList<Obligation> _obl = r.getObl();
      boolean _notEquals_1 = (!Objects.equal(_obl, null));
      if (_notEquals_1) {
        {
          Effect _effect = r.getEffect();
          boolean _equals = _effect.equals(Effect.PERMIT);
          if (_equals) {
            EList<Obligation> _obl_1 = r.getObl();
            String _name_3 = r.getName();
            Effect _effect_1 = r.getEffect();
            String _obligationConstr_Eff = this.getObligationConstr_Eff(_obl_1, _name_3, _effect_1);
            _builder.append(_obligationConstr_Eff, "");
            _builder.newLineIfNotEmpty();
            String _name_4 = r.getName();
            CharSequence _obligationsConstr_Default = this.getObligationsConstr_Default(_name_4, Effect.DENY);
            _builder.append(_obligationsConstr_Default, "");
            _builder.newLineIfNotEmpty();
          } else {
            EList<Obligation> _obl_2 = r.getObl();
            String _name_5 = r.getName();
            Effect _effect_2 = r.getEffect();
            String _obligationConstr_Eff_1 = this.getObligationConstr_Eff(_obl_2, _name_5, _effect_2);
            _builder.append(_obligationConstr_Eff_1, "");
            _builder.newLineIfNotEmpty();
            String _name_6 = r.getName();
            CharSequence _obligationsConstr_Default_1 = this.getObligationsConstr_Default(_name_6, Effect.PERMIT);
            _builder.append(_obligationsConstr_Default_1, "");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        String _name_7 = r.getName();
        CharSequence _obligationsConstr_Default_2 = this.getObligationsConstr_Default(_name_7, Effect.PERMIT);
        _builder.append(_obligationsConstr_Default_2, "");
        _builder.newLineIfNotEmpty();
        String _name_8 = r.getName();
        CharSequence _obligationsConstr_Default_3 = this.getObligationsConstr_Default(_name_8, Effect.DENY);
        _builder.append(_obligationsConstr_Default_3, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(";##### Rule Constraints");
    _builder.newLine();
    _builder.append(";PERMIT");
    _builder.newLine();
    _builder.append("(define-fun cns_");
    String _name_9 = r.getName();
    _builder.append(_name_9, "");
    _builder.append("_permit () Bool");
    _builder.newLineIfNotEmpty();
    {
      Effect _effect_3 = r.getEffect();
      boolean _equals_1 = _effect_3.equals(Effect.DENY);
      if (_equals_1) {
        _builder.append(" false ");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("(and (isTrue cns_target_");
        String _name_10 = r.getName();
        _builder.append(_name_10, "");
        _builder.append(") cns_obl_permit_");
        String _name_11 = r.getName();
        _builder.append(_name_11, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(")");
    _builder.newLine();
    _builder.append(";DENY");
    _builder.newLine();
    _builder.append("(define-fun cns_");
    String _name_12 = r.getName();
    _builder.append(_name_12, "");
    _builder.append("_deny () Bool");
    _builder.newLineIfNotEmpty();
    {
      Effect _effect_4 = r.getEffect();
      boolean _equals_2 = _effect_4.equals(Effect.PERMIT);
      if (_equals_2) {
        _builder.append(" false ");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("(and (isTrue cns_target_");
        String _name_13 = r.getName();
        _builder.append(_name_13, "");
        _builder.append(") cns_obl_deny_");
        String _name_14 = r.getName();
        _builder.append(_name_14, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(")");
    _builder.newLine();
    _builder.append(";NOT APP");
    _builder.newLine();
    _builder.append("(define-fun cns_");
    String _name_15 = r.getName();
    _builder.append(_name_15, "");
    _builder.append("_notApp () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(or (isFalse cns_target_");
    String _name_16 = r.getName();
    _builder.append(_name_16, "\t");
    _builder.append(") (miss cns_target_");
    String _name_17 = r.getName();
    _builder.append(_name_17, "\t");
    _builder.append("))");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    _builder.append(";INDET");
    _builder.newLine();
    _builder.append("(define-fun cns_");
    String _name_18 = r.getName();
    _builder.append(_name_18, "");
    _builder.append("_indet () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(or ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(not");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("(or  ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("(isBool cns_target_");
    String _name_19 = r.getName();
    _builder.append(_name_19, "\t\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("(miss cns_target_");
    String _name_20 = r.getName();
    _builder.append(_name_20, "\t\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(and ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("(isTrue cns_target_");
    String _name_21 = r.getName();
    _builder.append(_name_21, "\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      Effect _effect_5 = r.getEffect();
      boolean _equals_3 = _effect_5.equals(Effect.PERMIT);
      if (_equals_3) {
        _builder.append("\t\t\t");
        _builder.append("(not cns_obl_permit_");
        String _name_22 = r.getName();
        _builder.append(_name_22, "\t\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t\t");
        _builder.append("(not cns_obl_deny_");
        String _name_23 = r.getName();
        _builder.append(_name_23, "\t\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append(";################### END CONSTRAINT RULE ");
    String _name_24 = r.getName();
    _builder.append(_name_24, "");
    _builder.append(" #########################");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * POLICY SET (internal)
   */
  protected CharSequence _getInternalPolicyConstr(final PolicySet pol) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";################### START CONSTRAINT POLICY SET ");
      String _name = pol.getName();
      _builder.append(_name, "");
      _builder.append(" #######################");
      _builder.newLineIfNotEmpty();
      {
        if ((pol instanceof PolicySet)) {
          {
            EList<AbstractPolicyIncl> _policies = pol.getPolicies();
            for(final AbstractPolicyIncl el : _policies) {
              CharSequence _policyConstr = this.getPolicyConstr(el);
              _builder.append(_policyConstr, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append(";##### Policy Target");
      _builder.newLine();
      {
        Expression _target = pol.getTarget();
        boolean _notEquals = (!Objects.equal(_target, null));
        if (_notEquals) {
          Expression _target_1 = pol.getTarget();
          String _name_1 = pol.getName();
          CharSequence _targetConstr = this.getTargetConstr(_target_1, _name_1);
          _builder.append(_targetConstr, "");
          _builder.newLineIfNotEmpty();
        } else {
          String _name_2 = pol.getName();
          CharSequence _targetConstr_default = this.getTargetConstr_default(_name_2);
          _builder.append(_targetConstr_default, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append(";##### Policy Obligations");
      _builder.newLine();
      {
        EList<Obligation> _oblp = pol.getOblp();
        boolean _notEquals_1 = (!Objects.equal(_oblp, null));
        if (_notEquals_1) {
          EList<Obligation> _oblp_1 = pol.getOblp();
          String _name_3 = pol.getName();
          String _obligationConstr_Eff = this.getObligationConstr_Eff(_oblp_1, _name_3, Effect.PERMIT);
          _builder.append(_obligationConstr_Eff, "");
          _builder.newLineIfNotEmpty();
        } else {
          String _name_4 = pol.getName();
          CharSequence _obligationsConstr_Default = this.getObligationsConstr_Default(_name_4, Effect.PERMIT);
          _builder.append(_obligationsConstr_Default, "");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<Obligation> _obld = pol.getObld();
        boolean _notEquals_2 = (!Objects.equal(_obld, null));
        if (_notEquals_2) {
          EList<Obligation> _obld_1 = pol.getObld();
          String _name_5 = pol.getName();
          String _obligationConstr_Eff_1 = this.getObligationConstr_Eff(_obld_1, _name_5, Effect.DENY);
          _builder.append(_obligationConstr_Eff_1, "");
          _builder.newLineIfNotEmpty();
        } else {
          String _name_6 = pol.getName();
          CharSequence _obligationsConstr_Default_1 = this.getObligationsConstr_Default(_name_6, Effect.DENY);
          _builder.append(_obligationsConstr_Default_1, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append(";##### Policy Combining Algorithm");
      _builder.newLine();
      CharSequence _combiningAlgorithmConstr = this.getCombiningAlgorithmConstr(pol);
      _builder.append(_combiningAlgorithmConstr, "");
      _builder.newLineIfNotEmpty();
      _builder.append(";##### Policy Constraints");
      _builder.newLine();
      String _name_7 = pol.getName();
      CharSequence _finalConstrPSet = this.getFinalConstrPSet(_name_7, pol);
      _builder.append(_finalConstrPSet, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append(";################### END CONSTRAINT POLICY SET ");
      String _name_8 = pol.getName();
      _builder.append(_name_8, "");
      _builder.append(" #########################");
      _builder.newLineIfNotEmpty();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * ##############################################
   * Combining Algorithm Constraint
   * ##############################################
   */
  public CharSequence getCombiningAlgorithmConstr(final PolicySet p) {
    CharSequence _switchResult = null;
    Alg _polSetAlg = p.getPolSetAlg();
    AlgLiteral _idAlg = _polSetAlg.getIdAlg();
    if (_idAlg != null) {
      switch (_idAlg) {
        case PERMIT_OVER:
          SMT_LIBGenerator_PermitOver _sMT_LIBGenerator_PermitOver = new SMT_LIBGenerator_PermitOver();
          _switchResult = _sMT_LIBGenerator_PermitOver.combine(p);
          break;
        case DENY_OVER:
          SMT_LIBGenerator_DenyOver _sMT_LIBGenerator_DenyOver = new SMT_LIBGenerator_DenyOver();
          _switchResult = _sMT_LIBGenerator_DenyOver.combine(p);
          break;
        case DENY_UNLESS:
          SMT_LIBGenerator_DenyUnless _sMT_LIBGenerator_DenyUnless = new SMT_LIBGenerator_DenyUnless();
          _switchResult = _sMT_LIBGenerator_DenyUnless.combine(p);
          break;
        case PERMIT_UNLESS:
          SMT_LIBGenerator_PermitUnless _sMT_LIBGenerator_PermitUnless = new SMT_LIBGenerator_PermitUnless();
          _switchResult = _sMT_LIBGenerator_PermitUnless.combine(p);
          break;
        case FIRST:
          SMT_LIBGenerator_FirstApp _sMT_LIBGenerator_FirstApp = new SMT_LIBGenerator_FirstApp();
          _switchResult = _sMT_LIBGenerator_FirstApp.combine(p);
          break;
        case ONLY_ONE:
          SMT_LIBGenerator_OneApp _sMT_LIBGenerator_OneApp = new SMT_LIBGenerator_OneApp();
          _switchResult = _sMT_LIBGenerator_OneApp.combine(p);
          break;
        case WEAK_CONS:
          SMT_LIBGenerator_WeakCon _sMT_LIBGenerator_WeakCon = new SMT_LIBGenerator_WeakCon();
          _switchResult = _sMT_LIBGenerator_WeakCon.combine(p);
          break;
        case STRONG_CONS:
          SMT_LIBGenerator_StrongCon _sMT_LIBGenerator_StrongCon = new SMT_LIBGenerator_StrongCon();
          _switchResult = _sMT_LIBGenerator_StrongCon.combine(p);
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  public CharSequence getFinalConstrPSet(final String p_name, final FacplPolicy pol) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(";PERMIT");
    _builder.newLine();
    _builder.append("(define-fun cns_");
    _builder.append(p_name, "");
    _builder.append("_permit () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(and ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(isTrue cns_target_");
    _builder.append(p_name, "\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    {
      if ((pol instanceof PolicySet)) {
        _builder.append("cns_");
        _builder.append(p_name, "\t\t");
        _builder.append("_cmb_final_permit");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("cns_obl_permit_");
    _builder.append(p_name, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append(";DENY");
    _builder.newLine();
    _builder.append("(define-fun cns_");
    _builder.append(p_name, "");
    _builder.append("_deny () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(and ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(isTrue cns_target_");
    _builder.append(p_name, "\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    {
      if ((pol instanceof PolicySet)) {
        _builder.append("cns_");
        _builder.append(p_name, "\t\t");
        _builder.append("_cmb_final_deny");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("cns_obl_deny_");
    _builder.append(p_name, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append(";NOT APP");
    _builder.newLine();
    _builder.append("(define-fun cns_");
    _builder.append(p_name, "");
    _builder.append("_notApp () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(or");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(or (isFalse cns_target_");
    _builder.append(p_name, "\t\t");
    _builder.append(") (miss cns_target_");
    _builder.append(p_name, "\t\t");
    _builder.append("))");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    {
      if ((pol instanceof PolicySet)) {
        _builder.append("(and (isTrue cns_target_");
        _builder.append(p_name, "\t\t");
        _builder.append(") cns_");
        _builder.append(p_name, "\t\t");
        _builder.append("_cmb_final_notApp)");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    _builder.append(";INDET");
    _builder.newLine();
    _builder.append("(define-fun cns_");
    _builder.append(p_name, "");
    _builder.append("_indet () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(or ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(not");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("(or  ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("(isBool cns_target_");
    _builder.append(p_name, "\t\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("(miss cns_target_");
    _builder.append(p_name, "\t\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    {
      if ((pol instanceof PolicySet)) {
        _builder.append("\t\t");
        _builder.append("(and (isTrue cns_target_");
        _builder.append(p_name, "\t\t");
        _builder.append(") cns_");
        _builder.append(p_name, "\t\t");
        _builder.append("_cmb_final_indet)");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("(and ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("(isTrue cns_target_");
    _builder.append(p_name, "\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    {
      if ((pol instanceof PolicySet)) {
        _builder.append("cns_");
        _builder.append(p_name, "\t\t\t");
        _builder.append("_cmb_final_permit");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("(not cns_obl_permit_");
    _builder.append(p_name, "\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(and ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("(isTrue cns_target_");
    _builder.append(p_name, "\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    {
      if ((pol instanceof PolicySet)) {
        _builder.append("cns_");
        _builder.append(p_name, "\t\t\t");
        _builder.append("_cmb_final_deny");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("(not cns_obl_deny_");
    _builder.append(p_name, "\t\t\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * ##############################################
   * Target Constraint
   * ##############################################
   */
  public CharSequence getTargetConstr(final Expression e, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(define-fun cns_target_");
    _builder.append(name, "");
    _builder.append(" () (TValue Bool)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _expressionConst = this.getExpressionConst(e);
    _builder.append(_expressionConst, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getTargetConstr_default(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(define-fun cns_target_");
    _builder.append(name, "");
    _builder.append(" () (TValue Bool)\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(mk-val true false false) ");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * ##############################################
   * Obligation Constraint
   * ##############################################
   */
  public String getObligationConstr_Eff(final List<Obligation> obls, final String name, final Effect ef) {
    final StringBuffer str = new StringBuffer();
    String _string = ef.toString();
    String _plus = ("(define-fun cns_obl_" + _string);
    String _plus_1 = (_plus + "_");
    String _plus_2 = (_plus_1 + name);
    String _plus_3 = (_plus_2 + " ()  Bool\n");
    str.append(_plus_3);
    int _size = obls.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      str.append("\t (and ");
      int i = 0;
      for (final Obligation o : obls) {
        {
          i = (i + 1);
          EList<Expression> _expr = o.getExpr();
          int _size_1 = _expr.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            str.append("(and\n ");
            EList<Expression> _expr_1 = o.getExpr();
            for (final Expression e : _expr_1) {
              {
                String _expressionConst = this.getExpressionConst(e);
                String _plus_4 = ("\t\t (not (miss " + _expressionConst);
                String _plus_5 = (_plus_4 + "))\n");
                str.append(_plus_5);
                String _expressionConst_1 = this.getExpressionConst(e);
                String _plus_6 = ("\t\t (not (err " + _expressionConst_1);
                String _plus_7 = (_plus_6 + "))\n");
                str.append(_plus_7);
              }
            }
            str.append(")\n");
          } else {
            str.append("true");
          }
        }
      }
      if ((i == 0)) {
        str.append("\t true true");
      }
      str.append(")");
    } else {
      str.append("true\n");
    }
    str.append(")");
    return str.toString();
  }
  
  public CharSequence getObligationsConstr_Default(final String name, final Effect e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(define-fun cns_obl_");
    String _string = e.toString();
    _builder.append(_string, "");
    _builder.append("t_");
    _builder.append(name, "");
    _builder.append(" ()  Bool true )");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * ########################################################################
   * Auxiliary Functions for Datatype, functions and attributes declarations
   * ########################################################################
   */
  public CharSequence getDatatypeDec() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(";#######################");
    _builder.newLine();
    _builder.append(";RECORD DATATYPE with BOTTOM and ERROR");
    _builder.newLine();
    _builder.append(";#######################");
    _builder.newLine();
    _builder.append("(declare-datatypes (U) ((TValue (mk-val (val U)(miss Bool)(err Bool)))))");
    _builder.newLine();
    _builder.newLine();
    _builder.append(";#######################");
    _builder.newLine();
    _builder.append(";Set of elements of type T with attached an integer index");
    _builder.newLine();
    _builder.append(";#######################");
    _builder.newLine();
    _builder.append("(define-sort Set (T) (Array Int T)) ");
    return _builder;
  }
  
  public CharSequence getStringDec() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("(declare-datatypes () ((String ");
    {
      for(final String el : this.stringEls) {
        _builder.append("s_");
        _builder.append(el, " ");
        _builder.append(" ");
      }
    }
    _builder.append(" s_AdditionalStringValue )))");
    return _builder;
  }
  
  public CharSequence getAttributeDec() {
    StringConcatenation _builder = new StringConcatenation();
    {
      HashMap<String, FacplType> _substitutions = this.attributes.getSubstitutions();
      Set<String> _keySet = _substitutions.keySet();
      for(final String att_name : _keySet) {
        _builder.newLineIfNotEmpty();
        _builder.append("(declare-const ");
        CharSequence _nameAttr = this.getNameAttr(att_name);
        _builder.append(_nameAttr, "");
        _builder.append(" (TValue ");
        HashMap<String, FacplType> _substitutions_1 = this.attributes.getSubstitutions();
        FacplType _get = _substitutions_1.get(att_name);
        String _type = this.getType(_get);
        _builder.append(_type, "");
        _builder.append("))");
        _builder.newLineIfNotEmpty();
        _builder.append("(assert (not (and (miss ");
        CharSequence _nameAttr_1 = this.getNameAttr(att_name);
        _builder.append(_nameAttr_1, "");
        _builder.append(") (err ");
        CharSequence _nameAttr_2 = this.getNameAttr(att_name);
        _builder.append(_nameAttr_2, "");
        _builder.append("))))");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence getNameAttr(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("n_");
    _builder.append(string, "");
    return _builder;
  }
  
  public String getConstAttr(final String string) {
    String _replaceAll = string.replaceAll(" ", "_");
    return ("const_" + _replaceAll);
  }
  
  public String getType(final FacplType type) {
    try {
      Object _xblockexpression = null;
      {
        boolean _equals = Objects.equal(type, null);
        if (_equals) {
          return "Bool";
        }
        Object _switchResult = null;
        if (type != null) {
          switch (type) {
            case BOOLEAN:
              return "Bool";
            case DOUBLE:
              return "Real";
            case INT:
              return "Int";
            case STRING:
              return "String";
            case NAME:
              return "Bool";
            case SET_BOOLEAN:
              return "(Set Bool)";
            case SET_INT:
              return "(Set Int)";
            case SET_DOUBLE:
              return "(Set Real)";
            case SET_NAME:
              return "(Set Bool)";
            case SET_STRING:
              return "(Set String)";
            case SET_DATETIME:
              return "(Set Int)";
            case DATETIME:
              return "Int";
            case ERR:
              throw new Exception("Policy not well-typed");
            case TYPED:
              _switchResult = null;
              break;
            default:
              break;
          }
        }
        _xblockexpression = _switchResult;
      }
      return ((String)_xblockexpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence getConstantDec() {
    StringConcatenation _builder = new StringConcatenation();
    {
      Collection<ConstraintConstant> _values = this.constants.values();
      for(final ConstraintConstant cst : _values) {
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.newLine();
        {
          FacplType _type = cst.getType();
          boolean _isSet = FacplType.isSet(_type);
          if (_isSet) {
            StringBuffer _setConstantDec = this.getSetConstantDec(cst);
            _builder.append(_setConstantDec, "");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("(declare-const ");
            String _att_name = cst.getAtt_name();
            String _constAttr = this.getConstAttr(_att_name);
            _builder.append(_constAttr, "");
            _builder.append(" (TValue ");
            FacplType _type_1 = cst.getType();
            String _type_2 = this.getType(_type_1);
            _builder.append(_type_2, "");
            _builder.append("))");
            _builder.newLineIfNotEmpty();
            {
              FacplType _type_3 = cst.getType();
              boolean _equals = _type_3.equals(FacplType.STRING);
              if (_equals) {
                _builder.append("(assert (= (val ");
                String _att_name_1 = cst.getAtt_name();
                String _constAttr_1 = this.getConstAttr(_att_name_1);
                _builder.append(_constAttr_1, "");
                _builder.append(") s_");
                Object _value = cst.getValue();
                _builder.append(_value, "");
                _builder.append("))");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("(assert (= (val ");
                String _att_name_2 = cst.getAtt_name();
                String _constAttr_2 = this.getConstAttr(_att_name_2);
                _builder.append(_constAttr_2, "");
                _builder.append(") ");
                Object _value_1 = cst.getValue();
                _builder.append(_value_1, "");
                _builder.append("))");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("(assert (not (miss ");
            String _att_name_3 = cst.getAtt_name();
            String _constAttr_3 = this.getConstAttr(_att_name_3);
            _builder.append(_constAttr_3, "");
            _builder.append("))) ");
            _builder.newLineIfNotEmpty();
            _builder.append("(assert (not (err ");
            String _att_name_4 = cst.getAtt_name();
            String _constAttr_4 = this.getConstAttr(_att_name_4);
            _builder.append(_constAttr_4, "");
            _builder.append(")))");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  /**
   * ########################################
   * START DECLARATION SetS
   * ########################################
   */
  public StringBuffer getSetConstantDec(final ConstraintConstant cst) {
    StringBuffer _xblockexpression = null;
    {
      final StringBuffer str = new StringBuffer();
      String _att_name = cst.getAtt_name();
      final String set_id = this.getConstAttr(_att_name);
      FacplType _type = cst.getType();
      String _type_1 = this.getType(_type);
      String _plus = ((("(declare-const " + set_id) + " (TValue ") + _type_1);
      String _plus_1 = (_plus + "))\n");
      str.append(_plus_1);
      str.append((("(assert (not (miss " + set_id) + ")))\n"));
      str.append((("(assert (not (err " + set_id) + ")))\n"));
      for (int i = 0; (i < ((it.unifi.xtext.facpl.facpl2.Set) cst.getValue()).getArgs().size()); i++) {
        Object _value = cst.getValue();
        EList<Expression> _args = ((it.unifi.xtext.facpl.facpl2.Set) _value).getArgs();
        Expression _get = _args.get(i);
        String _expressionValue = this.getExpressionValue(_get);
        String _plus_2 = ((((("(assert (= (select (val " + set_id) + ") ") + Integer.valueOf(i)) + ") ") + _expressionValue);
        String _plus_3 = (_plus_2 + "))\n");
        str.append(_plus_3);
      }
      str.append("(assert (forall ((i Int))\n");
      str.append("\t (or \n");
      for (int i = 0; (i < ((it.unifi.xtext.facpl.facpl2.Set) cst.getValue()).getArgs().size()); i++) {
        Object _value = cst.getValue();
        EList<Expression> _args = ((it.unifi.xtext.facpl.facpl2.Set) _value).getArgs();
        Expression _get = _args.get(i);
        String _expressionValue = this.getExpressionValue(_get);
        String _plus_2 = ((("\t\t (= (select (val " + set_id) + ") i) ") + _expressionValue);
        String _plus_3 = (_plus_2 + ")\n");
        str.append(_plus_3);
      }
      str.append("\t )\n");
      _xblockexpression = str.append("))");
    }
    return _xblockexpression;
  }
  
  /**
   * Methods used within Sets -> elements are directly values and not TValue
   */
  protected String _getExpressionValue(final BooleanLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    boolean _isValue = e.isValue();
    String _string = Boolean.valueOf(_isValue).toString();
    _builder.append(_string, "");
    return _builder.toString();
  }
  
  protected String _getExpressionValue(final IntLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    int _value = e.getValue();
    String _string = Integer.valueOf(_value).toString();
    _builder.append(_string, "");
    return _builder.toString();
  }
  
  protected String _getExpressionValue(final DoubleLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    double _value = e.getValue();
    String _string = Double.valueOf(_value).toString();
    _builder.append(_string, "");
    return _builder.toString();
  }
  
  protected String _getExpressionValue(final StringLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("s_");
    String _value = e.getValue();
    String _string = _value.toString();
    _builder.append(_string, "");
    return _builder.toString();
  }
  
  protected String _getExpressionValue(final DateLiteral e) {
    long _dateTimeToInt = SMT_LIBGenerator_Code.dateTimeToInt(e);
    return Long.valueOf(_dateTimeToInt).toString();
  }
  
  protected String _getExpressionValue(final TimeLiteral e) {
    long _dateTimeToInt = SMT_LIBGenerator_Code.dateTimeToInt(e);
    return Long.valueOf(_dateTimeToInt).toString();
  }
  
  /**
   * THESE CASES CANNOT OCCUR
   */
  protected String _getExpressionValue(final it.unifi.xtext.facpl.facpl2.Set e) {
    try {
      throw new Exception("NOT SUPPORTED");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String _getExpressionValue(final AttributeName e) {
    try {
      throw new Exception("NOT SUPPORTED");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * ########################################
   * END DECLARATION SetS
   * ########################################
   */
  public CharSequence getFunctionDec() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _boolFunctions = SMT_LIBGenerator_Functions.getBoolFunctions();
    _builder.append(_boolFunctions, "");
    _builder.newLineIfNotEmpty();
    CharSequence _equalityFunctions = SMT_LIBGenerator_Functions.getEqualityFunctions();
    _builder.append(_equalityFunctions, "");
    _builder.newLineIfNotEmpty();
    {
      int _size = this.stringEls.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.newLine();
        _builder.append("(define-fun isValString ((x (TValue String))) Bool");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("(ite (and (not (miss x)) (not (err x))) true false)");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
        _builder.newLine();
        _builder.append("(define-fun ");
        String _string = funID.EQUAL.toString();
        _builder.append(_string, "");
        _builder.append("String ((x (TValue String)) (y (TValue String))) (TValue Bool)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("(ite (and (isValString x) (isValString y))");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("(ite (= (val x) (val y))");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("(mk-val true false false)");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("(mk-val false false false)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("(ite (or (err x) (err y))");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("(mk-val false false true)");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("(mk-val false true false)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
        _builder.newLine();
        _builder.append("(define-fun isValSetString ((x (TValue (Set String)))) Bool");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("(ite (and (not (miss x)) (not (err x))) true false)");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
        _builder.newLine();
        _builder.append("(define-fun ");
        String _string_1 = funID.IN.toString();
        _builder.append(_string_1, "");
        _builder.append("String ((x (TValue String)) (y (TValue (Set String)))) (TValue Bool)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("(ite (or (err x)(err y)) ");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("(mk-val false false true)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("(ite (or (miss x) (miss y))");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("(mk-val false true false)");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("(ite (exists ((i Int))");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        _builder.append("(= (val x) (select (val y) i))");
        _builder.newLine();
        _builder.append("\t\t\t\t  ");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("(mk-val true false false)");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("(mk-val false false false)");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
      }
    }
    CharSequence _intFunctions = SMT_LIBGenerator_Functions.getIntFunctions();
    _builder.append(_intFunctions, "");
    _builder.newLineIfNotEmpty();
    CharSequence _realFunctions = SMT_LIBGenerator_Functions.getRealFunctions();
    _builder.append(_realFunctions, "");
    _builder.newLineIfNotEmpty();
    CharSequence _setFunctions = SMT_LIBGenerator_Functions.getSetFunctions();
    _builder.append(_setFunctions, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected String _getExpressionConst(final AndExpression e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(FAnd ");
    Expression _left = e.getLeft();
    String _expressionConst = this.getExpressionConst(_left);
    _builder.append(_expressionConst, "");
    _builder.append(" ");
    Expression _right = e.getRight();
    String _expressionConst_1 = this.getExpressionConst(_right);
    _builder.append(_expressionConst_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _getExpressionConst(final OrExpression e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(FOr ");
    Expression _left = e.getLeft();
    String _expressionConst = this.getExpressionConst(_left);
    _builder.append(_expressionConst, "");
    _builder.append(" ");
    Expression _right = e.getRight();
    String _expressionConst_1 = this.getExpressionConst(_right);
    _builder.append(_expressionConst_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _getExpressionConst(final NotExpression e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(FNot ");
    Expression _arg = e.getArg();
    String _expressionConst = this.getExpressionConst(_arg);
    _builder.append(_expressionConst, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _getExpressionConst(final AttributeName e) {
    StringConcatenation _builder = new StringConcatenation();
    String __nameToString = SubstitutionSet._nameToString(e);
    CharSequence _nameAttr = this.getNameAttr(__nameToString);
    _builder.append(_nameAttr, "");
    return _builder.toString();
  }
  
  protected String _getExpressionConst(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    String _functionName = this.getFunctionName(f);
    _builder.append(_functionName, "");
    _builder.append(" ");
    Expression _arg1 = f.getArg1();
    String _expressionConst = this.getExpressionConst(_arg1);
    _builder.append(_expressionConst, "");
    _builder.append(" ");
    Expression _arg2 = f.getArg2();
    String _expressionConst_1 = this.getExpressionConst(_arg2);
    _builder.append(_expressionConst_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  public String getFunctionName(final Function function) {
    Expression _arg1 = function.getArg1();
    FacplType type1 = this.tInf.doSwitch(_arg1);
    Expression _arg2 = function.getArg2();
    FacplType type2 = this.tInf.doSwitch(_arg2);
    boolean _equals = type1.equals(FacplType.NAME);
    if (_equals) {
      Expression _arg1_1 = function.getArg1();
      FacplType _bound = this.attributes.getBound(((AttributeName) _arg1_1));
      type1 = _bound;
    }
    boolean _equals_1 = type2.equals(FacplType.NAME);
    if (_equals_1) {
      Expression _arg2_1 = function.getArg2();
      FacplType _bound_1 = this.attributes.getBound(((AttributeName) _arg2_1));
      type2 = _bound_1;
    }
    FacplType typeF = FacplType.combine(type1, type2);
    boolean _equals_2 = Objects.equal(typeF, null);
    if (_equals_2) {
      typeF = FacplType.BOOLEAN;
    }
    funID _functionId = function.getFunctionId();
    boolean _equals_3 = _functionId.equals(funID.IN);
    if (_equals_3) {
      funID _functionId_1 = function.getFunctionId();
      String _string = _functionId_1.toString();
      String _id = this.getId(_string);
      FacplType _typeSet = FacplType.getTypeSet(typeF);
      return (_id + _typeSet);
    } else {
      funID _functionId_2 = function.getFunctionId();
      String _string_1 = _functionId_2.toString();
      String _id_1 = this.getId(_string_1);
      String _type = this.getType(typeF);
      return (_id_1 + _type);
    }
  }
  
  public String getId(final String s) {
    return s.replace("-", "");
  }
  
  protected String _getExpressionConst(final DeclaredFunction f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    FunctionDeclaration _functionId = f.getFunctionId();
    CharSequence _declaredFunctionName = this.getDeclaredFunctionName(_functionId);
    _builder.append(_declaredFunctionName, "");
    _builder.append(" ");
    {
      EList<Expression> _args = f.getArgs();
      int _size = _args.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        {
          EList<Expression> _args_1 = f.getArgs();
          boolean _hasElements = false;
          for(final Expression arg : _args_1) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(" ", "");
            }
            _builder.append(" ");
            String _expressionConst = this.getExpressionConst(arg);
            _builder.append(_expressionConst, "");
            _builder.append(" ");
          }
        }
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
  
  public CharSequence getDeclaredFunctionName(final FunctionDeclaration function) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("DeclFun_");
    String _name = function.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  /**
   * Methods used everywhere apart from Sets
   */
  protected String _getExpressionConst(final BooleanLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    boolean _isValue = e.isValue();
    String _string = Boolean.valueOf(_isValue).toString();
    String _constAttr = this.getConstAttr(_string);
    _builder.append(_constAttr, "");
    return _builder.toString();
  }
  
  protected String _getExpressionConst(final IntLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    int _value = e.getValue();
    String _string = Integer.valueOf(_value).toString();
    String _constAttr = this.getConstAttr(_string);
    _builder.append(_constAttr, "");
    return _builder.toString();
  }
  
  protected String _getExpressionConst(final DoubleLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    double _value = e.getValue();
    String _string = Double.valueOf(_value).toString();
    String _constAttr = this.getConstAttr(_string);
    _builder.append(_constAttr, "");
    return _builder.toString();
  }
  
  protected String _getExpressionConst(final StringLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    String _value = e.getValue();
    String _string = _value.toString();
    String _constAttr = this.getConstAttr(_string);
    _builder.append(_constAttr, "");
    return _builder.toString();
  }
  
  protected String _getExpressionConst(final it.unifi.xtext.facpl.facpl2.Set e) {
    final SetUtils s = new SetUtils();
    String _doSwitch = s.doSwitch(e);
    String _get = this.sets.get(_doSwitch);
    String _constAttr = this.getConstAttr(_get);
    return _constAttr.toString();
  }
  
  protected String _getExpressionConst(final DateLiteral e) {
    String _value = e.getValue();
    String _string = _value.toString();
    ConstraintConstant _get = this.constants.get(_string);
    String _att_name = _get.getAtt_name();
    return this.getConstAttr(_att_name);
  }
  
  protected String _getExpressionConst(final TimeLiteral e) {
    String _value = e.getValue();
    String _string = _value.toString();
    ConstraintConstant _get = this.constants.get(_string);
    String _att_name = _get.getAtt_name();
    return this.getConstAttr(_att_name);
  }
  
  public String createDeclFunctionConstr(final FunctionDeclaration f) {
    FacplType type_return = this.tInf.doSwitch(f);
    StringBuffer str = new StringBuffer();
    CharSequence _declaredFunctionName = this.getDeclaredFunctionName(f);
    String _plus = ("(declare-fun " + _declaredFunctionName);
    String _plus_1 = (_plus + " ( ");
    str.append(_plus_1);
    EList<TypeLiteral> _args = f.getArgs();
    for (final TypeLiteral arg : _args) {
      {
        FacplType type = FacplType.getFacplType(arg);
        String _type = this.getType(type);
        String _plus_2 = ("(TValue " + _type);
        String _plus_3 = (_plus_2 + ") ");
        str.append(_plus_3);
      }
    }
    str.append(") ");
    String _type = this.getType(type_return);
    String _plus_2 = ("(TValue " + _type);
    String _plus_3 = (_plus_2 + ")) \n");
    str.append(_plus_3);
    return str.toString();
  }
  
  public static long dateTimeToInt(final DateLiteral e) {
    try {
      String _value = e.getValue();
      String _string = _value.toString();
      Date d = DateUtil.parseDate(_string);
      Instant _instant = d.toInstant();
      return _instant.toEpochMilli();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static long dateTimeToInt(final TimeLiteral e) {
    try {
      String _value = e.getValue();
      String _string = _value.toString();
      Date d = DateUtil.parseDate(_string);
      Instant _instant = d.toInstant();
      return _instant.toEpochMilli();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence getInternalPolicyConstr(final FacplPolicy pol) {
    if (pol instanceof PolicySet) {
      return _getInternalPolicyConstr((PolicySet)pol);
    } else if (pol instanceof Rule) {
      return _getInternalPolicyConstr((Rule)pol);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(pol).toString());
    }
  }
  
  public String getExpressionValue(final Expression e) {
    if (e instanceof AttributeName) {
      return _getExpressionValue((AttributeName)e);
    } else if (e instanceof BooleanLiteral) {
      return _getExpressionValue((BooleanLiteral)e);
    } else if (e instanceof DateLiteral) {
      return _getExpressionValue((DateLiteral)e);
    } else if (e instanceof DoubleLiteral) {
      return _getExpressionValue((DoubleLiteral)e);
    } else if (e instanceof IntLiteral) {
      return _getExpressionValue((IntLiteral)e);
    } else if (e instanceof it.unifi.xtext.facpl.facpl2.Set) {
      return _getExpressionValue((it.unifi.xtext.facpl.facpl2.Set)e);
    } else if (e instanceof StringLiteral) {
      return _getExpressionValue((StringLiteral)e);
    } else if (e instanceof TimeLiteral) {
      return _getExpressionValue((TimeLiteral)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public String getExpressionConst(final Expression e) {
    if (e instanceof AndExpression) {
      return _getExpressionConst((AndExpression)e);
    } else if (e instanceof AttributeName) {
      return _getExpressionConst((AttributeName)e);
    } else if (e instanceof BooleanLiteral) {
      return _getExpressionConst((BooleanLiteral)e);
    } else if (e instanceof DateLiteral) {
      return _getExpressionConst((DateLiteral)e);
    } else if (e instanceof DeclaredFunction) {
      return _getExpressionConst((DeclaredFunction)e);
    } else if (e instanceof DoubleLiteral) {
      return _getExpressionConst((DoubleLiteral)e);
    } else if (e instanceof Function) {
      return _getExpressionConst((Function)e);
    } else if (e instanceof IntLiteral) {
      return _getExpressionConst((IntLiteral)e);
    } else if (e instanceof NotExpression) {
      return _getExpressionConst((NotExpression)e);
    } else if (e instanceof OrExpression) {
      return _getExpressionConst((OrExpression)e);
    } else if (e instanceof it.unifi.xtext.facpl.facpl2.Set) {
      return _getExpressionConst((it.unifi.xtext.facpl.facpl2.Set)e);
    } else if (e instanceof StringLiteral) {
      return _getExpressionConst((StringLiteral)e);
    } else if (e instanceof TimeLiteral) {
      return _getExpressionConst((TimeLiteral)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
}
