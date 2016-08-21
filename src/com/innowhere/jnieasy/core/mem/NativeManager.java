/*
 * NativeManager.java
 *
 * Created on 26 de febrero de 2004, 12:32
 */

package com.innowhere.jnieasy.core.mem;
import com.innowhere.jnieasy.core.listener.InstanceLifecycleListener;
import com.innowhere.jnieasy.core.txn.NativeTransaction;


/**
 * The <code>NativeManager</code> interface is used to manage 
 * the native lifecycle of native capable objects and some 
 * native memory tasks.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.JNIEasy#getNativeManager()
 */
public interface NativeManager
{
    /**
     * Constant used to specify that the native memory must not be freed when 
     * a native object is being detached.
     *
     * @see #detach(Object,int,boolean)
     */    
    public final int NOT_FREE_MEMORY = 0;
    /**
     * Constant used to specify that the native memory must be freed when 
     * a native object is being detached and owns its native memory.
     *
     * @see #detach(Object,int,boolean)
     */
    public final int FREE_MEMORY = 1;
    /**
     * Constant used to specify that the native memory must be freed unconditionally 
     * when a native object is being detached. 
     * <p> 
     * Native memory is freed even though the native object does not own it.
     * Use this option with care; it is useful if the native memory was created
     * in native code.
     *
     * @see #detach(Object,int,boolean)
     */    
    public final int FORCE_FREE_MEMORY = 2;    
    
    /**
     * Returns the size in bytes of the native platform (size of addresses).
     *
     * @return the size of a native address.
     */
    public int getPlatformAddressSize();    
    
    /**
     * Returns the default fetch mode.
     * <p>
     * Default value is {@link Fetch#FAST}.
     *
     * @return the default fetch mode.
     * @see Fetch
     * @see #setDefaultFetchMode(int)
     * @see com.innowhere.jnieasy.core.data.NativeArray#getElement(int)
     * @see com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#getValue()
     */
    public int getDefaultFetchMode();
    
    /**
     * Sets the default fetch mode.
     * 
     * @param mode the new fetch mode.
     * @see #getDefaultFetchMode()
     */
    public void setDefaultFetchMode(int mode);
    
    /**
     * Returns the default "unfetch" mode.
     * <p>
     * Default value is {@link UnFetch#FAST}.
     *
     * @return the default "unfetch" mode.
     * @see UnFetch
     * @see #setDefaultUnFetchMode(int)
     * @see com.innowhere.jnieasy.core.data.NativeArray#setElement(int,Object)
     * @see com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#setValue(Object)
     */    
    public int getDefaultUnFetchMode();
    
    /**
     * Sets the default "unfetch" mode.
     * 
     * @param mode the new "unfetch" mode.
     * @see #getDefaultUnFetchMode()
     */    
    public void setDefaultUnFetchMode(int mode);    
    
    /**
     * Sets whether the framework must check native operations on runtime.
     * <p>
     * Runtime checking improves reliability of native operations, typical
     * operations like passing parameters on calling native methods 
     * or setting data members of a structure, are checked to verify that 
     * type and native state are valid. These checks expend some time, 
     * on deployment, with reliable code, checking may be disabled.
     *
     * @param check if <code>true</code> instructs the frameworks to check native operations.
     * @see #isRuntimeChecking()
     */
    public void setRuntimeChecking(boolean check);
    /**
     * Return whether the framework must check native operations on runtime. 
     * <p>
     * Returns <code>true</code> by default.
     *
     * @return <code>true</code> if the framework performs runtime checks. 
     * @see #setRuntimeChecking(boolean)
     */    
    public boolean isRuntimeChecking();
    
    /**
     * Creates a new native buffer allocating the amount native memory specified
     * with the <code>size</code> parameter.
     * <p>
     * The returned native buffer owns the native memory.
     *
     * @param size the native memory size to allocate
     * @return a new allocated native buffer. 
     */
    public NativeBuffer allocateBuffer(long size);
    
    /**
     * Creates a new native buffer attached to the native memory starting in
     * the specified <code>address</code> parameter.
     * <p>
     * The returned native buffer does not own the native memory, and there is 
     * no upper limit. This is useful to read data with not known size
     * as C allocated strings.
     * <p>
     * Current implementation calls {@link #attachBuffer(long,long)} with 
     * <code>size</code> equals to -1.
     *
     * @param address the native address to attach
     * @return a new attached native buffer.
     */    
    public NativeBuffer attachBuffer(long address);
    
