/*
 * NativeTypeManager.java
 *
 * Created on 6 de abril de 2005, 18:02
 */

package com.innowhere.jnieasy.core.typedec;

import java.util.Map;

/**
 * The <code>NativeTypeManager</code> is the interface used to declare native
 * types using native capable classes (user defined or predefined).
 * 
 * 
 * @author  Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.JNIEasy#getTypeManager()
 */

public interface NativeTypeManager
{

    /**
     * Returns the utility object to declare native variable types.
     * 
     * @return the <code>NativeVarTypeManager</code> object.
     */    
    public NativeVarTypeManager getVarTypeManager();  
    
    /**
     * Loads and returns the specified class with the <code>ClassLoader</code> 
     * defined in the framework.
     * <p>
     * The <code>className</code> parameter can have Java language syntax,
     * if is useful with array class names like <code>int[]</code> 
     * (<code>Class.forName()</code> methods does not work with this format).
     * 
     * @param className the class name to load.
     * @return the loaded class.
     * @see #getClassLoader()
     */
    public Class getClass(String className);
    
    /**
     * Returns the default <code>ClassLoader</code> currently defined in the framework,
     * to load user native capable and "can be native" capable wrapper classes. 
     * It may be an enhancer <code>ClassLoader</code>.
     * <p>
     * The default <code>ClassLoader</code> is the framework loader. Current implementation
     * returns the <code>ClassLoader</code> of the <code>NativeTypeManager</code> instance).
     * 
     * @return the current framework class loader.
     * @see #setClassLoader(ClassLoader)
     * @see com.innowhere.jnieasy.core.enh.NativeEnhancer#enableOnLoad(String[],String[],ClassLoader)
     */
    public ClassLoader getClassLoader();
    
    /**
     * Defines the default <code>ClassLoader</code> used by the framework to load user 
     * defined native capable and "can be native" wrapper classes
     * 
     * @param loader the new default class loader of the framework.
     * @see #getClassLoader()
    */    
    public void setClassLoader(ClassLoader loader);

    /** 
     * Returns the default memory size of the boolean data type.
     * If not modified by {@link #setDefaultBooleanSize(long)}
     * the default value is the Java standard size: 1 byte.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. 
     *
     * @return the default memory size of the boolean data type.    
     * @see #setDefaultBooleanSize(long)
     */
    public long getDefaultBooleanSize();

    /** 
     * Sets the default memory size of the boolean data type.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. The alignment is set to this value too.
     *
     * Current implementation is:
     * <blockquote><code>
     * setDefaultBooleanSize(size,size);
     * </code></blockquote>
     *     
     * @param size the new memory size.    
     * @see #getDefaultBooleanSize()
     * @see #setDefaultBooleanSize(long,long)
     */  
    public void setDefaultBooleanSize(long size);
    
    /** 
     * Returns the default memory size of the byte data type.
     * If not modified by {@link #setDefaultByteSize(long)}
     * the default value is the Java standard size: 1 byte.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. 
     *
     * @return the default memory size of the byte data type.    
     * @see #setDefaultByteSize(long)
     */
    public long getDefaultByteSize();

    /** 
     * Sets the default memory size of the byte data type.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. The alignment is set to this value too.
     *
     * Current implementation is:
     * <blockquote><code>
     * setDefaultByteSize(size,size);
     * </code></blockquote>
     *     
     * @param size the new memory size.    
     * @see #getDefaultByteSize()
     * @see #setDefaultByteSize(long,long)
     */
    public void setDefaultByteSize(long size);

    /** 
     * Returns the default memory size of the char data type.
     * If not modified by {@link #setDefaultCharSize(long)}
     * the default value is the Java standard size: 2 bytes.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. 
     *
     * @return the default memory size of the char data type.    
     * @see #setDefaultCharSize(long)
     */
    public long getDefaultCharSize();

    /** 
     * Sets the default memory size of the char data type.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. The alignment is set to this value too.
     *
     * Current implementation is:
     * <blockquote><code>
     * setDefaultCharSize(size,size);
     * </code></blockquote>
     *     
     * @param size the new memory size.    
     * @see #getDefaultCharSize()
     * @see #setDefaultCharSize(long,long)
     */
    public void setDefaultCharSize(long size);

    /** 
     * Returns the default memory size of the short data type.
     * If not modified by {@link #setDefaultShortSize(long)}
     * the default value is the Java standard size: 2 bytes.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. 
     *
     * @return the default memory size of the short data type.    
     * @see #setDefaultShortSize(long)
     */
    public long getDefaultShortSize();

    /** 
     * Sets the default memory size of the short data type.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. The alignment is set to this value too.
     *
     * Current implementation is:
     * <blockquote><code>
     * setDefaultShortSize(size,size);
     * </code></blockquote>
     *     
     * @param size the new memory size.    
     * @see #getDefaultShortSize()
     * @see #setDefaultShortSize(long,long)
     */
    public void setDefaultShortSize(long size);
    
    /** 
     * Returns the default memory size of the int data type.
     * If not modified by {@link #setDefaultIntSize(long)}
     * the default value is the Java standard size: 4 bytes.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. 
     *
     * @return the default memory size of the int data type.    
     * @see #setDefaultIntSize(long)
     */
    public long getDefaultIntSize();

    /** 
     * Sets the default memory size of the int data type.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. The alignment is set to this value too.
     *
     * Current implementation is:
     * <blockquote><code>
     * setDefaultIntSize(size,size);
     * </code></blockquote>
     *     
     * @param size the new memory size.    
     * @see #getDefaultIntSize()
     * @see #setDefaultIntSize(long,long)
     */
    public void setDefaultIntSize(long size);

    /** 
     * Returns the default memory size of the long data type.
     * If not modified by {@link #setDefaultLongSize(long)}
     * the default value is the Java standard size: 8 bytes.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. 
     *
     * @return the default memory size of the long data type.    
     * @see #setDefaultLongSize(long)
     */
    public long getDefaultLongSize();

    /** 
     * Sets the default memory size of the long data type.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. The alignment is set to this value too.
     *
     * Current implementation is:
     * <blockquote><code>
     * setDefaultLongSize(size,size);
     * </code></blockquote>
     *     
     * @param size the new memory size.    
     * @see #getDefaultLongSize()
     * @see #setDefaultLongSize(long,long)
     */
    public void setDefaultLongSize(long size);

    /** 
     * Returns the default memory size of the float data type.
     * If not modified by {@link #setDefaultFloatSize(long)}
     * the default value is the Java standard size: 4 bytes.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. 
     *
     * @return the default memory size of the float data type.    
     * @see #setDefaultFloatSize(long)
     */
    public long getDefaultFloatSize();

    /** 
     * Sets the default memory size of the float data type.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. The alignment is set to this value too.
     *
     * Current implementation is:
     * <blockquote><code>
     * setDefaultFloatSize(size,size);
     * </code></blockquote>
     *     
     * @param size the new memory size.    
     * @see #getDefaultFloatSize()
     * @see #setDefaultFloatSize(long,long)
     */
    public void setDefaultFloatSize(long size);

    /** 
     * Returns the default memory size of the double data type.
     * If not modified by {@link #setDefaultDoubleSize(long)}
     * the default value is the Java standard size: 8 bytes.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. 
     *
     * @return the default memory size of the double data type.    
     * @see #setDefaultDoubleSize(long)
     */
    public long getDefaultDoubleSize();

    /** 
     * Sets the default memory size of the double data type.
     * <p>
     * This value is used to calculate the native memory size
     * of native instances. The alignment is set to this value too.
     *
     * Current implementation is:
     * <blockquote><code>
     * setDefaultDoubleSize(size,size);
     * </code></blockquote>
     *     
     * @param size the new memory size.    
     * @see #getDefaultDoubleSize()
     * @see #setDefaultDoubleSize(long,long)
     */
    public void setDefaultDoubleSize(long size);

    /** 
     * Returns the default memory alignment size of the boolean data type.
     * If not modified by {@link #setDefaultBooleanSize(long,long)}
     * the default value is the same as the Java standard memory size.
     * <p>
     * This value is used to calculate the native memory layout and alignment 
     * of native instances. 
     *
     * @return the default alignment size of the boolean data type.    
     * @see #setDefaultBooleanSize(long,long)
     */  
    public long getDefaultBooleanAlignSize();
    
