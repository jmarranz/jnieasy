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
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

public abstract class NativeStringBufferImpl extends StringBasedImpl implements NativeStringBuffer
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected StringBuffer value;
    
    /** Creates a new instance of PtrByte */
    public NativeStringBufferImpl()
    {
    }    
   
    public long jnieasyCalcSize(Object newValue)
    {
        // OJO es muy importante diferenciar en un StringBuffer entre el espacio reservado
        // y el número de caracteres almacenados (length())
        // Ej. StringBuffer s = new StringBuffer(100) 
        // s.length() devolvería cero y s.capacity() 100
        // La capacidad es lo más parecido al concepto de buffer que la longitud
        // new StringBuffer(100) es similar a char[100] aunque luego usemos parte del buffer para una cadena usando sprintf
        long size = getCharSize() * (((StringBuffer)newValue).capacity() + 1); // el + 1 es por el terminador nulo '\0'        
        return size;
    }
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (StringBuffer)newValue;            
    }    
    
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        if (this.value != null)
            this.value = new StringBuffer(this.value.toString());
    }
  
    public StringBuffer getStringBuffer()
    {
        return (StringBuffer)getValue();
    }

    public void setStringBuffer(StringBuffer newValue)
    {
        setValue(newValue);
    }
        
    public synchronized char getCharacter(int index,int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return this.value.charAt(index);
        
        int encoding = getEncoding();
        if (encoding == StringEncoding.ANSI)        
            return ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getAnsiStringBufferChar(0,0,this.value,index);        
        else
            return ((NativeObjectFieldContainerStateManagerImpl)stateMgr).getUnicodeStringBufferChar(0,0,this.value,index); 
    }

    public synchronized void setCharacter(int index, char value,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();
        if ((stateMgr == null)||(unFetchMode == Fetch.NONE))
        {
            this.value.setCharAt(index,value);       
            return;
        }
        
        int encoding = getEncoding();
        if (encoding == StringEncoding.ANSI)        
            ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setAnsiStringBufferChar(0,0,this.value,index,value);
        else
            ((NativeObjectFieldContainerStateManagerImpl)stateMgr).setUnicodeStringBufferChar(0,0,this.value,index,value);
    }    
    
    public synchronized char getCharacter(int index)
    {
        int fetchMode = NativeManagerImpl.getDefaultFetchMode(this);
        return getCharacter(index,fetchMode);
    }
    
    public synchronized void setCharacter(int index, char value)
    {
        int unFetchMode = NativeManagerImpl.getDefaultUnFetchMode(this);
        setCharacter(index,value,unFetchMode);
    }
    
    public Object jnieasyCloneValue(Object valueToClone,Object cloneCtx,NativeStateManager stateMgr)
    {
        return new StringBuffer(((StringBuffer)valueToClone).toString());
    }    
}
