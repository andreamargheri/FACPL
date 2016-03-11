/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.funID;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Function</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.FunctionImpl#getFunctionId
 * <em>Function Id</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.FunctionImpl#getArg1
 * <em>Arg1</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.FunctionImpl#getArg2
 * <em>Arg2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionImpl extends ExpressionImpl implements Function {
	/**
	 * The default value of the '{@link #getFunctionId() <em>Function Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFunctionId()
	 * @generated
	 * @ordered
	 */
	protected static final funID FUNCTION_ID_EDEFAULT = funID.EQUAL;

	/**
	 * The cached value of the '{@link #getFunctionId() <em>Function Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFunctionId()
	 * @generated
	 * @ordered
	 */
	protected funID functionId = FUNCTION_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArg1() <em>Arg1</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getArg1()
	 * @generated
	 * @ordered
	 */
	protected Expression arg1;

	/**
	 * The cached value of the '{@link #getArg2() <em>Arg2</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getArg2()
	 * @generated
	 * @ordered
	 */
	protected Expression arg2;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Facpl2Package.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public funID getFunctionId() {
		return functionId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFunctionId(funID newFunctionId) {
		funID oldFunctionId = functionId;
		functionId = newFunctionId == null ? FUNCTION_ID_EDEFAULT : newFunctionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.FUNCTION__FUNCTION_ID, oldFunctionId,
					functionId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Expression getArg1() {
		return arg1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetArg1(Expression newArg1, NotificationChain msgs) {
		Expression oldArg1 = arg1;
		arg1 = newArg1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.FUNCTION__ARG1,
					oldArg1, newArg1);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setArg1(Expression newArg1) {
		if (newArg1 != arg1) {
			NotificationChain msgs = null;
			if (arg1 != null)
				msgs = ((InternalEObject) arg1).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.FUNCTION__ARG1, null, msgs);
			if (newArg1 != null)
				msgs = ((InternalEObject) newArg1).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.FUNCTION__ARG1, null, msgs);
			msgs = basicSetArg1(newArg1, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.FUNCTION__ARG1, newArg1, newArg1));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Expression getArg2() {
		return arg2;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetArg2(Expression newArg2, NotificationChain msgs) {
		Expression oldArg2 = arg2;
		arg2 = newArg2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.FUNCTION__ARG2,
					oldArg2, newArg2);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setArg2(Expression newArg2) {
		if (newArg2 != arg2) {
			NotificationChain msgs = null;
			if (arg2 != null)
				msgs = ((InternalEObject) arg2).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.FUNCTION__ARG2, null, msgs);
			if (newArg2 != null)
				msgs = ((InternalEObject) newArg2).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.FUNCTION__ARG2, null, msgs);
			msgs = basicSetArg2(newArg2, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.FUNCTION__ARG2, newArg2, newArg2));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Facpl2Package.FUNCTION__ARG1:
			return basicSetArg1(null, msgs);
		case Facpl2Package.FUNCTION__ARG2:
			return basicSetArg2(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Facpl2Package.FUNCTION__FUNCTION_ID:
			return getFunctionId();
		case Facpl2Package.FUNCTION__ARG1:
			return getArg1();
		case Facpl2Package.FUNCTION__ARG2:
			return getArg2();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Facpl2Package.FUNCTION__FUNCTION_ID:
			setFunctionId((funID) newValue);
			return;
		case Facpl2Package.FUNCTION__ARG1:
			setArg1((Expression) newValue);
			return;
		case Facpl2Package.FUNCTION__ARG2:
			setArg2((Expression) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Facpl2Package.FUNCTION__FUNCTION_ID:
			setFunctionId(FUNCTION_ID_EDEFAULT);
			return;
		case Facpl2Package.FUNCTION__ARG1:
			setArg1((Expression) null);
			return;
		case Facpl2Package.FUNCTION__ARG2:
			setArg2((Expression) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Facpl2Package.FUNCTION__FUNCTION_ID:
			return functionId != FUNCTION_ID_EDEFAULT;
		case Facpl2Package.FUNCTION__ARG1:
			return arg1 != null;
		case Facpl2Package.FUNCTION__ARG2:
			return arg2 != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (functionId: ");
		result.append(functionId);
		result.append(')');
		return result.toString();
	}

} // FunctionImpl
