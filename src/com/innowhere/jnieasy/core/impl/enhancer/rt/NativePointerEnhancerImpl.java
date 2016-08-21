/*
 * NativePointerEnhancerImpl.java
 *
 * Created on 28 de septiembre de 2005, 20:38
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

import com.innowhere.jnieasy.core.JNIEasy;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.NativePointerDescriptor;


/**
 *
 * @author jmarranz
 */
public class NativePointerEnhancerImpl extends NativeObjectFieldContainerEnhancerImpl
{
    
    /**
     * Creates a new instance of NativePointerEnhancerImpl
     */
    public NativePointerEnhancerImpl()
    {
    }
    
    public static NativePointerDescriptor initRegistrationPointerType(NativeCapableInternal factoryInst,String pointerClassName,int licenseUsedByEnhancer,JNIEasy jnieasy)
    {
        return JavaClassAsNativePointerRuntimeImpl.initRegistrationPointerType(factoryInst, pointerClassName, licenseUsedByEnhancer,(JNIEasyImpl)jnieasy);
    }    
 
}
