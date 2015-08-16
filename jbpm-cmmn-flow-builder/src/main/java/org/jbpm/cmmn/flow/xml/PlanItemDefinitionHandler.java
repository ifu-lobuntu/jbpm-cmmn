package org.jbpm.cmmn.flow.xml;

import org.drools.core.xml.ExtensibleXmlParser;
import org.jbpm.cmmn.flow.definition.impl.AbstractPlanItemDefinition;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PlanItemDefinitionHandler extends AbstractCaseElementHandler {
    Deque<PlanItemDefinitionHandlerDelegate> stack = new LinkedList<PlanItemDefinitionHandlerDelegate>(); 
    Map<String,PlanItemDefinitionHandlerDelegate> delegates=new HashMap<String, PlanItemDefinitionHandlerDelegate>();
    {
        delegates.put("tHumanTask", new HumanTaskHandler());
        delegates.put("tCaseTask", new CaseTaskHandler());
        delegates.put("tProcessTask", new ProcessTaskHandler());
        delegates.put("tMilestone", new MilestoneHandler());
        delegates.put("tTimerEvent", new TimerEventHandler());
        delegates.put("tUserEvent", new UserEventHandler());
        delegates.put("tStage", new StageHandler());
    }
    @Override
    public Object start(String uri, String localName, Attributes attrs, ExtensibleXmlParser xmlPackageReader) throws SAXException {
        String type = attrs.getValue("xsi:type");
        if(type.contains(":")){
            type=type.substring(type.indexOf(':')+1);
        }
        PlanItemDefinitionHandlerDelegate delegate = delegates.get(type);
        stack.push(delegate);
        return delegate.start(uri, localName, attrs, xmlPackageReader);
    }

    @Override
    public Object end(String uri, String localName, ExtensibleXmlParser xmlPackageReader) throws SAXException {
        return stack.pop().end(uri, localName, xmlPackageReader);
    }

    @Override
    public Class<?> generateNodeFor() {
        return AbstractPlanItemDefinition.class;
    }

}
