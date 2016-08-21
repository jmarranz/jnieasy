/*
 * MethodDec.java
 *
 * Created on 28 de febrero de 2005, 20:31
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.BehaviorOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.MethodOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import java.lang.reflect.Member;
import java.lang.reflect.Method;



public abstract class MethodOfClassImpl extends BehaviorOfClassImpl
{

    /** Creates a new instance of MethodDec */
    public MethodOfClassImpl(NativeMethodSignatureImpl signature,ClassTypeNativeCapableImpl containerClassType)
    {
        super(signature,containerClassType);
    }

    public static MethodOfClassImpl newMethodOfClass(NativeMethodSignatureImpl sig,ClassTypeNativeCapableImpl containerClassType)
    {
        return (MethodOfClassImpl)sig.newBehaviorOfClass(containerClassType);
    }
        
    public boolean mustHaveName()
    {
        return true;
    }
    
    public NativeMethodSignatureImpl getMethodSignature()
    {
        return (NativeMethodSignatureImpl)signature;
    }    
    
    public BehaviorOfClassRuntimeImpl newBehaviorOfClassRuntime(JavaClassAsNativeCapableRuntimeImpl javaClass,Member member,NativeBehaviorSignatureRuntimeImpl sig) 
    {
        return new MethodOfClassRuntimeImpl(javaClass,this,(Method)member,(NativeMethodSignatureRuntimeImpl)sig);
    }   
}
