/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>PDP</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.PDP#getPdpAlg <em>Pdp Alg</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.PDP#getPolSet <em>Pol Set</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPDP()
 * @model
 * @generated
 */
public interface PDP extends EObject {
	/**
	 * Returns the value of the '<em><b>Pdp Alg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pdp Alg</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pdp Alg</em>' containment reference.
	 * @see #setPdpAlg(Alg)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPDP_PdpAlg()
	 * @model containment="true"
	 * @generated
	 */
	Alg getPdpAlg();

	/**
	 * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.PDP#getPdpAlg
	 * <em>Pdp Alg</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Pdp Alg</em>' containment reference.
	 * @see #getPdpAlg()
	 * @generated
	 */
	void setPdpAlg(Alg value);

	/**
	 * Returns the value of the '<em><b>Pol Set</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pol Set</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pol Set</em>' containment reference list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPDP_PolSet()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractPolicyIncl> getPolSet();

} // PDP
