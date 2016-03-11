package it.unifi.xtext.facpl.generator.generators.smt.algorithms;

import it.unifi.xtext.facpl.generator.generators.SMT_LIBGenerator_Alg;

@SuppressWarnings("all")
public class SMT_LIBGenerator_DenyUnless extends SMT_LIBGenerator_Alg {
  @Override
  public String getCombinationPermit(final String prev, final String current, final String p_name, final Boolean isFirst) {
    String n_cns = "";
    if ((!(isFirst).booleanValue())) {
      n_cns = (p_name + "_cmb_");
    }
    return ((((("\t (or cns_" + n_cns) + prev) + "_permit cns_") + current) + "_permit)\n");
  }
  
  @Override
  public String getCombinationDeny(final String prev, final String current, final String p_name, final Boolean isFirst) {
    String n_cns = "";
    if ((!(isFirst).booleanValue())) {
      n_cns = (p_name + "_cmb_");
    }
    final StringBuffer str = new StringBuffer();
    str.append("\t (and \n");
    str.append(((((("\t\t (and (not cns_" + n_cns) + prev) + "_permit) (not cns_") + current) + "_permit))\n"));
    str.append(((((((((("\t\t (or cns_" + n_cns) + prev) + "_deny cns_") + n_cns) + prev) + "_notApp cns_") + n_cns) + prev) + "_indet)\n"));
    str.append((((((("\t\t (or cns_" + current) + "_deny cns_") + current) + "_notApp cns_") + current) + "_indet)\n"));
    str.append("\t )\n");
    return str.toString();
  }
  
  @Override
  public String getCombinationNotApp(final String prev, final String current, final String p_name, final Boolean isFirst) {
    return "false";
  }
  
  @Override
  public String getCombinationIndet(final String prev, final String current, final String p_name, final Boolean isFirst) {
    return "false";
  }
  
  /**
   * DEFAULT CASES
   */
  @Override
  public String getDefaultCombinationPermit(final String r_name) {
    return (("cns_" + r_name) + "_permit");
  }
  
  @Override
  public String getDefaultCombinationDeny(final String r_name) {
    final StringBuffer str = new StringBuffer();
    str.append("\t(and \n");
    str.append((("\t\t (not cns_" + r_name) + "_permit)\n"));
    str.append((((((("\t\t (or cns_" + r_name) + "_deny (or cns_") + r_name) + "_notApp cns_") + r_name) + "_indet)))"));
    return str.toString();
  }
  
  @Override
  public String getDefaultCombinationNotApp(final String r_name) {
    return "false";
  }
  
  @Override
  public String getDefaultCombinationIndet(final String r_name) {
    return "false";
  }
}
