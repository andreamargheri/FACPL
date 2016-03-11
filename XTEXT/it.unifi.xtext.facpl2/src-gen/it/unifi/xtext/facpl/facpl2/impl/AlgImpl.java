/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import it.unifi.xtext.facpl.facpl2.Alg;
import it.unifi.xtext.facpl.facpl2.AlgLiteral;
import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.FulfillmentStrategy;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Alg</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.AlgImpl#getIdAlg <em>Id Alg</em>}
 * </li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.AlgImpl#getFStrategy
 * <em>FStrategy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlgImpl extends MinimalEObjectImpl.Container implements Alg {
	/**
	 * The default value of the '{@link #getIdAlg() <em>Id Alg</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIdAlg()
	 * @generated
	 * @ordered
	 */
	protected static final AlgLiteral ID_ALG_EDEFAULT = AlgLiteral.ONLY_ONE;

	/**
	 * The cached value of the '{@link #getIdAlg() <em>Id Alg</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIdAlg()
	 * @generated
	 * @ordered
	 */
	protected AlgLiteral idAlg = ID_ALG_EDEFAULT;

	/**
	 * The default value of the '{@link #getFStrategy() <em>FStrategy</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFStrategy()
	 * @generated
	 * @ordered
	 */
	protected static final FulfillmentStrategy FSTRATEGY_EDEFAULT = FulfillmentStrategy.GREEDY;

	/**
	 * The cached value of the '{@link #getFStrategy() <em>FStrategy</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFStrategy()
	 * @generated
	 * @ordered
	 */
	protected FulfillmentStrategy fStrategy = FSTRATEGY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AlgImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Facpl2Package.Literals.ALG;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AlgLiteral getIdAlg() {
		return idAlg;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIdAlg(AlgLiteral newIdAlg) {
		AlgLiteral oldIdAlg = idAlg;
		idAlg = newIdAlg == null ? ID_ALG_EDEFAULT : newIdAlg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.ALG__ID_ALG, oldIdAlg, idAlg));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FulfillmentStrategy getFStrategy() {
		return fStrategy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFStrategy(FulfillmentStrategy newFStrategy) {
		FulfillmentStrategy oldFStrategy = fStrategy;
		fStrategy = newFStrategy == null ? FSTRATEGY_EDEFAULT : newFStrategy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.ALG__FSTRATEGY, oldFStrategy,
					fStrategy));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Facpl2Package.ALG__ID_ALG:
			return getIdAlg();
		case Facpl2Package.ALG__FSTRATEGY:
			return getFStrategy();
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
		case Facpl2Package.ALG__ID_ALG:
			setIdAlg((AlgLiteral) newValue);
			return;
		case Facpl2Package.ALG__FSTRATEGY:
			setFStrategy((FulfillmentStrategy) newValue);
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
		case Facpl2Package.ALG__ID_ALG:
			setIdAlg(ID_ALG_EDEFAULT);
			return;
		case Facpl2Package.ALG__FSTRATEGY:
			setFStrategy(FSTRATEGY_EDEFAULT);
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
		case Facpl2Package.ALG__ID_ALG:
			return idAlg != ID_ALG_EDEFAULT;
		case Facpl2Package.ALG__FSTRATEGY:
			return fStrategy != FSTRATEGY_EDEFAULT;
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
		result.append(" (idAlg: ");
		result.append(idAlg);
		result.append(", fStrategy: ");
		result.append(fStrategy);
		result.append(')');
		return result.toString();
	}

} // AlgImpl
