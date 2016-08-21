/*
 * TypeNativeByteRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeByteImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;


/**
 *
 * @author jmarranz
 */
public class TypeNativeByteRuntimeImpl extends TypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeByteRuntimeImpl
     */
    public TypeNativeByteRuntimeImpl(TypeNativeByteImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public void pushByte(byte value,NativeBufferIteratorImpl memIt)
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
        pushByte(((Byte)value).byteValue(),memIt);
        
        return value;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        byte newVal = 0;
        
        long size = size();
        if (size > 0)
        {        
            newVal = (byte)memIt.nextAddress();
        }
        else // Caso 0
        {
            // Nada
        } 
        
        return new Byte(newVal);
    }            
    
    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        byte[] array = (byte[])value;
        pushArrayVarArgsIncBufferSize(array.length,memIt);
        for(int i = 0; i < array.length; i++)
            pushByte(array[i],memIt);
    }
    
    public static boolean checkPositiveSize(long size)
    {
        // Único valor válido: el natural de Java
        return (size == TypeSizes.getByteSize());
    }    
    
    public static boolean checkPositiveAlignSize(long size)
    {
        return checkPositiveSize(size);
    }
    
    public byte getFieldByte(int fieldIndex,long offset,byte currValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getByteSize())
        {
            return stateMgr.getByte(fieldIndex,offset);            
        }
        else // Caso 0
        {
            return currValue;
        }        
    }    
    
    public void setFieldByte(int fieldIndex,long offset,byte newValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getByteSize())            
        {
            stateMgr.setByte(fieldIndex,offset,newValue);
        }    
        else // Caso 0
        {
            // Nada
        }
    }    
    
    public void getFieldByteArray(byte[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getByteSize())
        {
            stateMgr.getByteArray(0,value);
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void setFieldByteArray(byte[] newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {       
        long size = size();

        if (size == TypeSizes.getByteSize()) 
        {
            stateMgr.setByteArray(0,newValue);        
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public byte getFieldByteArray(int index,byte[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {     
        long size = size();
        
        byte res = 0;
        if (size == TypeSizes.getByteSize())
        {
            res = stateMgr.getByteArray(0,index);
        }
        else // Caso 0
        {
            if (value != null)
                res = value[index];
        }        

        return res;
    }

    public void setFieldByteArray(int index,byte newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getByteSize())
        {
            stateMgr.setByteArray(0,index,newValue);     
        }
        else // Caso 0
        {
            // Nada
        }   
    }    
}
