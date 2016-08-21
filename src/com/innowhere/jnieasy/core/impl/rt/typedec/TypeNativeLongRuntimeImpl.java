/*
 * TypeNativeLongRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeLongImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;
import com.innowhere.jnieasy.core.typedec.TypeNativeLong;

/**
 *
 * @author jmarranz
 */
public class TypeNativeLongRuntimeImpl extends TypeNativeNumberRuntimeImpl implements TypeNativeLong
{
    
    /**
     * Creates a new instance of TypeNativeLongRuntimeImpl
     */
    public TypeNativeLongRuntimeImpl(TypeNativeLongImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
        
    public TypeNativeLongImpl getTypeNativeLong()
    {
        return (TypeNativeLongImpl)typeDec;
    }
    
    public boolean isAddress()
    {
        long size = size();
        return (size == TypeSizes.getADDRESS());
    }
    
    public void setIsAddress()
    {
        setSizeAndPreferredAlignSize(TypeSizes.getADDRESS(), TypeSizes.getADDRESS());
    }
    
    public void pushLong(long value,NativeBufferIteratorImpl memIt)
    {
        // Siempre por valor        
       
        long size = size();        
        if (size == TypeSizes.getIntSize())
        {
            memIt.setInt((int)value);
        }
        else if (size == TypeSizes.getLongSize())
        {
            memIt.setLong(value);
        }
        else // Caso 0
        {
            // Nada
        }
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        pushLong(((Long)value).longValue(),memIt);
        
        return value;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        // Siempre por valor 
        long newVal = 0;
        
        long size = size();
        if (size == TypeSizes.getIntSize())
        {
            newVal = memIt.nextInt();
        }        
        else if (size == TypeSizes.getLongSize())
        {        
            newVal = memIt.nextLong();
        }
        else // Caso 0
        {
            // Nada
        }
        
        return new Long(newVal);
    }     
     
    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        long[] array = (long[])value;
        pushArrayVarArgsIncBufferSize(array.length,memIt);
        for(int i = 0; i < array.length; i++)
            pushLong(array[i],memIt);
    }    
    
    public static boolean checkPositiveSize(long size)
    {
        // Valores válidos: 4, 8
        // 4 para long en plataformas 32 bits y 8 para 64 bits.
        return ((size == TypeSizes.getIntSize()) || 
                (size == TypeSizes.getLongSize()));      
    }   
    
    public static boolean checkPositiveAlignSize(long size)
    {
        return checkPositiveSize(size);
    }
    
    public long getFieldLong(int fieldIndex,long offset,long currValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();
        if (size == TypeSizes.getIntSize())            
        {
            return stateMgr.getInt(fieldIndex,offset);         
        }
        else if (size == TypeSizes.getLongSize())
        {
            return stateMgr.getLong(fieldIndex,offset);            
        }
        else // Caso 0
        {
            return currValue;
        }
    }    
    
    public void setFieldLong(int fieldIndex,long offset,long newValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();
        if (size == TypeSizes.getIntSize())            
        {
            stateMgr.setInt(fieldIndex,offset,(int)newValue);            
        }    
        else if (size == TypeSizes.getLongSize())
        {
            stateMgr.setLong(fieldIndex,offset,newValue);
        }
        else // Caso 0
        {
            // Nada
        }
    }          
    
    public void getFieldLongArray(long[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getIntSize())            
        {
            int len = value.length;
            int[] valueTmp = new int[len];
            stateMgr.getIntArray(0,valueTmp);
            for(int i = 0; i < len; i++)
                value[i] = valueTmp[i];
        }
        else if (size == TypeSizes.getLongSize())     
        {
            stateMgr.getLongArray(0,value);
        }
        else // Caso 0
        {
            // Nada
        }
    }    
    
    public void setFieldLongArray(long[] newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {       
        long size = size();
        
        if (size == TypeSizes.getIntSize())            
        {            
            int len = newValue.length;
            int[] newValueTmp = new int[len];
            for(int i = 0; i < len; i++)
                newValueTmp[i] = (int)newValue[i];
            ((NativePrimitiveArrayStateManagerImpl)stateMgr).setIntArray(0,newValueTmp);                     
        }   
        else if (size == TypeSizes.getLongSize()) 
        {
            stateMgr.setLongArray(0,newValue);        
        }
        else // Caso 0
        {
            // Nada
        }
    }    
    
    public long getFieldLongArray(int index,long[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {     
        long size = size();
        
        long res = 0;        
        if (size == TypeSizes.getIntSize())            
        {
            res = stateMgr.getIntArray(0,index);
        }        
        else if (size == TypeSizes.getLongSize()) 
        {
            res = stateMgr.getLongArray(0,index);            
        }
        else // Caso 0
        {
            if (value != null)
                res = value[index];
        }            

        return res;
    }

    public void setFieldLongArray(int index,long newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getIntSize())            
        {
            stateMgr.setIntArray(0,index,(int)newValue); 
        }        
        else if (size == TypeSizes.getLongSize()) 
        {
            stateMgr.setLongArray(0,index,newValue);
        }
        else // Caso 0
        {
            // Nada
        }
    }    
}
