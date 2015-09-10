# 1. Done and Tested
## JPA/Hibernate persistent subscriptions

- scope of subscriptions 
- bindingRefined
- throwing CREATE,DELETE,ADD_CHILD,REMOVE_CHILD,ADD_REFERENCE,REMOVE_REFERENCE and UPDATE events

## JPA/Hibernate demarcated subscriptions

- throwing CREATE,DELETE,ADD_CHILD,REMOVE_CHILD,ADD_REFERENCE,REMOVE_REFERENCE and UPDATE events

## Timer Event

- OCCUR,CREATE,SUSPEND,RESUME,TERMINATE,PARENT_TERMINATE
- timerStart CaseFileItem
- timerStart PlanItem

## Milestone

- entry criteria achieved
- requiredRule
- repetitionRule
- OCCUR,CREATE,SUSPEND,RESUME,TERMINATE,PARENT_TERMINATE

## CaseTask

- basic call
- entry criteria achieved
- automaticActivationRule
- exit criteria achieved
- parameterMapping
- parameter transformation
- writing result to bindingRef/bindingRefinement
- EXIT,DISABLE,ENABLE,MANUAL_START,START,COMPLETE,TERMINATE,FAULT,SUSPEND,RESUME,REENABLE,REACTIVATE,CREATE

## Human Task

- automaticActivationRule
- repetitionRule
- entry criteria achieved
- exit criteria achieved
- writing result to bindingRef/bindingRefinement
- EXIT,DISABLE,ENABLE,MANUAL_START,START,COMPLETE,TERMINATE,FAULT,SUSPEND,RESUME,REENABLE,REACTIVATE,CREATE

## UserEvent

- OCCUR, CREATE,SUSPEND,RESUME,TERMINATE,PARENT_TERMINATE

## Stage:

- automaticActivationRule
- exit criteria achieved
- EXIT,DISABLE,ENABLE,MANUAL_START,START,COMPLETE,TERMINATE,FAULT,SUSPEND,RESUME,CREATE,REENABLE,REACTIVATE
- auto completion

## CaseModel

- auto completion
- manual completion
- direct exit Criteria
- CLOSE, COMPLETE,CREATE, SUSPEND, REACTIVATE (from suspended),TERMINATE,FAULT
- Write Output Parameters from Processes to Task.result (CaseTask, ProcessTask, Standalone Case) 

## PlanningTable

- authorizedRoles - pass the Case roles that the user is fulfilling 

## Planning Service

- startPlanning (include current parameters, authorizedRole)
- prepareDiscretionaryItem 
- submitPlan 
-- update parameters (taskContent AND workItem ),
-- role (do role-assignment in process too) and
- makeDiscretionaryItemAvailable
 
## DiscretionaryItem

- entryCriteria 
- itemControl.automaticActivationRule
- ApplicabilityRule
- itemControl.requiredRule
 
## Generate OCM and JPA test Java classes from UML along with CaseFileItemDefinition includes

## Implement OCLProcessDialect that extends JavaProcessDialect

## Output ParameterMapping, bindingRefinement and scoped subscriptions

## Drive planning from ProcessEngine rather than TaskService
 - interpret UpdateTaskStatusHandler as one-way sync
 - ensure UpdateTAskSTatusHandler does not call back to the ProcessEngine ( remove the CMMNTaskLifeCycleHandler from listerenrList)
 - store TaskInputs that have not been consumed yet in the NodeInstance's VariableContext

## OnCaseFileItem events - if it is an entryCriterion for a Task and there is a matching CaseParameter (same CaseFileItem) that does NOT have a bindingRefinement and is NOT a SingleInstance root CaseFileItem
 - if repititionRule=false, or it is the only CaseFileItem entry criterion that matches a CaseParameter, then set it on the variables of the task


# 2. To test more directly

- *.no sentry
- *.repetitionRule
- *.parentSuspend
- *.parentResume
- Storage of event variables inside StageInstances
- CaseTask.reactivated - check that process is restarted - it failed previously
- Planning Tables contained by HumanTasks and Stages
- HumanTask.stop

