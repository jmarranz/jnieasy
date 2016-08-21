/*
 * VarTypeNativePrimitiveRuntimeImpl.java
 *
 * Created on 2 de febrero de 2005, 11:38
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeVoidRuntimeImpl;

public class VarTypeNativePrimitiveRuntimeImpl extends VarTypeNativeRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativePrimitiveRuntimeImpl
     */
    public VarTypeNativePrimitiveRuntimeImpl(VarTypeNativePrimitiveImpl varTypeDec,TypeNativePrimitiveRuntimeImpl typeDecRt)
    {
        super(varTypeDec,typeDecRt);
    }
    
    public TypeNativePrimitiveRuntimeImpl getTypeNativePrimitiveRuntime()
    {
        return (TypeNativePrimitiveRuntimeImpl)typeRt;
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        TypeNativePrimitiveRuntimeImpl typeDecRt = getTypeNativePrimitiveRuntime();
        return typeDecRt.push(value,memIt);
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        TypeNativePrimitiveRuntimeImpl typeDecRt = getTypeNativePrimitiveRuntime();
        return typeDecRt.pop(memIt);
    }
   
    public Object pushVarArgs(Object value,NativeBufferIteratorImpl memIt)
    {
        // Nunca debería llegarse aquí pero por si acaso
        throw new JNIEasyException("A primitive type parameter cannot be a vararg");        
    }     
        
    public void unwrapVarArgs(Object arg,Object argUsed)  
    {
        // Nunca debería llegarse aquí pero por si acaso
        throw new JNIEasyException("A primitive type parameter cannot be a vararg"); 
    }     
    
    public Object unwrap(Object argUsed)
    {
        return argUsed;
    }    
    
    public void checkValue(Object value)
    {
        if (value == null) 
        {
            TypeNativePrimitiveRuntimeImpl typeDecRt = getTypeNativePrimitiveRuntime();
            if (typeDecRt instanceof TypeNativeVoidRuntimeImpl)
                return;  // En el caso de tipo primitivo es válido el nulo (en retorno de función) en el resto de los casos no           
            else 
                throw new JNIEasyException("Primitive value cannot be null, is declared by value");
        }
        super.checkValue(value); // dará error cuando sea necesario
    }         
}
