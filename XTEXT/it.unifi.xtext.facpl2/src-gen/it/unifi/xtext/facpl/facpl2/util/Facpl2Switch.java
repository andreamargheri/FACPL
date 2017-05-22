/**
 */
package it.unifi.xtext.facpl.facpl2.util;

import it.unifi.xtext.facpl.facpl2.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package
 * @generated
 */
public class Facpl2Switch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Facpl2Package modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Facpl2Switch()
  {
    if (modelPackage == null)
    {
      modelPackage = Facpl2Package.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case Facpl2Package.FACPL:
      {
        Facpl facpl = (Facpl)theEObject;
        T result = caseFacpl(facpl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.MAIN_FACPL:
      {
        MainFacpl mainFacpl = (MainFacpl)theEObject;
        T result = caseMainFacpl(mainFacpl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.FUNCTION_DECLARATION:
      {
        FunctionDeclaration functionDeclaration = (FunctionDeclaration)theEObject;
        T result = caseFunctionDeclaration(functionDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.PAF:
      {
        PAF paf = (PAF)theEObject;
        T result = casePAF(paf);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.REQUEST:
      {
        Request request = (Request)theEObject;
        T result = caseRequest(request);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.ATTRIBUTE_REQ:
      {
        AttributeReq attributeReq = (AttributeReq)theEObject;
        T result = caseAttributeReq(attributeReq);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.ATTRIBUTE_NAME:
      {
        AttributeName attributeName = (AttributeName)theEObject;
        T result = caseAttributeName(attributeName);
        if (result == null) result = caseExpression(attributeName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.PDP:
      {
        PDP pdp = (PDP)theEObject;
        T result = casePDP(pdp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.FACPL_POLICY:
      {
        FacplPolicy facplPolicy = (FacplPolicy)theEObject;
        T result = caseFacplPolicy(facplPolicy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.ABSTRACT_POLICY_INCL:
      {
        AbstractPolicyIncl abstractPolicyIncl = (AbstractPolicyIncl)theEObject;
        T result = caseAbstractPolicyIncl(abstractPolicyIncl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.POLICY_SET:
      {
        PolicySet policySet = (PolicySet)theEObject;
        T result = casePolicySet(policySet);
        if (result == null) result = caseFacplPolicy(policySet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.ALG:
      {
        Alg alg = (Alg)theEObject;
        T result = caseAlg(alg);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.RULE:
      {
        Rule rule = (Rule)theEObject;
        T result = caseRule(rule);
        if (result == null) result = caseFacplPolicy(rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.OBLIGATION:
      {
        Obligation obligation = (Obligation)theEObject;
        T result = caseObligation(obligation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.NOT_EXPRESSION:
      {
        NotExpression notExpression = (NotExpression)theEObject;
        T result = caseNotExpression(notExpression);
        if (result == null) result = caseExpression(notExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = caseExpression(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.DECLARED_FUNCTION:
      {
        DeclaredFunction declaredFunction = (DeclaredFunction)theEObject;
        T result = caseDeclaredFunction(declaredFunction);
        if (result == null) result = caseExpression(declaredFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.MAP_FUNCTION:
      {
        MapFunction mapFunction = (MapFunction)theEObject;
        T result = caseMapFunction(mapFunction);
        if (result == null) result = caseExpression(mapFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.SET:
      {
        Set set = (Set)theEObject;
        T result = caseSet(set);
        if (result == null) result = caseExpression(set);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.STRING_LITERAL:
      {
        StringLiteral stringLiteral = (StringLiteral)theEObject;
        T result = caseStringLiteral(stringLiteral);
        if (result == null) result = caseExpression(stringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.BOOLEAN_LITERAL:
      {
        BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
        T result = caseBooleanLiteral(booleanLiteral);
        if (result == null) result = caseExpression(booleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.INT_LITERAL:
      {
        IntLiteral intLiteral = (IntLiteral)theEObject;
        T result = caseIntLiteral(intLiteral);
        if (result == null) result = caseExpression(intLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.DOUBLE_LITERAL:
      {
        DoubleLiteral doubleLiteral = (DoubleLiteral)theEObject;
        T result = caseDoubleLiteral(doubleLiteral);
        if (result == null) result = caseExpression(doubleLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.DATE_LITERAL:
      {
        DateLiteral dateLiteral = (DateLiteral)theEObject;
        T result = caseDateLiteral(dateLiteral);
        if (result == null) result = caseExpression(dateLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.TIME_LITERAL:
      {
        TimeLiteral timeLiteral = (TimeLiteral)theEObject;
        T result = caseTimeLiteral(timeLiteral);
        if (result == null) result = caseExpression(timeLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = caseExpression(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Facpl2Package.OR_EXPRESSION:
      {
        OrExpression orExpression = (OrExpression)theEObject;
        T result = caseOrExpression(orExpression);
        if (result == null) result = caseExpression(orExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Facpl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Facpl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFacpl(Facpl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Main Facpl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Main Facpl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMainFacpl(MainFacpl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionDeclaration(FunctionDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PAF</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PAF</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePAF(PAF object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Request</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Request</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequest(Request object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Req</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Req</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeReq(AttributeReq object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeName(AttributeName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PDP</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PDP</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePDP(PDP object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Facpl Policy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Facpl Policy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFacplPolicy(FacplPolicy object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Policy Incl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Policy Incl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractPolicyIncl(AbstractPolicyIncl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Policy Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Policy Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePolicySet(PolicySet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alg</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alg</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlg(Alg object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule(Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Obligation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Obligation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObligation(Obligation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNotExpression(NotExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declared Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declared Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclaredFunction(DeclaredFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Map Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Map Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapFunction(MapFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSet(Set object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteral(StringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteral(BooleanLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntLiteral(IntLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Double Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoubleLiteral(DoubleLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Date Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Date Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDateLiteral(DateLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Time Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Time Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimeLiteral(TimeLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrExpression(OrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //Facpl2Switch
