/*
 * NativeDirectConstructorCallbackEnhancerImpl.java
 *
 * Created on 20 de julio de 2005, 21:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeDirectConstructorCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeConstructorSignature;
import com.innowhere.jnieasy.core.typedec.NativeDirectConstructorCallbackDescriptor;

/**
 *
 * @author jmarranz
 */
public class NativeDirectConstructorCallbackEnhancerImpl extends NativeDirectCallbackEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeDirectConstructorCallbackEnhancerImpl
     */
    public NativeDirectConstructorCallbackEnhancerImpl()
    {
    }
    
    public static void addConstructor(NativeDirectConstructorCallbackDescriptor classInfo,String javaClassName,boolean exportMethod,NativeConstructorSignature sig)
    {
        ((JavaClassAsNativeDirectConstructorCallbackRuntimeImpl)classInfo).setConstructor(javaClassName,exportMethod,(NativeConstructorSignatureRuntimeImpl)sig);
    }           
}
