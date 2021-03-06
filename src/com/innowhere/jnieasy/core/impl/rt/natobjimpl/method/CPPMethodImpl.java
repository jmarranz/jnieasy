/*
 * CPPMethod.java
 *
 * Created on 11 de febrero de 2004, 21:49
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceMethodSignatureRuntimeImpl;

/**
 *
 * @author  jmarranz
 */

public class CPPMethodImpl extends DLLMethodImpl implements CPPMethod
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    public CPPMethodImpl() 
    {
    }
    
    public NativeInstanceMethodSignature getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignature)getBehaviorSignature();
    }

    public NativeInstanceMethodSignatureRuntimeImpl jnieasyGetInstanceMethodSignatureRuntime()
    {
        return (NativeInstanceMethodSignatureRuntimeImpl)getBehaviorSignature();
    }
  
    public Object call(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().call(this,jnieasyGetAddress(),obj,args);
    }
    
    public void callVoid(Object obj,Object[] args)
    {
        jnieasyGetInstanceMethodSignatureRuntime().callVoid(this,jnieasyGetAddress(),obj,args);
    }    

    public boolean callBoolean(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callBoolean(this,jnieasyGetAddress(),obj,args);
    }        
    
    public byte callByte(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callByte(this,jnieasyGetAddress(),obj,args);
    }        
    
    public char callChar(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callChar(this,jnieasyGetAddress(),obj,args);
    }        
    
    public short callShort(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callShort(this,jnieasyGetAddress(),obj,args);
    }        

    public int callInt(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callInt(this,jnieasyGetAddress(),obj,args);
    }        
 
    public long callLong(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callLong(this,jnieasyGetAddress(),obj,args);
    }        
 
    public float callFloat(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callFloat(this,jnieasyGetAddress(),obj,args);
    }        
    
    public double callDouble(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callDouble(this,jnieasyGetAddress(),obj,args);
    }        
    
    public Object callObject(Object obj,Object[] args)
    {
        return jnieasyGetInstanceMethodSignatureRuntime().callObject(this,jnieasyGetAddress(),obj,args);
    }        
   
    public Object jnieasyNewInstance()
    {
        return new CPPMethodImpl();
    }   
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new CPPMethodImpl[len];
    }     
        
}
