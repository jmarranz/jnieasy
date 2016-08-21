/*
 * NativeDirectMethodCallbackEnhancerImpl.java
 *
 * Created on 20 de julio de 2005, 21:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeDirectMethodCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectMethodCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;

/**
 *
 * @author jmarranz
 */
public class NativeDirectMethodCallbackEnhancerImpl extends NativeDirectCallbackEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeDirectMethodCallbackEnhancerImpl
     */
    public NativeDirectMethodCallbackEnhancerImpl()
    {
    }
        
    public static void addMethod(NativeDirectMethodCallbackDescriptor classInfo,String javaClassName,String methodName,boolean exportMethod,NativeMethodSignature sig)
    {
        ((JavaClassAsNativeDirectMethodCallbackRuntimeImpl)classInfo).setMethod(javaClassName,methodName,exportMethod,(NativeMethodSignatureRuntimeImpl)sig);
    }      
}
