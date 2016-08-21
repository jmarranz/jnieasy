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
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeSingleFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeByteRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeCharacterRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;



public class NativeCharacterImpl extends NativePrimitiveImpl implements NativeCharacter
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected char value;
    
    /** Creates a new instance of PtrInteger */
    public NativeCharacterImpl()
    {
    }
    
    public TypeNativeCharacterRuntimeImpl jnieasyGetFieldTypeNativeCharacter()
    {
        return (TypeNativeCharacterRuntimeImpl)jnieasyGetFieldTypeNativePrimitive();
    }
    
    public char jnieasyGetCharValue(NativeStateManager stateMgr)
    {
        TypeNativeCharacterRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeCharacter();
        this.value = typeDecField.getFieldChar(0,0,this.value,(NativeSingleFieldContainerStateManagerImpl)stateMgr);

        return this.value;
    }

    public void jnieasySetCharValue(char newValue,NativeStateManager stateMgr)
    {
        TypeNativeCharacterRuntimeImpl typeDecField = jnieasyGetFieldTypeNativeCharacter();
        typeDecField.setFieldChar(0,0,newValue,(NativeSingleFieldContainerStateManagerImpl)stateMgr);
        
        this.value = newValue;
    }            
    
    public Object jnieasyGetValue(int fetchMode, Object fetchCtx,NativeStateManager stateMgr)
    {
        return new Character(jnieasyGetCharValue(stateMgr));
    }

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx, Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetCharValue(((Character)newValue).charValue(),stateMgr);
    }        
    
    public synchronized char getCharValue(int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value;
            
        return jnieasyGetCharValue(stateMgr);
    }

    public synchronized void setCharValue(char newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();                       
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            this.value = newValue;
            return;
        }
        
        jnieasySetCharValue(newValue,stateMgr);
    }    
        
    
    public synchronized char getCharValue()
    {
        return getCharValue(NativeManagerImpl.getDefaultFetchMode(this));
    }

    public synchronized void setCharValue(char newValue)
    {
        setCharValue(newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        jnieasyGetCharValue(stateMgr);
    }
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetCharValue(this.value,stateMgr);
    }    
    
    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        jnieasySetCharValue(((NativeCharacterImpl)detachedCopy).value,stateMgr);
    }           
    
    public Object jnieasyGetInternalValue()
    {
        return new Character(value);
    }

    public void jnieasySetInternalValue(Object obj)
    {
        this.value = ((Character)obj).charValue();
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeCharacterImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeCharacterImpl[len];
    }     
        
}
