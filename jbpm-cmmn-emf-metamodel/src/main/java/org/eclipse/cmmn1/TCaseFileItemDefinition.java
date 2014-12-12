/**
 */
package org.eclipse.cmmn1;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCase File Item Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tCaseFileItemDefinition defines the type of element "caseFileItemDefinition"
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getImportRef <em>Import Ref</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getStructureRef <em>Structure Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseFileItemDefinition()
 * @model extendedMetaData="name='tCaseFileItemDefinition' kind='elementOnly'"
 * @generated
 */
public interface TCaseFileItemDefinition extends TCmmnElement {
    /**
     * Returns the value of the '<em><b>Property</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TProperty}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Property</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseFileItemDefinition_Property()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
     * @generated
     */
    EList<TProperty> getProperty();

    /**
     * Returns the value of the '<em><b>Definition Type</b></em>' attribute.
     * The default value is <code>"http://www.omg.org/spec/CMMN/DefinitionType/Unspecified"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Definition Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Definition Type</em>' attribute.
     * @see #isSetDefinitionType()
     * @see #unsetDefinitionType()
     * @see #setDefinitionType(Object)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseFileItemDefinition_DefinitionType()
     * @model default="http://www.omg.org/spec/CMMN/DefinitionType/Unspecified" unsettable="true" dataType="org.eclipse.cmmn1.DefinitionTypeEnum"
     *        extendedMetaData="kind='attribute' name='definitionType'"
     * @generated
     */
    Object getDefinitionType();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getDefinitionType <em>Definition Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Definition Type</em>' attribute.
     * @see #isSetDefinitionType()
     * @see #unsetDefinitionType()
     * @see #getDefinitionType()
     * @generated
     */
    void setDefinitionType(Object value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getDefinitionType <em>Definition Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetDefinitionType()
     * @see #getDefinitionType()
     * @see #setDefinitionType(Object)
     * @generated
     */
    void unsetDefinitionType();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getDefinitionType <em>Definition Type</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Definition Type</em>' attribute is set.
     * @see #unsetDefinitionType()
     * @see #getDefinitionType()
     * @see #setDefinitionType(Object)
     * @generated
     */
    boolean isSetDefinitionType();

    /**
     * Returns the value of the '<em><b>Import Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               importRef refers an "import" element under "definitions"
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Import Ref</em>' attribute.
     * @see #setImportRef(QName)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseFileItemDefinition_ImportRef()
     * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
     *        extendedMetaData="kind='attribute' name='importRef'"
     * @generated
     */
    QName getImportRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getImportRef <em>Import Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import Ref</em>' attribute.
     * @see #getImportRef()
     * @generated
     */
    void setImportRef(QName value);

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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseFileItemDefinition_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Structure Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *               structureRef refers a structure, for example an XML-Schema element
     *               in a XSD referred by importRef
     *             
     * <!-- end-model-doc -->
     * @return the value of the '<em>Structure Ref</em>' attribute.
     * @see #setStructureRef(QName)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTCaseFileItemDefinition_StructureRef()
     * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
     *        extendedMetaData="kind='attribute' name='structureRef'"
     * @generated
     */
    QName getStructureRef();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TCaseFileItemDefinition#getStructureRef <em>Structure Ref</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Structure Ref</em>' attribute.
     * @see #getStructureRef()
     * @generated
     */
    void setStructureRef(QName value);

} // TCaseFileItemDefinition
