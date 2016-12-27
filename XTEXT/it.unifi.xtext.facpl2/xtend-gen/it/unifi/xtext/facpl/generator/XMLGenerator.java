package it.unifi.xtext.facpl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Alg;
import it.unifi.xtext.facpl.facpl2.AlgLiteral;
import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Effect;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.IntLiteral;
import it.unifi.xtext.facpl.facpl2.MainFacpl;
import it.unifi.xtext.facpl.facpl2.NotExpression;
import it.unifi.xtext.facpl.facpl2.Obligation;
import it.unifi.xtext.facpl.facpl2.OrExpression;
import it.unifi.xtext.facpl.facpl2.PAF;
import it.unifi.xtext.facpl.facpl2.PDP;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.facpl2.Rule;
import it.unifi.xtext.facpl.facpl2.Set;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TimeLiteral;
import it.unifi.xtext.facpl.facpl2.funID;
import it.unifi.xtext.facpl.generator.util.Connector;
import it.unifi.xtext.facpl.generator.util.TargetTree;
import it.unifi.xtext.facpl.generator.xtendUtil;
import it.unifi.xtext.facpl.validation.FacplType;
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Xtend Generator for creating the XACML policies and/or requests corresponding to the FACPL code given as input
 */
@SuppressWarnings("all")
public class XMLGenerator {
  private static URI path;
  
  private static StringBuffer projectPath;
  
  private static HashMap<String, Function> targetExp = new HashMap<String, Function>();
  
  private static FacplTypeInference tInf;
  
  private static String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
  
  public XMLGenerator() {
    FacplTypeInference _facplTypeInference = new FacplTypeInference();
    XMLGenerator.tInf = _facplTypeInference;
  }
  
