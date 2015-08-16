# 1. Done and Tested
JPA/Hibernate persistent subscriptions

- scope of subscriptions 
- bindingRefined
- throwing CREATE,DELETE,ADD_CHILD,REMOVE_CHILD,ADD_REFERENCE,REMOVE_REFERENCE and UPDATE events

JPA/Hibernate demarcated subscriptions

- throwing CREATE,DELETE,ADD_CHILD,REMOVE_CHILD,ADD_REFERENCE,REMOVE_REFERENCE and UPDATE events

Timer Event

- OCCUR,CREATE,SUSPEND,RESUME,TERMINATE,PARENT_TERMINATE
- timerStart CaseFileItem
- timerStart PlanItem

Milestone

- entry criteria achieved
- requiredRule
- repetitionRule
- OCCUR,CREATE,SUSPEND,RESUME,TERMINATE,PARENT_TERMINATE

CaseTask

- basic call
- entry criteria achieved
- automaticActivationRule
- exit criteria achieved
- parameterMapping
- parameter transformation
- writing result to bindingRef/bindingRefinement
- EXIT,DISABLE,ENABLE,MANUAL_START,START,COMPLETE,TERMINATE,FAULT,SUSPEND,RESUME,REENABLE,REACTIVATE,CREATE

Human Task

- automaticActivationRule
- repetitionRule
- entry criteria achieved
- exit criteria achieved
- writing result to bindingRef/bindingRefinement
- EXIT,DISABLE,ENABLE,MANUAL_START,START,COMPLETE,TERMINATE,FAULT,SUSPEND,RESUME,REENABLE,REACTIVATE,CREATE

UserEvent

- OCCUR, CREATE,SUSPEND,RESUME,TERMINATE,PARENT_TERMINATE

Stage:

- automaticActivationRule
- exit criteria achieved
- EXIT,DISABLE,ENABLE,MANUAL_START,START,COMPLETE,TERMINATE,FAULT,SUSPEND,RESUME,CREATE,REENABLE,REACTIVATE
- auto completion

CaseModel

- auto completion
- manual completion
- direct exit Criteria
- CLOSE, COMPLETE,CREATE, SUSPEND, REACTIVATE (from suspended),TERMINATE,FAULT
- Write Output Parameters from Processes to Task.result (CaseTask, ProcessTask, Standalone Case) 

PlanningTable

- authorizedRoles - pass the Case roles that the user is fulfilling 

Planning Service

- startPlanning (include current parameters, authorizedRole)
- prepareDiscretionaryItem 
- submitPlan 
-- update parameters (taskContent AND workItem ),
-- role (do role-assignment in process too) and
- makeDiscretionaryItemAvailable
 
DiscretionaryItem

- entryCriteria 
- itemControl.automaticActivationRule
- ApplicabilityRule
- itemControl.requiredRule
 
Generate OCM and JPA test Java classes from UML along with CaseFileItemDefinition includes

Implement OCLProcessDialect that extends JavaProcessDialect

Output ParameterMapping, bindingRefinement and scoped subscriptions

Recursive subscriptions, parameterizable

Drive planning from ProcessEngine rather than TaskService
 - interpret UpdateTaskStatusHandler as one-way sync
 - ensure UpdateTAskSTatusHandler does not call back to the ProcessEngine ( remove the CMMNTaskLifeCycleHandler from listerenrList)


# 2. To test more directly

- *.no sentry
- *.repetitionRule
- *.parentSuspend
- *.parentResume
- Storage of event variables inside StageInstances
- CaseTask.reactivated - check that process is restarted - it failed previously
- Planning Tables contained by HumanTasks and Stages

# 3. In Progress

# 4. To implement

XPath processDialect on JCR

OnCaseFileItem events - if it is an entryCriterion for a Task and there is a matching CaseParameter (same CaseFileItem)
 - if repititionRule=false, or it is the only CaseFileItem entry criterion, then set it on the variables of the task
 - if repititionRule=true and there are multiple CaseFileItem entry criteria, then
 -- if it is the primary input, set i on the variables of the task
 -- if it is the secondary input, find the appropriate task to set it on using a correlation expression that relates it to the primaryInput
 - But remember, the task and its node may not exist yet so we may need to build all of this up on the FactorynodeInstance
 - get rid of the eventStack in StandardEventNodeInstance
 - make

Drive planning from ProcessEngine rather than TaskService
 - store TaskInputs that have not been consumed yet in the NodeInstance's VariableContext

Only store Outputs that write to root CaseFileItems


Planning Service - HumanTask, Stage AND CasePlanModel
- calculate task startDates during plan submission
- startPlanning (include applicabilityRule) *
- prepareDiscretionaryItem *
-- recheck applicabilityRule*
-- recheck authorizedRole*
- submitPlan *
-- status/transition, *
-- (due date?)*

PlanItemOnPart.sentryRef *

Sentry.condition without onParts *

DiscretionaryItem - need input from OMG

- exitCriteria
- itemControl.repititionRule

CFA
 Consolidate all tasks for a participant
 Include VDML PropositionExchange info
 The CMMN Planner Role needs to be mapped to a Role in VDML (or maybe not), the CFA exchange takes place between the Planner and the target participant

# 5. Current potential problems
 
AbstractPersistentSubscriptionManager
- Find a way to get to the commandScopedEntity manager - the reflection won't work in CDI 

PlanningService (look at TaskServiceFactory interface)

- find a way to get to the persistence context - the reflection won't work in CDI
- find a way to get to the InternalTaskService

# 6. Difficult

For the validation of authorization for planning - get the possible roles from somewhere, perhaps the UserInfo service, but group != role

 
Sentry.condition without onParts - when to trigger the evaluation of the condition.


With JCR Property.CHANGE events, try to get the original value and only fire events for ADD_/REMOVE_REFERENCE when they applicable - JCR limitation


Optimize caching of SubscriptionInfo and perhaps even other OCM objects IN OCMSubscriptioinManager


# 7. Low priority


Plan fragments
- For Plan Items
- For Discretionary Items


ContextRefs for rules


Internationalization


CaseModel:

- REACTIVATE (from Failed,Terminated, Completed? need input from OMG)


JCR/OCM persistent subscriptions

- scope of subscriptions
- bindingRefined
- throwing CREATE,DELETE,ADD_CHILD,REMOVE_CHILD,ADD_REFERENCE,REMOVE_REFERENCE and UPDATE events

JCR/OCM demarcated subscriptions

- throwing CREATE,DELETE,ADD_CHILD,REMOVE_CHILD,ADD_REFERENCE,REMOVE_REFERENCE and UPDATE events

Pure JCR persistent subscriptions

- scope of subscriptions
- bindingRefined
- throwing CREATE,DELETE,ADD_CHILD,REMOVE_CHILD,ADD_REFERENCE,REMOVE_REFERENCE and UPDATE events

Pure JCR demarcated subscriptions

- throwing CREATE,DELETE,ADD_CHILD,REMOVE_CHILD,ADD_REFERENCE,REMOVE_REFERENCE and UPDATE events

