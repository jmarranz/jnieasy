/*
 * TypeNativeBehaviorReflectionRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBehaviorReflectionRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeBehaviorReflectionWrapperRuntimeImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeBehaviorReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import java.lang.reflect.Member;


public abstract class TypeNativeBehaviorReflectionRuntimeImpl extends TypeNativeMemberReflectionRuntimeImpl implements TypeNativeBehaviorReflectionRuntime
{
    /** Creates a new instance of TypeNativeBehaviorReflectionRuntimeImpl */
    public TypeNativeBehaviorReflectionRuntimeImpl(TypeNativeBehaviorReflectionImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
        
    public static TypeNativeBehaviorReflectionRuntimeImpl newTypeNativeBehaviorReflectionRuntime(Member value,RuntimeContext ctx)    
    {
        if (value instanceof Constructor)
            return TypeNativeConstructorReflectionRuntimeImpl.newTypeNativeConstructorReflectionRuntime((Constructor)value,ctx);
        else if (value instanceof Method)
            return TypeNativeMethodReflectionRuntimeImpl.newTypeNativeMethodReflectionRuntime((Method)value,ctx);
        return null;
    }
    
    public TypeNativeBehaviorReflectionWrapperRuntimeImpl getTypeNativeBehaviorReflectionWrapperRuntime()
    {
        return (TypeNativeBehaviorReflectionWrapperRuntimeImpl)getTypeCanBeNativeCapableWrapperRuntime();
    }

    public NativeBehaviorSignature getBehaviorSignature()
    {
        return getTypeNativeBehaviorReflectionWrapperRuntime().getBehaviorSignature();
    }
    
    public void setBehaviorSignature(NativeBehaviorSignature signature)
    {
        getTypeNativeBehaviorReflectionWrapperRuntime().setBehaviorSignature(signature);
    }   
    
    public void checkValueNotNull(Object value)
    {
        super.checkValueNotNull(value);
     
        NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)getBehaviorSignature();
        
        sig.checkReflectionObject((Member)value);
    }    
    
    public void checkShared()
    {
        super.checkShared();
        
        NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)getBehaviorSignature();

        if (sig == null)
            throw new JNIEasyException("Method signature is not defined");
    }    
}
