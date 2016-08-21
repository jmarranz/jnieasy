/*
 * MethodReflectionWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;
import java.lang.reflect.*;


/**
 *
 * @author  jmarranz
 */



public abstract class NativeMethodReflectionImpl extends NativeBehaviorReflectionImpl implements NativeMethodReflection
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Method value;
    
    /** Creates a new instance of MethodReflectionWrapperImpl */
    public NativeMethodReflectionImpl()
    {
    }
    
    public NativeMethodSignature getMethodSignature()
    {
        return (NativeMethodSignature)getBehaviorSignature();
    }    

    public NativeMethodSignatureRuntimeImpl getMethodSignatureRuntime()
    {
        return (NativeMethodSignatureRuntimeImpl)getBehaviorSignature();
    } 
    
    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        // No hay que hacer nada por el lado nativo (salvo el cast)   
        super.jnieasySetValue((Method)newValue,stateMgr);
    }    
   
    public Method getMethod()
    {
        return (Method)getValue();
    }    
    
    public void setMethod(Method newValue)
    {
        setValue(newValue);
    }
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Method)newValue;            
    }    
}
