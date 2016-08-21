/*
 * Callback.java
 *
 * Created on 2 de enero de 2004, 11:53
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.StaticMethodCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.method.*;

public abstract class NativeDirectStaticMethodCallbackImpl extends NativeDirectMethodCallbackImpl implements NativeDirectStaticMethodCallback
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of Callback */
    public NativeDirectStaticMethodCallbackImpl()
    {
    }    
    
    public long jnieasyGetSize()
    {
        return StaticMethodCallbackStateManagerImpl.memorySize();
    }

    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new StaticMethodCallbackStateManagerImpl();
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

    public Object onCall(Object[] args)
    {
        return jnieasyOnCall(args);
    }
    
    public abstract Object jnieasyOnCall(Object[] args);
    
}
