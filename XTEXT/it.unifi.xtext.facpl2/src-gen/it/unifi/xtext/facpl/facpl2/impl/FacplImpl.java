/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration;
import it.unifi.xtext.facpl.facpl2.Import;
import it.unifi.xtext.facpl.facpl2.MainFacpl;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Request;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facpl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.FacplImpl#getImportEl <em>Import El</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.FacplImpl#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.FacplImpl#getPolicies <em>Policies</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.FacplImpl#getRequests <em>Requests</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.FacplImpl#getMain <em>Main</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FacplImpl extends MinimalEObjectImpl.Container implements Facpl
{
  /**
   * The cached value of the '{@link #getImportEl() <em>Import El</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportEl()
   * @generated
   * @ordered
   */
  protected EList<Import> importEl;

  /**
   * The cached value of the '{@link #getDeclarations() <em>Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclarations()
   * @generated
   * @ordered
   */
  protected EList<FunctionDeclaration> declarations;

  /**
   * The cached value of the '{@link #getPolicies() <em>Policies</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPolicies()
   * @generated
   * @ordered
   */
  protected EList<PolicySet> policies;

  /**
   * The cached value of the '{@link #getRequests() <em>Requests</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequests()
   * @generated
   * @ordered
   */
  protected EList<Request> requests;

  /**
   * The cached value of the '{@link #getMain() <em>Main</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMain()
   * @generated
   * @ordered
   */
  protected MainFacpl main;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FacplImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Facpl2Package.Literals.FACPL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImportEl()
  {
    if (importEl == null)
    {
      importEl = new EObjectContainmentEList<Import>(Import.class, this, Facpl2Package.FACPL__IMPORT_EL);
    }
    return importEl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FunctionDeclaration> getDeclarations()
  {
    if (declarations == null)
    {
      declarations = new EObjectContainmentEList<FunctionDeclaration>(FunctionDeclaration.class, this, Facpl2Package.FACPL__DECLARATIONS);
    }
    return declarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PolicySet> getPolicies()
  {
    if (policies == null)
    {
      policies = new EObjectContainmentEList<PolicySet>(PolicySet.class, this, Facpl2Package.FACPL__POLICIES);
    }
    return policies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Request> getRequests()
  {
    if (requests == null)
    {
      requests = new EObjectContainmentEList<Request>(Request.class, this, Facpl2Package.FACPL__REQUESTS);
    }
    return requests;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MainFacpl getMain()
  {
    return main;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMain(MainFacpl newMain, NotificationChain msgs)
  {
    MainFacpl oldMain = main;
    main = newMain;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.FACPL__MAIN, oldMain, newMain);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMain(MainFacpl newMain)
  {
    if (newMain != main)
    {
      NotificationChain msgs = null;
      if (main != null)
        msgs = ((InternalEObject)main).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.FACPL__MAIN, null, msgs);
      if (newMain != null)
        msgs = ((InternalEObject)newMain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.FACPL__MAIN, null, msgs);
      msgs = basicSetMain(newMain, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.FACPL__MAIN, newMain, newMain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case Facpl2Package.FACPL__IMPORT_EL:
        return ((InternalEList<?>)getImportEl()).basicRemove(otherEnd, msgs);
      case Facpl2Package.FACPL__DECLARATIONS:
        return ((InternalEList<?>)getDeclarations()).basicRemove(otherEnd, msgs);
      case Facpl2Package.FACPL__POLICIES:
        return ((InternalEList<?>)getPolicies()).basicRemove(otherEnd, msgs);
      case Facpl2Package.FACPL__REQUESTS:
        return ((InternalEList<?>)getRequests()).basicRemove(otherEnd, msgs);
      case Facpl2Package.FACPL__MAIN:
        return basicSetMain(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case Facpl2Package.FACPL__IMPORT_EL:
        return getImportEl();
      case Facpl2Package.FACPL__DECLARATIONS:
        return getDeclarations();
      case Facpl2Package.FACPL__POLICIES:
        return getPolicies();
      case Facpl2Package.FACPL__REQUESTS:
        return getRequests();
      case Facpl2Package.FACPL__MAIN:
        return getMain();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Facpl2Package.FACPL__IMPORT_EL:
        getImportEl().clear();
        getImportEl().addAll((Collection<? extends Import>)newValue);
        return;
      case Facpl2Package.FACPL__DECLARATIONS:
        getDeclarations().clear();
        getDeclarations().addAll((Collection<? extends FunctionDeclaration>)newValue);
        return;
      case Facpl2Package.FACPL__POLICIES:
        getPolicies().clear();
        getPolicies().addAll((Collection<? extends PolicySet>)newValue);
        return;
      case Facpl2Package.FACPL__REQUESTS:
        getRequests().clear();
        getRequests().addAll((Collection<? extends Request>)newValue);
        return;
      case Facpl2Package.FACPL__MAIN:
        setMain((MainFacpl)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case Facpl2Package.FACPL__IMPORT_EL:
        getImportEl().clear();
        return;
      case Facpl2Package.FACPL__DECLARATIONS:
        getDeclarations().clear();
        return;
      case Facpl2Package.FACPL__POLICIES:
        getPolicies().clear();
        return;
      case Facpl2Package.FACPL__REQUESTS:
        getRequests().clear();
        return;
      case Facpl2Package.FACPL__MAIN:
        setMain((MainFacpl)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Facpl2Package.FACPL__IMPORT_EL:
        return importEl != null && !importEl.isEmpty();
      case Facpl2Package.FACPL__DECLARATIONS:
        return declarations != null && !declarations.isEmpty();
      case Facpl2Package.FACPL__POLICIES:
        return policies != null && !policies.isEmpty();
      case Facpl2Package.FACPL__REQUESTS:
        return requests != null && !requests.isEmpty();
      case Facpl2Package.FACPL__MAIN:
        return main != null;
    }
    return super.eIsSet(featureID);
  }

} //FacplImpl
