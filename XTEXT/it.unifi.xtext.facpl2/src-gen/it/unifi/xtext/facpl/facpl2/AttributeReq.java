/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Req</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.AttributeReq#getName <em>Name</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.AttributeReq#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAttributeReq()
 * @model
 * @generated
 */
public interface AttributeReq extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(AttributeName)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAttributeReq_Name()
   * @model containment="true"
   * @generated
   */
  AttributeName getName();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.AttributeReq#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(AttributeName value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference list.
   * The list contents are of type {@link it.unifi.xtext.facpl.facpl2.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference list.
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAttributeReq_Value()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getValue();

} // AttributeReq
