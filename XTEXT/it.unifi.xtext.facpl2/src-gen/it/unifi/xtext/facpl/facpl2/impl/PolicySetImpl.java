/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Alg;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.PolicySet;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Policy Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.PolicySetImpl#getPolSetAlg
 * <em>Pol Set Alg</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.PolicySetImpl#getPolicies
 * <em>Policies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PolicySetImpl extends FacplPolicyImpl implements PolicySet {
	/**
	 * The cached value of the '{@link #getPolSetAlg() <em>Pol Set Alg</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPolSetAlg()
	 * @generated
	 * @ordered
	 */
	protected Alg polSetAlg;

	/**
	 * The cached value of the '{@link #getPolicies() <em>Policies</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPolicies()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractPolicyIncl> policies;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PolicySetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Facpl2Package.Literals.POLICY_SET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Alg getPolSetAlg() {
		return polSetAlg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPolSetAlg(Alg newPolSetAlg, NotificationChain msgs) {
		Alg oldPolSetAlg = polSetAlg;
		polSetAlg = newPolSetAlg;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Facpl2Package.POLICY_SET__POL_SET_ALG, oldPolSetAlg, newPolSetAlg);
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
	public void setPolSetAlg(Alg newPolSetAlg) {
		if (newPolSetAlg != polSetAlg) {
			NotificationChain msgs = null;
			if (polSetAlg != null)
				msgs = ((InternalEObject) polSetAlg).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.POLICY_SET__POL_SET_ALG, null, msgs);
			if (newPolSetAlg != null)
				msgs = ((InternalEObject) newPolSetAlg).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.POLICY_SET__POL_SET_ALG, null, msgs);
			msgs = basicSetPolSetAlg(newPolSetAlg, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.POLICY_SET__POL_SET_ALG, newPolSetAlg,
					newPolSetAlg));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractPolicyIncl> getPolicies() {
		if (policies == null) {
			policies = new EObjectContainmentEList<AbstractPolicyIncl>(AbstractPolicyIncl.class, this,
					Facpl2Package.POLICY_SET__POLICIES);
		}
		return policies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Facpl2Package.POLICY_SET__POL_SET_ALG:
			return basicSetPolSetAlg(null, msgs);
		case Facpl2Package.POLICY_SET__POLICIES:
			return ((InternalEList<?>) getPolicies()).basicRemove(otherEnd, msgs);
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
		case Facpl2Package.POLICY_SET__POL_SET_ALG:
			return getPolSetAlg();
		case Facpl2Package.POLICY_SET__POLICIES:
			return getPolicies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Facpl2Package.POLICY_SET__POL_SET_ALG:
			setPolSetAlg((Alg) newValue);
			return;
		case Facpl2Package.POLICY_SET__POLICIES:
			getPolicies().clear();
			getPolicies().addAll((Collection<? extends AbstractPolicyIncl>) newValue);
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
		case Facpl2Package.POLICY_SET__POL_SET_ALG:
			setPolSetAlg((Alg) null);
			return;
		case Facpl2Package.POLICY_SET__POLICIES:
			getPolicies().clear();
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
		case Facpl2Package.POLICY_SET__POL_SET_ALG:
			return polSetAlg != null;
		case Facpl2Package.POLICY_SET__POLICIES:
			return policies != null && !policies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // PolicySetImpl
