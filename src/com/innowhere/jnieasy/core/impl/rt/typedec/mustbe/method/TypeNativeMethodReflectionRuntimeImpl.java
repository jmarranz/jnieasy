/*
 * TypeNativeMethodReflectionRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.rt.statemgr.InstanceMethodCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.StaticMethodCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import java.lang.reflect.Method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;


public class TypeNativeMethodReflectionRuntimeImpl extends TypeNativeBehaviorReflectionRuntimeImpl implements TypeNativeStaticMethodReflectionRuntime,TypeNativeInstanceMethodReflectionRuntime
{
    /** Creates a new instance of TypeNativeMethodReflectionRuntimeImpl */
    public TypeNativeMethodReflectionRuntimeImpl(TypeNativeMethodReflectionImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

    public static TypeNativeMethodReflectionRuntimeImpl newTypeNativeMethodReflectionRuntime(Method value,RuntimeContext ctx)
    {
        TypeNativeMethodReflectionRuntimeImpl typeDec = (TypeNativeMethodReflectionRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(Method.class, ctx);
        NativeMethodSignature sig = ctx.getRuntimeManager().getSignatureManagerRuntime().decMethod(value);
        typeDec.setMethodSignature(sig);
        return typeDec;
    }    
    
    public NativeMethodSignature getMethodSignature()
    {
        return (NativeMethodSignature)getBehaviorSignature();
    }
        
    public void setMethodSignature(NativeMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }    
    
    public NativeStaticMethodSignature getStaticMethodSignature()
    {
        return (NativeStaticMethodSignature)getBehaviorSignature();
    }
        
    public void setStaticMethodSignature(NativeStaticMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }
    
    public NativeInstanceMethodSignature getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignature)getBehaviorSignature();
    }    
    
    public void setInstanceMethodSignature(NativeInstanceMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }
 
    public boolean isObjectKnownSize()
    {
        return true;
    }
        
    public long calcSize()
    {
        NativeBehaviorSignatureRuntimeImpl signature = (NativeBehaviorSignatureRuntimeImpl)getBehaviorSignature();
        if (signature instanceof NativeStaticMethodSignatureRuntimeImpl)
            return StaticMethodCallbackStateManagerImpl.memorySize();
        else if (signature instanceof NativeInstanceMethodSignatureRuntimeImpl)
            return InstanceMethodCallbackStateManagerImpl.memorySize();		
        else
            throw new JNIEasyException("INTERNAL ERROR");
    }     

}
