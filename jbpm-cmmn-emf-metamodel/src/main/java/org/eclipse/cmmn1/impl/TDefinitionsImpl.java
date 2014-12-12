/**
 */
package org.eclipse.cmmn1.impl;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TCase;
import org.eclipse.cmmn1.TCaseFileItemDefinition;
import org.eclipse.cmmn1.TDefinitions;
import org.eclipse.cmmn1.TImport;
import org.eclipse.cmmn1.TProcess;
import org.eclipse.cmmndi.CMMNDiagram;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TDefinitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getCaseFileItemDefinition <em>Case File Item Definition</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getCase <em>Case</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getCMMNDiagram <em>CMMN Diagram</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getExporter <em>Exporter</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getExporterVersion <em>Exporter Version</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getTargetNamespace <em>Target Namespace</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TDefinitionsImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TDefinitionsImpl extends MinimalEObjectImpl.Container implements TDefinitions {
    /**
     * The cached value of the '{@link #getImport() <em>Import</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImport()
     * @generated
     * @ordered
     */
    protected EList<TImport> import_;

    /**
     * The cached value of the '{@link #getCaseFileItemDefinition() <em>Case File Item Definition</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCaseFileItemDefinition()
     * @generated
     * @ordered
     */
    protected EList<TCaseFileItemDefinition> caseFileItemDefinition;

    /**
     * The cached value of the '{@link #getCase() <em>Case</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCase()
     * @generated
     * @ordered
     */
    protected EList<TCase> case_;

    /**
     * The cached value of the '{@link #getProcess() <em>Process</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProcess()
     * @generated
     * @ordered
     */
    protected EList<TProcess> process;

    /**
     * The cached value of the '{@link #getCMMNDiagram() <em>CMMN Diagram</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCMMNDiagram()
     * @generated
     * @ordered
     */
    protected EList<CMMNDiagram> cMMNDiagram;

    /**
     * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthor()
     * @generated
     * @ordered
     */
    protected static final String AUTHOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthor()
     * @generated
     * @ordered
     */
    protected String author = AUTHOR_EDEFAULT;

    /**
     * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected static final XMLGregorianCalendar CREATION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCreationDate()
     * @generated
     * @ordered
     */
    protected XMLGregorianCalendar creationDate = CREATION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getExporter() <em>Exporter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporter()
     * @generated
     * @ordered
     */
    protected static final String EXPORTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExporter() <em>Exporter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporter()
     * @generated
     * @ordered
     */
    protected String exporter = EXPORTER_EDEFAULT;

    /**
     * The default value of the '{@link #getExporterVersion() <em>Exporter Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporterVersion()
     * @generated
     * @ordered
     */
    protected static final String EXPORTER_VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExporterVersion() <em>Exporter Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporterVersion()
     * @generated
     * @ordered
     */
    protected String exporterVersion = EXPORTER_VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpressionLanguage()
     * @generated
     * @ordered
     */
    protected static final String EXPRESSION_LANGUAGE_EDEFAULT = "http://www.w3.org/1999/XPath";

    /**
     * The cached value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpressionLanguage()
     * @generated
     * @ordered
     */
    protected String expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;

    /**
     * This is true if the Expression Language attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean expressionLanguageESet;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetNamespace()
     * @generated
     * @ordered
     */
    protected static final String TARGET_NAMESPACE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetNamespace()
     * @generated
     * @ordered
     */
    protected String targetNamespace = TARGET_NAMESPACE_EDEFAULT;

    /**
     * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAnyAttribute()
     * @generated
     * @ordered
     */
    protected FeatureMap anyAttribute;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TDefinitionsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TDEFINITIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TImport> getImport() {
        if (import_ == null) {
            import_ = new EObjectContainmentEList<TImport>(TImport.class, this, Cmmn1Package.TDEFINITIONS__IMPORT);
        }
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TCaseFileItemDefinition> getCaseFileItemDefinition() {
        if (caseFileItemDefinition == null) {
            caseFileItemDefinition = new EObjectContainmentEList<TCaseFileItemDefinition>(TCaseFileItemDefinition.class, this, Cmmn1Package.TDEFINITIONS__CASE_FILE_ITEM_DEFINITION);
        }
        return caseFileItemDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TCase> getCase() {
        if (case_ == null) {
            case_ = new EObjectContainmentEList<TCase>(TCase.class, this, Cmmn1Package.TDEFINITIONS__CASE);
        }
        return case_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TProcess> getProcess() {
        if (process == null) {
            process = new EObjectContainmentEList<TProcess>(TProcess.class, this, Cmmn1Package.TDEFINITIONS__PROCESS);
        }
        return process;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<CMMNDiagram> getCMMNDiagram() {
        if (cMMNDiagram == null) {
            cMMNDiagram = new EObjectContainmentEList<CMMNDiagram>(CMMNDiagram.class, this, Cmmn1Package.TDEFINITIONS__CMMN_DIAGRAM);
        }
        return cMMNDiagram;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAuthor(String newAuthor) {
        String oldAuthor = author;
        author = newAuthor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDEFINITIONS__AUTHOR, oldAuthor, author));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCreationDate(XMLGregorianCalendar newCreationDate) {
        XMLGregorianCalendar oldCreationDate = creationDate;
        creationDate = newCreationDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDEFINITIONS__CREATION_DATE, oldCreationDate, creationDate));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExporter() {
        return exporter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExporter(String newExporter) {
        String oldExporter = exporter;
        exporter = newExporter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDEFINITIONS__EXPORTER, oldExporter, exporter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExporterVersion() {
        return exporterVersion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExporterVersion(String newExporterVersion) {
        String oldExporterVersion = exporterVersion;
        exporterVersion = newExporterVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDEFINITIONS__EXPORTER_VERSION, oldExporterVersion, exporterVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExpressionLanguage() {
        return expressionLanguage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpressionLanguage(String newExpressionLanguage) {
        String oldExpressionLanguage = expressionLanguage;
        expressionLanguage = newExpressionLanguage;
        boolean oldExpressionLanguageESet = expressionLanguageESet;
        expressionLanguageESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDEFINITIONS__EXPRESSION_LANGUAGE, oldExpressionLanguage, expressionLanguage, !oldExpressionLanguageESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetExpressionLanguage() {
        String oldExpressionLanguage = expressionLanguage;
        boolean oldExpressionLanguageESet = expressionLanguageESet;
        expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;
        expressionLanguageESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, Cmmn1Package.TDEFINITIONS__EXPRESSION_LANGUAGE, oldExpressionLanguage, EXPRESSION_LANGUAGE_EDEFAULT, oldExpressionLanguageESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetExpressionLanguage() {
        return expressionLanguageESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDEFINITIONS__ID, oldId, id));
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
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDEFINITIONS__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetNamespace(String newTargetNamespace) {
        String oldTargetNamespace = targetNamespace;
        targetNamespace = newTargetNamespace;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TDEFINITIONS__TARGET_NAMESPACE, oldTargetNamespace, targetNamespace));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getAnyAttribute() {
        if (anyAttribute == null) {
            anyAttribute = new BasicFeatureMap(this, Cmmn1Package.TDEFINITIONS__ANY_ATTRIBUTE);
        }
        return anyAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TDEFINITIONS__IMPORT:
                return ((InternalEList<?>)getImport()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TDEFINITIONS__CASE_FILE_ITEM_DEFINITION:
                return ((InternalEList<?>)getCaseFileItemDefinition()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TDEFINITIONS__CASE:
                return ((InternalEList<?>)getCase()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TDEFINITIONS__PROCESS:
                return ((InternalEList<?>)getProcess()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TDEFINITIONS__CMMN_DIAGRAM:
                return ((InternalEList<?>)getCMMNDiagram()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TDEFINITIONS__ANY_ATTRIBUTE:
                return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case Cmmn1Package.TDEFINITIONS__IMPORT:
                return getImport();
            case Cmmn1Package.TDEFINITIONS__CASE_FILE_ITEM_DEFINITION:
                return getCaseFileItemDefinition();
            case Cmmn1Package.TDEFINITIONS__CASE:
                return getCase();
            case Cmmn1Package.TDEFINITIONS__PROCESS:
                return getProcess();
            case Cmmn1Package.TDEFINITIONS__CMMN_DIAGRAM:
                return getCMMNDiagram();
            case Cmmn1Package.TDEFINITIONS__AUTHOR:
                return getAuthor();
            case Cmmn1Package.TDEFINITIONS__CREATION_DATE:
                return getCreationDate();
            case Cmmn1Package.TDEFINITIONS__EXPORTER:
                return getExporter();
            case Cmmn1Package.TDEFINITIONS__EXPORTER_VERSION:
                return getExporterVersion();
            case Cmmn1Package.TDEFINITIONS__EXPRESSION_LANGUAGE:
                return getExpressionLanguage();
            case Cmmn1Package.TDEFINITIONS__ID:
                return getId();
            case Cmmn1Package.TDEFINITIONS__NAME:
                return getName();
            case Cmmn1Package.TDEFINITIONS__TARGET_NAMESPACE:
                return getTargetNamespace();
            case Cmmn1Package.TDEFINITIONS__ANY_ATTRIBUTE:
                if (coreType) return getAnyAttribute();
                return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case Cmmn1Package.TDEFINITIONS__IMPORT:
                getImport().clear();
                getImport().addAll((Collection<? extends TImport>)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__CASE_FILE_ITEM_DEFINITION:
                getCaseFileItemDefinition().clear();
                getCaseFileItemDefinition().addAll((Collection<? extends TCaseFileItemDefinition>)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__CASE:
                getCase().clear();
                getCase().addAll((Collection<? extends TCase>)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__PROCESS:
                getProcess().clear();
                getProcess().addAll((Collection<? extends TProcess>)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__CMMN_DIAGRAM:
                getCMMNDiagram().clear();
                getCMMNDiagram().addAll((Collection<? extends CMMNDiagram>)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__AUTHOR:
                setAuthor((String)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__CREATION_DATE:
                setCreationDate((XMLGregorianCalendar)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__EXPORTER:
                setExporter((String)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__EXPORTER_VERSION:
                setExporterVersion((String)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__EXPRESSION_LANGUAGE:
                setExpressionLanguage((String)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__ID:
                setId((String)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__NAME:
                setName((String)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__TARGET_NAMESPACE:
                setTargetNamespace((String)newValue);
                return;
            case Cmmn1Package.TDEFINITIONS__ANY_ATTRIBUTE:
                ((FeatureMap.Internal)getAnyAttribute()).set(newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case Cmmn1Package.TDEFINITIONS__IMPORT:
                getImport().clear();
                return;
            case Cmmn1Package.TDEFINITIONS__CASE_FILE_ITEM_DEFINITION:
                getCaseFileItemDefinition().clear();
                return;
            case Cmmn1Package.TDEFINITIONS__CASE:
                getCase().clear();
                return;
            case Cmmn1Package.TDEFINITIONS__PROCESS:
                getProcess().clear();
                return;
            case Cmmn1Package.TDEFINITIONS__CMMN_DIAGRAM:
                getCMMNDiagram().clear();
                return;
            case Cmmn1Package.TDEFINITIONS__AUTHOR:
                setAuthor(AUTHOR_EDEFAULT);
                return;
            case Cmmn1Package.TDEFINITIONS__CREATION_DATE:
                setCreationDate(CREATION_DATE_EDEFAULT);
                return;
            case Cmmn1Package.TDEFINITIONS__EXPORTER:
                setExporter(EXPORTER_EDEFAULT);
                return;
            case Cmmn1Package.TDEFINITIONS__EXPORTER_VERSION:
                setExporterVersion(EXPORTER_VERSION_EDEFAULT);
                return;
            case Cmmn1Package.TDEFINITIONS__EXPRESSION_LANGUAGE:
                unsetExpressionLanguage();
                return;
            case Cmmn1Package.TDEFINITIONS__ID:
                setId(ID_EDEFAULT);
                return;
            case Cmmn1Package.TDEFINITIONS__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Cmmn1Package.TDEFINITIONS__TARGET_NAMESPACE:
                setTargetNamespace(TARGET_NAMESPACE_EDEFAULT);
                return;
            case Cmmn1Package.TDEFINITIONS__ANY_ATTRIBUTE:
                getAnyAttribute().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case Cmmn1Package.TDEFINITIONS__IMPORT:
                return import_ != null && !import_.isEmpty();
            case Cmmn1Package.TDEFINITIONS__CASE_FILE_ITEM_DEFINITION:
                return caseFileItemDefinition != null && !caseFileItemDefinition.isEmpty();
            case Cmmn1Package.TDEFINITIONS__CASE:
                return case_ != null && !case_.isEmpty();
            case Cmmn1Package.TDEFINITIONS__PROCESS:
                return process != null && !process.isEmpty();
            case Cmmn1Package.TDEFINITIONS__CMMN_DIAGRAM:
                return cMMNDiagram != null && !cMMNDiagram.isEmpty();
            case Cmmn1Package.TDEFINITIONS__AUTHOR:
                return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
            case Cmmn1Package.TDEFINITIONS__CREATION_DATE:
                return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
            case Cmmn1Package.TDEFINITIONS__EXPORTER:
                return EXPORTER_EDEFAULT == null ? exporter != null : !EXPORTER_EDEFAULT.equals(exporter);
            case Cmmn1Package.TDEFINITIONS__EXPORTER_VERSION:
                return EXPORTER_VERSION_EDEFAULT == null ? exporterVersion != null : !EXPORTER_VERSION_EDEFAULT.equals(exporterVersion);
            case Cmmn1Package.TDEFINITIONS__EXPRESSION_LANGUAGE:
                return isSetExpressionLanguage();
            case Cmmn1Package.TDEFINITIONS__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case Cmmn1Package.TDEFINITIONS__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Cmmn1Package.TDEFINITIONS__TARGET_NAMESPACE:
                return TARGET_NAMESPACE_EDEFAULT == null ? targetNamespace != null : !TARGET_NAMESPACE_EDEFAULT.equals(targetNamespace);
            case Cmmn1Package.TDEFINITIONS__ANY_ATTRIBUTE:
                return anyAttribute != null && !anyAttribute.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (author: ");
        result.append(author);
        result.append(", creationDate: ");
        result.append(creationDate);
        result.append(", exporter: ");
        result.append(exporter);
        result.append(", exporterVersion: ");
        result.append(exporterVersion);
        result.append(", expressionLanguage: ");
        if (expressionLanguageESet) result.append(expressionLanguage); else result.append("<unset>");
        result.append(", id: ");
        result.append(id);
        result.append(", name: ");
        result.append(name);
        result.append(", targetNamespace: ");
        result.append(targetNamespace);
        result.append(", anyAttribute: ");
        result.append(anyAttribute);
        result.append(')');
        return result.toString();
    }

} //TDefinitionsImpl
