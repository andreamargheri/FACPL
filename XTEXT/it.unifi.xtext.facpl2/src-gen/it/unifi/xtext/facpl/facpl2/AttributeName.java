/**
 */
package it.unifi.xtext.facpl.facpl2;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Attribute Name</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link it.unifi.xtext.facpl.facpl2.AttributeName#getCategory
 * <em>Category</em>}</li>
 * <li>{@link it.unifi.xtext.facpl.facpl2.AttributeName#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAttributeName()
 * @model
 * @generated
 */
public interface AttributeName extends Expression {
	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAttributeName_Category()
	 * @model
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.AttributeName#getCategory
	 * <em>Category</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAttributeName_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '
	 * {@link it.unifi.xtext.facpl.facpl2.AttributeName#getId <em>Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // AttributeName
