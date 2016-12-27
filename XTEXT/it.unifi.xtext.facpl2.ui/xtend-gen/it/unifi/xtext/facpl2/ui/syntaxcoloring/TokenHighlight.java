package it.unifi.xtext.facpl2.ui.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import it.unifi.xtext.facpl.services.Facpl2GrammarAccess;
import it.unifi.xtext.facpl2.ui.syntaxcoloring.SyntaxHighlighting;
import java.util.Iterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

@SuppressWarnings("all")
public class TokenHighlight implements ISemanticHighlightingCalculator {
  @Inject
  private Facpl2GrammarAccess grammarAccess;
  
  private ParserRule rulePolicySet;
  
  private EnumRule rulePepAlg;
  
  private EnumRule ruleEffect;
  
  private EnumRule ruleFunction;
  
  private ParserRule ruleString;
  
  private ParserRule ruleBool;
  
  private ParserRule ruleAttributeName;
  
  private ParserRule ruleRule;
  
  private ParserRule ruleRequest;
  
  private Object ruleset;
  
  private TerminalRule ruleDate;
  
  private TerminalRule ruleTime;
  
  private EnumRule ruleCombAlg;
  
  private EnumRule ruleStrategy;
  
  private EnumRule ruleTypeLiteral;
  
  private ParserRule ruleDecFun;
  
  @Inject
  public ParserRule FacplSemanticHighlightingCalculator(final IGrammarAccess grammarAccess) {
    ParserRule _xblockexpression = null;
    {
      this.grammarAccess = ((Facpl2GrammarAccess) grammarAccess);
      _xblockexpression = this.setupRules();
    }
    return _xblockexpression;
  }
  
  private ParserRule setupRules() {
    ParserRule _xblockexpression = null;
    {
      ParserRule _policySetRule = this.grammarAccess.getPolicySetRule();
      this.rulePolicySet = _policySetRule;
      ParserRule _ruleRule = this.grammarAccess.getRuleRule();
      this.ruleRule = _ruleRule;
      EnumRule _pEPAlgRule = this.grammarAccess.getPEPAlgRule();
      this.rulePepAlg = _pEPAlgRule;
      EnumRule _algLiteralRule = this.grammarAccess.getAlgLiteralRule();
      this.ruleCombAlg = _algLiteralRule;
      EnumRule _fulfillmentStrategyRule = this.grammarAccess.getFulfillmentStrategyRule();
      this.ruleStrategy = _fulfillmentStrategyRule;
      EnumRule _effectRule = this.grammarAccess.getEffectRule();
      this.ruleEffect = _effectRule;
      EnumRule _funIDRule = this.grammarAccess.getFunIDRule();
      this.ruleFunction = _funIDRule;
      ParserRule _stringLiteralRule = this.grammarAccess.getStringLiteralRule();
      this.ruleString = _stringLiteralRule;
      ParserRule _booleanLiteralRule = this.grammarAccess.getBooleanLiteralRule();
      this.ruleBool = _booleanLiteralRule;
      ParserRule _attributeNameRule = this.grammarAccess.getAttributeNameRule();
      this.ruleAttributeName = _attributeNameRule;
      ParserRule _requestRule = this.grammarAccess.getRequestRule();
      this.ruleRequest = _requestRule;
      ParserRule _setRule = this.grammarAccess.getSetRule();
      this.ruleset = _setRule;
      TerminalRule _dATERule = this.grammarAccess.getDATERule();
      this.ruleDate = _dATERule;
      TerminalRule _tIMERule = this.grammarAccess.getTIMERule();
      this.ruleTime = _tIMERule;
      EnumRule _typeLiteralRule = this.grammarAccess.getTypeLiteralRule();
      this.ruleTypeLiteral = _typeLiteralRule;
      ParserRule _functionDeclarationRule = this.grammarAccess.getFunctionDeclarationRule();
      _xblockexpression = this.ruleDecFun = _functionDeclarationRule;
    }
    return _xblockexpression;
  }
  
