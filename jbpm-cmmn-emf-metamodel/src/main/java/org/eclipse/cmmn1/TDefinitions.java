/**
 */
package org.eclipse.cmmn1;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.cmmndi.CMMNDiagram;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TDefinitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         tDefinitions defines the type of element "definitions".
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getCaseFileItemDefinition <em>Case File Item Definition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getCase <em>Case</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getProcess <em>Process</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getCMMNDiagram <em>CMMN Diagram</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getExporter <em>Exporter</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getExporterVersion <em>Exporter Version</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getTargetNamespace <em>Target Namespace</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.TDefinitions#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions()
 * @model extendedMetaData="name='tDefinitions' kind='elementOnly'"
 * @generated
 */
public interface TDefinitions extends EObject {
    /**
     * Returns the value of the '<em><b>Import</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TImport}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_Import()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace'"
     * @generated
     */
    EList<TImport> getImport();

    /**
     * Returns the value of the '<em><b>Case File Item Definition</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TCaseFileItemDefinition}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         caseFileItemDefinition defines the type of a "caseFileItem".
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case File Item Definition</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_CaseFileItemDefinition()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='caseFileItemDefinition' namespace='##targetNamespace'"
     * @generated
     */
    EList<TCaseFileItemDefinition> getCaseFileItemDefinition();

    /**
     * Returns the value of the '<em><b>Case</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TCase}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         case is the root element for all CMMN case models. It is the container
     *         for the Case File and Plan Model.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Case</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_Case()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='case' namespace='##targetNamespace'"
     * @generated
     */
    EList<TCase> getCase();

    /**
     * Returns the value of the '<em><b>Process</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmn1.TProcess}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *         process represents an (abstract) Business Process in CMMN. It has
     *         a implementationType, inputs and outputs and can be referred from
     *         a ProcessTask.
     *       
     * <!-- end-model-doc -->
     * @return the value of the '<em>Process</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_Process()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='process' namespace='##targetNamespace'"
     * @generated
     */
    EList<TProcess> getProcess();

    /**
     * Returns the value of the '<em><b>CMMN Diagram</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.cmmndi.CMMNDiagram}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CMMN Diagram</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CMMN Diagram</em>' containment reference list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_CMMNDiagram()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='CMMNDiagram' namespace='http://www.omg.org/spec/CMMN/20131201/DI'"
     * @generated
     */
    EList<CMMNDiagram> getCMMNDiagram();

    /**
     * Returns the value of the '<em><b>Author</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Author</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Author</em>' attribute.
     * @see #setAuthor(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_Author()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='author'"
     * @generated
     */
    String getAuthor();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getAuthor <em>Author</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Author</em>' attribute.
     * @see #getAuthor()
     * @generated
     */
    void setAuthor(String value);

    /**
     * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Creation Date</em>' attribute.
     * @see #setCreationDate(XMLGregorianCalendar)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_CreationDate()
     * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
     *        extendedMetaData="kind='attribute' name='creationDate'"
     * @generated
     */
    XMLGregorianCalendar getCreationDate();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getCreationDate <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Creation Date</em>' attribute.
     * @see #getCreationDate()
     * @generated
     */
    void setCreationDate(XMLGregorianCalendar value);

    /**
     * Returns the value of the '<em><b>Exporter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exporter</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exporter</em>' attribute.
     * @see #setExporter(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_Exporter()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='exporter'"
     * @generated
     */
    String getExporter();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getExporter <em>Exporter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exporter</em>' attribute.
     * @see #getExporter()
     * @generated
     */
    void setExporter(String value);

    /**
     * Returns the value of the '<em><b>Exporter Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exporter Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exporter Version</em>' attribute.
     * @see #setExporterVersion(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_ExporterVersion()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='exporterVersion'"
     * @generated
     */
    String getExporterVersion();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getExporterVersion <em>Exporter Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exporter Version</em>' attribute.
     * @see #getExporterVersion()
     * @generated
     */
    void setExporterVersion(String value);

    /**
     * Returns the value of the '<em><b>Expression Language</b></em>' attribute.
     * The default value is <code>"http://www.w3.org/1999/XPath"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression Language</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression Language</em>' attribute.
     * @see #isSetExpressionLanguage()
     * @see #unsetExpressionLanguage()
     * @see #setExpressionLanguage(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_ExpressionLanguage()
     * @model default="http://www.w3.org/1999/XPath" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
     *        extendedMetaData="kind='attribute' name='expressionLanguage'"
     * @generated
     */
    String getExpressionLanguage();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getExpressionLanguage <em>Expression Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression Language</em>' attribute.
     * @see #isSetExpressionLanguage()
     * @see #unsetExpressionLanguage()
     * @see #getExpressionLanguage()
     * @generated
     */
    void setExpressionLanguage(String value);

    /**
     * Unsets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getExpressionLanguage <em>Expression Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetExpressionLanguage()
     * @see #getExpressionLanguage()
     * @see #setExpressionLanguage(String)
     * @generated
     */
    void unsetExpressionLanguage();

    /**
     * Returns whether the value of the '{@link org.eclipse.cmmn1.TDefinitions#getExpressionLanguage <em>Expression Language</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Expression Language</em>' attribute is set.
     * @see #unsetExpressionLanguage()
     * @see #getExpressionLanguage()
     * @see #setExpressionLanguage(String)
     * @generated
     */
    boolean isSetExpressionLanguage();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

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
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Target Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Namespace</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Namespace</em>' attribute.
     * @see #setTargetNamespace(String)
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_TargetNamespace()
     * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
     *        extendedMetaData="kind='attribute' name='targetNamespace'"
     * @generated
     */
    String getTargetNamespace();

    /**
     * Sets the value of the '{@link org.eclipse.cmmn1.TDefinitions#getTargetNamespace <em>Target Namespace</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Namespace</em>' attribute.
     * @see #getTargetNamespace()
     * @generated
     */
    void setTargetNamespace(String value);

    /**
     * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Any Attribute</em>' attribute list.
     * @see org.eclipse.cmmn1.Cmmn1Package#getTDefinitions_AnyAttribute()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':13' processing='lax'"
     * @generated
     */
    FeatureMap getAnyAttribute();

} // TDefinitions
