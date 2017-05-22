/*
 * generated by Xtext
 */
package it.unifi.xtext.facpl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import it.unifi.xtext.facpl.services.Facpl2GrammarAccess;

public class Facpl2Parser extends AbstractContentAssistParser {
	
	@Inject
	private Facpl2GrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected it.unifi.xtext.facpl.ui.contentassist.antlr.internal.InternalFacpl2Parser createParser() {
		it.unifi.xtext.facpl.ui.contentassist.antlr.internal.InternalFacpl2Parser result = new it.unifi.xtext.facpl.ui.contentassist.antlr.internal.InternalFacpl2Parser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getSTRING_OAccess().getAlternatives_1_0(), "rule__STRING_O__Alternatives_1_0");
					put(grammarAccess.getFacplPolicyAccess().getAlternatives(), "rule__FacplPolicy__Alternatives");
					put(grammarAccess.getAbstractPolicyInclAccess().getAlternatives(), "rule__AbstractPolicyIncl__Alternatives");
					put(grammarAccess.getObligationAccess().getTypeOblAlternatives_1_0(), "rule__Obligation__TypeOblAlternatives_1_0");
					put(grammarAccess.getBasicExpressionAccess().getAlternatives(), "rule__BasicExpression__Alternatives");
					put(grammarAccess.getLiteralsAccess().getAlternatives(), "rule__Literals__Alternatives");
					put(grammarAccess.getTypeLiteralAccess().getAlternatives(), "rule__TypeLiteral__Alternatives");
					put(grammarAccess.getPEPAlgAccess().getAlternatives(), "rule__PEPAlg__Alternatives");
					put(grammarAccess.getAlgLiteralAccess().getAlternatives(), "rule__AlgLiteral__Alternatives");
					put(grammarAccess.getFulfillmentStrategyAccess().getAlternatives(), "rule__FulfillmentStrategy__Alternatives");
					put(grammarAccess.getEffectAccess().getAlternatives(), "rule__Effect__Alternatives");
					put(grammarAccess.getFunIDAccess().getAlternatives(), "rule__FunID__Alternatives");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getMainFacplAccess().getGroup(), "rule__MainFacpl__Group__0");
					put(grammarAccess.getMainFacplAccess().getGroup_6(), "rule__MainFacpl__Group_6__0");
					put(grammarAccess.getMainFacplAccess().getGroup_7(), "rule__MainFacpl__Group_7__0");
					put(grammarAccess.getMainFacplAccess().getGroup_7_2(), "rule__MainFacpl__Group_7_2__0");
					put(grammarAccess.getMainFacplAccess().getGroup_7_2_1(), "rule__MainFacpl__Group_7_2_1__0");
					put(grammarAccess.getFunctionDeclarationAccess().getGroup(), "rule__FunctionDeclaration__Group__0");
					put(grammarAccess.getFunctionDeclarationAccess().getGroup_5(), "rule__FunctionDeclaration__Group_5__0");
					put(grammarAccess.getPAFAccess().getGroup(), "rule__PAF__Group__0");
					put(grammarAccess.getRequestAccess().getGroup(), "rule__Request__Group__0");
					put(grammarAccess.getRequestAccess().getGroup_1(), "rule__Request__Group_1__0");
					put(grammarAccess.getAttributeReqAccess().getGroup(), "rule__AttributeReq__Group__0");
					put(grammarAccess.getAttributeReqAccess().getGroup_4(), "rule__AttributeReq__Group_4__0");
					put(grammarAccess.getAttributeNameAccess().getGroup(), "rule__AttributeName__Group__0");
					put(grammarAccess.getSTRING_OAccess().getGroup(), "rule__STRING_O__Group__0");
					put(grammarAccess.getSTRING_OAccess().getGroup_1(), "rule__STRING_O__Group_1__0");
					put(grammarAccess.getPDPAccess().getGroup(), "rule__PDP__Group__0");
					put(grammarAccess.getAbstractPolicyInclAccess().getGroup_1(), "rule__AbstractPolicyIncl__Group_1__0");
					put(grammarAccess.getPolicySetAccess().getGroup(), "rule__PolicySet__Group__0");
					put(grammarAccess.getPolicySetAccess().getGroup_4(), "rule__PolicySet__Group_4__0");
					put(grammarAccess.getPolicySetAccess().getGroup_7(), "rule__PolicySet__Group_7__0");
					put(grammarAccess.getPolicySetAccess().getGroup_8(), "rule__PolicySet__Group_8__0");
					put(grammarAccess.getAlgAccess().getGroup(), "rule__Alg__Group__0");
					put(grammarAccess.getAlgAccess().getGroup_1(), "rule__Alg__Group_1__0");
					put(grammarAccess.getRuleAccess().getGroup(), "rule__Rule__Group__0");
					put(grammarAccess.getRuleAccess().getGroup_4(), "rule__Rule__Group_4__0");
					put(grammarAccess.getRuleAccess().getGroup_5(), "rule__Rule__Group_5__0");
					put(grammarAccess.getObligationAccess().getGroup(), "rule__Obligation__Group__0");
					put(grammarAccess.getObligationAccess().getGroup_4(), "rule__Obligation__Group_4__0");
					put(grammarAccess.getObligationAccess().getGroup_4_1(), "rule__Obligation__Group_4_1__0");
					put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
					put(grammarAccess.getOrExpressionAccess().getGroup(), "rule__OrExpression__Group__0");
					put(grammarAccess.getOrExpressionAccess().getGroup_1(), "rule__OrExpression__Group_1__0");
					put(grammarAccess.getBasicExpressionAccess().getGroup_3(), "rule__BasicExpression__Group_3__0");
					put(grammarAccess.getNotExpressionAccess().getGroup(), "rule__NotExpression__Group__0");
					put(grammarAccess.getFunctionAccess().getGroup(), "rule__Function__Group__0");
					put(grammarAccess.getDeclaredFunctionAccess().getGroup(), "rule__DeclaredFunction__Group__0");
					put(grammarAccess.getDeclaredFunctionAccess().getGroup_3(), "rule__DeclaredFunction__Group_3__0");
					put(grammarAccess.getMapFunctionAccess().getGroup(), "rule__MapFunction__Group__0");
					put(grammarAccess.getSetAccess().getGroup(), "rule__Set__Group__0");
					put(grammarAccess.getSetAccess().getGroup_1(), "rule__Set__Group_1__0");
					put(grammarAccess.getSetAccess().getGroup_1_1(), "rule__Set__Group_1_1__0");
					put(grammarAccess.getFacplAccess().getImportElAssignment_0(), "rule__Facpl__ImportElAssignment_0");
					put(grammarAccess.getFacplAccess().getDeclarationsAssignment_1(), "rule__Facpl__DeclarationsAssignment_1");
					put(grammarAccess.getFacplAccess().getPoliciesAssignment_2(), "rule__Facpl__PoliciesAssignment_2");
					put(grammarAccess.getFacplAccess().getRequestsAssignment_3(), "rule__Facpl__RequestsAssignment_3");
					put(grammarAccess.getFacplAccess().getMainAssignment_4(), "rule__Facpl__MainAssignment_4");
					put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
					put(grammarAccess.getMainFacplAccess().getExtIndetAssignment_4(), "rule__MainFacpl__ExtIndetAssignment_4");
					put(grammarAccess.getMainFacplAccess().getGenPackageAssignment_6_2(), "rule__MainFacpl__GenPackageAssignment_6_2");
					put(grammarAccess.getMainFacplAccess().getRefRequestAssignment_7_2_0(), "rule__MainFacpl__RefRequestAssignment_7_2_0");
					put(grammarAccess.getMainFacplAccess().getRefRequestAssignment_7_2_1_1(), "rule__MainFacpl__RefRequestAssignment_7_2_1_1");
					put(grammarAccess.getMainFacplAccess().getPafAssignment_8(), "rule__MainFacpl__PafAssignment_8");
					put(grammarAccess.getFunctionDeclarationAccess().getTypeAssignment_1(), "rule__FunctionDeclaration__TypeAssignment_1");
					put(grammarAccess.getFunctionDeclarationAccess().getNameAssignment_2(), "rule__FunctionDeclaration__NameAssignment_2");
					put(grammarAccess.getFunctionDeclarationAccess().getArgsAssignment_4(), "rule__FunctionDeclaration__ArgsAssignment_4");
					put(grammarAccess.getFunctionDeclarationAccess().getArgsAssignment_5_1(), "rule__FunctionDeclaration__ArgsAssignment_5_1");
					put(grammarAccess.getPAFAccess().getPepAssignment_1(), "rule__PAF__PepAssignment_1");
					put(grammarAccess.getPAFAccess().getPdpAssignment_3(), "rule__PAF__PdpAssignment_3");
					put(grammarAccess.getRequestAccess().getStubAssignment_1_1(), "rule__Request__StubAssignment_1_1");
					put(grammarAccess.getRequestAccess().getNameAssignment_3(), "rule__Request__NameAssignment_3");
					put(grammarAccess.getRequestAccess().getAttributesAssignment_4(), "rule__Request__AttributesAssignment_4");
					put(grammarAccess.getAttributeReqAccess().getNameAssignment_1(), "rule__AttributeReq__NameAssignment_1");
					put(grammarAccess.getAttributeReqAccess().getValueAssignment_3(), "rule__AttributeReq__ValueAssignment_3");
					put(grammarAccess.getAttributeReqAccess().getValueAssignment_4_1(), "rule__AttributeReq__ValueAssignment_4_1");
					put(grammarAccess.getAttributeNameAccess().getCategoryAssignment_0(), "rule__AttributeName__CategoryAssignment_0");
					put(grammarAccess.getAttributeNameAccess().getIdAssignment_2(), "rule__AttributeName__IdAssignment_2");
					put(grammarAccess.getPDPAccess().getPdpAlgAssignment_0(), "rule__PDP__PdpAlgAssignment_0");
					put(grammarAccess.getPDPAccess().getPolSetAssignment_1(), "rule__PDP__PolSetAssignment_1");
					put(grammarAccess.getAbstractPolicyInclAccess().getNewPolicyAssignment_0(), "rule__AbstractPolicyIncl__NewPolicyAssignment_0");
					put(grammarAccess.getAbstractPolicyInclAccess().getRefPolAssignment_1_1(), "rule__AbstractPolicyIncl__RefPolAssignment_1_1");
					put(grammarAccess.getPolicySetAccess().getNameAssignment_1(), "rule__PolicySet__NameAssignment_1");
					put(grammarAccess.getPolicySetAccess().getPolSetAlgAssignment_3(), "rule__PolicySet__PolSetAlgAssignment_3");
					put(grammarAccess.getPolicySetAccess().getTargetAssignment_4_1(), "rule__PolicySet__TargetAssignment_4_1");
					put(grammarAccess.getPolicySetAccess().getPoliciesAssignment_6(), "rule__PolicySet__PoliciesAssignment_6");
					put(grammarAccess.getPolicySetAccess().getOblpAssignment_7_1(), "rule__PolicySet__OblpAssignment_7_1");
					put(grammarAccess.getPolicySetAccess().getObldAssignment_8_1(), "rule__PolicySet__ObldAssignment_8_1");
					put(grammarAccess.getAlgAccess().getIdAlgAssignment_0(), "rule__Alg__IdAlgAssignment_0");
					put(grammarAccess.getAlgAccess().getFStrategyAssignment_1_1(), "rule__Alg__FStrategyAssignment_1_1");
					put(grammarAccess.getRuleAccess().getNameAssignment_1(), "rule__Rule__NameAssignment_1");
					put(grammarAccess.getRuleAccess().getEffectAssignment_3(), "rule__Rule__EffectAssignment_3");
					put(grammarAccess.getRuleAccess().getTargetAssignment_4_1(), "rule__Rule__TargetAssignment_4_1");
					put(grammarAccess.getRuleAccess().getOblAssignment_5_1(), "rule__Rule__OblAssignment_5_1");
					put(grammarAccess.getObligationAccess().getTypeOblAssignment_1(), "rule__Obligation__TypeOblAssignment_1");
					put(grammarAccess.getObligationAccess().getPepActionAssignment_2(), "rule__Obligation__PepActionAssignment_2");
					put(grammarAccess.getObligationAccess().getExprAssignment_4_0(), "rule__Obligation__ExprAssignment_4_0");
					put(grammarAccess.getObligationAccess().getExprAssignment_4_1_1(), "rule__Obligation__ExprAssignment_4_1_1");
					put(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2(), "rule__AndExpression__RightAssignment_1_2");
					put(grammarAccess.getOrExpressionAccess().getRightAssignment_1_2(), "rule__OrExpression__RightAssignment_1_2");
					put(grammarAccess.getNotExpressionAccess().getArgAssignment_1(), "rule__NotExpression__ArgAssignment_1");
					put(grammarAccess.getFunctionAccess().getFunctionIdAssignment_0(), "rule__Function__FunctionIdAssignment_0");
					put(grammarAccess.getFunctionAccess().getArg1Assignment_2(), "rule__Function__Arg1Assignment_2");
					put(grammarAccess.getFunctionAccess().getArg2Assignment_4(), "rule__Function__Arg2Assignment_4");
					put(grammarAccess.getDeclaredFunctionAccess().getFunctionIdAssignment_0(), "rule__DeclaredFunction__FunctionIdAssignment_0");
					put(grammarAccess.getDeclaredFunctionAccess().getArgsAssignment_2(), "rule__DeclaredFunction__ArgsAssignment_2");
					put(grammarAccess.getDeclaredFunctionAccess().getArgsAssignment_3_1(), "rule__DeclaredFunction__ArgsAssignment_3_1");
					put(grammarAccess.getMapFunctionAccess().getFunctionIDAssignment_1(), "rule__MapFunction__FunctionIDAssignment_1");
					put(grammarAccess.getMapFunctionAccess().getArg1Assignment_3(), "rule__MapFunction__Arg1Assignment_3");
					put(grammarAccess.getMapFunctionAccess().getArg2Assignment_5(), "rule__MapFunction__Arg2Assignment_5");
					put(grammarAccess.getSetAccess().getArgsAssignment_1_0(), "rule__Set__ArgsAssignment_1_0");
					put(grammarAccess.getSetAccess().getArgsAssignment_1_1_1(), "rule__Set__ArgsAssignment_1_1_1");
					put(grammarAccess.getStringLiteralAccess().getValueAssignment(), "rule__StringLiteral__ValueAssignment");
					put(grammarAccess.getBooleanLiteralAccess().getValueAssignment(), "rule__BooleanLiteral__ValueAssignment");
					put(grammarAccess.getIntLiteralAccess().getValueAssignment(), "rule__IntLiteral__ValueAssignment");
					put(grammarAccess.getDoubleLiteralAccess().getValueAssignment(), "rule__DoubleLiteral__ValueAssignment");
					put(grammarAccess.getDateLiteralAccess().getValueAssignment(), "rule__DateLiteral__ValueAssignment");
					put(grammarAccess.getTimeLiteralAccess().getValueAssignment(), "rule__TimeLiteral__ValueAssignment");
					put(grammarAccess.getFacplAccess().getUnorderedGroup(), "rule__Facpl__UnorderedGroup");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			it.unifi.xtext.facpl.ui.contentassist.antlr.internal.InternalFacpl2Parser typedParser = (it.unifi.xtext.facpl.ui.contentassist.antlr.internal.InternalFacpl2Parser) parser;
			typedParser.entryRuleFacpl();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public Facpl2GrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(Facpl2GrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
