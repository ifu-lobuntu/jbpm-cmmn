/**
 */
package org.eclipse.cmmn1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Plan Item Transition</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 *         Enumeration of PlanItem transitions.
 *       
 * <!-- end-model-doc -->
 * @see org.eclipse.cmmn1.Cmmn1Package#getPlanItemTransition()
 * @model extendedMetaData="name='PlanItemTransition'"
 * @generated
 */
public enum PlanItemTransition implements Enumerator {
    /**
     * The '<em><b>Close</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CLOSE_VALUE
     * @generated
     * @ordered
     */
    CLOSE(0, "close", "close"),

    /**
     * The '<em><b>Complete</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #COMPLETE_VALUE
     * @generated
     * @ordered
     */
    COMPLETE(1, "complete", "complete"),

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
     * The '<em><b>Disable</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DISABLE_VALUE
     * @generated
     * @ordered
     */
    DISABLE(3, "disable", "disable"),

    /**
     * The '<em><b>Enable</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ENABLE_VALUE
     * @generated
     * @ordered
     */
    ENABLE(4, "enable", "enable"),

    /**
     * The '<em><b>Exit</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #EXIT_VALUE
     * @generated
     * @ordered
     */
    EXIT(5, "exit", "exit"),

    /**
     * The '<em><b>Fault</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FAULT_VALUE
     * @generated
     * @ordered
     */
    FAULT(6, "fault", "fault"),

    /**
     * The '<em><b>Manual Start</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MANUAL_START_VALUE
     * @generated
     * @ordered
     */
    MANUAL_START(7, "manualStart", "manualStart"),

    /**
     * The '<em><b>Occur</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OCCUR_VALUE
     * @generated
     * @ordered
     */
    OCCUR(8, "occur", "occur"),

    /**
     * The '<em><b>Parent Resume</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PARENT_RESUME_VALUE
     * @generated
     * @ordered
     */
    PARENT_RESUME(9, "parentResume", "parentResume"),

    /**
     * The '<em><b>Parent Suspend</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PARENT_SUSPEND_VALUE
     * @generated
     * @ordered
     */
    PARENT_SUSPEND(10, "parentSuspend", "parentSuspend"),

    /**
     * The '<em><b>Reactivate</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REACTIVATE_VALUE
     * @generated
     * @ordered
     */
    REACTIVATE(11, "reactivate", "reactivate"),

    /**
     * The '<em><b>Reenable</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REENABLE_VALUE
     * @generated
     * @ordered
     */
    REENABLE(12, "reenable", "reenable"),

    /**
     * The '<em><b>Resume</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #RESUME_VALUE
     * @generated
     * @ordered
     */
    RESUME(13, "resume", "resume"),

    /**
     * The '<em><b>Start</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #START_VALUE
     * @generated
     * @ordered
     */
    START(14, "start", "start"),

    /**
     * The '<em><b>Suspend</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SUSPEND_VALUE
     * @generated
     * @ordered
     */
    SUSPEND(15, "suspend", "suspend"),

    /**
     * The '<em><b>Terminate</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TERMINATE_VALUE
     * @generated
     * @ordered
     */
    TERMINATE(16, "terminate", "terminate");

    /**
     * The '<em><b>Close</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Close</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CLOSE
     * @model name="close"
     * @generated
     * @ordered
     */
    public static final int CLOSE_VALUE = 0;

    /**
     * The '<em><b>Complete</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Complete</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #COMPLETE
     * @model name="complete"
     * @generated
     * @ordered
     */
    public static final int COMPLETE_VALUE = 1;

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
     * The '<em><b>Disable</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Disable</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DISABLE
     * @model name="disable"
     * @generated
     * @ordered
     */
    public static final int DISABLE_VALUE = 3;

    /**
     * The '<em><b>Enable</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Enable</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ENABLE
     * @model name="enable"
     * @generated
     * @ordered
     */
    public static final int ENABLE_VALUE = 4;

    /**
     * The '<em><b>Exit</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Exit</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #EXIT
     * @model name="exit"
     * @generated
     * @ordered
     */
    public static final int EXIT_VALUE = 5;

