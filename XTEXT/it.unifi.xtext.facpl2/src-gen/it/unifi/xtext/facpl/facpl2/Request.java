/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.Request#getStub <em>Stub</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.Request#getName <em>Name</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.Request#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getRequest()
 * @model
 * @generated
 */
public interface Request extends EObject
{
  /**
   * Returns the value of the '<em><b>Stub</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stub</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stub</em>' attribute.
   * @see #setStub(String)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getRequest_Stub()
   * @model
   * @generated
   */
  String getStub();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Request#getStub <em>Stub</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stub</em>' attribute.
   * @see #getStub()
   * @generated
   */
  void setStub(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getRequest_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Request#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link it.unifi.xtext.facpl.facpl2.AttributeReq}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getRequest_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<AttributeReq> getAttributes();

} // Request
