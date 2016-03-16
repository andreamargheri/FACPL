/**
 */
package it.unifi.xtext.facpl.facpl2;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Boolean Literal</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.BooleanLiteral#isValue <em>Value</em>}
 * </li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getBooleanLiteral()
 * @model
 * @generated
 */
public interface BooleanLiteral extends Expression {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(boolean)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getBooleanLiteral_Value()
	 * @model
	 * @generated
	 */
	boolean isValue();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.BooleanLiteral#isValue <em>Value</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Value</em>' attribute.
	 * @see #isValue()
	 * @generated
	 */
	void setValue(boolean value);

} // BooleanLiteral