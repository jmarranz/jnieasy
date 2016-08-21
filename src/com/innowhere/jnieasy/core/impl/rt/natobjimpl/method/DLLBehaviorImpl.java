/*
 * AbstractMethod.java
 *
 * Created on 10 de febrero de 2004, 19:42
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeDLLBehaviorRuntimeImpl;


/**
 *
 * @author  jmarranz
 */

public abstract class DLLBehaviorImpl extends NativeCapableImpl implements DLLBehavior
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos

    /** Creates a new instance of AbstractMethod */   
    public DLLBehaviorImpl() 
    {
    }
    
    public TypeNative jnieasyGetDefaultType()
    {
        throw new JNIEasyException("No default type declaration, missing signature");
    }    
    
    public TypeDLLBehaviorRuntimeImpl jnieasyGetTypeDLLBehaviorRuntime()
    {
        return (TypeDLLBehaviorRuntimeImpl)jnieasyGetType();
    }
    
    public NativeBehaviorSignature getBehaviorSignature()
    {
        TypeDLLBehaviorRuntimeImpl typeDec = jnieasyGetTypeDLLBehaviorRuntime();
        if (typeDec == null) throw new JNIEasyException("Object is not native");
        return typeDec.getBehaviorSignature();
    }

    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // no hay fields para clonar
    }
    
    public long jnieasyGetSize()
    {
        // No conocemos el tamaño en memoria del método nativo, ni falta que hace
        // por eso no devolvemos -1 (desconocido) sino 0 para evitar que se acceda a la memoria
        // y aún así podamos instanciar
        return 0;
    }    
}