    /** 
     * Sets the default memory and alignment size of the boolean data type.
     * <p>
     * Valid values: 0, 1, 4 and 8.
     * <p>
     * 1 byte is the size of the "bool" C++ data type, 4 and 8 values can
     * be used to represent the C BOOL macro usually defined as an integer data type, 
     * in this case there is no problem of "overflow" converting to the Java boolean, 
     * because only the first byte is used (integer literals 0 and 1).
     * <p>     
     * These values are used to calculate the native memory size and alignment
     * of native instances. 
     *
     * @param size the new memory size.    
     * @param align the new alignment size.       
     * @see #getDefaultBooleanSize()
     * @see #getDefaultBooleanAlignSize()     
     */ 
    public void setDefaultBooleanSize(long size,long align);

    /** 
     * Returns the default memory alignment size of the byte data type.
     * If not modified by {@link #setDefaultByteSize(long,long)}
     * the default value is the same as the Java standard memory size.
     * <p>
     * This value is used to calculate the native memory layout and alignment 
     * of native instances. 
     *
     * @return the default alignment size of the byte data type.    
     * @see #setDefaultByteSize(long,long)
     */
    public long getDefaultByteAlignSize();
    
    /** 
     * Sets the default memory and alignment size of the byte data type.
     * <p>
     * Valid values: 0 and 1
     * <p>     
     * These values are used to calculate the native memory size and alignment
     * of native instances. 
     *
     * @param size the new memory size.    
     * @param align the new alignment size.       
     * @see #getDefaultByteSize()
     * @see #getDefaultByteAlignSize()     
     */  
    public void setDefaultByteSize(long size,long align);    
    
    /** 
     * Returns the default memory alignment size of the char data type.
     * If not modified by {@link #setDefaultCharSize(long,long)}
     * the default value is the same as the Java standard memory size.
     * <p>
     * This value is used to calculate the native memory layout and alignment 
     * of native instances. 
     *
     * @return the default alignment size of the char data type.    
     * @see #setDefaultCharSize(long,long)
     */
    public long getDefaultCharAlignSize();
    
    /** 
     * Sets the default memory and alignment size of the char data type.
     * <p>
     * Valid values: 0, 1, 2 and 4.
     * <p>
     * 1 byte is the size of the C char type,
     * 2 bytes is the wchar_t size in Win32, and 4 bytes is the typical wchar_t size in
     * Linux/Mac/Solaris (the upper 2 bytes are lost when converting to the Java char, but
     * this is not a problem because most of the characters of the world can 
     * be contained in a 2 byte char).
     * <p>
     * These values are used to calculate the native memory size and alignment
     * of native instances. 
     *
     * @param size the new memory size.    
     * @param align the new alignment size.       
     * @see #getDefaultCharSize()
     * @see #getDefaultCharAlignSize()     
     */
    public void setDefaultCharSize(long size,long align);
    
    /** 
     * Returns the default memory alignment size of the short data type.
     * If not modified by {@link #setDefaultShortSize(long,long)}
     * the default value is the same as the Java standard memory size.
     * <p>
     * This value is used to calculate the native memory layout and alignment 
     * of native instances. 
     *
     * @return the default alignment size of the short data type.    
     * @see #setDefaultShortSize(long,long)
     */ 
    public long getDefaultShortAlignSize();
    
    /** 
     * Sets the default memory and alignment size of the short data type.
     * <p>
     * Valid values: 0 and 2.     
     * <p>
     * These values are used to calculate the native memory size and alignment
     * of native instances. 
     *
     * @param size the new memory size.    
     * @param align the new alignment size.       
     * @see #getDefaultShortSize()
     * @see #getDefaultShortAlignSize()     
     */    
    public void setDefaultShortSize(long size,long align);    

    /** 
     * Returns the default memory alignment size of the int data type.
     * If not modified by {@link #setDefaultIntSize(long,long)}
     * the default value is the same as the Java standard memory size.
     * <p>
     * This value is used to calculate the native memory layout and alignment 
     * of native instances. 
     *
     * @return the default alignment size of the int data type.    
     * @see #setDefaultIntSize(long,long)
     */
    public long getDefaultIntAlignSize();
    
    /** 
     * Sets the default memory and alignment size of the int data type.
     * <p>
     * Valid values: 0 and 4.
     * <p>
     * These values are used to calculate the native memory size and alignment
     * of native instances. 
     *
     * @param size the new memory size.    
     * @param align the new alignment size.       
     * @see #getDefaultIntSize()
     * @see #getDefaultIntAlignSize()     
     */
    public void setDefaultIntSize(long size,long align);    
    
    /** 
     * Returns the default memory alignment size of the long data type.
     * If not modified by {@link #setDefaultLongSize(long,long)}
     * the default value is the same as the Java standard memory size.
     * <p>
     * This value is used to calculate the native memory layout and alignment 
     * of native instances. 
     *
     * @return the default alignment size of the long data type.    
     * @see #setDefaultLongSize(long,long)
     */
    public long getDefaultLongAlignSize();
    
    /** 
     * Sets the default memory and alignment size of the long data type.
     * <p>
     * Valid values: 0, 4 and 8.     
     * <p>
     * The long data type is very useful to represent cross platform 
     * addresses because the 4 (32 bit) and 8 (64 bit) bytes are the 
     * typical platform values.
     * <p>
     * These values are used to calculate the native memory size and alignment
     * of native instances. 
     *
     * @param size the new memory size.    
     * @param align the new alignment size.       
     * @see #getDefaultLongSize()
     * @see #getDefaultLongAlignSize()     
     */
    public void setDefaultLongSize(long size,long align);    
    
    /** 
     * Returns the default memory alignment size of the float data type.
     * If not modified by {@link #setDefaultFloatSize(long,long)}
     * the default value is the same as the Java standard memory size.
     * <p>
     * This value is used to calculate the native memory layout and alignment 
     * of native instances. 
     *
     * @return the default alignment size of the float data type.    
     * @see #setDefaultFloatSize(long,long)
     */
    public long getDefaultFloatAlignSize();
    
    /** 
     * Sets the default memory and alignment size of the float data type.
     * <p>
     * Valid values: 0 and 4. 
     * <p>
     * These values are used to calculate the native memory size and alignment
     * of native instances. 
     *
     * @param size the new memory size.    
     * @param align the new alignment size.       
     * @see #getDefaultFloatSize()
     * @see #getDefaultFloatAlignSize()     
     */
    public void setDefaultFloatSize(long size,long align);
    
    /** 
     * Returns the default memory alignment size of the double data type.
     * If not modified by {@link #setDefaultDoubleSize(long,long)}
     * the default value is the same as the Java standard memory size.
     * <p>
     * This value is used to calculate the native memory layout and alignment 
     * of native instances. 
     *
     * @return the default alignment size of the double data type.    
     * @see #setDefaultDoubleSize(long,long)
     */
    public long getDefaultDoubleAlignSize();

    /** 
     * Sets the default memory and alignment size of the double data type.
     * <p>
     * Valid size values: 0 and 8.
     * <p>
     * Valid size values: 0, 4 and 8.
     * <p>
     * These values are used to calculate the native memory size and alignment
     * of native instances. 
     *
     * @param size the new memory size.    
     * @param align the new alignment size.       
     * @see #getDefaultDoubleSize()
     * @see #getDefaultDoubleAlignSize()     
     */
    public void setDefaultDoubleSize(long size,long align);    
    
   
    /** 
     * Returns the default memory size of the chars used in Unicode
     * strings (the native side of String, StringBuffer, and native wrappers declared 
     * as Unicode). The symmetric C type is the wchar_t.
     * <p>
     * If not modified by {@link #setWCharTSize(long)}
     * the returned value is the typical wchar_t size of the runtime platform:
     * in Windows is 2 bytes and in Linux/Mac/Solaris is 4 bytes.
     *
     * @return the default memory size of the chars used in Unicode. 
     * @see #setWCharTSize(long)
     */
    public long getWCharTSize();

    /** 
     * Sets the default memory size of the chars used in Unicode
     * strings (the native side of String, StringBuffer, and native wrappers declared 
     * as Unicode). The symmetric C type is the wchar_t.
     * <p>
     * Valid values are: 0, 2 and 4 bytes.
     * <p>
     * 2 bytes is the typical size of wchar_t in Windows, and 4 bytes in Linux/Mac/Solaris.
     *     
     * @param size the new memory size.    
     * @see #getWCharTSize()
     */
    public void setWCharTSize(long size);
    