# 3. In Progress

# 4. To implement

## jbpm-console-ng

 - Edit process instance variable using its ClassForm
   -- add methods to FormModelerProcessStarterEntryPointImpl
 - Edit Case Roles porcess instace variable using a special form
 - Introduce a planning tab
  -- Table: name, state,dropdown of transitions
  -- Edit inputs to taskInstances

## jbpm-form-modeler
 - Implement double listbox ManyToMany lookup
 - Add operations to FormModelerFormProvider for ClassForms  


## PlanItemOnPart.sentryRef *

## ProcessTask

- basic call
- entry criteria achieved
- automaticActivationRule
- exit criteria achieved
- parameterMapping
- parameter transformation
- writing result to bindingRef/bindingRefinement
- EXIT,DISABLE,ENABLE,MANUAL_START,START,COMPLETE,TERMINATE,FAULT,SUSPEND,RESUME,REENABLE,REACTIVATE,CREATE

## CaseEvent correllation
 - When a repeating CaseTask,ProcessTask or HumanTask is triggered by a sentry with multiple onparts, it could be useful to define a
   correlation expression for each OnPart to determine which set of occurrences should be considered together and offered to the
   TaskInstance when it is created. This CorrellationExpression is therefore and extension of CMMN, it resides on the OnPart and
   all OnParts whose CorrellationExpression evaluates to the same value TOGETHER result in a new TaskInstance. In addition, CaseFileItemEvents
   that match CaseParameters can be passed to the TaskInstance as parameter. This would also require Dialect level support for access
   to the state of source PlanItem instances, such as InputParameters and role assignments, perhaps dates. implementing this should
   ideally store CaseEvents in a Map on the OnPart instance, as opposed to the current Stack.

## HTTP/REST/JSON CaseFile support.
 - Create CaseFileItemInstance class with:
  -- CMMN "Primitive" attributes (String,Date,Integer)
  -- ChildLink attributes
  -- TargetRefLink attributes
  -- For each entity
 - Extend Spring Data REST
  -- Links should also have "names"
 - Implement ObjectMarshallingStrategy
  -- Read with GETs
  -- Write with PUTs
  -- Only Children can be deleted when they are removed from their parent.
 - Implement Form ValueHolder
 - Implement CaseFileItemLookup with REST url
   -- Find way to extract parameters from Form context. (eg. GET http://host.com/api/rings?param1=${input1}

## CMIS CaseFile support
 - Use Apache Chemistry
 - May need to store the last changeToken successfully processed
 
 
Only store Outputs that write to root CaseFileItems

## Planning Service - HumanTask, Stage AND CasePlanModel
- calculate task startDates during plan submission
- startPlanning (include applicabilityRule) *
- prepareDiscretionaryItem *
-- recheck applicabilityRule*
-- recheck authorizedRole*
- submitPlan *
-- status/transition, *
-- (due date?)*


## Sentry.condition without onParts *

## DiscretionaryItem - need input from OMG

- exitCriteria
- itemControl.repititionRule

CFA
 -Consolidate all tasks for a participant, may have a dependency on event correllation, alternatively the modeller
 should simply model the correllated set of activities in a separate Collaboration??.
 -Include VDML PropositionExchange info
 -The CMMN Planner Role needs to be mapped to a Role in VDML (or maybe not), the CFA exchange takes place between the Planner and the target participant

# 5. Difficult

For the validation of authorization for planning - get the possible roles from somewhere, perhaps the UserInfo service, but group != role

 
Sentry.condition without onParts - when to trigger the evaluation of the condition.


With JCR Property.CHANGE events, try to get the original value and only fire events for ADD_/REMOVE_REFERENCE when they applicable - JCR limitation


Optimize caching of SubscriptionInfo and perhaps even other OCM objects IN OCMSubscriptioinManager


# 6. Low priority


Plan fragments
- For Plan Items
- For Discretionary Items


ContextRefs for rules


Internationalization


CaseModel:

- REACTIVATE (from Failed,Terminated, Completed? need input from OMG)

XPath processDialect on JCR

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

