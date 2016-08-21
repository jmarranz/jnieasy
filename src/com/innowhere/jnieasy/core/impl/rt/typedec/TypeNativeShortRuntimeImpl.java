/*
 * TypeNativeShortRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeShortImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;


/**
 *
 * @author jmarranz
 */
public class TypeNativeShortRuntimeImpl extends TypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeShortRuntimeImpl
     */
    public TypeNativeShortRuntimeImpl(TypeNativeShortImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }       
    
    public void pushShort(short value,NativeBufferIteratorImpl memIt)
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
        pushShort(((Short)value).shortValue(),memIt);
        
        return value;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        short newVal = 0;
        
        long size = size();
        if (size > 0)
        {        
            newVal = (short)memIt.nextAddress();
        }
        else // Caso 0
        {
            // Nada
        }        

        return new Short(newVal);
    }
    
    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        short[] array = (short[])value;
        pushArrayVarArgsIncBufferSize(array.length,memIt);
        for(int i = 0; i < array.length; i++)
            pushShort(array[i],memIt);
    }    
    
    public static boolean checkPositiveSize(long size)
    {
        // Único valor válido: el natural de Java
        return (size == TypeSizes.getShortSize());
    }    
    
    public static boolean checkPositiveAlignSize(long size)
    {
        return checkPositiveSize(size);
    }
    
    public short getFieldShort(int fieldIndex,long offset,short currValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getShortSize())
        {
            return stateMgr.getShort(fieldIndex,offset);            
        }
        else // Caso 0
        {
            return currValue;
        }        
    }    
    
    public void setFieldShort(int fieldIndex,long offset,short newValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getShortSize())            
        {
            stateMgr.setShort(fieldIndex,offset,newValue);            
        }    
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void getFieldShortArray(short[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getShortSize())
        {
            stateMgr.getShortArray(0,value);
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void setFieldShortArray(short[] newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {       
        long size = size();

        if (size == TypeSizes.getShortSize()) 
        {
            stateMgr.setShortArray(0,newValue);        
        }
        else // Caso 0
        {
            // Nada
        }         
    }    
    
    public short getFieldShortArray(int index,short[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {     
        long size = size();
        
        short res = 0;
        if (size == TypeSizes.getShortSize())
        {
            res = stateMgr.getShortArray(0,index);
        }
        else // Caso 0
        {
            if (value != null)
                res = value[index];
        }   
        
        return res;
    }

    public void setFieldShortArray(int index,short newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getShortSize())
        {
            stateMgr.setShortArray(0,index,newValue);     
        }
        else // Caso 0
        {
            // Nada
        }
    }    
}
