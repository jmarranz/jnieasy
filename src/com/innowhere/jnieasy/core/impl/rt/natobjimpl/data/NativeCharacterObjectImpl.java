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
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeCharacterRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



public class NativeCharacterObjectImpl extends NativePrimitiveObjectImpl implements NativeCharacterObject
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Character value = new Character('\0');
    
    /** Creates a new instance of PtrCharacter */
    public NativeCharacterObjectImpl()
    {
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeCharacterRuntimeImpl typeComp = (TypeNativeCharacterRuntimeImpl)jnieasyGetTypeNativePrimitive();
        char newValue = typeComp.getFieldChar(0,0,this.value.charValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
        if (this.value.charValue() != newValue)
            this.value = new Character(newValue);
        return this.value;
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((Character)newValue,stateMgr);

        TypeNativeCharacterRuntimeImpl typeComp = (TypeNativeCharacterRuntimeImpl)jnieasyGetTypeNativePrimitive();
        typeComp.setFieldChar(0,0,((Character)newValue).charValue(),(NativeObjectFieldContainerStateManagerImpl)stateMgr);
    }
    
    public Character getCharacter()
    {
        return (Character)getValue();
    }

    public void setCharacter(Character newValue)
    {   
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeCharacterObjectImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeCharacterObjectImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Character)newValue;            
    }     
}
