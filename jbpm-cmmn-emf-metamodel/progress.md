#1. Designer
##1.1. Done and Tested:
###Stencils for:
 - CaseFileItem
 - CaseFileItem.children
 - CaseFileITem.targetRefs
 - Case
 - HumanTask
 - CaseTask
 - ProcessTask
 - Stage
 - DiscretionaryHumanTask
 - DiscretionaryCaseTask
 - DiscretionaryProcessTask
 - DiscretionaryStage
 - UserEvent
 - TimerEvent
 - PlanItemStartTrigger
 - CaseFileItemStartTrigger
 - Milestone
 - Sentries
 - CaseFileItemOnPart
 - PlanItemOnPart
 - PlanItemStartTrigger
 - CaseFileItemStartTrigger

### Decorators:
 - Repetition Rule Decorator present when a repetition rule exists
 - Manual Activation Rule Decorator present when a Manual Activation exists
 - Required Rule Decorator present when a Required Rule exists
 - AutoComplete decorator - normal refToView
 - Blocking vs non-blocking Human Task

### Property editors:
 - PerformerRef in HumanTasks - need to define a new plugin to lookup single roles
 - ProcessRef (Import other process WITH its ProcessParameters - set the Process and ProcessParameters on the calling Case as JSON property)
 - CaseRef (Import other Cases WITH its CaseParameters, set the Case and CaseParameters on the calling Case as JSON property)

###Parameters, their mappings and CaseFileItem bindings in Tasks.
 - This is a bit ugly in CMMN - lots of indirection, maybe we can hide it away from the user to a large extent.
 - For CaseTasks and ProcessTasks, let the list of input/output be fixed -no add/remove
 - Display the Case/Process parm name and type in the first two columns
 - Let the task's CaseParameter have exactly the same name as the mapped Case/Process parm
 - Select the CaseFileItem (CaseParameter.bindingRef in the third column
 - Select Language in fourth column
 - Type expression (CaseParamater.bindingRefinement) in 5 th column


##1.2. In Progress

##1.3. Todo:
###Stencils for:
 - Connector from HumanTask to related DiscretionaryItems in its PlanningTable
 - PlanFragment

###Decorators:
 - PlanItemTable for Stages
 - PlanItemTable for HumanTask


###Property editors:
 - ApplicabilityRuleRefs in Discretionary Items - simplify to one and make it appear contained
 - AuthorizedRoleRefs in Discretionary Items - need to define a new plugin to lookup multiple roles


###Collapse/Expand
 - Collapsed Stages and Cases
 - Collapsed Planning Tables for Stages and Cases
 - Collapsed Planning Table for Tasks with PlanningTable

#2. Form Modeler:
#2.1. Done and Tested
#2.2. Todo
 - Generate task forms
 - Generate CaseFileForm
 - Generate Start Case form

 - Name/Value construct to represent data
 - Form for CaseFile
 - Lookup of entities in dropdowns
 - Keep entitymanager/JCR session open during the form-request
