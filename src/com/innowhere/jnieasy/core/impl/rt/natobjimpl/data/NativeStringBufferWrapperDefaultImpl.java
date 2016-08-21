/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBufferWrapperDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

// Equivale en C a "char* s" apuntando a una cadena

public class NativeStringBufferWrapperDefaultImpl extends NativeStringBufferImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrByte */
    public NativeStringBufferWrapperDefaultImpl()
    {
    }
    
    public int getEncoding()
    {
        TypeNativeStringBufferWrapperDefaultRuntimeImpl typeDec = (TypeNativeStringBufferWrapperDefaultRuntimeImpl)jnieasyGetType();
        return typeDec.getEncoding();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        int encoding = getEncoding();
        if (encoding == StringEncoding.ANSI)
            this.value = ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getAnsiStringBuffer(0,0,this.value);
        else
            this.value = ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getUnicodeStringBuffer(0,0,this.value);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((StringBuffer)newValue,stateMgr);
        int encoding = getEncoding();
        if (encoding == StringEncoding.ANSI)        
            ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setAnsiStringBuffer(0,0,(StringBuffer)newValue);        
        else
            ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setUnicodeStringBuffer(0,0,(StringBuffer)newValue);        
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
        return new NativeStringBufferWrapperDefaultImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringBufferWrapperDefaultImpl[len];
    }     
        
}
