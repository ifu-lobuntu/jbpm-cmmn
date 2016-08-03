/*
 * Copyright 2011 JBoss Inc 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.kie.services.impl.cmmn;

import org.jbpm.cmmn.flow.xml.CMMNSemanticModule;

public class CMMNDataServiceSemanticModule extends CMMNSemanticModule {



    public CMMNDataServiceSemanticModule() {
        super(CMMN_URI);//Use the appropriate CMMN uri internally
        init();
    }

    public void init() {
        addHandler("definitions", new GetDefinitionsHandler());
    }

}
