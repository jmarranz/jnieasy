/*
 * AbstractPointerValueFactory.java
 *
 * Created on 4 de diciembre de 2003, 11:49
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.*;
import java.lang.ref.*;
import java.util.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;

/**
 *
 * @author  jmarranz
 */

/* 
  En principio se usa el object NativeAddress como clave, sin embargo el registro
  sólo se usa para objectos hechos nativos en Java que poseen su memoria nativa
  por tanto su dirección no va a cambiar, si queremos podemos cambiar el object
  NativeAddress (NativeAddressImpl) por Long a partir del valor devuelto por NativeAddress.getValue()
*/

public class JavaAllocatedObjectRegistry
{
    protected Map objects = new WeakHashMap();

    /** Creates a new instance of AbstractPointerValueFactory */
    public JavaAllocatedObjectRegistry()
    {
    }

    public synchronized int count()
    {
        return objects.size();
    }
    
    public NativeCapableInternal findObject(long address)
    {    
        return findObject(new NativeAddressImpl(address));
    }
    
    public synchronized NativeCapableInternal findObject(NativeAddress address)
    {
        WeakReference ref = (WeakReference)objects.get(address);
        if (ref == null) return null;
        return (NativeCapableInternal)ref.get();        
    }
   
    public synchronized void registerObject(NativeStateManagerImpl stateMgr)
    {
        // Usamos una WeakReference para que la colección no sujete el objeto (la clave es ya una WeakReference)
        NativeCapable obj = stateMgr.getNativeCapable();     
        objects.put(stateMgr.getBuffer(),new WeakReference(obj)); 
    }
    
    public void removeObject(NativeStateManagerImpl ptr)
    {
        removeObject(ptr.getBuffer());
    }
    
    public synchronized void removeObject(NativeAddress address)
    {
        objects.remove(address);
    }    
}
