/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.PAF;
import it.unifi.xtext.facpl.facpl2.PDP;
import it.unifi.xtext.facpl.facpl2.PEPAlg;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PAF</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.PAFImpl#getPep <em>Pep</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.PAFImpl#getPdp <em>Pdp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PAFImpl extends MinimalEObjectImpl.Container implements PAF {
	/**
	 * The default value of the '{@link #getPep() <em>Pep</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPep()
	 * @generated
	 * @ordered
	 */
	protected static final PEPAlg PEP_EDEFAULT = PEPAlg.BASE;

	/**
	 * The cached value of the '{@link #getPep() <em>Pep</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPep()
	 * @generated
	 * @ordered
	 */
	protected PEPAlg pep = PEP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPdp() <em>Pdp</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPdp()
	 * @generated
	 * @ordered
	 */
	protected PDP pdp;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PAFImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Facpl2Package.Literals.PAF;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PEPAlg getPep() {
		return pep;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPep(PEPAlg newPep) {
		PEPAlg oldPep = pep;
		pep = newPep == null ? PEP_EDEFAULT : newPep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.PAF__PEP, oldPep, pep));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PDP getPdp() {
		return pdp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPdp(PDP newPdp, NotificationChain msgs) {
		PDP oldPdp = pdp;
		pdp = newPdp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Facpl2Package.PAF__PDP,
					oldPdp, newPdp);
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
	public void setPdp(PDP newPdp) {
		if (newPdp != pdp) {
			NotificationChain msgs = null;
			if (pdp != null)
				msgs = ((InternalEObject) pdp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.PAF__PDP,
						null, msgs);
			if (newPdp != null)
				msgs = ((InternalEObject) newPdp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Facpl2Package.PAF__PDP,
						null, msgs);
			msgs = basicSetPdp(newPdp, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.PAF__PDP, newPdp, newPdp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Facpl2Package.PAF__PDP:
			return basicSetPdp(null, msgs);
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
		case Facpl2Package.PAF__PEP:
			return getPep();
		case Facpl2Package.PAF__PDP:
			return getPdp();
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
		case Facpl2Package.PAF__PEP:
			setPep((PEPAlg) newValue);
			return;
		case Facpl2Package.PAF__PDP:
			setPdp((PDP) newValue);
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
		case Facpl2Package.PAF__PEP:
			setPep(PEP_EDEFAULT);
			return;
		case Facpl2Package.PAF__PDP:
			setPdp((PDP) null);
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
		case Facpl2Package.PAF__PEP:
			return pep != PEP_EDEFAULT;
		case Facpl2Package.PAF__PDP:
			return pdp != null;
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
		result.append(" (pep: ");
		result.append(pep);
		result.append(')');
		return result.toString();
	}

} // PAFImpl
