/*
 * NativeDirectMethodCallbackImpl.java
 *
 * Created on 20 de julio de 2005, 18:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.method.NativeDirectMethodCallback;
import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;

/**
 *
 * @author jmarranz
 */
public abstract class NativeDirectMethodCallbackImpl extends NativeDirectCallbackImpl implements NativeDirectMethodCallback
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeDirectMethodCallbackImpl
     */
    public NativeDirectMethodCallbackImpl()
    {
    }

    public NativeMethodSignature getMethodSignature()
    {
        return (NativeMethodSignature)getBehaviorSignature();        
    }
}
