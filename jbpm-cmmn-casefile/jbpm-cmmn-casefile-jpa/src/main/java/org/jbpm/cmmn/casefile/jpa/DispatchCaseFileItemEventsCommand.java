package org.jbpm.cmmn.casefile.jpa;

import org.kie.api.executor.Command;
import org.kie.api.executor.CommandContext;
import org.kie.api.executor.ExecutionResults;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.internal.runtime.manager.RuntimeManagerRegistry;
import org.kie.internal.runtime.manager.context.EmptyContext;

public class DispatchCaseFileItemEventsCommand implements Command {
    @Override
    public ExecutionResults execute(CommandContext commandContext) throws Exception {

        String deploymentId = (String) commandContext.getData("deploymentId");
        RuntimeEngine re = RuntimeManagerRegistry.get().getManager(deploymentId).getRuntimeEngine(EmptyContext.get());
        JpaCaseFilePersistence p= (JpaCaseFilePersistence) re.getKieSession().getEnvironment().get(JpaCaseFilePersistence.ENV_NAME);
        p.dispatchCaseFileItemEventQueue();
        return null;
    }
}
