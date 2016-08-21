/*
 * TypeNativePrimitiveArrayRuntimeImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;

public class TypeNativePrimitiveArrayRuntimeImpl extends TypeNativeArrayRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativePrimitiveArrayRuntimeImpl
     */
    public TypeNativePrimitiveArrayRuntimeImpl(TypeNativePrimitiveArrayImpl typeDec,Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        super(typeDec,javaClass,varTypeDecCompRt,isPrimary,ctx);
    }        

    public Object pushVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        TypeNativePrimitiveRuntimeImpl typeComp = (TypeNativePrimitiveRuntimeImpl)getComponentDecRuntime().getTypeNativeRuntime();
        typeComp.pushArrayVarArgs(value,memIt);
        return value;
    }
    
    public void unwrapVarArgs(Object arg,Object argUsed)
    {
        // Nada que hacer pues en el caso de un char[] por ejemplo
        // no se utilizan wrappers nativos
    }    
}

