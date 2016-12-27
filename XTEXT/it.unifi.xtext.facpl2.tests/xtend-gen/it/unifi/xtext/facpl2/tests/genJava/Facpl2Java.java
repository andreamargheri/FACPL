package it.unifi.xtext.facpl2.tests.genJava;

import com.google.inject.Inject;
import it.unifi.xtext.facpl.Facpl2InjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(Facpl2InjectorProvider.class)
@SuppressWarnings("all")
public class Facpl2Java {
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void testRefAlgClasses() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pName { permit-overrides-greedy ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule rule1 (deny) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder, _function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pName { deny-overrides-greedy ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule rule1 (deny) ");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_1 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_1, _function_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("PolicySet pName {permit-unless-deny-greedy ");
      _builder_2.newLine();
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Rule rule1 (deny) ");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_2 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_2, _function_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("PolicySet pName {deny-unless-permit-greedy ");
      _builder_3.newLine();
      _builder_3.append("policies:");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("Rule rule1 (deny) ");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_3 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_3, _function_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("PolicySet pName {first-applicable-greedy ");
      _builder_4.newLine();
      _builder_4.append("policies:");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("Rule rule1 (deny) ");
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_4 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_4, _function_4);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("PolicySet pName {only-one-applicable-greedy ");
      _builder_5.newLine();
      _builder_5.append("policies:");
      _builder_5.newLine();
      _builder_5.append("\t");
      _builder_5.append("Rule rule1 (deny) ");
      _builder_5.newLine();
      _builder_5.append("}");
      _builder_5.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_5 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_5, _function_5);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("PolicySet pName {strong-consensus-greedy ");
      _builder_6.newLine();
      _builder_6.append("policies:");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("Rule rule1 (deny) ");
      _builder_6.newLine();
      _builder_6.append("}");
      _builder_6.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_6 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_6, _function_6);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("PolicySet pName {week-consensus-greedy ");
      _builder_7.newLine();
      _builder_7.append("policies:");
      _builder_7.newLine();
      _builder_7.append("\t");
      _builder_7.append("Rule rule1 (deny) ");
      _builder_7.newLine();
      _builder_7.append("}");
      _builder_7.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_7 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_7, _function_7);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("PolicySet pName { permit-overrides-all ");
      _builder_8.newLine();
      _builder_8.append("policies:");
      _builder_8.newLine();
      _builder_8.append("\t");
      _builder_8.append("Rule rule1 (deny) ");
      _builder_8.newLine();
      _builder_8.append("}");
      _builder_8.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_8 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_8, _function_8);
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("PolicySet pName { deny-overrides-all ");
      _builder_9.newLine();
      _builder_9.append("policies:");
      _builder_9.newLine();
      _builder_9.append("\t");
      _builder_9.append("Rule rule1 (deny) ");
      _builder_9.newLine();
      _builder_9.append("}");
      _builder_9.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_9 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_9, _function_9);
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("PolicySet pName {permit-unless-deny-all ");
      _builder_10.newLine();
      _builder_10.append("policies:");
      _builder_10.newLine();
      _builder_10.append("\t");
      _builder_10.append("Rule rule1 (deny) ");
      _builder_10.newLine();
      _builder_10.append("}");
      _builder_10.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_10 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_10, _function_10);
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append("PolicySet pName {deny-unless-permit-all ");
      _builder_11.newLine();
      _builder_11.append("policies:");
      _builder_11.newLine();
      _builder_11.append("\t");
      _builder_11.append("Rule rule1 (deny) ");
      _builder_11.newLine();
      _builder_11.append("}");
      _builder_11.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_11 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_11, _function_11);
      StringConcatenation _builder_12 = new StringConcatenation();
      _builder_12.append("PolicySet pName {first-applicable-all ");
      _builder_12.newLine();
      _builder_12.append("policies:");
      _builder_12.newLine();
      _builder_12.append("\t");
      _builder_12.append("Rule rule1 (deny) ");
      _builder_12.newLine();
      _builder_12.append("}");
      _builder_12.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_12 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_12, _function_12);
      StringConcatenation _builder_13 = new StringConcatenation();
      _builder_13.append("PolicySet pName {only-one-applicable-all ");
      _builder_13.newLine();
      _builder_13.append("policies:");
      _builder_13.newLine();
      _builder_13.append("\t");
      _builder_13.append("Rule rule1 (deny) ");
      _builder_13.newLine();
      _builder_13.append("}");
      _builder_13.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_13 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_13, _function_13);
      StringConcatenation _builder_14 = new StringConcatenation();
      _builder_14.append("PolicySet pName {strong-consensus-all ");
      _builder_14.newLine();
      _builder_14.append("policies:");
      _builder_14.newLine();
      _builder_14.append("\t");
      _builder_14.append("Rule rule1 (deny) ");
      _builder_14.newLine();
      _builder_14.append("}");
      _builder_14.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_14 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_14, _function_14);
      StringConcatenation _builder_15 = new StringConcatenation();
      _builder_15.append("PolicySet pName {week-consensus-all ");
      _builder_15.newLine();
      _builder_15.append("policies:");
      _builder_15.newLine();
      _builder_15.append("\t");
      _builder_15.append("Rule rule1 (deny) ");
      _builder_15.newLine();
      _builder_15.append("}");
      _builder_15.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_15 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_15, _function_15);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkRuleDecl() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pName {permit-overrides ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule rule1 (permit)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule rule2 (permit)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule rule3 (permit)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule rule4 (permit)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkPDP_PEP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Request:{ Name ( action / id , \"READ\" ) }");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("PolicySet pName {permit-overrides ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Rule rule1 (permit)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("PAS { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Extended Indeterminate : false ;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Java Package : \"foo\" ;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Requests To Evaluate : Name ;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("pep: deny-biased");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("pdp: permit-unless-deny");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("include pName");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder, _function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Request:{ Name ( action / id , \"READ\" ) }");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("PolicySet pName {permit-overrides ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("Rule rule1 (permit)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("PAS { ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Extended Indeterminate : false ;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Java Package : \"foo\" ;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Requests To Evaluate : Name ;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("pep: deny-biased");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("pdp: permit-unless-deny");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("include pName");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule r1 (permit)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("PolicySet pName1 {permit-overrides ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("Rule rule1 (permit)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_1 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_1, _function_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Request:{ Name ( action / id , \"READ\" ) }");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("PolicySet pName {permit-overrides ");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("policies:");
      _builder_2.newLine();
      _builder_2.append("\t\t\t");
      _builder_2.append("Rule rule1 (permit)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("PAS { ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Extended Indeterminate : false ;");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Java Package : \"foo\" ;");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Requests To Evaluate : Name ;");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("pep: deny-biased");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("pdp: permit-unless-deny");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("include pName");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("Rule r1 (permit)");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_2 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_2, _function_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testObligation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("PolicySet pName { permit-overrides-greedy ");
      _builder.newLine();
      _builder.append("policies:");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Rule rule1 (deny obl: (M log()) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder, _function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("PolicySet pName { permit-overrides-greedy ");
      _builder_1.newLine();
      _builder_1.append("policies:");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Rule rule1 (deny obl: (M log())");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("obl-p: (M log())");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("obl-d: (O log()) ");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function_1 = (CompilationTestHelper.Result it) -> {
        it.getCompiledClass();
      };
      this._compilationTestHelper.compile(_builder_1, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
