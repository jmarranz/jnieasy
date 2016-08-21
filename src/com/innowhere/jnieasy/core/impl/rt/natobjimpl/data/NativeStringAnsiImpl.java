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

public class NativeStringAnsiImpl extends NativeStringImpl implements NativeStringAnsi
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of PtrByte */
    public NativeStringAnsiImpl()
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
        this.value = ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getAnsiString(0,0,this.value);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((String)newValue,stateMgr);
        ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setAnsiString(0,0,(String)newValue);
    }    
    
    public Object jnieasyNewInstance()
    {
        return new NativeStringAnsiImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStringAnsiImpl[len];
    }

}
