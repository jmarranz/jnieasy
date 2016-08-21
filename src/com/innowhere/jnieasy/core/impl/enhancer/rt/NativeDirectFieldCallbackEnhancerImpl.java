/*
 * NativeDirectFieldCallbackEnhancerImpl.java
 *
 * Created on 20 de julio de 2005, 21:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeDirectFieldCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;
import com.innowhere.jnieasy.core.typedec.NativeDirectFieldCallbackDescriptor;


/**
 *
 * @author jmarranz
 */
public class NativeDirectFieldCallbackEnhancerImpl extends NativeDirectCallbackEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeDirectFieldCallbackEnhancerImpl
     */
    public NativeDirectFieldCallbackEnhancerImpl()
    {
    }
    
    public static void addFieldMethod(NativeDirectFieldCallbackDescriptor classInfo,String javaClassName,String fieldName,boolean exportMethod,NativeFieldMethodSignature sig)
    {
        ((JavaClassAsNativeDirectFieldCallbackRuntimeImpl)classInfo).setFieldMethod(javaClassName,fieldName,exportMethod,(NativeFieldMethodSignatureRuntimeImpl)sig);
    }      
}
