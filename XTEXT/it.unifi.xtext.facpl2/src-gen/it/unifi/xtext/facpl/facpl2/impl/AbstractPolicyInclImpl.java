/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.PolicySet;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Policy Incl</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link it.unifi.xtext.facpl.facpl2.impl.AbstractPolicyInclImpl#getNewPolicy
 * <em>New Policy</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.AbstractPolicyInclImpl#getRefPol
 * <em>Ref Pol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractPolicyInclImpl extends MinimalEObjectImpl.Container implements AbstractPolicyIncl {
	/**
	 * The cached value of the '{@link #getNewPolicy() <em>New Policy</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewPolicy()
	 * @generated
	 * @ordered
	 */
	protected FacplPolicy newPolicy;

	/**
	 * The cached value of the '{@link #getRefPol() <em>Ref Pol</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRefPol()
	 * @generated
	 * @ordered
	 */
	protected PolicySet refPol;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AbstractPolicyInclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Facpl2Package.Literals.ABSTRACT_POLICY_INCL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FacplPolicy getNewPolicy() {
		return newPolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetNewPolicy(FacplPolicy newNewPolicy, NotificationChain msgs) {
		FacplPolicy oldNewPolicy = newPolicy;
		newPolicy = newNewPolicy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY, oldNewPolicy, newNewPolicy);
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
	public void setNewPolicy(FacplPolicy newNewPolicy) {
		if (newNewPolicy != newPolicy) {
			NotificationChain msgs = null;
			if (newPolicy != null)
				msgs = ((InternalEObject) newPolicy).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY, null, msgs);
			if (newNewPolicy != null)
				msgs = ((InternalEObject) newNewPolicy).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY, null, msgs);
			msgs = basicSetNewPolicy(newNewPolicy, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY,
					newNewPolicy, newNewPolicy));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PolicySet getRefPol() {
		if (refPol != null && refPol.eIsProxy()) {
			InternalEObject oldRefPol = (InternalEObject) refPol;
			refPol = (PolicySet) eResolveProxy(oldRefPol);
			if (refPol != oldRefPol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Facpl2Package.ABSTRACT_POLICY_INCL__REF_POL, oldRefPol, refPol));
			}
		}
		return refPol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PolicySet basicGetRefPol() {
		return refPol;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRefPol(PolicySet newRefPol) {
		PolicySet oldRefPol = refPol;
		refPol = newRefPol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.ABSTRACT_POLICY_INCL__REF_POL,
					oldRefPol, refPol));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY:
			return basicSetNewPolicy(null, msgs);
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
		case Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY:
			return getNewPolicy();
		case Facpl2Package.ABSTRACT_POLICY_INCL__REF_POL:
			if (resolve)
				return getRefPol();
			return basicGetRefPol();
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
		case Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY:
			setNewPolicy((FacplPolicy) newValue);
			return;
		case Facpl2Package.ABSTRACT_POLICY_INCL__REF_POL:
			setRefPol((PolicySet) newValue);
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
		case Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY:
			setNewPolicy((FacplPolicy) null);
			return;
		case Facpl2Package.ABSTRACT_POLICY_INCL__REF_POL:
			setRefPol((PolicySet) null);
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
		case Facpl2Package.ABSTRACT_POLICY_INCL__NEW_POLICY:
			return newPolicy != null;
		case Facpl2Package.ABSTRACT_POLICY_INCL__REF_POL:
			return refPol != null;
		}
		return super.eIsSet(featureID);
	}

} // AbstractPolicyInclImpl
