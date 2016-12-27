/**
 */
package it.unifi.xtext.facpl.facpl2.util;

import it.unifi.xtext.facpl.facpl2.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package
 * @generated
 */
public class Facpl2AdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Facpl2Package modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Facpl2AdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = Facpl2Package.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Facpl2Switch<Adapter> modelSwitch =
    new Facpl2Switch<Adapter>()
    {
      @Override
      public Adapter caseFacpl(Facpl object)
      {
        return createFacplAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseMainFacpl(MainFacpl object)
      {
        return createMainFacplAdapter();
      }
      @Override
      public Adapter caseFunctionDeclaration(FunctionDeclaration object)
      {
        return createFunctionDeclarationAdapter();
      }
      @Override
      public Adapter casePAF(PAF object)
      {
        return createPAFAdapter();
      }
      @Override
      public Adapter caseRequest(Request object)
      {
        return createRequestAdapter();
      }
      @Override
      public Adapter caseAttributeReq(AttributeReq object)
      {
        return createAttributeReqAdapter();
      }
      @Override
      public Adapter caseAttributeName(AttributeName object)
      {
        return createAttributeNameAdapter();
      }
      @Override
      public Adapter casePDP(PDP object)
      {
        return createPDPAdapter();
      }
      @Override
      public Adapter caseFacplPolicy(FacplPolicy object)
      {
        return createFacplPolicyAdapter();
      }
      @Override
      public Adapter caseAbstractPolicyIncl(AbstractPolicyIncl object)
      {
        return createAbstractPolicyInclAdapter();
      }
      @Override
      public Adapter casePolicySet(PolicySet object)
      {
        return createPolicySetAdapter();
      }
      @Override
      public Adapter caseAlg(Alg object)
      {
        return createAlgAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseObligation(Obligation object)
      {
        return createObligationAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseNotExpression(NotExpression object)
      {
        return createNotExpressionAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseDeclaredFunction(DeclaredFunction object)
      {
        return createDeclaredFunctionAdapter();
      }
      @Override
      public Adapter caseSet(Set object)
      {
        return createSetAdapter();
      }
      @Override
      public Adapter caseStringLiteral(StringLiteral object)
      {
        return createStringLiteralAdapter();
      }
      @Override
      public Adapter caseBooleanLiteral(BooleanLiteral object)
      {
        return createBooleanLiteralAdapter();
      }
      @Override
      public Adapter caseIntLiteral(IntLiteral object)
      {
        return createIntLiteralAdapter();
      }
      @Override
      public Adapter caseDoubleLiteral(DoubleLiteral object)
      {
        return createDoubleLiteralAdapter();
      }
      @Override
      public Adapter caseDateLiteral(DateLiteral object)
      {
        return createDateLiteralAdapter();
      }
      @Override
      public Adapter caseTimeLiteral(TimeLiteral object)
      {
        return createTimeLiteralAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseOrExpression(OrExpression object)
      {
        return createOrExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Facpl <em>Facpl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Facpl
   * @generated
   */
  public Adapter createFacplAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.MainFacpl <em>Main Facpl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.MainFacpl
   * @generated
   */
  public Adapter createMainFacplAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration <em>Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.FunctionDeclaration
   * @generated
   */
  public Adapter createFunctionDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.PAF <em>PAF</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.PAF
   * @generated
   */
  public Adapter createPAFAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Request <em>Request</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Request
   * @generated
   */
  public Adapter createRequestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.AttributeReq <em>Attribute Req</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.AttributeReq
   * @generated
   */
  public Adapter createAttributeReqAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.AttributeName <em>Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.AttributeName
   * @generated
   */
  public Adapter createAttributeNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.PDP <em>PDP</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.PDP
   * @generated
   */
  public Adapter createPDPAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.FacplPolicy <em>Facpl Policy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.FacplPolicy
   * @generated
   */
  public Adapter createFacplPolicyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl <em>Abstract Policy Incl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl
   * @generated
   */
  public Adapter createAbstractPolicyInclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.PolicySet <em>Policy Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.PolicySet
   * @generated
   */
  public Adapter createPolicySetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Alg <em>Alg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Alg
   * @generated
   */
  public Adapter createAlgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Obligation <em>Obligation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Obligation
   * @generated
   */
  public Adapter createObligationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.NotExpression
   * @generated
   */
  public Adapter createNotExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.DeclaredFunction <em>Declared Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.DeclaredFunction
   * @generated
   */
  public Adapter createDeclaredFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.Set <em>Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.Set
   * @generated
   */
  public Adapter createSetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.StringLiteral
   * @generated
   */
  public Adapter createStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.BooleanLiteral
   * @generated
   */
  public Adapter createBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.IntLiteral
   * @generated
   */
  public Adapter createIntLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.DoubleLiteral <em>Double Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.DoubleLiteral
   * @generated
   */
  public Adapter createDoubleLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.DateLiteral <em>Date Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.DateLiteral
   * @generated
   */
  public Adapter createDateLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.TimeLiteral <em>Time Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.TimeLiteral
   * @generated
   */
  public Adapter createTimeLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link it.unifi.xtext.facpl.facpl2.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see it.unifi.xtext.facpl.facpl2.OrExpression
   * @generated
   */
  public Adapter createOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //Facpl2AdapterFactory