    /**
     * Returns the default string encoding (ANSI or UNICODE) when declaring 
     * native strings and no encoding is specified.
     * <p>
     * By default is ANSI.
     *
     * @return the default string encoding.
     * @see StringEncoding#ANSI
     * @see StringEncoding#UNICODE
     * @see #setDefaultStringEncoding(int)
     */
    public int getDefaultStringEncoding();
    
    /**
     * Sets the default string encoding (ANSI or UNICODE) when declaring 
     * native strings and no encoding is specified.
     *
     * @param encoding the new default string encoding.
     * @see StringEncoding#ANSI
     * @see StringEncoding#UNICODE     
     * @see #getDefaultStringEncoding()
     */
    public void setDefaultStringEncoding(int encoding);

    
    /**
     * Returns the current default alignment size applied to field structure 
     * based objects.
     * <p>
     * Native memory of fields of structures, unions, and C++ classes are arranged
     * on native memory using the minimum value of the intrinsic (preferred) 
     * alignment size of the field type, the specific value specified, if any, 
     * on enhancement, and this default value.
     * 
     * 
     * 
     * @return the current default alignment size
     * @see #setStructureAlignSize(long)
     * @see TypeNative#preferredAlignSize()
     * @see #alignSizeOf(Class)
     */
    public long getStructureAlignSize();
    
    /**
     * Sets the current default alignment size applied to field structure 
     * based objects.    
     *
     * @param size the new current default alignment size.
     * @see #getStructureAlignSize()
     */
    public void setStructureAlignSize(long size);
    
    /**
     * Returns the native descriptor of the specified class.
     * <p> 
     * If the <code>clasz</code> parameter is not a user defined Class
     * it returns <code>null</code>.
     *
     * @param clasz the class object to get the native descriptor.
     * @return the native descriptor of the specified class.
     * @see NativeClassDescriptor
     */
    public NativeClassDescriptor getClassDescriptor(Class clasz);
    
    /**
     * Returns the native memory size of an instance of the specified class.
     * <p>
     * If memory size can not be determined using the Class only or is not 
     * a user defined native or predefined native wrapper or a "can be native" class,
     * an exception is thrown.
     * 
     * @param clasz the class object to get the memory size.
     * @return the native memory size.
     * @see TypeNative#size()
     * @see com.innowhere.jnieasy.core.util.NativeCapableUtil#sizeOf(Object)
     */
    public long sizeOf(Class clasz);
    
    /**
     * Returns the preferred alignment size of an instance of the specified class.
     * <p>
     * If alignment size can not be determined using the Class only or is not 
     * a user defined native or a predefined native wrapper or a "can be native" class,
     * an exception is thrown.
     * 
     * @param clasz the class object to get the alignment size.
     * @return the preferred alignment size.
     * @see TypeNative#preferredAlignSize()
     */    
    public long alignSizeOf(Class clasz);
    
    /**
     * Returns the default import declarations used to resolve class names. 
     * <p>
     * By default return null, only "java.lang.*" import is used.
     *
     * @return an String array with the import declarations. Can be null.
     * @see #setDefaultImports(String[])
     */    
    public String[] getDefaultImports();
       
    /**
     * Sets the default import declarations used to resolve class names without package.
     * <p>
     * The <code>importList</code> parameter must be a string array,
     * each string contains an expression following the format of the 
     * parameter of <code>import</code> keyword of Java language.
     * E.g. "java.lang.reflect.*" or "java.lang.reflect.Method".
     * <p>
     * An extension is permitted: the matching expression may be ended with 
     * two asterisks (.**) meaning a recursive tree search, all classes of 
     * package and classes of sub packages are matched. 
     *
     * The import expression "java.lang.*" is ever added by default to mimic 
     * the Java language behavior (resolving String, as java.lang.String etc).
     * If null all classes, except "java.lang.*" classes, must be absolute.
     *
     * @param importList the included list of classes using Java import syntax. Can be null.
     * @see #getDefaultImports()
     */
    public void setDefaultImports(String[] importList);

    /**
     * Returns the value, if set, of the specified macro. 
     * A null value is returned is the macro is not defined, the value
     * of a defined macro can be null too, use {@link #isDefinedMacro(String)}
     * to distinguish these two cases.
     *
     * @param name the macro to look for.
     * @return the value associated to the macro or null.
     * @see #defineMacro(String,Object)
     */
    public Object getMacro(String name);
    
    /**
     * Returns true, if the specified macro was defined. 
     *
     * @param name the macro to look for.
     * @return true if the specified macro was defined.
     * @see #defineMacro(String,Object)
     */    
    public boolean isDefinedMacro(String name);
        
    /**
     * Defines (registers) the specified macro. 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return defineMacro(name,null);
     * </code></blockquote>
     *
     * @param name the macro to look for.
     * @return the previous value associated to this macro or null if was not defined.
     * @see #defineMacro(String,Object)
     */     
    public Object defineMacro(String name);
    
    /**
     * Defines (registers) the specified macro and associated value. 
     * <p>
     * The macro can be used to resolve native names or sizes.
     *
     * @param name the macro to look for.
     * @param value the associated value.
     * @return the previous value associated to this macro or null if was not defined.
     * @see #getMacro(String)
     * @see NativeTypeManager#parseTextWithMacros(String)
     * @see NativeTypeManager#parseNameWithMacros(String)
     */  
    public Object defineMacro(String name,Object value);
    
    /**
     * Removes (unregisters) the specified macro and associated value. 
     *
     * @param name the macro to look for.
     * @return the current value associated to this macro or null if was not defined.
     * @see #defineMacro(String,Object)
     */   
    public Object undefMacro(String name);
    
    /**
     * Returns a Map with the registered macro-value pairs.
     * <p>
     * The returned Map is unmodifiable.
     *
     * @return a Map with the registered macro-value pairs.
     * @see #defineMacro(String,Object)
     */
    public Map getMacros();    
    
    /**
     * Parses the specified expression prefixed with macros, and return the text selected. 
     * <p>
     * This utility is very useful when the text resolved is platform/compiler dependent.
     * <p>
     * The format supported is:
     * <blockquote><code>
     * <i>MacroTextPairDec</i>[;<i>MacroTextPairDec</i>[;<i>MacroTextPairDec</i> ...]]
     * </code></blockquote>
     * 
     * The <i>MacroTextPairDec</i> is defined as:
     * <blockquote><code>
     * [<i>Macro</i>:]<i>Text</i>
     * </code></blockquote>
     *
     * Where <i>Macro</i> is an optional "selector macro" name, if the macro was defined
     * using {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#defineMacro(String)} or 
     * {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#defineMacro(String,Object)}
     * then the <i>Text</i> is returned, else the following <i>MacroTextPairDec</i>
     * is checked. If the optional <i>Macro</i> prefix is absent the <i>Text</i> is returned
     * <p>
     * The <i>Text</i> string must not contain ":" and ";" characters.
     * <p>
     * Example:
     * <code>WIN32:MSVCRT;Linux:/lib/libc.so.6;MacOSX:/usr/lib/libc.dylib;SunOS:/lib/libc.so.1;OtherLibc</code>
     * <blockquote>The name "MSVCRT" is returned if "WIN32" macro was defined,
     * else "/lib/libc.so.6" if "Linux" macro was defined, 
     * else "/usr/lib/libc.dylib" if "MacOSX" macro was defined, 
     * else "/lib/libc.so.1" if "SunOS" macro was defined,      
     * else "OtherLibc" is returned.
     * </blockquote>      
     *
     * @param textExpr the expression to parse.
     * @return the resolved text.
     */
    public String parseTextWithMacros(String textExpr);    
    
    /**
     * Parses the specified expression prefixed with macros, and return the selected name.  
     * <p>
     * Current implementation calls {@link NativeTypeManager#parseTextWithMacros(String)}
     * and trims the leading and trailing spaces.
     * <p>
     * This utility is very useful when the name used is platform/compiler dependent.
     * <p>
     * Example:
     * <code>WIN32: MSVCRT ;Linux: /lib/libc.so.6 ;MacOSX: /usr/lib/libc.dylib ;SunOS: /lib/libc.so.1 ; OtherLibc</code> 
     * <blockquote>The name "MSVCRT" is returned if "WIN32" macro was defined,
     * else "/lib/libc.so.6" if "Linux" macro was defined, 
     * else "/usr/lib/libc.dylib" if "MacOSX" macro was defined, 
     * else "/lib/libc.so.1" if "SunOS" macro was defined,     
     * else "OtherLibc" is returned.
     * </blockquote> 
     *
     * @param nameExpr the native name expression to parse.
     * @return the resolved name.
     */    
    public String parseNameWithMacros(String nameExpr);    
    