  @Override
  public void provideHighlightingFor(final XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
    IParseResult _parseResult = resource.getParseResult();
    ICompositeNode _rootNode = _parseResult.getRootNode();
    BidiTreeIterable<INode> _asTreeIterable = _rootNode.getAsTreeIterable();
    Iterator<INode> contents = _asTreeIterable.iterator();
    while (contents.hasNext()) {
      {
        INode node = contents.next();
        EObject o = node.getGrammarElement();
        if ((o instanceof RuleCall)) {
          AbstractRule rule = ((RuleCall) o).getRule();
          boolean _equals = Objects.equal(rule, this.ruleRule);
          if (_equals) {
            int _offset = node.getOffset();
            acceptor.addPosition(_offset, 4, SyntaxHighlighting.POLICY);
          }
          boolean _equals_1 = Objects.equal(rule, this.rulePolicySet);
          if (_equals_1) {
            int _offset_1 = node.getOffset();
            acceptor.addPosition(_offset_1, 9, SyntaxHighlighting.POLICY);
          }
          boolean _equals_2 = Objects.equal(rule, this.ruleRequest);
          if (_equals_2) {
            int _offset_2 = node.getOffset();
            acceptor.addPosition(_offset_2, 8, SyntaxHighlighting.POLICY);
          }
          boolean _equals_3 = Objects.equal(rule, this.ruleTypeLiteral);
          if (_equals_3) {
            int _offset_3 = node.getOffset();
            int _length = node.getLength();
            acceptor.addPosition(_offset_3, _length, SyntaxHighlighting.STRATEGY);
          }
          boolean _equals_4 = Objects.equal(rule, this.ruleDecFun);
          if (_equals_4) {
            int _offset_4 = node.getOffset();
            acceptor.addPosition(_offset_4, 7, SyntaxHighlighting.POLICY);
          }
          if ((Objects.equal(rule, this.rulePepAlg) || Objects.equal(rule, this.ruleCombAlg))) {
            int _offset_5 = node.getOffset();
            int _length_1 = node.getLength();
            acceptor.addPosition(_offset_5, _length_1, SyntaxHighlighting.ALG);
          }
          boolean _equals_5 = Objects.equal(rule, this.ruleStrategy);
          if (_equals_5) {
            int _offset_6 = node.getOffset();
            int _length_2 = node.getLength();
            acceptor.addPosition(_offset_6, _length_2, SyntaxHighlighting.STRATEGY);
          }
          boolean _equals_6 = Objects.equal(rule, this.ruleEffect);
          if (_equals_6) {
            int _offset_7 = node.getOffset();
            int _length_3 = node.getLength();
            acceptor.addPosition(_offset_7, _length_3, SyntaxHighlighting.EFFECT);
          }
          boolean _equals_7 = Objects.equal(rule, this.ruleFunction);
          if (_equals_7) {
            int _offset_8 = node.getOffset();
            int _length_4 = node.getLength();
            acceptor.addPosition(_offset_8, _length_4, SyntaxHighlighting.FUNCTION);
          }
          boolean _equals_8 = Objects.equal(rule, this.ruleAttributeName);
          if (_equals_8) {
            int _offset_9 = node.getOffset();
            int _length_5 = node.getLength();
            acceptor.addPosition(_offset_9, _length_5, SyntaxHighlighting.STRUCT_NAME);
          }
          boolean _equals_9 = Objects.equal(rule, this.ruleString);
          if (_equals_9) {
            int _offset_10 = node.getOffset();
            int _length_6 = node.getLength();
            acceptor.addPosition(_offset_10, _length_6, SyntaxHighlighting.STRING_ID);
          }
          boolean _equals_10 = Objects.equal(rule, this.ruleBool);
          if (_equals_10) {
            int _offset_11 = node.getOffset();
            int _length_7 = node.getLength();
            acceptor.addPosition(_offset_11, _length_7, SyntaxHighlighting.START_KEYWORD);
          }
          boolean _equals_11 = Objects.equal(rule, this.ruleDate);
          if (_equals_11) {
            int _offset_12 = node.getOffset();
            int _length_8 = node.getLength();
            acceptor.addPosition(_offset_12, _length_8, SyntaxHighlighting.DATETIME);
          }
          boolean _equals_12 = Objects.equal(rule, this.ruleTime);
          if (_equals_12) {
            int _offset_13 = node.getOffset();
            int _length_9 = node.getLength();
            acceptor.addPosition(_offset_13, _length_9, SyntaxHighlighting.DATETIME);
          }
          boolean _equals_13 = Objects.equal(rule, this.ruleset);
          if (_equals_13) {
            int _offset_14 = node.getOffset();
            acceptor.addPosition(_offset_14, 10, SyntaxHighlighting.SET);
          }
        }
        if ((o instanceof Keyword)) {
          String _value = ((Keyword) o).getValue();
          boolean _equals_14 = _value.equals("pep:");
          if (_equals_14) {
            int _offset_15 = node.getOffset();
            acceptor.addPosition(_offset_15, 7, SyntaxHighlighting.START_KEYWORD);
          }
          String _value_1 = ((Keyword) o).getValue();
          boolean _equals_15 = _value_1.equals("pdp:");
          if (_equals_15) {
            int _offset_16 = node.getOffset();
            acceptor.addPosition(_offset_16, 4, SyntaxHighlighting.START_KEYWORD);
          }
          String _value_2 = ((Keyword) o).getValue();
          boolean _equals_16 = _value_2.equals("PAS");
          if (_equals_16) {
            int _offset_17 = node.getOffset();
            acceptor.addPosition(_offset_17, 3, SyntaxHighlighting.POLICY);
          }
          String _value_3 = ((Keyword) o).getValue();
          boolean _equals_17 = _value_3.equals("Extended Indeterminate");
          if (_equals_17) {
            int _offset_18 = node.getOffset();
            acceptor.addPosition(_offset_18, 24, SyntaxHighlighting.MAIN);
          }
          String _value_4 = ((Keyword) o).getValue();
          boolean _equals_18 = _value_4.equals("Java Package");
          if (_equals_18) {
            int _offset_19 = node.getOffset();
            acceptor.addPosition(_offset_19, 15, SyntaxHighlighting.MAIN);
          }
          String _value_5 = ((Keyword) o).getValue();
          boolean _equals_19 = _value_5.equals("Requests To Evaluate");
          if (_equals_19) {
            int _offset_20 = node.getOffset();
            acceptor.addPosition(_offset_20, 21, SyntaxHighlighting.MAIN);
          }
          String _value_6 = ((Keyword) o).getValue();
          boolean _equals_20 = _value_6.equals("target:");
          if (_equals_20) {
            int _offset_21 = node.getOffset();
            acceptor.addPosition(_offset_21, 7, SyntaxHighlighting.POLICY_KEYWORD);
          }
          String _value_7 = ((Keyword) o).getValue();
          boolean _equals_21 = _value_7.equals("policies:");
          if (_equals_21) {
            int _offset_22 = node.getOffset();
            acceptor.addPosition(_offset_22, 9, SyntaxHighlighting.POLICY_KEYWORD);
          }
          String _value_8 = ((Keyword) o).getValue();
          boolean _equals_22 = _value_8.equals("obl:");
          if (_equals_22) {
            int _offset_23 = node.getOffset();
            acceptor.addPosition(_offset_23, 4, SyntaxHighlighting.POLICY_KEYWORD);
          }
          String _value_9 = ((Keyword) o).getValue();
          boolean _equals_23 = _value_9.equals("obl-p:");
          if (_equals_23) {
            int _offset_24 = node.getOffset();
            acceptor.addPosition(_offset_24, 6, SyntaxHighlighting.POLICY_KEYWORD);
          }
          String _value_10 = ((Keyword) o).getValue();
          boolean _equals_24 = _value_10.equals("obl-d:");
          if (_equals_24) {
            int _offset_25 = node.getOffset();
            acceptor.addPosition(_offset_25, 6, SyntaxHighlighting.POLICY_KEYWORD);
          }
          String _value_11 = ((Keyword) o).getValue();
          boolean _equals_25 = _value_11.equals("include");
          if (_equals_25) {
            int _offset_26 = node.getOffset();
            acceptor.addPosition(_offset_26, 7, SyntaxHighlighting.POLICY_KEYWORD);
          }
          String _value_12 = ((Keyword) o).getValue();
          boolean _equals_26 = _value_12.equals("import");
          if (_equals_26) {
            int _offset_27 = node.getOffset();
            acceptor.addPosition(_offset_27, 7, SyntaxHighlighting.POLICY_KEYWORD);
          }
        }
      }
    }
  }
}
