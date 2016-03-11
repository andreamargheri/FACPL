/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Facpl Policy</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.FacplPolicy#getName <em>Name</em>}
 * </li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.FacplPolicy#getTarget <em>Target</em>}
 * </li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.FacplPolicy#getObl <em>Obl</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacplPolicy()
 * @model
 * @generated
 */
public interface FacplPolicy extends EObject {
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
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacplPolicy_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.FacplPolicy#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacplPolicy_Target()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.FacplPolicy#getTarget <em>Target</em>}
	 * ' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

	/**
	 * Returns the value of the '<em><b>Obl</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.Obligation}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obl</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Obl</em>' containment reference list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacplPolicy_Obl()
	 * @model containment="true"
	 * @generated
	 */
	EList<Obligation> getObl();

} // FacplPolicy