    /** 
     * Returns the size number (an integer) declared in the specified string expression parsed
     * and resolved with the following format:
     * <p>
     * <blockquote><code>
     * <i>SizeDec</i>[;<i>SizeDec</i>[;<i>SizeDec</i> ...]]
     * </code></blockquote>
     * 
     * <i>SizeDec</i> format is:
     * <blockquote><code>
     * [<i>Macro</i>:]<i>SizeExpr</i>
     * </code></blockquote>
     *
     * Where <i>Macro</i> is an optional "selector macro" name, if the macro was defined
     * using {@link NativeTypeManager#defineMacro(String)} or {@link NativeTypeManager#defineMacro(String,Object)}
     * then the <i>SizeExpr</i> is resolved and returned, else the following <i>SizeDec</i>
     * is checked. If the optional <i>Macro</i> prefix is absent the <i>SizeExpr</i> is resolved and used 
     * and no more following <i>SizeExpr</i> are scanned.
     * <p>
     * The <i>SizeExpr</i> has the format:
     * <blockquote><code>
     * <i>Macro</i>|<i>LiteralSize</i>
     * </code></blockquote>
     * 
     * If specified a macro then the macro value (must be defined and an integer) is used,
     * else the literal value is returned.
     * <p>
     * Examples:
     * <ul>
     *  <li>
     *      <code>"8"</code>
     *      <blockquote>The size returned is 8      
     *      </blockquote> 
     *  </li>
     *  <li>
     *      <code>"MSC:4;gcc:8;REGISTER_SIZE"</code>
     *      <blockquote>The size returned is 4 if the "MSC" macro was defined,
     *      else is 8 if the "gcc" macro was defined, else the value of the
     *      "REGISTER_SIZE" macro is used (must be defined with an integer value
     *      or an exception is thrown).   
     *      </blockquote> 
     *  </li>
     * </ul>     
     *
     * @param sizeExpr the expression to parse.
     * @return the size after parsing and resolving the expression.
     * @see #defineMacro(String,Object)
     * @see #decPrimitive(Class,String,String)
     * @see TypeNativePrimitive
     */     
    public long parseMemorySizeWithMacros(String sizeExpr);
    
    
    /**
     * Returns the default native type of the specified value.
     * <p>
     * The <code>value</code> may be a native capable object or
     * a "can be native object". If is not possible get a complete 
     * native type an exception is thrown.
     * <p>
     * For instance:
     * <blockquote><code>
     * NativeTypeManager typeDecMgr = JNIEasy.get().getTypeManager(); 
     * TypeNativeString typeDec = (TypeNativeString)typeDecMgr.getDefaultType("Hello");
     * </code></blockquote>
     * 
     * 
     * @param value the object to get its default native type.
     * @return the default native type.
     */    
    public TypeNative getDefaultType(Object value);    
    
    /**
     *  
     * Declares the native type defined in the specified expression string.
     * <p>
     * An expression string defines how a class that can be native is made native, 
     * specifying the missing native info using a special C-Java mixed syntax.
     * <p>
     * Every class type which can be native has a specific syntax in expressions,
     * see 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativePrimitive},
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeArray}, 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeStringBased}, 
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativeBehavior} and
     * {@link com.innowhere.jnieasy.core.typedec.TypeNativePointer}
     * for specific syntax.
     * <p>
     * Spaces are used as separators when necessary and are ignored (and internally trimmed).
     * <p>
     * The default ClassLoader as returned by {@link #getClassLoader()} 
     * is used to load the referred classes.
     * <p>
     * The <code>importList</code> parameter is a string array of import declarations
     * as explained in {@link #setDefaultImports(String[])} used to resolve
     * class names, if null the default imports are used.
     * <p>
     * Expression examples:
     * <p>
     * <code>"int"</code><p>  
     * <blockquote>Declares the int primitive type as native.</blockquote>
     * 
     * <code>"mypkg.MyStructure[3]"</code><p>  
     * <blockquote>Declares an array of 3 elements of user defined mypkg.MyStructure elements
     * "by value".</blockquote>
     * <p>
     * 
     * @param decExpr the expression string defining the native type.
     * @param importList the included list of classes using Java import syntax. Can be null.
     * @return the native type object of the declaration.
     * @see NativeVarTypeManager#dec(String,String[])
     * @see #getDefaultImports()
     * @see NativeTypeManager#dec(Class)
     * @see TypeNative#getDeclarationString() 
     */
    public TypeNative dec(String decExpr,String[] importList);
    
    /**
     * Declares the native type defined in the specified expression string.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return dec(decExpr,null);
     * </code></blockquote>
     *
     * @param decExpr the expression string defining the native type.
     * @return the native type object of the declaration.
     * @see #dec(String,String[])
     */
    public TypeNative dec(String decExpr);    
    
       
    /**
     * Declares the default native type of the specified class. 
     * <p>
     * The <code>clasz</code> parameter must be a user defined native capable 
     * a native wrapper or a "can be native" class, otherwise an exception is
     * thrown.
     * <p>
     * If the Class is not enough to get a native type declaration throws an
     * exception.
     * 
     * @param clasz the class to declare.
     * @return the native type object of the class.
     * @see NativeVarTypeManager#dec(String,String[])
     */
    public TypeNative dec(Class clasz);   
    
    /** 
     * Declares the primitive native type specified in the Class parameter with
     * the specified memory size.
     * <p>
     * The alignment is set to the specified memory size.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decPrimitive(clasz,size,size);
     * </code></blockquote>
     *
     * @param clasz the primitive class (boolean, int etc).
     * @param size the native memory size.
     * @return the primitive native type.
     */     
    public TypeNativePrimitive decPrimitive(Class clasz,long size);
    
    /** 
     * Declares the primitive native type specified in the Class parameter with
     * the specified memory size and alignment.
     * <p>
     * The specified size and alignment must be valid values according to the 
     * native primitive type, see the setDefaultXSize(long,long) methods, where
     * X is Boolean, Char, Int, etc.
     *
     * @param clasz the primitive class (boolean, int etc).
     * @param size the native memory size.
     * @param alignment the native memory alignment.     
     * @return the primitive native type.
     * @see #decPrimitive(Class,String,String)
     */    
    public TypeNativePrimitive decPrimitive(Class clasz,long size,long alignment);    
    
    /** 
     * Declares the primitive native type specified in the Class parameter with
     * the specified memory size expression.
     * <p>
     * The memory size string expression is resolved using {@link #parseMemorySizeWithMacros(String)}.
     * The alignment is set to the specified memory size.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decPrimitive(clasz,sizeExpr,sizeExpr);
     * </code></blockquote>
     *
     * @param clasz the primitive class (boolean, int etc).
     * @param sizeExpr the native memory size expression.
     * @return the primitive native type.
     * @see #decPrimitive(Class,String,String)
     * @see #decPrimitive(Class,long)
     */     
    public TypeNativePrimitive decPrimitive(Class clasz,String sizeExpr);
    
    /** 
     * Declares the primitive native type specified in the Class parameter with
     * the specified memory size and alignment expressions.
     * <p>
     * The memory size and alignment string expressions are resolved using {@link #parseMemorySizeWithMacros(String)}.
     * <p>
     * The specified size and alignment must be valid values according to the 
     * native primitive type, see the setDefaultXSize(long,long) methods, where
     * X is Boolean, Char, Int, etc, like {@link #setDefaultBooleanSize(long,long)}.
     *
     * @param clasz the primitive class (boolean, int etc).
     * @param sizeExpr the native memory size.
     * @param alignSizeExpr the native memory alignment.     
     * @return the primitive native type.
     * @see #decPrimitive(Class,long,long)
     */
    public TypeNativePrimitive decPrimitive(Class clasz,String sizeExpr,String alignSizeExpr);
    
    
    /**
     * Declares a long native type like a platform dependent address. 
     * <p>
     * In a 32 bit platform the native size will be 4 bytes, on 64 bit
     * will be 8 bytes.
     * <p>
     * This declaration may be used to cross-platform Java native programming.
     * 
     * @return the native type object of the class.
     * @see TypeNativeLong#isAddress()
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getPlatformAddressSize()
     */    
    public TypeNativeLong decAddress();    
    
