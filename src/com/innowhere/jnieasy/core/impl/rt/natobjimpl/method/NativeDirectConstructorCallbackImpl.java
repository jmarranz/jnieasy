/*
 * Callback.java
 *
 * Created on 2 de enero de 2004, 11:53
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.statemgr.ConstructorCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.method.*;



public abstract class NativeDirectConstructorCallbackImpl extends NativeDirectCallbackImpl implements NativeDirectConstructorCallback
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
 
    /** Creates a new instance of Callback */
    public NativeDirectConstructorCallbackImpl()
    {
    }
    
    public long jnieasyGetSize()
    {
        return ConstructorCallbackStateManagerImpl.memorySize();
    }

    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new ConstructorCallbackStateManagerImpl();
    }   
    
    public NativeConstructorSignature getConstructorSignature()
    {
        return (NativeConstructorSignature)getBehaviorSignature();
    }    
    
    public NativeConstructorSignatureRuntimeImpl jnieasyGetConstructorSignatureRuntime()
    {
        return (NativeConstructorSignatureRuntimeImpl)getBehaviorSignature();
    }  
    
    public Object call(Object[] args)
    {
        return jnieasyGetConstructorSignatureRuntime().call(this,jnieasyGetAddress(),args);
    }
    
    public void call(Object proxy,Object[] args)
    {
        jnieasyGetConstructorSignatureRuntime().call(this,jnieasyGetAddress(),proxy,args);
    }        

    public Object onCall(Object[] args)
    {
        return jnieasyOnCall(args);
    }
    
    public abstract Object jnieasyOnCall(Object[] args);

}
