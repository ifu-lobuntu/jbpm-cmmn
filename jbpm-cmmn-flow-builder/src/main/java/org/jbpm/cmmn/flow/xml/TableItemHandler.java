package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.drools.core.xml.Handler;
import org.jbpm.cmmn.flow.planning.ApplicabilityRuleImpl;
import org.jbpm.cmmn.flow.planning.PlanningTable;
import org.jbpm.cmmn.flow.planning.TableItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TableItemHandler extends AbstractTableItemHandler implements Handler {
    Deque<AbstractTableItemHandler> stack = new LinkedList<AbstractTableItemHandler>();
    Map<String, AbstractTableItemHandler> delegates = new HashMap<String, AbstractTableItemHandler>();
    {
        delegates.put("tDiscretionaryItem", new DiscretionaryItemHandler());
        delegates.put("tPlanningTable", new PlanningTableHandler());
    }

    public TableItemHandler() {
        super();
        validParents.add(PlanningTable.class);
        validPeers.add(TableItem.class);
        validPeers.add(ApplicabilityRuleImpl.class);
        validPeers.add(null);
    }
    @Override
    public boolean allowNesting() {
        return true;
    }

    @Override
    public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser xmlPackageReader) throws SAXException {
        String type = attrs.getValue("xsi:type");
        if (type.contains(":")) {
            type = type.substring(type.indexOf(':') + 1);
        }
        AbstractTableItemHandler delegate = delegates.get(type);
        stack.push(delegate);
        return delegate.start(uri, localName, attrs, xmlPackageReader);
    }

    @Override
    public Object end(String uri, String localName, ExtensibleXmlParser xmlPackageReader) throws SAXException {
        return stack.pop().end(uri, localName, xmlPackageReader);
    }

    @Override
    public Class<?> generateNodeFor() {
        return TableItem.class;
    }

}
