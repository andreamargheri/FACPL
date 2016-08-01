package it.unifi.xtext.facpl.validation;

import com.google.common.base.Objects;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DeclaredFunction;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.IntLiteral;
import it.unifi.xtext.facpl.facpl2.NotExpression;
import it.unifi.xtext.facpl.facpl2.OrExpression;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Rule;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TimeLiteral;
import it.unifi.xtext.facpl.facpl2.util.Facpl2Switch;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;

/**
 * Check if the structural conditions on Expression (defining targets) are match
 */
@SuppressWarnings("all")
public class Facpl2Xacml_Validator extends Facpl2Switch<Boolean> {
  @Override
  public Boolean caseAndExpression(final AndExpression object) {
    return Boolean.valueOf(((this.doSwitch(object.getLeft())).booleanValue() && (this.doSwitch(object.getRight())).booleanValue()));
  }
  
  @Override
  public Boolean caseOrExpression(final OrExpression object) {
    return Boolean.valueOf(((this.doSwitch(object.getLeft())).booleanValue() && (this.doSwitch(object.getRight())).booleanValue()));
  }
  
  /**
   * Not supported by XACML
   */
  @Override
  public Boolean caseNotExpression(final NotExpression object) {
    return Boolean.valueOf(false);
  }
  
  /**
   * Check for a Policy target -> FIRST-> Attribute-Name SECOND -> Literal
   */
  @Override
  public Boolean caseFunction(final Function object) {
    if (((this.isLiteral(object.getArg1())).booleanValue() && (object.getArg2() instanceof AttributeName))) {
      return Boolean.valueOf(true);
    } else {
      Expression _arg1 = object.getArg1();
      String _string = _arg1.toString();
      String _plus = ("Function not well-formed: " + _string);
      System.out.println(_plus);
      return Boolean.valueOf(false);
    }
  }
  
  public Boolean isLiteral(final Expression e) {
    if (((((((e instanceof BooleanLiteral) || (e instanceof StringLiteral)) || (e instanceof IntLiteral)) || 
      (e instanceof DoubleLiteral)) || (e instanceof DateLiteral)) || (e instanceof TimeLiteral))) {
      return Boolean.valueOf(true);
    } else {
      return Boolean.valueOf(false);
    }
  }
  
  /**
   * If it is not wrapped by a function, it is an error
   */
  @Override
  public Boolean caseAttributeName(final AttributeName object) {
    return Boolean.valueOf(false);
  }
  
  @Override
  public Boolean caseBooleanLiteral(final BooleanLiteral object) {
    return Boolean.valueOf(false);
  }
  
  @Override
  public Boolean caseDateLiteral(final DateLiteral object) {
    return Boolean.valueOf(false);
  }
  
  @Override
  public Boolean caseDeclaredFunction(final DeclaredFunction object) {
    return Boolean.valueOf(false);
  }
  
  @Override
  public Boolean caseDoubleLiteral(final DoubleLiteral object) {
    return Boolean.valueOf(false);
  }
  
  @Override
  public Boolean caseIntLiteral(final IntLiteral object) {
    return Boolean.valueOf(false);
  }
  
  @Override
  public Boolean caseStringLiteral(final StringLiteral object) {
    return Boolean.valueOf(false);
  }
  
  @Override
  public Boolean caseTimeLiteral(final TimeLiteral object) {
    return Boolean.valueOf(false);
  }
  
  /**
   * EntryPoint for Checking if a Policy is of the expected form for translating it in XACML
   */
  protected Boolean _isXACML_FormedPolicy(final PolicySet p) {
    Expression _target = p.getTarget();
    boolean _notEquals = (!Objects.equal(_target, null));
    if (_notEquals) {
      Expression _target_1 = p.getTarget();
      Boolean _doSwitch = this.doSwitch(_target_1);
      boolean _not = (!(_doSwitch).booleanValue());
      if (_not) {
        return Boolean.valueOf(false);
      }
    }
    boolean flag = true;
    EList<AbstractPolicyIncl> _policies = p.getPolicies();
    for (final AbstractPolicyIncl el : _policies) {
      FacplPolicy _newPolicy = el.getNewPolicy();
      boolean _notEquals_1 = (!Objects.equal(_newPolicy, null));
      if (_notEquals_1) {
        flag = (flag && (this.isXACML_FormedPolicy(el.getNewPolicy())).booleanValue());
      } else {
        flag = (flag && (this.isXACML_FormedPolicy(el.getRefPol())).booleanValue());
      }
    }
    return Boolean.valueOf(flag);
  }
  
  protected Boolean _isXACML_FormedPolicy(final Rule p) {
    return Boolean.valueOf(true);
  }
  
  public Boolean isXACML_Formed(final Facpl f) {
    EList<PolicySet> _policies = f.getPolicies();
    boolean _notEquals = (!Objects.equal(_policies, null));
    if (_notEquals) {
      EList<PolicySet> _policies_1 = f.getPolicies();
      for (final PolicySet p : _policies_1) {
        Boolean _isXACML_FormedPolicy = this.isXACML_FormedPolicy(p);
        boolean _not = (!(_isXACML_FormedPolicy).booleanValue());
        if (_not) {
          return Boolean.valueOf(false);
        }
      }
    }
    return Boolean.valueOf(true);
  }
  
  public Boolean isXACML_FormedPolicy(final FacplPolicy p) {
    if (p instanceof PolicySet) {
      return _isXACML_FormedPolicy((PolicySet)p);
    } else if (p instanceof Rule) {
      return _isXACML_FormedPolicy((Rule)p);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(p).toString());
    }
  }
}
