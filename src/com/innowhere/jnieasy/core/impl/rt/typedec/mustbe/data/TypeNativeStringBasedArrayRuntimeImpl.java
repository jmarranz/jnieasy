/*
 * StringBasedType.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBasedArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;

public class TypeNativeStringBasedArrayRuntimeImpl extends TypeCanBeNativeCapableArrayRuntimeImpl
{
    
    /** Creates a new instance of StringBasedType */
    public TypeNativeStringBasedArrayRuntimeImpl(TypeNativeStringBasedArrayImpl typeDec,Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        super(typeDec,javaClass,varTypeDecCompRt,isPrimary,ctx);
    }    

}
