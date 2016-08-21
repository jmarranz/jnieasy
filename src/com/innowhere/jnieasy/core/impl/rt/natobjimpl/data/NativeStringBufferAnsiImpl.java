/*
 * Point.java
 *
 * Created on 28 de noviembre de 2003, 10:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.*;



// Equivale en C a "char* s" apuntando a una cadena

public class NativeStringBufferAnsiImpl extends NativeStringBufferImpl implements NativeStringBufferAnsi
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrByte */
    public NativeStringBufferAnsiImpl()
    {
    }
   
    public long getCharSize()
    {
        return TypeSizes.getByteSize();
    }
    
    public int getEncoding()
    {
        return StringEncoding.ANSI;        
    }

    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        this.value = ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getAnsiStringBuffer(0,0,this.value);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((StringBuffer)newValue,stateMgr);
        ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setAnsiStringBuffer(0,0,(StringBuffer)newValue);        
    }    
    
    public Object jnieasyNewInstance()
    {
        return new NativeStringBufferAnsiImpl();
    }        
            
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringBufferAnsiImpl[len];
    }     

}
