/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.MainFacpl;
import it.unifi.xtext.facpl.facpl2.PAF;
import it.unifi.xtext.facpl.facpl2.Request;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main Facpl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl#getExtIndet <em>Ext Indet</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl#getSimulateXACML <em>Simulate XACML</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl#getGenPackage <em>Gen Package</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl#getRefRequest <em>Ref Request</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.MainFacplImpl#getPaf <em>Paf</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MainFacplImpl extends MinimalEObjectImpl.Container implements MainFacpl
{
  /**
   * The cached value of the '{@link #getExtIndet() <em>Ext Indet</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtIndet()
   * @generated
   * @ordered
   */
  protected BooleanLiteral extIndet;

  /**
   * The cached value of the '{@link #getSimulateXACML() <em>Simulate XACML</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSimulateXACML()
   * @generated
   * @ordered
   */
  protected BooleanLiteral simulateXACML;

  /**
   * The default value of the '{@link #getGenPackage() <em>Gen Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenPackage()
   * @generated
   * @ordered
   */
  protected static final String GEN_PACKAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGenPackage() <em>Gen Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenPackage()
   * @generated
   * @ordered
   */
  protected String genPackage = GEN_PACKAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getRefRequest() <em>Ref Request</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefRequest()
   * @generated
   * @ordered
   */
  protected EList<Request> refRequest;

  /**
   * The cached value of the '{@link #getPaf() <em>Paf</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPaf()
   * @generated
   * @ordered
   */
  protected PAF paf;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MainFacplImpl()
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
    return Facpl2Package.Literals.MAIN_FACPL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteral getExtIndet()
  {
    return extIndet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtIndet(BooleanLiteral newExtIndet, NotificationChain msgs)
  {
    BooleanLiteral oldExtIndet = extIndet;
    extIndet = newExtIndet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.MAIN_FACPL__EXT_INDET, oldExtIndet, newExtIndet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtIndet(BooleanLiteral newExtIndet)
  {
    if (newExtIndet != extIndet)
    {
      NotificationChain msgs = null;
      if (extIndet != null)
        msgs = ((InternalEObject)extIndet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.MAIN_FACPL__EXT_INDET, null, msgs);
      if (newExtIndet != null)
        msgs = ((InternalEObject)newExtIndet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.MAIN_FACPL__EXT_INDET, null, msgs);
      msgs = basicSetExtIndet(newExtIndet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.MAIN_FACPL__EXT_INDET, newExtIndet, newExtIndet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteral getSimulateXACML()
  {
    return simulateXACML;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSimulateXACML(BooleanLiteral newSimulateXACML, NotificationChain msgs)
  {
    BooleanLiteral oldSimulateXACML = simulateXACML;
    simulateXACML = newSimulateXACML;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.MAIN_FACPL__SIMULATE_XACML, oldSimulateXACML, newSimulateXACML);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSimulateXACML(BooleanLiteral newSimulateXACML)
  {
    if (newSimulateXACML != simulateXACML)
    {
      NotificationChain msgs = null;
      if (simulateXACML != null)
        msgs = ((InternalEObject)simulateXACML).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.MAIN_FACPL__SIMULATE_XACML, null, msgs);
      if (newSimulateXACML != null)
        msgs = ((InternalEObject)newSimulateXACML).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.MAIN_FACPL__SIMULATE_XACML, null, msgs);
      msgs = basicSetSimulateXACML(newSimulateXACML, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.MAIN_FACPL__SIMULATE_XACML, newSimulateXACML, newSimulateXACML));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGenPackage()
  {
    return genPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenPackage(String newGenPackage)
  {
    String oldGenPackage = genPackage;
    genPackage = newGenPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.MAIN_FACPL__GEN_PACKAGE, oldGenPackage, genPackage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Request> getRefRequest()
  {
    if (refRequest == null)
    {
      refRequest = new EObjectResolvingEList<Request>(Request.class, this, Facpl2Package.MAIN_FACPL__REF_REQUEST);
    }
    return refRequest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PAF getPaf()
  {
    return paf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPaf(PAF newPaf, NotificationChain msgs)
  {
    PAF oldPaf = paf;
    paf = newPaf;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.MAIN_FACPL__PAF, oldPaf, newPaf);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPaf(PAF newPaf)
  {
    if (newPaf != paf)
    {
      NotificationChain msgs = null;
      if (paf != null)
        msgs = ((InternalEObject)paf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.MAIN_FACPL__PAF, null, msgs);
      if (newPaf != null)
        msgs = ((InternalEObject)newPaf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.MAIN_FACPL__PAF, null, msgs);
      msgs = basicSetPaf(newPaf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.MAIN_FACPL__PAF, newPaf, newPaf));
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
      case Facpl2Package.MAIN_FACPL__EXT_INDET:
        return basicSetExtIndet(null, msgs);
      case Facpl2Package.MAIN_FACPL__SIMULATE_XACML:
        return basicSetSimulateXACML(null, msgs);
      case Facpl2Package.MAIN_FACPL__PAF:
        return basicSetPaf(null, msgs);
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
      case Facpl2Package.MAIN_FACPL__EXT_INDET:
        return getExtIndet();
      case Facpl2Package.MAIN_FACPL__SIMULATE_XACML:
        return getSimulateXACML();
      case Facpl2Package.MAIN_FACPL__GEN_PACKAGE:
        return getGenPackage();
      case Facpl2Package.MAIN_FACPL__REF_REQUEST:
        return getRefRequest();
      case Facpl2Package.MAIN_FACPL__PAF:
        return getPaf();
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
      case Facpl2Package.MAIN_FACPL__EXT_INDET:
        setExtIndet((BooleanLiteral)newValue);
        return;
      case Facpl2Package.MAIN_FACPL__SIMULATE_XACML:
        setSimulateXACML((BooleanLiteral)newValue);
        return;
      case Facpl2Package.MAIN_FACPL__GEN_PACKAGE:
        setGenPackage((String)newValue);
        return;
      case Facpl2Package.MAIN_FACPL__REF_REQUEST:
        getRefRequest().clear();
        getRefRequest().addAll((Collection<? extends Request>)newValue);
        return;
      case Facpl2Package.MAIN_FACPL__PAF:
        setPaf((PAF)newValue);
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
      case Facpl2Package.MAIN_FACPL__EXT_INDET:
        setExtIndet((BooleanLiteral)null);
        return;
      case Facpl2Package.MAIN_FACPL__SIMULATE_XACML:
        setSimulateXACML((BooleanLiteral)null);
        return;
      case Facpl2Package.MAIN_FACPL__GEN_PACKAGE:
        setGenPackage(GEN_PACKAGE_EDEFAULT);
        return;
      case Facpl2Package.MAIN_FACPL__REF_REQUEST:
        getRefRequest().clear();
        return;
      case Facpl2Package.MAIN_FACPL__PAF:
        setPaf((PAF)null);
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
      case Facpl2Package.MAIN_FACPL__EXT_INDET:
        return extIndet != null;
      case Facpl2Package.MAIN_FACPL__SIMULATE_XACML:
        return simulateXACML != null;
      case Facpl2Package.MAIN_FACPL__GEN_PACKAGE:
        return GEN_PACKAGE_EDEFAULT == null ? genPackage != null : !GEN_PACKAGE_EDEFAULT.equals(genPackage);
      case Facpl2Package.MAIN_FACPL__REF_REQUEST:
        return refRequest != null && !refRequest.isEmpty();
      case Facpl2Package.MAIN_FACPL__PAF:
        return paf != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (genPackage: ");
    result.append(genPackage);
    result.append(')');
    return result.toString();
  }

} //MainFacplImpl
