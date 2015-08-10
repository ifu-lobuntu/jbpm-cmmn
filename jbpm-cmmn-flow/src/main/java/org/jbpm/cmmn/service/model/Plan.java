package org.jbpm.cmmn.service.model;


import org.jbpm.cmmn.common.ApplicableDiscretionaryItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plan implements Serializable {
    private List<PlannableItem> plannableItems;
    private List<ApplicableDiscretionaryItem> discretionaryItems;

    public Plan(List<PlannableItem> plannableItems) {
        this.plannableItems = plannableItems;
    }
    public Plan(List<PlannableItem> plannableItems,List<ApplicableDiscretionaryItem> discretionaryItems) {
        this(plannableItems);
        this.discretionaryItems = discretionaryItems;
    }

    public List<PlannableItem> getPlannableItems() {
        return plannableItems;
    }

    public List<PlannableItem> getPlannableItemsFor(String planItemName) {
        List<PlannableItem> result = new ArrayList<PlannableItem>();
        for (PlannableItem plannableItem : plannableItems) {
            if (plannableItem.getName().equals(planItemName)) {
                result.add(plannableItem);
            }
        }
        return result;
    }

    public List<ApplicableDiscretionaryItem> getDiscretionaryItems() {
        return discretionaryItems;
    }
}
