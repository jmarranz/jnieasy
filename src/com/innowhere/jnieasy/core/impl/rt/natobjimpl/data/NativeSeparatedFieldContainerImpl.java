/*
 * NativeSeparatedFieldContainerImpl.java
 *
 * Created on 13 de octubre de 2005, 19:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.data.NativeSeparatedFieldContainer;

/**
 *
 * @author jmarranz
 */
public abstract class NativeSeparatedFieldContainerImpl extends NativeMultipleFieldContainerImpl implements NativeSeparatedFieldContainer
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeSeparatedFieldContainerImpl
     */
    public NativeSeparatedFieldContainerImpl()
    {
    }
    
}
