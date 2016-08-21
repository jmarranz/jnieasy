/*
 * TypeNativeIntegerRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeIntegerImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;


/**
 *
 * @author jmarranz
 */
public class TypeNativeIntegerRuntimeImpl extends TypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeIntegerRuntimeImpl
     */
    public TypeNativeIntegerRuntimeImpl(TypeNativeIntegerImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    
    public void pushInt(int value,NativeBufferIteratorImpl memIt)
    {
        long size = size();        
        if (size == TypeSizes.getIntSize())
        {
            memIt.setInt(value);
        }
        else // Caso 0
        {
            // Nada
        }              
    }    
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        pushInt(((Integer)value).intValue(),memIt);
        
        return value;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        int newVal = 0;
        
        long size = size();
        if (size == TypeSizes.getIntSize())
        {
            newVal = memIt.nextInt();
        }        
        else // Caso 0
        {
            // Nada
        }        
                
        return new Integer(newVal);
    }        

    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        int[] array = (int[])value;
        pushArrayVarArgsIncBufferSize(array.length,memIt);
        for(int i = 0; i < array.length; i++)
            pushInt(array[i],memIt);
    }
    
    
    public static boolean checkPositiveSize(long size)
    {
        // Valores válidos: 4 el natural de Java
        // No consideramos valores superiores aunque el int en alguna
        // plataforma sea de 64 bits porque desbordaría el int Java,
        // usar el long Java con diferentes tamaños de memoria.
        return (size == TypeSizes.getIntSize());      
    }
    
    public static boolean checkPositiveAlignSize(long size)
    {
        return checkPositiveSize(size);
    }
    
    public int getFieldInt(int fieldIndex,long offset,int currValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getIntSize())
        {
            return stateMgr.getInt(fieldIndex,offset);
        }
        else // Caso 0
        {
            return currValue;
        }
    }    
    
    public void setFieldInt(int fieldIndex,long offset,int newValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getIntSize())            
        {
            stateMgr.setInt(fieldIndex,offset,newValue);            
        }    
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void getFieldIntegerArray(int[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getIntSize())
        {
            stateMgr.getIntArray(0,value);
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void setFieldIntegerArray(int[] newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {       
        long size = size();

        if (size == TypeSizes.getIntSize()) 
        {
            stateMgr.setIntArray(0,newValue);        
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public int getFieldIntegerArray(int index,int[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {     
        long size = size();
        
        int res = 0;
        if (size == TypeSizes.getIntSize())
        {
            res = stateMgr.getIntArray(0,index);
        }
        else // Caso 0
        {
            if (value != null)
                res = value[index];
        }        

        return res;
    }

    public void setFieldIntegerArray(int index,int newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getIntSize())
        {
            stateMgr.setIntArray(0,index,newValue);     
        }
        else // Caso 0
        {
            // Nada
        }
    }    

}
