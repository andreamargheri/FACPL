package it.unifi.xtext.facpl2.ui.syntaxcoloring

import com.google.inject.Inject
import it.unifi.xtext.facpl.services.Facpl2GrammarAccess
import java.util.Iterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator

class TokenHighlight implements ISemanticHighlightingCalculator {
	
	@Inject	Facpl2GrammarAccess grammarAccess;
	
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
	
	EnumRule ruleTypeLiteral
	
	ParserRule ruleDecFun
	
	
	@Inject
	def FacplSemanticHighlightingCalculator(IGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess as Facpl2GrammarAccess ;
		// get rules from grammar access to make comparisons of rule calls faster
		setupRules();
	}

	private def setupRules() {
		rulePolicySet = grammarAccess.getPolicySetRule();
		ruleRule = grammarAccess.getRuleRule();
		rulePepAlg = grammarAccess.getPEPAlgRule();
		ruleCombAlg = grammarAccess.algLiteralRule
		ruleStrategy = grammarAccess.fulfillmentStrategyRule
		ruleEffect = grammarAccess.getEffectRule();
		ruleFunction = grammarAccess.funIDRule
		ruleString = grammarAccess.getStringLiteralRule();
		ruleBool = grammarAccess.getBooleanLiteralRule();
		ruleAttributeName = grammarAccess.getAttributeNameRule();
		ruleRequest = grammarAccess.getRequestRule();
		ruleset = grammarAccess.getSetRule();
		ruleDate = grammarAccess.getDATERule();
		ruleTime = grammarAccess.getTIMERule();
		ruleTypeLiteral = grammarAccess.typeLiteralRule
		ruleDecFun = grammarAccess.functionDeclarationRule
	}	

	override provideHighlightingFor(XtextResource resource,IHighlightedPositionAcceptor acceptor){
		var Iterator<INode> contents = resource.getParseResult().getRootNode().getAsTreeIterable().iterator();
		
		while(contents.hasNext()){
			var INode node = contents.next();

			var EObject o = node.getGrammarElement();
			if (o instanceof RuleCall){
				//System.out.println(((RuleCall) o).getRule().toString());
				var AbstractRule rule = (o as RuleCall).getRule();
				if (rule == ruleRule ){
					acceptor.addPosition(node.getOffset(), 4, SyntaxHighlighting.POLICY);
				}
				if (rule == rulePolicySet ){
					acceptor.addPosition(node.getOffset(), 9, SyntaxHighlighting.POLICY);
				}
				if (rule == ruleRequest ){
					acceptor.addPosition(node.getOffset(), 8, SyntaxHighlighting.POLICY);
				}
				
				
				if (rule == ruleTypeLiteral){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.STRATEGY )
				}
				if (rule == ruleDecFun){
					acceptor.addPosition(node.getOffset(), 7, SyntaxHighlighting.POLICY )
				}
				
				
				if (rule == rulePepAlg || rule == ruleCombAlg){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.ALG);
				}
				if (rule == ruleStrategy){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.STRATEGY);
				}
				if (rule == ruleEffect){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.EFFECT);
				}				
				if (rule == ruleFunction ){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.FUNCTION);
				}
				//attribute_name
				if (rule == ruleAttributeName){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.STRUCT_NAME);
				}
				//literal
				if (rule == ruleString ){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.STRING_ID);
				}
				if (rule == ruleBool ){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.START_KEYWORD);
				}
				if (rule == ruleDate ){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.DATETIME);
				}
				if (rule == ruleTime ){
					acceptor.addPosition(node.getOffset(), node.getLength(), SyntaxHighlighting.DATETIME);
				}
				//set
				if (rule == ruleset ){
					acceptor.addPosition(node.getOffset(), 10, SyntaxHighlighting.SET);
				}
			}
			if(o instanceof Keyword){
				if ((o as Keyword).getValue().equals("pep:")){
					acceptor.addPosition(node.getOffset(), 7, SyntaxHighlighting.START_KEYWORD);
				}
				if ((o as Keyword).getValue().equals("pdp:")){
					acceptor.addPosition(node.getOffset(), 4, SyntaxHighlighting.START_KEYWORD);
				}
				if ((o as Keyword).getValue().equals("PAS")){
					acceptor.addPosition(node.getOffset(), 3, SyntaxHighlighting.POLICY);
				}
				if ((o as Keyword).getValue().equals("Extended Indeterminate")){
					acceptor.addPosition(node.getOffset(), 24, SyntaxHighlighting.MAIN);
				}
				if ((o as Keyword).getValue().equals("Java Package")){
					acceptor.addPosition(node.getOffset(), 15, SyntaxHighlighting.MAIN);
				}
				if ((o as Keyword).getValue().equals("Requests To Evaluate")){
					acceptor.addPosition(node.getOffset(), 21, SyntaxHighlighting.MAIN);
				}
				if ((o as Keyword).getValue().equals("target:")){
					acceptor.addPosition(node.getOffset(), 7, SyntaxHighlighting.POLICY_KEYWORD);
				}
				if ((o as Keyword).getValue().equals("policies:")){
					acceptor.addPosition(node.getOffset(), 9, SyntaxHighlighting.POLICY_KEYWORD);
				}
				if ((o as Keyword).getValue().equals("obl:")){
					acceptor.addPosition(node.getOffset(), 4, SyntaxHighlighting.POLICY_KEYWORD);
				}
				if ((o as Keyword).getValue().equals("obl-p:")){
					acceptor.addPosition(node.getOffset(), 6, SyntaxHighlighting.POLICY_KEYWORD);
				}
				if ((o as Keyword).getValue().equals("obl-d:")){
					acceptor.addPosition(node.getOffset(), 6, SyntaxHighlighting.POLICY_KEYWORD);
				}
				if ((o as Keyword).getValue().equals("include")){
					acceptor.addPosition(node.getOffset(), 7, SyntaxHighlighting.POLICY_KEYWORD);
				}
				if ((o as Keyword).getValue().equals("import")){
					acceptor.addPosition(node.getOffset(), 7, SyntaxHighlighting.POLICY_KEYWORD);
				}
			}
		}
	}
}