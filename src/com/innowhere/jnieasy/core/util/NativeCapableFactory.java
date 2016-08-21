/*
 * NativeCapableFactory.java
 *
 * Created on 23 de mayo de 2005, 17:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.util;

import com.innowhere.jnieasy.core.data.CanBeNativeCapable;
import com.innowhere.jnieasy.core.data.NativeBoolean;
import com.innowhere.jnieasy.core.data.NativeByte;
import com.innowhere.jnieasy.core.data.NativeCharacter;
import com.innowhere.jnieasy.core.data.NativeDouble;
import com.innowhere.jnieasy.core.data.NativeFloat;
import com.innowhere.jnieasy.core.data.NativeInteger;
import com.innowhere.jnieasy.core.data.NativeLong;
import com.innowhere.jnieasy.core.data.NativeString;
import com.innowhere.jnieasy.core.data.NativeStringBuffer;
import com.innowhere.jnieasy.core.data.NativePointer;
import com.innowhere.jnieasy.core.data.NativeShort;
import com.innowhere.jnieasy.core.data.NativeStringAnsi;
import com.innowhere.jnieasy.core.data.NativeStringBufferAnsi;
import com.innowhere.jnieasy.core.data.NativeStringBufferUnicode;
import com.innowhere.jnieasy.core.data.NativeStringUnicode;
import com.innowhere.jnieasy.core.typedec.NativeTypeManager;

/**
 * The <code>NativeCapableFactory</code> is the interface used as a shortcut
 * to create native capable objects wrapping other native capable, 
 * or "can be native" objects, or primitive values.
 * 
 * @see com.innowhere.jnieasy.core.JNIEasy#getNativeCapableFactory()
 */
public interface NativeCapableFactory
{
    /**
     * Returns the utility object to declare native types.
     * 
     * 
     * 
     * @return the <code>NativeTypeManager</code> object.
     */        
    public NativeTypeManager getTypeManager();  
    
    /**
     * Wraps the specified "can be native" value inside a native 
     * capable object.
     * <p>
     * The native type used is the default native type of the specified
     * value.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * if (value == null) return null;        
     * TypeCanBeNativeCapable typeDec = (TypeCanBeNativeCapable)getTypeManager().getDefaultType(value);
     * return (CanBeNativeCapable)typeDec.wrapValue(value); 
     * </code></blockquote>
     * For instance:
     * <blockquote><code>
     * NativeCapableFactory factory = JNIEasy.get().getObjectFactory();
     * NativeString obj = (NativeString)factory.wrapValue("Hello");
     * </code></blockquote>
     * 
     * 
     * @param value the object to wrap.
     * @return the native capable object.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#getDefaultType(Object)
     * @see com.innowhere.jnieasy.core.typedec.TypeCanBeNativeCapable#wrapValue(Object)
     */
    public CanBeNativeCapable wrapValue(Object value);
    
    /**
     * Creates a native capable NativePointer object containing the 
     * specified reference as the contained pointer.
     * <p>
     * Current implementation uses the default native type of 
     * the parameter to construct the type of the container pointer.
     * 
     * @param addressed the reference to be addressed. Can not be null.
     * @return the new NativePointer object containing the specified reference.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#getDefaultType(Object)
     * @see com.innowhere.jnieasy.core.typedec.TypeNative#decVarType()
     * @see com.innowhere.jnieasy.core.typedec.VarTypeNative#decPointer()
     * @see com.innowhere.jnieasy.core.typedec.TypeNativeObject#newValue()
     * @see com.innowhere.jnieasy.core.data.NativeSingleFieldContainer#setValue(Object)
     */
    public NativePointer newPointer(Object addressed);
    
    /**
     * Wraps (makes native capable) a String object with a NativeString 
     * wrapper object.
     * <p>
     * This method is a shortcut of 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeString#newString(String)}
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * if (value == null) return null;
     * return getTypeManager().decString().newString(value);
     * </code></blockquote>
     * 
     * 
     * 
     * 
     * @param value the String value to wrap.
     * @return the native capable wrapper object.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#decString()
     */
    public NativeString newString(String value);
    
