/*
 * TypeNativeConstructorReflectionRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeConstructorReflectionRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import java.lang.reflect.Constructor;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeConstructorReflectionImpl;


public class TypeNativeConstructorReflectionRuntimeImpl extends TypeNativeBehaviorReflectionRuntimeImpl implements TypeNativeConstructorReflectionRuntime
{
    /** Creates a new instance of TypeNativeConstructorReflectionRuntimeImpl */
    public TypeNativeConstructorReflectionRuntimeImpl(TypeNativeConstructorReflectionImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
    
    public static TypeNativeConstructorReflectionRuntimeImpl newTypeNativeConstructorReflectionRuntime(Constructor value,RuntimeContext ctx)
    {
        TypeNativeConstructorReflectionRuntimeImpl typeDec = (TypeNativeConstructorReflectionRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(Constructor.class, ctx);
        NativeConstructorSignature sig = ctx.getRuntimeManager().getSignatureManagerRuntime().decConstructor(value);
        typeDec.setConstructorSignature(sig);
        return typeDec;
    }

    
    public NativeConstructorSignature getConstructorSignature()
    {
        return (NativeConstructorSignature)getBehaviorSignature();
    }    
    
    public void setConstructorSignature(NativeConstructorSignature signature)
    {
        setBehaviorSignature(signature);
    }    

    public boolean isObjectKnownSize()
    {
        return true;
    }    
      
    public long calcSize()
    {
        return getClassTypeRuntime().getObjectSize();
    }     
}
