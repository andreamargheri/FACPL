/**
 */
package it.unifi.xtext.facpl.facpl2;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Rule</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Rule#getEffect <em>Effect</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getRule()
 * @model
 * @generated
 */
public interface Rule extends FacplPolicy {
	/**
	 * Returns the value of the '<em><b>Effect</b></em>' attribute. The literals
	 * are from the enumeration {@link it.unifi.xtext.facpl.facpl2.Effect}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Effect</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.Effect
	 * @see #setEffect(Effect)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getRule_Effect()
	 * @model
	 * @generated
	 */
	Effect getEffect();

	/**
	 * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Rule#getEffect
	 * <em>Effect</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Effect</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.Effect
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(Effect value);

} // Rule
