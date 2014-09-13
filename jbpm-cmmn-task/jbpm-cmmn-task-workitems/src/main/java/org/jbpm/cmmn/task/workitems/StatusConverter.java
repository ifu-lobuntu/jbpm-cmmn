package org.jbpm.cmmn.task.workitems;

import org.jbpm.cmmn.instance.PlanElementState;
import org.kie.api.task.model.Status;

public class StatusConverter {

	public static PlanElementState convertStatus(Status status) {
		switch (status) {
		case Created:
			return PlanElementState.ENABLED;
		case Error:
		case Failed:
			return PlanElementState.FAILED;
		case Exited:
			return PlanElementState.TERMINATED;
		case Completed:
			return PlanElementState.COMPLETED;
		case Obsolete:
			return PlanElementState.DISABLED;
		case InProgress:
			return PlanElementState.ACTIVE;
		case Ready:
		case Reserved:
			return PlanElementState.ENABLED;
		case Suspended:
			return PlanElementState.SUSPENDED;
		}
		return PlanElementState.ACTIVE;
	}

	public static Status convertState(PlanElementState stat, boolean isOwned) {
		switch (stat) {
		case ACTIVE:
			return Status.InProgress;
		case INITIAL:
		case NONE:
			return Status.Created;
		case AVAILABLE:
		case ENABLED:
			return isOwned ? Status.Reserved : Status.Ready;
		case CLOSED:
		case COMPLETED:
			return Status.Completed;
		case DISABLED:
			return Status.Obsolete;
		case FAILED:
			return Status.Failed;
		case SUSPENDED:
			return Status.Suspended;
		case TERMINATED:
			return Status.Exited;
		}
		return Status.Ready;
	}

}
