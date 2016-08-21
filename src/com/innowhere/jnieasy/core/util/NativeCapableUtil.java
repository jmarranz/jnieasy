/*
 * NativeCapableUtil.java
 *
 * Created on 27 de febrero de 2004, 12:40
 */

package com.innowhere.jnieasy.core.util;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.mem.NativeBuffer;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.TypeNative;

/**
 * The <code>NativeCapableUtil</code> is a utility class 
 * used to get native information of native capable objects.
 *
 * This class is a shortcut to avoid casting the native object to NativeCapable
 * and get the NativeStateManager object.
 *
 * @author  Jose M. Arranz Santamaria
 * @see NativeCapable
 */
public class NativeCapableUtil
{
   /**
     * Returns true if the specified object is native capable else returns false.
     * <p>
     * An object is native capable if implements the interface 
     * {@link NativeCapable}.
     *
     * @param obj the specified object.
     * @return true if the object is native capable.
     */
    public static boolean isNativeCapable(Object obj)
    {
        return (obj instanceof NativeCapable);
    }    
    
    /**
     * Returns true if the specified object is native else returns false.
     * <p>
     * An object is native if it is native capable and was made native.
     *
     * @param obj the specified object. Can not be null.
     * @return true if the object is native capable.
     */
    public static boolean isNative(Object obj)
    {
        if (obj instanceof NativeCapable)
            return (((NativeCapable)obj).jnieasyGetNativeStateManager() != null);
        return false;
    }
    
    /**
     * Returns the native address of a native object.
     *
     * @param obj the specified native object. Can not be null.
     * @return the native address.
     */
    public static long getAddress(Object obj)
    {
        synchronized(obj)
        {
            NativeManagerImpl.checkNative(obj);
            NativeStateManager stateMgr = ((NativeCapable)obj).jnieasyGetNativeStateManager();
            return stateMgr.getBuffer().getValue();
        }
    }

    /**
     * Returns the native memory size of a native object.
     *
     * @param obj the specified native object. Can not be null.
     * @return the native memory size.
     */    
    public static long sizeOf(Object obj)
    {
        synchronized(obj)
        {
            NativeManagerImpl.checkNative(obj);    
            NativeStateManager stateMgr = ((NativeCapable)obj).jnieasyGetNativeStateManager();            
            return stateMgr.getBuffer().size();
        }
    }        
    
    /**
     * Returns true if the native object is attached to native memory.
     *
     * @param obj the specified native object. Can not be null.
     * @return true if object is attached, false if owns the native memory.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#makeNative(Object).
     */
    public static boolean isAttached(Object obj)
    {
        synchronized(obj)
        {
            NativeManagerImpl.checkNative(obj);  
            NativeStateManager stateMgr = ((NativeCapable)obj).jnieasyGetNativeStateManager();            
            return stateMgr.getBuffer().isAttached();
        }
    }
    
    /**
     * Frees the native object if owns its native memory.
     * <p>
     * If the specified object is not native it does nothing.
     * <p>
     * Current implementation calls 
     * {@link com.innowhere.jnieasy.core.mem.NativeManager#free(Object)}.
     *
     * @param obj the specified native object. Can not be null.
     * @return true is the object was native before calling.
     */    
    public static boolean free(Object obj)
    {
        NativeManagerImpl.checkNativeCapable(obj);        
        synchronized(obj)
        {
            NativeStateManager stateMgr = ((NativeCapable)obj).jnieasyGetNativeStateManager();            
            if (stateMgr == null) return false;
            return stateMgr.getNativeManager().free(obj);
        }
    }
    
    /**
     * Detaches the native object keeping its native memory.
     *
     * Current implementation calls 
     * {@link com.innowhere.jnieasy.core.mem.NativeManager#detach(Object)}.
     *
     * @param obj the specified native object. Can not be null.
     */    
    public static void detach(Object obj)
    {
        synchronized(obj)
        {
            NativeManagerImpl.checkNative(obj);
            NativeStateManager stateMgr = ((NativeCapable)obj).jnieasyGetNativeStateManager();            
            stateMgr.getNativeManager().detach(obj);
        }
    }    
    
    /**
     * Returns the native buffer manager of a native object.
     *
     * @param obj the specified native object. Can not be null.
     * @return the native buffer manager.
     */
    public static NativeBuffer getBuffer(Object obj)
    {
        synchronized(obj)
        {
            NativeManagerImpl.checkNative(obj);
            NativeStateManager stateMgr = ((NativeCapable)obj).jnieasyGetNativeStateManager();            
            return stateMgr.getBuffer();
        }
    }    
    
    /**
     * Returns the native state manager of a native capable object.
     *
     * @param obj the specified native capable object. Can not be null.
     * @return the native state manager, if is not native returns null.
     */
    public static NativeStateManager getNativeStateManager(Object obj)
    {
        NativeManagerImpl.checkNativeCapable(obj);        
        synchronized(obj)
        {        
            return ((NativeCapable)obj).jnieasyGetNativeStateManager();
        }
    }

    /**
     * Returns the native manager managing a native object.
     * <p>
     * In the current implementation, the native manager is a singleton. 
     *
     * @param obj the specified native object. Can not be null.
     * @return the native manager, never is null.
     */        
    public static NativeManager getNativeManager(Object obj)    
    {
        synchronized(obj)
        {        
            NativeManagerImpl.checkNative(obj);  
            NativeStateManager stateMgr = ((NativeCapable)obj).jnieasyGetNativeStateManager();            
            return stateMgr.getNativeManager();   
        }
    }
    
    /**
     * Returns true if the specified native object is inside a native transaction.
     *
     * @param obj the specified native object. Can not be null.
     * @return true if inside a transaction.
     */        
    public static boolean isInsideTxn(Object obj)    
    {
        synchronized(obj)
        {        
            NativeManagerImpl.checkNative(obj);  
            NativeStateManager stateMgr = ((NativeCapable)obj).jnieasyGetNativeStateManager();            
            return stateMgr.isInsideTxn();   
        }
    }    
    
    /**
     * Returns the type declaration instance of a native capable object.      
     * 
     * @param obj the specified native capable object. Can not be null.
     * @return the type declaration of specified object.
     * @see NativeCapable#jnieasyGetType()
     */ 
    public static TypeNative getType(Object obj)
    {
        synchronized(obj)
        {        
            NativeManagerImpl.checkNativeCapable(obj);        
            return ((NativeCapable)obj).jnieasyGetType();
        }
    }

    /**
     * A simple utility to ensure a java.lang.Class is initialized.
     * The initialization of a user defined native capable class is
     * necessary to self-register.
     * <p>
     * Current implementation is:
     * <blockquote>
     * Class.forName(clasz.getName(),true,clasz.getClassLoader());
     * </blockquote>
     *
     * @param clasz the specified Class.
     */    
    public static void initializeClass(Class clasz)
    {
        try
        {
            Class.forName(clasz.getName(),true,clasz.getClassLoader());
        }
        catch(ClassNotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
}
