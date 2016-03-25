/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.Effect;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.Obligation;
import it.unifi.xtext.facpl.facpl2.PepFunction;

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
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getEvaluetedOn <em>Evalueted On</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getTypeObl <em>Type Obl</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getPepAction <em>Pep Action</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getE1 <em>E1</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getE2 <em>E2</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.ObligationImpl#getExpiration <em>Expiration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObligationImpl extends MinimalEObjectImpl.Container implements Obligation
{
  /**
   * The default value of the '{@link #getEvaluetedOn() <em>Evalueted On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluetedOn()
   * @generated
   * @ordered
   */
  protected static final Effect EVALUETED_ON_EDEFAULT = Effect.PERMIT;

  /**
   * The cached value of the '{@link #getEvaluetedOn() <em>Evalueted On</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluetedOn()
   * @generated
   * @ordered
   */
  protected Effect evaluetedOn = EVALUETED_ON_EDEFAULT;

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
   * The cached value of the '{@link #getFunction() <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected PepFunction function;

  /**
   * The cached value of the '{@link #getE1() <em>E1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getE1()
   * @generated
   * @ordered
   */
  protected Function e1;

  /**
   * The cached value of the '{@link #getE2() <em>E2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getE2()
   * @generated
   * @ordered
   */
  protected Function e2;

  /**
   * The cached value of the '{@link #getExpiration() <em>Expiration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpiration()
   * @generated
   * @ordered
   */
  protected Expression expiration;

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
  public Effect getEvaluetedOn()
  {
    return evaluetedOn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvaluetedOn(Effect newEvaluetedOn)
  {
    Effect oldEvaluetedOn = evaluetedOn;
    evaluetedOn = newEvaluetedOn == null ? EVALUETED_ON_EDEFAULT : newEvaluetedOn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__EVALUETED_ON, oldEvaluetedOn, evaluetedOn));
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
  public PepFunction getFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFunction(PepFunction newFunction, NotificationChain msgs)
  {
    PepFunction oldFunction = function;
    function = newFunction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__FUNCTION, oldFunction, newFunction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(PepFunction newFunction)
  {
    if (newFunction != function)
    {
      NotificationChain msgs = null;
      if (function != null)
        msgs = ((InternalEObject)function).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.OBLIGATION__FUNCTION, null, msgs);
      if (newFunction != null)
        msgs = ((InternalEObject)newFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.OBLIGATION__FUNCTION, null, msgs);
      msgs = basicSetFunction(newFunction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__FUNCTION, newFunction, newFunction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function getE1()
  {
    return e1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetE1(Function newE1, NotificationChain msgs)
  {
    Function oldE1 = e1;
    e1 = newE1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__E1, oldE1, newE1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setE1(Function newE1)
  {
    if (newE1 != e1)
    {
      NotificationChain msgs = null;
      if (e1 != null)
        msgs = ((InternalEObject)e1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.OBLIGATION__E1, null, msgs);
      if (newE1 != null)
        msgs = ((InternalEObject)newE1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.OBLIGATION__E1, null, msgs);
      msgs = basicSetE1(newE1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__E1, newE1, newE1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function getE2()
  {
    return e2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetE2(Function newE2, NotificationChain msgs)
  {
    Function oldE2 = e2;
    e2 = newE2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__E2, oldE2, newE2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setE2(Function newE2)
  {
    if (newE2 != e2)
    {
      NotificationChain msgs = null;
      if (e2 != null)
        msgs = ((InternalEObject)e2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.OBLIGATION__E2, null, msgs);
      if (newE2 != null)
        msgs = ((InternalEObject)newE2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.OBLIGATION__E2, null, msgs);
      msgs = basicSetE2(newE2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__E2, newE2, newE2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpiration()
  {
    return expiration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpiration(Expression newExpiration, NotificationChain msgs)
  {
    Expression oldExpiration = expiration;
    expiration = newExpiration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__EXPIRATION, oldExpiration, newExpiration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpiration(Expression newExpiration)
  {
    if (newExpiration != expiration)
    {
      NotificationChain msgs = null;
      if (expiration != null)
        msgs = ((InternalEObject)expiration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.OBLIGATION__EXPIRATION, null, msgs);
      if (newExpiration != null)
        msgs = ((InternalEObject)newExpiration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.OBLIGATION__EXPIRATION, null, msgs);
      msgs = basicSetExpiration(newExpiration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.OBLIGATION__EXPIRATION, newExpiration, newExpiration));
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
      case Facpl2Package.OBLIGATION__FUNCTION:
        return basicSetFunction(null, msgs);
      case Facpl2Package.OBLIGATION__E1:
        return basicSetE1(null, msgs);
      case Facpl2Package.OBLIGATION__E2:
        return basicSetE2(null, msgs);
      case Facpl2Package.OBLIGATION__EXPIRATION:
        return basicSetExpiration(null, msgs);
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
      case Facpl2Package.OBLIGATION__EVALUETED_ON:
        return getEvaluetedOn();
      case Facpl2Package.OBLIGATION__TYPE_OBL:
        return getTypeObl();
      case Facpl2Package.OBLIGATION__PEP_ACTION:
        return getPepAction();
      case Facpl2Package.OBLIGATION__EXPR:
        return getExpr();
      case Facpl2Package.OBLIGATION__FUNCTION:
        return getFunction();
      case Facpl2Package.OBLIGATION__E1:
        return getE1();
      case Facpl2Package.OBLIGATION__E2:
        return getE2();
      case Facpl2Package.OBLIGATION__EXPIRATION:
        return getExpiration();
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
      case Facpl2Package.OBLIGATION__EVALUETED_ON:
        setEvaluetedOn((Effect)newValue);
        return;
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
      case Facpl2Package.OBLIGATION__FUNCTION:
        setFunction((PepFunction)newValue);
        return;
      case Facpl2Package.OBLIGATION__E1:
        setE1((Function)newValue);
        return;
      case Facpl2Package.OBLIGATION__E2:
        setE2((Function)newValue);
        return;
      case Facpl2Package.OBLIGATION__EXPIRATION:
        setExpiration((Expression)newValue);
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
      case Facpl2Package.OBLIGATION__EVALUETED_ON:
        setEvaluetedOn(EVALUETED_ON_EDEFAULT);
        return;
      case Facpl2Package.OBLIGATION__TYPE_OBL:
        setTypeObl(TYPE_OBL_EDEFAULT);
        return;
      case Facpl2Package.OBLIGATION__PEP_ACTION:
        setPepAction(PEP_ACTION_EDEFAULT);
        return;
      case Facpl2Package.OBLIGATION__EXPR:
        getExpr().clear();
        return;
      case Facpl2Package.OBLIGATION__FUNCTION:
        setFunction((PepFunction)null);
        return;
      case Facpl2Package.OBLIGATION__E1:
        setE1((Function)null);
        return;
      case Facpl2Package.OBLIGATION__E2:
        setE2((Function)null);
        return;
      case Facpl2Package.OBLIGATION__EXPIRATION:
        setExpiration((Expression)null);
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
      case Facpl2Package.OBLIGATION__EVALUETED_ON:
        return evaluetedOn != EVALUETED_ON_EDEFAULT;
      case Facpl2Package.OBLIGATION__TYPE_OBL:
        return TYPE_OBL_EDEFAULT == null ? typeObl != null : !TYPE_OBL_EDEFAULT.equals(typeObl);
      case Facpl2Package.OBLIGATION__PEP_ACTION:
        return PEP_ACTION_EDEFAULT == null ? pepAction != null : !PEP_ACTION_EDEFAULT.equals(pepAction);
      case Facpl2Package.OBLIGATION__EXPR:
        return expr != null && !expr.isEmpty();
      case Facpl2Package.OBLIGATION__FUNCTION:
        return function != null;
      case Facpl2Package.OBLIGATION__E1:
        return e1 != null;
      case Facpl2Package.OBLIGATION__E2:
        return e2 != null;
      case Facpl2Package.OBLIGATION__EXPIRATION:
        return expiration != null;
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
    result.append(" (EvaluetedOn: ");
    result.append(evaluetedOn);
    result.append(", typeObl: ");
    result.append(typeObl);
    result.append(", pepAction: ");
    result.append(pepAction);
    result.append(')');
    return result.toString();
  }

} //ObligationImpl
