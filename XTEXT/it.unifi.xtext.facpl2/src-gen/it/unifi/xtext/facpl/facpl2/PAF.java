/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.PAF#getStatus <em>Status</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.PAF#getPep <em>Pep</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.PAF#getPdp <em>Pdp</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPAF()
 * @model
 * @generated
 */
public interface PAF extends EObject
{
  /**
   * Returns the value of the '<em><b>Status</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status</em>' containment reference.
   * @see #setStatus(STATUS)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPAF_Status()
   * @model containment="true"
   * @generated
   */
  STATUS getStatus();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.PAF#getStatus <em>Status</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' containment reference.
   * @see #getStatus()
   * @generated
   */
  void setStatus(STATUS value);

  /**
   * Returns the value of the '<em><b>Pep</b></em>' attribute.
   * The literals are from the enumeration {@link it.unifi.xtext.facpl.facpl2.PEPAlg}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pep</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pep</em>' attribute.
   * @see it.unifi.xtext.facpl.facpl2.PEPAlg
   * @see #setPep(PEPAlg)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPAF_Pep()
   * @model
   * @generated
   */
  PEPAlg getPep();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.PAF#getPep <em>Pep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pep</em>' attribute.
   * @see it.unifi.xtext.facpl.facpl2.PEPAlg
   * @see #getPep()
   * @generated
   */
  void setPep(PEPAlg value);

  /**
   * Returns the value of the '<em><b>Pdp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pdp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pdp</em>' containment reference.
   * @see #setPdp(PDP)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getPAF_Pdp()
   * @model containment="true"
   * @generated
   */
  PDP getPdp();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.PAF#getPdp <em>Pdp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pdp</em>' containment reference.
   * @see #getPdp()
   * @generated
   */
  void setPdp(PDP value);

} // PAF
