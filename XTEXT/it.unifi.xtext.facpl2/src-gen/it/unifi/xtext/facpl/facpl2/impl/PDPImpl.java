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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.Alg;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.PDP;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PDP</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.PDPImpl#getPdpAlg
 * <em>Pdp Alg</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.PDPImpl#getPolSet
 * <em>Pol Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PDPImpl extends MinimalEObjectImpl.Container implements PDP {
	/**
	 * The cached value of the '{@link #getPdpAlg() <em>Pdp Alg</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPdpAlg()
	 * @generated
	 * @ordered
	 */
	protected Alg pdpAlg;

	/**
	 * The cached value of the '{@link #getPolSet() <em>Pol Set</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPolSet()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractPolicyIncl> polSet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PDPImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Facpl2Package.Literals.PDP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Alg getPdpAlg() {
		return pdpAlg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPdpAlg(Alg newPdpAlg, NotificationChain msgs) {
		Alg oldPdpAlg = pdpAlg;
		pdpAlg = newPdpAlg;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.PDP__PDP_ALG,
					oldPdpAlg, newPdpAlg);
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
	public void setPdpAlg(Alg newPdpAlg) {
		if (newPdpAlg != pdpAlg) {
			NotificationChain msgs = null;
			if (pdpAlg != null)
				msgs = ((InternalEObject) pdpAlg).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.PDP__PDP_ALG, null, msgs);
			if (newPdpAlg != null)
				msgs = ((InternalEObject) newPdpAlg).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Facpl2Package.PDP__PDP_ALG, null, msgs);
			msgs = basicSetPdpAlg(newPdpAlg, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.PDP__PDP_ALG, newPdpAlg, newPdpAlg));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractPolicyIncl> getPolSet() {
		if (polSet == null) {
			polSet = new EObjectContainmentEList<AbstractPolicyIncl>(AbstractPolicyIncl.class, this,
					Facpl2Package.PDP__POL_SET);
		}
		return polSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Facpl2Package.PDP__PDP_ALG:
			return basicSetPdpAlg(null, msgs);
		case Facpl2Package.PDP__POL_SET:
			return ((InternalEList<?>) getPolSet()).basicRemove(otherEnd, msgs);
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
		case Facpl2Package.PDP__PDP_ALG:
			return getPdpAlg();
		case Facpl2Package.PDP__POL_SET:
			return getPolSet();
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
		case Facpl2Package.PDP__PDP_ALG:
			setPdpAlg((Alg) newValue);
			return;
		case Facpl2Package.PDP__POL_SET:
			getPolSet().clear();
			getPolSet().addAll((Collection<? extends AbstractPolicyIncl>) newValue);
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
		case Facpl2Package.PDP__PDP_ALG:
			setPdpAlg((Alg) null);
			return;
		case Facpl2Package.PDP__POL_SET:
			getPolSet().clear();
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
		case Facpl2Package.PDP__PDP_ALG:
			return pdpAlg != null;
		case Facpl2Package.PDP__POL_SET:
			return polSet != null && !polSet.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // PDPImpl
