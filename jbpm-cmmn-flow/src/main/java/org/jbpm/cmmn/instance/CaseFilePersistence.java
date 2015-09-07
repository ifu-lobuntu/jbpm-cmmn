package org.jbpm.cmmn.instance;


import java.util.Collection;
import java.util.Map;

public interface CaseFilePersistence {
    public static final String ENV_NAME = CaseFilePersistence.class.getName() + "VAR";
    Collection<?> readAll(String objectType);
    Collection<?> executeNamedQuery(String name, Map<String, Object> parameters);
}
