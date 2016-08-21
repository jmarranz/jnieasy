/*
 * DLLManager.java
 *
 * Created on 26 de febrero de 2004, 13:15
 */

package com.innowhere.jnieasy.core.mem;

/**
 * The <code>NativeManager</code> interface is used to manage 
 * the Dynamic Link Libraries loaded by the framework.
 *
 * @author Jose M. Arranz Santamaria
 * @see com.innowhere.jnieasy.core.JNIEasy#getDLLManager()
 */
public interface DLLManager
{
    /**
     * Returns the DLL registered with the specified name or null if it
     * is not found.
     * <p>
     * Search is case sensitive and must match the used name to
     * loading the DLL.
     *
     * @param name used name/path to search.
     * @return the DynamicLibrary object or null if not found.
     * @see #get(String)
     * @see #find(long)
     */
    public DynamicLibrary find(String name);
        
    /**
     * Returns the DLL registered with the specified platform handle or null if it
     * is not found.
     * <p>
     *
     * @param handle DLL´s handle to search.
     * @return the DynamicLibrary object or null if not found.
     * @see #get(String)
     * @see #find(String)
     */    
    public DynamicLibrary find(long handle);
    
    /**
     * Returns the DLL registered with the specified name/path (exactly, 
     * name is case sensitive), 
     * if it is not found tries to load the library from filesystem
     * using the specified name/path.
     * <p>
     * The library name can optionally follow the rules of System.loadLibrary(String):
     * a DLL file name without extension (.dll, .so or .dylib) and "lib" prefix (Linux/Mac/Solaris)
     * or can be a normal path. 
     * </p>
     * The loaded dynamic library is registered with the specified name.
     * <p>
     * The uniqueness of the DLL handle ensures only one DynamicLibrary instance
     * is created per DLL but with multiple name registries.
     * <p>
     * If there is no DLL with this name/path an exception is thrown.
     * <p>
     * The specified name can be a native name expression as explained in
     * {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#parseTextWithMacros(String)}, this method is internally called to get
     * the name of the library to load.  
     *
     * @param name used name/path to search.
     * @return the DynamicLibrary object found or loaded.
     * @see #find(String)
     */    
    public DynamicLibrary get(String name);  

}
