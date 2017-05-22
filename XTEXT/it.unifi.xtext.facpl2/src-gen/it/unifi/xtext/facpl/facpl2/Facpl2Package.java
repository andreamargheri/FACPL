/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Factory
 * @model kind="package"
 * @generated
 */
public interface Facpl2Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "facpl2";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.unifi.it/xtext/facpl/Facpl2";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "facpl2";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Facpl2Package eINSTANCE = it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl.init();

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.FacplImpl <em>Facpl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.FacplImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFacpl()
   * @generated
   */
  int FACPL = 0;

  /**
   * The feature id for the '<em><b>Import El</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL__IMPORT_EL = 0;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL__DECLARATIONS = 1;

  /**
   * The feature id for the '<em><b>Policies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL__POLICIES = 2;

  /**
   * The feature id for the '<em><b>Requests</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL__REQUESTS = 3;

  /**
   * The feature id for the '<em><b>Main</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL__MAIN = 4;

  /**
   * The number of structural features of the '<em>Facpl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.ImportImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl <em>Main Facpl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getMainFacpl()
   * @generated
   */
  int MAIN_FACPL = 2;

  /**
   * The feature id for the '<em><b>Ext Indet</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_FACPL__EXT_INDET = 0;

  /**
   * The feature id for the '<em><b>Gen Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_FACPL__GEN_PACKAGE = 1;

  /**
   * The feature id for the '<em><b>Ref Request</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_FACPL__REF_REQUEST = 2;

  /**
   * The feature id for the '<em><b>Paf</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_FACPL__PAF = 3;

  /**
   * The number of structural features of the '<em>Main Facpl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_FACPL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.FunctionDeclarationImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFunctionDeclaration()
   * @generated
   */
  int FUNCTION_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Args</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION__ARGS = 2;

  /**
   * The number of structural features of the '<em>Function Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.PAFImpl <em>PAF</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.PAFImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getPAF()
   * @generated
   */
  int PAF = 4;

  /**
   * The feature id for the '<em><b>Pep</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAF__PEP = 0;

  /**
   * The feature id for the '<em><b>Pdp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAF__PDP = 1;

  /**
   * The number of structural features of the '<em>PAF</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.RequestImpl <em>Request</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.RequestImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getRequest()
   * @generated
   */
  int REQUEST = 5;

  /**
   * The feature id for the '<em><b>Stub</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUEST__STUB = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUEST__NAME = 1;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUEST__ATTRIBUTES = 2;

  /**
   * The number of structural features of the '<em>Request</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUEST_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.AttributeReqImpl <em>Attribute Req</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.AttributeReqImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAttributeReq()
   * @generated
   */
  int ATTRIBUTE_REQ = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_REQ__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_REQ__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attribute Req</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_REQ_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.ExpressionImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 15;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.AttributeNameImpl <em>Attribute Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.AttributeNameImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAttributeName()
   * @generated
   */
  int ATTRIBUTE_NAME = 7;

  /**
   * The feature id for the '<em><b>Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_NAME__CATEGORY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_NAME__ID = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attribute Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_NAME_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.PDPImpl <em>PDP</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.PDPImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getPDP()
   * @generated
   */
  int PDP = 8;

  /**
   * The feature id for the '<em><b>Pdp Alg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PDP__PDP_ALG = 0;

  /**
   * The feature id for the '<em><b>Pol Set</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PDP__POL_SET = 1;

  /**
   * The number of structural features of the '<em>PDP</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PDP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.FacplPolicyImpl <em>Facpl Policy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.FacplPolicyImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFacplPolicy()
   * @generated
   */
  int FACPL_POLICY = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL_POLICY__NAME = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL_POLICY__TARGET = 1;

  /**
   * The number of structural features of the '<em>Facpl Policy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACPL_POLICY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.AbstractPolicyInclImpl <em>Abstract Policy Incl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.AbstractPolicyInclImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAbstractPolicyIncl()
   * @generated
   */
  int ABSTRACT_POLICY_INCL = 10;

  /**
   * The feature id for the '<em><b>New Policy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_POLICY_INCL__NEW_POLICY = 0;

  /**
   * The feature id for the '<em><b>Ref Pol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_POLICY_INCL__REF_POL = 1;

  /**
   * The number of structural features of the '<em>Abstract Policy Incl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_POLICY_INCL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.PolicySetImpl <em>Policy Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.PolicySetImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getPolicySet()
   * @generated
   */
  int POLICY_SET = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICY_SET__NAME = FACPL_POLICY__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICY_SET__TARGET = FACPL_POLICY__TARGET;

  /**
   * The feature id for the '<em><b>Pol Set Alg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICY_SET__POL_SET_ALG = FACPL_POLICY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Policies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICY_SET__POLICIES = FACPL_POLICY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Oblp</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICY_SET__OBLP = FACPL_POLICY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Obld</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICY_SET__OBLD = FACPL_POLICY_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Policy Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICY_SET_FEATURE_COUNT = FACPL_POLICY_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.AlgImpl <em>Alg</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.AlgImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAlg()
   * @generated
   */
  int ALG = 12;

  /**
   * The feature id for the '<em><b>Id Alg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALG__ID_ALG = 0;

  /**
   * The feature id for the '<em><b>FStrategy</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALG__FSTRATEGY = 1;

  /**
   * The number of structural features of the '<em>Alg</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALG_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.RuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.RuleImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getRule()
   * @generated
   */
  int RULE = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__NAME = FACPL_POLICY__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__TARGET = FACPL_POLICY__TARGET;

  /**
   * The feature id for the '<em><b>Effect</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__EFFECT = FACPL_POLICY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Obl</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE__OBL = FACPL_POLICY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_FEATURE_COUNT = FACPL_POLICY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl <em>Obligation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.ObligationImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getObligation()
   * @generated
   */
  int OBLIGATION = 14;

  /**
   * The feature id for the '<em><b>Type Obl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBLIGATION__TYPE_OBL = 0;

  /**
   * The feature id for the '<em><b>Pep Action</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBLIGATION__PEP_ACTION = 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBLIGATION__EXPR = 2;

  /**
   * The number of structural features of the '<em>Obligation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBLIGATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.NotExpressionImpl <em>Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.NotExpressionImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getNotExpression()
   * @generated
   */
  int NOT_EXPRESSION = 16;

  /**
   * The feature id for the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION__ARG = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Not Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.FunctionImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 17;

  /**
   * The feature id for the '<em><b>Function Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__FUNCTION_ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arg1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__ARG1 = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Arg2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__ARG2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.DeclaredFunctionImpl <em>Declared Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.DeclaredFunctionImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getDeclaredFunction()
   * @generated
   */
  int DECLARED_FUNCTION = 18;

  /**
   * The feature id for the '<em><b>Function Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARED_FUNCTION__FUNCTION_ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARED_FUNCTION__ARGS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Declared Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARED_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.MapFunctionImpl <em>Map Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.MapFunctionImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getMapFunction()
   * @generated
   */
  int MAP_FUNCTION = 19;

  /**
   * The feature id for the '<em><b>Function ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_FUNCTION__FUNCTION_ID = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Arg1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_FUNCTION__ARG1 = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Arg2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_FUNCTION__ARG2 = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Map Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_FUNCTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.SetImpl <em>Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.SetImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getSet()
   * @generated
   */
  int SET = 20;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET__ARGS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.StringLiteralImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 21;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.BooleanLiteralImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 22;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.IntLiteralImpl <em>Int Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.IntLiteralImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getIntLiteral()
   * @generated
   */
  int INT_LITERAL = 23;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.DoubleLiteralImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getDoubleLiteral()
   * @generated
   */
  int DOUBLE_LITERAL = 24;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.DateLiteralImpl <em>Date Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.DateLiteralImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getDateLiteral()
   * @generated
   */
  int DATE_LITERAL = 25;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Date Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.TimeLiteralImpl <em>Time Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.TimeLiteralImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getTimeLiteral()
   * @generated
   */
  int TIME_LITERAL = 26;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Time Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.AndExpressionImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 27;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.impl.OrExpressionImpl
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 28;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.TypeLiteral <em>Type Literal</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.TypeLiteral
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getTypeLiteral()
   * @generated
   */
  int TYPE_LITERAL = 29;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.PEPAlg <em>PEP Alg</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.PEPAlg
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getPEPAlg()
   * @generated
   */
  int PEP_ALG = 30;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.AlgLiteral <em>Alg Literal</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.AlgLiteral
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAlgLiteral()
   * @generated
   */
  int ALG_LITERAL = 31;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.FulfillmentStrategy <em>Fulfillment Strategy</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.FulfillmentStrategy
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFulfillmentStrategy()
   * @generated
   */
  int FULFILLMENT_STRATEGY = 32;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.Effect <em>Effect</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.Effect
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getEffect()
   * @generated
   */
  int EFFECT = 33;

  /**
   * The meta object id for the '{@link it.unifi.xtext.facpl.facpl2.funID <em>fun ID</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see it.unifi.xtext.facpl.facpl2.funID
   * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getfunID()
   * @generated
   */
  int FUN_ID = 34;


  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Facpl <em>Facpl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Facpl</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Facpl
   * @generated
   */
  EClass getFacpl();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.Facpl#getImportEl <em>Import El</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Import El</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Facpl#getImportEl()
   * @see #getFacpl()
   * @generated
   */
  EReference getFacpl_ImportEl();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.Facpl#getDeclarations <em>Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declarations</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Facpl#getDeclarations()
   * @see #getFacpl()
   * @generated
   */
  EReference getFacpl_Declarations();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.Facpl#getPolicies <em>Policies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Policies</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Facpl#getPolicies()
   * @see #getFacpl()
   * @generated
   */
  EReference getFacpl_Policies();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.Facpl#getRequests <em>Requests</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requests</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Facpl#getRequests()
   * @see #getFacpl()
   * @generated
   */
  EReference getFacpl_Requests();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.Facpl#getMain <em>Main</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Main</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Facpl#getMain()
   * @see #getFacpl()
   * @generated
   */
  EReference getFacpl_Main();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.MainFacpl <em>Main Facpl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Main Facpl</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MainFacpl
   * @generated
   */
  EClass getMainFacpl();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getExtIndet <em>Ext Indet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ext Indet</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MainFacpl#getExtIndet()
   * @see #getMainFacpl()
   * @generated
   */
  EReference getMainFacpl_ExtIndet();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getGenPackage <em>Gen Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Gen Package</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MainFacpl#getGenPackage()
   * @see #getMainFacpl()
   * @generated
   */
  EAttribute getMainFacpl_GenPackage();

  /**
   * Returns the meta object for the reference list '{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getRefRequest <em>Ref Request</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Ref Request</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MainFacpl#getRefRequest()
   * @see #getMainFacpl()
   * @generated
   */
  EReference getMainFacpl_RefRequest();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getPaf <em>Paf</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Paf</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MainFacpl#getPaf()
   * @see #getMainFacpl()
   * @generated
   */
  EReference getMainFacpl_Paf();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration <em>Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Declaration</em>'.
   * @see it.unifi.xtext.facpl.facpl2.FunctionDeclaration
   * @generated
   */
  EClass getFunctionDeclaration();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getType()
   * @see #getFunctionDeclaration()
   * @generated
   */
  EAttribute getFunctionDeclaration_Type();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getName()
   * @see #getFunctionDeclaration()
   * @generated
   */
  EAttribute getFunctionDeclaration_Name();

  /**
   * Returns the meta object for the attribute list '{@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Args</em>'.
   * @see it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getArgs()
   * @see #getFunctionDeclaration()
   * @generated
   */
  EAttribute getFunctionDeclaration_Args();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.PAF <em>PAF</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PAF</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PAF
   * @generated
   */
  EClass getPAF();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.PAF#getPep <em>Pep</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pep</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PAF#getPep()
   * @see #getPAF()
   * @generated
   */
  EAttribute getPAF_Pep();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.PAF#getPdp <em>Pdp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pdp</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PAF#getPdp()
   * @see #getPAF()
   * @generated
   */
  EReference getPAF_Pdp();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Request <em>Request</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Request</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Request
   * @generated
   */
  EClass getRequest();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Request#getStub <em>Stub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Stub</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Request#getStub()
   * @see #getRequest()
   * @generated
   */
  EAttribute getRequest_Stub();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Request#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Request#getName()
   * @see #getRequest()
   * @generated
   */
  EAttribute getRequest_Name();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.Request#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Request#getAttributes()
   * @see #getRequest()
   * @generated
   */
  EReference getRequest_Attributes();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.AttributeReq <em>Attribute Req</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Req</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AttributeReq
   * @generated
   */
  EClass getAttributeReq();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.AttributeReq#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AttributeReq#getName()
   * @see #getAttributeReq()
   * @generated
   */
  EReference getAttributeReq_Name();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.AttributeReq#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AttributeReq#getValue()
   * @see #getAttributeReq()
   * @generated
   */
  EReference getAttributeReq_Value();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.AttributeName <em>Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Name</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AttributeName
   * @generated
   */
  EClass getAttributeName();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.AttributeName#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Category</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AttributeName#getCategory()
   * @see #getAttributeName()
   * @generated
   */
  EAttribute getAttributeName_Category();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.AttributeName#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AttributeName#getId()
   * @see #getAttributeName()
   * @generated
   */
  EAttribute getAttributeName_Id();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.PDP <em>PDP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PDP</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PDP
   * @generated
   */
  EClass getPDP();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.PDP#getPdpAlg <em>Pdp Alg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pdp Alg</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PDP#getPdpAlg()
   * @see #getPDP()
   * @generated
   */
  EReference getPDP_PdpAlg();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.PDP#getPolSet <em>Pol Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pol Set</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PDP#getPolSet()
   * @see #getPDP()
   * @generated
   */
  EReference getPDP_PolSet();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.FacplPolicy <em>Facpl Policy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Facpl Policy</em>'.
   * @see it.unifi.xtext.facpl.facpl2.FacplPolicy
   * @generated
   */
  EClass getFacplPolicy();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.FacplPolicy#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see it.unifi.xtext.facpl.facpl2.FacplPolicy#getName()
   * @see #getFacplPolicy()
   * @generated
   */
  EAttribute getFacplPolicy_Name();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.FacplPolicy#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see it.unifi.xtext.facpl.facpl2.FacplPolicy#getTarget()
   * @see #getFacplPolicy()
   * @generated
   */
  EReference getFacplPolicy_Target();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl <em>Abstract Policy Incl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Policy Incl</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl
   * @generated
   */
  EClass getAbstractPolicyIncl();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl#getNewPolicy <em>New Policy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>New Policy</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl#getNewPolicy()
   * @see #getAbstractPolicyIncl()
   * @generated
   */
  EReference getAbstractPolicyIncl_NewPolicy();

  /**
   * Returns the meta object for the reference '{@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl#getRefPol <em>Ref Pol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref Pol</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl#getRefPol()
   * @see #getAbstractPolicyIncl()
   * @generated
   */
  EReference getAbstractPolicyIncl_RefPol();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.PolicySet <em>Policy Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Policy Set</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PolicySet
   * @generated
   */
  EClass getPolicySet();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.PolicySet#getPolSetAlg <em>Pol Set Alg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pol Set Alg</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PolicySet#getPolSetAlg()
   * @see #getPolicySet()
   * @generated
   */
  EReference getPolicySet_PolSetAlg();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.PolicySet#getPolicies <em>Policies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Policies</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PolicySet#getPolicies()
   * @see #getPolicySet()
   * @generated
   */
  EReference getPolicySet_Policies();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.PolicySet#getOblp <em>Oblp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Oblp</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PolicySet#getOblp()
   * @see #getPolicySet()
   * @generated
   */
  EReference getPolicySet_Oblp();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.PolicySet#getObld <em>Obld</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Obld</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PolicySet#getObld()
   * @see #getPolicySet()
   * @generated
   */
  EReference getPolicySet_Obld();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Alg <em>Alg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alg</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Alg
   * @generated
   */
  EClass getAlg();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Alg#getIdAlg <em>Id Alg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id Alg</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Alg#getIdAlg()
   * @see #getAlg()
   * @generated
   */
  EAttribute getAlg_IdAlg();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Alg#getFStrategy <em>FStrategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>FStrategy</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Alg#getFStrategy()
   * @see #getAlg()
   * @generated
   */
  EAttribute getAlg_FStrategy();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Rule
   * @generated
   */
  EClass getRule();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Rule#getEffect <em>Effect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Effect</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Rule#getEffect()
   * @see #getRule()
   * @generated
   */
  EAttribute getRule_Effect();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.Rule#getObl <em>Obl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Obl</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Rule#getObl()
   * @see #getRule()
   * @generated
   */
  EReference getRule_Obl();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Obligation <em>Obligation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Obligation</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Obligation
   * @generated
   */
  EClass getObligation();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Obligation#getTypeObl <em>Type Obl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Obl</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Obligation#getTypeObl()
   * @see #getObligation()
   * @generated
   */
  EAttribute getObligation_TypeObl();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Obligation#getPepAction <em>Pep Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pep Action</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Obligation#getPepAction()
   * @see #getObligation()
   * @generated
   */
  EAttribute getObligation_PepAction();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.Obligation#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Obligation#getExpr()
   * @see #getObligation()
   * @generated
   */
  EReference getObligation_Expr();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Expression</em>'.
   * @see it.unifi.xtext.facpl.facpl2.NotExpression
   * @generated
   */
  EClass getNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.NotExpression#getArg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg</em>'.
   * @see it.unifi.xtext.facpl.facpl2.NotExpression#getArg()
   * @see #getNotExpression()
   * @generated
   */
  EReference getNotExpression_Arg();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.Function#getFunctionId <em>Function Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Function Id</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Function#getFunctionId()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_FunctionId();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.Function#getArg1 <em>Arg1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg1</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Function#getArg1()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Arg1();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.Function#getArg2 <em>Arg2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg2</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Function#getArg2()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Arg2();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.DeclaredFunction <em>Declared Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declared Function</em>'.
   * @see it.unifi.xtext.facpl.facpl2.DeclaredFunction
   * @generated
   */
  EClass getDeclaredFunction();

  /**
   * Returns the meta object for the reference '{@link it.unifi.xtext.facpl.facpl2.DeclaredFunction#getFunctionId <em>Function Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Function Id</em>'.
   * @see it.unifi.xtext.facpl.facpl2.DeclaredFunction#getFunctionId()
   * @see #getDeclaredFunction()
   * @generated
   */
  EReference getDeclaredFunction_FunctionId();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.DeclaredFunction#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see it.unifi.xtext.facpl.facpl2.DeclaredFunction#getArgs()
   * @see #getDeclaredFunction()
   * @generated
   */
  EReference getDeclaredFunction_Args();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.MapFunction <em>Map Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Map Function</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MapFunction
   * @generated
   */
  EClass getMapFunction();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.MapFunction#getFunctionID <em>Function ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Function ID</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MapFunction#getFunctionID()
   * @see #getMapFunction()
   * @generated
   */
  EAttribute getMapFunction_FunctionID();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.MapFunction#getArg1 <em>Arg1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg1</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MapFunction#getArg1()
   * @see #getMapFunction()
   * @generated
   */
  EReference getMapFunction_Arg1();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.MapFunction#getArg2 <em>Arg2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arg2</em>'.
   * @see it.unifi.xtext.facpl.facpl2.MapFunction#getArg2()
   * @see #getMapFunction()
   * @generated
   */
  EReference getMapFunction_Arg2();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.Set <em>Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Set
   * @generated
   */
  EClass getSet();

  /**
   * Returns the meta object for the containment reference list '{@link it.unifi.xtext.facpl.facpl2.Set#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Set#getArgs()
   * @see #getSet()
   * @generated
   */
  EReference getSet_Args();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see it.unifi.xtext.facpl.facpl2.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.unifi.xtext.facpl.facpl2.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see it.unifi.xtext.facpl.facpl2.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.BooleanLiteral#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.unifi.xtext.facpl.facpl2.BooleanLiteral#isValue()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Literal</em>'.
   * @see it.unifi.xtext.facpl.facpl2.IntLiteral
   * @generated
   */
  EClass getIntLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.IntLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.unifi.xtext.facpl.facpl2.IntLiteral#getValue()
   * @see #getIntLiteral()
   * @generated
   */
  EAttribute getIntLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.DoubleLiteral <em>Double Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Literal</em>'.
   * @see it.unifi.xtext.facpl.facpl2.DoubleLiteral
   * @generated
   */
  EClass getDoubleLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.DoubleLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.unifi.xtext.facpl.facpl2.DoubleLiteral#getValue()
   * @see #getDoubleLiteral()
   * @generated
   */
  EAttribute getDoubleLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.DateLiteral <em>Date Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Date Literal</em>'.
   * @see it.unifi.xtext.facpl.facpl2.DateLiteral
   * @generated
   */
  EClass getDateLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.DateLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.unifi.xtext.facpl.facpl2.DateLiteral#getValue()
   * @see #getDateLiteral()
   * @generated
   */
  EAttribute getDateLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.TimeLiteral <em>Time Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Literal</em>'.
   * @see it.unifi.xtext.facpl.facpl2.TimeLiteral
   * @generated
   */
  EClass getTimeLiteral();

  /**
   * Returns the meta object for the attribute '{@link it.unifi.xtext.facpl.facpl2.TimeLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see it.unifi.xtext.facpl.facpl2.TimeLiteral#getValue()
   * @see #getTimeLiteral()
   * @generated
   */
  EAttribute getTimeLiteral_Value();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.AndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AndExpression#getLeft()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.AndExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AndExpression#getRight()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Right();

  /**
   * Returns the meta object for class '{@link it.unifi.xtext.facpl.facpl2.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see it.unifi.xtext.facpl.facpl2.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.OrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see it.unifi.xtext.facpl.facpl2.OrExpression#getLeft()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link it.unifi.xtext.facpl.facpl2.OrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see it.unifi.xtext.facpl.facpl2.OrExpression#getRight()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Right();

  /**
   * Returns the meta object for enum '{@link it.unifi.xtext.facpl.facpl2.TypeLiteral <em>Type Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Type Literal</em>'.
   * @see it.unifi.xtext.facpl.facpl2.TypeLiteral
   * @generated
   */
  EEnum getTypeLiteral();

  /**
   * Returns the meta object for enum '{@link it.unifi.xtext.facpl.facpl2.PEPAlg <em>PEP Alg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>PEP Alg</em>'.
   * @see it.unifi.xtext.facpl.facpl2.PEPAlg
   * @generated
   */
  EEnum getPEPAlg();

  /**
   * Returns the meta object for enum '{@link it.unifi.xtext.facpl.facpl2.AlgLiteral <em>Alg Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Alg Literal</em>'.
   * @see it.unifi.xtext.facpl.facpl2.AlgLiteral
   * @generated
   */
  EEnum getAlgLiteral();

  /**
   * Returns the meta object for enum '{@link it.unifi.xtext.facpl.facpl2.FulfillmentStrategy <em>Fulfillment Strategy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Fulfillment Strategy</em>'.
   * @see it.unifi.xtext.facpl.facpl2.FulfillmentStrategy
   * @generated
   */
  EEnum getFulfillmentStrategy();

  /**
   * Returns the meta object for enum '{@link it.unifi.xtext.facpl.facpl2.Effect <em>Effect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Effect</em>'.
   * @see it.unifi.xtext.facpl.facpl2.Effect
   * @generated
   */
  EEnum getEffect();

  /**
   * Returns the meta object for enum '{@link it.unifi.xtext.facpl.facpl2.funID <em>fun ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>fun ID</em>'.
   * @see it.unifi.xtext.facpl.facpl2.funID
   * @generated
   */
  EEnum getfunID();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Facpl2Factory getFacpl2Factory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.FacplImpl <em>Facpl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.FacplImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFacpl()
     * @generated
     */
    EClass FACPL = eINSTANCE.getFacpl();

    /**
     * The meta object literal for the '<em><b>Import El</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACPL__IMPORT_EL = eINSTANCE.getFacpl_ImportEl();

    /**
     * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACPL__DECLARATIONS = eINSTANCE.getFacpl_Declarations();

    /**
     * The meta object literal for the '<em><b>Policies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACPL__POLICIES = eINSTANCE.getFacpl_Policies();

    /**
     * The meta object literal for the '<em><b>Requests</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACPL__REQUESTS = eINSTANCE.getFacpl_Requests();

    /**
     * The meta object literal for the '<em><b>Main</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACPL__MAIN = eINSTANCE.getFacpl_Main();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.ImportImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl <em>Main Facpl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getMainFacpl()
     * @generated
     */
    EClass MAIN_FACPL = eINSTANCE.getMainFacpl();

    /**
     * The meta object literal for the '<em><b>Ext Indet</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAIN_FACPL__EXT_INDET = eINSTANCE.getMainFacpl_ExtIndet();

    /**
     * The meta object literal for the '<em><b>Gen Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAIN_FACPL__GEN_PACKAGE = eINSTANCE.getMainFacpl_GenPackage();

    /**
     * The meta object literal for the '<em><b>Ref Request</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAIN_FACPL__REF_REQUEST = eINSTANCE.getMainFacpl_RefRequest();

    /**
     * The meta object literal for the '<em><b>Paf</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAIN_FACPL__PAF = eINSTANCE.getMainFacpl_Paf();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.FunctionDeclarationImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFunctionDeclaration()
     * @generated
     */
    EClass FUNCTION_DECLARATION = eINSTANCE.getFunctionDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DECLARATION__TYPE = eINSTANCE.getFunctionDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DECLARATION__NAME = eINSTANCE.getFunctionDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DECLARATION__ARGS = eINSTANCE.getFunctionDeclaration_Args();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.PAFImpl <em>PAF</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.PAFImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getPAF()
     * @generated
     */
    EClass PAF = eINSTANCE.getPAF();

    /**
     * The meta object literal for the '<em><b>Pep</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PAF__PEP = eINSTANCE.getPAF_Pep();

    /**
     * The meta object literal for the '<em><b>Pdp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PAF__PDP = eINSTANCE.getPAF_Pdp();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.RequestImpl <em>Request</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.RequestImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getRequest()
     * @generated
     */
    EClass REQUEST = eINSTANCE.getRequest();

    /**
     * The meta object literal for the '<em><b>Stub</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUEST__STUB = eINSTANCE.getRequest_Stub();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUEST__NAME = eINSTANCE.getRequest_Name();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUEST__ATTRIBUTES = eINSTANCE.getRequest_Attributes();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.AttributeReqImpl <em>Attribute Req</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.AttributeReqImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAttributeReq()
     * @generated
     */
    EClass ATTRIBUTE_REQ = eINSTANCE.getAttributeReq();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_REQ__NAME = eINSTANCE.getAttributeReq_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_REQ__VALUE = eINSTANCE.getAttributeReq_Value();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.AttributeNameImpl <em>Attribute Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.AttributeNameImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAttributeName()
     * @generated
     */
    EClass ATTRIBUTE_NAME = eINSTANCE.getAttributeName();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_NAME__CATEGORY = eINSTANCE.getAttributeName_Category();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_NAME__ID = eINSTANCE.getAttributeName_Id();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.PDPImpl <em>PDP</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.PDPImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getPDP()
     * @generated
     */
    EClass PDP = eINSTANCE.getPDP();

    /**
     * The meta object literal for the '<em><b>Pdp Alg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PDP__PDP_ALG = eINSTANCE.getPDP_PdpAlg();

    /**
     * The meta object literal for the '<em><b>Pol Set</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PDP__POL_SET = eINSTANCE.getPDP_PolSet();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.FacplPolicyImpl <em>Facpl Policy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.FacplPolicyImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFacplPolicy()
     * @generated
     */
    EClass FACPL_POLICY = eINSTANCE.getFacplPolicy();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACPL_POLICY__NAME = eINSTANCE.getFacplPolicy_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACPL_POLICY__TARGET = eINSTANCE.getFacplPolicy_Target();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.AbstractPolicyInclImpl <em>Abstract Policy Incl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.AbstractPolicyInclImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAbstractPolicyIncl()
     * @generated
     */
    EClass ABSTRACT_POLICY_INCL = eINSTANCE.getAbstractPolicyIncl();

    /**
     * The meta object literal for the '<em><b>New Policy</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_POLICY_INCL__NEW_POLICY = eINSTANCE.getAbstractPolicyIncl_NewPolicy();

    /**
     * The meta object literal for the '<em><b>Ref Pol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_POLICY_INCL__REF_POL = eINSTANCE.getAbstractPolicyIncl_RefPol();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.PolicySetImpl <em>Policy Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.PolicySetImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getPolicySet()
     * @generated
     */
    EClass POLICY_SET = eINSTANCE.getPolicySet();

    /**
     * The meta object literal for the '<em><b>Pol Set Alg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POLICY_SET__POL_SET_ALG = eINSTANCE.getPolicySet_PolSetAlg();

    /**
     * The meta object literal for the '<em><b>Policies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POLICY_SET__POLICIES = eINSTANCE.getPolicySet_Policies();

    /**
     * The meta object literal for the '<em><b>Oblp</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POLICY_SET__OBLP = eINSTANCE.getPolicySet_Oblp();

    /**
     * The meta object literal for the '<em><b>Obld</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POLICY_SET__OBLD = eINSTANCE.getPolicySet_Obld();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.AlgImpl <em>Alg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.AlgImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAlg()
     * @generated
     */
    EClass ALG = eINSTANCE.getAlg();

    /**
     * The meta object literal for the '<em><b>Id Alg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALG__ID_ALG = eINSTANCE.getAlg_IdAlg();

    /**
     * The meta object literal for the '<em><b>FStrategy</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALG__FSTRATEGY = eINSTANCE.getAlg_FStrategy();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.RuleImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getRule()
     * @generated
     */
    EClass RULE = eINSTANCE.getRule();

    /**
     * The meta object literal for the '<em><b>Effect</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE__EFFECT = eINSTANCE.getRule_Effect();

    /**
     * The meta object literal for the '<em><b>Obl</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE__OBL = eINSTANCE.getRule_Obl();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl <em>Obligation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.ObligationImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getObligation()
     * @generated
     */
    EClass OBLIGATION = eINSTANCE.getObligation();

    /**
     * The meta object literal for the '<em><b>Type Obl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBLIGATION__TYPE_OBL = eINSTANCE.getObligation_TypeObl();

    /**
     * The meta object literal for the '<em><b>Pep Action</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBLIGATION__PEP_ACTION = eINSTANCE.getObligation_PepAction();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBLIGATION__EXPR = eINSTANCE.getObligation_Expr();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.ExpressionImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.NotExpressionImpl <em>Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.NotExpressionImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getNotExpression()
     * @generated
     */
    EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

    /**
     * The meta object literal for the '<em><b>Arg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EXPRESSION__ARG = eINSTANCE.getNotExpression_Arg();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.FunctionImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Function Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__FUNCTION_ID = eINSTANCE.getFunction_FunctionId();

    /**
     * The meta object literal for the '<em><b>Arg1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__ARG1 = eINSTANCE.getFunction_Arg1();

    /**
     * The meta object literal for the '<em><b>Arg2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__ARG2 = eINSTANCE.getFunction_Arg2();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.DeclaredFunctionImpl <em>Declared Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.DeclaredFunctionImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getDeclaredFunction()
     * @generated
     */
    EClass DECLARED_FUNCTION = eINSTANCE.getDeclaredFunction();

    /**
     * The meta object literal for the '<em><b>Function Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARED_FUNCTION__FUNCTION_ID = eINSTANCE.getDeclaredFunction_FunctionId();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARED_FUNCTION__ARGS = eINSTANCE.getDeclaredFunction_Args();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.MapFunctionImpl <em>Map Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.MapFunctionImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getMapFunction()
     * @generated
     */
    EClass MAP_FUNCTION = eINSTANCE.getMapFunction();

    /**
     * The meta object literal for the '<em><b>Function ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAP_FUNCTION__FUNCTION_ID = eINSTANCE.getMapFunction_FunctionID();

    /**
     * The meta object literal for the '<em><b>Arg1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAP_FUNCTION__ARG1 = eINSTANCE.getMapFunction_Arg1();

    /**
     * The meta object literal for the '<em><b>Arg2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAP_FUNCTION__ARG2 = eINSTANCE.getMapFunction_Arg2();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.SetImpl <em>Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.SetImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getSet()
     * @generated
     */
    EClass SET = eINSTANCE.getSet();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET__ARGS = eINSTANCE.getSet_Args();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.StringLiteralImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.BooleanLiteralImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.IntLiteralImpl <em>Int Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.IntLiteralImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getIntLiteral()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getIntLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_LITERAL__VALUE = eINSTANCE.getIntLiteral_Value();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.DoubleLiteralImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getDoubleLiteral()
     * @generated
     */
    EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_LITERAL__VALUE = eINSTANCE.getDoubleLiteral_Value();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.DateLiteralImpl <em>Date Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.DateLiteralImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getDateLiteral()
     * @generated
     */
    EClass DATE_LITERAL = eINSTANCE.getDateLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATE_LITERAL__VALUE = eINSTANCE.getDateLiteral_Value();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.TimeLiteralImpl <em>Time Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.TimeLiteralImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getTimeLiteral()
     * @generated
     */
    EClass TIME_LITERAL = eINSTANCE.getTimeLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_LITERAL__VALUE = eINSTANCE.getTimeLiteral_Value();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.AndExpressionImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__LEFT = eINSTANCE.getAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__RIGHT = eINSTANCE.getAndExpression_Right();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.impl.OrExpressionImpl
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__LEFT = eINSTANCE.getOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__RIGHT = eINSTANCE.getOrExpression_Right();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.TypeLiteral <em>Type Literal</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.TypeLiteral
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getTypeLiteral()
     * @generated
     */
    EEnum TYPE_LITERAL = eINSTANCE.getTypeLiteral();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.PEPAlg <em>PEP Alg</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.PEPAlg
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getPEPAlg()
     * @generated
     */
    EEnum PEP_ALG = eINSTANCE.getPEPAlg();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.AlgLiteral <em>Alg Literal</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.AlgLiteral
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getAlgLiteral()
     * @generated
     */
    EEnum ALG_LITERAL = eINSTANCE.getAlgLiteral();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.FulfillmentStrategy <em>Fulfillment Strategy</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.FulfillmentStrategy
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getFulfillmentStrategy()
     * @generated
     */
    EEnum FULFILLMENT_STRATEGY = eINSTANCE.getFulfillmentStrategy();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.Effect <em>Effect</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.Effect
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getEffect()
     * @generated
     */
    EEnum EFFECT = eINSTANCE.getEffect();

    /**
     * The meta object literal for the '{@link it.unifi.xtext.facpl.facpl2.funID <em>fun ID</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see it.unifi.xtext.facpl.facpl2.funID
     * @see it.unifi.xtext.facpl.facpl2.impl.Facpl2PackageImpl#getfunID()
     * @generated
     */
    EEnum FUN_ID = eINSTANCE.getfunID();

  }

} //Facpl2Package
