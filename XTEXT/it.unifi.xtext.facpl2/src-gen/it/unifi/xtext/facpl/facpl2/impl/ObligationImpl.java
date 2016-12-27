/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.Obligation;

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
 * An implementation of the model object '<em><b>Obligation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getTypeObl <em>Type Obl</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getPepAction <em>Pep Action</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObligationImpl extends MinimalEObjectImpl.Container implements Obligation
{
  /**
   * The default value of the '{@link #getTypeObl() <em>Type Obl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeObl()
   * @generated
   * @ordered
   */
  protected static final String TYPE_OBL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeObl() <em>Type Obl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeObl()
   * @generated
   * @ordered
   */
  protected String typeObl = TYPE_OBL_EDEFAULT;

  /**
   * The default value of the '{@link #getPepAction() <em>Pep Action</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPepAction()
   * @generated
   * @ordered
   */
  protected static final String PEP_ACTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPepAction() <em>Pep Action</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPepAction()
   * @generated
   * @ordered
   */
  protected String pepAction = PEP_ACTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected EList<Expression> expr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObligationImpl()
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
    return Facpl2Package.Literals.OBLIGATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeObl()
  {
    return typeObl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeObl(String newTypeObl)
  {
    String oldTypeObl = typeObl;
    typeObl = newTypeObl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__TYPE_OBL, oldTypeObl, typeObl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPepAction()
  {
    return pepAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPepAction(String newPepAction)
  {
    String oldPepAction = pepAction;
    pepAction = newPepAction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__PEP_ACTION, oldPepAction, pepAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getExpr()
  {
    if (expr == null)
    {
      expr = new EObjectContainmentEList<Expression>(Expression.class, this, Facpl2Package.OBLIGATION__EXPR);
    }
    return expr;
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
      case Facpl2Package.OBLIGATION__EXPR:
        return ((InternalEList<?>)getExpr()).basicRemove(otherEnd, msgs);
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
      case Facpl2Package.OBLIGATION__TYPE_OBL:
        return getTypeObl();
      case Facpl2Package.OBLIGATION__PEP_ACTION:
        return getPepAction();
      case Facpl2Package.OBLIGATION__EXPR:
        return getExpr();
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
      case Facpl2Package.OBLIGATION__TYPE_OBL:
        setTypeObl((String)newValue);
        return;
      case Facpl2Package.OBLIGATION__PEP_ACTION:
        setPepAction((String)newValue);
        return;
      case Facpl2Package.OBLIGATION__EXPR:
        getExpr().clear();
        getExpr().addAll((Collection<? extends Expression>)newValue);
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
      case Facpl2Package.OBLIGATION__TYPE_OBL:
        setTypeObl(TYPE_OBL_EDEFAULT);
        return;
      case Facpl2Package.OBLIGATION__PEP_ACTION:
        setPepAction(PEP_ACTION_EDEFAULT);
        return;
      case Facpl2Package.OBLIGATION__EXPR:
        getExpr().clear();
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
      case Facpl2Package.OBLIGATION__TYPE_OBL:
        return TYPE_OBL_EDEFAULT == null ? typeObl != null : !TYPE_OBL_EDEFAULT.equals(typeObl);
      case Facpl2Package.OBLIGATION__PEP_ACTION:
        return PEP_ACTION_EDEFAULT == null ? pepAction != null : !PEP_ACTION_EDEFAULT.equals(pepAction);
      case Facpl2Package.OBLIGATION__EXPR:
        return expr != null && !expr.isEmpty();
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
    result.append(" (typeObl: ");
    result.append(typeObl);
    result.append(", pepAction: ");
    result.append(pepAction);
    result.append(')');
    return result.toString();
  }

} //ObligationImpl
