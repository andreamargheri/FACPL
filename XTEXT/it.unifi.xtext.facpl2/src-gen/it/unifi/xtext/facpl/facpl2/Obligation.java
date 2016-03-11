/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Obligation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Obligation#getEvaluetedOn
 * <em>Evalueted On</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Obligation#getTypeObl
 * <em>Type Obl</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Obligation#getPepAction
 * <em>Pep Action</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Obligation#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getObligation()
 * @model
 * @generated
 */
public interface Obligation extends EObject {
	/**
	 * Returns the value of the '<em><b>Evalueted On</b></em>' attribute. The
	 * literals are from the enumeration
	 * {@link it.unifi.xtext.facpl.facpl2.Effect}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evalueted On</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Evalueted On</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.Effect
	 * @see #setEvaluetedOn(Effect)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getObligation_EvaluetedOn()
	 * @model
	 * @generated
	 */
	Effect getEvaluetedOn();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.Obligation#getEvaluetedOn
	 * <em>Evalueted On</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Evalueted On</em>' attribute.
	 * @see it.unifi.xtext.facpl.facpl2.Effect
	 * @see #getEvaluetedOn()
	 * @generated
	 */
	void setEvaluetedOn(Effect value);

	/**
	 * Returns the value of the '<em><b>Type Obl</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Obl</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type Obl</em>' attribute.
	 * @see #setTypeObl(String)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getObligation_TypeObl()
	 * @model
	 * @generated
	 */
	String getTypeObl();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.Obligation#getTypeObl
	 * <em>Type Obl</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type Obl</em>' attribute.
	 * @see #getTypeObl()
	 * @generated
	 */
	void setTypeObl(String value);

	/**
	 * Returns the value of the '<em><b>Pep Action</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pep Action</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pep Action</em>' attribute.
	 * @see #setPepAction(String)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getObligation_PepAction()
	 * @model
	 * @generated
	 */
	String getPepAction();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.Obligation#getPepAction
	 * <em>Pep Action</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Pep Action</em>' attribute.
	 * @see #getPepAction()
	 * @generated
	 */
	void setPepAction(String value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.Expression}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expr</em>' containment reference list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getObligation_Expr()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpr();

} // Obligation
