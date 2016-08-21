/*
 * JNIEasy.java
 *
 * Created on 23 de diciembre de 2003, 22:03
 */

package com.innowhere.jnieasy.core;

import com.innowhere.jnieasy.core.cgen.NativeJavaCodeGenerator;
import com.innowhere.jnieasy.core.enh.NativeEnhancer;
import com.innowhere.jnieasy.core.util.NativeCapableFactory;
import com.innowhere.jnieasy.core.mem.DLLManager;
import com.innowhere.jnieasy.core.mem.JNIEasyLibrary;
import com.innowhere.jnieasy.core.mem.LockedRegistry;
import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;

/**
 * <code>JNIEasy</code> is the core class of the framework and the starting point
 * to get the different managers of the framework.
 * <p>
 * JNIEasy class is abstract, the method {@link JNIEasy#get()} returns the singleton object of 
 * the internal implementation.
 *
 * @author  Jose M. Arranz Santamaria
 */

public abstract class JNIEasy
{
    private static JNIEasyImpl SINGLETON = new JNIEasyImpl();

    protected JNIEasy()
    {
    }
    
    /**
     * Returns the singleton object of the internal implementation.
     * 
     * @return the singleton implementation object
     */
    public static JNIEasy get()
    {
        return SINGLETON;
    }

    /**
     * Informs whether the specified feature was defined.
     * 
     * @param name feature name to look for
     * @return true if the specified feature was defined.
     */
    public static boolean hasFeature(String name)
    {
        return SINGLETON.hasFeature(name);
    }        
    
    /**
     * Returns the feature value of the specified feature name.
     *
     * @param name feature name to look for   
     * @return the feature value. Null if the specified feature was not defined.
     */    
    public static Object getFeature(String name)
    {
        return SINGLETON.getFeature(name);
    }    
    
    /**
     * Defines the feature name and value.
     *
     * <p>Current implementation only recognizes:</p>
     *
     * <ul>
     * <li><code>"jnieasy.license.dir"</code> : 
     * This feature registers the specified directory path where JNIEasy will try to load the license file
     * (JNIEasy.lic) and overwrites any other form of specifying this property.
     * <br />
     * </li>
     * 
     * <li><code>"java.library.path"</code> : 
     * Tell JNIEasy to ignore System.getProperty("java.library.path") to get the 
     * paths used to search and load native libraries on runtime.
       This property is used only by JNIEasy and doesn't change the system property.
     * Use the same format used to define the <code>-Djava.library.path</code> property on command line
     * (<code>File.pathSeparator</code> may be useful).
     * </li>
     * </ul>
     * 
     * @param name feature name to register
     * @param value feature value to register     
     */    
    public static void setFeature(String name,Object value)
    {
        SINGLETON.setFeature(name,value);
    }           
    
    /**
     * Returns the current version of the framework using an array of 4 integers:
     * element with index 0 is the main version and following elements (1,2,3) are 
     * minor versions.
     *
     * @return the current version
     */    
    public abstract int[] getVersion();    
    
    /**
     * Loads the framework. Loading is necessary before executing native operations.
     */
    public abstract void load();
    
    /**
     * Returns <code>true</code> if the framework is loaded.
     *
     * @return true if the framework is loaded.
     * @see JNIEasy#load()
     */
    public abstract boolean isLoaded();
    
    /**
     * Returns the utility object to declare native types.
     * 
     * @return the <code>NativeTypeManager</code> object.
     * @see NativeTypeManager
     */
    public abstract NativeTypeManager getTypeManager();
    
    /**
     * Returns the utility object to declare native variable types.
     * 
     * @return the <code>NativeVarTypeManager</code> object.
     */    
    public abstract NativeVarTypeManager getVarTypeManager(); 
    
    /**
     * Returns the utility object to declare native signatures of methods.
     * 
     * @return the <code>NativeSignatureManager</code> object.
     */     
    public abstract NativeSignatureManager getSignatureManager();
    
    /**
     * Returns the utility object to create native objects.
     *
     * @return the <code>NativeCapableFactory</code> object.
     */    
    public abstract NativeCapableFactory getNativeCapableFactory();
 
    /**
     * Returns the utility object to control the native lifecycle of native capable
     * objects.
     * 
     * @return the <code>NativeManager</code> object.
     */    
    public abstract NativeManager getNativeManager();
    
    /**
     * Returns the utility object to manage dynamic link libraries.
     * 
     * @return the <code>DLLManager</code> object.
     */    
    public abstract DLLManager getDLLManager();
    
    /**
     * Returns the utility object to manage the JNIEasy dynamic link library.
     * 
     * @return the <code>JNIEasyLibrary</code> object.
     */      
    public abstract JNIEasyLibrary getJNIEasyLib();
    
    /**
     * Returns the utility object to enhance classes.
     * 
     * 
     * @return the <code>NativeEnhancer</code> object.
     */    
    public abstract NativeEnhancer getEnhancer();
    
    /**
     * Returns the utility object to generate the code of native classes.
     * 
     * 
     * 
     * @return the <code>NativeJavaCodeGenerator</code> object.
     */        
    public abstract NativeJavaCodeGenerator getJavaCodeGenerator();
    
    /**
     * Returns the utility object to manage the locks of native objects.
     * 
     * @return the <code>LockedRegistry</code> object.
     */    
    public abstract LockedRegistry getLockedRegistry();    

}
