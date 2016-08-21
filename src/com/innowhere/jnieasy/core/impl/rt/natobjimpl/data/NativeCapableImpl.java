/*
 * NativeCapable.java
 *
 * Created on 8 de enero de 2004, 19:50
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

import java.io.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNative;

/**
 *
 * @author  jmarranz
 */


public abstract class NativeCapableImpl implements NativeCapable,NativeCapableInternal, Serializable, Cloneable
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    // los transient son importantes para serialización
    protected transient NativeStateManagerImpl jnieasyNativeStateManager; // Debe definirse en las clases derivadas
    protected transient TypeNativeCapableRuntimeImpl jnieasyType;
    
    /**
     * Creates a new instance of NativeCapable
     */
    public NativeCapableImpl() 
    {
    }
    
    public NativeStateManager jnieasyGetNativeStateManager()
    {
        return jnieasyNativeStateManager;
    }
    
    public void jnieasySetNativeStateManager(NativeStateManager stateMgr)
    {
        this.jnieasyNativeStateManager = (NativeStateManagerImpl)stateMgr;
    }    
    
    public synchronized long jnieasyGetAddress()
    {
        // Sirve para dar un error elegante de que el objeto no es nativo
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();
        if (stateMgr == null)
            throw new JNIEasyException("Object is not native " + this);
        return stateMgr.getBuffer().getValue();
    }    

    public Object jnieasyClone() throws CloneNotSupportedException
    {
        return clone();
    }
    
    public void jnieasySetType(TypeNative typeDec)
    {
        this.jnieasyType = (TypeNativeCapableRuntimeImpl)typeDec;
    }
    
    public TypeNative jnieasyGetType()    
    {
        return jnieasyGetType(this, jnieasyType);
    }
    
    public static TypeNative jnieasyGetType(NativeCapableInternal container,TypeNative typeDec)
    {
        if (typeDec != null) return typeDec;
        else
        {
            // Puede ser null por ejemplo en el caso de objeto "deserializado"
            // de esta manera salimos del paso.
            typeDec = container.jnieasyGetDefaultType();
            container.jnieasySetType(typeDec);
        }
        return typeDec;
    }    
    
    public RuntimeContext jnieasyGetDefaultRuntimeContext()    
    {
        JNIEasyImpl jniEasy = (JNIEasyImpl)JNIEasy.get();
        return jniEasy.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();        
    }

    public void jnieasyInitClass(JNIEasy jnieasy)
    {
        // No hace nada, sólo tiene sentido en clases custom
    }    
}
