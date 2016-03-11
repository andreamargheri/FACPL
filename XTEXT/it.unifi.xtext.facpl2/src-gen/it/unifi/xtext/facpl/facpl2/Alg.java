/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Alg</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Alg#getIdAlg <em>Id Alg</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Alg#getFStrategy <em>FStrategy</em>}
 * </li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAlg()
 * @model
 * @generated
 */
public interface Alg extends EObject {
	/**
	 * Returns the value of the '<em><b>Id Alg</b></em>' attribute. The literals
	 * are from the enumeration {@link it.unifi.xtext.facpl.facpl2.AlgLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Alg</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id Alg</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.AlgLiteral
	 * @see #setIdAlg(AlgLiteral)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAlg_IdAlg()
	 * @model
	 * @generated
	 */
	AlgLiteral getIdAlg();

	/**
	 * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Alg#getIdAlg
	 * <em>Id Alg</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id Alg</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.AlgLiteral
	 * @see #getIdAlg()
	 * @generated
	 */
	void setIdAlg(AlgLiteral value);

	/**
	 * Returns the value of the '<em><b>FStrategy</b></em>' attribute. The
	 * literals are from the enumeration
	 * {@link it.unifi.xtext.facpl.facpl2.FulfillmentStrategy}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FStrategy</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>FStrategy</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.FulfillmentStrategy
	 * @see #setFStrategy(FulfillmentStrategy)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAlg_FStrategy()
	 * @model
	 * @generated
	 */
	FulfillmentStrategy getFStrategy();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.Alg#getFStrategy <em>FStrategy</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>FStrategy</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.FulfillmentStrategy
	 * @see #getFStrategy()
	 * @generated
	 */
	void setFStrategy(FulfillmentStrategy value);

} // Alg
