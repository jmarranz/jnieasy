/*
 * NativePointerCustomImpl.java
 *
 * Created on 29 de junio de 2005, 19:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeCapableRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public abstract class NativePointerCustomImpl extends NativePointerImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativePointerCustomImpl
     */
    public NativePointerCustomImpl()
    {
    }
    
    public boolean jnieasyNeedAuxObjects()
    {
        // Si el puntero contenido es un NativeCapable no es necesario auxiliar,
        // resto de los casos (VarTypeCanBeNativeCapableRuntimeImpl y VarTypeNativeObjectDefaultRuntimeImpl) sí
        TypeNativePointerRuntimeImpl typeDec = (TypeNativePointerRuntimeImpl)jnieasyGetType();
        return (! (typeDec.getAddressedVarTypeNativeObjectRuntime() instanceof VarTypeNativeCapableRuntimeImpl) );        
    }   

}
