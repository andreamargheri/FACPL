/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import it.unifi.xtext.facpl.facpl2.DeclaredFunction;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration;

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
 * An implementation of the model object '<em><b>Declared Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.DeclaredFunctionImpl#getFunctionId <em>Function Id</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.impl.DeclaredFunctionImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclaredFunctionImpl extends ExpressionImpl implements DeclaredFunction
{
  /**
   * The cached value of the '{@link #getFunctionId() <em>Function Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctionId()
   * @generated
   * @ordered
   */
  protected FunctionDeclaration functionId;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Expression> args;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclaredFunctionImpl()
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
    return Facpl2Package.Literals.DECLARED_FUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDeclaration getFunctionId()
  {
    if (functionId != null && functionId.eIsProxy())
    {
      InternalEObject oldFunctionId = (InternalEObject)functionId;
      functionId = (FunctionDeclaration)eResolveProxy(oldFunctionId);
      if (functionId != oldFunctionId)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Facpl2Package.DECLARED_FUNCTION__FUNCTION_ID, oldFunctionId, functionId));
      }
    }
    return functionId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDeclaration basicGetFunctionId()
  {
    return functionId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunctionId(FunctionDeclaration newFunctionId)
  {
    FunctionDeclaration oldFunctionId = functionId;
    functionId = newFunctionId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.DECLARED_FUNCTION__FUNCTION_ID, oldFunctionId, functionId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Expression>(Expression.class, this, Facpl2Package.DECLARED_FUNCTION__ARGS);
    }
    return args;
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
      case Facpl2Package.DECLARED_FUNCTION__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case Facpl2Package.DECLARED_FUNCTION__FUNCTION_ID:
        if (resolve) return getFunctionId();
        return basicGetFunctionId();
      case Facpl2Package.DECLARED_FUNCTION__ARGS:
        return getArgs();
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
      case Facpl2Package.DECLARED_FUNCTION__FUNCTION_ID:
        setFunctionId((FunctionDeclaration)newValue);
        return;
      case Facpl2Package.DECLARED_FUNCTION__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expression>)newValue);
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
      case Facpl2Package.DECLARED_FUNCTION__FUNCTION_ID:
        setFunctionId((FunctionDeclaration)null);
        return;
      case Facpl2Package.DECLARED_FUNCTION__ARGS:
        getArgs().clear();
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
      case Facpl2Package.DECLARED_FUNCTION__FUNCTION_ID:
        return functionId != null;
      case Facpl2Package.DECLARED_FUNCTION__ARGS:
        return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DeclaredFunctionImpl
