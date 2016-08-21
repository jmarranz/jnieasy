/*
 * NativeCapableEnhancerImpl.java
 *
 * Created on 16 de marzo de 2005, 16:48
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeClassDescriptor;


public class NativeCapableEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeCapableEnhancerImpl 
     */
    public NativeCapableEnhancerImpl()
    {
    }

    public static void finalizeRegistration(NativeClassDescriptor classInfo)
    {
        ((JavaClassAsNativeCapableRuntimeImpl)classInfo).finalizeRegistration();        
    }
    
    public static Class getClass(String className,ClassLoader loader)
    {
        return ClassTypeNativeRuntimeImpl.getClass(className,loader, true);
    }    

    public static TypeNative getDefaultType(NativeClassDescriptor classInfo)
    {
        return ((JavaClassAsNativeCapableRuntimeImpl)classInfo).getTypeNativeCapableRuntime();
    }    
    
}
