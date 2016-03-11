/**
 */
package it.unifi.xtext.facpl.facpl2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>fun ID</b></em>', and utility methods for working with them. <!--
 * end-user-doc -->
 * 
 * @see it.unifi.xtext.facpl.facpl2.Facpl2Package#getfunID()
 * @model
 * @generated
 */
public enum funID implements Enumerator {
	/**
	 * The '<em><b>EQUAL</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL(0, "EQUAL", "equal"),

	/**
	 * The '<em><b>NEQUAL</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #NEQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	NEQUAL(1, "N_EQUAL", "not-equal"),

	/**
	 * The '<em><b>LESS</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #LESS_VALUE
	 * @generated
	 * @ordered
	 */
	LESS(2, "LESS", "less-than"),

	/**
	 * The '<em><b>LESS EQ</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #LESS_EQ_VALUE
	 * @generated
	 * @ordered
	 */
	LESS_EQ(3, "LESS_EQ", "less-than-or-equal"),

	/**
	 * The '<em><b>GREATER</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #GREATER_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER(4, "GREATER", "greater-than"),

	/**
	 * The '<em><b>GREATER EQ</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #GREATER_EQ_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_EQ(5, "GREATER_EQ", "greater-than-or-equal"),

	/**
	 * The '<em><b>IN</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #IN_VALUE
	 * @generated
	 * @ordered
	 */
	IN(6, "IN", "in"),

	/**
	 * The '<em><b>ADD</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #ADD_VALUE
	 * @generated
	 * @ordered
	 */
	ADD(7, "ADD", "addition"),

	/**
	 * The '<em><b>SUBTRACT</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SUBTRACT_VALUE
	 * @generated
	 * @ordered
	 */
	SUBTRACT(8, "SUBTRACT", "subtract"),

	/**
	 * The '<em><b>DIVIDE</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #DIVIDE_VALUE
	 * @generated
	 * @ordered
	 */
	DIVIDE(9, "DIVIDE", "divide"),

	/**
	 * The '<em><b>MULTIPLY</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #MULTIPLY_VALUE
	 * @generated
	 * @ordered
	 */
	MULTIPLY(10, "MULTIPLY", "multiply");

	/**
	 * The '<em><b>EQUAL</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #EQUAL
	 * @model literal="equal"
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_VALUE = 0;

	/**
	 * The '<em><b>NEQUAL</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #NEQUAL
	 * @model name="N_EQUAL" literal="not-equal"
	 * @generated
	 * @ordered
	 */
	public static final int NEQUAL_VALUE = 1;

	/**
	 * The '<em><b>LESS</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #LESS
	 * @model literal="less-than"
	 * @generated
	 * @ordered
	 */
	public static final int LESS_VALUE = 2;

	/**
	 * The '<em><b>LESS EQ</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LESS EQ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #LESS_EQ
	 * @model literal="less-than-or-equal"
	 * @generated
	 * @ordered
	 */
	public static final int LESS_EQ_VALUE = 3;

	/**
	 * The '<em><b>GREATER</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #GREATER
	 * @model literal="greater-than"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_VALUE = 4;

	/**
	 * The '<em><b>GREATER EQ</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER EQ</b></em>' literal object isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #GREATER_EQ
	 * @model literal="greater-than-or-equal"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_EQ_VALUE = 5;

	/**
	 * The '<em><b>IN</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IN</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #IN
	 * @model literal="in"
	 * @generated
	 * @ordered
	 */
	public static final int IN_VALUE = 6;

	/**
	 * The '<em><b>ADD</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADD</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ADD
	 * @model literal="addition"
	 * @generated
	 * @ordered
	 */
	public static final int ADD_VALUE = 7;

	/**
	 * The '<em><b>SUBTRACT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUBTRACT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SUBTRACT
	 * @model literal="subtract"
	 * @generated
	 * @ordered
	 */
	public static final int SUBTRACT_VALUE = 8;

	/**
	 * The '<em><b>DIVIDE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIVIDE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DIVIDE
	 * @model literal="divide"
	 * @generated
	 * @ordered
	 */
	public static final int DIVIDE_VALUE = 9;

	/**
	 * The '<em><b>MULTIPLY</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MULTIPLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #MULTIPLY
	 * @model literal="multiply"
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLY_VALUE = 10;

	/**
	 * An array of all the '<em><b>fun ID</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final funID[] VALUES_ARRAY = new funID[] { EQUAL, NEQUAL, LESS, LESS_EQ, GREATER, GREATER_EQ, IN,
			ADD, SUBTRACT, DIVIDE, MULTIPLY, };

	/**
	 * A public read-only list of all the '<em><b>fun ID</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<funID> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>fun ID</b></em>' literal with the specified literal
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param literal
	 *            the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static funID get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			funID result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>fun ID</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param name
	 *            the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static funID getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			funID result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>fun ID</b></em>' literal with the specified integer
	 * value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static funID get(int value) {
		switch (value) {
		case EQUAL_VALUE:
			return EQUAL;
		case NEQUAL_VALUE:
			return NEQUAL;
		case LESS_VALUE:
			return LESS;
		case LESS_EQ_VALUE:
			return LESS_EQ;
		case GREATER_VALUE:
			return GREATER;
		case GREATER_EQ_VALUE:
			return GREATER_EQ;
		case IN_VALUE:
			return IN;
		case ADD_VALUE:
			return ADD;
		case SUBTRACT_VALUE:
			return SUBTRACT;
		case DIVIDE_VALUE:
			return DIVIDE;
		case MULTIPLY_VALUE:
			return MULTIPLY;
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
	private funID(int value, String name, String literal) {
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

} // funID