    /**
     * The '<em><b>Fault</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Fault</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FAULT
     * @model name="fault"
     * @generated
     * @ordered
     */
    public static final int FAULT_VALUE = 6;

    /**
     * The '<em><b>Manual Start</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Manual Start</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MANUAL_START
     * @model name="manualStart"
     * @generated
     * @ordered
     */
    public static final int MANUAL_START_VALUE = 7;

    /**
     * The '<em><b>Occur</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Occur</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #OCCUR
     * @model name="occur"
     * @generated
     * @ordered
     */
    public static final int OCCUR_VALUE = 8;

    /**
     * The '<em><b>Parent Resume</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Parent Resume</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PARENT_RESUME
     * @model name="parentResume"
     * @generated
     * @ordered
     */
    public static final int PARENT_RESUME_VALUE = 9;

    /**
     * The '<em><b>Parent Suspend</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Parent Suspend</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PARENT_SUSPEND
     * @model name="parentSuspend"
     * @generated
     * @ordered
     */
    public static final int PARENT_SUSPEND_VALUE = 10;

    /**
     * The '<em><b>Reactivate</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Reactivate</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REACTIVATE
     * @model name="reactivate"
     * @generated
     * @ordered
     */
    public static final int REACTIVATE_VALUE = 11;

    /**
     * The '<em><b>Reenable</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Reenable</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REENABLE
     * @model name="reenable"
     * @generated
     * @ordered
     */
    public static final int REENABLE_VALUE = 12;

    /**
     * The '<em><b>Resume</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Resume</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RESUME
     * @model name="resume"
     * @generated
     * @ordered
     */
    public static final int RESUME_VALUE = 13;

    /**
     * The '<em><b>Start</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Start</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #START
     * @model name="start"
     * @generated
     * @ordered
     */
    public static final int START_VALUE = 14;

    /**
     * The '<em><b>Suspend</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Suspend</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SUSPEND
     * @model name="suspend"
     * @generated
     * @ordered
     */
    public static final int SUSPEND_VALUE = 15;

    /**
     * The '<em><b>Terminate</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Terminate</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TERMINATE
     * @model name="terminate"
     * @generated
     * @ordered
     */
    public static final int TERMINATE_VALUE = 16;

    /**
     * An array of all the '<em><b>Plan Item Transition</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final PlanItemTransition[] VALUES_ARRAY =
        new PlanItemTransition[] {
            CLOSE,
            COMPLETE,
            CREATE,
            DISABLE,
            ENABLE,
            EXIT,
            FAULT,
            MANUAL_START,
            OCCUR,
            PARENT_RESUME,
            PARENT_SUSPEND,
            REACTIVATE,
            REENABLE,
            RESUME,
            START,
            SUSPEND,
            TERMINATE,
        };

    /**
     * A public read-only list of all the '<em><b>Plan Item Transition</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<PlanItemTransition> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Plan Item Transition</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PlanItemTransition get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PlanItemTransition result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Plan Item Transition</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PlanItemTransition getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PlanItemTransition result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Plan Item Transition</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PlanItemTransition get(int value) {
        switch (value) {
            case CLOSE_VALUE: return CLOSE;
            case COMPLETE_VALUE: return COMPLETE;
            case CREATE_VALUE: return CREATE;
            case DISABLE_VALUE: return DISABLE;
            case ENABLE_VALUE: return ENABLE;
            case EXIT_VALUE: return EXIT;
            case FAULT_VALUE: return FAULT;
            case MANUAL_START_VALUE: return MANUAL_START;
            case OCCUR_VALUE: return OCCUR;
            case PARENT_RESUME_VALUE: return PARENT_RESUME;
            case PARENT_SUSPEND_VALUE: return PARENT_SUSPEND;
            case REACTIVATE_VALUE: return REACTIVATE;
            case REENABLE_VALUE: return REENABLE;
            case RESUME_VALUE: return RESUME;
            case START_VALUE: return START;
            case SUSPEND_VALUE: return SUSPEND;
            case TERMINATE_VALUE: return TERMINATE;
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
    private PlanItemTransition(int value, String name, String literal) {
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
    
} //PlanItemTransition
