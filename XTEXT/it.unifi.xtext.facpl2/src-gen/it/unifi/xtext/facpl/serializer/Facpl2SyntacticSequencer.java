/*
 * generated by Xtext
 */
package it.unifi.xtext.facpl.serializer;

import com.google.inject.Inject;
import it.unifi.xtext.facpl.services.Facpl2GrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class Facpl2SyntacticSequencer extends AbstractSyntacticSequencer {

	protected Facpl2GrammarAccess grammarAccess;
	protected AbstractElementAlias match_BasicExpression_LeftParenthesisKeyword_2_0_a;
	protected AbstractElementAlias match_BasicExpression_LeftParenthesisKeyword_2_0_p;
	protected AbstractElementAlias match_PolicySet_OblDKeyword_8_0_q;
	protected AbstractElementAlias match_PolicySet_OblPKeyword_7_0_q;
	protected AbstractElementAlias match_Rule_OblKeyword_5_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (Facpl2GrammarAccess) access;
		match_BasicExpression_LeftParenthesisKeyword_2_0_a = new TokenAlias(true, true, grammarAccess.getBasicExpressionAccess().getLeftParenthesisKeyword_2_0());
		match_BasicExpression_LeftParenthesisKeyword_2_0_p = new TokenAlias(true, false, grammarAccess.getBasicExpressionAccess().getLeftParenthesisKeyword_2_0());
		match_PolicySet_OblDKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getPolicySetAccess().getOblDKeyword_8_0());
		match_PolicySet_OblPKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getPolicySetAccess().getOblPKeyword_7_0());
		match_Rule_OblKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getRuleAccess().getOblKeyword_5_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_BasicExpression_LeftParenthesisKeyword_2_0_a.equals(syntax))
				emit_BasicExpression_LeftParenthesisKeyword_2_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_BasicExpression_LeftParenthesisKeyword_2_0_p.equals(syntax))
				emit_BasicExpression_LeftParenthesisKeyword_2_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PolicySet_OblDKeyword_8_0_q.equals(syntax))
				emit_PolicySet_OblDKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PolicySet_OblPKeyword_7_0_q.equals(syntax))
				emit_PolicySet_OblPKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Rule_OblKeyword_5_0_q.equals(syntax))
				emit_Rule_OblKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' arg=BasicExpression
	 *     (rule start) (ambiguity) 'set(' args+=Literals
	 *     (rule start) (ambiguity) category=STRING_O
	 *     (rule start) (ambiguity) functionId=[FunctionDeclaration|ID]
	 *     (rule start) (ambiguity) functionId=funID
	 *     (rule start) (ambiguity) value=BOOLEAN
	 *     (rule start) (ambiguity) value=DATE
	 *     (rule start) (ambiguity) value=INT
	 *     (rule start) (ambiguity) value=REAL
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) value=TIME
	 *     (rule start) (ambiguity) {AndExpression.left=}
	 *     (rule start) (ambiguity) {OrExpression.left=}
	 */
	protected void emit_BasicExpression_LeftParenthesisKeyword_2_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {AndExpression.left=}
	 *     (rule start) (ambiguity) {OrExpression.left=}
	 */
	protected void emit_BasicExpression_LeftParenthesisKeyword_2_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'obl-d:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     oblp+=Obligation (ambiguity) '}' (rule end)
	 *     policies+=AbstractPolicyIncl 'obl-p:'? (ambiguity) '}' (rule end)
	 */
	protected void emit_PolicySet_OblDKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'obl-p:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     policies+=AbstractPolicyIncl (ambiguity) 'obl-d:' obld+=Obligation
	 *     policies+=AbstractPolicyIncl (ambiguity) 'obl-d:'? '}' (rule end)
	 */
	protected void emit_PolicySet_OblPKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'obl:'?
	 *
	 * This ambiguous syntax occurs at:
	 *     effect=Effect (ambiguity) ')' (rule end)
	 *     target=Expression (ambiguity) ')' (rule end)
	 */
	protected void emit_Rule_OblKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
