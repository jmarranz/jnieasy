/*
 * NativeDirectFieldCallbackImpl.java
 *
 * Created on 20 de julio de 2005, 18:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeDirectFieldCallback;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;

/**
 *
 * @author jmarranz
 */
public abstract class NativeDirectFieldCallbackImpl extends NativeDirectCallbackImpl implements NativeDirectFieldCallback
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeDirectFieldCallbackImpl
     */
    public NativeDirectFieldCallbackImpl()
    {
    }
    
    public Object jnieasyGetDefaultReturnValue()
    {
        NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)getBehaviorSignature();
        return sig.getDefaultReturnValue();
    }    
    
    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)getBehaviorSignature();        
    }   
    
}
