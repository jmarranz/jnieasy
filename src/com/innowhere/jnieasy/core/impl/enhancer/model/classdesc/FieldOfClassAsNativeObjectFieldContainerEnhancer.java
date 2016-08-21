/*
 * FieldOfClassAsNativeObjectFieldContainerEnhancer.java
 *
 * Created on 29 de septiembre de 2005, 14:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeObjectFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldOfClassAsNativeObjectFieldContainerEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldOfClassEnhancerRender;
import javassist.CtField;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeObjectFieldContainerEnhancer extends FieldOfClassEnhancer
{
    
    /**
     * Creates a new instance of FieldOfClassAsNativeObjectFieldContainerEnhancer
     */
    public FieldOfClassAsNativeObjectFieldContainerEnhancer(CtField field,FieldOfClassAsNativeObjectFieldContainerImpl accessObject,JavaClassAsNativeObjectFieldContainerEnhancer classEnhancer)
    {
        super(field,accessObject, classEnhancer);
    }
    
    public FieldOfClassEnhancerRender newFieldOfClassEnhancerRender()
    {
        return new FieldOfClassAsNativeObjectFieldContainerEnhancerRender(this);
    }   

    public FieldOfClassAsNativeObjectFieldContainerImpl getFieldOfClassAsObjectFieldContainer()
    {
        return (FieldOfClassAsNativeObjectFieldContainerImpl)memberOfClass;
    }
}
