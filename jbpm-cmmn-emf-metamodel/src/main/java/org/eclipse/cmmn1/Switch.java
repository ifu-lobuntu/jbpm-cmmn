package org.eclipse.cmmn1;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public abstract class Switch<T> {

    protected abstract T doSwitch(int classifierID, EObject theEObject) ;
    public abstract T defaultCase(EObject object) ;
    protected abstract boolean isSwitchFor(EPackage ePackage) ;
    public T doSwitch(EObject target) {
        if(target==null){
            return null;
        }
        return doSwitch(target.eClass().getClassifierID(), target);
    }
}
