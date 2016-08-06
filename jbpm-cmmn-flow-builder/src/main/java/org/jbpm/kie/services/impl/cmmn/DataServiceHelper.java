package org.jbpm.kie.services.impl.cmmn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataServiceHelper {
    public static boolean isCmmn(String bpmn2Content) {
        Pattern namespacePattern=Pattern.compile("(xmlns\\:)([\\w]{1,10})(\\=\\\"http\\:\\/\\/www\\.omg\\.org\\/spec\\/CMMN\\/20131201\\/MODEL\\\")");
        boolean isCmmn=false;
        Matcher matcher = namespacePattern.matcher(bpmn2Content);
        if(matcher.find()){
            String prefix = matcher.group(2);
            if(bpmn2Content.contains("<" + prefix + ":definitions")){
                isCmmn=true;
            }
        }
        return isCmmn;
    }
}
