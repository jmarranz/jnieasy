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
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeBehaviorDefaultStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeBehaviorDefaultRuntimeImpl;


/**
 *
 * @author  jmarranz
 */

public abstract class NativeBehaviorDefaultImpl extends NativeCapableImpl implements NativeBehavior
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serializaci�n/deserializaci�n no cambia aunque se recompile la clase y se a�adan nuevos m�todos

    /** Creates a new instance of AbstractMethod */   
    public NativeBehaviorDefaultImpl() 
    {
    }
    
    public TypeNative jnieasyGetDefaultType()
    {
        throw new JNIEasyException("No default type declaration, missing signature");
    }    
    
    public TypeNativeBehaviorDefaultRuntimeImpl jnieasyGetTypeNativeBehaviorDefaultRuntime()
    {
        return (TypeNativeBehaviorDefaultRuntimeImpl)jnieasyGetType();
    }
    
    public NativeBehaviorSignature getBehaviorSignature()
    {
        TypeNativeBehaviorDefaultRuntimeImpl typeDec = jnieasyGetTypeNativeBehaviorDefaultRuntime();
        if (typeDec == null) throw new JNIEasyException("Object is not native");
        return typeDec.getBehaviorSignature();
    }

    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // no hay fields para clonar
    }
    
    public long jnieasyGetSize()
    {
        // No conocemos el tama�o en memoria del m�todo nativo, ni falta que hace
        // por eso no devolvemos -1 (desconocido) sino 0 para evitar que se acceda a la memoria
        // y a�n as� podamos instanciar
        return 0;
    }    
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativeBehaviorDefaultStateManagerImpl();
    }    
}
