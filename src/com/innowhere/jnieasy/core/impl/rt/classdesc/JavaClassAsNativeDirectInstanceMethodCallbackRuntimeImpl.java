/*
 * JavaClassAsNativeDirectInstanceMethodCallbackRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 11:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectInstanceMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectInstanceMethodCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectInstanceMethodCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeInstanceFieldMethodSignature;
import com.innowhere.jnieasy.core.typedec.NativeInstanceMethodSignature;
import java.lang.reflect.Method;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectInstanceMethodCallbackRuntimeImpl extends JavaClassAsNativeDirectMethodCallbackRuntimeImpl implements NativeDirectInstanceMethodCallbackDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectInstanceMethodCallbackRuntimeImpl
     */
    public JavaClassAsNativeDirectInstanceMethodCallbackRuntimeImpl(JavaClassAsNativeDirectInstanceMethodCallbackImpl javaClass,ClassTypeNativeDirectInstanceMethodCallbackCustomRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
    public void setMethod(String containerClassName,String methodName,boolean exportMethod,NativeMethodSignatureRuntimeImpl sig)
    {
        // containerClassName también se puede sacar del parámetro sig
        Method method = ((NativeInstanceMethodSignatureRuntimeImpl)sig).getMethod(methodName);
        setBehavior(method.getDeclaringClass(),method,exportMethod, sig);        
    }    

    public NativeInstanceMethodSignature getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignature)getBehaviorSignature();        
    }

}
