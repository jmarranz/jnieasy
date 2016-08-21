/*
 * TypeNativeMemberReflectionRuntimeImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeAccessibleReflectionObjectRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeMemberReflectionWrapperRuntimeImpl;
import java.lang.reflect.Field;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;
import java.lang.reflect.Member;

public abstract class TypeNativeMemberReflectionRuntimeImpl extends TypeCanBeNativeCapableRuntimeImpl implements TypeAccessibleReflectionObjectRuntime
{
   
    /**
     * Creates a new instance of TypeNativeMemberReflectionRuntimeImpl
     */
    public TypeNativeMemberReflectionRuntimeImpl(TypeNativeMemberReflectionImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }    
    
    public static TypeNativeMemberReflectionRuntimeImpl newTypeNativeMemberReflectionRuntime(Member value,RuntimeContext ctx)    
    {
        if (value instanceof Field)
            return TypeNativeFieldMethodReflectionRuntimeImpl.newTypeNativeFieldMethodReflectionRuntime((Field)value,ctx);
        else
            return TypeNativeBehaviorReflectionRuntimeImpl.newTypeNativeBehaviorReflectionRuntime(value,ctx);
    }
    
    public TypeNativeMemberReflectionWrapperRuntimeImpl getTypeNativeMemberWrapperRuntime()
    {
        return (TypeNativeMemberReflectionWrapperRuntimeImpl)getTypeCanBeNativeCapableWrapperRuntime();
    }
   
    public long calcPreferredAlignSize()
    {
        return getClassTypeRuntime().getPreferredAlignSize();
    }    
          
    public Object newValueInternal()
    {
        return getClassTypeNativeObjectRuntime().newValue();
    }

}
