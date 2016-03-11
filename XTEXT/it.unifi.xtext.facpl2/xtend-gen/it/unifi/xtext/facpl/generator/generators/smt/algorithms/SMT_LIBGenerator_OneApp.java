package it.unifi.xtext.facpl.generator.generators.smt.algorithms;

import it.unifi.xtext.facpl.generator.generators.SMT_LIBGenerator_Alg;

@SuppressWarnings("all")
public class SMT_LIBGenerator_OneApp extends SMT_LIBGenerator_Alg {
  @Override
  public String getCombinationPermit(final String prev, final String current, final String p_name, final Boolean isFirst) {
    String n_cns = "";
    if ((!(isFirst).booleanValue())) {
      n_cns = (p_name + "_cmb_");
    }
    return (((((((((("\t (or (and cns_" + n_cns) + prev) + "_permit cns_") + current) + "_notApp) (and cns_") + n_cns) + prev) + "_notApp cns_") + current) + "_permit))\n");
  }
  
  @Override
  public String getCombinationDeny(final String prev, final String current, final String p_name, final Boolean isFirst) {
    String n_cns = "";
    if ((!(isFirst).booleanValue())) {
      n_cns = (p_name + "_cmb_");
    }
    return (((((((((("\t (or (and cns_" + n_cns) + prev) + "_deny cns_") + current) + "_notApp) (and cns_") + n_cns) + prev) + "_notApp cns_") + current) + "_deny))\n");
  }
  
  @Override
  public String getCombinationNotApp(final String prev, final String current, final String p_name, final Boolean isFirst) {
    String n_cns = "";
    if ((!(isFirst).booleanValue())) {
      n_cns = (p_name + "_cmb_");
    }
    return ((((("\t (and cns_" + n_cns) + prev) + "_notApp cns_") + current) + "_notApp)\n");
  }
  
  @Override
  public String getCombinationIndet(final String prev, final String current, final String p_name, final Boolean isFirst) {
    String n_cns = "";
    if ((!(isFirst).booleanValue())) {
      n_cns = (p_name + "_cmb_");
    }
    final StringBuffer str = new StringBuffer();
    str.append("\t (or \n ");
    str.append(((((("\t\t cns_" + n_cns) + prev) + "_indet \n\t\t cns_") + current) + "_indet \n"));
    str.append("\t\t (and \n");
    str.append((((((("\t\t\t (or cns_" + n_cns) + prev) + "_permit cns_") + n_cns) + prev) + "_deny)\n"));
    str.append((((("\t\t\t (or cns_" + current) + "_permit cns_") + current) + "_deny)"));
    str.append("\t\t )");
    str.append(")");
    return str.toString();
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
    return (("cns_" + r_name) + "_deny");
  }
  
  @Override
  public String getDefaultCombinationNotApp(final String r_name) {
    return (("cns_" + r_name) + "_notApp");
  }
  
  @Override
  public String getDefaultCombinationIndet(final String r_name) {
    return (("cns_" + r_name) + "_indet");
  }
}
