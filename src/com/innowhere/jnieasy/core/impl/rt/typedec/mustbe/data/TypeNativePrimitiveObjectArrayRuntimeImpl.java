/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;

public class TypeNativePrimitiveObjectArrayRuntimeImpl extends TypeCanBeNativeCapableArrayRuntimeImpl
{
    /** Creates a new instance of StringArrayType */       
    public TypeNativePrimitiveObjectArrayRuntimeImpl(TypeNativePrimitiveObjectArrayImpl typeDec,Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        super(typeDec,javaClass,varTypeDecCompRt,isPrimary,ctx);
    }       
}
