/*
 * TypeNativeObjectArrayRuntimeImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;


public abstract class TypeNativeObjectArrayRuntimeImpl extends TypeNativeArrayRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeObjectArrayRuntimeImpl
     */   
    public TypeNativeObjectArrayRuntimeImpl(TypeNativeObjectArrayImpl typeDec,Class javaClass,VarTypeNativeRuntimeImpl varTypeDecCompRt,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,varTypeDecCompRt,isPrimary,ctx);
    }    

    public Object pushVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        RuntimeContext ctx = getDefaultRuntimeContext();
        Object[] array = (Object[])value;
        VarTypeNativeRuntimeImpl[] varTypes = new VarTypeNativeRuntimeImpl[array.length];
        long sizeInc = 0;
        for(int i = 0; i < array.length; i++)
        {
            VarTypeNativeRuntimeImpl defaultVarType = VarTypeNativeRuntimeImpl.getDefaultAssociatedType(array[i],true,ctx);
            sizeInc += defaultVarType.stackSize();
            varTypes[i] = defaultVarType;
        }
        
        NativeBufferImpl buffer = (NativeBufferImpl)memIt.getBuffer();
        buffer.realloc(buffer.size() + sizeInc);        
        
        Object[] arrayUsed = new Object[array.length];
        for(int i = 0; i < array.length; i++)
        {        
            arrayUsed[i] = varTypes[i].push(array[i],memIt);
        }
        
        return arrayUsed;
    }
        
    public void unwrapVarArgs(Object arg,Object argUsed)
    {
        Object[] argArray = (Object[])arg;
        Object[] argArrayUsed = (Object[])argUsed;
                    
        for(int i = 0; i < argArray.length; i++)
        {
            Object argVarArg = argArray[i];
            Object argVarArgUsed = argArrayUsed[i];
            if ((argVarArgUsed != null) && (argVarArg != argVarArgUsed))
                argArray[i] = ((CanBeNativeCapableInternal)argVarArgUsed).getValue();
        }    
    }
}
