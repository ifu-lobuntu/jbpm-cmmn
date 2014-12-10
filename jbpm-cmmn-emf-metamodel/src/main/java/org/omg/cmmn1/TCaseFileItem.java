/**
 */
package org.omg.cmmn1;

import java.util.List;

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCase File Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tCaseFileItem defines the type of element "caseFileItem".
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.cmmn1.TCaseFileItem#getChildren <em>Children</em>}</li>
 *   <li>{@link org.omg.cmmn1.TCaseFileItem#getDefinitionRef <em>Definition Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.TCaseFileItem#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.omg.cmmn1.TCaseFileItem#getName <em>Name</em>}</li>
 *   <li>{@link org.omg.cmmn1.TCaseFileItem#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.omg.cmmn1.TCaseFileItem#getTargetRefs <em>Target Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItem()
 * @model extendedMetaData="name='tCaseFileItem' kind='elementOnly'"
 * @generated
 */
public interface TCaseFileItem extends TCmmnElement {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference.
	 * @see #setChildren(TChildren)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItem_Children()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='children' namespace='##targetNamespace'"
	 * @generated
	 */
	TChildren getChildren();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItem#getChildren <em>Children</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children</em>' containment reference.
	 * @see #getChildren()
	 * @generated
	 */
	void setChildren(TChildren value);

	/**
	 * Returns the value of the '<em><b>Definition Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               definitinRef MUST refer to a "caseFileItemDefinition" element. Since
	 *               CaseFileItemDefinition is re-usable, QName is used for reference.
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Definition Ref</em>' attribute.
	 * @see #setDefinitionRef(QName)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItem_DefinitionRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='definitionRef'"
	 * @generated
	 */
	QName getDefinitionRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItem#getDefinitionRef <em>Definition Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition Ref</em>' attribute.
	 * @see #getDefinitionRef()
	 * @generated
	 */
	void setDefinitionRef(QName value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The default value is <code>"Unspecified"</code>.
	 * The literals are from the enumeration {@link org.omg.cmmn1.MultiplicityEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see org.omg.cmmn1.MultiplicityEnum
	 * @see #isSetMultiplicity()
	 * @see #unsetMultiplicity()
	 * @see #setMultiplicity(MultiplicityEnum)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItem_Multiplicity()
	 * @model default="Unspecified" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='multiplicity'"
	 * @generated
	 */
	MultiplicityEnum getMultiplicity();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItem#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see org.omg.cmmn1.MultiplicityEnum
	 * @see #isSetMultiplicity()
	 * @see #unsetMultiplicity()
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(MultiplicityEnum value);

	/**
	 * Unsets the value of the '{@link org.omg.cmmn1.TCaseFileItem#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMultiplicity()
	 * @see #getMultiplicity()
	 * @see #setMultiplicity(MultiplicityEnum)
	 * @generated
	 */
	void unsetMultiplicity();

	/**
	 * Returns whether the value of the '{@link org.omg.cmmn1.TCaseFileItem#getMultiplicity <em>Multiplicity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Multiplicity</em>' attribute is set.
	 * @see #unsetMultiplicity()
	 * @see #getMultiplicity()
	 * @see #setMultiplicity(MultiplicityEnum)
	 * @generated
	 */
	boolean isSetMultiplicity();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItem_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               sourceRef MUST refer to a "caseFileItem" element in the case where this
	 *               "caseFileItem" has a parent.
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Ref</em>' attribute.
	 * @see #setSourceRef(String)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItem_SourceRef()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
	 *        extendedMetaData="kind='attribute' name='sourceRef'"
	 * @generated
	 */
	String getSourceRef();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItem#getSourceRef <em>Source Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Ref</em>' attribute.
	 * @see #getSourceRef()
	 * @generated
	 */
	void setSourceRef(String value);

	/**
	 * Returns the value of the '<em><b>Target Refs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *               If this "caseFileItem" maintains references to "caseFileItem" childs, then 
	 *               targetRefs MUST refer to "caseFileItem" elements; the targets of this caseFileItem.
	 *             
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Refs</em>' attribute.
	 * @see #setTargetRefs(List)
	 * @see org.omg.cmmn1.Cmmn1Package#getTCaseFileItem_TargetRefs()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.IDREFS" many="false"
	 *        extendedMetaData="kind='attribute' name='targetRefs'"
	 * @generated
	 */
	List<String> getTargetRefs();

	/**
	 * Sets the value of the '{@link org.omg.cmmn1.TCaseFileItem#getTargetRefs <em>Target Refs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Refs</em>' attribute.
	 * @see #getTargetRefs()
	 * @generated
	 */
	void setTargetRefs(List<String> value);

} // TCaseFileItem
