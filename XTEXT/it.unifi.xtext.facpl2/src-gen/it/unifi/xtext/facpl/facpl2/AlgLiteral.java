/**
 */
package it.unifi.xtext.facpl.facpl2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Alg Literal</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getAlgLiteral()
 * @model
 * @generated
 */
public enum AlgLiteral implements Enumerator
{
  /**
   * The '<em><b>ONLY ONE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ONLY_ONE_VALUE
   * @generated
   * @ordered
   */
  ONLY_ONE(0, "ONLY_ONE", "only-one-applicable"),

  /**
   * The '<em><b>DENY OVER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DENY_OVER_VALUE
   * @generated
   * @ordered
   */
  DENY_OVER(1, "DENY_OVER", "deny-overrides"),

  /**
   * The '<em><b>PERMIT OVER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PERMIT_OVER_VALUE
   * @generated
   * @ordered
   */
  PERMIT_OVER(2, "PERMIT_OVER", "permit-overrides"),

  /**
   * The '<em><b>FIRST</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FIRST_VALUE
   * @generated
   * @ordered
   */
  FIRST(3, "FIRST", "first-applicable"),

  /**
   * The '<em><b>DENY UNLESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DENY_UNLESS_VALUE
   * @generated
   * @ordered
   */
  DENY_UNLESS(4, "DENY_UNLESS", "deny-unless-permit"),

  /**
   * The '<em><b>PERMIT UNLESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PERMIT_UNLESS_VALUE
   * @generated
   * @ordered
   */
  PERMIT_UNLESS(5, "PERMIT_UNLESS", "permit-unless-deny"),

  /**
   * The '<em><b>WEAK CONS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WEAK_CONS_VALUE
   * @generated
   * @ordered
   */
  WEAK_CONS(6, "WEAK_CONS", "weak-consensus"),

  /**
   * The '<em><b>STRONG CONS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STRONG_CONS_VALUE
   * @generated
   * @ordered
   */
  STRONG_CONS(7, "STRONG_CONS", "strong-consensus"),

  /**
   * The '<em><b>CUSTOM ALG</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CUSTOM_ALG_VALUE
   * @generated
   * @ordered
   */
  CUSTOM_ALG(8, "CUSTOM_ALG", "custom-algorithm");

  /**
   * The '<em><b>ONLY ONE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ONLY ONE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ONLY_ONE
   * @model literal="only-one-applicable"
   * @generated
   * @ordered
   */
  public static final int ONLY_ONE_VALUE = 0;

  /**
   * The '<em><b>DENY OVER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DENY OVER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DENY_OVER
   * @model literal="deny-overrides"
   * @generated
   * @ordered
   */
  public static final int DENY_OVER_VALUE = 1;

  /**
   * The '<em><b>PERMIT OVER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PERMIT OVER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PERMIT_OVER
   * @model literal="permit-overrides"
   * @generated
   * @ordered
   */
  public static final int PERMIT_OVER_VALUE = 2;

  /**
   * The '<em><b>FIRST</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FIRST</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FIRST
   * @model literal="first-applicable"
   * @generated
   * @ordered
   */
  public static final int FIRST_VALUE = 3;

  /**
   * The '<em><b>DENY UNLESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DENY UNLESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DENY_UNLESS
   * @model literal="deny-unless-permit"
   * @generated
   * @ordered
   */
  public static final int DENY_UNLESS_VALUE = 4;

  /**
   * The '<em><b>PERMIT UNLESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PERMIT UNLESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PERMIT_UNLESS
   * @model literal="permit-unless-deny"
   * @generated
   * @ordered
   */
  public static final int PERMIT_UNLESS_VALUE = 5;

  /**
   * The '<em><b>WEAK CONS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WEAK CONS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WEAK_CONS
   * @model literal="weak-consensus"
   * @generated
   * @ordered
   */
  public static final int WEAK_CONS_VALUE = 6;

  /**
   * The '<em><b>STRONG CONS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STRONG CONS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STRONG_CONS
   * @model literal="strong-consensus"
   * @generated
   * @ordered
   */
  public static final int STRONG_CONS_VALUE = 7;

  /**
   * The '<em><b>CUSTOM ALG</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CUSTOM ALG</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CUSTOM_ALG
   * @model literal="custom-algorithm"
   * @generated
   * @ordered
   */
  public static final int CUSTOM_ALG_VALUE = 8;

  /**
   * An array of all the '<em><b>Alg Literal</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AlgLiteral[] VALUES_ARRAY =
    new AlgLiteral[]
    {
      ONLY_ONE,
      DENY_OVER,
      PERMIT_OVER,
      FIRST,
      DENY_UNLESS,
      PERMIT_UNLESS,
      WEAK_CONS,
      STRONG_CONS,
      CUSTOM_ALG,
    };

  /**
   * A public read-only list of all the '<em><b>Alg Literal</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AlgLiteral> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Alg Literal</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AlgLiteral get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AlgLiteral result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Alg Literal</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AlgLiteral getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AlgLiteral result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Alg Literal</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AlgLiteral get(int value)
  {
    switch (value)
    {
      case ONLY_ONE_VALUE: return ONLY_ONE;
      case DENY_OVER_VALUE: return DENY_OVER;
      case PERMIT_OVER_VALUE: return PERMIT_OVER;
      case FIRST_VALUE: return FIRST;
      case DENY_UNLESS_VALUE: return DENY_UNLESS;
      case PERMIT_UNLESS_VALUE: return PERMIT_UNLESS;
      case WEAK_CONS_VALUE: return WEAK_CONS;
      case STRONG_CONS_VALUE: return STRONG_CONS;
      case CUSTOM_ALG_VALUE: return CUSTOM_ALG;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private AlgLiteral(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //AlgLiteral
