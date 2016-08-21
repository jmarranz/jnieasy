/*
 * FieldContainerImpl.java
 *
 * Created on 14 de septiembre de 2005, 12:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeFieldContainerInternal;

/**
 *
 * @author jmarranz
 */
public abstract class FieldContainerImpl extends NativeCapableImpl implements NativeFieldContainerInternal
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of FieldContainerImpl */
    public FieldContainerImpl()
    {
    }
    
}
