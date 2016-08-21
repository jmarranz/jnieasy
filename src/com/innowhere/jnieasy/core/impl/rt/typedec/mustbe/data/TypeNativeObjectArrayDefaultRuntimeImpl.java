/*
 * TypeNativeObjectArrayDefaultRuntimeImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeObjectArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;


public class TypeNativeObjectArrayDefaultRuntimeImpl extends TypeNativeObjectArrayRuntimeImpl
{
    /**
     * Creates a new instance of TypeNativeObjectArrayDefaultRuntimeImpl
     */   
    public TypeNativeObjectArrayDefaultRuntimeImpl(TypeNativeObjectArrayDefaultImpl typeDec,Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        super(typeDec,javaClass,varTypeDecCompRt,isPrimary,ctx);
    }
        
}

