/*
 * NativeStateManager.java
 *
 * Created on 2 de marzo de 2004, 19:48
 */

package com.innowhere.jnieasy.core.mem;

import com.innowhere.jnieasy.core.data.*;

/**
 * Every native object instance has an internal object implementing 
 * <code>NativeStateManager</code> interface.
 * <p>
 * This NativeStateManager object controls all native operations,
 * that is, any operation with the native instance that modifies or
 * gets data from native memory.
 * <p>
 * The native state manager object of a native instance can be got with 
 * the method {@link NativeCapable#jnieasyGetNativeStateManager()}, but is
 * recommended use {@link com.innowhere.jnieasy.core.util.NativeCapableUtil#getNativeStateManager(Object)}.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeStateManager
{
    /** 
     * Returns the <code>NativeBuffer</code> object representing the native 
     * memory of the native object from which this NativeStateManager comes from.
     * 
     * @return the <code>NativeBuffer</code> of the native object, never is <code>null</code>.
     * @see com.innowhere.jnieasy.core.util.NativeCapableUtil#getBuffer(Object)
     */
    public NativeBuffer getBuffer();
    /**
     * 
     * Returns the native object instance from which this NativeStateManager comes from.
     * <p>
     * The returned object is never null although the object may be non-native. 
     * Be care holding NativeStateManager objects because this prevents 
     * the related object be garbage collected. The framework never holds NativeStateManager
     * objects with strong references.
     * 
     * 
     * @return the managed native object instance.
     * @see NativeCapable#jnieasyGetNativeStateManager()
     */    
    public NativeCapable getNativeCapable();
    /** 
     * Returns the <code>NativeManager</code> object.
     * <p>
     *
     * @return the native manager object. 
     * @see com.innowhere.jnieasy.core.util.NativeCapableUtil#getNativeManager(Object)
     */     
    public NativeManager getNativeManager();
    /** 
     * Returns true is the native object is enrolled in a native transaction.
     * <p>
     *
     * @return true is the native object is inside a native transaction. 
     * @see com.innowhere.jnieasy.core.txn.NativeTransaction
     * @see com.innowhere.jnieasy.core.util.NativeCapableUtil#isInsideTxn(Object)
     */        
    public boolean isInsideTxn();    
}