    /**
     * Creates a new native buffer attached to the native memory starting in
     * the specified <code>address</code> parameter and <code>size</code> bytes.
     * <p>
     * The returned native buffer does not own the native memory and is not 
     * possible to access data upper the address: address + size. 
     * This is useful to read data with known size.
     * <p>
     * If <code>size</code> is -1, memory size is unknown and there is 
     * no checking upper limits.
     *
     * @param address the native address to attach.
     * @param size the native memory size.
     * @return a new attached native buffer.
     * @see #attachBuffer(long)
     */     
    public NativeBuffer attachBuffer(long address,long size); 
    
    /**
     * Creates a new <code>NativeAddress</code> object encapsulating the 
     * native memory address submitted.
     * 
     * 
     * @param address the native address to encapsulate.
     * @return the new NativeAddress object
     */
    public NativeAddress newAddress(long address);
    /**
     * Creates a new <code>NativeAddress</code> object encapsulating the 
     * native memory address and relative offset submitted.
     * <p>
     * The returned NativeAddress object is "attached" to the <code>address</code> object 
     * and native address value is calculated as <code>address.getValue() + offset</code>
     * 
     * 
     * @param address the parent NativeAddress object.
     * @param offset the relative offset to the parent address.
     * @return the new NativeAddress object
     */    
    public NativeAddress newAddress(NativeAddress address,long offset);    
    
    /**
     * Makes the native capable object native, "unfetching" data members 
     * to native memory.
     * <p>
     * Native memory is allocated and object's data members are "unfetched" recursively. 
     * If a member is a persistent capable object (embedded or not) it will be
     * made native and so on. The dependency tree of the object will be made native.
     * Circular dependencies are detected with no problem.
     * <p>
     * Anyway, member objects are made native using different ways:
     * <ul>
     * <li>An embedded object member shares the memory of the parent object, 
     * therefore it will be made native invoking
     * {@link #makeNative(Object,NativeAddress,long)}, using the address of parent 
     * and relative offset of the member data according the native memory 
     * attribute map.
     * <li>A linked (not embedded) object member does not share the memory of
     * the parent object (native memory layout of the member is a pointer), 
     * therefore it will be made native invoking {@link #makeNative(Object)}
     * and its address is copied to the pointer member of the parent.
     * </ul>
     * <p>
     * If the object is already native, it does nothing.
     * <p>
     * The object must be an instance of a native capable class, otherwise an exception
     * is thrown.
     * 
     * 
     * @param obj object instance to make native.
     * @return <code>true</code> if instance was not native before calling.
     * @see #unFetch(Object,int)
     */
    public boolean makeNative(Object obj);
    
    /**
     * Makes the native capable object native, attaching to the native memory address
     * submitted with <code>address</code> and <code>offset</code> parameters
     * and "unfetching" data members to native memory.
     * <p>
     * The main difference with {@link #makeNative(Object)} is that native memory 
     * is not allocated.
     * 
     * 
     * @param obj object instance to make native.
     * @param address native address instance to attach.
     * @param offset relative offset.
     * @return <code>true</code> if instance was not native before calling.
     * @see #attach(Object,NativeAddress,long)
     * @see #newAddress(NativeAddress,long)
     */
    public boolean makeNative(Object obj,NativeAddress address, long offset);
    
    /**
     * Makes the native capable object native, attaching to the native memory address
     * submitted with the <code>address</code> parameter 
     * and "unfetching" data members to native memory.
     * <p>
     * Current implementation is:
     * <blockquote><pre>
     * return makeNative(obj,newAddress(address),0);
     * </pre></blockquote>
     * 
     * 
     * @return <code>true</code> if instance was not native before calling.
     * @see #makeNative(Object,NativeAddress,long)
     * @see #newAddress(long)
     */    
    public boolean makeNative(Object obj,long address);  
    
