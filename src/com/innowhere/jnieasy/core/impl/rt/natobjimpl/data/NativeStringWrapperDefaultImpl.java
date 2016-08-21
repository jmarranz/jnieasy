/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringWrapperDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;

// Equivale en C a "char* s" apuntando a una cadena

public class NativeStringWrapperDefaultImpl extends NativeStringImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrByte */
    public NativeStringWrapperDefaultImpl()
    {
    }
    
    public int getEncoding()
    {
        TypeNativeStringWrapperDefaultRuntimeImpl typeDec = (TypeNativeStringWrapperDefaultRuntimeImpl)jnieasyGetType();
        return typeDec.getEncoding();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        int encoding = getEncoding();
        if (encoding == StringEncoding.ANSI)
            this.value = ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getAnsiString(0,0,this.value);
        else
            this.value = ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getUnicodeString(0,0,this.value);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((String)newValue,stateMgr);
        int encoding = getEncoding();
        if (encoding == StringEncoding.ANSI)        
            ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setAnsiString(0,0,(String)newValue);       
        else
            ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setUnicodeString(0,0,(String)newValue);
    }
    
    public long getCharSize()
    {
        int encoding = getEncoding();
        if (encoding == StringEncoding.ANSI) 
            return TypeSizes.getByteSize();
        else
            return TypeSizes.getWCharTSize();
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeStringWrapperDefaultImpl();
    }
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringWrapperDefaultImpl[len];
    }     
        
}
