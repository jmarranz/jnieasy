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
import com.innowhere.jnieasy.core.mem.NativeStateManager;


public abstract class NativeStringImpl extends StringBasedImpl implements NativeString
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected String value;
    
    /** Creates a new instance of PtrByte */
    public NativeStringImpl()
    {
    }
    
    public long jnieasyCalcSize(Object newValue)
    {
        long size = getCharSize() * (((String)newValue).length() + 1); // el "+ 1" es por el terminador nulo '\0'        
        return size;
    }

    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (String)newValue;            
    }
    
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // el String no es clonable y es de solo lectura además
    }
        
    public String getString()
    {
        return (String)getValue();
    }

    public void setString(String newValue)
    {
        setValue(newValue);
    }
    
    public Object jnieasyCloneValue(Object valueToClone,Object cloneCtx,NativeStateManager stateMgr)
    {
        // No es necesario clonarlo porque un String es de sólo lectura
        return valueToClone;
    }    
}
