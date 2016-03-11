package it.unifi.xtext.facpl.generator.util;

import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.IntLiteral;
import it.unifi.xtext.facpl.facpl2.Set;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TimeLiteral;
import it.unifi.xtext.facpl.facpl2.util.Facpl2Switch;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Pretty printing of Sets (it reports only the Literals forming a Set)
 */
@SuppressWarnings("all")
public class SetUtils extends Facpl2Switch<String> {
  @Override
  public String caseSet(final Set Set) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set(");
    {
      EList<Expression> _args = Set.getArgs();
      boolean _hasElements = false;
      for(final Expression arg : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        String _doSwitch = this.doSwitch(arg);
        _builder.append(_doSwitch, "");
      }
    }
    _builder.append(")");
    return _builder.toString();
  }
  
  @Override
  public String caseAttributeName(final AttributeName object) {
    String _category = object.getCategory();
    String _plus = (_category + "/");
    String _id = object.getId();
    return (_plus + _id);
  }
  
  @Override
  public String caseBooleanLiteral(final BooleanLiteral object) {
    boolean _isValue = object.isValue();
    return Boolean.valueOf(_isValue).toString();
  }
  
  @Override
  public String caseDoubleLiteral(final DoubleLiteral object) {
    double _value = object.getValue();
    return Double.valueOf(_value).toString();
  }
  
  @Override
  public String caseIntLiteral(final IntLiteral object) {
    int _value = object.getValue();
    return Integer.valueOf(_value).toString();
  }
  
  @Override
  public String caseStringLiteral(final StringLiteral object) {
    String _value = object.getValue();
    return _value.toString();
  }
  
  @Override
  public String caseDateLiteral(final DateLiteral object) {
    String _value = object.getValue();
    return _value.toString();
  }
  
  @Override
  public String caseTimeLiteral(final TimeLiteral object) {
    String _value = object.getValue();
    return _value.toString();
  }
}
