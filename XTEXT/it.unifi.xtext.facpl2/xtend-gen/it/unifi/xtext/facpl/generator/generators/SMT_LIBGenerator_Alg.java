package it.unifi.xtext.facpl.generator.generators;

import com.google.common.base.Objects;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Abstract Methods for the Combination of constraints
 */
@SuppressWarnings("all")
public abstract class SMT_LIBGenerator_Alg {
  private int n_step;
  
  public CharSequence combine(final PolicySet p) {
    EList<AbstractPolicyIncl> _policies = p.getPolicies();
    int _size = _policies.size();
    int _minus = (_size - 1);
    this.n_step = _minus;
    if ((this.n_step == 0)) {
      String r_name = null;
      String _polName = this.getPolName(0, p);
      r_name = _polName;
      String _name = p.getName();
      return this.getDefaultCase(_name, r_name);
    } else {
      StringBuffer s = new StringBuffer();
      String previousCmb = this.getPolName(0, p);
      Boolean isFirst = Boolean.valueOf(true);
      for (int i = 1; (i <= this.n_step); i++) {
        {
          String currentCmb = this.getPolName(i, p);
          Boolean isFinal = null;
          if ((i == this.n_step)) {
            isFinal = Boolean.valueOf(true);
          } else {
            isFinal = Boolean.valueOf(false);
          }
          String _name_1 = p.getName();
          String _combination = this.getCombination(previousCmb, currentCmb, _name_1, isFirst, isFinal);
          String _plus = (_combination + " \n");
          s.append(_plus);
          isFirst = Boolean.valueOf(false);
          if ((!(isFinal).booleanValue())) {
            previousCmb = (previousCmb + currentCmb);
          }
        }
      }
      return s;
    }
  }
  
  /**
   * Prev = name of first policy to consider (i.e. relevant part of the name of the corresponding constraint)
   * current = name of second policy to consider (i.e. relevant part of the name of the corresponding constraint)
   * P_name = name of the represented policy (i.e. part of the name of the generated constraint)
   * IsFirst = signal the first combination (i.e. it needed to initialize the constraint name)
   * IsFinal = true== the last step of the combination -> the constraint name contains _final_
   */
  public String getCombination(final String prev, final String current, final String p_name, final Boolean isFirst, final Boolean isFinal) {
    StringBuffer str = new StringBuffer();
    String cns_name = null;
    if ((isFinal).booleanValue()) {
      cns_name = "final";
    } else {
      cns_name = (prev + current);
    }
    str.append((((("(define-fun cns_" + p_name) + "_cmb_") + cns_name) + "_permit () Bool\n"));
    String _combinationPermit = this.getCombinationPermit(prev, current, p_name, isFirst);
    str.append(_combinationPermit);
    str.append(")\n\n");
    str.append((((("(define-fun cns_" + p_name) + "_cmb_") + cns_name) + "_deny () Bool\n"));
    String _combinationDeny = this.getCombinationDeny(prev, current, p_name, isFirst);
    str.append(_combinationDeny);
    str.append(")\n\n");
    str.append((((("(define-fun cns_" + p_name) + "_cmb_") + cns_name) + "_notApp () Bool\n"));
    String _combinationNotApp = this.getCombinationNotApp(prev, current, p_name, isFirst);
    str.append(_combinationNotApp);
    str.append(")\n\n");
    str.append((((("(define-fun cns_" + p_name) + "_cmb_") + cns_name) + "_indet () Bool\n"));
    String _combinationIndet = this.getCombinationIndet(prev, current, p_name, isFirst);
    str.append(_combinationIndet);
    str.append(")\n\n");
    return str.toString();
  }
  
  /**
   * Return the name of the referred or defined policy
   */
  public String getPolName(final int index, final PolicySet p) {
    EList<AbstractPolicyIncl> _policies = p.getPolicies();
    AbstractPolicyIncl _get = _policies.get(index);
    PolicySet _refPol = _get.getRefPol();
    boolean _notEquals = (!Objects.equal(_refPol, null));
    if (_notEquals) {
      EList<AbstractPolicyIncl> _policies_1 = p.getPolicies();
      AbstractPolicyIncl _get_1 = _policies_1.get(index);
      PolicySet _refPol_1 = _get_1.getRefPol();
      return _refPol_1.getName();
    } else {
      EList<AbstractPolicyIncl> _policies_2 = p.getPolicies();
      AbstractPolicyIncl _get_2 = _policies_2.get(index);
      FacplPolicy _newPolicy = _get_2.getNewPolicy();
      return _newPolicy.getName();
    }
  }
  
  /**
   * Abstract Methods modeling the different combinations due to each combining algorithm
   */
  public abstract String getCombinationPermit(final String prev, final String current, final String p_name, final Boolean isFirst);
  
  public abstract String getCombinationDeny(final String prev, final String current, final String p_name, final Boolean isFirst);
  
  public abstract String getCombinationNotApp(final String prev, final String current, final String p_name, final Boolean isFirst);
  
  public abstract String getCombinationIndet(final String prev, final String current, final String p_name, final Boolean isFirst);
  
  /**
   * ################
   * DEFAULT CASE: only one policy to combine
   * ################
   */
  public CharSequence getDefaultCase(final String pSet_name, final String r_name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(define-fun cns_");
    _builder.append(pSet_name, "");
    _builder.append("_cmb_final_permit () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _defaultCombinationPermit = this.getDefaultCombinationPermit(r_name);
    _builder.append(_defaultCombinationPermit, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    _builder.newLine();
    _builder.append("(define-fun cns_");
    _builder.append(pSet_name, "");
    _builder.append("_cmb_final_deny () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _defaultCombinationDeny = this.getDefaultCombinationDeny(r_name);
    _builder.append(_defaultCombinationDeny, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    _builder.newLine();
    _builder.append("(define-fun cns_");
    _builder.append(pSet_name, "");
    _builder.append("_cmb_final_notApp () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _defaultCombinationNotApp = this.getDefaultCombinationNotApp(r_name);
    _builder.append(_defaultCombinationNotApp, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    _builder.newLine();
    _builder.append("(define-fun cns_");
    _builder.append(pSet_name, "");
    _builder.append("_cmb_final_indet () Bool");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _defaultCombinationIndet = this.getDefaultCombinationIndet(r_name);
    _builder.append(_defaultCombinationIndet, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Abstract Methods modeling the different combinations due to each combining algorithm
   */
  public abstract String getDefaultCombinationPermit(final String r_name);
  
  public abstract String getDefaultCombinationDeny(final String r_name);
  
  public abstract String getDefaultCombinationNotApp(final String r_name);
  
  public abstract String getDefaultCombinationIndet(final String r_name);
}
