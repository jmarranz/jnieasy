/*
 * AbstractPointerValueFactory.java
 *
 * Created on 4 de diciembre de 2003, 11:49
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.*;
import java.util.*;
import com.innowhere.jnieasy.core.mem.LockedRegistry;
import com.innowhere.jnieasy.core.impl.mem.*;

/**
 *
 * @author  jmarranz
 */

/* Simplemente evita que los objetos bloqueados no se los lleve el GC
 * Evitamos interferir en el equals() y en el hashCode() de la clase del usuario
 * y por eso usamos System.identityHashCode()
 */
 
public class LockedRegistryImpl implements LockedRegistry
{
    protected Set objects = new HashSet();
    
    /** Creates a new instance of AbstractPointerValueFactory */
    public LockedRegistryImpl()
    {
    }

    public synchronized int count()
    {
        return objects.size();
    }
    
    public synchronized boolean isLocked(Object obj)
    {
        return objects.contains(obj);
    }
   
    public synchronized boolean lock(Object obj)
    {
        return objects.add(obj);
    }
    
    public synchronized boolean unlock(Object obj)
    {
        return objects.remove(obj);
    }    
    
    public synchronized void unlockAll()
    {
        objects.clear();
    }
    
    public synchronized Collection getLocked()
    {
        return objects;
    }

}
