/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Set</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Set#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getSet()
 * @model
 * @generated
 */
public interface Set extends Expression {
	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.Expression}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getSet_Args()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArgs();

} // Set
