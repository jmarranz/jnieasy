/*
 * JavaClassAsNativeDirectStaticMethodCallbackRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 11:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectStaticMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectStaticMethodCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectStaticMethodCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeStaticMethodSignature;
import java.lang.reflect.Method;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectStaticMethodCallbackRuntimeImpl extends JavaClassAsNativeDirectMethodCallbackRuntimeImpl implements NativeDirectStaticMethodCallbackDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectStaticMethodCallbackRuntimeImpl
     */
    public JavaClassAsNativeDirectStaticMethodCallbackRuntimeImpl(JavaClassAsNativeDirectStaticMethodCallbackImpl javaClass,ClassTypeNativeDirectStaticMethodCallbackCustomRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
    public NativeStaticMethodSignature getStaticMethodSignature()
    {
        return (NativeStaticMethodSignature)getBehaviorSignature();
    }    
        
    public void setMethod(String containerClassName,String methodName,boolean exportMethod,NativeMethodSignatureRuntimeImpl sig)
    {
        // containerClassName puede ser una clase normal Java que contiene el método al que se refiere la Callback
        
        Class containerClass;
        Method method;
        if (getJavaClass().getName().equals(containerClassName))
        {
            containerClass = getJavaClass();
            method = ((NativeStaticMethodSignatureRuntimeImpl)sig).getMethodNoCheck(containerClass,methodName); // No forzamos la comprobación de que el método deba ser estático porque cuando están en callbacks admitimos que sean no estáticos para permitir la herencia
        }
        else
        {
            containerClass = ClassTypeNativeRuntimeImpl.getClassFromVMClassName(containerClassName,getClassLoader(),true);
            method = ((NativeStaticMethodSignatureRuntimeImpl)sig).getMethod(containerClass,methodName);
        }

        setBehavior(containerClass,method,exportMethod,sig);
    }          
}
