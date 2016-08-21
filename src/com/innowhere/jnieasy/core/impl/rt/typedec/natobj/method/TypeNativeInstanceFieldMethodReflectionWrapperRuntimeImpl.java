/*
 * TypeNativeInstanceFieldMethodReflectionWrapperRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeInstanceFieldMethodReflectionRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceFieldMethodReflectionWrapperImpl;


public class TypeNativeInstanceFieldMethodReflectionWrapperRuntimeImpl extends TypeNativeFieldMethodReflectionWrapperRuntimeImpl implements TypeNativeInstanceFieldMethodReflectionRuntime
{
    /**
     * Creates a new instance of TypeNativeInstanceFieldMethodReflectionWrapperRuntimeImpl
     */
    public TypeNativeInstanceFieldMethodReflectionWrapperRuntimeImpl(TypeNativeInstanceFieldMethodReflectionWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
   
    public NativeBehaviorSignature checkSignature(NativeBehaviorSignature signature)
    {
        return (NativeInstanceFieldMethodSignature)signature;
    }      
    
    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignature)signature;
    }    
    
    public void setInstanceFieldMethodSignature(NativeInstanceFieldMethodSignature signature)
    {
        setBehaviorSignature(signature);
    }

}
