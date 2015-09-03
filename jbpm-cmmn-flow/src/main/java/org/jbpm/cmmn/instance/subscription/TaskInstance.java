package org.jbpm.cmmn.instance.subscription;

import org.jbpm.cmmn.flow.definition.TaskDefinition;
import org.jbpm.cmmn.instance.ControllableItemInstance;

public interface TaskInstance <T extends TaskDefinition> extends ControllableItemInstance<T>{
    Object getInput(String s);
}