    /**
     * Attaches the native capable object to the native memory address
     * submitted with <code>address</code> and <code>offset</code> parameters
     * and fetching data members from native memory. The attached object will be native.
     * <p> 
     * 
     * It follows a similar process as {@link #makeNative(Object,NativeAddress,long)}, 
     * with the following differences: native memory is not modified and 
     * is fetched to the Java data members. 
     * <p>
     * Member objects are attached using different ways:
     * <ul>
     * <li>An embedded object member shares the memory of the parent object, 
     * therefore it will be attached invoking
     * {@link #attach(Object,NativeAddress,long)}, using the address of parent 
     * and relative offset of the member data according the native memory 
     * attribute map.
     * <li>A linked (not embedded) object member does not share the memory of
     * the parent object (native memory layout of the member is a pointer), 
     * therefore it will be attached invoking {@link #attach(Object,long)} 
     * using as address the value of the pointer member from native memory.
     * </ul>
     * <p>
     * The dependency tree of the object will be made native.
     * Circular dependencies are detected with no problem.
     * <p>
     * It does nothing if the object is already attached to the submitted 
     * address and offset, otherwise an exception is thrown.
     * 
     * 
     * @param obj object instance to attach.
     * @param address native address instance to attach.
     * @param offset relative offset.
     * @return <code>true</code> if instance was not native before calling.
     * @see #newAddress(NativeAddress,long)
     * @see #fetch(Object,int)
     */        
    public boolean attach(Object obj,NativeAddress address, long offset); 
    
    /**
     * Attaches the native capable object native to the native memory address
     * submitted with <code>address</code> parameter
     * and fetching data members from native memory.
     * <p>
     * Current implementation is:
     * <blockquote><pre>
     * return attach(obj,newAddress(address),0);
     * </pre></blockquote>
     * 
     * 
     * @param obj object instance to attach.
     * @param address native address instance to attach.
     * @return <code>true</code> if instance was not native before calling.
     * @see #attach(Object,NativeAddress,long)
     * @see #newAddress(long)
     */        
    public boolean attach(Object obj,long address);
    
    /**
     * Frees the native object, the native memory is freed if object 
     * owns it.
     * <p>
     * Member embedded objects are freed too, but linked member objects keep
     * as native.
     * <p>
     * A freed object is not native.
     * <p>
     * Current implementation is:
     * <blockquote><pre>
     * return detach(obj,FREE_MEMORY,false);
     * </pre></blockquote>
     *
     * @param obj object instance to free.
     * @return true is the object was native before calling.
     * @see #detach(Object,int,boolean)
     */
    public boolean free(Object obj);  
    
    /**
     * Detaches the native object but not free the native memory.
     * <p>
     * Member embedded objects are detached too, but linked member objects keep
     * as native.
     * <p>
     * A detached object is not native.
     * <p>     
     * Current implementation is:
     * <blockquote><pre>
     * return detach(obj,NOT_FREE_MEMORY,false);
     * </pre></blockquote>
     *
     * @param obj object instance to detach.
     * @return true is the object was native before calling.
     * @see #detach(Object,int,boolean)
     */
    public boolean detach(Object obj);

    /**
     * Detaches the native object.
     * <p>
     * Native memory is freed following the rules of <code>freeMemMode</code> 
     * parameter with values: {@link #NOT_FREE_MEMORY},{@link #FREE_MEMORY},
     * {@link #FORCE_FREE_MEMORY}.
     * <p>
     * Member embedded objects are detached too. If <code>deep</code> parameter 
     * is true, linked member objects are detached too recursively, 
     * using the same <code>freeMemMode</code> and <code>deep</code>
     * parameters. The dependency tree of the object will be detached.
     * Circular dependencies are detected with no problem.
     * <p>
     * If the object is not native does nothing.     
     * <p>
     * A detached object is not native.
     *
     * @param obj object instance to free.
     * @param freeMemMode free memory condition.
     * @param deep true if linked objects must be detached too recursively.
     * @return true is the object was native before calling.
     */    
    public boolean detach(Object obj,int freeMemMode,boolean deep);
    
    /**
     * Makes a detached clone of a native object.
     * <p>
     * The dependency tree (member native objects and relationships) of the 
     * native object is fully cloned, no changes are performed
     * in the original and dependent objects and native memory is not fetched.
     * <p>
     * Circular dependencies are detected with no problem.
     *
     * @param obj native object to clone.
     * @return the cloned object
     * @see #detach(Object)
     * @see #attachCopy(Object,Object)
     */
    public Object detachCopy(Object obj);
    
    /**
     * Copy the content of a non native object to a native object.
     * <p>
     * Both objects must have same type, otherwise an exception is thrown.
     * <p>
     * The non native object is left as is, but member native capable objects 
     * are made native and member of the native object to copy.
     * <p> 
     *
     * @param nativeObj the native object to copy to.
     * @param detachedObj the non native object to copy from.
     * @see #detachCopy(Object)
     */    
    public void attachCopy(Object nativeObj,Object detachedObj);
        
    /**
     * Fetches the native memory data to the native members of the native
     * object synchronizing native memory and "Java memory".
     * <p>
     * Current implementation calls {@link #fetch(Object,int)} with the current
     * default fetch mode.
     *
     * @param obj the native object to fetch.
     * @see #getDefaultFetchMode()
     */    
    public void fetch(Object obj);    
    
