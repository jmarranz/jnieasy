/*
 * TypeNativeDoubleRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeDoubleImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePrimitiveArrayStateManagerImpl;


/**
 *
 * @author jmarranz
 */
public class TypeNativeDoubleRuntimeImpl extends TypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeDoubleRuntimeImpl
     */
    public TypeNativeDoubleRuntimeImpl(TypeNativeDoubleImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public void pushDouble(double value,NativeBufferIteratorImpl memIt)
    {
        long size = size();        
        if (size == TypeSizes.getDoubleSize())
        {
            memIt.setDouble(value);
        }
        else // Caso 0
        {
            // Nada
        }   
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        pushDouble(((Double)value).doubleValue(),memIt);
        
        return value;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        double newVal = 0;
        
        long size = size();
        if (size == TypeSizes.getDoubleSize())
        {
            newVal = memIt.nextDouble();
        }        
        else // Caso 0
        {
            // Nada
        }        
        
        return new Double(newVal);
    }        
    
    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        double[] array = (double[])value;
        pushArrayVarArgsIncBufferSize(array.length,memIt);
        for(int i = 0; i < array.length; i++)
            pushDouble(array[i],memIt);
    }
    
    public static boolean checkPositiveSize(long size)
    {
        // Único valor válido: el natural de Java
        return (size == TypeSizes.getDoubleSize());
    }        
    
    public static boolean checkPositiveAlignSize(long size)
    {
        // Admitimos el natural de Java y también 4 bytes por el 
        // alineamiento de double como field en los viejos i386
        // (pero que produce problemas de rendimiento en Pentium)
        return (size == TypeSizes.getIntSize()) ||
               (size == TypeSizes.getDoubleSize());
    }
    
    public double getFieldDouble(int fieldIndex,long offset,double currValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getDoubleSize())
        {
            return stateMgr.getDouble(fieldIndex,offset);            
        }
        else // Caso 0
        {
            return currValue;
        }
    }    
    
    public void setFieldDouble(int fieldIndex,long offset,double newValue,NativeFieldContainerStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getDoubleSize())            
        {
            stateMgr.setDouble(fieldIndex,offset,newValue);            
        }    
        else // Caso 0
        {
            // Nada
        }
    }    
    
    public void getFieldDoubleArray(double[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getDoubleSize())
        {
            stateMgr.getDoubleArray(0,value);
        }
        else // Caso 0
        {
            // Nada
        }        
    }    
    
    public void setFieldDoubleArray(double[] newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {       
        long size = size();
        
        if (size == TypeSizes.getDoubleSize()) 
        {
            stateMgr.setDoubleArray(0,newValue);        
        }
        else // Caso 0
        {
            // Nada
        }
    }    
    
    public double getFieldDoubleArray(int index,double[] value,NativePrimitiveArrayStateManagerImpl stateMgr)
    {     
        long size = size();
        
        double res = 0;
        if (size == TypeSizes.getDoubleSize())
        {
            res = stateMgr.getDoubleArray(0,index);
        }
        else // Caso 0
        {
            if (value != null)
                res = value[index];
        }        

        return res;
    }

    public void setFieldDoubleArray(int index,double newValue,NativePrimitiveArrayStateManagerImpl stateMgr)
    {
        long size = size();
        
        if (size == TypeSizes.getDoubleSize())
        {
            stateMgr.setDoubleArray(0,index,newValue);     
        }
        else // Caso 0
        {
            // Nada
        }
    }    
}
