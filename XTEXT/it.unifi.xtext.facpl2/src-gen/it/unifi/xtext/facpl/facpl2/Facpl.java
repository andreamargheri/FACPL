/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Facpl</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Facpl#getImportEl <em>Import El</em>}
 * </li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Facpl#getDeclarations
 * <em>Declarations</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Facpl#getPolicies <em>Policies</em>}
 * </li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Facpl#getRequests <em>Requests</em>}
 * </li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.Facpl#getMain <em>Main</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacpl()
 * @model
 * @generated
 */
public interface Facpl extends EObject {
	/**
	 * Returns the value of the '<em><b>Import El</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.Import}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import El</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Import El</em>' containment reference list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacpl_ImportEl()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImportEl();

	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.FunctionDeclaration}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarations</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Declarations</em>' containment reference
	 *         list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacpl_Declarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionDeclaration> getDeclarations();

	/**
	 * Returns the value of the '<em><b>Policies</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.PolicySet}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Policies</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Policies</em>' containment reference list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacpl_Policies()
	 * @model containment="true"
	 * @generated
	 */
	EList<PolicySet> getPolicies();

	/**
	 * Returns the value of the '<em><b>Requests</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link it.unifi.xtext.facpl.facpl2.Request}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requests</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Requests</em>' containment reference list.
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacpl_Requests()
	 * @model containment="true"
	 * @generated
	 */
	EList<Request> getRequests();

	/**
	 * Returns the value of the '<em><b>Main</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Main</em>' containment reference.
	 * @see #setMain(MainFacpl)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFacpl_Main()
	 * @model containment="true"
	 * @generated
	 */
	MainFacpl getMain();

	/**
	 * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Facpl#getMain
	 * <em>Main</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Main</em>' containment reference.
	 * @see #getMain()
	 * @generated
	 */
	void setMain(MainFacpl value);

} // Facpl
