/**
 */
package org.eclipse.cmmn1.impl;

import org.eclipse.cmmn1.Cmmn1Package;
import org.eclipse.cmmn1.TExpression;
import org.eclipse.cmmn1.TStartTrigger;
import org.eclipse.cmmn1.TTimerEvent;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTimer Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cmmn1.impl.TTimerEventImpl#getTimerExpression <em>Timer Expression</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TTimerEventImpl#getTimerStartGroup <em>Timer Start Group</em>}</li>
 *   <li>{@link org.eclipse.cmmn1.impl.TTimerEventImpl#getTimerStart <em>Timer Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TTimerEventImpl extends TEventImpl implements TTimerEvent {
    /**
     * The cached value of the '{@link #getTimerExpression() <em>Timer Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimerExpression()
     * @generated
     * @ordered
     */
    protected TExpression timerExpression;

    /**
     * The cached value of the '{@link #getTimerStartGroup() <em>Timer Start Group</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimerStartGroup()
     * @generated
     * @ordered
     */
    protected FeatureMap timerStartGroup;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TTimerEventImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Cmmn1Package.Literals.TTIMER_EVENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TExpression getTimerExpression() {
        return timerExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTimerExpression(TExpression newTimerExpression, NotificationChain msgs) {
        TExpression oldTimerExpression = timerExpression;
        timerExpression = newTimerExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION, oldTimerExpression, newTimerExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimerExpression(TExpression newTimerExpression) {
        if (newTimerExpression != timerExpression) {
            NotificationChain msgs = null;
            if (timerExpression != null)
                msgs = ((InternalEObject)timerExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION, null, msgs);
            if (newTimerExpression != null)
                msgs = ((InternalEObject)newTimerExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION, null, msgs);
            msgs = basicSetTimerExpression(newTimerExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION, newTimerExpression, newTimerExpression));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getTimerStartGroup() {
        if (timerStartGroup == null) {
            timerStartGroup = new BasicFeatureMap(this, Cmmn1Package.TTIMER_EVENT__TIMER_START_GROUP);
        }
        return timerStartGroup;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TStartTrigger getTimerStart() {
        return (TStartTrigger)getTimerStartGroup().get(Cmmn1Package.Literals.TTIMER_EVENT__TIMER_START, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTimerStart(TStartTrigger newTimerStart, NotificationChain msgs) {
        return ((FeatureMap.Internal)getTimerStartGroup()).basicAdd(Cmmn1Package.Literals.TTIMER_EVENT__TIMER_START, newTimerStart, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimerStart(TStartTrigger newTimerStart) {
        ((FeatureMap.Internal)getTimerStartGroup()).set(Cmmn1Package.Literals.TTIMER_EVENT__TIMER_START, newTimerStart);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION:
                return basicSetTimerExpression(null, msgs);
            case Cmmn1Package.TTIMER_EVENT__TIMER_START_GROUP:
                return ((InternalEList<?>)getTimerStartGroup()).basicRemove(otherEnd, msgs);
            case Cmmn1Package.TTIMER_EVENT__TIMER_START:
                return basicSetTimerStart(null, msgs);
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
            case Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION:
                return getTimerExpression();
            case Cmmn1Package.TTIMER_EVENT__TIMER_START_GROUP:
                if (coreType) return getTimerStartGroup();
                return ((FeatureMap.Internal)getTimerStartGroup()).getWrapper();
            case Cmmn1Package.TTIMER_EVENT__TIMER_START:
                return getTimerStart();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION:
                setTimerExpression((TExpression)newValue);
                return;
            case Cmmn1Package.TTIMER_EVENT__TIMER_START_GROUP:
                ((FeatureMap.Internal)getTimerStartGroup()).set(newValue);
                return;
            case Cmmn1Package.TTIMER_EVENT__TIMER_START:
                setTimerStart((TStartTrigger)newValue);
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
            case Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION:
                setTimerExpression((TExpression)null);
                return;
            case Cmmn1Package.TTIMER_EVENT__TIMER_START_GROUP:
                getTimerStartGroup().clear();
                return;
            case Cmmn1Package.TTIMER_EVENT__TIMER_START:
                setTimerStart((TStartTrigger)null);
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
            case Cmmn1Package.TTIMER_EVENT__TIMER_EXPRESSION:
                return timerExpression != null;
            case Cmmn1Package.TTIMER_EVENT__TIMER_START_GROUP:
                return timerStartGroup != null && !timerStartGroup.isEmpty();
            case Cmmn1Package.TTIMER_EVENT__TIMER_START:
                return getTimerStart() != null;
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
        result.append(" (timerStartGroup: ");
        result.append(timerStartGroup);
        result.append(')');
        return result.toString();
    }

} //TTimerEventImpl