    /**
     * Declares a string native type with the specified encoding/size
     * using the java.lang.String class or a native wrapper.
     * <p>
     * The <code>clasz</code> parameter can be java.lang.String or
     * {@link com.innowhere.jnieasy.core.data.NativeString} or 
     * {@link com.innowhere.jnieasy.core.data.NativeStringAnsi} or 
     * {@link com.innowhere.jnieasy.core.data.NativeStringUnicode}.
     * <p>
     * The <code>encoding</code> parameter is useful with String and NativeString,
     * use {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#dec(Class)}
     * with {@link com.innowhere.jnieasy.core.data.NativeStringAnsi} and 
     * {@link com.innowhere.jnieasy.core.data.NativeStringUnicode}, because encoding is implicitly 
     * defined.
     * 
     * 
     * @param clasz the java.lang.String class or a wrapper.
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see StringEncoding#ANSI
     * @see StringEncoding#UNICODE
     * @see #decStringBuffer(Class,int)
     */    
    public TypeNativeString decString(Class clasz,int encoding);    

    /**
     * Declares a string native type with the specified encoding expression
     * using the java.lang.String class or a native wrapper.
     * <p>
     * Current implementation parses the encoding expression with 
     * {@link #parseNameWithMacros(String)} and calls
     * {@link #decString(Class,int)}
     * 
     * @param clasz the java.lang.String class or a wrapper.
     * @param encodingExpr the encoding value (a macro based expression).
     * @return the native type object of the declaration.
     */    
    public TypeNativeString decString(Class clasz,String encodingExpr);    
    
    /**
     * Declares a string native type with the specified encoding/size
     * using the java.lang.String class.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decString(String.class,encoding);
     * </code></blockquote>
     *
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see #decString(Class,int)
     */
    public TypeNativeString decString(int encoding);
    
    /**
     * Declares a string native type with the default encoding/size
     * using the java.lang.String class.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decString(getDefaultStringEncoding());
     * </code></blockquote>
     *
     * @return the native type of the declaration.
     * @see #decString(int)
     * @see #getDefaultStringEncoding()
     */    
    public TypeNativeString decString();  
    
    /**
     * Declares a string native type with the ANSI encoding/size
     * using the NativeStringAnsi wrapper class.
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeStringAnsi)dec(NativeStringAnsi.class);
     * </code></blockquote>
     * 
     * 
     * @return the native type of the declaration.
     * @see #dec(Class)
     * @see com.innowhere.jnieasy.core.data.NativeStringAnsi
     */
    public TypeNativeStringAnsi decStringAnsi();    
    
    /**
     * Declares a string native type with the UNICODE encoding/size
     * using the NativeStringUnicode wrapper class.
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeStringUnicode)dec(NativeStringUnicode.class);
     * </code></blockquote>
     * 
     * 
     * 
     * @return the native type of the declaration.
     * @see #dec(Class)
     * @see com.innowhere.jnieasy.core.data.NativeStringUnicode
     */    
    public TypeNativeStringUnicode decStringUnicode();
    
    /**
     * Declares a string native type with the specified encoding/size
     * using the java.lang.StringBuffer class or a native wrapper.
     * <p>
     * The <code>clasz</code> parameter can be java.lang.StringBuffer or
     * {@link com.innowhere.jnieasy.core.data.NativeStringBuffer} or 
     * {@link com.innowhere.jnieasy.core.data.NativeStringBufferAnsi} or 
     * {@link com.innowhere.jnieasy.core.data.NativeStringBufferUnicode}.
     * 
     * The <code>encoding</code> parameter is useful with StringBuffer and NativeStringBuffer,
     * use {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#dec(Class)}
     * with {@link com.innowhere.jnieasy.core.data.NativeStringBufferAnsi} and 
     * {@link com.innowhere.jnieasy.core.data.NativeStringBufferUnicode}, 
     * because encoding is implicitly defined.
     * 
     * 
     * 
     * @param clasz the java.lang.StringBuffer class or a wrapper.
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see StringEncoding#ANSI
     * @see StringEncoding#UNICODE
     * @see #decString(Class,int)
     */    
    public TypeNativeStringBuffer decStringBuffer(Class clasz,int encoding);    
    
    /**
     * Declares a string native type with the specified encoding expression
     * using the java.lang.StringBuffer class or a native wrapper.
     * <p>
     * Current implementation parses the encoding expression with 
     * {@link #parseNameWithMacros(String)} and calls
     * {@link #decStringBuffer(Class,int)}
     * 
     * @param clasz the java.lang.StringBuffer class or a wrapper.
     * @param encodingExpr the encoding value (a macro based expression).
     * @return the native type object of the declaration.
     */    
    public TypeNativeStringBuffer decStringBuffer(Class clasz,String encodingExpr);    
    
    /**
     * Declares a string native type with the specified encoding/size
     * using the java.lang.StringBuffer class.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStringBuffer(StringBuffer.class,encoding);
     * </code></blockquote>
     *
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see #decStringBuffer(Class,int)
     */    
    public TypeNativeStringBuffer decStringBuffer(int encoding);  
    
    /**
     * Declares a string native type with the default encoding/size
     * using the java.lang.StringBuffer class.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStringBuffer(getDefaultStringEncoding());
     * </code></blockquote>
     *
     * @return the native type of the declaration.
     * @see #decStringBuffer(int)
     * @see #getDefaultStringEncoding()
     */       
    public TypeNativeStringBuffer decStringBuffer();    

    /**
     * Declares a string native type with the ANSI encoding/size
     * using the NativeStringBufferAnsi wrapper class.
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeStringBufferAnsi)dec(NativeStringBufferAnsi.class);
     * </code></blockquote>
     * 
     * 
     * @return the native type of the declaration.
     * @see #dec(Class)
     * @see com.innowhere.jnieasy.core.data.NativeStringBufferAnsi
     */
    public TypeNativeStringBufferAnsi decStringBufferAnsi();  
    
    /**
     * Declares a string native type with the UNICODE encoding/size
     * using the NativeStringBufferUnicode wrapper class.
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeStringBufferUnicode)dec(NativeStringBufferUnicode.class);
     * </code></blockquote>
     * 
     * 
     * 
     * @return the native type of the declaration.
     * @see #dec(Class)
     * @see com.innowhere.jnieasy.core.data.NativeStringBufferUnicode
     */    
    public TypeNativeStringBufferUnicode decStringBufferUnicode();    
    
    /**
     * Declares a native array type using the specified array class, dimensions 
     * and array component native info. 
     * <p>
     * The parameter <code>clasz</code> can be a Java array class 
     * like int[] (multidimensional included) or a native array wrapper class like 
     * {@link com.innowhere.jnieasy.core.data.NativeStringArray} or a user
     * defined native array.
     * <p>
     * The number of array dimensions (length of the <code>dims</code>
     * parameter), must be coincident with the number of dimensions 
     * defined in the <code>clasz</code> parameter, otherwise an exception
     * is thrown. A dimension value of -1 is equivalent to undefined length.
     * If <code>dims</code> parameter is null, the length of all dimensions
     * is undefined.
     * <p>
     * The parameter <code>compVarType</code> specifies the native information
     * of the array elements. This native type info must be compatible with the
     * default native type of the element type defined in <code>clasz</code>, 
     * this default native type is overwritten  with <code>compVarType</code>. If
     * this parameter is null, default native info is used.
     * 
     * @param clasz the Java array or native wrapper or a user defined array class.
     * @param dims the lengths of the array dimensions. Can be null.
     * @param compVarType the native info of the array component. Can be null.
     * @return the native array type of the declaration.
     * @see NativeVarTypeManager
     */
    public TypeNativeArray decArray(Class clasz,int[] dims,VarTypeNative compVarType);    
        
    /**
     * Declares a native array type using the specified array class, with  
     * dimensions and array component native info by default. 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decArray(clasz,null,null);
     * </code></blockquote>
     * 
     * 
     * @param clasz the Java array or native wrapper or a user defined array class.
     * @return the native array type of the declaration.
     * @see #decArray(Class,int[],VarTypeNative)
     */    
    public TypeNativeArray decArray(Class clasz);
    
