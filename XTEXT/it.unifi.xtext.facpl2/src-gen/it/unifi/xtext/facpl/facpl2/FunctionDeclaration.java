/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Function Declaration</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getType
 * <em>Type</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getName
 * <em>Name</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getArgs
 * <em>Args</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunctionDeclaration()
 * @model
 * @generated
 */
public interface FunctionDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. The literals
	 * are from the enumeration {@link it.unifi.xtext.facpl.facpl2.TypeLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.TypeLiteral
	 * @see #setType(TypeLiteral)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunctionDeclaration_Type()
	 * @model
	 * @generated
	 */
	TypeLiteral getType();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getType
	 * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.TypeLiteral
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeLiteral value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunctionDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' attribute list. The list
	 * contents are of type {@link it.unifi.xtext.facpl.facpl2.TypeLiteral}. The
	 * literals are from the enumeration
	 * {@link it.unifi.xtext.facpl.facpl2.TypeLiteral}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Args</em>' attribute list.
	 * @see it.unifi.xtext.facpl.facpl2.TypeLiteral
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunctionDeclaration_Args()
	 * @model unique="false"
	 * @generated
	 */
	EList<TypeLiteral> getArgs();

} // FunctionDeclaration
