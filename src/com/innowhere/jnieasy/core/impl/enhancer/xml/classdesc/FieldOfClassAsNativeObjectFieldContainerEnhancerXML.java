/*
 * FieldOfClassAsNativeObjectFieldContainerEnhancerXML.java
 *
 * Created on 29 de septiembre de 2005, 14:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.xml.FieldOfClassXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassAsNativeObjectFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeObjectFieldContainerEnhancer;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeObjectFieldContainerEnhancerXML extends FieldOfClassEnhancerXML
{
    
    /**
     * Creates a new instance of FieldOfClassAsNativeObjectFieldContainerEnhancerXML
     */
    public FieldOfClassAsNativeObjectFieldContainerEnhancerXML(FieldOfClassXML accessObjOfClassXML,JavaClassAsNativeObjectFieldContainerEnhancer classEnhancer)
    {
        super(accessObjOfClassXML,classEnhancer);
    }
    
    public FieldOfClassAsNativeObjectFieldContainerEnhancer getFieldOfClassAsObjectFieldContainerEnhancer()
    {
        return (FieldOfClassAsNativeObjectFieldContainerEnhancer)memberOfClassEnh;
    }    
}