  private static String now() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(XMLGenerator.DATE_FORMAT_NOW);
    Date _time = cal.getTime();
    return sdf.format(_time);
  }
  
  /**
   * XACML Code generation
   */
  public void doGenerateFileXACML(final Resource resource, final IFileSystemAccess fsa) throws Exception {
    EList<EObject> _contents = resource.getContents();
    Iterable<Facpl> _filter = Iterables.<Facpl>filter(_contents, Facpl.class);
    for (final Facpl e : _filter) {
      {
        URI _uRI = resource.getURI();
        XMLGenerator.path = _uRI;
        StringBuffer _stringBuffer = new StringBuffer();
        XMLGenerator.projectPath = _stringBuffer;
        int count = 1;
        List<String> _segmentsList = XMLGenerator.path.segmentsList();
        for (final String f : _segmentsList) {
          {
            if ((count != 1)) {
              List<String> _segmentsList_1 = XMLGenerator.path.segmentsList();
              int _size = _segmentsList_1.size();
              boolean _notEquals = (count != _size);
              if (_notEquals) {
                XMLGenerator.projectPath.append((f + "/"));
              }
            }
            count = (count + 1);
          }
        }
        EList<Request> _requests = e.getRequests();
        boolean _notEquals = (!Objects.equal(_requests, null));
        if (_notEquals) {
          EList<Request> _requests_1 = e.getRequests();
          for (final Request r : _requests_1) {
            String _name = r.getName();
            String _plus = ("ContextRequest_" + _name);
            String _plus_1 = (_plus + ".xml");
            CharSequence _doGenerateXACML = this.doGenerateXACML(r);
            fsa.generateFile(_plus_1, _doGenerateXACML);
          }
        }
        MainFacpl _main = e.getMain();
        boolean _notEquals_1 = (!Objects.equal(_main, null));
        if (_notEquals_1) {
          MainFacpl _main_1 = e.getMain();
          PAF _paf = _main_1.getPaf();
          boolean _notEquals_2 = (!Objects.equal(_paf, null));
          if (_notEquals_2) {
            MainFacpl _main_2 = e.getMain();
            PAF _paf_1 = _main_2.getPaf();
            PDP _pdp = _paf_1.getPdp();
            EList<AbstractPolicyIncl> _polSet = _pdp.getPolSet();
            for (final AbstractPolicyIncl pol : _polSet) {
              FacplPolicy _newPolicy = pol.getNewPolicy();
              boolean _notEquals_3 = (!Objects.equal(_newPolicy, null));
              if (_notEquals_3) {
                FacplPolicy _newPolicy_1 = pol.getNewPolicy();
                String _name_1 = ((FacplPolicy) _newPolicy_1).getName();
                String _plus_2 = (_name_1 + ".xml");
                FacplPolicy _newPolicy_2 = pol.getNewPolicy();
                CharSequence _doGenerateXACML_1 = this.doGenerateXACML(_newPolicy_2);
                fsa.generateFile(_plus_2, _doGenerateXACML_1);
              } else {
                PolicySet _refPol = pol.getRefPol();
                boolean _notEquals_4 = (!Objects.equal(_refPol, null));
                if (_notEquals_4) {
                  PolicySet _refPol_1 = pol.getRefPol();
                  String _name_2 = _refPol_1.getName();
                  String _plus_3 = (_name_2 + ".xml");
                  PolicySet _refPol_2 = pol.getRefPol();
                  CharSequence _doGenerateXACML_2 = this.doGenerateXACML(_refPol_2);
                  fsa.generateFile(_plus_3, _doGenerateXACML_2);
                }
              }
            }
          }
        }
        EList<PolicySet> _policies = e.getPolicies();
        boolean _notEquals_5 = (!Objects.equal(_policies, null));
        if (_notEquals_5) {
          EList<PolicySet> _policies_1 = e.getPolicies();
          for (final PolicySet pol_1 : _policies_1) {
            String _name_3 = pol_1.getName();
            String _plus_4 = (_name_3 + ".xml");
            CharSequence _doGenerateXACML_3 = this.doGenerateXACML(pol_1);
            fsa.generateFile(_plus_4, _doGenerateXACML_3);
          }
        }
      }
    }
  }
  
  /**
   * COMMANDS for interaction with ECLIPSE MENU -> Policies
   */
  public void doGenerateFileXACML_Pol(final FacplPolicy p, final IFileSystemAccess fsa) {
    String _name = p.getName();
    String _plus = (_name + ".xml");
    CharSequence _doGenerateXACML = this.doGenerateXACML(p);
    fsa.generateFile(_plus, _doGenerateXACML);
  }
  
  /**
   * COMMANDS for interaction with ECLIPSE MENU -> Requests
   */
  public void doGenerateFileXACML_Req(final Request r, final IFileSystemAccess fsa) {
    String _name = r.getName();
    String _plus = ("ContextRequest_" + _name);
    String _plus_1 = (_plus + ".xml");
    CharSequence _doGenerateXACML = this.doGenerateXACML(r);
    fsa.generateFile(_plus_1, _doGenerateXACML);
  }
  
  /**
   * XACML Code generation -> STUB FOR TESTs
   */
  public String doGenerateXACML_StubTest(final Facpl res) throws Exception {
    Object _xblockexpression = null;
    {
      EList<Request> _requests = res.getRequests();
      boolean _notEquals = (!Objects.equal(_requests, null));
      if (_notEquals) {
        EList<Request> _requests_1 = res.getRequests();
        for (final Request r : _requests_1) {
          CharSequence _doGenerateXACML = this.doGenerateXACML(r);
          return _doGenerateXACML.toString();
        }
      }
      MainFacpl _main = res.getMain();
      boolean _notEquals_1 = (!Objects.equal(_main, null));
      if (_notEquals_1) {
        MainFacpl _main_1 = res.getMain();
        PAF _paf = _main_1.getPaf();
        boolean _notEquals_2 = (!Objects.equal(_paf, null));
        if (_notEquals_2) {
          MainFacpl _main_2 = res.getMain();
          PAF _paf_1 = _main_2.getPaf();
          PDP _pdp = _paf_1.getPdp();
          EList<AbstractPolicyIncl> _polSet = _pdp.getPolSet();
          for (final AbstractPolicyIncl pol : _polSet) {
            FacplPolicy _newPolicy = pol.getNewPolicy();
            boolean _notEquals_3 = (!Objects.equal(_newPolicy, null));
            if (_notEquals_3) {
              FacplPolicy _newPolicy_1 = pol.getNewPolicy();
              CharSequence _doGenerateXACML_1 = this.doGenerateXACML(_newPolicy_1);
              return _doGenerateXACML_1.toString();
            } else {
              PolicySet _refPol = pol.getRefPol();
              boolean _notEquals_4 = (!Objects.equal(_refPol, null));
              if (_notEquals_4) {
                PolicySet _refPol_1 = pol.getRefPol();
                CharSequence _doGenerateXACML_2 = this.doGenerateXACML(_refPol_1);
                return _doGenerateXACML_2.toString();
              }
            }
          }
        }
      }
      Object _xifexpression = null;
      EList<PolicySet> _policies = res.getPolicies();
      boolean _notEquals_5 = (!Objects.equal(_policies, null));
      if (_notEquals_5) {
        EList<PolicySet> _policies_1 = res.getPolicies();
        for (final PolicySet pol_1 : _policies_1) {
          CharSequence _doGenerateXACML_3 = this.doGenerateXACML(pol_1);
          return _doGenerateXACML_3.toString();
        }
      }
      _xblockexpression = _xifexpression;
    }
    return ((String)_xblockexpression);
  }
  
  /**
   * Call Translation
   */
  public CharSequence doGenerateXACML(final Object res) {
    if ((res instanceof Request)) {
      return this.compileReq(((Request)res));
    } else {
      if ((res instanceof FacplPolicy)) {
        return this.compilePol(((FacplPolicy)res));
      }
    }
    return null;
  }
  
  /**
   * External PolicySet (prologue needed)
   */
  protected CharSequence _compilePol(final PolicySet policy) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- New document created with Xtend2 by Eclipse Plugin at ");
    String _now = XMLGenerator.now();
    _builder.append(_now, "");
    _builder.append(" -->");
    _builder.newLineIfNotEmpty();
    _builder.append("<PolicySet xmlns=\"urn:oasis:names:tc:xacml:3.0:core:schema:wd-17\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xsi:schemaLocation=\"urn:oasis:names:tc:xacml:3.0:core:schema:wd-17");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("http://docs.oasis-open.org/xacml/3.0/xacml-core-v3-schema-wd-17.xsd\"");
    _builder.newLine();
    _builder.append("PolicySetId=\"");
    String _name = policy.getName();
    _builder.append(_name, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("Version=\"1.0\"");
    _builder.newLine();
    _builder.append("PolicyCombiningAlgId=\"");
    Alg _polSetAlg = policy.getPolSetAlg();
    String _alg = this.getAlg(_polSetAlg, policy);
    _builder.append(_alg, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("MaxDelegationDepth=\"1\">");
    _builder.newLine();
    {
      Expression _target = policy.getTarget();
      boolean _notEquals = (!Objects.equal(_target, null));
      if (_notEquals) {
        Expression _target_1 = policy.getTarget();
        String _compileExpressionTarget = this.compileExpressionTarget(_target_1);
        _builder.append(_compileExpressionTarget, "");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("<Target/>");
        _builder.newLine();
      }
    }
    {
      EList<AbstractPolicyIncl> _policies = policy.getPolicies();
      for(final AbstractPolicyIncl pol : _policies) {
        {
          PolicySet _refPol = pol.getRefPol();
          boolean _notEquals_1 = (!Objects.equal(_refPol, null));
          if (_notEquals_1) {
            _builder.append("<PolicySetIdReference>");
            _builder.newLine();
            _builder.append("\t");
            PolicySet _refPol_1 = pol.getRefPol();
            String _name_1 = _refPol_1.getName();
            _builder.append(_name_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("</PolicySetIdReference>");
            _builder.newLine();
          } else {
            FacplPolicy _newPolicy = pol.getNewPolicy();
            CharSequence _compileIntPol = this.compileIntPol(_newPolicy);
            _builder.append(_compileIntPol, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      EList<Obligation> _oblp = policy.getOblp();
      int _size = _oblp.size();
      boolean _notEquals_2 = (_size != 0);
      if (_notEquals_2) {
        EList<Obligation> _oblp_1 = policy.getOblp();
        String _compileAdvObl = this.compileAdvObl(_oblp_1, Effect.PERMIT);
        _builder.append(_compileAdvObl, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Obligation> _obld = policy.getObld();
      int _size_1 = _obld.size();
      boolean _notEquals_3 = (_size_1 != 0);
      if (_notEquals_3) {
        _builder.append(",\t");
        EList<Obligation> _obld_1 = policy.getObld();
        String _compileAdvObl_1 = this.compileAdvObl(_obld_1, Effect.DENY);
        _builder.append(_compileAdvObl_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</PolicySet>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _compilePol(final Rule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- New document created with Xtend2 by Eclipse Plugin at ");
    String _now = XMLGenerator.now();
    _builder.append(_now, "");
    _builder.append(" -->");
    _builder.newLineIfNotEmpty();
    _builder.append("<Policy xmlns=\"urn:oasis:names:tc:xacml:3.0:core:schema:wd-17\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xsi:schemaLocation=\"urn:oasis:names:tc:xacml:3.0:core:schema:wd-17");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("http://docs.oasis-open.org/xacml/3.0/xacml-core-v3-schema-wd-17.xsd\"");
    _builder.newLine();
    _builder.append("PolicyId=\"PolicyEnclosingRule_");
    String _name = rule.getName();
    _builder.append(_name, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("Version=\"1.0\"");
    _builder.newLine();
    _builder.append("RuleCombiningAlgId=\"urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-overrides\"");
    _builder.newLine();
    _builder.append("MaxDelegationDepth=\"1\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<Target/>");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _compileIntPol = this.compileIntPol(rule);
    _builder.append(_compileIntPol, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</Policy>");
    _builder.newLine();
    return _builder;
  }
  
  public String compileAdvObl(final EList<Obligation> list, final Effect e) {
    Boolean flag = Boolean.valueOf(false);
    StringBuffer s = new StringBuffer();
    for (final Obligation obl : list) {
      String _typeObl = obl.getTypeObl();
      boolean _equals = _typeObl.equals("M");
      if (_equals) {
        if ((!(flag).booleanValue())) {
          s.append("<ObligationExpressions>\n");
          flag = Boolean.valueOf(true);
        }
        CharSequence _compileObl = this.compileObl(obl, e);
        s.append(_compileObl);
      }
    }
    if ((flag).booleanValue()) {
      s.append("</ObligationExpressions>\n");
    }
    flag = Boolean.valueOf(false);
    for (final Obligation obl_1 : list) {
      String _typeObl_1 = obl_1.getTypeObl();
      boolean _equals_1 = _typeObl_1.equals("O");
      if (_equals_1) {
        if ((!(flag).booleanValue())) {
          s.append("<AdviceExpressions>\n");
          flag = Boolean.valueOf(true);
        }
        CharSequence _compileAdv = this.compileAdv(obl_1, e);
        s.append(_compileAdv);
      }
    }
    if ((flag).booleanValue()) {
      s.append("</AdviceExpressions>\n");
    }
    return s.toString();
  }
  
  public CharSequence compileObl(final Obligation obl, final Effect e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ObligationExpression ObligationId=\"");
    String _pepAction = obl.getPepAction();
    _builder.append(_pepAction, "");
    _builder.append("\" FulfillOn=\"");
    String _string = e.toString();
    String _firstUpper = StringExtensions.toFirstUpper(_string);
    _builder.append(_firstUpper, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    {
      EList<Expression> _expr = obl.getExpr();
      for(final Expression o : _expr) {
        _builder.append("\t");
        _builder.append("<AttributeAssignmentExpression AttributeId=\"urn:oasis:names:tc:xaml:3.0:argument\">");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _expression = this.getExpression(o);
        _builder.append(_expression, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</AttributeAssignmentExpression>");
        _builder.newLine();
      }
    }
    _builder.append("</ObligationExpression>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileAdv(final Obligation obl, final Effect e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<AdviceExpression AdviceId=\"");
    String _pepAction = obl.getPepAction();
    _builder.append(_pepAction, "");
    _builder.append("\" AppliesTo=\"");
    String _string = e.toString();
    String _firstUpper = StringExtensions.toFirstUpper(_string);
    _builder.append(_firstUpper, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    {
      EList<Expression> _expr = obl.getExpr();
      for(final Expression o : _expr) {
        _builder.append("\t");
        _builder.append("<AttributeAssignmentExpression AttributeId=\"urn:oasis:names:tc:xaml:3.0:argument\">");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _expression = this.getExpression(o);
        _builder.append(_expression, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</AttributeAssignmentExpression>");
        _builder.newLine();
      }
    }
    _builder.append("</AdviceExpression>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _compileIntPol(final PolicySet policy) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<PolicySet PolicySetId=\"");
    String _name = policy.getName();
    _builder.append(_name, "");
    _builder.append("\" Version=\"1.0\"");
    _builder.newLineIfNotEmpty();
    _builder.append("PolicyCombiningAlgId=\"");
    Alg _polSetAlg = policy.getPolSetAlg();
    String _alg = this.getAlg(_polSetAlg, policy);
    _builder.append(_alg, "");
    _builder.append("\" >");
    _builder.newLineIfNotEmpty();
    {
      Expression _target = policy.getTarget();
      boolean _notEquals = (!Objects.equal(_target, null));
      if (_notEquals) {
        Expression _target_1 = policy.getTarget();
        String _compileExpressionTarget = this.compileExpressionTarget(_target_1);
        _builder.append(_compileExpressionTarget, "");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("<Target/>");
        _builder.newLine();
      }
    }
    {
      EList<AbstractPolicyIncl> _policies = policy.getPolicies();
      for(final AbstractPolicyIncl p : _policies) {
        {
          PolicySet _refPol = p.getRefPol();
          boolean _notEquals_1 = (!Objects.equal(_refPol, null));
          if (_notEquals_1) {
            _builder.append("<PolicySetIdReference>");
            _builder.newLine();
            PolicySet _refPol_1 = p.getRefPol();
            String _name_1 = _refPol_1.getName();
            _builder.append(_name_1, "");
            _builder.newLineIfNotEmpty();
            _builder.append("</PolicySetIdReference>");
            _builder.newLine();
          } else {
            FacplPolicy _newPolicy = p.getNewPolicy();
            CharSequence _compileIntPol = this.compileIntPol(_newPolicy);
            _builder.append(_compileIntPol, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      EList<Obligation> _oblp = policy.getOblp();
      int _size = _oblp.size();
      boolean _notEquals_2 = (_size != 0);
      if (_notEquals_2) {
        EList<Obligation> _oblp_1 = policy.getOblp();
        String _compileAdvObl = this.compileAdvObl(_oblp_1, Effect.PERMIT);
        _builder.append(_compileAdvObl, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Obligation> _obld = policy.getObld();
      int _size_1 = _obld.size();
      boolean _notEquals_3 = (_size_1 != 0);
      if (_notEquals_3) {
        EList<Obligation> _obld_1 = policy.getObld();
        String _compileAdvObl_1 = this.compileAdvObl(_obld_1, Effect.DENY);
        _builder.append(_compileAdvObl_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</PolicySet>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _compileIntPol(final Rule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<Policy ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("PolicyId=\"PolicyEnclosingRule");
    String _name = rule.getName();
    _builder.append(_name, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Version=\"1.0\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("RuleCombiningAlgId=\"urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-overrides\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("MaxDelegationDepth=\"1\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<Target/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<Rule RuleId=\"");
    String _name_1 = rule.getName();
    _builder.append(_name_1, "\t");
    _builder.append("\" Effect=\"");
    Effect _effect = rule.getEffect();
    String _string = _effect.toString();
    String _firstUpper = StringExtensions.toFirstUpper(_string);
    _builder.append(_firstUpper, "\t");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<Target/>");
    _builder.newLine();
    {
      Expression _target = rule.getTarget();
      boolean _notEquals = (!Objects.equal(_target, null));
      if (_notEquals) {
        _builder.append("\t\t");
        _builder.append("<Condition>");
        Expression _target_1 = rule.getTarget();
        CharSequence _expression = this.getExpression(_target_1);
        _builder.append(_expression, "\t\t");
        _builder.append("</Condition>");
        _builder.newLineIfNotEmpty();
      } else {
      }
    }
    {
      EList<Obligation> _obl = rule.getObl();
      int _size = _obl.size();
      boolean _notEquals_1 = (_size != 0);
      if (_notEquals_1) {
        _builder.append("\t\t");
        EList<Obligation> _obl_1 = rule.getObl();
        Effect _effect_1 = rule.getEffect();
        String _compileAdvObl = this.compileAdvObl(_obl_1, _effect_1);
        _builder.append(_compileAdvObl, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("</Rule>");
    _builder.newLine();
    _builder.append("</Policy>");
    _builder.newLine();
    return _builder;
  }
  
  public String compileExpressionTarget(final Expression expression) {
    boolean _equals = Objects.equal(expression, null);
    if (_equals) {
      return "<Target/>";
    }
    TargetTree exp = this.createTargetTree(expression);
    TargetTree _refactorTargetTree = xtendUtil.refactorTargetTree(exp);
    exp = _refactorTargetTree;
    CharSequence _createTargetXML = this.createTargetXML(exp, null, Boolean.valueOf(false));
    String _plus = ("<Target>\n" + _createTargetXML);
    return (_plus + "</Target>");
  }
  
  public CharSequence createTargetXML(final TargetTree tree, final Connector dad, final Boolean isMatchSequence) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Object _root = tree.getRoot();
      boolean _notEquals = (!Objects.equal(_root, null));
      if (_notEquals) {
        {
          Object _root_1 = tree.getRoot();
          if ((_root_1 instanceof Connector)) {
            {
              LinkedList<TargetTree> _child = tree.getChild();
              for(final TargetTree el : _child) {
                Object _root_2 = tree.getRoot();
                String _xMLElementS = this.getXMLElementS(((Connector) _root_2), dad);
                _builder.append(_xMLElementS, "");
                _builder.newLineIfNotEmpty();
                {
                  if (((!Objects.equal(dad, null)) && dad.equals(Connector.OR))) {
                    Object _root_3 = tree.getRoot();
                    CharSequence _createTargetXML = this.createTargetXML(el, ((Connector) _root_3), Boolean.valueOf(true));
                    _builder.append(_createTargetXML, "");
                    _builder.newLineIfNotEmpty();
                  } else {
                    Object _root_4 = tree.getRoot();
                    CharSequence _createTargetXML_1 = this.createTargetXML(el, ((Connector) _root_4), Boolean.valueOf(false));
                    _builder.append(_createTargetXML_1, "");
                    _builder.newLineIfNotEmpty();
                  }
                }
                Object _root_5 = tree.getRoot();
                String _xMLElementE = this.getXMLElementE(((Connector) _root_5), dad);
                _builder.append(_xMLElementE, "");
                _builder.newLineIfNotEmpty();
              }
            }
          } else {
            String _openSequenceElements = this.getOpenSequenceElements(dad, isMatchSequence);
            _builder.append(_openSequenceElements, "");
            _builder.newLineIfNotEmpty();
            Object _root_6 = tree.getRoot();
            String _targetFunction = this.getTargetFunction(((String) _root_6));
            _builder.append(_targetFunction, "");
            _builder.newLineIfNotEmpty();
            String _closeSequenceElements = this.getCloseSequenceElements(dad, isMatchSequence);
            _builder.append(_closeSequenceElements, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public String getXMLElementS(final Connector connector, final Connector dad) {
    try {
      if (connector != null) {
        switch (connector) {
          case AND:
            boolean _equals = Objects.equal(dad, null);
            if (_equals) {
              return "<AnyOf>";
            } else {
              return "";
            }
          case OR:
            return "<AllOf>";
          case NOT:
            throw new Exception("Operator NOT cannot occur in XACML Target");
          default:
            break;
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getXMLElementE(final Connector connector, final Connector dad) {
    try {
      if (connector != null) {
        switch (connector) {
          case AND:
            boolean _equals = Objects.equal(dad, null);
            if (_equals) {
              return "</AnyOf>";
            } else {
              return "";
            }
          case OR:
            return "</AllOf>";
          case NOT:
            throw new Exception("Operator NOT cannot occur in XACML Target");
          default:
            break;
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getOpenSequenceElements(final Connector connector, final Boolean isMatchSequence) {
    boolean _equals = Objects.equal(connector, null);
    if (_equals) {
      return "<AnyOf> \n \t <AllOf> \n \t\t ";
    }
    if ((Objects.equal(connector, Connector.AND) && (!(isMatchSequence).booleanValue()))) {
      return "<AllOf> \n \t\t ";
    }
    return null;
  }
  
  public String getCloseSequenceElements(final Connector connector, final Boolean isMatchSequence) {
    boolean _equals = Objects.equal(connector, null);
    if (_equals) {
      return "</AllOf> \n \t </AnyOf> \n \t\t ";
    }
    if ((Objects.equal(connector, Connector.AND) && (!(isMatchSequence).booleanValue()))) {
      return "</AllOf> \n \t\t ";
    }
    return null;
  }
  
  public String getTargetFunction(final String string) {
    Function exp = XMLGenerator.targetExp.remove(string);
    StringBuffer target = new StringBuffer();
    funID _functionId = exp.getFunctionId();
    String _string = _functionId.toString();
    Expression _arg1 = exp.getArg1();
    FacplType _doSwitch = XMLGenerator.tInf.doSwitch(_arg1);
    Expression _arg2 = exp.getArg2();
    FacplType _doSwitch_1 = XMLGenerator.tInf.doSwitch(_arg2);
    FacplType _combine = FacplType.combine(_doSwitch, _doSwitch_1);
    String _functionId_1 = this.getFunctionId(_string, _combine);
    String _plus = ("<Match MatchId=\"" + _functionId_1);
    String _plus_1 = (_plus + "\">\n");
    target.append(_plus_1);
    Expression _arg1_1 = exp.getArg1();
    CharSequence _expression = this.getExpression(_arg1_1);
    target.append(_expression);
    Expression _arg2_1 = exp.getArg2();
    CharSequence _expression_1 = this.getExpression(_arg2_1);
    target.append(_expression_1);
    target.append("</Match>");
    return target.toString();
  }
  
  protected TargetTree _createTargetTree(final AndExpression exp) {
    Expression _left = exp.getLeft();
    TargetTree _createTargetTree = this.createTargetTree(_left);
    Expression _right = exp.getRight();
    TargetTree _createTargetTree_1 = this.createTargetTree(_right);
    return new TargetTree(Connector.AND, _createTargetTree, _createTargetTree_1);
  }
  
  protected TargetTree _createTargetTree(final OrExpression exp) {
    Expression _left = exp.getLeft();
    TargetTree _createTargetTree = this.createTargetTree(_left);
    Expression _right = exp.getRight();
    TargetTree _createTargetTree_1 = this.createTargetTree(_right);
    return new TargetTree(Connector.OR, _createTargetTree, _createTargetTree_1);
  }
  
  protected TargetTree _createTargetTree(final NotExpression exp) {
    Expression _arg = exp.getArg();
    TargetTree _createTargetTree = this.createTargetTree(_arg);
    return new TargetTree(Connector.NOT, _createTargetTree);
  }
  
  protected TargetTree _createTargetTree(final Function target) {
    String _createAtomTarget = this.createAtomTarget(target);
    TargetTree r = new TargetTree(_createAtomTarget);
    return r;
  }
  
  public String createAtomTarget(final Function target) {
    UUID _randomUUID = UUID.randomUUID();
    String id = _randomUUID.toString();
    XMLGenerator.targetExp.put(id, target);
    return id;
  }
  
  public Connector compileOP(final String string) {
    switch (string) {
      case "&&":
        return Connector.AND;
      case "||":
        return Connector.OR;
      case "!":
        return Connector.NOT;
    }
    return null;
  }
  
  protected CharSequence _getExpression(final AndExpression e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<Apply FunctionId=\"urn:oasis:names:tc:xacml:1.0:function:and\">");
    _builder.newLine();
    _builder.append("\t\t");
    Expression _left = e.getLeft();
    Object _expression = this.getExpression(_left);
    _builder.append(_expression, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    Expression _right = e.getRight();
    Object _expression_1 = this.getExpression(_right);
    _builder.append(_expression_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</Apply>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final OrExpression e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<Apply FunctionId=\"urn:oasis:names:tc:xacml:1.0:function:or\">");
    _builder.newLine();
    _builder.append("\t\t");
    Expression _left = e.getLeft();
    Object _expression = this.getExpression(_left);
    _builder.append(_expression, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    Expression _right = e.getRight();
    Object _expression_1 = this.getExpression(_right);
    _builder.append(_expression_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</Apply>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final NotExpression e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<Apply FunctionId=\"urn:oasis:names:tc:xacml:1.0:function:not\">");
    _builder.newLine();
    _builder.append("\t\t");
    Expression _arg = e.getArg();
    Object _expression = this.getExpression(_arg);
    _builder.append(_expression, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</Apply>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final Function f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<Apply FunctionId=\"");
    funID _functionId = f.getFunctionId();
    String _string = _functionId.toString();
    Expression _arg1 = f.getArg1();
    FacplType _doSwitch = XMLGenerator.tInf.doSwitch(_arg1);
    Expression _arg2 = f.getArg2();
    FacplType _doSwitch_1 = XMLGenerator.tInf.doSwitch(_arg2);
    FacplType _combine = FacplType.combine(_doSwitch, _doSwitch_1);
    String _functionId_1 = this.getFunctionId(_string, _combine);
    _builder.append(_functionId_1, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Expression _arg1_1 = f.getArg1();
    Object _expression = this.getExpression(_arg1_1);
    _builder.append(_expression, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Expression _arg2_1 = f.getArg2();
    Object _expression_1 = this.getExpression(_arg2_1);
    _builder.append(_expression_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</Apply>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final IntLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<AttributeValue DataType=\"");
    String _dataType = this.getDataType(e);
    _builder.append(_dataType, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    int _value = e.getValue();
    _builder.append(_value, "");
    _builder.newLineIfNotEmpty();
    _builder.append("</AttributeValue>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final DoubleLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<AttributeValue DataType=\"");
    String _dataType = this.getDataType(e);
    _builder.append(_dataType, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    double _value = e.getValue();
    _builder.append(_value, "");
    _builder.newLineIfNotEmpty();
    _builder.append("</AttributeValue>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final StringLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<AttributeValue DataType=\"");
    String _dataType = this.getDataType(e);
    _builder.append(_dataType, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    String _value = e.getValue();
    _builder.append(_value, "");
    _builder.newLineIfNotEmpty();
    _builder.append("</AttributeValue>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final BooleanLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<AttributeValue DataType=\"");
    String _dataType = this.getDataType(e);
    _builder.append(_dataType, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    boolean _isValue = e.isValue();
    _builder.append(_isValue, "");
    _builder.newLineIfNotEmpty();
    _builder.append("</AttributeValue>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final DateLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<AttributeValue DataType=\"");
    String _dataType = this.getDataType(e);
    _builder.append(_dataType, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    String _value = e.getValue();
    _builder.append(_value, "");
    _builder.newLineIfNotEmpty();
    _builder.append("</AttributeValue>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _getExpression(final AttributeName name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<AttributeDesignator ");
    _builder.newLine();
    _builder.append("DataType=\"http://www.w3.org/2001/XMLSchema#anyURI\" MustBePresent=\"false\" ");
    _builder.newLine();
    _builder.append("Category=\"");
    String _category = name.getCategory();
    String _categoryId = this.getCategoryId(_category);
    _builder.append(_categoryId, "");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("AttributeId=\"");
    String _attributeId = this.getAttributeId(name);
    _builder.append(_attributeId, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _getExpression(final Set item) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<Apply FunctionId=\"urn:oasis:names:tc:xacml:1.0:function:anyuri-bag\">");
    _builder.newLine();
    {
      EList<Expression> _args = item.getArgs();
      for(final Expression i : _args) {
        _builder.append("\t");
        Object _expression = this.getExpression(i);
        _builder.append(_expression, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</Apply>");
    _builder.newLine();
    return _builder;
  }
  
  protected String _getDataType(final IntLiteral exp) {
    return "http://www.w3.org/2001/XMLSchema#integer";
  }
  
  protected String _getDataType(final DoubleLiteral exp) {
    return "http://www.w3.org/2001/XMLSchema#double";
  }
  
  protected String _getDataType(final BooleanLiteral exp) {
    return "http://www.w3.org/2001/XMLSchema#boolean";
  }
  
  protected String _getDataType(final StringLiteral exp) {
    return "http://www.w3.org/2001/XMLSchema#string";
  }
  
  protected String _getDataType(final DateLiteral exp) {
    return "http://www.w3.org/2001/XMLSchema#date";
  }
  
  protected String _getDataType(final TimeLiteral exp) {
    return "http://www.w3.org/2001/XMLSchema#date";
  }
  
  public String getFunctionId(final String id, final FacplType type) {
    boolean _equals = id.equals("equal");
    if (_equals) {
      boolean _equals_1 = type.equals(FacplType.BOOLEAN);
      if (_equals_1) {
        return "urn:oasis:names:tc:xacml:1.0:function:boolean-equal";
      }
      boolean _equals_2 = type.equals(FacplType.STRING);
      if (_equals_2) {
        return "urn:oasis:names:tc:xacml:1.0:function:string-equal";
      }
      boolean _equals_3 = type.equals(FacplType.INT);
      if (_equals_3) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-equal";
      }
      boolean _equals_4 = type.equals(FacplType.DOUBLE);
      if (_equals_4) {
        return "urn:oasis:names:tc:xacml:1.0:function:double-equal";
      }
      boolean _equals_5 = type.equals(FacplType.DATETIME);
      if (_equals_5) {
        return "urn:oasis:names:tc:xacml:1.0:function:dateTime-equal";
      }
      boolean _equals_6 = type.equals(FacplType.NAME);
      if (_equals_6) {
        return "urn:oasis:names:tc:xacml:1.0:function:anyURI-equal";
      }
    } else {
      boolean _equals_7 = id.equals("not-equal");
      if (_equals_7) {
        boolean _equals_8 = type.equals(FacplType.BOOLEAN);
        if (_equals_8) {
          return "urn:oasis:names:tc:xacml:1.0:function:boolean-not-equal";
        }
        boolean _equals_9 = type.equals(FacplType.STRING);
        if (_equals_9) {
          return "urn:oasis:names:tc:xacml:1.0:function:string-not-equal";
        }
        boolean _equals_10 = type.equals(FacplType.INT);
        if (_equals_10) {
          return "urn:oasis:names:tc:xacml:1.0:function:integer-not-equal";
        }
        boolean _equals_11 = type.equals(FacplType.DOUBLE);
        if (_equals_11) {
          return "urn:oasis:names:tc:xacml:1.0:function:double-not-equal";
        }
        boolean _equals_12 = type.equals(FacplType.DATETIME);
        if (_equals_12) {
          return "urn:oasis:names:tc:xacml:1.0:function:dateTime-not-equal";
        }
        boolean _equals_13 = type.equals(FacplType.NAME);
        if (_equals_13) {
          return "urn:oasis:names:tc:xacml:1.0:function:anyURI-not-equal";
        }
      } else {
        boolean _equals_14 = id.equals("less-than");
        if (_equals_14) {
          boolean _equals_15 = type.equals(FacplType.INT);
          if (_equals_15) {
            return "urn:oasis:names:tc:xacml:1.0:function:integer-less-than";
          }
          boolean _equals_16 = type.equals(FacplType.DOUBLE);
          if (_equals_16) {
            return "urn:oasis:names:tc:xacml:1.0:function:double-less-than";
          }
          boolean _equals_17 = type.equals(FacplType.DATETIME);
          if (_equals_17) {
            return "urn:oasis:names:tc:xacml:1.0:function:dateTime-less-than";
          }
          boolean _equals_18 = type.equals(FacplType.NAME);
          if (_equals_18) {
            return "urn:oasis:names:tc:xacml:1.0:function:integer-less-than";
          }
        } else {
          boolean _equals_19 = id.equals("less-than-or-equal");
          if (_equals_19) {
            boolean _equals_20 = type.equals(FacplType.INT);
            if (_equals_20) {
              return "urn:oasis:names:tc:xacml:1.0:function:integer-less-than-or-equal";
            }
            boolean _equals_21 = type.equals(FacplType.DOUBLE);
            if (_equals_21) {
              return "urn:oasis:names:tc:xacml:1.0:function:double-less-than-or-equal";
            }
            boolean _equals_22 = type.equals(FacplType.DATETIME);
            if (_equals_22) {
              return "urn:oasis:names:tc:xacml:1.0:function:dateTime-less-than-or-equal";
            }
            boolean _equals_23 = type.equals(FacplType.NAME);
            if (_equals_23) {
              return "urn:oasis:names:tc:xacml:1.0:function:integer-less-than-or-equal";
            }
          } else {
            boolean _equals_24 = id.equals("greater-than");
            if (_equals_24) {
              boolean _equals_25 = type.equals(FacplType.INT);
              if (_equals_25) {
                return "urn:oasis:names:tc:xacml:1.0:function:integer-greater-than";
              }
              boolean _equals_26 = type.equals(FacplType.DOUBLE);
              if (_equals_26) {
                return "urn:oasis:names:tc:xacml:1.0:function:double-greater-than";
              }
              boolean _equals_27 = type.equals(FacplType.DATETIME);
              if (_equals_27) {
                return "urn:oasis:names:tc:xacml:1.0:function:dateTime-greater-than";
              }
              boolean _equals_28 = type.equals(FacplType.NAME);
              if (_equals_28) {
                return "urn:oasis:names:tc:xacml:1.0:function:integer-greater-than";
              }
            } else {
              boolean _equals_29 = id.equals("greater-than-or-equal");
              if (_equals_29) {
                boolean _equals_30 = type.equals(FacplType.INT);
                if (_equals_30) {
                  return "urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal";
                }
                boolean _equals_31 = type.equals(FacplType.DOUBLE);
                if (_equals_31) {
                  return "urn:oasis:names:tc:xacml:1.0:function:double-greater-than-or-equal";
                }
                boolean _equals_32 = type.equals(FacplType.DATETIME);
                if (_equals_32) {
                  return "urn:oasis:names:tc:xacml:1.0:function:dateTime-greater-than-or-equal";
                }
                boolean _equals_33 = type.equals(FacplType.NAME);
                if (_equals_33) {
                  return "urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal";
                }
              } else {
                boolean _equals_34 = id.equals("in");
                if (_equals_34) {
                  boolean _equals_35 = type.equals(FacplType.INT);
                  if (_equals_35) {
                    return "urn:oasis:names:tc:xacml:1.0:function:int-subset";
                  }
                  boolean _equals_36 = type.equals(FacplType.DOUBLE);
                  if (_equals_36) {
                    return "urn:oasis:names:tc:xacml:1.0:function:double-subset";
                  }
                  boolean _equals_37 = type.equals(FacplType.STRING);
                  if (_equals_37) {
                    return "urn:oasis:names:tc:xacml:1.0:function:string-subset";
                  }
                  boolean _equals_38 = type.equals(FacplType.NAME);
                  if (_equals_38) {
                    return "urn:oasis:names:tc:xacml:1.0:function:anyURI-subset";
                  }
                }
              }
            }
          }
        }
      }
    }
    boolean _equals_39 = id.equals("addition");
    if (_equals_39) {
      boolean _equals_40 = type.equals(FacplType.INT);
      if (_equals_40) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-add";
      }
      boolean _equals_41 = type.equals(FacplType.DOUBLE);
      if (_equals_41) {
        return "urn:oasis:names:tc:xacml:1.0:function:double-add";
      }
      boolean _equals_42 = type.equals(FacplType.NAME);
      if (_equals_42) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-add";
      }
    }
    boolean _equals_43 = id.equals("subtract");
    if (_equals_43) {
      boolean _equals_44 = type.equals(FacplType.INT);
      if (_equals_44) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-subtract";
      }
      boolean _equals_45 = type.equals(FacplType.DOUBLE);
      if (_equals_45) {
        return "urn:oasis:names:tc:xacml:1.0:function:double-subtract";
      }
      boolean _equals_46 = type.equals(FacplType.NAME);
      if (_equals_46) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-subtract";
      }
    }
    boolean _equals_47 = id.equals("multiply");
    if (_equals_47) {
      boolean _equals_48 = type.equals(FacplType.INT);
      if (_equals_48) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-multiply";
      }
      boolean _equals_49 = type.equals(FacplType.DOUBLE);
      if (_equals_49) {
        return "urn:oasis:names:tc:xacml:1.0:function:double-multiply";
      }
      boolean _equals_50 = type.equals(FacplType.NAME);
      if (_equals_50) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-multiply";
      }
    }
    boolean _equals_51 = id.equals("divide");
    if (_equals_51) {
      boolean _equals_52 = type.equals(FacplType.INT);
      if (_equals_52) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-divide";
      }
      boolean _equals_53 = type.equals(FacplType.DOUBLE);
      if (_equals_53) {
        return "urn:oasis:names:tc:xacml:1.0:function:double-divide";
      }
      boolean _equals_54 = type.equals(FacplType.NAME);
      if (_equals_54) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-divide";
      }
    }
    boolean _equals_55 = id.equals("abs");
    if (_equals_55) {
      boolean _equals_56 = type.equals(FacplType.INT);
      if (_equals_56) {
        return "urn:oasis:names:tc:xacml:1.0:function:integer-abs";
      }
      boolean _equals_57 = type.equals(FacplType.DOUBLE);
      if (_equals_57) {
        return "urn:oasis:names:tc:xacml:1.0:function:double-abs";
      }
    }
    boolean _equals_58 = id.equals("mod");
    if (_equals_58) {
      return "urn:oasis:names:tc:xacml:1.0:function:integer-mod";
    }
    return null;
  }
  
  public CharSequence compileReq(final Request request) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!-- New document created with Xtend2 by Eclipse Plugin at ");
    String _now = XMLGenerator.now();
    _builder.append(_now, "");
    _builder.append(" -->");
    _builder.newLineIfNotEmpty();
    _builder.append("<Request xmlns=\"urn:oasis:names:tc:xacml:3.0:core:schema:wd-17\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xsi:schemaLocation=\"urn:oasis:names:tc:xacml:3.0:core:schema:wd-17");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("http://docs.oasis-open.org/xacml/3.0/xacml-core-v3-schema-wd-17.xsd\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ReturnPolicyIdList=\"false\" CombinedDecision=\"false\">");
    _builder.newLine();
    {
      List<String> _categories = xtendUtil.getCategories(request);
      for(final String category : _categories) {
        _builder.append("<Attributes");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Category=\"");
        String _categoryId = this.getCategoryId(category);
        _builder.append(_categoryId, "\t");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        {
          EList<AttributeReq> _attributes = request.getAttributes();
          for(final AttributeReq at : _attributes) {
            {
              AttributeName _name = at.getName();
              String _category = _name.getCategory();
              boolean _equals = _category.equals(category);
              if (_equals) {
                _builder.append("\t");
                _builder.append("<Attribute IncludeInResult=\"false\"");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("AttributeId=\"");
                AttributeName _name_1 = at.getName();
                String _attributeId = this.getAttributeId(_name_1);
                _builder.append(_attributeId, "\t");
                _builder.append("\">");
                _builder.newLineIfNotEmpty();
                {
                  EList<Expression> _value = at.getValue();
                  for(final Expression e : _value) {
                    _builder.append("\t");
                    CharSequence _expression = this.getExpression(e);
                    _builder.append(_expression, "\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("</Attribute>");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append("</Attributes>");
        _builder.newLine();
      }
    }
    _builder.append("</Request>");
    _builder.newLine();
    return _builder;
  }
  
  public String getCategoryId(final String string) {
    String id = null;
    switch (string) {
      case "subject":
        id = "urn:oasis:names:tc:xacml:3.0:attribute-category:subject";
        break;
      case "action":
        id = "urn:oasis:names:tc:xacml:3.0:attribute-category:action";
        break;
      case "environment":
        id = "urn:oasis:names:tc:xacml:3.0:attribute-category:environment";
        break;
      case "resource":
        id = "urn:oasis:names:tc:xacml:3.0:attribute-category:resource";
        break;
      default:
        id = ("urn:oasis:names:tc:xacml:3.0:attribute-category:" + string);
        break;
    }
    return id;
  }
  
  public String getAttributeId(final AttributeName literal) {
    StringBuffer id = new StringBuffer();
    String _category = literal.getCategory();
    switch (_category) {
      case "subject":
        id.append("urn:oasis:names:tc:xacml:1.0:subject:");
        break;
      case "resource":
        id.append("urn:oasis:names:tc:xacml:1.0:resource:");
        break;
      case "action":
        id.append("urn:oasis:names:tc:xacml:1.0:action:");
        break;
      case "environment":
        id.append("urn:oasis:names:tc:xacml:1.0:environment:");
        break;
      default:
        String _category_1 = literal.getCategory();
        String _plus = ("urn:oasis:names:tc:xacml:3.0:" + _category_1);
        String _plus_1 = (_plus + ":");
        id.append(_plus_1);
        break;
    }
    String _id = literal.getId();
    id.append(_id);
    return id.toString();
  }
  
  public String getAlg(final Alg alg, final FacplPolicy pol) {
    AlgLiteral _idAlg = alg.getIdAlg();
    String _name = _idAlg.getName();
    String _string = _name.toString();
    boolean _equals = _string.equals("DENY_OVER");
    if (_equals) {
      return "urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:deny-overrides";
    }
    AlgLiteral _idAlg_1 = alg.getIdAlg();
    String _name_1 = _idAlg_1.getName();
    String _string_1 = _name_1.toString();
    boolean _equals_1 = _string_1.equals("PERMIT_OVER");
    if (_equals_1) {
      return "urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-overrides";
    }
    AlgLiteral _idAlg_2 = alg.getIdAlg();
    String _name_2 = _idAlg_2.getName();
    String _string_2 = _name_2.toString();
    boolean _equals_2 = _string_2.equals("FIRST");
    if (_equals_2) {
      return "urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:first-applicable";
    }
    AlgLiteral _idAlg_3 = alg.getIdAlg();
    String _name_3 = _idAlg_3.getName();
    String _string_3 = _name_3.toString();
    boolean _equals_3 = _string_3.equals("DENY_UNLESS");
    if (_equals_3) {
      return "urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:deny-unless-permit";
    }
    AlgLiteral _idAlg_4 = alg.getIdAlg();
    String _name_4 = _idAlg_4.getName();
    String _string_4 = _name_4.toString();
    boolean _equals_4 = _string_4.equals("PERMIT_UNLESS");
    if (_equals_4) {
      return "urn:oasis:names:tc:xacml:3.0:policy-combining-algorithm:permit-unless-deny";
    }
    AlgLiteral _idAlg_5 = alg.getIdAlg();
    String _name_5 = _idAlg_5.getName();
    String _string_5 = _name_5.toString();
    boolean _equals_5 = _string_5.equals("ONLY_ONE");
    if (_equals_5) {
      return "urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:only-one-applicable";
    }
    return "urn:names:policy-combining-algorithm:personal-algorithm";
  }
  
  public CharSequence compilePol(final FacplPolicy policy) {
    if (policy instanceof PolicySet) {
      return _compilePol((PolicySet)policy);
    } else if (policy instanceof Rule) {
      return _compilePol((Rule)policy);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(policy).toString());
    }
  }
  
  public CharSequence compileIntPol(final FacplPolicy policy) {
    if (policy instanceof PolicySet) {
      return _compileIntPol((PolicySet)policy);
    } else if (policy instanceof Rule) {
      return _compileIntPol((Rule)policy);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(policy).toString());
    }
  }
  
  public TargetTree createTargetTree(final Expression exp) {
    if (exp instanceof AndExpression) {
      return _createTargetTree((AndExpression)exp);
    } else if (exp instanceof Function) {
      return _createTargetTree((Function)exp);
    } else if (exp instanceof NotExpression) {
      return _createTargetTree((NotExpression)exp);
    } else if (exp instanceof OrExpression) {
      return _createTargetTree((OrExpression)exp);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(exp).toString());
    }
  }
  
  public CharSequence getExpression(final Expression e) {
    if (e instanceof AndExpression) {
      return _getExpression((AndExpression)e);
    } else if (e instanceof AttributeName) {
      return _getExpression((AttributeName)e);
    } else if (e instanceof BooleanLiteral) {
      return _getExpression((BooleanLiteral)e);
    } else if (e instanceof DateLiteral) {
      return _getExpression((DateLiteral)e);
    } else if (e instanceof DoubleLiteral) {
      return _getExpression((DoubleLiteral)e);
    } else if (e instanceof Function) {
      return _getExpression((Function)e);
    } else if (e instanceof IntLiteral) {
      return _getExpression((IntLiteral)e);
    } else if (e instanceof NotExpression) {
      return _getExpression((NotExpression)e);
    } else if (e instanceof OrExpression) {
      return _getExpression((OrExpression)e);
    } else if (e instanceof Set) {
      return _getExpression((Set)e);
    } else if (e instanceof StringLiteral) {
      return _getExpression((StringLiteral)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public String getDataType(final Expression exp) {
    if (exp instanceof BooleanLiteral) {
      return _getDataType((BooleanLiteral)exp);
    } else if (exp instanceof DateLiteral) {
      return _getDataType((DateLiteral)exp);
    } else if (exp instanceof DoubleLiteral) {
      return _getDataType((DoubleLiteral)exp);
    } else if (exp instanceof IntLiteral) {
      return _getDataType((IntLiteral)exp);
    } else if (exp instanceof StringLiteral) {
      return _getDataType((StringLiteral)exp);
    } else if (exp instanceof TimeLiteral) {
      return _getDataType((TimeLiteral)exp);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(exp).toString());
    }
  }
}
