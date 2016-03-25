/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Alg;
import it.unifi.xtext.facpl.facpl2.AlgLiteral;
import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.Attribute;
import it.unifi.xtext.facpl.facpl2.AttributeDeclaration;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DeclaredFunction;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Effect;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.Facpl2Factory;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.FulfillmentStrategy;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration;
import it.unifi.xtext.facpl.facpl2.Import;
import it.unifi.xtext.facpl.facpl2.IntLiteral;
import it.unifi.xtext.facpl.facpl2.MainFacpl;
import it.unifi.xtext.facpl.facpl2.NotExpression;
import it.unifi.xtext.facpl.facpl2.Obligation;
import it.unifi.xtext.facpl.facpl2.OrExpression;
import it.unifi.xtext.facpl.facpl2.PEPAlg;
import it.unifi.xtext.facpl.facpl2.PepFunction;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.facpl2.Rule;
import it.unifi.xtext.facpl.facpl2.Set;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TimeLiteral;
import it.unifi.xtext.facpl.facpl2.TypeLiteral;
import it.unifi.xtext.facpl.facpl2.funID;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Facpl2PackageImpl extends EPackageImpl implements Facpl2Package
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass facplEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mainFacplEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pafEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pepFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass obligationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeReqEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pdpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass facplPolicyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractPolicyInclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass policySetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass algEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass notExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declaredFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass setEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doubleLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dateLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum typeLiteralEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum pepAlgEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum algLiteralEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum fulfillmentStrategyEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum effectEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum funIDEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#eNS_URI
   * @see #init()
   * @generated
   */
  private Facpl2PackageImpl()
  {
    super(eNS_URI, Facpl2Factory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link Facpl2Package#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Facpl2Package init()
  {
    if (isInited) return (Facpl2Package)EPackage.Registry.INSTANCE.getEPackage(Facpl2Package.eNS_URI);

    // Obtain or create and register package
    Facpl2PackageImpl theFacpl2Package = (Facpl2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Facpl2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Facpl2PackageImpl());

    isInited = true;

    // Create package meta-data objects
    theFacpl2Package.createPackageContents();

    // Initialize created meta-data
    theFacpl2Package.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theFacpl2Package.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Facpl2Package.eNS_URI, theFacpl2Package);
    return theFacpl2Package;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFacpl()
  {
    return facplEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFacpl_ImportEl()
  {
    return (EReference)facplEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFacpl_Declarations()
  {
    return (EReference)facplEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFacpl_Policies()
  {
    return (EReference)facplEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFacpl_Requests()
  {
    return (EReference)facplEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFacpl_Main()
  {
    return (EReference)facplEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportURI()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMainFacpl()
  {
    return mainFacplEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMainFacpl_ExtIndet()
  {
    return (EReference)mainFacplEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMainFacpl_GenPackage()
  {
    return (EAttribute)mainFacplEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMainFacpl_RefRequest()
  {
    return (EReference)mainFacplEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMainFacpl_Paf()
  {
    return (EReference)mainFacplEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDeclaration()
  {
    return functionDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDeclaration_Type()
  {
    return (EAttribute)functionDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDeclaration_Name()
  {
    return (EAttribute)functionDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDeclaration_Args()
  {
    return (EAttribute)functionDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPAF()
  {
    return pafEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPAF_Status()
  {
    return (EReference)pafEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPAF_Pep()
  {
    return (EAttribute)pafEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPAF_Pdp()
  {
    return (EReference)pafEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSTATUS()
  {
    return statusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSTATUS_Elements()
  {
    return (EReference)statusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Type()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Name()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_X()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeDeclaration()
  {
    return attributeDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeDeclaration_Att()
  {
    return (EReference)attributeDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPepFunction()
  {
    return pepFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPepFunction_Name()
  {
    return (EAttribute)pepFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPepFunction_Att()
  {
    return (EReference)pepFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPepFunction_Value()
  {
    return (EReference)pepFunctionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObligation()
  {
    return obligationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObligation_EvaluetedOn()
  {
    return (EAttribute)obligationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObligation_TypeObl()
  {
    return (EAttribute)obligationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObligation_PepAction()
  {
    return (EAttribute)obligationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObligation_Expr()
  {
    return (EReference)obligationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObligation_Function()
  {
    return (EReference)obligationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObligation_E1()
  {
    return (EReference)obligationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObligation_E2()
  {
    return (EReference)obligationEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObligation_Expiration()
  {
    return (EReference)obligationEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequest()
  {
    return requestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRequest_Stub()
  {
    return (EAttribute)requestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRequest_Name()
  {
    return (EAttribute)requestEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequest_Attributes()
  {
    return (EReference)requestEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeReq()
  {
    return attributeReqEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeReq_Name()
  {
    return (EReference)attributeReqEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttributeReq_Value()
  {
    return (EReference)attributeReqEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeName()
  {
    return attributeNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttributeName_Category()
  {
    return (EAttribute)attributeNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttributeName_Id()
  {
    return (EAttribute)attributeNameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPDP()
  {
    return pdpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPDP_PdpAlg()
  {
    return (EReference)pdpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPDP_PolSet()
  {
    return (EReference)pdpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFacplPolicy()
  {
    return facplPolicyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFacplPolicy_Name()
  {
    return (EAttribute)facplPolicyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFacplPolicy_Target()
  {
    return (EReference)facplPolicyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFacplPolicy_Obl()
  {
    return (EReference)facplPolicyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractPolicyIncl()
  {
    return abstractPolicyInclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractPolicyIncl_NewPolicy()
  {
    return (EReference)abstractPolicyInclEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractPolicyIncl_RefPol()
  {
    return (EReference)abstractPolicyInclEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPolicySet()
  {
    return policySetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPolicySet_PolSetAlg()
  {
    return (EReference)policySetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPolicySet_Policies()
  {
    return (EReference)policySetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlg()
  {
    return algEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlg_IdAlg()
  {
    return (EAttribute)algEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlg_FStrategy()
  {
    return (EAttribute)algEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRule()
  {
    return ruleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRule_Effect()
  {
    return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNotExpression()
  {
    return notExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNotExpression_Arg()
  {
    return (EReference)notExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunction()
  {
    return functionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunction_FunctionId()
  {
    return (EAttribute)functionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Arg1()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Att1()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Arg2()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Att2()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclaredFunction()
  {
    return declaredFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclaredFunction_FunctionId()
  {
    return (EReference)declaredFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclaredFunction_Args()
  {
    return (EReference)declaredFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSet()
  {
    return setEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSet_Args()
  {
    return (EReference)setEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLiteral()
  {
    return stringLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringLiteral_Value()
  {
    return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanLiteral()
  {
    return booleanLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanLiteral_Value()
  {
    return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntLiteral()
  {
    return intLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntLiteral_Value()
  {
    return (EAttribute)intLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoubleLiteral()
  {
    return doubleLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDoubleLiteral_Value()
  {
    return (EAttribute)doubleLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDateLiteral()
  {
    return dateLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDateLiteral_Value()
  {
    return (EAttribute)dateLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeLiteral()
  {
    return timeLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeLiteral_Value()
  {
    return (EAttribute)timeLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Left()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Right()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpression()
  {
    return orExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Left()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Right()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTypeLiteral()
  {
    return typeLiteralEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getPEPAlg()
  {
    return pepAlgEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAlgLiteral()
  {
    return algLiteralEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getFulfillmentStrategy()
  {
    return fulfillmentStrategyEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEffect()
  {
    return effectEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getfunID()
  {
    return funIDEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Facpl2Factory getFacpl2Factory()
  {
    return (Facpl2Factory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    facplEClass = createEClass(FACPL);
    createEReference(facplEClass, FACPL__IMPORT_EL);
    createEReference(facplEClass, FACPL__DECLARATIONS);
    createEReference(facplEClass, FACPL__POLICIES);
    createEReference(facplEClass, FACPL__REQUESTS);
    createEReference(facplEClass, FACPL__MAIN);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORT_URI);

    mainFacplEClass = createEClass(MAIN_FACPL);
    createEReference(mainFacplEClass, MAIN_FACPL__EXT_INDET);
    createEAttribute(mainFacplEClass, MAIN_FACPL__GEN_PACKAGE);
    createEReference(mainFacplEClass, MAIN_FACPL__REF_REQUEST);
    createEReference(mainFacplEClass, MAIN_FACPL__PAF);

    functionDeclarationEClass = createEClass(FUNCTION_DECLARATION);
    createEAttribute(functionDeclarationEClass, FUNCTION_DECLARATION__TYPE);
    createEAttribute(functionDeclarationEClass, FUNCTION_DECLARATION__NAME);
    createEAttribute(functionDeclarationEClass, FUNCTION_DECLARATION__ARGS);

    pafEClass = createEClass(PAF);
    createEReference(pafEClass, PAF__STATUS);
    createEAttribute(pafEClass, PAF__PEP);
    createEReference(pafEClass, PAF__PDP);

    statusEClass = createEClass(STATUS);
    createEReference(statusEClass, STATUS__ELEMENTS);

    attributeEClass = createEClass(ATTRIBUTE);
    createEAttribute(attributeEClass, ATTRIBUTE__TYPE);
    createEAttribute(attributeEClass, ATTRIBUTE__NAME);
    createEReference(attributeEClass, ATTRIBUTE__X);

    attributeDeclarationEClass = createEClass(ATTRIBUTE_DECLARATION);
    createEReference(attributeDeclarationEClass, ATTRIBUTE_DECLARATION__ATT);

    pepFunctionEClass = createEClass(PEP_FUNCTION);
    createEAttribute(pepFunctionEClass, PEP_FUNCTION__NAME);
    createEReference(pepFunctionEClass, PEP_FUNCTION__ATT);
    createEReference(pepFunctionEClass, PEP_FUNCTION__VALUE);

    obligationEClass = createEClass(OBLIGATION);
    createEAttribute(obligationEClass, OBLIGATION__EVALUETED_ON);
    createEAttribute(obligationEClass, OBLIGATION__TYPE_OBL);
    createEAttribute(obligationEClass, OBLIGATION__PEP_ACTION);
    createEReference(obligationEClass, OBLIGATION__EXPR);
    createEReference(obligationEClass, OBLIGATION__FUNCTION);
    createEReference(obligationEClass, OBLIGATION__E1);
    createEReference(obligationEClass, OBLIGATION__E2);
    createEReference(obligationEClass, OBLIGATION__EXPIRATION);

    requestEClass = createEClass(REQUEST);
    createEAttribute(requestEClass, REQUEST__STUB);
    createEAttribute(requestEClass, REQUEST__NAME);
    createEReference(requestEClass, REQUEST__ATTRIBUTES);

    attributeReqEClass = createEClass(ATTRIBUTE_REQ);
    createEReference(attributeReqEClass, ATTRIBUTE_REQ__NAME);
    createEReference(attributeReqEClass, ATTRIBUTE_REQ__VALUE);

    attributeNameEClass = createEClass(ATTRIBUTE_NAME);
    createEAttribute(attributeNameEClass, ATTRIBUTE_NAME__CATEGORY);
    createEAttribute(attributeNameEClass, ATTRIBUTE_NAME__ID);

    pdpEClass = createEClass(PDP);
    createEReference(pdpEClass, PDP__PDP_ALG);
    createEReference(pdpEClass, PDP__POL_SET);

    facplPolicyEClass = createEClass(FACPL_POLICY);
    createEAttribute(facplPolicyEClass, FACPL_POLICY__NAME);
    createEReference(facplPolicyEClass, FACPL_POLICY__TARGET);
    createEReference(facplPolicyEClass, FACPL_POLICY__OBL);

    abstractPolicyInclEClass = createEClass(ABSTRACT_POLICY_INCL);
    createEReference(abstractPolicyInclEClass, ABSTRACT_POLICY_INCL__NEW_POLICY);
    createEReference(abstractPolicyInclEClass, ABSTRACT_POLICY_INCL__REF_POL);

    policySetEClass = createEClass(POLICY_SET);
    createEReference(policySetEClass, POLICY_SET__POL_SET_ALG);
    createEReference(policySetEClass, POLICY_SET__POLICIES);

    algEClass = createEClass(ALG);
    createEAttribute(algEClass, ALG__ID_ALG);
    createEAttribute(algEClass, ALG__FSTRATEGY);

    ruleEClass = createEClass(RULE);
    createEAttribute(ruleEClass, RULE__EFFECT);

    expressionEClass = createEClass(EXPRESSION);

    notExpressionEClass = createEClass(NOT_EXPRESSION);
    createEReference(notExpressionEClass, NOT_EXPRESSION__ARG);

    functionEClass = createEClass(FUNCTION);
    createEAttribute(functionEClass, FUNCTION__FUNCTION_ID);
    createEReference(functionEClass, FUNCTION__ARG1);
    createEReference(functionEClass, FUNCTION__ATT1);
    createEReference(functionEClass, FUNCTION__ARG2);
    createEReference(functionEClass, FUNCTION__ATT2);

    declaredFunctionEClass = createEClass(DECLARED_FUNCTION);
    createEReference(declaredFunctionEClass, DECLARED_FUNCTION__FUNCTION_ID);
    createEReference(declaredFunctionEClass, DECLARED_FUNCTION__ARGS);

    setEClass = createEClass(SET);
    createEReference(setEClass, SET__ARGS);

    stringLiteralEClass = createEClass(STRING_LITERAL);
    createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

    booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
    createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

    intLiteralEClass = createEClass(INT_LITERAL);
    createEAttribute(intLiteralEClass, INT_LITERAL__VALUE);

    doubleLiteralEClass = createEClass(DOUBLE_LITERAL);
    createEAttribute(doubleLiteralEClass, DOUBLE_LITERAL__VALUE);

    dateLiteralEClass = createEClass(DATE_LITERAL);
    createEAttribute(dateLiteralEClass, DATE_LITERAL__VALUE);

    timeLiteralEClass = createEClass(TIME_LITERAL);
    createEAttribute(timeLiteralEClass, TIME_LITERAL__VALUE);

    andExpressionEClass = createEClass(AND_EXPRESSION);
    createEReference(andExpressionEClass, AND_EXPRESSION__LEFT);
    createEReference(andExpressionEClass, AND_EXPRESSION__RIGHT);

    orExpressionEClass = createEClass(OR_EXPRESSION);
    createEReference(orExpressionEClass, OR_EXPRESSION__LEFT);
    createEReference(orExpressionEClass, OR_EXPRESSION__RIGHT);

    // Create enums
    typeLiteralEEnum = createEEnum(TYPE_LITERAL);
    pepAlgEEnum = createEEnum(PEP_ALG);
    algLiteralEEnum = createEEnum(ALG_LITERAL);
    fulfillmentStrategyEEnum = createEEnum(FULFILLMENT_STRATEGY);
    effectEEnum = createEEnum(EFFECT);
    funIDEEnum = createEEnum(FUN_ID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    attributeNameEClass.getESuperTypes().add(this.getExpression());
    policySetEClass.getESuperTypes().add(this.getFacplPolicy());
    ruleEClass.getESuperTypes().add(this.getFacplPolicy());
    notExpressionEClass.getESuperTypes().add(this.getExpression());
    functionEClass.getESuperTypes().add(this.getExpression());
    declaredFunctionEClass.getESuperTypes().add(this.getExpression());
    setEClass.getESuperTypes().add(this.getExpression());
    stringLiteralEClass.getESuperTypes().add(this.getExpression());
    booleanLiteralEClass.getESuperTypes().add(this.getExpression());
    intLiteralEClass.getESuperTypes().add(this.getExpression());
    doubleLiteralEClass.getESuperTypes().add(this.getExpression());
    dateLiteralEClass.getESuperTypes().add(this.getExpression());
    timeLiteralEClass.getESuperTypes().add(this.getExpression());
    andExpressionEClass.getESuperTypes().add(this.getExpression());
    orExpressionEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(facplEClass, Facpl.class, "Facpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFacpl_ImportEl(), this.getImport(), null, "importEl", null, 0, -1, Facpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFacpl_Declarations(), this.getFunctionDeclaration(), null, "declarations", null, 0, -1, Facpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFacpl_Policies(), this.getPolicySet(), null, "policies", null, 0, -1, Facpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFacpl_Requests(), this.getRequest(), null, "requests", null, 0, -1, Facpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFacpl_Main(), this.getMainFacpl(), null, "main", null, 0, 1, Facpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mainFacplEClass, MainFacpl.class, "MainFacpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMainFacpl_ExtIndet(), this.getBooleanLiteral(), null, "extIndet", null, 0, 1, MainFacpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMainFacpl_GenPackage(), ecorePackage.getEString(), "genPackage", null, 0, 1, MainFacpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMainFacpl_RefRequest(), this.getRequest(), null, "refRequest", null, 0, -1, MainFacpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMainFacpl_Paf(), this.getPAF(), null, "paf", null, 0, 1, MainFacpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionDeclarationEClass, FunctionDeclaration.class, "FunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunctionDeclaration_Type(), this.getTypeLiteral(), "type", null, 0, 1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionDeclaration_Args(), this.getTypeLiteral(), "args", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pafEClass, it.unifi.xtext.facpl.facpl2.PAF.class, "PAF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPAF_Status(), this.getSTATUS(), null, "status", null, 0, 1, it.unifi.xtext.facpl.facpl2.PAF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPAF_Pep(), this.getPEPAlg(), "pep", null, 0, 1, it.unifi.xtext.facpl.facpl2.PAF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPAF_Pdp(), this.getPDP(), null, "pdp", null, 0, 1, it.unifi.xtext.facpl.facpl2.PAF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statusEClass, it.unifi.xtext.facpl.facpl2.STATUS.class, "STATUS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSTATUS_Elements(), this.getAttributeDeclaration(), null, "elements", null, 0, -1, it.unifi.xtext.facpl.facpl2.STATUS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribute_Type(), ecorePackage.getEString(), "type", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribute_X(), this.getExpression(), null, "x", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeDeclarationEClass, AttributeDeclaration.class, "AttributeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributeDeclaration_Att(), this.getAttribute(), null, "att", null, 0, 1, AttributeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pepFunctionEClass, PepFunction.class, "PepFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPepFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, PepFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPepFunction_Att(), this.getAttribute(), null, "att", null, 0, 1, PepFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPepFunction_Value(), this.getExpression(), null, "value", null, 0, 1, PepFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(obligationEClass, Obligation.class, "Obligation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getObligation_EvaluetedOn(), this.getEffect(), "EvaluetedOn", null, 0, 1, Obligation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObligation_TypeObl(), ecorePackage.getEString(), "typeObl", null, 0, 1, Obligation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObligation_PepAction(), ecorePackage.getEString(), "pepAction", null, 0, 1, Obligation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObligation_Expr(), this.getExpression(), null, "expr", null, 0, -1, Obligation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObligation_Function(), this.getPepFunction(), null, "function", null, 0, 1, Obligation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObligation_E1(), this.getFunction(), null, "e1", null, 0, 1, Obligation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObligation_E2(), this.getFunction(), null, "e2", null, 0, 1, Obligation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObligation_Expiration(), this.getExpression(), null, "expiration", null, 0, 1, Obligation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requestEClass, Request.class, "Request", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRequest_Stub(), ecorePackage.getEString(), "stub", null, 0, 1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRequest_Name(), ecorePackage.getEString(), "name", null, 0, 1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequest_Attributes(), this.getAttributeReq(), null, "attributes", null, 0, -1, Request.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeReqEClass, AttributeReq.class, "AttributeReq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttributeReq_Name(), this.getAttributeName(), null, "name", null, 0, 1, AttributeReq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttributeReq_Value(), this.getExpression(), null, "value", null, 0, -1, AttributeReq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeNameEClass, AttributeName.class, "AttributeName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttributeName_Category(), ecorePackage.getEString(), "category", null, 0, 1, AttributeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttributeName_Id(), ecorePackage.getEString(), "id", null, 0, 1, AttributeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pdpEClass, it.unifi.xtext.facpl.facpl2.PDP.class, "PDP", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPDP_PdpAlg(), this.getAlg(), null, "pdpAlg", null, 0, 1, it.unifi.xtext.facpl.facpl2.PDP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPDP_PolSet(), this.getAbstractPolicyIncl(), null, "polSet", null, 0, -1, it.unifi.xtext.facpl.facpl2.PDP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(facplPolicyEClass, FacplPolicy.class, "FacplPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFacplPolicy_Name(), ecorePackage.getEString(), "name", null, 0, 1, FacplPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFacplPolicy_Target(), this.getExpression(), null, "target", null, 0, 1, FacplPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFacplPolicy_Obl(), this.getObligation(), null, "obl", null, 0, -1, FacplPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractPolicyInclEClass, AbstractPolicyIncl.class, "AbstractPolicyIncl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractPolicyIncl_NewPolicy(), this.getFacplPolicy(), null, "newPolicy", null, 0, 1, AbstractPolicyIncl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractPolicyIncl_RefPol(), this.getPolicySet(), null, "refPol", null, 0, 1, AbstractPolicyIncl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(policySetEClass, PolicySet.class, "PolicySet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPolicySet_PolSetAlg(), this.getAlg(), null, "polSetAlg", null, 0, 1, PolicySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPolicySet_Policies(), this.getAbstractPolicyIncl(), null, "policies", null, 0, -1, PolicySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(algEClass, Alg.class, "Alg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAlg_IdAlg(), this.getAlgLiteral(), "idAlg", null, 0, 1, Alg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAlg_FStrategy(), this.getFulfillmentStrategy(), "fStrategy", null, 0, 1, Alg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRule_Effect(), this.getEffect(), "effect", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(notExpressionEClass, NotExpression.class, "NotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNotExpression_Arg(), this.getExpression(), null, "arg", null, 0, 1, NotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunction_FunctionId(), this.getfunID(), "functionId", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunction_Arg1(), this.getExpression(), null, "arg1", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunction_Att1(), this.getAttribute(), null, "att1", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunction_Arg2(), this.getExpression(), null, "arg2", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunction_Att2(), this.getAttribute(), null, "att2", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(declaredFunctionEClass, DeclaredFunction.class, "DeclaredFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDeclaredFunction_FunctionId(), this.getFunctionDeclaration(), null, "functionId", null, 0, 1, DeclaredFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDeclaredFunction_Args(), this.getExpression(), null, "args", null, 0, -1, DeclaredFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(setEClass, Set.class, "Set", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSet_Args(), this.getExpression(), null, "args", null, 0, -1, Set.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanLiteral_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intLiteralEClass, IntLiteral.class, "IntLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntLiteral_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doubleLiteralEClass, DoubleLiteral.class, "DoubleLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDoubleLiteral_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, DoubleLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dateLiteralEClass, DateLiteral.class, "DateLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDateLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, DateLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeLiteralEClass, TimeLiteral.class, "TimeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, TimeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpression_Left(), this.getExpression(), null, "left", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndExpression_Right(), this.getExpression(), null, "right", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpression_Left(), this.getExpression(), null, "left", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrExpression_Right(), this.getExpression(), null, "right", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(typeLiteralEEnum, TypeLiteral.class, "TypeLiteral");
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.INT);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.DOUBLE);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.BOOL);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.STRING);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.DATE_TIME);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.SET_INT);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.SET_DOUBLE);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.SET_BOOL);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.SET_STRING);
    addEEnumLiteral(typeLiteralEEnum, TypeLiteral.SET_DATE_TIME);

    initEEnum(pepAlgEEnum, PEPAlg.class, "PEPAlg");
    addEEnumLiteral(pepAlgEEnum, PEPAlg.BASE);
    addEEnumLiteral(pepAlgEEnum, PEPAlg.DENY);
    addEEnumLiteral(pepAlgEEnum, PEPAlg.PERMIT);

    initEEnum(algLiteralEEnum, AlgLiteral.class, "AlgLiteral");
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.ONLY_ONE);
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.DENY_OVER);
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.PERMIT_OVER);
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.FIRST);
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.DENY_UNLESS);
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.PERMIT_UNLESS);
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.WEAK_CONS);
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.STRONG_CONS);
    addEEnumLiteral(algLiteralEEnum, AlgLiteral.CUSTOM_ALG);

    initEEnum(fulfillmentStrategyEEnum, FulfillmentStrategy.class, "FulfillmentStrategy");
    addEEnumLiteral(fulfillmentStrategyEEnum, FulfillmentStrategy.GREEDY);
    addEEnumLiteral(fulfillmentStrategyEEnum, FulfillmentStrategy.ALL);

    initEEnum(effectEEnum, Effect.class, "Effect");
    addEEnumLiteral(effectEEnum, Effect.PERMIT);
    addEEnumLiteral(effectEEnum, Effect.DENY);

    initEEnum(funIDEEnum, funID.class, "funID");
    addEEnumLiteral(funIDEEnum, funID.EQUAL);
    addEEnumLiteral(funIDEEnum, funID.NEQUAL);
    addEEnumLiteral(funIDEEnum, funID.LESS);
    addEEnumLiteral(funIDEEnum, funID.LESS_EQ);
    addEEnumLiteral(funIDEEnum, funID.GREATER);
    addEEnumLiteral(funIDEEnum, funID.GREATER_EQ);
    addEEnumLiteral(funIDEEnum, funID.IN);
    addEEnumLiteral(funIDEEnum, funID.ADD);
    addEEnumLiteral(funIDEEnum, funID.SUBTRACT);
    addEEnumLiteral(funIDEEnum, funID.DIVIDE);
    addEEnumLiteral(funIDEEnum, funID.MULTIPLY);

    // Create resource
    createResource(eNS_URI);
  }

} //Facpl2PackageImpl
