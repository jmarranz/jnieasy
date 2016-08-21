/*
 * MethodOfClassRuntimeImpl.java
 *
 * Created on 24 de junio de 2005, 13:42
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.DLLBehavior;
import com.innowhere.jnieasy.core.method.NativeMethod;
import com.innowhere.jnieasy.core.typedec.NativeMethodDescriptor;
import java.lang.reflect.Method;

/**
 *
 * @author jmarranz
 */
public class MethodOfClassRuntimeImpl extends BehaviorOfClassRuntimeImpl implements NativeMethodDescriptor
{
    
    /** Creates a new instance of MethodOfClassRuntimeImpl */
    public MethodOfClassRuntimeImpl(JavaClassAsNativeCapableRuntimeImpl javaClass,MethodOfClassImpl accessObjectOfClass,Method method,NativeMethodSignatureRuntimeImpl sig)
    {
        super(javaClass,accessObjectOfClass,method,sig);
    }
    
    public void init()
    {
        getMethodOfClass().setName(getMethod().getName());
    }
    
    public NativeMethodSignatureRuntimeImpl getMethodSignatureRuntime()
    {
        return (NativeMethodSignatureRuntimeImpl)signature;
    }
    
    public MethodOfClassImpl getMethodOfClass()
    {
        return (MethodOfClassImpl)memberOfClass;
    }
    
    public Method getMethod()
    {
        return (Method)member;
    }
    
    public NativeMethod getNativeMethod()
    {
        return (NativeMethod)getNativeBehavior();
    }
    
    public DLLBehavior newDLLBehavior()    
    {
        String nativeName = getNativeName();
        return getDynamicLibrary().addDLLMethod(nativeName,getMethodSignatureRuntime());
    }
}

    