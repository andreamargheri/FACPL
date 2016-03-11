package it.unifi.xtext.facpl.generator.util;

import com.google.common.base.Objects;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DeclaredFunction;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
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
import it.unifi.xtext.facpl.facpl2.Set;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TimeLiteral;
import it.unifi.xtext.facpl.facpl2.TypeLiteral;
import it.unifi.xtext.facpl.facpl2.util.Facpl2Switch;
import it.unifi.xtext.facpl.generator.generators.SMT_LIBGenerator_Code;
import it.unifi.xtext.facpl.generator.util.ConstraintConstant;
import it.unifi.xtext.facpl.generator.util.SetUtils;
import it.unifi.xtext.facpl.validation.FacplType;
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Collect constants used in a policy
 */
@SuppressWarnings("all")
public class PolicyConstant extends Facpl2Switch<Boolean> {
  private HashMap<String, ConstraintConstant> constants;
  
  /**
   * <String1, String2>
   * -> String1 == string representation of set
   * -> String2 == name of the set
   */
  private HashMap<String, String> sets;
  
  public PolicyConstant() {
    HashMap<String, ConstraintConstant> _hashMap = new HashMap<String, ConstraintConstant>();
    this.constants = _hashMap;
    HashMap<String, String> _hashMap_1 = new HashMap<String, String>();
    this.sets = _hashMap_1;
  }
  
  public HashMap<String, ConstraintConstant> getConstants() {
    return this.constants;
  }
  
  public HashMap<String, String> getSets() {
    return this.sets;
  }
  
  @Override
  public Boolean caseFacpl(final Facpl object) {
    boolean s = true;
    EList<PolicySet> _policies = object.getPolicies();
    boolean _notEquals = (!Objects.equal(_policies, null));
    if (_notEquals) {
      EList<PolicySet> _policies_1 = object.getPolicies();
      for (final PolicySet pol : _policies_1) {
        boolean _and = false;
        if (!s) {
          _and = false;
        } else {
          Boolean _doSwitch = this.doSwitch(pol);
          _and = (_doSwitch).booleanValue();
        }
        s = _and;
      }
    }
    EList<FunctionDeclaration> _declarations = object.getDeclarations();
    boolean _notEquals_1 = (!Objects.equal(_declarations, null));
    if (_notEquals_1) {
      EList<FunctionDeclaration> _declarations_1 = object.getDeclarations();
      for (final FunctionDeclaration f : _declarations_1) {
        boolean _and_1 = false;
        if (!s) {
          _and_1 = false;
        } else {
          Boolean _doSwitch_1 = this.doSwitch(f);
          _and_1 = (_doSwitch_1).booleanValue();
        }
        s = _and_1;
      }
    }
    EList<Request> _requests = object.getRequests();
    boolean _notEquals_2 = (!Objects.equal(_requests, null));
    if (_notEquals_2) {
      EList<Request> _requests_1 = object.getRequests();
      for (final Request r : _requests_1) {
        boolean _and_2 = false;
        if (!s) {
          _and_2 = false;
        } else {
          Boolean _doSwitch_2 = this.doSwitch(r);
          _and_2 = (_doSwitch_2).booleanValue();
        }
        s = _and_2;
      }
    }
    return Boolean.valueOf(s);
  }
  
  /**
   * REQUEST
   */
  @Override
  public Boolean caseRequest(final Request req) {
    EList<AttributeReq> _attributes = req.getAttributes();
    for (final AttributeReq el : _attributes) {
      {
        boolean s = true;
        EList<Expression> _value = el.getValue();
        for (final Expression v : _value) {
          boolean _and = false;
          if (!s) {
            _and = false;
          } else {
            Boolean _doSwitch = this.doSwitch(v);
            _and = (_doSwitch).booleanValue();
          }
          s = _and;
        }
        if ((s == false)) {
          return Boolean.valueOf(false);
        }
      }
    }
    return Boolean.valueOf(true);
  }
  
  /**
   * DECLARED FUNCTIONs
   */
  @Override
  public Boolean caseFunctionDeclaration(final FunctionDeclaration f) {
    EList<TypeLiteral> _args = f.getArgs();
    for (final TypeLiteral el : _args) {
      boolean _equals = el.equals(TypeLiteral.STRING);
      if (_equals) {
        final ConstraintConstant c = new ConstraintConstant(FacplType.STRING, "def_val", "def_val");
        String _att_name = c.getAtt_name();
        this.constants.put(_att_name, c);
      }
    }
    return Boolean.valueOf(true);
  }
  
