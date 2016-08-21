/*
 * NativeDirectCallbackEnhancerImpl.java
 *
 * Created on 7 de julio de 2005, 21:34
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

import com.innowhere.jnieasy.core.JNIEasy;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.NativeDirectCallbackDescriptor;

/**
 *
 * @author jmarranz
 */
public class NativeDirectCallbackEnhancerImpl extends NativeCapableEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeDirectCallbackEnhancerImpl
     */
    public NativeDirectCallbackEnhancerImpl()
    {
    }
    
    public static NativeDirectCallbackDescriptor initRegistrationNativeDirectCallbackType(NativeCapableInternal factoryInst,int licenseUsedByEnhancer,JNIEasy jnieasy)
    {
        return JavaClassAsNativeDirectCallbackRuntimeImpl.initRegistrationNativeDirectCallbackType(factoryInst,licenseUsedByEnhancer,(JNIEasyImpl)jnieasy);
    }

}
