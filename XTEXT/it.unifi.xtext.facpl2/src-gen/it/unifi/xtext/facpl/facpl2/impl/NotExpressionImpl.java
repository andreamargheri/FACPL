/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.NotExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.NotExpressionImpl#getArg <em>Arg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NotExpressionImpl extends ExpressionImpl implements NotExpression
{
  /**
   * The cached value of the '{@link #getArg() <em>Arg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArg()
   * @generated
   * @ordered
   */
  protected Expression arg;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NotExpressionImpl()
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
    return Facpl2Package.Literals.NOT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getArg()
  {
    return arg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArg(Expression newArg, NotificationChain msgs)
  {
    Expression oldArg = arg;
    arg = newArg;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.NOT_EXPRESSION__ARG, oldArg, newArg);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArg(Expression newArg)
  {
    if (newArg != arg)
    {
      NotificationChain msgs = null;
      if (arg != null)
        msgs = ((InternalEObject)arg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.NOT_EXPRESSION__ARG, null, msgs);
      if (newArg != null)
        msgs = ((InternalEObject)newArg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.NOT_EXPRESSION__ARG, null, msgs);
      msgs = basicSetArg(newArg, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.NOT_EXPRESSION__ARG, newArg, newArg));
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
      case Facpl2Package.NOT_EXPRESSION__ARG:
        return basicSetArg(null, msgs);
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
      case Facpl2Package.NOT_EXPRESSION__ARG:
        return getArg();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Facpl2Package.NOT_EXPRESSION__ARG:
        setArg((Expression)newValue);
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
      case Facpl2Package.NOT_EXPRESSION__ARG:
        setArg((Expression)null);
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
      case Facpl2Package.NOT_EXPRESSION__ARG:
        return arg != null;
    }
    return super.eIsSet(featureID);
  }

} //NotExpressionImpl
