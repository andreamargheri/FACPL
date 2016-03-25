/*
 * generated by Xtext
 */
package it.unifi.xtext.facpl.serializer;

import com.google.inject.Inject;
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Alg;
import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.Attribute;
import it.unifi.xtext.facpl.facpl2.AttributeDeclaration;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DeclaredFunction;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
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
import it.unifi.xtext.facpl.facpl2.PepFunction;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.facpl2.Rule;
import it.unifi.xtext.facpl.facpl2.STATUS;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TimeLiteral;
import it.unifi.xtext.facpl.services.Facpl2GrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class Facpl2SemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Facpl2GrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Facpl2Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Facpl2Package.ABSTRACT_POLICY_INCL:
				sequence_AbstractPolicyIncl(context, (AbstractPolicyIncl) semanticObject); 
				return; 
			case Facpl2Package.ALG:
				sequence_Alg(context, (Alg) semanticObject); 
				return; 
			case Facpl2Package.AND_EXPRESSION:
				sequence_AndExpression(context, (AndExpression) semanticObject); 
				return; 
			case Facpl2Package.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case Facpl2Package.ATTRIBUTE_DECLARATION:
				sequence_AttributeDeclaration(context, (AttributeDeclaration) semanticObject); 
				return; 
			case Facpl2Package.ATTRIBUTE_NAME:
				sequence_AttributeName(context, (AttributeName) semanticObject); 
				return; 
			case Facpl2Package.ATTRIBUTE_REQ:
				sequence_AttributeReq(context, (AttributeReq) semanticObject); 
				return; 
			case Facpl2Package.BOOLEAN_LITERAL:
				sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
				return; 
			case Facpl2Package.DATE_LITERAL:
				sequence_DateLiteral(context, (DateLiteral) semanticObject); 
				return; 
			case Facpl2Package.DECLARED_FUNCTION:
				sequence_DeclaredFunction(context, (DeclaredFunction) semanticObject); 
				return; 
			case Facpl2Package.DOUBLE_LITERAL:
				sequence_DoubleLiteral(context, (DoubleLiteral) semanticObject); 
				return; 
			case Facpl2Package.FACPL:
				sequence_Facpl(context, (Facpl) semanticObject); 
				return; 
			case Facpl2Package.FUNCTION:
				sequence_Function(context, (Function) semanticObject); 
				return; 
			case Facpl2Package.FUNCTION_DECLARATION:
				sequence_FunctionDeclaration(context, (FunctionDeclaration) semanticObject); 
				return; 
			case Facpl2Package.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case Facpl2Package.INT_LITERAL:
				sequence_IntLiteral(context, (IntLiteral) semanticObject); 
				return; 
			case Facpl2Package.MAIN_FACPL:
				sequence_MainFacpl(context, (MainFacpl) semanticObject); 
				return; 
			case Facpl2Package.NOT_EXPRESSION:
				sequence_NotExpression(context, (NotExpression) semanticObject); 
				return; 
			case Facpl2Package.OBLIGATION:
				sequence_Obligation(context, (Obligation) semanticObject); 
				return; 
			case Facpl2Package.OR_EXPRESSION:
				sequence_OrExpression(context, (OrExpression) semanticObject); 
				return; 
			case Facpl2Package.PAF:
				sequence_PAF(context, (PAF) semanticObject); 
				return; 
			case Facpl2Package.PDP:
				sequence_PDP(context, (PDP) semanticObject); 
				return; 
			case Facpl2Package.PEP_FUNCTION:
				sequence_PepFunction(context, (PepFunction) semanticObject); 
				return; 
			case Facpl2Package.POLICY_SET:
				sequence_PolicySet(context, (PolicySet) semanticObject); 
				return; 
			case Facpl2Package.REQUEST:
				sequence_Request(context, (Request) semanticObject); 
				return; 
			case Facpl2Package.RULE:
				sequence_Rule(context, (Rule) semanticObject); 
				return; 
			case Facpl2Package.STATUS:
				sequence_STATUS(context, (STATUS) semanticObject); 
				return; 
			case Facpl2Package.SET:
				sequence_Set(context, (it.unifi.xtext.facpl.facpl2.Set) semanticObject); 
				return; 
			case Facpl2Package.STRING_LITERAL:
				sequence_StringLiteral(context, (StringLiteral) semanticObject); 
				return; 
			case Facpl2Package.TIME_LITERAL:
				sequence_TimeLiteral(context, (TimeLiteral) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AbstractPolicyIncl returns AbstractPolicyIncl
	 *
	 * Constraint:
	 *     (newPolicy=FacplPolicy | refPol=[PolicySet|ID])
	 */
	protected void sequence_AbstractPolicyIncl(ISerializationContext context, AbstractPolicyIncl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Alg returns Alg
	 *
	 * Constraint:
	 *     (idAlg=AlgLiteral fStrategy=FulfillmentStrategy?)
	 */
	protected void sequence_Alg(ISerializationContext context, Alg semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns AndExpression
	 *     AndExpression returns AndExpression
	 *     AndExpression.AndExpression_1_0 returns AndExpression
	 *     OrExpression returns AndExpression
	 *     OrExpression.OrExpression_1_0 returns AndExpression
	 *     BasicExpression returns AndExpression
	 *
	 * Constraint:
	 *     (left=AndExpression_AndExpression_1_0 right=OrExpression)
	 */
	protected void sequence_AndExpression(ISerializationContext context, AndExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.AND_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.AND_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.AND_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.AND_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAndExpressionAccess().getRightOrExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AttributeDeclaration returns AttributeDeclaration
	 *
	 * Constraint:
	 *     att=Attribute
	 */
	protected void sequence_AttributeDeclaration(ISerializationContext context, AttributeDeclaration semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.ATTRIBUTE_DECLARATION__ATT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.ATTRIBUTE_DECLARATION__ATT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAttributeDeclarationAccess().getAttAttributeParserRuleCall_1_0(), semanticObject.getAtt());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AttributeName returns AttributeName
	 *     Expression returns AttributeName
	 *     AndExpression returns AttributeName
	 *     AndExpression.AndExpression_1_0 returns AttributeName
	 *     OrExpression returns AttributeName
	 *     OrExpression.OrExpression_1_0 returns AttributeName
	 *     BasicExpression returns AttributeName
	 *     Literals returns AttributeName
	 *
	 * Constraint:
	 *     (category=STRING_O id=STRING_O)
	 */
	protected void sequence_AttributeName(ISerializationContext context, AttributeName semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.ATTRIBUTE_NAME__CATEGORY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.ATTRIBUTE_NAME__CATEGORY));
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.ATTRIBUTE_NAME__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.ATTRIBUTE_NAME__ID));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAttributeNameAccess().getCategorySTRING_OParserRuleCall_0_0(), semanticObject.getCategory());
		feeder.accept(grammarAccess.getAttributeNameAccess().getIdSTRING_OParserRuleCall_2_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AttributeReq returns AttributeReq
	 *
	 * Constraint:
	 *     (name=AttributeName value+=Literals value+=Literals*)
	 */
	protected void sequence_AttributeReq(ISerializationContext context, AttributeReq semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (
	 *         (type='boolean' name=ID x=BooleanLiteral) | 
	 *         (type='int' name=ID x=IntLiteral) | 
	 *         (type='date' name=ID (x=DateLiteral | x=TimeLiteral)) | 
	 *         (type='float' name=ID (x=IntLiteral | x=DoubleLiteral)) | 
	 *         (type='string' name=ID x=StringLiteral)
	 *     )
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns BooleanLiteral
	 *     AndExpression returns BooleanLiteral
	 *     AndExpression.AndExpression_1_0 returns BooleanLiteral
	 *     OrExpression returns BooleanLiteral
	 *     OrExpression.OrExpression_1_0 returns BooleanLiteral
	 *     BasicExpression returns BooleanLiteral
	 *     Literals returns BooleanLiteral
	 *     BooleanLiteral returns BooleanLiteral
	 *
	 * Constraint:
	 *     value=BOOLEAN
	 */
	protected void sequence_BooleanLiteral(ISerializationContext context, BooleanLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.BOOLEAN_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.BOOLEAN_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBooleanLiteralAccess().getValueBOOLEANTerminalRuleCall_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns DateLiteral
	 *     AndExpression returns DateLiteral
	 *     AndExpression.AndExpression_1_0 returns DateLiteral
	 *     OrExpression returns DateLiteral
	 *     OrExpression.OrExpression_1_0 returns DateLiteral
	 *     BasicExpression returns DateLiteral
	 *     Literals returns DateLiteral
	 *     DateLiteral returns DateLiteral
	 *
	 * Constraint:
	 *     value=DATE
	 */
	protected void sequence_DateLiteral(ISerializationContext context, DateLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.DATE_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.DATE_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDateLiteralAccess().getValueDATETerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns DeclaredFunction
	 *     AndExpression returns DeclaredFunction
	 *     AndExpression.AndExpression_1_0 returns DeclaredFunction
	 *     OrExpression returns DeclaredFunction
	 *     OrExpression.OrExpression_1_0 returns DeclaredFunction
	 *     BasicExpression returns DeclaredFunction
	 *     DeclaredFunction returns DeclaredFunction
	 *
	 * Constraint:
	 *     (functionId=[FunctionDeclaration|ID] args+=Expression args+=Expression*)
	 */
	protected void sequence_DeclaredFunction(ISerializationContext context, DeclaredFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns DoubleLiteral
	 *     AndExpression returns DoubleLiteral
	 *     AndExpression.AndExpression_1_0 returns DoubleLiteral
	 *     OrExpression returns DoubleLiteral
	 *     OrExpression.OrExpression_1_0 returns DoubleLiteral
	 *     BasicExpression returns DoubleLiteral
	 *     Literals returns DoubleLiteral
	 *     DoubleLiteral returns DoubleLiteral
	 *
	 * Constraint:
	 *     value=REAL
	 */
	protected void sequence_DoubleLiteral(ISerializationContext context, DoubleLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.DOUBLE_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.DOUBLE_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDoubleLiteralAccess().getValueREALTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Facpl returns Facpl
	 *
	 * Constraint:
	 *     (importEl+=Import | declarations+=FunctionDeclaration | policies+=PolicySet | requests+=Request | main=MainFacpl)+
	 */
	protected void sequence_Facpl(ISerializationContext context, Facpl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FunctionDeclaration returns FunctionDeclaration
	 *
	 * Constraint:
	 *     (type=TypeLiteral name=ID args+=TypeLiteral args+=TypeLiteral*)
	 */
	protected void sequence_FunctionDeclaration(ISerializationContext context, FunctionDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Function
	 *     AndExpression returns Function
	 *     AndExpression.AndExpression_1_0 returns Function
	 *     OrExpression returns Function
	 *     OrExpression.OrExpression_1_0 returns Function
	 *     BasicExpression returns Function
	 *     Function returns Function
	 *
	 * Constraint:
	 *     (functionId=funID (arg1=Expression | att1=[Attribute|ID]) (arg2=Expression | att2=[Attribute|ID]))
	 */
	protected void sequence_Function(ISerializationContext context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     importURI=STRING
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.IMPORT__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.IMPORT__IMPORT_URI));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns IntLiteral
	 *     AndExpression returns IntLiteral
	 *     AndExpression.AndExpression_1_0 returns IntLiteral
	 *     OrExpression returns IntLiteral
	 *     OrExpression.OrExpression_1_0 returns IntLiteral
	 *     BasicExpression returns IntLiteral
	 *     Literals returns IntLiteral
	 *     IntLiteral returns IntLiteral
	 *
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_IntLiteral(ISerializationContext context, IntLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.INT_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.INT_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MainFacpl returns MainFacpl
	 *
	 * Constraint:
	 *     (extIndet=BooleanLiteral genPackage=STRING? refRequest+=[Request|ID] refRequest+=[Request|ID]* paf=PAF)
	 */
	protected void sequence_MainFacpl(ISerializationContext context, MainFacpl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns NotExpression
	 *     AndExpression returns NotExpression
	 *     AndExpression.AndExpression_1_0 returns NotExpression
	 *     OrExpression returns NotExpression
	 *     OrExpression.OrExpression_1_0 returns NotExpression
	 *     BasicExpression returns NotExpression
	 *     NotExpression returns NotExpression
	 *
	 * Constraint:
	 *     arg=BasicExpression
	 */
	protected void sequence_NotExpression(ISerializationContext context, NotExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.NOT_EXPRESSION__ARG) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.NOT_EXPRESSION__ARG));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNotExpressionAccess().getArgBasicExpressionParserRuleCall_1_0(), semanticObject.getArg());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Obligation returns Obligation
	 *
	 * Constraint:
	 *     (
	 *         EvaluetedOn=Effect 
	 *         (typeObl='M' | typeObl='O') 
	 *         ((pepAction=ID (expr+=Expression expr+=Expression*)*) | function=PepFunction | (e1=Function e2=Function expiration=Literals?))
	 *     )
	 */
	protected void sequence_Obligation(ISerializationContext context, Obligation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns OrExpression
	 *     AndExpression returns OrExpression
	 *     AndExpression.AndExpression_1_0 returns OrExpression
	 *     OrExpression returns OrExpression
	 *     OrExpression.OrExpression_1_0 returns OrExpression
	 *     BasicExpression returns OrExpression
	 *
	 * Constraint:
	 *     (left=OrExpression_OrExpression_1_0 right=BasicExpression)
	 */
	protected void sequence_OrExpression(ISerializationContext context, OrExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.OR_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.OR_EXPRESSION__LEFT));
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.OR_EXPRESSION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.OR_EXPRESSION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getOrExpressionAccess().getRightBasicExpressionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PAF returns PAF
	 *
	 * Constraint:
	 *     (status=STATUS? pep=PEPAlg pdp=PDP)
	 */
	protected void sequence_PAF(ISerializationContext context, PAF semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PDP returns PDP
	 *
	 * Constraint:
	 *     (pdpAlg=Alg polSet+=AbstractPolicyIncl+)
	 */
	protected void sequence_PDP(ISerializationContext context, PDP semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PepFunction returns PepFunction
	 *
	 * Constraint:
	 *     (
	 *         (name='add-status' att=[Attribute|ID] value=IntLiteral) | 
	 *         (name='add-status' att=[Attribute|ID] value=DoubleLiteral) | 
	 *         (name='sub-status' att=[Attribute|ID] value=IntLiteral) | 
	 *         (name='sub-status' att=[Attribute|ID] value=DoubleLiteral) | 
	 *         (name='div-status' att=[Attribute|ID] value=IntLiteral) | 
	 *         (name='div-status' att=[Attribute|ID] value=DoubleLiteral) | 
	 *         (name='mul-status' att=[Attribute|ID] value=IntLiteral) | 
	 *         (name='mul-status' att=[Attribute|ID] value=DoubleLiteral) | 
	 *         (name='sum-date' att=[Attribute|ID] (value=DateLiteral | value=TimeLiteral)) | 
	 *         (name='set-date' att=[Attribute|ID] (value=DateLiteral | value=TimeLiteral)) | 
	 *         (name='set-string' att=[Attribute|ID] value=StringLiteral) | 
	 *         (name='sum-string' att=[Attribute|ID] value=StringLiteral) | 
	 *         (name='flag-status' att=[Attribute|ID] value=BooleanLiteral)
	 *     )
	 */
	protected void sequence_PepFunction(ISerializationContext context, PepFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FacplPolicy returns PolicySet
	 *     PolicySet returns PolicySet
	 *
	 * Constraint:
	 *     (name=ID polSetAlg=Alg target=Expression? policies+=AbstractPolicyIncl+ obl+=Obligation*)
	 */
	protected void sequence_PolicySet(ISerializationContext context, PolicySet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Request returns Request
	 *
	 * Constraint:
	 *     (stub=STRING? name=ID attributes+=AttributeReq+)
	 */
	protected void sequence_Request(ISerializationContext context, Request semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FacplPolicy returns Rule
	 *     Rule returns Rule
	 *
	 * Constraint:
	 *     (name=ID effect=Effect target=Expression? obl+=Obligation*)
	 */
	protected void sequence_Rule(ISerializationContext context, Rule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     STATUS returns STATUS
	 *
	 * Constraint:
	 *     elements+=AttributeDeclaration+
	 */
	protected void sequence_STATUS(ISerializationContext context, STATUS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Set
	 *     AndExpression returns Set
	 *     AndExpression.AndExpression_1_0 returns Set
	 *     OrExpression returns Set
	 *     OrExpression.OrExpression_1_0 returns Set
	 *     BasicExpression returns Set
	 *     Literals returns Set
	 *     Set returns Set
	 *
	 * Constraint:
	 *     (args+=Literals args+=Literals*)
	 */
	protected void sequence_Set(ISerializationContext context, it.unifi.xtext.facpl.facpl2.Set semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns StringLiteral
	 *     AndExpression returns StringLiteral
	 *     AndExpression.AndExpression_1_0 returns StringLiteral
	 *     OrExpression returns StringLiteral
	 *     OrExpression.OrExpression_1_0 returns StringLiteral
	 *     BasicExpression returns StringLiteral
	 *     Literals returns StringLiteral
	 *     StringLiteral returns StringLiteral
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_StringLiteral(ISerializationContext context, StringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.STRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.STRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns TimeLiteral
	 *     AndExpression returns TimeLiteral
	 *     AndExpression.AndExpression_1_0 returns TimeLiteral
	 *     OrExpression returns TimeLiteral
	 *     OrExpression.OrExpression_1_0 returns TimeLiteral
	 *     BasicExpression returns TimeLiteral
	 *     Literals returns TimeLiteral
	 *     TimeLiteral returns TimeLiteral
	 *
	 * Constraint:
	 *     value=TIME
	 */
	protected void sequence_TimeLiteral(ISerializationContext context, TimeLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Facpl2Package.Literals.TIME_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Facpl2Package.Literals.TIME_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTimeLiteralAccess().getValueTIMETerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
}
