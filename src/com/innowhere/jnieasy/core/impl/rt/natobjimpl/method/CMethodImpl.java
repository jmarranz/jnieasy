
package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method; 

import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticMethodSignatureRuntimeImpl;



public class CMethodImpl extends DLLMethodImpl implements CMethod
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    public CMethodImpl() 
    {
    }   
    
    public NativeStaticMethodSignature getStaticMethodSignature()
    {
        return (NativeStaticMethodSignature)getBehaviorSignature();
    }    

    public NativeStaticMethodSignatureRuntimeImpl jnieasyGetStaticMethodSignatureRuntime()
    {
        return (NativeStaticMethodSignatureRuntimeImpl)getBehaviorSignature();
    }        
    
    public Object call(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().call(this,jnieasyGetAddress(),args);
    }
    
    public void callVoid(Object[] args)
    {
        jnieasyGetStaticMethodSignatureRuntime().callVoid(this,jnieasyGetAddress(),args);
    }

    public boolean callBoolean(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callBoolean(this,jnieasyGetAddress(),args);
    }
    
    public byte callByte(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callByte(this,jnieasyGetAddress(),args);
    }
    
    public char callChar(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callChar(this,jnieasyGetAddress(),args);
    }
    
    public short callShort(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callShort(this,jnieasyGetAddress(),args);
    }

    public int callInt(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callInt(this,jnieasyGetAddress(),args);
    }    
 
    public long callLong(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callLong(this,jnieasyGetAddress(),args);
    }    
 
    public float callFloat(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callFloat(this,jnieasyGetAddress(),args);
    }    
    
    public double callDouble(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callDouble(this,jnieasyGetAddress(),args);
    }   
    
    public Object callObject(Object[] args)
    {
        return jnieasyGetStaticMethodSignatureRuntime().callObject(this,jnieasyGetAddress(),args);
    }    
   
    public Object jnieasyNewInstance()
    {
        return new CMethodImpl();
    }    
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new CMethodImpl[len];
    }     
        
}

