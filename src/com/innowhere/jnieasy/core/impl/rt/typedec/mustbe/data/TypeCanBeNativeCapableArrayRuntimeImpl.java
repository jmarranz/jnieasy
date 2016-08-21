/*
 * ObjectArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;

public abstract class TypeCanBeNativeCapableArrayRuntimeImpl extends TypeNativeObjectArrayRuntimeImpl
{
    
    /** Creates a new instance of ObjectArrayType */
    public TypeCanBeNativeCapableArrayRuntimeImpl(TypeCanBeNativeCapableArrayImpl typeDec,Class javaClass,VarTypeNativeRuntimeImpl varTypeDecCompRt,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,varTypeDecCompRt,isPrimary,ctx);
    }    
}
