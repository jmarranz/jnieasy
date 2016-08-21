/*
 * DLLMethodImpl.java
 *
 * Created on 17 de septiembre de 2005, 15:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeMethod;
import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;

/**
 *
 * @author jmarranz
 */
public abstract class NativeMethodDefaultImpl extends NativeBehaviorDefaultImpl implements NativeMethod
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of DLLMethodImpl
     */
    public NativeMethodDefaultImpl()
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
}
