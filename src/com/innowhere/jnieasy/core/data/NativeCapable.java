/*
 * NativeCapable.java
 *
 * Created on 14 de febrero de 2004, 15:28
 */

package com.innowhere.jnieasy.core.data;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.TypeNative;

/**
 * The <code>NativeCapable</code> is the interface implemented by 
 * all native capable classes.
 * <p>
 * An object of a class implementing this interface is a "native capable
 * object". This object can be made native using makeNative() and attach()
 * methods of {@link com.innowhere.jnieasy.core.mem.NativeManager} or 
 * used as parameter of methods defined as native or set in fields
 * of other native objects. A native object has an address and occupies
 * some native memory; this native memory is accessible from native world
 * and is synchronized automatically with Java data elements when these
 * elements are accessed.
 * <p>
 * There are two types of NativeCapable based classes: predefined/internal of
 * the framework (using the related interfaces) and user defined native 
 * capable classes previously enhanced (on filesystem or when loading).
 * 
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeCapable
{
    /** 
     * Returns the native state manager instance  that controls this native 
     * capable object instance.
     * <p>
     * If the returned reference is not null, the object is native, else is non-native.
     *
     * @return the state manager instance of this object if native, else null. 
     * @see NativeStateManager#getNativeCapable()
     */            
    public NativeStateManager jnieasyGetNativeStateManager();
    
    /**
     * Returns the type declaration used in this object.
     * <p>
     * If the object is an instance of a user defined native class, and this method
     * is called immediately after the instance creation with 
     * a normal <code>new</code> sentence, the returned type is the default
     * type of the user defined class.
     * <p> 
     * If the object was created using a TypeNative object like
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeObject#newValue()},
     * the returned object is this TypeNative object.
     * <p>
     * The original type is not ever respected: if this instance is referenced 
     * by a native field "by value", the returned type object is the type 
     * of the field declaration.
     * 
     * 
     * 
     * @return the type declaration of this object.
     * @see com.innowhere.jnieasy.core.typedec.NativeClassDescriptor#getType()
     */
    public TypeNative jnieasyGetType();    
}
