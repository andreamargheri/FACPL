/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package
 * @generated
 */
public interface Facpl2Factory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Facpl2Factory eINSTANCE = it.unifi.xtext.facpl.facpl2.impl.Facpl2FactoryImpl.init();

  /**
   * Returns a new object of class '<em>Facpl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Facpl</em>'.
   * @generated
   */
  Facpl createFacpl();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Main Facpl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Main Facpl</em>'.
   * @generated
   */
  MainFacpl createMainFacpl();

  /**
   * Returns a new object of class '<em>Function Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Declaration</em>'.
   * @generated
   */
  FunctionDeclaration createFunctionDeclaration();

  /**
   * Returns a new object of class '<em>PAF</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAF</em>'.
   * @generated
   */
  PAF createPAF();

  /**
   * Returns a new object of class '<em>Request</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Request</em>'.
   * @generated
   */
  Request createRequest();

  /**
   * Returns a new object of class '<em>Attribute Req</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Req</em>'.
   * @generated
   */
  AttributeReq createAttributeReq();

  /**
   * Returns a new object of class '<em>Attribute Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Name</em>'.
   * @generated
   */
  AttributeName createAttributeName();

  /**
   * Returns a new object of class '<em>PDP</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PDP</em>'.
   * @generated
   */
  PDP createPDP();

  /**
   * Returns a new object of class '<em>Facpl Policy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Facpl Policy</em>'.
   * @generated
   */
  FacplPolicy createFacplPolicy();

  /**
   * Returns a new object of class '<em>Abstract Policy Incl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Policy Incl</em>'.
   * @generated
   */
  AbstractPolicyIncl createAbstractPolicyIncl();

  /**
   * Returns a new object of class '<em>Policy Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Policy Set</em>'.
   * @generated
   */
  PolicySet createPolicySet();

  /**
   * Returns a new object of class '<em>Alg</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alg</em>'.
   * @generated
   */
  Alg createAlg();

  /**
   * Returns a new object of class '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule</em>'.
   * @generated
   */
  Rule createRule();

  /**
   * Returns a new object of class '<em>Obligation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Obligation</em>'.
   * @generated
   */
  Obligation createObligation();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Not Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not Expression</em>'.
   * @generated
   */
  NotExpression createNotExpression();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  Function createFunction();

  /**
   * Returns a new object of class '<em>Declared Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declared Function</em>'.
   * @generated
   */
  DeclaredFunction createDeclaredFunction();

  /**
   * Returns a new object of class '<em>Map Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map Function</em>'.
   * @generated
   */
  MapFunction createMapFunction();

  /**
   * Returns a new object of class '<em>Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Set</em>'.
   * @generated
   */
  Set createSet();

  /**
   * Returns a new object of class '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Literal</em>'.
   * @generated
   */
  StringLiteral createStringLiteral();

  /**
   * Returns a new object of class '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Literal</em>'.
   * @generated
   */
  BooleanLiteral createBooleanLiteral();

  /**
   * Returns a new object of class '<em>Int Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Literal</em>'.
   * @generated
   */
  IntLiteral createIntLiteral();

  /**
   * Returns a new object of class '<em>Double Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Double Literal</em>'.
   * @generated
   */
  DoubleLiteral createDoubleLiteral();

  /**
   * Returns a new object of class '<em>Date Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Date Literal</em>'.
   * @generated
   */
  DateLiteral createDateLiteral();

  /**
   * Returns a new object of class '<em>Time Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Literal</em>'.
   * @generated
   */
  TimeLiteral createTimeLiteral();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expression</em>'.
   * @generated
   */
  OrExpression createOrExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Facpl2Package getFacpl2Package();

} //Facpl2Factory
