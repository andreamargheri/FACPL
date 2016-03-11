/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Policy Set</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.PolicySet#getPolSetAlg
 * <em>Pol Set Alg</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.PolicySet#getPolicies
 * <em>Policies</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPolicySet()
 * @model
 * @generated
 */
public interface PolicySet extends FacplPolicy {
	/**
	 * Returns the value of the '<em><b>Pol Set Alg</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pol Set Alg</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pol Set Alg</em>' containment reference.
	 * @see #setPolSetAlg(Alg)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPolicySet_PolSetAlg()
	 * @model containment="true"
	 * @generated
	 */
	Alg getPolSetAlg();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.PolicySet#getPolSetAlg
	 * <em>Pol Set Alg</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Pol Set Alg</em>' containment
	 *            reference.
	 * @see #getPolSetAlg()
	 * @generated
	 */
	void setPolSetAlg(Alg value);

	/**
	 * Returns the value of the '<em><b>Policies</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policies</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Policies</em>' containment reference list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPolicySet_Policies()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractPolicyIncl> getPolicies();

} // PolicySet
