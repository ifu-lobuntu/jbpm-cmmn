package org.jbpm.cmmn.service.model;


import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plan implements Serializable {
    private List<PlannedItem> plannedItems;
    private List<ApplicableDiscretionaryItem> discretionaryItems;

    public Plan(List<PlannedItem> plannedItems) {
        this.plannedItems = plannedItems;
    }
    public Plan(List<PlannedItem> plannedItems,List<ApplicableDiscretionaryItem> discretionaryItems) {
        this(plannedItems);
        this.discretionaryItems = discretionaryItems;
    }

    public List<PlannedItem> getPlannedItems() {
        return plannedItems;
    }

    public List<PlannedItem> getPlannableItemsFor(String planItemName) {
        List<PlannedItem> result = new ArrayList<PlannedItem>();
        for (PlannedItem plannedItem : plannedItems) {
            if (plannedItem.getName().equals(planItemName)) {
                result.add(plannedItem);
            }
        }
        return result;
    }

    public List<ApplicableDiscretionaryItem> getApplicableDiscretionaryItems() {
        return discretionaryItems;
    }
}
