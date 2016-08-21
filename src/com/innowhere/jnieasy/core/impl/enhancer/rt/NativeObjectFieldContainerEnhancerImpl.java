/*
 * NativeObjectFieldContainerEnhancerImpl.java
 *
 * Created on 29 de septiembre de 2005, 14:28
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeObjectFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeObjectFieldContainerDescriptor;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

/**
 *
 * @author jmarranz
 */
public class NativeObjectFieldContainerEnhancerImpl extends NativeFieldContainerEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeObjectFieldContainerEnhancerImpl
     */
    public NativeObjectFieldContainerEnhancerImpl()
    {
    }
        
    public static void setFieldDescriptor(NativeObjectFieldContainerDescriptor classInfo,String fieldName,VarTypeNative varTypeDec)
    {
        ((JavaClassAsNativeObjectFieldContainerRuntimeImpl)classInfo).setFieldDescriptor(fieldName,varTypeDec);
    }   
}
