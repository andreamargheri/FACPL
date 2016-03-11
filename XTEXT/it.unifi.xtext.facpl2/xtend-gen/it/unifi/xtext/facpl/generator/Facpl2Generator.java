package it.unifi.xtext.facpl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import it.unifi.xtext.facpl.Facpl2StandaloneSetup;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Alg;
import it.unifi.xtext.facpl.facpl2.AlgLiteral;
import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DeclaredFunction;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Effect;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.FulfillmentStrategy;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration;
import it.unifi.xtext.facpl.facpl2.Import;
import it.unifi.xtext.facpl.facpl2.IntLiteral;
import it.unifi.xtext.facpl.facpl2.MainFacpl;
import it.unifi.xtext.facpl.facpl2.NotExpression;
import it.unifi.xtext.facpl.facpl2.Obligation;
import it.unifi.xtext.facpl.facpl2.OrExpression;
import it.unifi.xtext.facpl.facpl2.PAF;
import it.unifi.xtext.facpl.facpl2.PDP;
import it.unifi.xtext.facpl.facpl2.PEPAlg;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.facpl2.Rule;
import it.unifi.xtext.facpl.facpl2.Set;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TimeLiteral;
import it.unifi.xtext.facpl.facpl2.TypeLiteral;
import it.unifi.xtext.facpl.facpl2.funID;
import it.unifi.xtext.facpl.generator.generators.Facpl2Generator_Name;
import it.unifi.xtext.facpl.generator.xtendUtil;
import it.unifi.xtext.facpl.validation.FacplType;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.XtextResourceSet;

@SuppressWarnings("all")
public class Facpl2Generator implements IGenerator {
  protected String packageFolder = "";
  
  protected String packageName = "";
  
  protected static URI path;
  
  protected static StringBuffer projectPath;
  
