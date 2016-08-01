package it.unifi.xtext.facpl.generator;

import com.google.common.base.Objects;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.MainFacpl;
import it.unifi.xtext.facpl.facpl2.PAF;
import it.unifi.xtext.facpl.facpl2.PDP;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.generator.generators.SMT_LIBGenerator_Code;
import it.unifi.xtext.facpl.generator.util.AuthorisationProperty;
import it.unifi.xtext.facpl.generator.util.Decision;
import it.unifi.xtext.facpl.generator.util.StructuralProperty;
import it.unifi.xtext.facpl.validation.FacplType;
import it.unifi.xtext.facpl.validation.inference.SubstitutionSet;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class SMT_LIBGenerator extends SMT_LIBGenerator_Code {
  /**
   * EntryPoint for menu command Generate SMT-LIB code
   */
  public void doGenerateFileSMT_LIB(final Facpl resource, final IFileSystemAccess fsa) throws Exception {
    CharSequence header = this.initialiseFacplResource(resource);
    EList<PolicySet> _policies = resource.getPolicies();
    boolean _notEquals = (!Objects.equal(_policies, null));
    if (_notEquals) {
      EList<PolicySet> _policies_1 = resource.getPolicies();
      for (final PolicySet pol : _policies_1) {
        String _name = pol.getName();
        String _plus = (_name + ".smt2");
        String _plus_1 = (header + " \n");
        CharSequence _createMainConstraint = this.createMainConstraint(pol);
        String _plus_2 = (_plus_1 + _createMainConstraint);
        fsa.generateFile(_plus, _plus_2);
      }
    }
    MainFacpl _main = resource.getMain();
    boolean _notEquals_1 = (!Objects.equal(_main, null));
    if (_notEquals_1) {
      MainFacpl _main_1 = resource.getMain();
      PAF _paf = _main_1.getPaf();
      PDP _pdp = _paf.getPdp();
      boolean _notEquals_2 = (!Objects.equal(_pdp, null));
      if (_notEquals_2) {
        MainFacpl _main_2 = resource.getMain();
        PAF _paf_1 = _main_2.getPaf();
        PDP _pdp_1 = _paf_1.getPdp();
        EList<AbstractPolicyIncl> _polSet = _pdp_1.getPolSet();
        for (final AbstractPolicyIncl pol_1 : _polSet) {
          FacplPolicy _newPolicy = pol_1.getNewPolicy();
          boolean _notEquals_3 = (!Objects.equal(_newPolicy, null));
          if (_notEquals_3) {
            FacplPolicy _newPolicy_1 = pol_1.getNewPolicy();
            String _name_1 = _newPolicy_1.getName();
            String _plus_3 = (_name_1 + ".smt2");
            String _plus_4 = (header + " \n");
            FacplPolicy _newPolicy_2 = pol_1.getNewPolicy();
            CharSequence _createMainConstraint_1 = this.createMainConstraint(_newPolicy_2);
            String _plus_5 = (_plus_4 + _createMainConstraint_1);
            fsa.generateFile(_plus_3, _plus_5);
          }
        }
      }
    }
  }
  
  /**
   * EntryPoint for Authorisation Property
   */
  public void doGenerateAuthorisation_Property(final Facpl resource, final String policy_name, final String name_property, final Request req, final Decision dec, final AuthorisationProperty prop, final IFileSystemAccess fsa) {
    String str = this.doGenerateAuthorisation_Property_Code(resource, policy_name, req, dec, prop);
    String fileName = ((("Property_" + name_property) + "_") + policy_name);
    fsa.generateFile((fileName + ".smt2"), str);
    CharSequence _bashCommand = this.getBashCommand(fileName, name_property, policy_name);
    fsa.generateFile((fileName + "_z3.sh"), _bashCommand);
  }
  
  /**
   * EntryPoint for Structural Property
   */
  public void doGenerateStructural_Property(final Facpl resource, final String policy_name1, final String policy_name2, final String name_property, final StructuralProperty prop, final IFileSystemAccess fsa) {
    String str = "";
    String fileName = "";
    boolean _equals = prop.equals(StructuralProperty.COMPLETE);
    if (_equals) {
      String _doGenerateComplete_Property_Code = this.doGenerateComplete_Property_Code(resource, policy_name1);
      str = _doGenerateComplete_Property_Code;
      fileName = ((("Property_" + name_property) + "_") + policy_name1);
    } else {
      String _doGenerateStructural_Property_Code = this.doGenerateStructural_Property_Code(resource, policy_name1, policy_name2, prop);
      str = _doGenerateStructural_Property_Code;
      fileName = ((((("Property_" + name_property) + "_") + policy_name1) + "_") + policy_name2);
    }
    fsa.generateFile((fileName + ".smt2"), str);
    CharSequence _bashCommand = this.getBashCommand(fileName, name_property, policy_name1);
    fsa.generateFile((fileName + "_z3.sh"), _bashCommand);
  }
  
  /**
   * Main bash file for Z3 launch
   */
  public CharSequence getBashCommand(final String fileName, final String prop_name, final String policy_name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#! /bin/bash");
    _builder.newLine();
    _builder.newLine();
    _builder.append("clear");
    _builder.newLine();
    _builder.newLine();
    _builder.append("echo \"Starting Verification of Property ");
    _builder.append(prop_name, "");
    _builder.append(" on FACPL Policy ");
    _builder.append(policy_name, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#Alias z3 is assumed defined in the environment");
    _builder.newLine();
    _builder.newLine();
    _builder.append("z3 -st -smt2 ");
    _builder.append(fileName, "");
    _builder.append(".smt2");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * Generation of SMT-LIB code for the Complete Structural Property
   */
  public String doGenerateComplete_Property_Code(final Facpl resource, final String policy_name) {
    try {
      StringBuffer str = new StringBuffer();
      CharSequence _initialiseFacplResource = this.initialiseFacplResource(resource);
      str.append(_initialiseFacplResource);
      EList<PolicySet> _policies = resource.getPolicies();
      boolean _notEquals = (!Objects.equal(_policies, null));
      if (_notEquals) {
        EList<PolicySet> _policies_1 = resource.getPolicies();
        for (final PolicySet pol : _policies_1) {
          String _name = pol.getName();
          boolean _equals = _name.equals(policy_name);
          if (_equals) {
            CharSequence _createMainConstraint = this.createMainConstraint(pol);
            str.append(_createMainConstraint);
          }
        }
      }
      str.append(";###################### STRUCTURAL PROPERTY #####################\n");
      str.append((("(echo \"--> Check COMPLETE of " + policy_name) + "... (holds if the following check is unsat)\")\n"));
      str.append((("(assert cns_" + policy_name) + "_notApp)"));
      str.append("\n\n(check-sat)\n");
      str.append("(get-model)\n");
      return str.toString();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Generation of the SMT-LIB for the structural properties
   */
  public String doGenerateStructural_Property_Code(final Facpl resource, final String policy_name1, final String policy_name2, final StructuralProperty property) {
    try {
      StringBuffer str = new StringBuffer();
      CharSequence _initialiseFacplResource = this.initialiseFacplResource(resource);
      str.append(_initialiseFacplResource);
      EList<PolicySet> _policies = resource.getPolicies();
      boolean _notEquals = (!Objects.equal(_policies, null));
      if (_notEquals) {
        EList<PolicySet> _policies_1 = resource.getPolicies();
        for (final PolicySet pol : _policies_1) {
          if ((pol.getName().equals(policy_name1) || pol.getName().equals(policy_name2))) {
            CharSequence _createMainConstraint = this.createMainConstraint(pol);
            str.append(_createMainConstraint);
          }
        }
      }
      str.append(";###################### STRUCTURAL PROPERTY #####################\n");
      boolean _equals = property.equals(StructuralProperty.COVER);
      if (_equals) {
        str.append((((("(echo \"--> Check " + policy_name1) + "COVER") + policy_name2) + "... (holds if the following two checks are unsat)\")\n"));
        str.append((((("(echo \"...(1/2) " + policy_name1) + "_PERMIT  COVER ") + policy_name2) + "_PERMIT...(holds if it is unsat)\")\n "));
        str.append("(push)\n");
        str.append("(assert \n");
        str.append((((("\t (and (not cns_" + policy_name1) + "_permit) cns_") + policy_name2) + "_permit)\n"));
        str.append(")\n");
        str.append("\n(check-sat)\n");
        str.append(";(get-model)\n\n");
        str.append("(pop)\n");
        str.append("(push)\n");
        str.append((((("(echo \"...(2/2) " + policy_name1) + "_DENY  COVER ") + policy_name2) + "_DENY...(holds if it is unsat)\")\n "));
        str.append("(assert \n");
        str.append((((("\t (and (not cns_" + policy_name1) + "_deny) cns_") + policy_name2) + "_deny)\n"));
        str.append(")\n");
        str.append("\n(check-sat)\n");
        str.append(";(get-model)\n\n");
      } else {
        boolean _equals_1 = property.equals(StructuralProperty.DISJOINT);
        if (_equals_1) {
          str.append((((("(echo \"--> Check " + policy_name1) + "DIJOINT") + policy_name2) + "... (holds if the following four checks are unsat)\")\n"));
          str.append((((("(echo \"...(1/4) " + policy_name1) + "_PERMIT  DIJOINT ") + policy_name2) + "_PERMIT...(holds if it is unsat)\")\n "));
          str.append("(push)\n");
          str.append("(assert \n");
          str.append((((("\t (and cns_" + policy_name1) + "_permit cns_") + policy_name2) + "_permit)\n"));
          str.append(")\n");
          str.append("\n(check-sat)\n");
          str.append(";(get-model)\n\n");
          str.append((((("(echo \"...(2/4) " + policy_name1) + "_PERMIT  DIJOINT ") + policy_name2) + "_DENY...(holds if it is unsat)\")\n "));
          str.append("(push)\n");
          str.append("(assert \n");
          str.append((((("\t (and cns_" + policy_name1) + "_permit cns_") + policy_name2) + "_deny)\n"));
          str.append(")\n");
          str.append("\n(check-sat)\n");
          str.append(";(get-model)\n\n");
          str.append((((("(echo \"...(3/4) " + policy_name1) + "_DENY  DIJOINT ") + policy_name2) + "_PERMIT...(holds if it is unsat)\")\n "));
          str.append("(push)\n");
          str.append("(assert \n");
          str.append((((("\t (and cns_" + policy_name1) + "_deny cns_") + policy_name2) + "_permit)\n"));
          str.append(")\n");
          str.append("\n(check-sat)\n");
          str.append(";(get-model)\n\n");
          str.append((((("(echo \"...(4/4) " + policy_name1) + "_DENY  DIJOINT ") + policy_name2) + "_DENY...(holds if it is unsat)\")\n "));
          str.append("(push)\n");
          str.append("(assert \n");
          str.append((((("\t (and cns_" + policy_name1) + "_deny cns_") + policy_name2) + "_deny)\n"));
          str.append(")\n");
          str.append("\n(check-sat)\n");
          str.append(";(get-model)\n\n");
        } else {
          throw new Exception("Wrong invocation of the generation method for the case of structural properties");
        }
      }
      return str.toString();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Generation of SMT-LIB code for Authorisation Property
   */
  public String doGenerateAuthorisation_Property_Code(final Facpl resource, final String policy_name, final Request req, final Decision dec, final AuthorisationProperty prop) {
    try {
      StringBuffer str = new StringBuffer();
      CharSequence _initialiseFacplResource_Request = this.initialiseFacplResource_Request(resource, req);
      str.append(_initialiseFacplResource_Request);
      EList<PolicySet> _policies = resource.getPolicies();
      boolean _notEquals = (!Objects.equal(_policies, null));
      if (_notEquals) {
        EList<PolicySet> _policies_1 = resource.getPolicies();
        for (final PolicySet pol : _policies_1) {
          String _name = pol.getName();
          boolean _equals = _name.equals(policy_name);
          if (_equals) {
            CharSequence _createMainConstraint = this.createMainConstraint(pol);
            str.append(_createMainConstraint);
          }
        }
      }
      str.append(";###################### AUTHORISATION PROPERTY #####################\n");
      EList<AttributeReq> _attributes = req.getAttributes();
      for (final AttributeReq attr : _attributes) {
        AttributeName _name_1 = attr.getName();
        FacplType _bound = this.attributes.getBound(_name_1);
        boolean _notEquals_1 = (!Objects.equal(_bound, null));
        if (_notEquals_1) {
          EList<Expression> _value = attr.getValue();
          int _size = _value.size();
          boolean _equals_1 = (_size == 1);
          if (_equals_1) {
            AttributeName _name_2 = attr.getName();
            String __nameToString = SubstitutionSet._nameToString(_name_2);
            CharSequence _nameAttr = this.getNameAttr(__nameToString);
            String _plus = ("(assert (= (val " + _nameAttr);
            String _plus_1 = (_plus + ") ");
            EList<Expression> _value_1 = attr.getValue();
            Expression _get = _value_1.get(0);
            String _expressionValue = this.getExpressionValue(_get);
            String _plus_2 = (_plus_1 + _expressionValue);
            String _plus_3 = (_plus_2 + "))\n");
            str.append(_plus_3);
          } else {
            for (int i = 0; (i < attr.getValue().size()); i++) {
              AttributeName _name_3 = attr.getName();
              String __nameToString_1 = SubstitutionSet._nameToString(_name_3);
              CharSequence _nameAttr_1 = this.getNameAttr(__nameToString_1);
              String _plus_4 = ("(assert (= (select (val " + _nameAttr_1);
              String _plus_5 = (_plus_4 + ") ");
              String _plus_6 = (_plus_5 + Integer.valueOf(i));
              String _plus_7 = (_plus_6 + ") ");
              EList<Expression> _value_2 = attr.getValue();
              Expression _get_1 = _value_2.get(i);
              String _expressionValue_1 = this.getExpressionValue(_get_1);
              String _plus_8 = (_plus_7 + _expressionValue_1);
              String _plus_9 = (_plus_8 + "))\n");
              str.append(_plus_9);
            }
            str.append("\n(assert (forall ((i Int\t))\n");
            str.append("\t (or\n");
            for (int i = 0; (i < attr.getValue().size()); i++) {
              AttributeName _name_3 = attr.getName();
              String __nameToString_1 = SubstitutionSet._nameToString(_name_3);
              CharSequence _nameAttr_1 = this.getNameAttr(__nameToString_1);
              String _plus_4 = ("\t \t (= (select (val " + _nameAttr_1);
              String _plus_5 = (_plus_4 + ") ");
              String _plus_6 = (_plus_5 + Integer.valueOf(i));
              String _plus_7 = (_plus_6 + ")");
              EList<Expression> _value_2 = attr.getValue();
              Expression _get_1 = _value_2.get(i);
              String _expressionValue_1 = this.getExpressionValue(_get_1);
              String _plus_8 = (_plus_7 + _expressionValue_1);
              String _plus_9 = (_plus_8 + ")\n");
              str.append(_plus_9);
            }
            str.append(")))\n\n");
          }
          AttributeName _name_3 = attr.getName();
          String __nameToString_1 = SubstitutionSet._nameToString(_name_3);
          CharSequence _nameAttr_1 = this.getNameAttr(__nameToString_1);
          String _plus_4 = ("(assert (not (miss " + _nameAttr_1);
          String _plus_5 = (_plus_4 + ")))\n");
          str.append(_plus_5);
          AttributeName _name_4 = attr.getName();
          String __nameToString_2 = SubstitutionSet._nameToString(_name_4);
          CharSequence _nameAttr_2 = this.getNameAttr(__nameToString_2);
          String _plus_6 = ("(assert (not (err " + _nameAttr_2);
          String _plus_7 = (_plus_6 + ")))\n");
          str.append(_plus_7);
        }
      }
      boolean _equals_2 = prop.equals(AuthorisationProperty.EVAL);
      if (_equals_2) {
        HashMap<String, FacplType> _substitutions = this.attributes.getSubstitutions();
        Set<String> _keySet = _substitutions.keySet();
        for (final String attr_policy : _keySet) {
          boolean _isDefinedInReq = this.isDefinedInReq(attr_policy, req);
          boolean _not = (!_isDefinedInReq);
          if (_not) {
            CharSequence _nameAttr_3 = this.getNameAttr(attr_policy);
            String _plus_8 = ("(assert (miss " + _nameAttr_3);
            String _plus_9 = (_plus_8 + "))\n");
            str.append(_plus_9);
          }
        }
      }
      str.append("\n");
      if (prop != null) {
        switch (prop) {
          case EVAL:
            String __toDecision = this._toDecision(dec);
            String _plus_10 = ((("(assert cns_" + policy_name) + "_") + __toDecision);
            String _plus_11 = (_plus_10 + ")");
            str.append(_plus_11);
            str.append("(echo \" --> Check EVAL property... (holds if the following check is sat)\")\n");
            break;
          case MAY:
            String __toDecision_1 = this._toDecision(dec);
            String _plus_12 = ((("(assert cns_" + policy_name) + "_") + __toDecision_1);
            String _plus_13 = (_plus_12 + ")");
            str.append(_plus_13);
            str.append("(echo \" --> Check MAY property... (holds if the following check is sat)\")\n");
            break;
          case MUST:
            String __toDecision_2 = this._toDecision(dec);
            String _plus_14 = ((("(assert (not cns_" + policy_name) + "_") + __toDecision_2);
            String _plus_15 = (_plus_14 + "))");
            str.append(_plus_15);
            str.append("(echo \" --> Check MUST property... (holds if the following check is unsat)\")\n");
            break;
          default:
            break;
        }
      }
      str.append("\n\n(check-sat)\n");
      str.append("(get-model)\n");
      return str.toString();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String _toDecision(final Decision dec) {
    if (dec != null) {
      switch (dec) {
        case DENY:
          return "deny";
        case PERMIT:
          return "permit";
        case INDETERMINATE:
          return "indet";
        case NOT_APPLICABLE:
          return "notApp";
        default:
          break;
      }
    }
    return null;
  }
  
  public boolean isDefinedInReq(final String attr_p, final Request req) {
    EList<AttributeReq> _attributes = req.getAttributes();
    for (final AttributeReq attr : _attributes) {
      AttributeName _name = attr.getName();
      String __nameToString = SubstitutionSet._nameToString(_name);
      boolean _equals = __nameToString.equals(attr_p);
      if (_equals) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Stub for testing SMT-LIB code
   */
  public String doGenerateSMT_LIB_Test(final Facpl resource) throws Exception {
    StringBuffer str = new StringBuffer();
    CharSequence _initialiseFacplResource = this.initialiseFacplResource(resource);
    str.append(_initialiseFacplResource);
    EList<PolicySet> _policies = resource.getPolicies();
    boolean _notEquals = (!Objects.equal(_policies, null));
    if (_notEquals) {
      EList<PolicySet> _policies_1 = resource.getPolicies();
      for (final PolicySet pol : _policies_1) {
        CharSequence _createMainConstraint = this.createMainConstraint(pol);
        str.append(_createMainConstraint);
      }
    }
    return str.toString();
  }
}
