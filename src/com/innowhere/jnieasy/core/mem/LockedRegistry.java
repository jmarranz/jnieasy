/*
 * LockedRegistry.java
 *
 * Created on 22 de abril de 2005, 14:31
 */

package com.innowhere.jnieasy.core.mem;

import java.util.*;

/**
 * <code>LockedRegistry</code> is a simple wrapper of a synchronized <code>java.util.HashSet</code> 
 * collection; it is included as a utility and can be easily replaced with your own. 
 * Is useful to lock native objects created in the Java side and used in native code,
 * usually to lock returned objects of Java exported methods as native (callbacks) and 
 * invoked from native code (or from Java but using a native call). 
 * <p>
 * When locking, object is inserted in the internal collection using a strong reference 
 * and saved of the garbage collector, otherwise the returned object without strong 
 * references may be destroyed at any time and related native memory freed, it may
 * cause unpredictable behavior in the native side (invalid pointers etc). 
 * When unlocking, if the object has not more strong references, 
 * it can be garbage collected and memory native freed, unlocking can be seen then as an 
 * asynchronous C free or C++ delete.
 * <p>
 * Locking/unlocking does not modify the native state of the objects, use 
 * {@link NativeManager#makeNative(Object)} and 
 * {@link NativeManager#free(Object)} too to take total control (in a deterministic way)
 * of native memory lifecycle.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.JNIEasy#getLockedRegistry()
 */

public interface LockedRegistry
{
    /**
     * Returns true if the internal collection contains the specified object (is locked).
     * 
     * @param obj the object to look for.
     * @return <code>true</code> is the object was locked.
     */
    public boolean isLocked(Object obj);
    
    /**
     * Inserts the specified object in the internal collection, holding it with 
     * a strong reference.
     *
     * @param obj the object to lock.
     * @return <code>true</code> is the object was not locked before.
     */
    public boolean lock(Object obj);
    
    /**
     * Remove the specified object of the internal collection, if the object has not 
     * more references can be garbage collected and its native memory freed.
     *
     * @param obj the object to unlock.
     * @return <code>true</code> is the object was locked.
     */   
    public boolean unlock(Object obj);
    
    /**
     * Unlocks all locked objects removing then from the internal collection.
     */       
    public void unlockAll();
    //public Collection getLocked();
    
    /**
     * Returns the number of locked objects. Locked native objects may involve 
     * memory leaks (Java and native).
     *
     * @return the number of locked objects.
     */           
    public int count();
}
