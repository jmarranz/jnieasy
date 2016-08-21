/*
 * NativeFieldMethodDefaultImpl.java
 *
 * Created on 8 de marzo de 2006, 13:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeFieldMethod;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;

/**
 *
 * @author jmarranz
 */
public abstract class NativeFieldMethodDefaultImpl extends NativeBehaviorDefaultImpl implements NativeFieldMethod
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of NativeFieldMethodDefaultImpl */
    public NativeFieldMethodDefaultImpl()
    {
    }
    
    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)getBehaviorSignature();
    }        
    
    public Object jnieasyGetDefaultReturnValue()
    {
        NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)getBehaviorSignature();
        return sig.getDefaultReturnValue();
    }    
}
