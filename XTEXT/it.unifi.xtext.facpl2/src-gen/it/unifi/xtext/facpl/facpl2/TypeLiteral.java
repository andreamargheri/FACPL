/**
 */
package it.unifi.xtext.facpl.facpl2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Type Literal</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getTypeLiteral()
 * @model
 * @generated
 */
public enum TypeLiteral implements Enumerator {
	/**
	 * The '<em><b>Int</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #INT_VALUE
	 * @generated
	 * @ordered
	 */
	INT(0, "Int", "Int"),

	/**
	 * The '<em><b>Double</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE(1, "Double", "Double"),

	/**
	 * The '<em><b>Bool</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #BOOL_VALUE
	 * @generated
	 * @ordered
	 */
	BOOL(2, "Bool", "Bool"),

	/**
	 * The '<em><b>String</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #STRING_VALUE
	 * @generated
	 * @ordered
	 */
	STRING(3, "String", "String"),

	/**
	 * The '<em><b>Date Time</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #DATE_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	DATE_TIME(4, "DateTime", "DateTime"),

	/**
	 * The '<em><b>Set Int</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_INT_VALUE
	 * @generated
	 * @ordered
	 */
	SET_INT(5, "SetInt", "Set<Int>"),

	/**
	 * The '<em><b>Set Double</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	SET_DOUBLE(6, "SetDouble", "Set<Double>"),

	/**
	 * The '<em><b>Set Bool</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_BOOL_VALUE
	 * @generated
	 * @ordered
	 */
	SET_BOOL(7, "SetBool", "Set<Bool>"),

	/**
	 * The '<em><b>Set String</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_STRING_VALUE
	 * @generated
	 * @ordered
	 */
	SET_STRING(8, "SetString", "Set<String>"),

	/**
	 * The '<em><b>Set Date Time</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #SET_DATE_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	SET_DATE_TIME(9, "SetDateTime", "Set<DateTime>");

	/**
	 * The '<em><b>Int</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INT
	 * @model name="Int"
	 * @generated
	 * @ordered
	 */
	public static final int INT_VALUE = 0;

	/**
	 * The '<em><b>Double</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Double</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DOUBLE
	 * @model name="Double"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_VALUE = 1;

	/**
	 * The '<em><b>Bool</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bool</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BOOL
	 * @model name="Bool"
	 * @generated
	 * @ordered
	 */
	public static final int BOOL_VALUE = 2;

	/**
	 * The '<em><b>String</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>String</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #STRING
	 * @model name="String"
	 * @generated
	 * @ordered
	 */
	public static final int STRING_VALUE = 3;

	/**
	 * The '<em><b>Date Time</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Date Time</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DATE_TIME
	 * @model name="DateTime"
	 * @generated
	 * @ordered
	 */
	public static final int DATE_TIME_VALUE = 4;

	/**
	 * The '<em><b>Set Int</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set Int</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_INT
	 * @model name="SetInt" literal="Set<Int>"
	 * @generated
	 * @ordered
	 */
	public static final int SET_INT_VALUE = 5;

	/**
	 * The '<em><b>Set Double</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set Double</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_DOUBLE
	 * @model name="SetDouble" literal="Set<Double>"
	 * @generated
	 * @ordered
	 */
	public static final int SET_DOUBLE_VALUE = 6;

	/**
	 * The '<em><b>Set Bool</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set Bool</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_BOOL
	 * @model name="SetBool" literal="Set<Bool>"
	 * @generated
	 * @ordered
	 */
	public static final int SET_BOOL_VALUE = 7;

	/**
	 * The '<em><b>Set String</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set String</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_STRING
	 * @model name="SetString" literal="Set<String>"
	 * @generated
	 * @ordered
	 */
	public static final int SET_STRING_VALUE = 8;

	/**
	 * The '<em><b>Set Date Time</b></em>' literal value. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of '<em><b>Set Date Time</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SET_DATE_TIME
	 * @model name="SetDateTime" literal="Set<DateTime>"
	 * @generated
	 * @ordered
	 */
	public static final int SET_DATE_TIME_VALUE = 9;

	/**
	 * An array of all the '<em><b>Type Literal</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final TypeLiteral[] VALUES_ARRAY = new TypeLiteral[] { INT, DOUBLE, BOOL, STRING, DATE_TIME, SET_INT,
			SET_DOUBLE, SET_BOOL, SET_STRING, SET_DATE_TIME, };

	/**
	 * A public read-only list of all the '<em><b>Type Literal</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<TypeLiteral> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type Literal</b></em>' literal with the specified
	 * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param literal
	 *            the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeLiteral get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeLiteral result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Literal</b></em>' literal with the specified
	 * name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param name
	 *            the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeLiteral getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeLiteral result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Literal</b></em>' literal with the specified
	 * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeLiteral get(int value) {
		switch (value) {
		case INT_VALUE:
			return INT;
		case DOUBLE_VALUE:
			return DOUBLE;
		case BOOL_VALUE:
			return BOOL;
		case STRING_VALUE:
			return STRING;
		case DATE_TIME_VALUE:
			return DATE_TIME;
		case SET_INT_VALUE:
			return SET_INT;
		case SET_DOUBLE_VALUE:
			return SET_DOUBLE;
		case SET_BOOL_VALUE:
			return SET_BOOL;
		case SET_STRING_VALUE:
			return SET_STRING;
		case SET_DATE_TIME_VALUE:
			return SET_DATE_TIME;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private TypeLiteral(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string
	 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // TypeLiteral
