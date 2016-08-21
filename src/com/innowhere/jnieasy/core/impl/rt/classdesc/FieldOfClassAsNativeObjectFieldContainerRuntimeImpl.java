/*
 * FieldOfClassAsNativeObjectFieldContainerRuntimeImpl.java
 *
 * Created on 29 de septiembre de 2005, 14:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeObjectFieldContainerImpl;
import java.lang.reflect.Field;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeObjectFieldContainerRuntimeImpl extends FieldOfClassRuntimeImpl
{
    
    /**
     * Creates a new instance of FieldOfClassAsNativeObjectFieldContainerRuntimeImpl
     */
    public FieldOfClassAsNativeObjectFieldContainerRuntimeImpl(FieldOfClassAsNativeObjectFieldContainerImpl accessObjectClass,Field field,JavaClassAsNativeObjectFieldContainerRuntimeImpl javaClass)
    {
        super(accessObjectClass,field,javaClass);
    }
    
}
