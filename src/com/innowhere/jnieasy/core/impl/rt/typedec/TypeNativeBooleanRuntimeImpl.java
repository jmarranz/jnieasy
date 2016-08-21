/*
 * TypeNativeBooleanRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBooleanImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;


/**
 *
 * @author jmarranz
 */
public class TypeNativeBooleanRuntimeImpl extends TypeNativePrimitiveRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeBooleanRuntimeImpl
     */
    public TypeNativeBooleanRuntimeImpl(TypeNativeBooleanImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public void pushBoolean(boolean value,NativeBufferIteratorImpl memIt)
    {
        long size = size();
        if (size > 0)
        {
            // Escribimos un entero (y no un byte) pues el push de código máquina 
            // no escribe tamaños más pequeños.
            memIt.setAddress(value ? 1 : 0);
        }
        else // Caso 0
        {
            // Nada
        }
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        pushBoolean(((Boolean)value).booleanValue(),memIt);
        
        return value;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        boolean newVal = false;

        long size = size();
        if (size > 0)
        {        
            newVal = (memIt.nextAddress() != 0);
        }
        else // Caso 0
        {
            // Nada
        }
        
        return Boolean.valueOf(newVal);
    }    
    

    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        boolean[] array = (boolean[])value;
        pushArrayVarArgsIncBufferSize(array.length,memIt);
        for(int i = 0; i < array.length; i++)
            pushBoolean(array[i],memIt);
    }
    
    public static boolean checkPositiveSize(long size)
    {
        // Valores válidos: 1, 4, 8
        // El 4 y el 8 es por ejemplo cuando el booleano se identifica con BOOL de
        // Windows por ejemplo que se define como int (4 bytes en 32 bits y 64 bits plataformas, pero por si acaso permitimos 8 bytes para plataformas con int de 64 bits)
        // No hay problema de desbordamiento pues apenas se usa el primer bit
        return ((size == TypeSizes.getBooleanSize()) || 
                (size == TypeSizes.getIntSize()) || 
                (size == TypeSizes.getLongSize()));      
    }    
    
    public static boolean checkPositiveAlignSize(long size)
    {
        return checkPositiveSize(size);
    }
    
    public boolean getFieldBoolean(int fieldIndex,long offset,boolean currValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getBooleanSize())
        {
            return stateMgr.getBoolean(fieldIndex,offset);
        }
        else if (size == TypeSizes.getIntSize())            
        {
            return stateMgr.getInt(fieldIndex,offset) != 0;         
        }
        else if (size == TypeSizes.getLongSize())
        {
            return stateMgr.getLong(fieldIndex,offset) != 0;            
        }
        else // Caso 0
        {
            return currValue;
        }        
    }    
    
    public void setFieldBoolean(int fieldIndex,long offset,boolean newValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();

        if (size == TypeSizes.getBooleanSize())            
        {
            stateMgr.setBoolean(fieldIndex,offset,newValue);
        }         
        else if (size == TypeSizes.getIntSize())            
        {
            stateMgr.setInt(fieldIndex,offset,newValue ? 1 : 0);            
        }    
        else if (size == TypeSizes.getLongSize())
        {
            stateMgr.setLong(fieldIndex,offset,newValue ? 1 : 0);
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void getFieldBooleanArray(boolean[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getBooleanSize())
        {
            stateMgr.getBooleanArray(0,value);
        }
        if (size == TypeSizes.getIntSize())            
        {
            int len = value.length;
            int[] valueTmp = new int[len];
            stateMgr.getIntArray(0,valueTmp);
            for(int i = 0; i < len; i++)
                value[i] = (valueTmp[i] != 0);
        }
        else if (size == TypeSizes.getLongSize())     
        {
            int len = value.length;
            long[] valueTmp = new long[len];
            stateMgr.getLongArray(0,valueTmp);
            for(int i = 0; i < len; i++)
                value[i] = (valueTmp[i] != 0);
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void setFieldBooleanArray(boolean[] newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {       
        long size = size();

        if (size == TypeSizes.getBooleanSize())
        {
           stateMgr.setBooleanArray(0,newValue);                    
        }
        else if (size == TypeSizes.getIntSize())            
        {
            int len = newValue.length;
            int[] newValueTmp = new int[len];
            for(int i = 0; i < len; i++)
                newValueTmp[i] = newValue[i]? 1 : 0;
            stateMgr.setIntArray(0,newValueTmp);
        }   
        else if (size == TypeSizes.getLongSize()) 
        {
            int len = newValue.length;
            long[] newValueTmp = new long[len];
            for(int i = 0; i < len; i++)
                newValueTmp[i] = newValue[i]? 1 : 0;
            stateMgr.setLongArray(0,newValueTmp);
        }
        else // Caso 0
        {
            // Nada
        }                
    }    
    
    public boolean getFieldBooleanArray(int index,boolean[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {     
        long size = size();
        
        boolean res = false;        
        if (size == TypeSizes.getBooleanSize())
        {
            res = stateMgr.getBooleanArray(0,index);
        }
        if (size == TypeSizes.getIntSize())            
        {
            res = stateMgr.getIntArray(0,index) != 0;
        }        
        else if (size == TypeSizes.getLongSize()) 
        {
            res = stateMgr.getLongArray(0,index) != 0;            
        }
        else // Caso 0
        {
            if (value != null)
                res = value[index];
        }     
        

        return res;
    }

    public void setFieldBooleanArray(int index,boolean newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getBooleanSize())
        {
            stateMgr.setBooleanArray(0,index,newValue);
        }
        if (size == TypeSizes.getIntSize())            
        {
            stateMgr.setIntArray(0,index,newValue ? 1 : 0); 
        }        
        else if (size == TypeSizes.getLongSize()) 
        {
            stateMgr.setLongArray(0,index,newValue ? 1 : 0);
        }
        else // Caso 0
        {
            // Nada
        }
    }    
}
