/*
 * TypeNativeCharacterRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeCharacterImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;


/**
 *
 * @author jmarranz
 */
public class TypeNativeCharacterRuntimeImpl extends TypeNativePrimitiveRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeCharacterRuntimeImpl
     */
    public TypeNativeCharacterRuntimeImpl(TypeNativeCharacterImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public void pushChar(char value,NativeBufferIteratorImpl memIt)
    {
        long size = size();
        if (size > 0)
        {
            // Escribimos un entero del tamaño del registro pues el push de código máquina 
            // no escribe tamaños más pequeños.
            memIt.setAddress(value);
        }
        else // Caso 0
        {
            // Nada
        }        
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        pushChar(((Character)value).charValue(),memIt);
        
        return value;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        char newVal = 0;
        
        long size = size();
        if (size > 0)
        {        
            newVal = (char)memIt.nextAddress();
        }
        else // Caso 0
        {
            // Nada
        }
        
        return new Character(newVal);
    }         
    
    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        char[] array = (char[])value;
        pushArrayVarArgsIncBufferSize(array.length,memIt);
        for(int i = 0; i < array.length; i++)
            pushChar(array[i],memIt);
    }
    
    public static boolean checkPositiveSize(long size)
    {
        // Valores válidos: 1, 2, 4
        // El 1 es para el char C, el 2 para el wchar_t del C de Windows y el propio char de Java
        // y el 4 para el wchar_t de Linux.
        // En el caso de 4 hay truncamiento respecto al char Java, 
        // pero no es importante pues 2 bytes Unicode representan la inmensa mayoría de los caracteres del mundo
        // los dos superiores no se usarán salvo aplicaciones muy muy raras.
        return ((size == TypeSizes.getByteSize()) || 
                (size == TypeSizes.getCharSize()) || 
                (size == TypeSizes.getIntSize()));
    }    
    
    public static boolean checkPositiveAlignSize(long size)
    {
        return checkPositiveSize(size);
    }
    
    public char getFieldChar(int fieldIndex,long offset,char currValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getByteSize())
        {
            return (char)stateMgr.getByte(fieldIndex,offset);            
        }        
        else if (size == TypeSizes.getCharSize())            
        {
            return stateMgr.getChar(fieldIndex,offset);         
        }        
        else if (size == TypeSizes.getIntSize())            
        {
            return (char)stateMgr.getInt(fieldIndex,offset);         
        }
        else // Caso 0
        {
            return currValue;
        }        
    }    
    
    public void setFieldChar(int fieldIndex,long offset,char newValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getByteSize())            
        {
            stateMgr.setByte(fieldIndex,offset,(byte)newValue);            
        }   
        else if (size == TypeSizes.getCharSize())            
        {
            stateMgr.setChar(fieldIndex,offset,newValue);            
        }        
        else if (size == TypeSizes.getIntSize())            
        {
            stateMgr.setInt(fieldIndex,offset,(int)newValue);            
        }    
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void getFieldCharArray(char[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getByteSize())            
        {
            int len = value.length;
            byte[] valueTmp = new byte[len];
            stateMgr.getByteArray(0,valueTmp);
            for(int i = 0; i < len; i++)
                value[i] = (char)valueTmp[i];
        } 
        else if (size == TypeSizes.getCharSize())            
        {
            stateMgr.getCharArray(0,value);
        }        
        else if (size == TypeSizes.getIntSize())            
        {
            int len = value.length;
            int[] valueTmp = new int[len];
            stateMgr.getIntArray(0,valueTmp);
            for(int i = 0; i < len; i++)
                value[i] = (char)valueTmp[i];
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void setFieldCharArray(char[] newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {       
        long size = size();

        if (size == TypeSizes.getByteSize())            
        {            
            int len = newValue.length;
            byte[] newValueTmp = new byte[len];
            for(int i = 0; i < len; i++)
                newValueTmp[i] = (byte)newValue[i];
            stateMgr.setByteArray(0,newValueTmp);                     
        }         
        else if (size == TypeSizes.getCharSize()) 
        {
            stateMgr.setCharArray(0,newValue); 
        }        
        else if (size == TypeSizes.getIntSize())            
        {            
            int len = newValue.length;
            int[] newValueTmp = new int[len];
            for(int i = 0; i < len; i++)
                newValueTmp[i] = (int)newValue[i];
            stateMgr.setIntArray(0,newValueTmp);
        }   
        else // Caso 0
        {
            // Nada
        }                
    }    
    
    public char getFieldCharArray(int index,char[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {     
        long size = size();
        
        char res = 0;        
        if (size == TypeSizes.getByteSize())
        {
            res = (char)stateMgr.getByteArray(0,index);
        }
        if (size == TypeSizes.getCharSize())
        {
            res = stateMgr.getCharArray(0,index);
        }        
        else if (size == TypeSizes.getIntSize())            
        {
            res = (char)stateMgr.getIntArray(0,index);
        }        
        else // Caso 0
        {
            if (value != null)
                res = value[index];
        }                               

        return res;
    }

    public void setFieldCharArray(int index,char newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getByteSize())
        {
            stateMgr.setByteArray(0,index,(byte)newValue);
        }
        else if (size == TypeSizes.getCharSize()) 
        {
            stateMgr.setCharArray(0,index,newValue);
        }        
        if (size == TypeSizes.getIntSize())            
        {
            stateMgr.setIntArray(0,index,(int)newValue); 
        } 
        else // Caso 0
        {
            // Nada
        }        
    }    
}
