/**
 */
package org.eclipse.cmmn1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Multiplicity Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.cmmn1.Cmmn1Package#getMultiplicityEnum()
 * @model extendedMetaData="name='MultiplicityEnum'"
 * @generated
 */
public enum MultiplicityEnum implements Enumerator {
    /**
     * The '<em><b>Zero Or One</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ZERO_OR_ONE_VALUE
     * @generated
     * @ordered
     */
    ZERO_OR_ONE(0, "ZeroOrOne", "ZeroOrOne"),

    /**
     * The '<em><b>Zero Or More</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ZERO_OR_MORE_VALUE
     * @generated
     * @ordered
     */
    ZERO_OR_MORE(1, "ZeroOrMore", "ZeroOrMore"),

    /**
     * The '<em><b>Exactly One</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #EXACTLY_ONE_VALUE
     * @generated
     * @ordered
     */
    EXACTLY_ONE(2, "ExactlyOne", "ExactlyOne"),

    /**
     * The '<em><b>One Or More</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ONE_OR_MORE_VALUE
     * @generated
     * @ordered
     */
    ONE_OR_MORE(3, "OneOrMore", "OneOrMore"),

    /**
     * The '<em><b>Unspecified</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UNSPECIFIED_VALUE
     * @generated
     * @ordered
     */
    UNSPECIFIED(4, "Unspecified", "Unspecified"),

    /**
     * The '<em><b>Unknown</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UNKNOWN_VALUE
     * @generated
     * @ordered
     */
    UNKNOWN(5, "Unknown", "Unknown");

    /**
     * The '<em><b>Zero Or One</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Zero Or One</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ZERO_OR_ONE
     * @model name="ZeroOrOne"
     * @generated
     * @ordered
     */
    public static final int ZERO_OR_ONE_VALUE = 0;

    /**
     * The '<em><b>Zero Or More</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Zero Or More</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ZERO_OR_MORE
     * @model name="ZeroOrMore"
     * @generated
     * @ordered
     */
    public static final int ZERO_OR_MORE_VALUE = 1;

    /**
     * The '<em><b>Exactly One</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Exactly One</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #EXACTLY_ONE
     * @model name="ExactlyOne"
     * @generated
     * @ordered
     */
    public static final int EXACTLY_ONE_VALUE = 2;

    /**
     * The '<em><b>One Or More</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>One Or More</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ONE_OR_MORE
     * @model name="OneOrMore"
     * @generated
     * @ordered
     */
    public static final int ONE_OR_MORE_VALUE = 3;

    /**
     * The '<em><b>Unspecified</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Unspecified</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UNSPECIFIED
     * @model name="Unspecified"
     * @generated
     * @ordered
     */
    public static final int UNSPECIFIED_VALUE = 4;

    /**
     * The '<em><b>Unknown</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UNKNOWN
     * @model name="Unknown"
     * @generated
     * @ordered
     */
    public static final int UNKNOWN_VALUE = 5;

    /**
     * An array of all the '<em><b>Multiplicity Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final MultiplicityEnum[] VALUES_ARRAY =
        new MultiplicityEnum[] {
            ZERO_OR_ONE,
            ZERO_OR_MORE,
            EXACTLY_ONE,
            ONE_OR_MORE,
            UNSPECIFIED,
            UNKNOWN,
        };

    /**
     * A public read-only list of all the '<em><b>Multiplicity Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<MultiplicityEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Multiplicity Enum</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MultiplicityEnum get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MultiplicityEnum result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Multiplicity Enum</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MultiplicityEnum getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MultiplicityEnum result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Multiplicity Enum</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MultiplicityEnum get(int value) {
        switch (value) {
            case ZERO_OR_ONE_VALUE: return ZERO_OR_ONE;
            case ZERO_OR_MORE_VALUE: return ZERO_OR_MORE;
            case EXACTLY_ONE_VALUE: return EXACTLY_ONE;
            case ONE_OR_MORE_VALUE: return ONE_OR_MORE;
            case UNSPECIFIED_VALUE: return UNSPECIFIED;
            case UNKNOWN_VALUE: return UNKNOWN;
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
    private MultiplicityEnum(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }
    
} //MultiplicityEnum
