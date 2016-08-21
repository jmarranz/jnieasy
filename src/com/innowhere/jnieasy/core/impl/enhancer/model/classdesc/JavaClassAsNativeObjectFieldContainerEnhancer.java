/*
 * JavaClassAsNativeObjectFieldContainerEnhancer.java
 *
 * Created on 29 de septiembre de 2005, 13:50
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeObjectFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeCapableEnhancerXML;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeObjectFieldContainerEnhancerXML;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeObjectFieldContainerEnhancer extends JavaClassAsNativeFieldContainerEnhancer
{
    protected FieldOfClassAsNativeObjectFieldContainerEnhancer fieldEnh;
    
    /**
     * Creates a new instance of JavaClassAsNativeObjectFieldContainerEnhancer
     */
    public JavaClassAsNativeObjectFieldContainerEnhancer(JavaClassAsNativeObjectFieldContainerImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }
    
    public FieldOfClassAsNativeObjectFieldContainerEnhancer getField()
    {
        return fieldEnh;
    }
    
    public void setField(FieldOfClassAsNativeObjectFieldContainerEnhancer fieldEnh)
    {
        if (this.fieldEnh != null)
            throw new JNIEasyException("Only one field is allowed, class: " + getName());
             
        this.fieldEnh = fieldEnh;        
    }        

    public JavaClassAsNativeCapableEnhancerXML newJavaClassAsNativeCapableEnhancerXML()
    {
        return new JavaClassAsNativeObjectFieldContainerEnhancerXML(this);
    }    
}