  /**
   * POLICIES
   */
  @Override
  public Boolean caseFacplPolicy(final FacplPolicy object) {
    if ((object instanceof PolicySet)) {
      return this.doSwitch(((PolicySet) object));
    } else {
      if ((object instanceof Rule)) {
        return this.doSwitch(((Rule) object));
      }
    }
    return null;
  }
  
  @Override
  public Boolean caseAbstractPolicyIncl(final AbstractPolicyIncl object) {
    PolicySet _refPol = object.getRefPol();
    boolean _notEquals = (!Objects.equal(_refPol, null));
    if (_notEquals) {
      PolicySet _refPol_1 = object.getRefPol();
      return this.doSwitch(_refPol_1);
    } else {
      FacplPolicy _newPolicy = object.getNewPolicy();
      boolean _notEquals_1 = (!Objects.equal(_newPolicy, null));
      if (_notEquals_1) {
        FacplPolicy _newPolicy_1 = object.getNewPolicy();
        return this.doSwitch(_newPolicy_1);
      }
    }
    return null;
  }
  
  @Override
  public Boolean casePolicySet(final PolicySet object) {
    boolean s = true;
    Expression _target = object.getTarget();
    boolean _notEquals = (!Objects.equal(_target, null));
    if (_notEquals) {
      boolean _and = false;
      if (!s) {
        _and = false;
      } else {
        Expression _target_1 = object.getTarget();
        Boolean _doSwitch = this.doSwitch(_target_1);
        _and = (_doSwitch).booleanValue();
      }
      s = _and;
    }
    EList<AbstractPolicyIncl> _policies = object.getPolicies();
    for (final AbstractPolicyIncl pol : _policies) {
      boolean _and_1 = false;
      if (!s) {
        _and_1 = false;
      } else {
        Boolean _doSwitch_1 = this.doSwitch(pol);
        _and_1 = (_doSwitch_1).booleanValue();
      }
      s = _and_1;
    }
    EList<Obligation> _obl = object.getObl();
    for (final Obligation ob : _obl) {
      EList<Expression> _expr = ob.getExpr();
      for (final Expression expr : _expr) {
        boolean _and_2 = false;
        if (!s) {
          _and_2 = false;
        } else {
          Boolean _doSwitch_2 = this.doSwitch(expr);
          _and_2 = (_doSwitch_2).booleanValue();
        }
        s = _and_2;
      }
    }
    return Boolean.valueOf(s);
  }
  
  @Override
  public Boolean caseRule(final Rule object) {
    boolean s = true;
    Expression _target = object.getTarget();
    boolean _notEquals = (!Objects.equal(_target, null));
    if (_notEquals) {
      boolean _and = false;
      if (!s) {
        _and = false;
      } else {
        Expression _target_1 = object.getTarget();
        Boolean _doSwitch = this.doSwitch(_target_1);
        _and = (_doSwitch).booleanValue();
      }
      s = _and;
    }
    EList<Obligation> _obl = object.getObl();
    for (final Obligation ob : _obl) {
      EList<Expression> _expr = ob.getExpr();
      for (final Expression expr : _expr) {
        boolean _and_1 = false;
        if (!s) {
          _and_1 = false;
        } else {
          Boolean _doSwitch_1 = this.doSwitch(expr);
          _and_1 = (_doSwitch_1).booleanValue();
        }
        s = _and_1;
      }
    }
    return Boolean.valueOf(s);
  }
  
  @Override
  public Boolean caseExpression(final Expression object) {
    return this.doSwitch(object);
  }
  
