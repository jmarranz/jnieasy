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
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeCharacterRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;


public class NativeCharacterArrayImpl extends NativePrimitiveArrayImpl implements NativeCharacterArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected char[] value;
    
    /** Creates a new instance of PtrCharacter */
    public NativeCharacterArrayImpl()
    {
    }

    public TypeNativeCharacterRuntimeImpl jnieasyGetTypeNativeCharacterComponent()
    {
        return (TypeNativeCharacterRuntimeImpl)jnieasyGetTypeNativeRuntimeComponent();
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativeCharacterRuntimeImpl typeDecComp = jnieasyGetTypeNativeCharacterComponent();
        typeDecComp.getFieldCharArray(this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        return this.value;        
    }

    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        super.jnieasySetValue((char[])newValue,stateMgr);              
             
        TypeNativeCharacterRuntimeImpl typeDecComp = jnieasyGetTypeNativeCharacterComponent();
        typeDecComp.setFieldCharArray((char[])newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
    }
    
    public synchronized char getChar(int index,int fetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value[index];
            
        TypeNativeCharacterRuntimeImpl typeDecComp = jnieasyGetTypeNativeCharacterComponent();
        char res = typeDecComp.getFieldCharArray(index,this.value,(NativePrimitiveArrayStateManagerImpl)stateMgr);
                
        if (this.value != null)
            this.value[index] = res; 
        return res;
    }

    public synchronized void setChar(int index,char newValue,int unFetchMode)
    {
        NativePrimitiveArrayStateManagerImpl stateMgr = (NativePrimitiveArrayStateManagerImpl)jnieasyGetNativeStateManager();                                             
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))        
        {
            this.value[index] = newValue;
            return;
        }

        TypeNativeCharacterRuntimeImpl typeDecComp = jnieasyGetTypeNativeCharacterComponent();
        typeDecComp.setFieldCharArray(index,newValue,(NativePrimitiveArrayStateManagerImpl)stateMgr);
        
        if (this.value != null)
            this.value[index] = newValue;
    }

    public synchronized char getChar(int index)
    {    
        return getChar(index,NativeManagerImpl.getDefaultFetchMode(this));
    }
    
    public synchronized void setChar(int index,char newValue)
    {        
        setChar(index,newValue,NativeManagerImpl.getDefaultUnFetchMode(this));
    }
    
    public char[] getCharArray()
    {
        return (char[])getValue();
    }
    
    public void setCharArray(char[] newValue)
    {
        setValue(newValue);
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeCharacterArrayImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeCharacterArrayImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (char[])newValue;            
    }    

    public Object jnieasyCloneArray(Object array) throws CloneNotSupportedException    
    {
        return ((char[])array).clone(); 
    }    
    
    public synchronized int length()
    {
        return ((char[])this.value).length;
    }    
    
    public Object getElement(int index)
    {
        return new Character(getChar(index));
    }
    
    public void setElement(int index, Object value)
    {
        setChar(index,((Character)value).charValue());
    }

    public Object getElement(int index, int fetchMode)
    {
        return new Character(getChar(index,fetchMode));        
    }
    
    public void setElement(int index, Object value, int unFetchMode)
    {
        setChar(index,((Character)value).charValue(),unFetchMode);        
    }    
}
