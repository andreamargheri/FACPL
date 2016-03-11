/**
 */
package it.unifi.xtext.facpl.facpl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import it.unifi.xtext.facpl.facpl2.Facpl2Package;
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration;
import it.unifi.xtext.facpl.facpl2.TypeLiteral;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Function Declaration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.FunctionDeclarationImpl#getType
 * <em>Type</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.FunctionDeclarationImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.impl.FunctionDeclarationImpl#getArgs
 * <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionDeclarationImpl extends MinimalEObjectImpl.Container implements FunctionDeclaration {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TypeLiteral TYPE_EDEFAULT = TypeLiteral.INT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeLiteral type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeLiteral> args;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FunctionDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Facpl2Package.Literals.FUNCTION_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeLiteral getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(TypeLiteral newType) {
		TypeLiteral oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.FUNCTION_DECLARATION__TYPE, oldType,
					type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Facpl2Package.FUNCTION_DECLARATION__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<TypeLiteral> getArgs() {
		if (args == null) {
			args = new EDataTypeEList<TypeLiteral>(TypeLiteral.class, this, Facpl2Package.FUNCTION_DECLARATION__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Facpl2Package.FUNCTION_DECLARATION__TYPE:
			return getType();
		case Facpl2Package.FUNCTION_DECLARATION__NAME:
			return getName();
		case Facpl2Package.FUNCTION_DECLARATION__ARGS:
			return getArgs();
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
		case Facpl2Package.FUNCTION_DECLARATION__TYPE:
			setType((TypeLiteral) newValue);
			return;
		case Facpl2Package.FUNCTION_DECLARATION__NAME:
			setName((String) newValue);
			return;
		case Facpl2Package.FUNCTION_DECLARATION__ARGS:
			getArgs().clear();
			getArgs().addAll((Collection<? extends TypeLiteral>) newValue);
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
		case Facpl2Package.FUNCTION_DECLARATION__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case Facpl2Package.FUNCTION_DECLARATION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case Facpl2Package.FUNCTION_DECLARATION__ARGS:
			getArgs().clear();
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
		case Facpl2Package.FUNCTION_DECLARATION__TYPE:
			return type != TYPE_EDEFAULT;
		case Facpl2Package.FUNCTION_DECLARATION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case Facpl2Package.FUNCTION_DECLARATION__ARGS:
			return args != null && !args.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(", name: ");
		result.append(name);
		result.append(", args: ");
		result.append(args);
		result.append(')');
		return result.toString();
	}

} // FunctionDeclarationImpl