    /**
     * Declares a native array type using the specified array class and  
     * dimensions with default array component native info. 
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decArray(clasz,dims,null);
     * </code></blockquote>
     * 
     * 
     * @param clasz the Java array or native wrapper or a user defined array class.
     * @param dims the lengths of the array dimensions. Can be null.
     * @return the native array type of the declaration.
     * @see #decArray(Class,int[],VarTypeNative)
     */    
    public TypeNativeArray decArray(Class clasz,int[] dims);
    
    /**
     * Declares a one-dimensional native array type using the specified array class
     * and length with default array component native info. 
     * <p>
     * It is a shorthand of the method {@link #decArray(Class,int[])}
     * to one-dimensional arrays. Current implementation is:
     * <blockquote><code>
     * return decArray(clasz,new int[]{length}); 
     * </code></blockquote>
     *
     * @param clasz the Java array or native wrapper or a user defined array class.
     * @param length the length of the array.
     * @return the native array type of the declaration.
     * @see #decArray(Class,int[])
     */    
    public TypeNativeArray decArray(Class clasz,int length);    
    
    /**
     * Declares a native array type using the specified array class and  
     * dimensions and reference conventionalism of the array elements. 
     * <p>
     * The <code>compVarConv</code> overwrites the default conventionalism.
     * 
     * 
     * @param clasz the Java array or native wrapper or a user defined array class.
     * @param dims the lengths of the array dimensions. Can be null.
     * @param compVarConv the reference conventionalism of the array elements.
     * @return the native array type of the declaration.
     * @see #decArray(Class,int[],VarTypeNative)
     * @see VarTypeNative#BY_DEFAULT
     * @see VarTypeNative#BY_PTR
     * @see VarTypeNative#BY_VALUE
     */          
    public TypeNativeArray decArray(Class clasz,int[] dims,int compVarConv);
    
    /**
     * Declares a native array type using the specified native declaration 
     * of the array elements and dimensions. 
     * <p>
     * The parameter <code>compVarType</code> can be any native variable
     * type. Can not be null.
     * <p>
     * The dimensions parameter array <code>dims</code> defines the 
     * number of dimensions and lengths of the declared array. Can not be null.
     * A dimension value of -1 is equivalent to undefined length.
     * <p>
     * 
     * 
     * @param dims the lengths of the array dimensions.
     * @param compVarType the native info of the array elements.
     * @return the native array type of the declaration.
     * @see #decArray(Class,int[],VarTypeNative)
     * @see VarTypeNative#decArray(int[])
     */   
    public TypeNativeArray decArray(int[] dims,VarTypeNative compVarType);
    
    /**
     * Declares a one-dimensional native array type using the specified native declaration 
     * of the array elements and length. 
     * <p>
     * It is a shorthand of the method {@link #decArray(int[],VarTypeNative)}
     * to one-dimensional arrays. Current implementation is:
     * <blockquote><code>
     * return decArray(new int[]{length},compVarType); 
     * </code></blockquote>
     * 
     * 
     * @param length the length of the array.
     * @param compVarType the native info of the array elements.
     * @return the native array type of the declaration.
     * @see #decArray(int[],VarTypeNative)
     * @see VarTypeNative#decArray(int)
     */    
    public TypeNativeArray decArray(int length,VarTypeNative compVarType);   
    
    /**
     * Declares a native array type using the specified class  
     * of the array elements and dimensions. 
     * 
     * Current implementation is:
     * <blockquote><code>
     * return decArray(dims,getVarTypeManager().dec(compClass));
     * </code></blockquote>
     * 
     * 
     * 
     * @param dims the lengths of the array dimensions.
     * @param compClass the class of the array elements.
     * @return the native array type of the declaration.
     * @see #decArray(int[],VarTypeNative)
     */       
    public TypeNativeArray decArray(int[] dims,Class compClass);
    
    /**
     * Declares a one-dimensional native array type using the specified class 
     * of the array elements and length. 
     * <p>
     * It is a shorthand of the method {@link #decArray(int[],Class)}
     * to one-dimensional arrays. Current implementation is:
     * <blockquote><code>
     * return decArray(new int[]{length},compClass); 
     * </code></blockquote>
     * 
     * 
     * @param length the length of the array.
     * @param compClass the class of the array elements.
     * @return the native array type of the declaration.
     * @see #decArray(int[],VarTypeNative)
     */
    public TypeNativeArray decArray(int length,Class compClass);   
    
    /**
     * Declares a native array type of strings with the specified encoding/size
     * using a java.lang.String array class or a native wrapper or a user defined
     * multidimensional array of String.
     * <p>
     * The <code>clasz</code> parameter can be a Java array of java.lang.String 
     * (multidimensional included as String[][]) or
     * {@link com.innowhere.jnieasy.core.data.NativeStringArray} or 
     * {@link com.innowhere.jnieasy.core.data.NativeStringAnsiArray} or 
     * {@link com.innowhere.jnieasy.core.data.NativeStringUnicodeArray} or a
     * user defined multidimensional array class of String.
     * <p>
     * The <code>dims</code> follows the same rules as explained in
     * {@link #decArray(Class,int[],VarTypeNative)}
     * <p>
     * The <code>encoding</code> parameter is useful with classes with no implicit
     * encoding like String or NativeStringArray. 
     * Use {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#decArray(Class,int[])}
     * with NativeStringAnsiArray and NativeStringUnicodeArray, 
     * because encoding is implicitly defined.
     * 
     * @param clasz a java.lang.String based array class.
     * @param dims the lengths of the array dimensions. Can be null.
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see #decString(Class,int)
     */
    public TypeNativeArray decStringArray(Class clasz,int[] dims,int encoding);
    
    /**
     * Declares a native array type of strings with the specified encoding/size
     * using a java.lang.String array class or a native wrapper or a user defined
     * multidimensional array of String.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStringArray(clasz,null,encoding);
     * </code></blockquote>
     *
     * @param clasz a java.lang.String based array class.
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see #decStringArray(Class,int[],int)
     */   
    public TypeNativeArray decStringArray(Class clasz,int encoding);    
    
    /**
     * Declares a native array type of strings with the specified encoding/size
     * using the java.lang.String[] class.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStringArray(String[].class,encoding);
     * </code></blockquote>
     *
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see #decString(Class,int)
     */    
    public TypeNativeArray decStringArray(int encoding);
    
    /**
     * Declares a native array type of strings with the ANSI encoding/size
     * using the NativeStringAnsiArray wrapper class.
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return decArray(NativeStringAnsiArray.class);
     * </code></blockquote>
     *
     * @return the native type of the declaration.
     * @see #decArray(Class)
     * @see com.innowhere.jnieasy.core.data.NativeStringAnsiArray
     */    
    public TypeNativeArray decStringAnsiArray(); 
    
    /**
     * Declares a native array type of strings with the ANSI encoding/size
     * using the NativeStringUnicodeArray wrapper class.
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return decArray(NativeStringUnicodeArray.class);
     * </code></blockquote>
     *
     * @return the native type of the declaration.
     * @see #decArray(Class)
     * @see com.innowhere.jnieasy.core.data.NativeStringUnicodeArray
     */    
    public TypeNativeArray decStringUnicodeArray();    
  
    /**
     * Declares a native array type of strings with the specified encoding/size
     * using a java.lang.StringBuffer array class or a native wrapper or a user defined
     * multidimensional array of StringBuffer.
     * <p>
     * The <code>clasz</code> parameter can be a Java array of java.lang.StringBuffer 
     * (multidimensional included as StringBuffer[][]) or
     * {@link com.innowhere.jnieasy.core.data.NativeStringBufferArray} or 
     * {@link com.innowhere.jnieasy.core.data.NativeStringBufferAnsiArray} or 
     * {@link com.innowhere.jnieasy.core.data.NativeStringBufferUnicodeArray} or a
     * user defined multidimensional array class of StringBuffer.
     * <p>
     * The <code>dims</code> parameter follows the same rules as explained in
     * {@link #decArray(Class,int[],VarTypeNative)}
     * <p>
     * The <code>encoding</code> parameter is useful with classes with no implicit
     * encoding like StringBuffer or NativeStringBufferArray. 
     * Use {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#decArray(Class,int[])}
     * with NativeStringBufferAnsiArray and NativeStringBufferUnicodeArray, because encoding is implicitly 
     * defined.
     * 
     * 
     * 
     * 
     * @param clasz a java.lang.StringBuffer based array class.
     * @param dims the lengths of the array dimensions. Can be null.
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see #decStringBuffer(Class,int)
     */    
    public TypeNativeArray decStringBufferArray(Class clasz,int[] dims,int encoding);
    
