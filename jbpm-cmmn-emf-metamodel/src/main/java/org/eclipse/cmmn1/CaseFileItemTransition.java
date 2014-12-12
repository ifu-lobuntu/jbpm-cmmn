/**
 */
package org.eclipse.cmmn1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Case File Item Transition</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 *         Enumeration of CaseFileItem transitions.
 *       
 * <!-- end-model-doc -->
 * @see org.eclipse.cmmn1.Cmmn1Package#getCaseFileItemTransition()
 * @model extendedMetaData="name='CaseFileItemTransition'"
 * @generated
 */
public enum CaseFileItemTransition implements Enumerator {
    /**
     * The '<em><b>Add Child</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ADD_CHILD_VALUE
     * @generated
     * @ordered
     */
    ADD_CHILD(0, "addChild", "addChild"),

    /**
     * The '<em><b>Add Reference</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ADD_REFERENCE_VALUE
     * @generated
     * @ordered
     */
    ADD_REFERENCE(1, "addReference", "addReference"),

    /**
     * The '<em><b>Create</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CREATE_VALUE
     * @generated
     * @ordered
     */
    CREATE(2, "create", "create"),

    /**
     * The '<em><b>Delete</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DELETE_VALUE
     * @generated
     * @ordered
     */
    DELETE(3, "delete", "delete"),

    /**
     * The '<em><b>Remove Child</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REMOVE_CHILD_VALUE
     * @generated
     * @ordered
     */
    REMOVE_CHILD(4, "removeChild", "removeChild"),

    /**
     * The '<em><b>Remove Reference</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REMOVE_REFERENCE_VALUE
     * @generated
     * @ordered
     */
    REMOVE_REFERENCE(5, "removeReference", "removeReference"),

    /**
     * The '<em><b>Replace</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REPLACE_VALUE
     * @generated
     * @ordered
     */
    REPLACE(6, "replace", "replace"),

    /**
     * The '<em><b>Update</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UPDATE_VALUE
     * @generated
     * @ordered
     */
    UPDATE(7, "update", "update");

    /**
     * The '<em><b>Add Child</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Add Child</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ADD_CHILD
     * @model name="addChild"
     * @generated
     * @ordered
     */
    public static final int ADD_CHILD_VALUE = 0;

    /**
     * The '<em><b>Add Reference</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Add Reference</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ADD_REFERENCE
     * @model name="addReference"
     * @generated
     * @ordered
     */
    public static final int ADD_REFERENCE_VALUE = 1;

    /**
     * The '<em><b>Create</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Create</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CREATE
     * @model name="create"
     * @generated
     * @ordered
     */
    public static final int CREATE_VALUE = 2;

    /**
     * The '<em><b>Delete</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Delete</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DELETE
     * @model name="delete"
     * @generated
     * @ordered
     */
    public static final int DELETE_VALUE = 3;

    /**
     * The '<em><b>Remove Child</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Remove Child</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REMOVE_CHILD
     * @model name="removeChild"
     * @generated
     * @ordered
     */
    public static final int REMOVE_CHILD_VALUE = 4;

    /**
     * The '<em><b>Remove Reference</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Remove Reference</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REMOVE_REFERENCE
     * @model name="removeReference"
     * @generated
     * @ordered
     */
    public static final int REMOVE_REFERENCE_VALUE = 5;

    /**
     * The '<em><b>Replace</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Replace</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REPLACE
     * @model name="replace"
     * @generated
     * @ordered
     */
    public static final int REPLACE_VALUE = 6;

    /**
     * The '<em><b>Update</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Update</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UPDATE
     * @model name="update"
     * @generated
     * @ordered
     */
    public static final int UPDATE_VALUE = 7;

    /**
     * An array of all the '<em><b>Case File Item Transition</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final CaseFileItemTransition[] VALUES_ARRAY =
        new CaseFileItemTransition[] {
            ADD_CHILD,
            ADD_REFERENCE,
            CREATE,
            DELETE,
            REMOVE_CHILD,
            REMOVE_REFERENCE,
            REPLACE,
            UPDATE,
        };

    /**
     * A public read-only list of all the '<em><b>Case File Item Transition</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<CaseFileItemTransition> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Case File Item Transition</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CaseFileItemTransition get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            CaseFileItemTransition result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Case File Item Transition</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CaseFileItemTransition getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            CaseFileItemTransition result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Case File Item Transition</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CaseFileItemTransition get(int value) {
        switch (value) {
            case ADD_CHILD_VALUE: return ADD_CHILD;
            case ADD_REFERENCE_VALUE: return ADD_REFERENCE;
            case CREATE_VALUE: return CREATE;
            case DELETE_VALUE: return DELETE;
            case REMOVE_CHILD_VALUE: return REMOVE_CHILD;
            case REMOVE_REFERENCE_VALUE: return REMOVE_REFERENCE;
            case REPLACE_VALUE: return REPLACE;
            case UPDATE_VALUE: return UPDATE;
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
    private CaseFileItemTransition(int value, String name, String literal) {
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
    
} //CaseFileItemTransition
