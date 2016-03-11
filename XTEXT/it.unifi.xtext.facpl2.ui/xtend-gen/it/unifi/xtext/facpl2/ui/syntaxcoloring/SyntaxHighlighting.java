package it.unifi.xtext.facpl2.ui.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

@SuppressWarnings("all")
public class SyntaxHighlighting extends DefaultHighlightingConfiguration {
  public final static String POLICY = "policy";
  
  public final static String ID = "id";
  
  public final static String ALG = "algorithm";
  
  public final static String STRATEGY = "fulfillmentstragey";
  
  public final static String EFFECT = "effect";
  
  public final static String START_KEYWORD = "start keyword";
  
  public final static String POLICY_KEYWORD = "policy keyword";
  
  public final static String FUNCTION = "match function";
  
  public final static String STRING_ID = "string";
  
  public final static String NUMBER = "number";
  
  public final static String STRUCT_NAME = "structured name";
  
  public final static String DATETIME = "datetime";
  
  public final static String SET = "set";
  
  public final static String MAIN = "main";
  
  @Override
  public void configure(final IHighlightingConfigurationAcceptor acceptor) {
    TextStyle _policyTextStyle = this.policyTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.POLICY, "Policy", _policyTextStyle);
    TextStyle _idTextStyle = this.idTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.ID, "Id", _idTextStyle);
    TextStyle _algTextStyle = this.algTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.ALG, "Algorithm", _algTextStyle);
    TextStyle _strategyTextStyle = this.strategyTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.STRATEGY, "Strategy", _strategyTextStyle);
    TextStyle _effectTextStyle = this.effectTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.EFFECT, "Effect", _effectTextStyle);
    TextStyle _startTextStyle = this.startTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.START_KEYWORD, "Start Keyword", _startTextStyle);
    TextStyle _policyKeyTextStyle = this.policyKeyTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.POLICY_KEYWORD, "Policy Keyword", _policyKeyTextStyle);
    TextStyle _functionTextStyle = this.functionTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.FUNCTION, "Match Function", _functionTextStyle);
    TextStyle _stringTextStyle = this.stringTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.STRING_ID, "String_ID", _stringTextStyle);
    TextStyle _numberTextStyle = this.numberTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.NUMBER, "Number", _numberTextStyle);
    TextStyle _attributeTextStyle = this.attributeTextStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.STRUCT_NAME, "Structured Name", _attributeTextStyle);
    TextStyle _stringSetStyle = this.stringSetStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.SET, "Set value", _stringSetStyle);
    TextStyle _stringMainStyle = this.stringMainStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.MAIN, "Main option", _stringMainStyle);
    TextStyle _dateStyle = this.dateStyle();
    acceptor.acceptDefaultHighlighting(SyntaxHighlighting.DATETIME, "DateTime", _dateStyle);
  }
  
  public TextStyle effectTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(208, 32, 144);
    textStyle.setColor(_rGB);
    return textStyle;
  }
  
  public TextStyle functionTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(0, 0, 156);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.ITALIC);
    return textStyle;
  }
  
  public TextStyle dateStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(180, 40, 40);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle algTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(1, 100, 1);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle strategyTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(1, 1, 100);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle policyTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(255, 127, 0);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle policyKeyTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(100, 10, 10);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle stringSetStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(131, 111, 255);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.ITALIC);
    return textStyle;
  }
  
  public TextStyle stringMainStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(58, 95, 205);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle attributeTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(138, 43, 226);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle startTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(100, 10, 10);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.BOLD);
    return textStyle;
  }
  
  public TextStyle idTextStyle() {
    TextStyle _defaultTextStyle = this.defaultTextStyle();
    TextStyle textStyle = _defaultTextStyle.copy();
    RGB _rGB = new RGB(1, 1, 100);
    textStyle.setColor(_rGB);
    textStyle.setStyle(SWT.ITALIC);
    return textStyle;
  }
}