  protected static String personalAlg = "CustomCombingAlg";
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    EList<EObject> _contents = resource.getContents();
    Iterable<Facpl> _filter = Iterables.<Facpl>filter(_contents, Facpl.class);
    for (final Facpl e : _filter) {
      {
        URI _uRI = resource.getURI();
        Facpl2Generator.path = _uRI;
        StringBuffer _stringBuffer = new StringBuffer();
        Facpl2Generator.projectPath = _stringBuffer;
        int count = 1;
        List<String> _segmentsList = Facpl2Generator.path.segmentsList();
        for (final String f : _segmentsList) {
          {
            if ((count != 1)) {
              List<String> _segmentsList_1 = Facpl2Generator.path.segmentsList();
              int _size = _segmentsList_1.size();
              boolean _notEquals = (count != _size);
              if (_notEquals) {
                Facpl2Generator.projectPath.append((f + "/"));
              }
            }
            count = (count + 1);
          }
        }
        MainFacpl _main = e.getMain();
        boolean _notEquals = (!Objects.equal(_main, null));
        if (_notEquals) {
          boolean _and = false;
          MainFacpl _main_1 = e.getMain();
          String _genPackage = _main_1.getGenPackage();
          boolean _notEquals_1 = (!Objects.equal(_genPackage, null));
          if (!_notEquals_1) {
            _and = false;
          } else {
            MainFacpl _main_2 = e.getMain();
            String _genPackage_1 = _main_2.getGenPackage();
            boolean _notEquals_2 = (!Objects.equal(_genPackage_1, ""));
            _and = _notEquals_2;
          }
          if (_and) {
            MainFacpl _main_3 = e.getMain();
            String name = _main_3.getGenPackage();
            int _length = name.length();
            int _minus = (_length - 1);
            char _charAt = name.charAt(_minus);
            boolean _equals = Objects.equal(Character.valueOf(_charAt), "/");
            if (_equals) {
              MainFacpl _main_4 = e.getMain();
              String _genPackage_2 = _main_4.getGenPackage();
              this.packageFolder = _genPackage_2;
            } else {
              MainFacpl _main_5 = e.getMain();
              String _genPackage_3 = _main_5.getGenPackage();
              String _plus = (_genPackage_3 + "/");
              this.packageFolder = _plus;
            }
            String _replace = this.packageFolder.replace("/", ".");
            this.packageName = _replace;
            int _length_1 = this.packageName.length();
            int _minus_1 = (_length_1 - 1);
            String _substring = this.packageName.substring(0, _minus_1);
            String _plus_1 = (_substring + ";");
            this.packageName = _plus_1;
          }
        }
        EList<Request> _requests = e.getRequests();
        boolean _notEquals_3 = (!Objects.equal(_requests, null));
        if (_notEquals_3) {
          EList<Request> _requests_1 = e.getRequests();
          for (final Request r : _requests_1) {
            String _name = r.getName();
            String _plus_2 = ((this.packageFolder + "ContextRequest_") + _name);
            String _plus_3 = (_plus_2 + ".java");
            CharSequence _compileRequest = this.compileRequest(r);
            fsa.generateFile(_plus_3, _compileRequest);
          }
        }
        EList<Import> _importEl = e.getImportEl();
        boolean _notEquals_4 = (!Objects.equal(_importEl, null));
        if (_notEquals_4) {
          EList<Import> _importEl_1 = e.getImportEl();
          for (final Import i : _importEl_1) {
            {
              Facpl2StandaloneSetup _facpl2StandaloneSetup = new Facpl2StandaloneSetup();
              Injector injector = _facpl2StandaloneSetup.createInjectorAndDoEMFRegistration();
              Class<XtextResourceSet> _classXtext = xtendUtil.getClassXtext();
              XtextResourceSet set = injector.<XtextResourceSet>getInstance(_classXtext);
              String _importURI = i.getImportURI();
              String _plus_4 = (Facpl2Generator.projectPath + _importURI);
              URI uri = URI.createPlatformResourceURI(_plus_4, true);
              set.createResource(uri);
              Resource res = set.getResource(uri, true);
              this.doGenerate(res, fsa);
            }
          }
        }
        EList<PolicySet> _policies = e.getPolicies();
        boolean _notEquals_5 = (!Objects.equal(_policies, null));
        if (_notEquals_5) {
          EList<PolicySet> _policies_1 = e.getPolicies();
          for (final PolicySet pol : _policies_1) {
            String _nameFacplPolicy = this.getNameFacplPolicy(pol);
            String _plus_4 = (this.packageFolder + _nameFacplPolicy);
            String _plus_5 = (_plus_4 + ".java");
            CharSequence _compilePolicy = this.compilePolicy(pol, fsa);
            fsa.generateFile(_plus_5, _compilePolicy);
          }
        }
        EList<FunctionDeclaration> _declarations = e.getDeclarations();
        boolean _notEquals_6 = (!Objects.equal(_declarations, null));
        if (_notEquals_6) {
          EList<FunctionDeclaration> _declarations_1 = e.getDeclarations();
          for (final FunctionDeclaration dec : _declarations_1) {
            String _name_1 = dec.getName();
            String _nameFunction = this.getNameFunction(_name_1);
            String _plus_6 = (this.packageFolder + _nameFunction);
            String _plus_7 = (_plus_6 + ".java");
            CharSequence _compileFunction = this.compileFunction(dec);
            fsa.generateFile(_plus_7, _compileFunction);
          }
        }
        MainFacpl _main_6 = e.getMain();
        boolean _notEquals_7 = (!Objects.equal(_main_6, null));
        if (_notEquals_7) {
          MainFacpl _main_7 = e.getMain();
          CharSequence _compileMain = this.compileMain(_main_7, fsa);
          fsa.generateFile((this.packageFolder + "MainFACPL.java"), _compileMain);
          CharSequence _compilePEPAction = this.compilePEPAction();
          fsa.generateFile((this.packageFolder + "PEPAction.java"), _compilePEPAction);
        }
      }
    }
  }
  
  /**
   * Create an specific context stub given as input
   */
  public void doGenerate_ExternalContext(final Resource resource, final IFileSystemAccess fsa, final String external_contextStub) {
    this.doGenerate(resource, fsa);
    EList<EObject> _contents = resource.getContents();
    Iterable<Facpl> _filter = Iterables.<Facpl>filter(_contents, Facpl.class);
    for (final Facpl e : _filter) {
      EList<Request> _requests = e.getRequests();
      boolean _notEquals = (!Objects.equal(_requests, null));
      if (_notEquals) {
        fsa.generateFile((this.packageFolder + "ContextStub_Default.java"), external_contextStub);
      }
    }
  }
  
  public CharSequence compileMain(final MainFacpl main, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.packageName, ""));
      if (_notEquals) {
        _builder.append("package ");
        _builder.append(this.packageName, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.policy.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.system.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.context.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.interfaces.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.enums.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.util.*;");
    _builder.newLine();
    _builder.append("import java.lang.reflect.Method;");
    _builder.newLine();
    _builder.append("import java.util.LinkedList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class MainFACPL{");
    _builder.newLine();
    _builder.append("\t \t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PDP pdp;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private PEP pep;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public MainFACPL() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// defined list of policies included in the PDP");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LinkedList<FacplPolicy> policies = new LinkedList<FacplPolicy>();");
    _builder.newLine();
    {
      PAF _paf = main.getPaf();
      PDP _pdp = _paf.getPdp();
      EList<AbstractPolicyIncl> _polSet = _pdp.getPolSet();
      for(final AbstractPolicyIncl p : _polSet) {
        _builder.append("\t\t");
        _builder.append("policies.add(new ");
        {
          PolicySet _refPol = p.getRefPol();
          boolean _equals = Objects.equal(_refPol, null);
          if (_equals) {
            FacplPolicy _newPolicy = p.getNewPolicy();
            String _nameFacplPolicy = this.getNameFacplPolicy(_newPolicy);
            _builder.append(_nameFacplPolicy, "\t\t");
          } else {
            PolicySet _refPol_1 = p.getRefPol();
            String _nameFacplPolicy_1 = this.getNameFacplPolicy(_refPol_1);
            _builder.append(_nameFacplPolicy_1, "\t\t");
          }
        }
        _builder.append("()); ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("this.pdp = new PDP(");
    PAF _paf_1 = main.getPaf();
    PDP _pdp_1 = _paf_1.getPdp();
    Alg _pdpAlg = _pdp_1.getPdpAlg();
    AlgLiteral _idAlg = _pdpAlg.getIdAlg();
    String _algName = this.getAlgName(_idAlg, fsa);
    _builder.append(_algName, "\t\t");
    {
      PAF _paf_2 = main.getPaf();
      PDP _pdp_2 = _paf_2.getPdp();
      Alg _pdpAlg_1 = _pdp_2.getPdpAlg();
      FulfillmentStrategy _fStrategy = _pdpAlg_1.getFStrategy();
      boolean _notEquals_1 = (!Objects.equal(_fStrategy, null));
      if (_notEquals_1) {
        {
          PAF _paf_3 = main.getPaf();
          PDP _pdp_3 = _paf_3.getPdp();
          Alg _pdpAlg_2 = _pdp_3.getPdpAlg();
          FulfillmentStrategy _fStrategy_1 = _pdpAlg_2.getFStrategy();
          boolean _equals_1 = _fStrategy_1.equals(FulfillmentStrategy.GREEDY);
          if (_equals_1) {
            _builder.append("Greedy");
          }
        }
      }
    }
    _builder.append(".class, policies, ");
    {
      BooleanLiteral _extIndet = main.getExtIndet();
      boolean _notEquals_2 = (!Objects.equal(_extIndet, null));
      if (_notEquals_2) {
        BooleanLiteral _extIndet_1 = main.getExtIndet();
        Object _expression = this.getExpression(_extIndet_1);
        _builder.append(_expression, "\t\t");
      } else {
        _builder.append("false");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.pep = new PEP(EnforcementAlgorithm.");
    PAF _paf_4 = main.getPaf();
    PEPAlg _pep = _paf_4.getPep();
    String _literal = _pep.getLiteral();
    String _replace = _literal.replace("-", "_");
    String _upperCase = _replace.toUpperCase();
    _builder.append(_upperCase, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.pep.addPEPActions(PEPAction.getPepActions());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*ENTRY POINT FOR EVALUATION");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//Initialise Authorisation System");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MainFACPL system = new MainFACPL();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//log");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("StringBuffer result = new StringBuffer();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//request");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LinkedList<ContextRequest> requests = new LinkedList<ContextRequest>();");
    _builder.newLine();
    {
      EList<Request> _refRequest = main.getRefRequest();
      for(final Request r : _refRequest) {
        _builder.append("\t\t");
        _builder.append("requests.add(ContextRequest_");
        String _name = r.getName();
        _builder.append(_name, "\t\t");
        _builder.append(".getContextReq());");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("for (ContextRequest rcxt : requests) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("result.append(\"---------------------------------------------------\\n\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("AuthorisationPDP resPDP = system.pdp.doAuthorisation(rcxt);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("result.append(\"Request: \"+ resPDP.getId() + \"\\n\\n\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("result.append(\"PDP Decision=\\n \" + resPDP.toString()+\"\\n\\n\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("//enforce decision");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("AuthorisationPEP resPEP = system.pep.doEnforcement(resPDP);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("result.append(\"PEP Decision=\\n \" + resPEP.toString()+\"\\n\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("result.append(\"---------------------------------------------------\\n\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(result.toString());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//ShowResult.showResult(result);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      PAF _paf_5 = main.getPaf();
      PDP _pdp_4 = _paf_5.getPdp();
      EList<AbstractPolicyIncl> _polSet_1 = _pdp_4.getPolSet();
      for(final AbstractPolicyIncl p_1 : _polSet_1) {
        {
          FacplPolicy _newPolicy_1 = p_1.getNewPolicy();
          boolean _notEquals_3 = (!Objects.equal(_newPolicy_1, null));
          if (_notEquals_3) {
            {
              FacplPolicy _newPolicy_2 = p_1.getNewPolicy();
              if ((_newPolicy_2 instanceof PolicySet)) {
                _builder.append("\t");
                FacplPolicy _newPolicy_3 = p_1.getNewPolicy();
                String _nameFacplPolicy_2 = this.getNameFacplPolicy(_newPolicy_3);
                String _plus = (this.packageFolder + _nameFacplPolicy_2);
                String _plus_1 = (_plus + ".java");
                FacplPolicy _newPolicy_4 = p_1.getNewPolicy();
                CharSequence _compilePolicy = this.compilePolicy(_newPolicy_4, fsa);
                fsa.generateFile(_plus_1, _compilePolicy);
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                FacplPolicy _newPolicy_5 = p_1.getNewPolicy();
                CharSequence _compilePolicy_1 = this.compilePolicy(((Rule) _newPolicy_5), fsa);
                _builder.append(_compilePolicy_1, "\t");
                _builder.append("\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public PDP getPdp() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return pdp;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public PEP getPep() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return pep;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compilePEPAction() {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.packageName, ""));
      if (_notEquals) {
        _builder.append("package ");
        _builder.append(this.packageName, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.interfaces.IPepAction;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class PEPAction{");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public static HashMap<String, Class<? extends IPepAction>> getPepActions() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* Set your own pep action e.g. HashMap<String,Class<? extends");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* IPepAction>> pepAction = new HashMap<String,Class<? extends");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* IPepAction>>(); pepAction.put(\"action\", Action.class); return");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("* pepAction;");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected String _getNameFacplPolicy(final PolicySet policyS) {
    String _name = policyS.getName();
    return ("PolicySet_" + _name);
  }
  
  protected String _getNameFacplPolicy(final Rule rule) {
    String _name = rule.getName();
    return ("Rule_" + _name);
  }
  
  protected CharSequence _compilePolicy(final PolicySet pol, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.packageName, ""));
      if (_notEquals) {
        _builder.append("package ");
        _builder.append(this.packageName, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.policy.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.enums.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.util.*;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")\t");
    _builder.newLine();
    _builder.append("public class ");
    String _nameFacplPolicy = this.getNameFacplPolicy(pol);
    _builder.append(_nameFacplPolicy, "");
    _builder.append(" extends PolicySet {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    String _nameFacplPolicy_1 = this.getNameFacplPolicy(pol);
    _builder.append(_nameFacplPolicy_1, "\t");
    _builder.append("(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("addId(\"");
    String _name = pol.getName();
    _builder.append(_name, "\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("//Algorithm Combining");
    _builder.newLine();
    _builder.append("\t\t");
    Alg _polSetAlg = pol.getPolSetAlg();
    CharSequence _compileAlg = this.compileAlg(_polSetAlg, fsa);
    _builder.append(_compileAlg, "\t\t");
    _builder.newLineIfNotEmpty();
    {
      Expression _target = pol.getTarget();
      boolean _notEquals_1 = (!Objects.equal(_target, null));
      if (_notEquals_1) {
        _builder.append("\t\t");
        _builder.append("//Target");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("addTarget(");
        Expression _target_1 = pol.getTarget();
        Object _expression = this.getExpression(_target_1);
        _builder.append(_expression, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("//PolElements");
    _builder.newLine();
    {
      EList<AbstractPolicyIncl> _policies = pol.getPolicies();
      for(final AbstractPolicyIncl p : _policies) {
        _builder.append("\t\t");
        _builder.append("addPolicyElement(new ");
        {
          PolicySet _refPol = p.getRefPol();
          boolean _equals = Objects.equal(_refPol, null);
          if (_equals) {
            FacplPolicy _newPolicy = p.getNewPolicy();
            String _nameFacplPolicy_2 = this.getNameFacplPolicy(_newPolicy);
            _builder.append(_nameFacplPolicy_2, "\t\t");
          } else {
            PolicySet _refPol_1 = p.getRefPol();
            String _nameFacplPolicy_3 = this.getNameFacplPolicy(_refPol_1);
            _builder.append(_nameFacplPolicy_3, "\t\t");
          }
        }
        _builder.append("());");
        _builder.newLineIfNotEmpty();
        {
          PolicySet _refPol_2 = p.getRefPol();
          boolean _equals_1 = Objects.equal(_refPol_2, null);
          if (_equals_1) {
            {
              FacplPolicy _newPolicy_1 = p.getNewPolicy();
              if ((_newPolicy_1 instanceof PolicySet)) {
                _builder.append("\t\t");
                FacplPolicy _newPolicy_2 = p.getNewPolicy();
                String _nameFacplPolicy_4 = this.getNameFacplPolicy(_newPolicy_2);
                String _plus = (this.packageFolder + _nameFacplPolicy_4);
                String _plus_1 = (_plus + ".java");
                FacplPolicy _newPolicy_3 = p.getNewPolicy();
                CharSequence _compilePolicy = this.compilePolicy(_newPolicy_3, fsa);
                fsa.generateFile(_plus_1, _compilePolicy);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("//Obligation");
    _builder.newLine();
    {
      EList<Obligation> _obl = pol.getObl();
      for(final Obligation o : _obl) {
        _builder.append("\t\t");
        _builder.append("addObligation(");
        CharSequence _compileObligation = this.compileObligation(o);
        _builder.append(_compileObligation, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<AbstractPolicyIncl> _policies_1 = pol.getPolicies();
      for(final AbstractPolicyIncl p_1 : _policies_1) {
        {
          FacplPolicy _newPolicy_4 = p_1.getNewPolicy();
          boolean _notEquals_2 = (!Objects.equal(_newPolicy_4, null));
          if (_notEquals_2) {
            {
              FacplPolicy _newPolicy_5 = p_1.getNewPolicy();
              if ((_newPolicy_5 instanceof Rule)) {
                _builder.append("\t\t");
                FacplPolicy _newPolicy_6 = p_1.getNewPolicy();
                CharSequence _compilePolicy_1 = this.compilePolicy(((Rule) _newPolicy_6), fsa);
                _builder.append(_compilePolicy_1, "\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _compilePolicy(final Rule rule, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private class ");
    String _nameFacplPolicy = this.getNameFacplPolicy(rule);
    _builder.append(_nameFacplPolicy, "");
    _builder.append(" extends Rule {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    String _nameFacplPolicy_1 = this.getNameFacplPolicy(rule);
    _builder.append(_nameFacplPolicy_1, "\t\t");
    _builder.append(" (){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("addId(\"");
    String _name = rule.getName();
    _builder.append(_name, "\t\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("//Effect");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("addEffect(Effect.");
    Effect _effect = rule.getEffect();
    String _name_1 = _effect.getName();
    _builder.append(_name_1, "\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      Expression _target = rule.getTarget();
      boolean _notEquals = (!Objects.equal(_target, null));
      if (_notEquals) {
        _builder.append("\t\t\t");
        _builder.append("//Target");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("addTarget(");
        Expression _target_1 = rule.getTarget();
        Object _expression = this.getExpression(_target_1);
        _builder.append(_expression, "\t\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("//Obligations");
    _builder.newLine();
    {
      EList<Obligation> _obl = rule.getObl();
      for(final Obligation o : _obl) {
        _builder.append("\t\t\t");
        _builder.append("addObligation(");
        CharSequence _compileObligation = this.compileObligation(o);
        _builder.append(_compileObligation, "\t\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileObligation(final Obligation obl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Obligation(\"");
    String _pepAction = obl.getPepAction();
    _builder.append(_pepAction, "");
    _builder.append("\",Effect.");
    Effect _evaluetedOn = obl.getEvaluetedOn();
    String _name = _evaluetedOn.getName();
    _builder.append(_name, "");
    _builder.append(",ObligationType.");
    String _typeObl = obl.getTypeObl();
    _builder.append(_typeObl, "");
    _builder.append(",");
    EList<Expression> _expr = obl.getExpr();
    CharSequence _oblExpression = this.getOblExpression(_expr);
    _builder.append(_oblExpression, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence getOblExpression(final EList<Expression> list) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      boolean _equals = Objects.equal(list, null);
      if (_equals) {
        _or = true;
      } else {
        int _size = list.size();
        boolean _equals_1 = (_size == 0);
        _or = _equals_1;
      }
      if (_or) {
        _builder.append("null");
        _builder.newLine();
      } else {
        {
          boolean _hasElements = false;
          for(final Expression e : list) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            Object _expression = this.getExpression(e);
            _builder.append(_expression, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected Object _getExpression(final AndExpression exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ExpressionBooleanTree(ExprBooleanConnector.AND,new ExpressionBooleanTree(");
    Expression _left = exp.getLeft();
    Object _expression = this.getExpression(_left);
    _builder.append(_expression, "");
    _builder.append("),new ExpressionBooleanTree(");
    Expression _right = exp.getRight();
    Object _expression_1 = this.getExpression(_right);
    _builder.append(_expression_1, "");
    _builder.append("))");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected Object _getExpression(final OrExpression exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ExpressionBooleanTree(ExprBooleanConnector.OR,new ExpressionBooleanTree(");
    Expression _left = exp.getLeft();
    Object _expression = this.getExpression(_left);
    _builder.append(_expression, "");
    _builder.append("),new ExpressionBooleanTree(");
    Expression _right = exp.getRight();
    Object _expression_1 = this.getExpression(_right);
    _builder.append(_expression_1, "");
    _builder.append("))");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected Object _getExpression(final NotExpression exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ExpressionBooleanTree(ExprBooleanConnector.NOT,new ExpressionBooleanTree(");
    Expression _arg = exp.getArg();
    Object _expression = this.getExpression(_arg);
    _builder.append(_expression, "");
    _builder.append("))");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected Object _getExpression(final Function exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ExpressionFunction(it.unifi.facpl.lib.function.");
    funID _functionId = exp.getFunctionId();
    String _funName = Facpl2Generator_Name.getFunName(_functionId);
    _builder.append(_funName, "");
    _builder.append(".class, ");
    Expression _arg1 = exp.getArg1();
    Object _expression = this.getExpression(_arg1);
    _builder.append(_expression, "");
    _builder.append(",");
    Expression _arg2 = exp.getArg2();
    Object _expression_1 = this.getExpression(_arg2);
    _builder.append(_expression_1, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected Object _getExpression(final DeclaredFunction exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ExpressionFunction(");
    FunctionDeclaration _functionId = exp.getFunctionId();
    String _name = _functionId.getName();
    String _nameFunction = this.getNameFunction(_name);
    _builder.append(_nameFunction, "");
    _builder.append(".class,");
    _builder.newLineIfNotEmpty();
    {
      EList<Expression> _args = exp.getArgs();
      int _size = _args.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        {
          EList<Expression> _args_1 = exp.getArgs();
          boolean _hasElements = false;
          for(final Expression arg : _args_1) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            Object _expression = this.getExpression(arg);
            _builder.append(_expression, "");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        _builder.append("null");
        _builder.newLine();
      }
    }
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }
  
  protected Object _getExpression(final IntLiteral e) {
    return Integer.valueOf(e.getValue());
  }
  
  protected Object _getExpression(final DoubleLiteral e) {
    return Double.valueOf(e.getValue());
  }
  
  protected Object _getExpression(final BooleanLiteral e) {
    return Boolean.valueOf(e.isValue());
  }
  
  protected Object _getExpression(final StringLiteral e) {
    String _value = e.getValue();
    String _plus = ("\"" + _value);
    return (_plus + "\"");
  }
  
  protected Object _getExpression(final TimeLiteral e) {
    String _value = e.getValue();
    String _plus = ("new FacplDate(\"" + _value);
    return (_plus + "\")");
  }
  
  protected Object _getExpression(final DateLiteral e) {
    String _value = e.getValue();
    String _plus = ("new FacplDate(\"" + _value);
    return (_plus + "\")");
  }
  
  protected Object _getExpression(final AttributeName attributeName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new AttributeName(\"");
    String _category = attributeName.getCategory();
    String _string = _category.toString();
    _builder.append(_string, "");
    _builder.append("\",\"");
    String _id = attributeName.getId();
    String _string_1 = _id.toString();
    _builder.append(_string_1, "");
    _builder.append("\") ");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected Object _getExpression(final Set Set) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Set(");
    _builder.newLine();
    {
      EList<Expression> _args = Set.getArgs();
      boolean _hasElements = false;
      for(final Expression b : _args) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        Object _expression = this.getExpression(b);
        _builder.append(_expression, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileAlg(final Alg alg, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    {
      AlgLiteral _idAlg = alg.getIdAlg();
      String _name = _idAlg.getName();
      String _string = _name.toString();
      boolean _equals = _string.equals("CUSTOM_ALG");
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("addCombiningAlg(");
        AlgLiteral _idAlg_1 = alg.getIdAlg();
        String _algName = this.getAlgName(_idAlg_1, fsa);
        _builder.append(_algName, "");
        {
          FulfillmentStrategy _fStrategy = alg.getFStrategy();
          boolean _notEquals = (!Objects.equal(_fStrategy, null));
          if (_notEquals) {
            {
              FulfillmentStrategy _fStrategy_1 = alg.getFStrategy();
              boolean _equals_1 = _fStrategy_1.equals(FulfillmentStrategy.GREEDY);
              if (_equals_1) {
                _builder.append("Greedy");
              }
            }
          }
        }
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("addCombiningAlg(");
        AlgLiteral _idAlg_2 = alg.getIdAlg();
        String _algName_1 = this.getAlgName(_idAlg_2, fsa);
        _builder.append(_algName_1, "");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String getAlgName(final AlgLiteral alg, final IFileSystemAccess fsa) {
    String _name = alg.getName();
    String _string = _name.toString();
    boolean _equals = _string.equals("DENY_OVER");
    if (_equals) {
      return "it.unifi.facpl.lib.algorithm.DenyOverrides";
    }
    String _name_1 = alg.getName();
    String _string_1 = _name_1.toString();
    boolean _equals_1 = _string_1.equals("PERMIT_OVER");
    if (_equals_1) {
      return "it.unifi.facpl.lib.algorithm.PermitOverrides";
    }
    String _name_2 = alg.getName();
    String _string_2 = _name_2.toString();
    boolean _equals_2 = _string_2.equals("FIRST");
    if (_equals_2) {
      return "it.unifi.facpl.lib.algorithm.FirstApplicable";
    }
    String _name_3 = alg.getName();
    String _string_3 = _name_3.toString();
    boolean _equals_3 = _string_3.equals("DENY_UNLESS");
    if (_equals_3) {
      return "it.unifi.facpl.lib.algorithm.DenyUnlessPermit";
    }
    String _name_4 = alg.getName();
    String _string_4 = _name_4.toString();
    boolean _equals_4 = _string_4.equals("PERMIT_UNLESS");
    if (_equals_4) {
      return "it.unifi.facpl.lib.algorithm.PermitUnlessDeny";
    }
    String _name_5 = alg.getName();
    String _string_5 = _name_5.toString();
    boolean _equals_5 = _string_5.equals("ONLY_ONE");
    if (_equals_5) {
      return "it.unifi.facpl.lib.algorithm.OnlyOneApplicable";
    }
    String _name_6 = alg.getName();
    String _string_6 = _name_6.toString();
    boolean _equals_6 = _string_6.equals("WEAK_CONS");
    if (_equals_6) {
      return "it.unifi.facpl.lib.algorithm.WeakConsensus";
    }
    String _name_7 = alg.getName();
    String _string_7 = _name_7.toString();
    boolean _equals_7 = _string_7.equals("STRONG_CONS");
    if (_equals_7) {
      return "it.unifi.facpl.lib.algorithm.StrongConsensus";
    }
    String _name_8 = alg.getName();
    String _string_8 = _name_8.toString();
    boolean _equals_8 = _string_8.equals("CUSTOM_ALG");
    if (_equals_8) {
      CharSequence _compilePersonalAlg = this.compilePersonalAlg();
      fsa.generateFile(((this.packageFolder + Facpl2Generator.personalAlg) + ".java"), _compilePersonalAlg);
      return Facpl2Generator.personalAlg;
    }
    return null;
  }
  
  public CharSequence compilePersonalAlg() {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.packageName, ""));
      if (_notEquals) {
        _builder.append("package ");
        _builder.append(this.packageName, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.LinkedList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import org.apache.log4j.Logger;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.context.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.enums.ExtendedDecision;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.interfaces.IEvaluableAlgorithm;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.interfaces.IEvaluableElement;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.policy.PAFElement;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.util.DecisionResult;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(Facpl2Generator.personalAlg, "");
    _builder.append(" implements IEvaluableAlgorithm{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public DecisionResult evaluate(List<EvaluableElement> elements, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ContextRequest cxtRequest, Boolean arg2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Logger l = Logger.getLogger(PAFElement.class);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("l.debug(\"-> personal combining algorithm started\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* TODO Auto-generated evaluate method");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Create personal combing strategy for EvaluableElement");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* For Example");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*for (EvaluableElement el : elements) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\tDecisionResult d = el.evaluate(cxtRequest);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\tif (d.getDecision().equals(ExtendedDecision.PERMIT)){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\t\tobls_permit.addAll(d.getObligation());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\t}else ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\tecisions.add(d);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*DecisionResult dr = new DecisionResult();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*for (DecisionResult decision : decisions) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\tif (decision.getDecision().equals(ExtendedDecision.PERMIT)){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\t\tdr.setDecision(ExtendedDecision.PERMIT);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\t\tdr.addObligation(obls_permit);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\t\treturn dr;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*\t}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*dr.setDecision(ExtendedDecision.INDETERMINATE);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*return dr;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileRequest(final Request request) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.packageName, ""));
      if (_notEquals) {
        _builder.append("package ");
        _builder.append(this.packageName, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.context.*;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.util.*;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")\t\t");
    _builder.newLine();
    _builder.append("public class ContextRequest_");
    String _name = request.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static ContextRequest CxtReq;");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static ContextRequest getContextReq(){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (CxtReq != null){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return CxtReq;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//create map for each category");
    _builder.newLine();
    {
      List<String> _categories = xtendUtil.getCategories(request);
      for(final String category : _categories) {
        _builder.append("\t");
        _builder.append("HashMap<String, Object> req_");
        String _parseNameCat = xtendUtil.parseNameCat(category);
        _builder.append(_parseNameCat, "\t");
        _builder.append(" = new HashMap<String, Object>();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("//add attribute\'s values");
    _builder.newLine();
    {
      EList<AttributeReq> _attributes = request.getAttributes();
      for(final AttributeReq a : _attributes) {
        _builder.append("\t");
        _builder.append("req_");
        AttributeName _name_1 = a.getName();
        String _category = _name_1.getCategory();
        String _parseNameCat_1 = xtendUtil.parseNameCat(_category);
        _builder.append(_parseNameCat_1, "\t");
        _builder.append(".put(\"");
        AttributeName _name_2 = a.getName();
        String _id = _name_2.getId();
        _builder.append(_id, "\t");
        _builder.append("\",");
        EList<Expression> _value = a.getValue();
        Object _compileRequestValue = this.compileRequestValue(_value);
        _builder.append(_compileRequestValue, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("//add attributes to request");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Request req = new Request(\"");
    String _name_3 = request.getName();
    _builder.append(_name_3, "\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    {
      List<String> _categories_1 = xtendUtil.getCategories(request);
      for(final String category_1 : _categories_1) {
        _builder.append("\t");
        _builder.append("req.addAttribute(\"");
        _builder.append(category_1, "\t");
        _builder.append("\",req_");
        String _parseNameCat_2 = xtendUtil.parseNameCat(category_1);
        _builder.append(_parseNameCat_2, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      String _stub = request.getStub();
      boolean _notEquals_1 = (!Objects.equal(_stub, null));
      if (_notEquals_1) {
        _builder.append("\t");
        _builder.append("//context stub: ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("CxtReq =  new ContextRequest(req, ");
        String _stub_1 = request.getStub();
        String _trim = _stub_1.trim();
        _builder.append(_trim, "\t");
        _builder.append(".getInstance());");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t");
        _builder.append("//context stub: default-one");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("CxtReq =  new ContextRequest(req, ContextStub_Default.getInstance());");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("return CxtReq;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public Object compileRequestValue(final EList<Expression> list) {
    CharSequence _xifexpression = null;
    int _size = list.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      Expression _get = list.get(0);
      return this.getExpression(_get);
    } else {
      _xifexpression = this.getSetDeclaration(list);
    }
    return _xifexpression;
  }
  
  public CharSequence getSetDeclaration(final EList<Expression> list) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Set(");
    _builder.newLine();
    {
      boolean _hasElements = false;
      for(final Expression l : list) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        Object _expression = this.getExpression(l);
        _builder.append(_expression, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(")");
    _builder.newLine();
    return _builder;
  }
  
  public String getNameFunction(final String f_name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Function_");
    _builder.append(f_name, "");
    return _builder.toString();
  }
  
  public CharSequence compileFunction(final FunctionDeclaration f) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(this.packageName, ""));
      if (_notEquals) {
        _builder.append("package ");
        _builder.append(this.packageName, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.interfaces.IExpressionFunction;");
    _builder.newLine();
    _builder.append("import it.unifi.facpl.lib.util.*;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _name = f.getName();
    String _nameFunction = this.getNameFunction(_name);
    _builder.append(_nameFunction, "");
    _builder.append(" implements IExpressionFunction{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Object evaluateFunction(List<Object> args) throws Throwable {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (args.size() == ");
    EList<TypeLiteral> _args = f.getArgs();
    int _size = _args.size();
    _builder.append(_size, "\t\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      EList<TypeLiteral> _args_1 = f.getArgs();
      int _size_1 = _args_1.size();
      boolean _greaterThan = (_size_1 > 0);
      if (_greaterThan) {
        _builder.append("\t\t\t");
        _builder.append("if( ");
        _builder.newLine();
        _builder.append("\t\t\t");
        int i = (-1);
        _builder.newLineIfNotEmpty();
        {
          EList<TypeLiteral> _args_2 = f.getArgs();
          boolean _hasElements = false;
          for(final TypeLiteral arg : _args_2) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(" && ", "\t\t\t");
            }
            _builder.append("\t\t\t");
            _builder.append("args.get(");
            _builder.append(i = (i + 1), "\t\t\t");
            _builder.append(") instanceof ");
            FacplType _facplType = FacplType.getFacplType(arg);
            String _javaType = Facpl2Generator_Name.getJavaType(_facplType);
            _builder.append(_javaType, "\t\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("){");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t\t");
        _builder.append("throw new Exception(\"TODO: auto-generated method stub\");");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}else{");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t\t");
        _builder.append("throw new Exception(\"Illegal types of arguments\");");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t\t\t");
        _builder.append("throw new Exception(\"TODO: auto-generated method stub\");");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new Exception(\"Illegal number of arguments\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String getNameFacplPolicy(final FacplPolicy policyS) {
    if (policyS instanceof PolicySet) {
      return _getNameFacplPolicy((PolicySet)policyS);
    } else if (policyS instanceof Rule) {
      return _getNameFacplPolicy((Rule)policyS);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(policyS).toString());
    }
  }
  
  public CharSequence compilePolicy(final FacplPolicy pol, final IFileSystemAccess fsa) {
    if (pol instanceof PolicySet) {
      return _compilePolicy((PolicySet)pol, fsa);
    } else if (pol instanceof Rule) {
      return _compilePolicy((Rule)pol, fsa);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(pol, fsa).toString());
    }
  }
  
  public Object getExpression(final Expression exp) {
    if (exp instanceof AndExpression) {
      return _getExpression((AndExpression)exp);
    } else if (exp instanceof AttributeName) {
      return _getExpression((AttributeName)exp);
    } else if (exp instanceof BooleanLiteral) {
      return _getExpression((BooleanLiteral)exp);
    } else if (exp instanceof DateLiteral) {
      return _getExpression((DateLiteral)exp);
    } else if (exp instanceof DeclaredFunction) {
      return _getExpression((DeclaredFunction)exp);
    } else if (exp instanceof DoubleLiteral) {
      return _getExpression((DoubleLiteral)exp);
    } else if (exp instanceof Function) {
      return _getExpression((Function)exp);
    } else if (exp instanceof IntLiteral) {
      return _getExpression((IntLiteral)exp);
    } else if (exp instanceof NotExpression) {
      return _getExpression((NotExpression)exp);
    } else if (exp instanceof OrExpression) {
      return _getExpression((OrExpression)exp);
    } else if (exp instanceof Set) {
      return _getExpression((Set)exp);
    } else if (exp instanceof StringLiteral) {
      return _getExpression((StringLiteral)exp);
    } else if (exp instanceof TimeLiteral) {
      return _getExpression((TimeLiteral)exp);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(exp).toString());
    }
  }
}
