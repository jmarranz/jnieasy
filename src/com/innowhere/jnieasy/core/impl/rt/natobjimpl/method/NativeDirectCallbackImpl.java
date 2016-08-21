/*
 * AbstractMethod.java
 *
 * Created on 10 de febrero de 2004, 19:42
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCapableImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.method.*;


/**
 *
 * @author  jmarranz
 */

public abstract class NativeDirectCallbackImpl extends NativeCapableImpl implements NativeDirectCallback
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of AbstractMethod */
    public NativeDirectCallbackImpl() 
    {
    }    

    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // idem
    }

}
