/**
 */
package it.unifi.xtext.facpl.facpl2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.NotExpression#getArg <em>Arg</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getNotExpression()
 * @model
 * @generated
 */
public interface NotExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg</em>' containment reference.
   * @see #setArg(Expression)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getNotExpression_Arg()
   * @model containment="true"
   * @generated
   */
  Expression getArg();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.NotExpression#getArg <em>Arg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg</em>' containment reference.
   * @see #getArg()
   * @generated
   */
  void setArg(Expression value);

} // NotExpression
