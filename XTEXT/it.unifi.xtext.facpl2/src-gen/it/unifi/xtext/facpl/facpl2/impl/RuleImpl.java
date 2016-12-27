/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.Effect;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.Obligation;
import it.unifi.xtext.facpl.facpl2.Rule;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.RuleImpl#getEffect <em>Effect</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.RuleImpl#getObl <em>Obl</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleImpl extends FacplPolicyImpl implements Rule
{
  /**
   * The default value of the '{@link #getEffect() <em>Effect</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffect()
   * @generated
   * @ordered
   */
  protected static final Effect EFFECT_EDEFAULT = Effect.PERMIT;

  /**
   * The cached value of the '{@link #getEffect() <em>Effect</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffect()
   * @generated
   * @ordered
   */
  protected Effect effect = EFFECT_EDEFAULT;

  /**
   * The cached value of the '{@link #getObl() <em>Obl</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObl()
   * @generated
   * @ordered
   */
  protected EList<Obligation> obl;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleImpl()
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
    return Facpl2Package.Literals.RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Effect getEffect()
  {
    return effect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEffect(Effect newEffect)
  {
    Effect oldEffect = effect;
    effect = newEffect == null ? EFFECT_EDEFAULT : newEffect;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.RULE__EFFECT, oldEffect, effect));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Obligation> getObl()
  {
    if (obl == null)
    {
      obl = new EObjectContainmentEList<Obligation>(Obligation.class, this, Facpl2Package.RULE__OBL);
    }
    return obl;
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
      case Facpl2Package.RULE__OBL:
        return ((InternalEList<?>)getObl()).basicRemove(otherEnd, msgs);
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
      case Facpl2Package.RULE__EFFECT:
        return getEffect();
      case Facpl2Package.RULE__OBL:
        return getObl();
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
      case Facpl2Package.RULE__EFFECT:
        setEffect((Effect)newValue);
        return;
      case Facpl2Package.RULE__OBL:
        getObl().clear();
        getObl().addAll((Collection<? extends Obligation>)newValue);
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
      case Facpl2Package.RULE__EFFECT:
        setEffect(EFFECT_EDEFAULT);
        return;
      case Facpl2Package.RULE__OBL:
        getObl().clear();
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
      case Facpl2Package.RULE__EFFECT:
        return effect != EFFECT_EDEFAULT;
      case Facpl2Package.RULE__OBL:
        return obl != null && !obl.isEmpty();
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
    result.append(" (effect: ");
    result.append(effect);
    result.append(')');
    return result.toString();
  }

} //RuleImpl
