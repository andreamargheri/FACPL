/**
 */
package it.unifi.xtext.facpl.facpl2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.Function#getFunctionId <em>Function Id</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.Function#getArg1 <em>Arg1</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.Function#getAtt1 <em>Att1</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.Function#getArg2 <em>Arg2</em>}</li>
 *   <li>{@link it.unifi.xtext.facpl.facpl2.Function#getAtt2 <em>Att2</em>}</li>
 * </ul>
 *
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunction()
 * @model
 * @generated
 */
public interface Function extends Expression
{
  /**
   * Returns the value of the '<em><b>Function Id</b></em>' attribute.
   * The literals are from the enumeration {@link it.unifi.xtext.facpl.facpl2.funID}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Id</em>' attribute.
   * @see it.unifi.xtext.facpl.facpl2.funID
   * @see #setFunctionId(funID)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunction_FunctionId()
   * @model
   * @generated
   */
  funID getFunctionId();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Function#getFunctionId <em>Function Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Id</em>' attribute.
   * @see it.unifi.xtext.facpl.facpl2.funID
   * @see #getFunctionId()
   * @generated
   */
  void setFunctionId(funID value);

  /**
   * Returns the value of the '<em><b>Arg1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg1</em>' containment reference.
   * @see #setArg1(Expression)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunction_Arg1()
   * @model containment="true"
   * @generated
   */
  Expression getArg1();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Function#getArg1 <em>Arg1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg1</em>' containment reference.
   * @see #getArg1()
   * @generated
   */
  void setArg1(Expression value);

  /**
   * Returns the value of the '<em><b>Att1</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Att1</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Att1</em>' reference.
   * @see #setAtt1(Attribute)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunction_Att1()
   * @model
   * @generated
   */
  Attribute getAtt1();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Function#getAtt1 <em>Att1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Att1</em>' reference.
   * @see #getAtt1()
   * @generated
   */
  void setAtt1(Attribute value);

  /**
   * Returns the value of the '<em><b>Arg2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg2</em>' containment reference.
   * @see #setArg2(Expression)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunction_Arg2()
   * @model containment="true"
   * @generated
   */
  Expression getArg2();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Function#getArg2 <em>Arg2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg2</em>' containment reference.
   * @see #getArg2()
   * @generated
   */
  void setArg2(Expression value);

  /**
   * Returns the value of the '<em><b>Att2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Att2</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Att2</em>' reference.
   * @see #setAtt2(Attribute)
   * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getFunction_Att2()
   * @model
   * @generated
   */
  Attribute getAtt2();

  /**
   * Sets the value of the '{@link it.unifi.xtext.facpl.facpl2.Function#getAtt2 <em>Att2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Att2</em>' reference.
   * @see #getAtt2()
   * @generated
   */
  void setAtt2(Attribute value);

} // Function
