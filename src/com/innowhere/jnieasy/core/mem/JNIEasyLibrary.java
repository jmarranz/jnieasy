/*
 * JNIEasyLibrary.java
 *
 * Created on 1 de octubre de 2004, 13:51
 */

package com.innowhere.jnieasy.core.mem;
import com.innowhere.jnieasy.core.method.*;
import java.util.*;

/**
 * The <code>JNIEasyLibrary</code> interface represents 
 * the framework's Dynamic Link Library (JNIEasy.dll).
 * <p>
 * Using this interface, DLL's exported native methods and fields are 
 * accessible to the Java world using internal framework classes
 * and public using specific interfaces. 
 *
 * @author Jose M. Arranz Santamaria
 * @see DLLManager
 */
public interface JNIEasyLibrary extends DynamicLibrary
{
 
    /**
     * Exports a native capable method instance with the specified name. 
     * <p>
     * The instance is made first native (if already native does nothing) 
     * and registered in the DLL with the specified name. A native program
     * (C or C++) can find this method using the JNIEasy.dll's exported
     * method <code>findExportedMethodAddress</code> using as signature 
     * the returned String of the call:
     * <blockquote><code>
     *  method.getBehaviorSignature().getSignatureString(nativeName)
     * </code></blockquote>
     * 
     *
     * @param nativeName the exported name of the method in the DLL, can be a macro based expression.
     * @param method the native method instance to export.
     * @return a native proxy instance of the DLL method.
     * @see #findExportedMethodAddress(String)
     */    
    public boolean exportBehavior(String nativeName,NativeBehavior method);        
    
    /**
     * Returns the native method instance registered with the specified signature.
     * <p>
     * The method is very similar to {@link #findBehaviorBySignature(String)},
     * with two differences:
     * <ol>
     *  <li>The <code>signature</code> parameter admits an optional DLL name prefix:
     *      <blockquote><code>
     *      [<i>DLLName</i>:]<i>signature</i>
     *      </code></blockquote>
     *      <i>DLLName</i> is an optional DLL name, as used in 
     *      {@link DLLManager#get(String)}, to search the method, if missing
     *      the DLL to search is the framework´s DLL.
     *      <i>signature</i> is the method signature to search calling
     *      {@link #findBehaviorBySignature(String)} on the selected DLL.
     *  </li>
     *  <li>This method is the "Java view" of the JNIEasy.dll's exported method
     *      <blockquote><code> 
     *      void* __stdcall findExportedMethodAddress(const char* signature);
     *      </code></blockquote>
     *      with the exported name "findExportedMethodAddress".<p>
     *      The C version returns the address of the returned native method or <code>NULL</code>
     *      if no method is found.
     *  </li>
     * </ol>
     *
     * @param signature the signature string of the native method to search.
     * @return the registered native method instance in the selected DLL or null if not found.
     */
    public NativeBehavior findExportedMethodAddress(String signature);
    
    /**
     * Exports all methods and fields (as methods) of a class using the default native
     * declarations.
     * <p>
     * It is a shortcut especially useful to export all methods and fields of a class (and optionally 
     * superclasses) using primitive or String types mainly.
     *
     * @param cls the class to export.
     * @param callConv the call convention.
     * @param useReflection if true BehaviorReflection objects are used, else NativeDirectCallback objects are used.
     * @param upperClasses if true export the superclasses.
     * @param skipNotValid if true avoids methods and fields with non-native capable types without throwing exceptions.
     * @return the method/name indexed collection of native method instances exported.
     * @see #unexportClassBehaviorsByDefault(Class,boolean)
     */
    public Map exportClassBehaviorsByDefault(Class cls, int callConv,boolean useReflection,boolean upperClasses,boolean skipNotValid);
    
    /**
     * Un exports all methods and fields (as methods) of a class using the default native
     * declarations.
     * <p>
     * It is the symmetric method of {@link #exportClassBehaviorsByDefault(Class,int,boolean,boolean,boolean)}.
     *
     * @param cls the class to export.
     * @param upperClasses if true export the superclasses.
     * @return the method/name indexed collection of native method instances removed.
     */    
    public Map unexportClassBehaviorsByDefault(Class cls,boolean upperClasses);        
}