    /**
     * Declares a native array type of strings with the specified encoding/size
     * using a java.lang.StringBuffer array class or a native wrapper or a user defined
     * multidimensional array of StringBuffer.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStringBufferArray(clasz,null,encoding);
     * </code></blockquote>
     *
     * @param clasz a java.lang.StringBuffer based array class.
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see #decStringBufferArray(Class,int[],int)
     */
    public TypeNativeArray decStringBufferArray(Class clasz,int encoding);  
    
    /**
     * Declares a native array type of strings with the specified encoding/size
     * using the java.lang.StringBuffer[] class.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return decStringBufferArray(StringBuffer[].class,encoding);
     * </code></blockquote>
     *
     * @param encoding the character encoding/size.
     * @return the native type object of the declaration.
     * @see #decStringBuffer(Class,int)
     */       
    public TypeNativeArray decStringBufferArray(int encoding); 
    
    /**
     * Declares a native array type of strings with the ANSI encoding/size
     * using the NativeStringBufferAnsiArray wrapper class.
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return decArray(NativeStringBufferAnsiArray.class);
     * </code></blockquote>
     *
     * @return the native type of the declaration.
     * @see #decArray(Class)
     * @see com.innowhere.jnieasy.core.data.NativeStringBufferAnsiArray
     */       
    public TypeNativeArray decStringBufferAnsiArray();
    
    /**
     * Declares a native array type of strings with the ANSI encoding/size
     * using the NativeStringBufferUnicodeArray wrapper class.
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return decArray(NativeStringBufferUnicodeArray.class);
     * </code></blockquote>
     *
     * @return the native type of the declaration.
     * @see #decArray(Class)
     * @see com.innowhere.jnieasy.core.data.NativeStringBufferUnicodeArray
     */       
    public TypeNativeArray decStringBufferUnicodeArray();
    
    /**
     * Declares a native behavior type using the specified 
     * native behavior class and signature.
     * <p>
     * The parameter <code>methodClass</code> can be any of the following
     * classes/interfaces:
     * <ul>
     *  <li>Callbacks based on reflection classes
     *      <ul>
     *          <li>java.lang.reflect.Constructor
     *          <li>java.lang.reflect.Method
     *          <li>java.lang.reflect.Field
     *      </ul>
     *  </li>
     *  <li>Callbacks based on native wrappers of reflection classes
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeConstructorReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeFieldMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldMethodReflection}
     *      </ul>  
     *  </li>
     *  <li>Native wrappers of DLL methods
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.CPPConstructor}
     *          <li>{@link com.innowhere.jnieasy.core.method.CMethod}
     *          <li>{@link com.innowhere.jnieasy.core.method.CPPMethod}
     *          <li>{@link com.innowhere.jnieasy.core.method.CFieldMethod}
     *      </ul>  
     *  </li> 
     *  <li>Native direct callback interfaces (user defined classes are valid too)
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectStaticMethodCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectInstanceMethodCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectInstanceFieldCallback}
     *      </ul>
     *  </li>
     *  <li>Generic interfaces of method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeConstructor}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethod}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethod}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldMethod}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldMethod}
     *      </ul>
     *  </li>
     *  <li>Generic callback interfaces of callback based method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeConstructorCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethodCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethodCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldCallback}
     *      </ul>
     *  </li>
     * </ul>
     * <p>
     * The native signature object type specified with <code>signature</code> must match with
     * the specified method class, otherwise an exception is thrown. 
     * For instance, a NativeConstructorSignature object
     * is expected if <code>methodClass</code> is: 
     * Constructor, {@link com.innowhere.jnieasy.core.method.NativeConstructorReflection},
     * {@link com.innowhere.jnieasy.core.method.CPPConstructor}, 
     * {@link com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback}, 
     * a user defined 
     * {@link com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback} class, 
     * {@link com.innowhere.jnieasy.core.method.NativeConstructor} and 
     * {@link com.innowhere.jnieasy.core.method.NativeConstructorCallback}.
     * <p>
     * If a user defined class implementing {@link com.innowhere.jnieasy.core.method.NativeDirectCallback} 
     * is used, the specified signature is used instead the default signature 
     * declared with the class. This class can be used with 
     * {@link #dec(Class)}, in this case the default declared signature is used.
     * 
     * 
     * @param methodClass the behavior class or interface to use.
     * @param signature the native signature of the behavior.
     * @return the native type of the declaration.
     * @see NativeBehaviorSignature#decBehavior(Class methodClass)
     */
    public TypeNativeBehavior decBehavior(Class methodClass,NativeBehaviorSignature signature);
    
    /**
     * Declares a constructor native type using the specified 
     * native constructor class and signature.
     * <p>
     * The parameter <code>methodClass</code> can be any of the following
     * classes/interfaces:
     * <ul>
     *  <li>Callbacks based on reflection classes
     *      <ul>
     *          <li>java.lang.reflect.Constructor
     *      </ul>
     *  </li>
     *  <li>Callbacks based on native wrappers of reflection classes
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeConstructorReflection}
     *      </ul>  
     *  </li>
     *  <li>Native wrappers of DLL methods
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.CPPConstructor}
     *      </ul>  
     *  </li> 
     *  <li>Native direct callback interfaces (user defined classes are valid too)
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback}
     *      </ul>
     *  </li>
     *  <li>Generic interfaces of method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeConstructor}
     *      </ul>
     *  </li>
     *  <li>Generic callback interfaces of callback based method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeConstructorCallback}
     *      </ul>
     *  </li>
     * </ul> 
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeConstructor)decBehavior(methodClass,signature);
     * </code></blockquote>
     * 
     * 
     * @param methodClass the native constructor class or interface to use.
     * @param signature the native signature of the behavior.
     * @return the native type of the declaration.
     * @see #decBehavior(Class,NativeBehaviorSignature)
     * @see NativeConstructorSignature#decConstructor(Class methodClass)
     */     
    public TypeNativeConstructor decConstructor(Class methodClass,NativeConstructorSignature signature);    
    
    /**
     * Declares a method native type using the specified 
     * native method class and signature.
     * <p>
     * The parameter <code>methodClass</code> can be any of the following
     * classes/interfaces:
     * <ul>
     *  <li>Callbacks based on reflection classes
     *      <ul>
     *          <li>java.lang.reflect.Method
     *      </ul>
     *  </li>
     *  <li>Callbacks based on native wrappers of reflection classes
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethodReflection}
     *      </ul>  
     *  </li>
     *  <li>Native wrappers of DLL methods
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.CMethod}
     *          <li>{@link com.innowhere.jnieasy.core.method.CPPMethod}
     *      </ul>  
     *  </li> 
     *  <li>Native direct callback interfaces (user defined classes are valid too)
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectStaticMethodCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectInstanceMethodCallback}
     *      </ul>
     *  </li>
     *  <li>Generic interfaces of method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethod}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethod}
     *      </ul>
     *  </li>
     *  <li>Generic callback interfaces of callback based method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethodCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethodCallback}
     *      </ul>
     *  </li>
     * </ul>
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeMethod)decBehavior(methodClass,signature);
     * </code></blockquote>
     * 
     * 
     * @param methodClass the native method class or interface to use.
     * @param signature the native signature of the behavior.
     * @return the native type of the declaration.
     * @see #decBehavior(Class,NativeBehaviorSignature)
     * @see NativeMethodSignature#decMethod(Class methodClass)
     */  
    public TypeNativeMethod decMethod(Class methodClass,NativeMethodSignature signature);
    
