/*
 * CPPConstructor.java
 *
 * Created on 11 de febrero de 2004, 20:54
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.DLLBehaviorStateManagerOtherImpl;

/**
 *
 * @author  jmarranz
 */

public class CPPConstructorImpl extends DLLBehaviorImpl implements CPPConstructor
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    public CPPConstructorImpl() 
    {
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
   
    public Object jnieasyNewInstance()
    {
        return new CPPConstructorImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new CPPConstructorImpl[len];
    }     
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new DLLBehaviorStateManagerOtherImpl();
    }     
}
