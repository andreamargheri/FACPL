/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Main Facpl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getExtIndet <em>Ext Indet</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getSimulateXACML <em>Simulate XACML</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getGenPackage <em>Gen Package</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getRefRequest <em>Ref Request</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getPaf <em>Paf</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getMainFacpl()
 * @model
 * @generated
 */
public interface MainFacpl extends EObject
{
  /**
   * Returns the value of the '<em><b>Ext Indet</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ext Indet</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ext Indet</em>' containment reference.
   * @see #setExtIndet(BooleanLiteral)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getMainFacpl_ExtIndet()
   * @model containment="true"
   * @generated
   */
  BooleanLiteral getExtIndet();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getExtIndet <em>Ext Indet</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ext Indet</em>' containment reference.
   * @see #getExtIndet()
   * @generated
   */
  void setExtIndet(BooleanLiteral value);

  /**
   * Returns the value of the '<em><b>Simulate XACML</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Simulate XACML</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Simulate XACML</em>' containment reference.
   * @see #setSimulateXACML(BooleanLiteral)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getMainFacpl_SimulateXACML()
   * @model containment="true"
   * @generated
   */
  BooleanLiteral getSimulateXACML();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getSimulateXACML <em>Simulate XACML</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Simulate XACML</em>' containment reference.
   * @see #getSimulateXACML()
   * @generated
   */
  void setSimulateXACML(BooleanLiteral value);

  /**
   * Returns the value of the '<em><b>Gen Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Gen Package</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gen Package</em>' attribute.
   * @see #setGenPackage(String)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getMainFacpl_GenPackage()
   * @model
   * @generated
   */
  String getGenPackage();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getGenPackage <em>Gen Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gen Package</em>' attribute.
   * @see #getGenPackage()
   * @generated
   */
  void setGenPackage(String value);

  /**
   * Returns the value of the '<em><b>Ref Request</b></em>' reference list.
   * The list contents are of type {@link it.unifi.xtext.facpl.facpl2.Request}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Request</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Request</em>' reference list.
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getMainFacpl_RefRequest()
   * @model
   * @generated
   */
  EList<Request> getRefRequest();

  /**
   * Returns the value of the '<em><b>Paf</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Paf</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Paf</em>' containment reference.
   * @see #setPaf(PAF)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getMainFacpl_Paf()
   * @model containment="true"
   * @generated
   */
  PAF getPaf();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.MainFacpl#getPaf <em>Paf</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Paf</em>' containment reference.
   * @see #getPaf()
   * @generated
   */
  void setPaf(PAF value);

} // MainFacpl
