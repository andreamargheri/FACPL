/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Facpl2FactoryImpl extends EFactoryImpl implements Facpl2Factory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Facpl2Factory init()
  {
    try
    {
      Facpl2Factory theFacpl2Factory = (Facpl2Factory)EPackage.Registry.INSTANCE.getEFactory(Facpl2Package.eNS_URI);
      if (theFacpl2Factory != null)
      {
        return theFacpl2Factory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Facpl2FactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Facpl2FactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case Facpl2Package.FACPL: return createFacpl();
      case Facpl2Package.IMPORT: return createImport();
      case Facpl2Package.MAIN_FACPL: return createMainFacpl();
      case Facpl2Package.FUNCTION_DECLARATION: return createFunctionDeclaration();
      case Facpl2Package.PAF: return createPAF();
      case Facpl2Package.STATUS: return createSTATUS();
      case Facpl2Package.ATTRIBUTE: return createAttribute();
      case Facpl2Package.ATTRIBUTE_DECLARATION: return createAttributeDeclaration();
      case Facpl2Package.PEP_FUNCTION: return createPepFunction();
      case Facpl2Package.OBLIGATION: return createObligation();
      case Facpl2Package.REQUEST: return createRequest();
      case Facpl2Package.ATTRIBUTE_REQ: return createAttributeReq();
      case Facpl2Package.ATTRIBUTE_NAME: return createAttributeName();
      case Facpl2Package.PDP: return createPDP();
      case Facpl2Package.FACPL_POLICY: return createFacplPolicy();
      case Facpl2Package.ABSTRACT_POLICY_INCL: return createAbstractPolicyIncl();
      case Facpl2Package.POLICY_SET: return createPolicySet();
      case Facpl2Package.ALG: return createAlg();
      case Facpl2Package.RULE: return createRule();
      case Facpl2Package.EXPRESSION: return createExpression();
      case Facpl2Package.NOT_EXPRESSION: return createNotExpression();
      case Facpl2Package.FUNCTION: return createFunction();
      case Facpl2Package.DECLARED_FUNCTION: return createDeclaredFunction();
      case Facpl2Package.SET: return createSet();
      case Facpl2Package.STRING_LITERAL: return createStringLiteral();
      case Facpl2Package.BOOLEAN_LITERAL: return createBooleanLiteral();
      case Facpl2Package.INT_LITERAL: return createIntLiteral();
      case Facpl2Package.DOUBLE_LITERAL: return createDoubleLiteral();
      case Facpl2Package.DATE_LITERAL: return createDateLiteral();
      case Facpl2Package.TIME_LITERAL: return createTimeLiteral();
      case Facpl2Package.AND_EXPRESSION: return createAndExpression();
      case Facpl2Package.OR_EXPRESSION: return createOrExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Facpl2Package.TYPE_LITERAL:
        return createTypeLiteralFromString(eDataType, initialValue);
      case Facpl2Package.PEP_ALG:
        return createPEPAlgFromString(eDataType, initialValue);
      case Facpl2Package.ALG_LITERAL:
        return createAlgLiteralFromString(eDataType, initialValue);
      case Facpl2Package.FULFILLMENT_STRATEGY:
        return createFulfillmentStrategyFromString(eDataType, initialValue);
      case Facpl2Package.EFFECT:
        return createEffectFromString(eDataType, initialValue);
      case Facpl2Package.FUN_ID:
        return createfunIDFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Facpl2Package.TYPE_LITERAL:
        return convertTypeLiteralToString(eDataType, instanceValue);
      case Facpl2Package.PEP_ALG:
        return convertPEPAlgToString(eDataType, instanceValue);
      case Facpl2Package.ALG_LITERAL:
        return convertAlgLiteralToString(eDataType, instanceValue);
      case Facpl2Package.FULFILLMENT_STRATEGY:
        return convertFulfillmentStrategyToString(eDataType, instanceValue);
      case Facpl2Package.EFFECT:
        return convertEffectToString(eDataType, instanceValue);
      case Facpl2Package.FUN_ID:
        return convertfunIDToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Facpl createFacpl()
  {
    FacplImpl facpl = new FacplImpl();
    return facpl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MainFacpl createMainFacpl()
  {
    MainFacplImpl mainFacpl = new MainFacplImpl();
    return mainFacpl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDeclaration createFunctionDeclaration()
  {
    FunctionDeclarationImpl functionDeclaration = new FunctionDeclarationImpl();
    return functionDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PAF createPAF()
  {
    PAFImpl paf = new PAFImpl();
    return paf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public STATUS createSTATUS()
  {
    STATUSImpl status = new STATUSImpl();
    return status;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeDeclaration createAttributeDeclaration()
  {
    AttributeDeclarationImpl attributeDeclaration = new AttributeDeclarationImpl();
    return attributeDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PepFunction createPepFunction()
  {
    PepFunctionImpl pepFunction = new PepFunctionImpl();
    return pepFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Obligation createObligation()
  {
    ObligationImpl obligation = new ObligationImpl();
    return obligation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Request createRequest()
  {
    RequestImpl request = new RequestImpl();
    return request;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeReq createAttributeReq()
  {
    AttributeReqImpl attributeReq = new AttributeReqImpl();
    return attributeReq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeName createAttributeName()
  {
    AttributeNameImpl attributeName = new AttributeNameImpl();
    return attributeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PDP createPDP()
  {
    PDPImpl pdp = new PDPImpl();
    return pdp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FacplPolicy createFacplPolicy()
  {
    FacplPolicyImpl facplPolicy = new FacplPolicyImpl();
    return facplPolicy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractPolicyIncl createAbstractPolicyIncl()
  {
    AbstractPolicyInclImpl abstractPolicyIncl = new AbstractPolicyInclImpl();
    return abstractPolicyIncl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PolicySet createPolicySet()
  {
    PolicySetImpl policySet = new PolicySetImpl();
    return policySet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Alg createAlg()
  {
    AlgImpl alg = new AlgImpl();
    return alg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule createRule()
  {
    RuleImpl rule = new RuleImpl();
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotExpression createNotExpression()
  {
    NotExpressionImpl notExpression = new NotExpressionImpl();
    return notExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclaredFunction createDeclaredFunction()
  {
    DeclaredFunctionImpl declaredFunction = new DeclaredFunctionImpl();
    return declaredFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Set createSet()
  {
    SetImpl set = new SetImpl();
    return set;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteral createStringLiteral()
  {
    StringLiteralImpl stringLiteral = new StringLiteralImpl();
    return stringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteral createBooleanLiteral()
  {
    BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
    return booleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntLiteral createIntLiteral()
  {
    IntLiteralImpl intLiteral = new IntLiteralImpl();
    return intLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoubleLiteral createDoubleLiteral()
  {
    DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
    return doubleLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DateLiteral createDateLiteral()
  {
    DateLiteralImpl dateLiteral = new DateLiteralImpl();
    return dateLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeLiteral createTimeLiteral()
  {
    TimeLiteralImpl timeLiteral = new TimeLiteralImpl();
    return timeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpression createOrExpression()
  {
    OrExpressionImpl orExpression = new OrExpressionImpl();
    return orExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeLiteral createTypeLiteralFromString(EDataType eDataType, String initialValue)
  {
    TypeLiteral result = TypeLiteral.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTypeLiteralToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PEPAlg createPEPAlgFromString(EDataType eDataType, String initialValue)
  {
    PEPAlg result = PEPAlg.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPEPAlgToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlgLiteral createAlgLiteralFromString(EDataType eDataType, String initialValue)
  {
    AlgLiteral result = AlgLiteral.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAlgLiteralToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FulfillmentStrategy createFulfillmentStrategyFromString(EDataType eDataType, String initialValue)
  {
    FulfillmentStrategy result = FulfillmentStrategy.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFulfillmentStrategyToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Effect createEffectFromString(EDataType eDataType, String initialValue)
  {
    Effect result = Effect.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEffectToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public funID createfunIDFromString(EDataType eDataType, String initialValue)
  {
    funID result = funID.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertfunIDToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Facpl2Package getFacpl2Package()
  {
    return (Facpl2Package)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Facpl2Package getPackage()
  {
    return Facpl2Package.eINSTANCE;
  }

} //Facpl2FactoryImpl