    /**
     * Wraps (makes native capable) a String object with a NativeStringAnsi
     * wrapper object.
     * <p>
     * This method is a shortcut of 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeStringAnsi#newStringAnsi(String)}
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * if (value == null) return null;
     * return getTypeManager().decStringAnsi().newStringAnsi(value);
     * </code></blockquote>
     * 
     * 
     * @param value the String value to wrap.
     * @return the native capable wrapper object.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#decStringAnsi()
     */    
    public NativeStringAnsi newStringAnsi(String value); 
    
    /**
     * Wraps (makes native capable) a String object with a NativeStringUnicode
     * wrapper object.
     * <p>
     * This method is a shortcut of 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeStringUnicode#newStringUnicode(String)}
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * if (value == null) return null;
     * return getTypeManager().decStringUnicode().newStringUnicode(value);
     * </code></blockquote>
     * 
     * 
     * 
     * 
     * 
     * @param value the String value to wrap.
     * @return the native capable wrapper object.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#decStringUnicode()
     */    
    public NativeStringUnicode newStringUnicode(String value);

    /**
     * Wraps (makes native capable) a StringBuffer object with a NativeStringBuffer
     * wrapper object.
     * <p>
     * This method is a shortcut of 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeStringBuffer#newStringBuffer(StringBuffer)}
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * if (value == null) return null;
     * return getTypeManager().decStringBuffer().newStringBuffer(value);
     * </code></blockquote>
     * 
     * 
     * 
     * 
     * @param value the StringBuffer value to wrap.
     * @return the native capable wrapper object.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#decStringBuffer()
     */    
    public NativeStringBuffer newStringBuffer(StringBuffer value);    
    
    /**
     * Wraps (makes native capable) a StringBuffer object with a NativeStringBufferAnsi
     * wrapper object.
     * <p>
     * This method is a shortcut of 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeStringBufferAnsi#newStringBufferAnsi(StringBuffer)}
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * if (value == null) return null;
     * return getTypeManager().decStringBufferAnsi().newStringBufferAnsi(value);
     * </code></blockquote>
     * 
     * 
     * 
     * 
     * 
     * @param value the StringBuffer value to wrap.
     * @return the native capable wrapper object.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#decStringBufferAnsi()
     */    
    public NativeStringBufferAnsi newStringBufferAnsi(StringBuffer value);
    
    
    /**
     * Wraps (makes native capable) a StringBuffer object with a NativeStringBufferUnicode
     * wrapper object.
     * <p>
     * This method is a shortcut of 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeStringBufferUnicode#newStringBufferUnicode(StringBuffer)}
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * if (value == null) return null;
     * return getTypeManager().decStringBufferUnicode().newStringBufferUnicode(value);
     * </code></blockquote>
     *
     * @param value the StringBuffer value to wrap.
     * @return the native capable wrapper object.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#decStringBufferUnicode()
     */    
    public NativeStringBufferUnicode newStringBufferUnicode(StringBuffer value);    
    
    /**
     * Creates a new native capable boolean object with the specified value.
     *
     * @param value the value to set the new object.
     * @return the new native capable object.
     */
    public NativeBoolean newNativeBoolean(boolean value);
    
    /**
     * Creates a new native capable byte object with the specified value.
     *
     * @param value the value to set the new object.
     * @return the new native capable object.
     */    
    public NativeByte newNativeByte(byte value);
    
    /**
     * Creates a new native capable character object with the specified value.
     *
     * @param value the value to set the new object.
     * @return the new native capable object.
     */
    public NativeCharacter newNativeCharacter(char value);
    
    /**
     * Creates a new native capable short object with the specified value.
     *
     * @param value the value to set the new object.
     * @return the new native capable object.
     */    
    public NativeShort newNativeShort(short value);
    
    /**
     * Creates a new native capable integer object with the specified value.
     *
     * @param value the value to set the new object.
     * @return the new native capable object.
     */    
    public NativeInteger newNativeInteger(int value);
    
    /**
     * Creates a new native capable long object with the specified value.
     *
     * @param value the value to set the new object.
     * @return the new native capable object.
     */    
    public NativeLong newNativeLong(long value);
    
    /**
     * Creates a new native capable float object with the specified value.
     *
     * @param value the value to set the new object.
     * @return the new native capable object.
     */    
    public NativeFloat newNativeFloat(float value);
    
    /**
     * Creates a new native capable double object with the specified value.
     *
     * @param value the value to set the new object.
     * @return the new native capable object.
     */    
    public NativeDouble newNativeDouble(double value);  
    
    
}
