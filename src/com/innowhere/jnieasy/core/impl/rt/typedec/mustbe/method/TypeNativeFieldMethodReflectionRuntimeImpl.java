/*
 * TypeNativeFieldMethodReflectionRuntimeImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceFieldMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStaticFieldMethodReflectionRuntime;
import java.lang.reflect.Field;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.InstanceFieldCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.StaticFieldCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;


public class TypeNativeFieldMethodReflectionRuntimeImpl extends TypeNativeBehaviorReflectionRuntimeImpl implements TypeNativeStaticFieldMethodReflectionRuntime,TypeNativeInstanceFieldMethodReflectionRuntime
{
    /**
     * Creates a new instance of TypeNativeFieldMethodReflectionRuntimeImpl
     */
    public TypeNativeFieldMethodReflectionRuntimeImpl(TypeNativeFieldMethodReflectionImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

    public static TypeNativeFieldMethodReflectionRuntimeImpl newTypeNativeFieldMethodReflectionRuntime(Field value,RuntimeContext ctx)    
    {
        TypeNativeFieldMethodReflectionRuntimeImpl typeDec = (TypeNativeFieldMethodReflectionRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(Field.class, ctx);
        NativeFieldMethodSignature sig = ctx.getRuntimeManager().getSignatureManagerRuntime().decFieldMethod(value);
        typeDec.setFieldMethodSignature(sig);
        return typeDec;
    }

    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)getBehaviorSignature();
    }
        
    public void setFieldMethodSignature(NativeFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }
    
    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignature)getBehaviorSignature();
    }
        
    public void setStaticFieldMethodSignature(NativeStaticFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }
    
    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignature)getBehaviorSignature();
    }    
    
    public void setInstanceFieldMethodSignature(NativeInstanceFieldMethodSignature signature)
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
        if (signature instanceof NativeStaticFieldMethodSignatureRuntimeImpl)
            return StaticFieldCallbackStateManagerImpl.memorySize();
        else if (signature instanceof NativeInstanceFieldMethodSignatureRuntimeImpl)
            return InstanceFieldCallbackStateManagerImpl.memorySize();		
        else
            throw new JNIEasyException("INTERNAL ERROR");
    }
      
}
