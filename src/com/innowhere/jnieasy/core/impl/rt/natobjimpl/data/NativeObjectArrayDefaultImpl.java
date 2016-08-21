/*
 * NativeObjectArrayDefaultImpl.java
 *
 * Created on 7 de marzo de 2005, 14:07
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectArrayStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;



public class NativeObjectArrayDefaultImpl extends NativeObjectArrayImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Object[] value;
    
    /**
     * Creates a new instance of NativeObjectArrayDefaultImpl
     */
    public NativeObjectArrayDefaultImpl()
    {
    }
    
    public boolean jnieasyNeedAuxObjects()
    {
        return true; // Puede haber elementos en el array que no sean NativeCapable
    }   
       
    public Object jnieasyNewInstance()
    {
        return new NativeObjectArrayDefaultImpl();
    }
                    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeObjectArrayDefaultImpl[len];
    }     
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Object[])newValue;            
    }           
 
}
