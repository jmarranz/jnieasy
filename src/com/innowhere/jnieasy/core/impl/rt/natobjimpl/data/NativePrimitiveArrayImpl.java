/*
 * NativePrimitiveArrayImpl.java
 *
 * Created on 15 de octubre de 2004, 12:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;

/**
 *
 * @author  jmarranz
 */

public abstract class NativePrimitiveArrayImpl extends NativeArrayImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativePrimitiveArrayImpl
     */
    public NativePrimitiveArrayImpl()
    {
    }
    
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        // no hay fields detachables
    }  

    public Object jnieasyCloneValue(Object valueToClone,Object cloneCtx,NativeStateManager stateMgr)
    {
        try
        {
            return jnieasyCloneArray(valueToClone);
        }
        catch(CloneNotSupportedException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }
    
    public abstract Object jnieasyCloneArray(Object array) throws CloneNotSupportedException;

    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativePrimitiveArrayStateManagerImpl();    
    }    
    

    public boolean jnieasyNeedAuxObjects()
    {
        return false;
    }

    public Object getElement(int[] dims, int dimStart, int fetchMode)
    {
        if ((dims.length - dimStart) != 1) throw new JNIEasyException("Not valid dims - dimStart, dims.length - dimStart must be 1");
        return getElement(dims[dimStart],fetchMode);
    }

    public void setElement(int[] dims, int dimStart,Object newValue, int unFetchMode)
    {
        if ((dims.length - dimStart) != 1) throw new JNIEasyException("Not valid dims - dimStart, dims.length - dimStart must be 1");
        setElement(dims[dimStart],newValue,unFetchMode);
    }    
    
}