    /**
     * Fetches the native memory data to the native members of the native
     * object synchronizing native memory and "Java memory".
     * <p>
     * The <code>mode</code> parameter, with values {@link Fetch#FAST},
     * {@link Fetch#EMBEDDED}, and {@link Fetch#DEEP}, instructs how "deep" 
     * is the fetch.
     *
     * @param obj the native object to fetch.
     * @param mode the fetch mode.
     * @see #unFetch(Object,int)
     */
    public void fetch(Object obj,int mode);
    
    /**
     * "Unfetches" the native members of the native object to the native 
     * memory data, synchronizing native memory and "Java memory".
     * <p>
     * Current implementation calls {@link #unFetch(Object,int)} with the current
     * default "unfetch" mode.
     *
     * @param obj the native object to fetch.
     * @see #getDefaultUnFetchMode()
     */    
    public void unFetch(Object obj);      
    
    /**
     * "Unfetches" the native members of the native object to the native 
     * memory data, synchronizing native memory and "Java memory".
     * <p>
     * The <code>mode</code> parameter, with values {@link UnFetch#FAST},
     * {@link UnFetch#EMBEDDED}, and {@link UnFetch#DEEP}, instructs how "deep" 
     * is the "unfetch".
     *
     * @param obj the native object to "unfetch".
     * @param mode the "unfetch" mode.
     * @see #fetch(Object,int)
     */    
    public void unFetch(Object obj,int mode);
    
    /**
     * Finds the native object with the submitted address in the 
     * native object registry. If found is returned else returns null. 
     * <p>
     * The registry only contains objects that own their native memory. When 
     * a native capable object is made native and owns their native memory,
     * is automatically registered.
     * <p>
     * When the framework needs a native object corresponding to a native address,
     * (for instance a returned address of the invocation of a native method) 
     * always looks in the registry first, if does not exist then creates 
     * a new native object and attach to the address.
     * <p>
     * The insertion in the registry does not prevent that a native object 
     * can be garbage collected. When a native object is garbage collected
     * is removed from the registry automatically.
     * 
     * @param address the native address to look for.
     * @see #getObject(Class,long)
     */
    public Object findObject(long address);
    
    /**
     * Gets the object linked to the submitted address or constructs and attaches
     * a new object if there is no native object in the registry with this address.
     * <p>
     * The <code>cls</code> parameter must be a native capable Class (user defined
     * or framework defined) or a "can be native" class (as primitive wrappers,
     * Java arrays, String etc).
     * <p>
     * If <code>cls</code> is a "can be native" class, the method returns
     * the wrapped object of the native object found in the registry or the 
     * new wrapper object attached to the address, using the method 
     * {@link com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#getValue()}. 
     * This ensures that the returned "can be native" object value
     * is synchronized with the native memory.
     * <p>
     * The returned object is ensured its type of specified Class.
     * <p>
     * If a new object is created, it is created with <code>new</code> 
     * using the default constructor without parameters, reflection is only used
     * with multidimensional Java arrays (for instance int[][].class).
     *
     * @param cls the expected class type of returned object.
     * @param address the native address to look for or attach.
     * @return the object found or created and attached.
     * @see #findObject(long)
     */
    public Object getObject(Class cls,long address);
    
    /**
     * Returns the <code>NativeTransaction</code> manager of the caller thread.
     * 
     * 
     * @return the transaction object.
     */
    public NativeTransaction currentTransaction();
    
    /**
     * Adds the listener instance to the list of lifecycle event listeners.
     * <p>
     * The <code>classes</code> parameter identifies all classes of interest 
     * to the listener.
     * <p>
     * The listener will be called for each event for which it implements 
     * the corresponding listener interface.
     * <p>
     * If the <code>classes</code> parameter is <code>null</code>, events of the listener type 
     * for all native classes will be sent to this listener. 
     *
     * @param listener the lifecycle listener
     * @param classes the classes of interest to the listener 
     * @see #removeInstanceLifecycleListener(InstanceLifecycleListener)
     */   
    public void addInstanceLifecycleListener(InstanceLifecycleListener listener,Class[] classes);
    
    /**
     * Removes the listener instance from the list of lifecycle event listeners.
     *
     * @param listener the listener instance to be removed    
     * @see #addInstanceLifecycleListener(InstanceLifecycleListener,Class[])
     */
    public void removeInstanceLifecycleListener(InstanceLifecycleListener listener);    
}
