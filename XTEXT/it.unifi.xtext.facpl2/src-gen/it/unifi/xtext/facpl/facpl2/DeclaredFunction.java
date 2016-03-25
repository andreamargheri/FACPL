/**
 */
package it.unifi.xtext.facpl.facpl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declared Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.DeclaredFunction#getFunctionId <em>Function Id</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.DeclaredFunction#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getDeclaredFunction()
 * @model
 * @generated
 */
public interface DeclaredFunction extends Expression
{
  /**
   * Returns the value of the '<em><b>Function Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Id</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Id</em>' reference.
   * @see #setFunctionId(FunctionDeclaration)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getDeclaredFunction_FunctionId()
   * @model
   * @generated
   */
  FunctionDeclaration getFunctionId();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.DeclaredFunction#getFunctionId <em>Function Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Id</em>' reference.
   * @see #getFunctionId()
   * @generated
   */
  void setFunctionId(FunctionDeclaration value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link it.unifi.xtext.facpl.facpl2.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getDeclaredFunction_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // DeclaredFunction