    /**
     * Declares a method native type using the specified 
     * static native method class and signature.
     * <p>
     * The parameter <code>methodClass</code> can be any of the following
     * classes/interfaces:
     * <ul>
     *  <li>Callbacks based on reflection classes
     *      <ul>
     *          <li>java.lang.reflect.Method
     *      </ul>
     *  </li>
     *  <li>Callbacks based on native wrappers of reflection classes
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethodReflection}
     *      </ul>  
     *  </li>
     *  <li>Native wrappers of DLL methods
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.CMethod}
     *      </ul>  
     *  </li> 
     *  <li>Native direct callback interfaces (user defined classes are valid too)
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectStaticMethodCallback}
     *      </ul>
     *  </li>
     *  <li>Generic interfaces of method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethod}
     *      </ul>
     *  </li>
     *  <li>Generic callback interfaces of callback based method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticMethodCallback}
     *      </ul>
     *  </li>
     * </ul>
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeStaticMethod)decBehavior(methodClass,signature);
     * </code></blockquote>
     *
     * @param methodClass the native method class or interface to use.
     * @param signature the native signature of the behavior.
     * @return the native type of the declaration.
     * @see #decBehavior(Class,NativeBehaviorSignature)
     * @see NativeStaticMethodSignature#decStaticMethod(Class methodClass)
     */    
    public TypeNativeStaticMethod decStaticMethod(Class methodClass,NativeStaticMethodSignature signature);
    
    /**
     * Declares a native method type using the specified 
     * native instance method class and signature.
     * <p>
     * The parameter <code>methodClass</code> can be any of the following
     * classes/interfaces:
     * <ul>
     *  <li>Callbacks based on reflection classes
     *      <ul>
     *          <li>java.lang.reflect.Method
     *      </ul>
     *  </li>
     *  <li>Callbacks based on native wrappers of reflection classes
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethodReflection}
     *      </ul>  
     *  </li>
     *  <li>Native wrappers of DLL methods
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.CPPMethod}
     *      </ul>  
     *  </li> 
     *  <li>Native direct callback interfaces (user defined classes are valid too)
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectInstanceMethodCallback}
     *      </ul>
     *  </li>
     *  <li>Generic interfaces of method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethod}
     *      </ul>
     *  </li>
     *  <li>Generic callback interfaces of callback based method wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceMethodCallback}
     *      </ul>
     *  </li>
     * </ul>
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeInstanceMethod)decBehavior(methodClass,signature);
     * </code></blockquote>
     * 
     * @param methodClass the native method class or interface to use.
     * @param signature the native signature of the behavior.
     * @return the native type of the declaration.
     * @see #decBehavior(Class,NativeBehaviorSignature)
     * @see NativeInstanceMethodSignature#decInstanceMethod(Class methodClass)
     */   
    public TypeNativeInstanceMethod decInstanceMethod(Class methodClass,NativeInstanceMethodSignature signature);
    
    /**
     * Declares a native field-method type using the specified 
     * native field class and signature.
     * <p>
     * The parameter <code>fieldClass</code> can be any of the following
     * classes/interfaces:
     * <ul>
     *  <li>Callbacks based on reflection classes
     *      <ul>
     *          <li>java.lang.reflect.Field
     *      </ul>
     *  </li>
     *  <li>Callbacks based on native wrappers of reflection classes
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeFieldMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldMethodReflection}
     *      </ul>  
     *  </li>
     *  <li>Native wrappers of DLL methods
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.CFieldMethod}
     *      </ul>  
     *  </li>
     *  <li>Native direct callback interfaces (user defined classes are valid too)
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectInstanceFieldCallback}
     *      </ul>
     *  </li>
     *  <li>Generic interfaces of field wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldMethod}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldMethod}
     *      </ul>
     *  </li>
     *  <li>Generic callback interfaces of callback based field wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldCallback}
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldCallback}
     *      </ul>
     *  </li>
     * </ul>
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeFieldMethod)decBehavior(fieldClass,signature);
     * </code></blockquote>
     * 
     * @param fieldClass the native field class or interface to use.
     * @param signature the native signature of the field.
     * @return the native type of the declaration.
     * @see #decBehavior(Class,NativeBehaviorSignature)
     * @see NativeFieldMethodSignature#decFieldMethod(Class fieldClass)
     */    
    public TypeNativeFieldMethod decFieldMethod(Class fieldClass,NativeFieldMethodSignature signature);
    
    /**
     * Declares a native field-method using the specified 
     * static native field class and signature.
     * <p>
     * The parameter <code>fieldClass</code> can be any of the following
     * classes/interfaces:
     * <ul>
     *  <li>Callbacks based on reflection classes
     *      <ul>
     *          <li>java.lang.reflect.Field
     *      </ul>
     *  </li>
     *  <li>Callbacks based on native wrappers of reflection classes
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection}
     *      </ul>  
     *  </li>
     *  <li>Native wrappers of DLL methods
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.CFieldMethod}
     *      </ul>  
     *  </li>
     *  <li>Native direct callback interfaces (user defined classes are valid too)
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback}
     *      </ul>
     *  </li>
     *  <li>Generic interfaces of field wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldMethod}
     *      </ul>
     *  </li>
     *  <li>Generic callback interfaces of callback based field wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeStaticFieldCallback}
     *      </ul>
     *  </li>
     * </ul>
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeStaticFieldMethod)decBehavior(fieldClass,signature);
     * </code></blockquote>
     * 
     * @param fieldClass the native field class or interface to use.
     * @param signature the native signature of the field.
     * @return the native type of the declaration.
     * @see #decBehavior(Class,NativeBehaviorSignature)
     * @see NativeStaticFieldMethodSignature#decStaticFieldMethod(Class fieldClass)
     */ 
    public TypeNativeStaticFieldMethod decStaticFieldMethod(Class fieldClass,NativeStaticFieldMethodSignature signature);
    
    /**
     * Declares a native field-method type using the specified 
     * native instance field class and signature.
     * <p>
     * The parameter <code>fieldClass</code> can be any of the following
     * classes/interfaces:
     * <ul>
     *  <li>Callbacks based on reflection classes
     *      <ul>
     *          <li>java.lang.reflect.Field
     *      </ul>
     *  </li>
     *  <li>Callbacks based on native wrappers of reflection classes
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldMethodReflection}
     *      </ul>  
     *  </li>
     *  <li>Native wrappers of DLL methods
     *      <ul>
     *          <li>None
     *      </ul>  
     *  </li>
     *  <li>Native direct callback interfaces (user defined classes are valid too)
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeDirectInstanceFieldCallback}
     *      </ul>
     *  </li>
     *  <li>Generic interfaces of field wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldMethod}
     *      </ul>
     *  </li>
     *  <li>Generic callback interfaces of callback based field wrappers
     *      <ul>
     *          <li>{@link com.innowhere.jnieasy.core.method.NativeInstanceFieldCallback}
     *      </ul>
     *  </li>
     * </ul>
     * <p>     
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativeInstanceFieldMethod)decBehavior(fieldClass,signature);
     * </code></blockquote>
     * 
     * 
     * 
     * @param fieldClass the native contructor class or interface to use.
     * @param signature the native signature of the field.
     * @return the native type of the declaration.
     * @see #decBehavior(Class,NativeBehaviorSignature)
     * @see NativeStaticFieldMethodSignature#decStaticFieldMethod(Class fieldClass)
     */   
    public TypeNativeInstanceFieldMethod decInstanceFieldMethod(Class fieldClass,NativeInstanceFieldMethodSignature signature);
    
    /**
     * Declares a native pointer type wrapping the specified 
     * declaration of the pointer member.
     * <p>    
     * The <code>pointerDec</code> must be declared "by pointer".
     * <p>
     * If specified class is user defined, the pointer declaration
     * overwrites the default declaration.
     * 
     * 
     * @param clasz container class.
     * @param pointerDec the native pointer type to wrap.
     * @return the native type of the declaration.
     * @see VarTypeNative#decPointer()
     * @see com.innowhere.jnieasy.core.data.NativePointer
     */
    public TypeNativePointer decPointer(Class clasz,VarTypeNative pointerDec);    
    
    /**
     * Declares a native pointer type wrapping the specified 
     * declaration of the pointer member.
     * <p>    
     * Current implementation is:
     * <blockquote><code>
     * return (TypeNativePointer)decPointer(NativePointer.class,pointerDec);
     * </code></blockquote>
     * 
     * @param pointerDec the native pointer type to wrap.
     * @return the native type of the declaration.
     * @see VarTypeNative#decPointer()
     * @see com.innowhere.jnieasy.core.data.NativePointer
     */
    public TypeNativePointer decPointer(VarTypeNative pointerDec);
    
}
