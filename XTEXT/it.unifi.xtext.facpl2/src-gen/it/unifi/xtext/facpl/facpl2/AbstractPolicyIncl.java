/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Policy Incl</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl#getNewPolicy
 * <em>New Policy</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl#getRefPol
 * <em>Ref Pol</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAbstractPolicyIncl()
 * @model
 * @generated
 */
public interface AbstractPolicyIncl extends EObject {
	/**
	 * Returns the value of the '<em><b>New Policy</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Policy</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>New Policy</em>' containment reference.
	 * @see #setNewPolicy(FacplPolicy)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAbstractPolicyIncl_NewPolicy()
	 * @model containment="true"
	 * @generated
	 */
	FacplPolicy getNewPolicy();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl#getNewPolicy
	 * <em>New Policy</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>New Policy</em>' containment
	 *            reference.
	 * @see #getNewPolicy()
	 * @generated
	 */
	void setNewPolicy(FacplPolicy value);

	/**
	 * Returns the value of the '<em><b>Ref Pol</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Pol</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ref Pol</em>' reference.
	 * @see #setRefPol(PolicySet)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAbstractPolicyIncl_RefPol()
	 * @model
	 * @generated
	 */
	PolicySet getRefPol();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl#getRefPol
	 * <em>Ref Pol</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Ref Pol</em>' reference.
	 * @see #getRefPol()
	 * @generated
	 */
	void setRefPol(PolicySet value);

} // AbstractPolicyIncl
