/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.*;



// Equivale en C a "char* s" apuntando a una cadena

public class NativeStringBufferUnicodeImpl extends NativeStringBufferImpl implements NativeStringBufferUnicode
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrByte */
    public NativeStringBufferUnicodeImpl()
    {
    }
        
    public long getCharSize()
    {
        return TypeSizes.getWCharTSize();
    }
   
    public int getEncoding()
    {
        return StringEncoding.UNICODE;        
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        this.value = ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getUnicodeStringBuffer(0,0,this.value);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((StringBuffer)newValue,stateMgr);
        ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setUnicodeStringBuffer(0,0,(StringBuffer)newValue);        
    }

    public Object jnieasyNewInstance()
    {
        return new NativeStringBufferUnicodeImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringBufferUnicodeImpl[len];
    }     
        
}
