/*
 * TypeNativeFloatRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeFloatImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;


/**
 *
 * @author jmarranz
 */
public class TypeNativeFloatRuntimeImpl extends TypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeFloatRuntimeImpl
     */
    public TypeNativeFloatRuntimeImpl(TypeNativeFloatImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public void pushFloat(float value,NativeBufferIteratorImpl memIt)
    {
        long size = size();        
        if (size == TypeSizes.getFloatSize())
        {          
            memIt.setFloat(value);
        }
        else // Caso 0
        {
            // Nada
        }        
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        pushFloat(((Float)value).floatValue(),memIt);
        
        return value;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        float newVal = 0;
        
        long size = size();
        if (size == TypeSizes.getFloatSize())
        {
            newVal = memIt.nextFloat();
        }        
        else // Caso 0
        {
            // Nada
        }        
        
        return new Float(newVal);
    }        
    
    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        float[] array = (float[])value;
        pushArrayVarArgsIncBufferSize(array.length,memIt);
        for(int i = 0; i < array.length; i++)
            pushFloat(array[i],memIt);
    }    
    
    public static boolean checkPositiveSize(long size)
    {
        // Sólo permitimos el tamaño del tipo de datos Java
        return (size == TypeSizes.getFloatSize());
    }    
    
    public static boolean checkPositiveAlignSize(long size)
    {
        return checkPositiveSize(size);
    }        
    
    public float getFieldFloat(int fieldIndex,long offset,float currValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();
        if (size == TypeSizes.getFloatSize())
        {
            return stateMgr.getFloat(fieldIndex,offset);            
        }
        else // Caso 0
        {
            return currValue;
        }
    }    
    
    public void setFieldFloat(int fieldIndex,long offset,float newValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();
        if (size == TypeSizes.getFloatSize())            
        {
            stateMgr.setFloat(fieldIndex,offset,newValue);            
        }    
        else // Caso 0
        {
            // Nada
        }
    }    
    
    public void getFieldFloatArray(float[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getFloatSize())
        {
            stateMgr.getFloatArray(0,value);
        }
        else // Caso 0
        {
            // Nada
        }
    }    
    
    public void setFieldFloatArray(float[] newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {       
        long size = size();
        
        if (size == TypeSizes.getFloatSize()) 
        {
            stateMgr.setFloatArray(0,newValue);        
        }
        else // Caso 0
        {
            // Nada
        }
    }    
    
    public float getFieldFloatArray(int index,float[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {     
        long size = size();
        
        float res = 0;        
        if (size == TypeSizes.getFloatSize())
        {
            res = stateMgr.getFloatArray(0,index);
        }
        else // Caso 0
        {
            if (value != null)
                res = value[index];
        }        

        return res;
    }

    public void setFieldFloatArray(int index,float newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getFloatSize())
        {
            stateMgr.setFloatArray(0,index,newValue);     
        }
        else // Caso 0
        {
            // Nada
        }
    }        
    
    
}