  @Override
  public Boolean caseAndExpression(final AndExpression object) {
    Expression _left = object.getLeft();
    this.doSwitch(_left);
    Expression _right = object.getRight();
    this.doSwitch(_right);
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseOrExpression(final OrExpression object) {
    Expression _left = object.getLeft();
    this.doSwitch(_left);
    Expression _right = object.getRight();
    this.doSwitch(_right);
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseNotExpression(final NotExpression object) {
    Expression _arg = object.getArg();
    return this.doSwitch(_arg);
  }
  
  @Override
  public Boolean caseFunction(final Function object) {
    Expression _arg1 = object.getArg1();
    this.doSwitch(_arg1);
    Expression _arg2 = object.getArg2();
    this.doSwitch(_arg2);
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseSet(final Set set) {
    try {
      final FacplTypeInference tCheck = new FacplTypeInference();
      final FacplType t = tCheck.doSwitch(set);
      boolean _equals = t.equals(FacplType.SET_NAME);
      boolean _not = (!_equals);
      if (_not) {
        final SetUtils setUtils = new SetUtils();
        String _doSwitch = setUtils.doSwitch(set);
        boolean _containsKey = this.sets.containsKey(_doSwitch);
        boolean _not_1 = (!_containsKey);
        if (_not_1) {
          int _size = this.sets.size();
          int _plus = (_size + 1);
          String _string = Integer.valueOf(_plus).toString();
          final String id = ("set_" + _string);
          String _doSwitch_1 = setUtils.doSwitch(set);
          this.sets.put(_doSwitch_1, id);
          final ConstraintConstant c = new ConstraintConstant(t, id, set);
          this.constants.put(id, c);
        } else {
        }
      } else {
        throw new Exception("Bags containing attribute names are not supported");
      }
      return Boolean.valueOf(true);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public Boolean caseDeclaredFunction(final DeclaredFunction f) {
    EList<Expression> _args = f.getArgs();
    for (final Expression arg : _args) {
      this.doSwitch(arg);
    }
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseAttributeName(final AttributeName object) {
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseBooleanLiteral(final BooleanLiteral object) {
    boolean _isValue = object.isValue();
    String _string = Boolean.valueOf(_isValue).toString();
    boolean _isValue_1 = object.isValue();
    String _string_1 = Boolean.valueOf(_isValue_1).toString();
    final ConstraintConstant c = new ConstraintConstant(FacplType.BOOLEAN, _string, _string_1);
    String _att_name = c.getAtt_name();
    this.constants.put(_att_name, c);
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseDoubleLiteral(final DoubleLiteral object) {
    double _value = object.getValue();
    String _string = Double.valueOf(_value).toString();
    double _value_1 = object.getValue();
    String _string_1 = Double.valueOf(_value_1).toString();
    final ConstraintConstant c = new ConstraintConstant(FacplType.DOUBLE, _string, _string_1);
    String _att_name = c.getAtt_name();
    this.constants.put(_att_name, c);
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseIntLiteral(final IntLiteral object) {
    int _value = object.getValue();
    String _string = Integer.valueOf(_value).toString();
    int _value_1 = object.getValue();
    String _string_1 = Integer.valueOf(_value_1).toString();
    final ConstraintConstant c = new ConstraintConstant(FacplType.INT, _string, _string_1);
    String _att_name = c.getAtt_name();
    this.constants.put(_att_name, c);
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseStringLiteral(final StringLiteral object) {
    String _value = object.getValue();
    String _string = _value.toString();
    String _value_1 = object.getValue();
    String _string_1 = _value_1.toString();
    final ConstraintConstant c = new ConstraintConstant(FacplType.STRING, _string, _string_1);
    String _att_name = c.getAtt_name();
    this.constants.put(_att_name, c);
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseDateLiteral(final DateLiteral object) {
    String _value = object.getValue();
    String _string = _value.toString();
    long _dateTimeToInt = SMT_LIBGenerator_Code.dateTimeToInt(object);
    final ConstraintConstant c = new ConstraintConstant(FacplType.INT, _string, Long.valueOf(_dateTimeToInt));
    String _att_name = c.getAtt_name();
    this.constants.put(_att_name, c);
    return Boolean.valueOf(true);
  }
  
  @Override
  public Boolean caseTimeLiteral(final TimeLiteral object) {
    String _value = object.getValue();
    String _string = _value.toString();
    long _dateTimeToInt = SMT_LIBGenerator_Code.dateTimeToInt(object);
    final ConstraintConstant c = new ConstraintConstant(FacplType.INT, _string, Long.valueOf(_dateTimeToInt));
    String _att_name = c.getAtt_name();
    this.constants.put(_att_name, c);
    return Boolean.valueOf(true);
  }
}
